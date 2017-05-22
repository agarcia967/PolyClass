package com.zalgebar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @(#)FileTokenizer.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/02/09
 * @lastModified 2017/02/22
 */
public class FileTokenizer
{
  public static PrintStream LOGGER = System.out;
  public static boolean LOGALL = false;
  public static boolean LOGCATEG = false;
  public static boolean LOGAPPEND = false;
  public static boolean LOGLINES = false;
  public static String keyboardStyle = "Standard US QWERTY keyboard",
      letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", numbers = "0123456789",
      floatChars = "." + numbers, startFloatChars = "-" + floatChars, startVarChars = "_" + letters,
      varChars = startVarChars + numbers, symbols = "~!@#$%^&*()_+`-={}|[]\\:\";'<>?,./", whitespaces = " \t",
      scopeOpeners = "{([\"'<", scopeClosers = "})]\"'>";
  private Scanner scan;
  private FileInputStream fis;
  private LinkedList<String> tokens;
  private ListIterator<String> tokenItr;
  private LinkedList<Integer> tokenLine;
  private LinkedList<Integer> tokenIndents;
  private Integer currentLine;
  private Integer currentIndents;
  private long numLines;
  private static Stack<String> stack;

  /**
   * Constructs a FileTokenizer object.
   */
  public FileTokenizer()
  {
    this.tokens = new LinkedList<String>();
  }

  /**
   * Constructs a FileTokenizer and immediately tokenizes the file into a
   * LinkedList stored in this object.
   * 
   * @param filePath path to the file to be tokenized
   * @throws FileNotFoundException if file not found
   * @throws IOException if file could not be read
   */
  public FileTokenizer(String filePath) throws FileNotFoundException, IOException
  {
    this.tokenizeFile(filePath);
  }

  /**
   * Tokenizes the file into a LinkedList stored in this object.
   * 
   * @param filePath path to the file to be tokenized
   * @throws FileNotFoundException if file not found
   * @throws IOException if file could not be read
   */
  public void tokenizeFile(String filePath) throws FileNotFoundException, IOException
  {
    this.tokens = new LinkedList<String>();

    LOGGER.printf("%-1s | %s", "", ("Opening file '" + filePath + "'\n"));
    this.fis = new FileInputStream(filePath);
    this.scan = new Scanner(fis);
    String myLine = "";
    StringBuilder sb = new StringBuilder();
    this.tokenLine = new LinkedList<Integer>();
    this.currentLine = 0;
    this.tokenIndents = new LinkedList<Integer>();
    this.currentIndents = 0;
    // Read file
    while (this.scan.hasNextLine())
    {
      myLine = this.scan.nextLine();
      ++this.currentLine;
      // TODO Check Number of Indents for this line
      this.currentIndents = numLineIndents(myLine);
      myLine = myLine.trim();

      if (LOGLINES || LOGALL)
        LOGGER.printf("%-1s | Line %4d : '%s'\n", "", (++this.numLines), (myLine));
      for (int i = 0; i < myLine.length(); i++)
      {
        String myChar = "" + myLine.charAt(i);

        // BEGIN Token Processing
        if (sb.length() == 0)
        {
          sb.append(myChar);
          if (LOGCATEG || LOGALL)
            LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Added to SB\n");
        }
        else if (isWhitespace("" + sb.charAt(0)))
        {
          if (LOGCATEG || LOGALL)
            LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Whitespace\n");
          sb = startNewSB(sb, myChar);
        }
        else if (isStartVarChar("" + sb.charAt(0)))
        {
          if (isVarChar(myChar))
          {// check if valid variable character
            if (LOGCATEG || LOGALL)
              LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Is Variable Character\n");
            sb.append(myChar);// if so, append to StringBuilder
          }
          else
          {
            if (LOGCATEG || LOGALL)
              LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Invalid Variable Character\n");
            sb = startNewSB(sb, myChar);// otherwise start a new
            // StringBuilder
          }
        }
        else if (isStartFloatChar("" + sb.charAt(0)))
        {
          if (isFloatChar(myChar))
          {// check if valid number character
            if (LOGCATEG || LOGALL)
              LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Is Float Character\n");
            sb.append(myChar);// if so, append to StringBuilder
          }
          else
          {
            if (LOGCATEG || LOGALL)
              LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Invalid Float Character\n");
            sb = startNewSB(sb, myChar);// otherwise start a new
            // StringBuilder
          }
        }
        else if (isSymbol("" + sb.charAt(0)))
        {// if there appears a
          // symbol, after
          // anything else,
          if (LOGCATEG || LOGALL)
            LOGGER.printf("%-1s | '%s' | %s", "", myChar, "Symbol\n");
          sb = startNewSB(sb, myChar);// start a new StringBuilder
        }
        else
        {
          LOGGER.printf("%-1s | %s", "E", "Unknown error.");
          System.exit(0);
        }
      }
      sb = startNewSB(sb);
      // END Token Processing
    }
    // END Read file
    this.scan.close();
    this.fis.close();

    this.tokenItr = this.tokens.listIterator();

    LOGGER.printf("%-1s | %s", "", ("===== Token List (" + this.numTokens() + ") =====\n"));
    LOGGER.println(this.tokens.toString());
    LOGGER.printf("%-1s | %s", "", "===== Line of each Token (" + this.tokenLine.size() + ") =====\n");
    LOGGER.println(this.tokenLine.toString());
    LOGGER.printf("%-1s | %s", "", "===== Indents of each Token (" + this.tokenLine.size() + ") =====\n");
    LOGGER.println(this.tokenIndents.toString());
  }

  private StringBuilder startNewSB(StringBuilder sb)
  {
    return this.startNewSB(sb, "");
  }

  private StringBuilder startNewSB(StringBuilder sb, String init)
  {
    if (!sb.toString().equals("") && sb != null)
    {
      this.tokens.addLast(sb.toString());
      // Append Line number this token is on
      this.tokenLine.addLast(this.currentLine);
      // Append Number of Indents for the line this token is on
      this.tokenIndents.addLast(this.currentIndents);
      if (LOGAPPEND || LOGALL)
        LOGGER.printf("%-1s | %s", "", ("Appended '" + sb.toString() + "' to token list\n"));
    }
    sb = new StringBuilder();
    sb.append(init);
    return sb;
  }

  /**
   * Checks the number of whitespace characters that the line start with.
   * 
   * @param line the line to check
   * @return the number of whitespace characters
   */
  public static int numLineIndents(String line)
  {
    if (line != null && line.length() > 0)
    {
      if (isWhitespace("" + line.charAt(0)))
        return 1 + numLineIndents(line.substring(1));
    }
    return 0;
  }

  // BEGIN Iterator Methods

  /**
   * Checks if the tokenizer has more tokens. Returns true if the tokenizer has
   * more tokens.
   * 
   * @return returns if the tokenizer has more tokens
   */
  public boolean hasNext()
  {
    return this.tokenItr.hasNext();
  }

  /**
   * Checks if the tokenizer has previous tokens. Returns true if the tokenizer
   * has previous tokens.
   * 
   * @return returns if the tokenizer has previous tokens
   */
  public boolean hasPrevious()
  {
    return this.tokenItr.hasPrevious();
  }

  /**
   * Returns the next token in the tokenizer. Returns null if there is no next
   * token.
   * 
   * @return the next token
   */
  public String nextToken()
  {
    return this.tokenItr.next();
  }

  /**
   * Returns the previous token in the tokenizer. Returns null if there is no
   * previous token.
   * 
   * @return the previous token
   */
  public String previousToken()
  {
    return this.tokenItr.previous();
  }

  /**
   * Returns the index of the next token.
   * 
   * @return the index of the next token
   */
  public int nextIndex()
  {
    return this.tokenItr.nextIndex();
  }

  /**
   * Returns the index of the previous token.
   * 
   * @return the index of the previous token
   */
  public int previousIndex()
  {
    return this.tokenItr.previousIndex();
  }

  /**
   * Returns the next non-whitespace token.
   * 
   * @return the next non-whitespace token
   */
  public String previousNonWhitespaceToken()
  {
    while (this.hasPrevious())
    {
      if (!isWhitespace(this.previousToken()))
      {
        return this.nextToken();
      }
    }
    return null;
  }

  /**
   * Returns the previous non-whitespace token.
   * 
   * @return the previous non-whitespace token
   */
  public String nextNonWhitespaceToken()
  {
    while (this.hasNext())
    {
      if (!isWhitespace(this.nextToken()))
      {
        return this.previousToken();
      }
    }
    return null;
  }

  /**
   * Returns the number of tokens in the in the tokenizer.
   * 
   * @return number of tokens in the in the tokenizer
   */
  public int numTokens()
  {
    return this.tokens.size();
  }

  /**
   * Returns the line number of the previous token.
   * 
   * @return the line number of the previous token
   */
  public int previousLineNumber()
  {
    return this.tokenLine.get(this.previousIndex());
  }

  /**
   * Returns the line number of the next token.
   * 
   * @return the line number of the next token
   */
  public int nextLineNumber()
  {
    return this.tokenLine.get(this.nextIndex());
  }

  /**
   * Returns the number of indents of the line the previous token is on.
   * 
   * @return number of indents
   */
  public int previousGetIndents()
  {
    return this.tokenIndents.get(this.previousIndex());
  }

  /**
   * Returns the number of indents of the line the next token is on.
   * 
   * @return number of indents
   */
  public int nextGetIndents()
  {
    return this.tokenIndents.get(this.nextIndex());
  }

  // END Iterator Methods

  // BEGIN Char Category

  /**
   * Returns whether or not the <code>str</code> is a number.
   * 
   * @see #numbers
   * @param str the string to check
   * @return true if str is a number
   */
  public static boolean isNumber(String str)
  {
    return numbers.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a letter.
   * 
   * @see #letters
   * @param str the string to check
   * @return true if str is a letter
   */
  public static boolean isLetter(String str)
  {
    return letters.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a variable character.
   * 
   * @see #varChars
   * @param str the string to check
   * @return true if str is a variable character
   */
  public static boolean isVarChar(String str)
  {
    return varChars.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a float character.
   * 
   * @see #floatChars
   * @param str the string to check
   * @return true if str is a float character
   */
  public static boolean isFloatChar(String str)
  {
    return floatChars.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a starting float character.
   * 
   * @see #startFloatChars
   * @param str the string to check
   * @return true if str is a starting float character
   */
  public static boolean isStartFloatChar(String str)
  {
    return startFloatChars.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a starting variable
   * character.
   * 
   * @see #startVarChars
   * @param str the string to check
   * @return true if str is a starting variable character
   */
  public static boolean isStartVarChar(String str)
  {
    return startVarChars.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a symbols character.
   * 
   * @see #symbols
   * @param str the string to check
   * @return true if str is a symbols character
   */
  public static boolean isSymbol(String str)
  {
    return symbols.indexOf(str) >= 0;
  }

  /**
   * Returns whether or not the <code>str</code> is a whitespace character.
   * 
   * @see #whitespaces
   * @param str the string to check
   * @return true if str is a whitespace character
   */
  public static boolean isWhitespace(String str)
  {
    return whitespaces.indexOf(str) >= 0;
  }

  // END Char Category

  // BEGIN Scope Balancing

  /**
   * Resets the stack with an empty list. To be called before calling
   * {@link #stackIsBalanced() stackIsBalanced()}, {@link #stackList()
   * stackList()}, or {@link #stackUpdate(String) stackUpdate()}.
   */
  public static void stackReset()
  {
    stack = new Stack<String>();
  }

  /**
   * Returns whether or not the stack is balanced.
   * 
   * @throws NullPointerException if stack has not been reset
   * @see #stackReset()
   * @return true if the stack is balanced
   */
  public static boolean stackIsBalanced() throws NullPointerException
  {
    return stack.isEmpty();
  }

  /**
   * Returns a string of the contents of the stack.
   * 
   * @throws NullPointerException if stack has not been reset
   * @see #stackReset()
   * @return true if the stack is balanced
   */
  public static String stackList() throws NullPointerException
  {
    return stack.toString();
  }

  /**
   * Adds an item to that stack and pops off items if they match up to the last
   * scope indicator (e.g. it is the closing '}' to an opening '{').
   * 
   * @param input the token to push onto the stack
   * @throws NullPointerException if stack has not been reset
   * @see #stackReset()
   */
  public static void stackUpdate(String input) throws NullPointerException
  {
    if (stack.isEmpty())
      stack.push(input);
    else if (isCloserForOpener(stack.peek(), input))
      stack.pop();
    else
      stack.push(input);
  }

  /**
   * Returns whether or not the closing token matches an opening token (e.g. it
   * is the closing '}' to an opening '{').
   * 
   * @param opener the possible opening token
   * @param closer the possible closing token
   * @return true if items match
   */
  public static boolean isCloserForOpener(String opener, String closer)
  {
    long indexOfOpener = scopeOpeners.indexOf(opener);
    long indexOfCloser = scopeClosers.indexOf(closer);
    if (indexOfOpener < 0 || indexOfCloser < 0)
      return false;
    return indexOfOpener == indexOfCloser;
  }

  // END Scope Balancing
}

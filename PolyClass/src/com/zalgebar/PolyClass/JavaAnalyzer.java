package com.zalgebar.PolyClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.zalgebar.FileTokenizer;

/**
 * @(#)JavaAnalyzer.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/02/23
 * @lastModified 2017/02/23
 */
public class JavaAnalyzer implements LanguageAnalyzer
{
  private PolyClass polyClass;
  private boolean isComment;
  private boolean isLiteral;
  private FileTokenizer tokenizer;

  /**
   * Constructs a new LanguageAnalyzer. Initializes a new
   * {@link com.zalgebar.FileTokenizer FileTokenizer} that is ready to have
   * {@link com.zalgebar.FileTokenizer#tokenizeFile(String)
   * tokenizeFile(String)} called from it.
   */
  protected JavaAnalyzer()
  {
    this.tokenizer = new FileTokenizer();
  }

  /**
   * Constructs a new LanguageAnalyzer and immediately attempts to tokenize the
   * file. Calls {@link #analyzeFile(String) analyzeFile(String)}.
   *
   * @param filename name of the file to be analyzed
   * @throws FileNotFoundException if the file could not be found
   * @throws IOException if the file could not be read
   */
  protected JavaAnalyzer(String filename) throws FileNotFoundException, IOException
  {
    this.tokenizer = new FileTokenizer(filename);
  }

  /**
   * Compares the next non-whitespace token to the <code>expectedString</code>
   * parameter.
   *
   * @param expectedString The string that the next non-whitespace token should
   *          be
   * @return Whether or not expectedString equals the next non-whitespace token
   */
  boolean nextNonWhitespaceTokenIs(String expectedString)
  {
    return expectedString.equals(this.tokenizer.nextNonWhitespaceToken());
  }

  @Override
  public void analyzeFile(String filename)
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeClass() throws FileFormatException
  {
    analyzeVisibility();// 0 or 3

    analyzeMfrAbstract();// Abstract & final are mutually exclusive
    analyzeMfrConstant();

    if (this.nextNonWhitespaceTokenIs("class") || this.nextNonWhitespaceTokenIs("interface"))
    {
    }
    else
    {
      throw new FileFormatException();
    }
    analyzeIdentifier();
    if (nextNonWhitespaceTokenIs("{"))
    {
    }
    else
    {
      throw new FileFormatException();
    }
  }

  @Override
  public void analyzeAttribute() throws FileFormatException
  { // analyzeVariable()
    analyzeVisibility();// 0-3

    // order inconsequential
    analyzeMfrConstant();
    analyzeMfrStatic();
  }

  @Override
  public void analyzeOperation() throws FileFormatException
  { // analyzeMethod()
    // TODO: Add your code here
  }

  @Override
  public void analyzeReturns() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeArguments() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeVisibility() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeMfrConstant() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeMfrAbstract() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeMfrStatic() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeIdentifier() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public void analyzeDataType() throws FileFormatException
  {
    // TODO: Add your code here
  }

  @Override
  public PolyClass getPolyClass()
  {
    return this.polyClass;
  }
}

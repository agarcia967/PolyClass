/**
 * @(#)FileWriter.java
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/01/17
 * @lastModified 2017/02/26
 */
package com.zalgebar;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class FileWriter
{
  private static final boolean DEBUG = true;
  private FileOutputStream fos;
  private PrintWriter pw;
  private int linesWritten;

  /**
   * Opens a file to be prepared for writing.
   * 
   * @param outFileName Full file path and name. May not be null.
   * @throws FileNotFoundException TODO
   * @post Out file is ready for writing by object.
   */
  public FileWriter(String outFileName) throws FileNotFoundException
  {
    if (DEBUG)
      System.out.print("Creating output file '" + outFileName + "'... ");
    if (outFileName == null)
      throw new FileNotFoundException("File name may not be null.");
    this.fos = new FileOutputStream(outFileName);
    this.pw = new PrintWriter(fos);
    if (DEBUG)
      System.out.println("Done.");
  }

  /**
   * Initializes a FileWriter, writes the lines from the list, and closes the
   * file.
   * 
   * @param outFileName Full file path and name. May not be null.
   * @param list List of String objects that are each a line in the file to be
   *          written.
   * @throws FileNotFoundException TODO
   * @throws IOException TODO
   * @post Out file is written and closed.
   */
  public FileWriter(String outFileName, List<String> list) throws FileNotFoundException, IOException
  {
    this(outFileName);
    for (String l : list)
    {
      this.println(l);
    }
    this.close();
  }

  /**
   * Prints to file or to console depending on DEBUG.
   * 
   * @param string String to write to outstream.
   * @post Writes string to outstream.
   */
  public void print(String string)
  {
    if (string.indexOf("\n") > 0)
      this.linesWritten += string.split("\n").length - 1;
    if (DEBUG)
      System.out.println("Writing line: '" + string + "'");
    this.pw.print(string);
  }

  /**
   * Prints string with newline to file or to console depending on DEBUG.
   * 
   * @param string String to write to outstream.
   * @post Writes string to outstream.
   */
  private void println(String string)
  {
    this.print(string + "\n");
    this.linesWritten += 1;
  }

  /**
   * Returns the amount of lines written so far.
   * 
   * @return Returns the amount of lines written so far.
   */
  public int linesWritten()
  {
    return this.linesWritten;
  }

  /**
   * Writes to file and closes the file.
   * 
   * @post Output file is written and closed.
   * @throws IOException TODO
   */
  public void close() throws IOException
  {
    if (DEBUG)
      System.out.print("Closing...");
    this.pw.flush();
    this.pw.close();
    this.fos.flush();
    this.fos.close();
    if (DEBUG)
      System.out.println("Done.");
  }

  /**
   * Tests the FileWriter object
   * 
   * @param args program arguments
   */
  public static void main(String[] args)
  {
    FileWriter fw;
    try
    {
      fw = new FileWriter("test/TestFile.txt");
      fw.print("text1\ntext2");
      fw.println("line1");
      fw.print("text3");
      fw.println("line2");
      fw.close();
      System.out.println(fw.linesWritten());
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e);
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
  }
}

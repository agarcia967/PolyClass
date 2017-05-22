/**
 * @(#)FileFormatException.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/02/23
 * @lastModified 2017/02/23
 */
package com.zalgebar.PolyClass;

public final class FileFormatException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = -9100593904882004849L;

  public FileFormatException()
  {}

  public FileFormatException(String message)
  {
    super(message);
  }

  public FileFormatException(Throwable cause)
  {
    super(cause);
  }

  public FileFormatException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/**
 * @(#)PolyDataType.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2016/12/08
 * @lastModified 2017/02/22
 */
package com.zalgebar.PolyClass;

public enum PolyDataType
{
  /**
   * The void return type (for PolyReturn objects only).
   * 
   * @see PolyReturn#PolyReturn
   */
  VOID("void"),
  /**
   * The primitive boolean type (commonly <code>bool</code> or
   * <code>boolean</code>).
   */
  BOOLEAN("boolean"),
  /**
   * The primitive character type (commonly <code>char</code>).
   */
  CHARACTER("char"),
  /**
   * The primitive byte type (commonly <code>byte</code>).
   */
  BYTE("byte"),
  /**
   * The primitive short integer type (commonly <code>short</code>).
   */
  SHORT("short"),
  /**
   * The primitive integer type (commonly <code>int</code>).
   */
  INTEGER("int"),
  /**
   * The primitive long integer type (commonly <code>long</code>).
   */
  LONG("long"),
  /**
   * The primitive floating point decimal type (commonly <code>float</code>).
   */
  FLOAT("float"),
  /**
   * The primitive double floating point decimal type (commonly
   * <code>double</code>).
   */
  DOUBLE("double"),
  /**
   * The primitive or built-in string class (commonly <code>string</code> or
   * <code>String</code>).
   */
  STRING("string"),
  /**
   * Any built-in or custom class that has been declared and compiled (e.g.
   * <code>MyClass</code> or <code>Dog</code>).
   */
  CLASS("CLASS");

  private final String umlLabel;

  /**
   * Constructs a PolyDataType object and sets its UML Label.
   * 
   * @return the UML label of this data type
   */
  PolyDataType(String umlLabel)
  {
    this.umlLabel = umlLabel;
  }

  /**
   * Outputs in standard UML formatting.
   * 
   * @return the UML format of this data type
   */
  @Override
  public String toString()
  {
    return umlLabel;
  }
}

/**
 * @(#)PolyOperationPart.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/03/02
 * @lastModified 2017/03/02
 */
package com.zalgebar.PolyClass;

abstract class PolyOperationPart
{
  private PolyDataType dataType;
  private String className;

  /**
   * Constructs a new void typed part.
   * <p>
   * Sets the data type for this part as VOID.
   * </p>
   *
   * @see PolyDataType#VOID
   */
  public PolyOperationPart()
  {
    this.dataType = PolyDataType.VOID;
  }

  /**
   * Constructs a new primitive type part.
   * <p>
   * Sets the data type for this part.
   * </p>
   *
   * @param dataType data type of the part
   *
   * @see PolyDataType#PolyDataType
   */
  public PolyOperationPart(PolyDataType dataType)
  {
    this.dataType = dataType;
  }

  /**
   * Constructs a new class-typed part.
   * <p>
   * Sets the data type and class identifier for this part. Data type is
   * automatically set to CLASS as the String assumes identifying a
   * non-primitive data type.
   * </p>
   *
   * @param className class name of the part
   *
   * @see PolyDataType#PolyDataType
   * @see PolyDataType#CLASS
   */
  public PolyOperationPart(String className)
  {
    this(PolyDataType.CLASS);
    this.className = className;
  }

  /**
   * Gets the data type for this part.
   *
   * @return current data type
   */
  PolyDataType getDataType()
  {
    return this.dataType;
  }

  /**
   * Gets the non-primitive data type class name for this part.
   *
   * @return current class name
   */
  String getClassName()
  {
    return this.className;
  }

  /**
   * Outputs in standard UML formatting.
   *
   * @return the UML format of this part
   */
  @Override
  public String toString()
  {
    if (this.dataType == PolyDataType.CLASS)
      return this.className;
    return this.dataType.toString();
  }
}

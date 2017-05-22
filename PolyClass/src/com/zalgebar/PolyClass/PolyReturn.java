/**
 * @(#)PolyOperationPart.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/02/17
 * @lastModified 2017/03/02
 */
package com.zalgebar.PolyClass;

public final class PolyReturn extends PolyOperationPart
{

  /**
   * Constructs a new void typed return.
   * <p>
   * Sets the data type for this return as VOID.
   * </p>
   *
   * @see PolyDataType#VOID
   * @see PolyOperationPart#PolyOperationPart()
   */
  PolyReturn()
  {
    super();
  }

  /**
   * Constructs a new primitive type return.
   * <p>
   * Sets the data type for this return.
   * </p>
   *
   * @param dataType data type of the return
   *
   * @see PolyDataType#PolyDataType
   * @see PolyOperationPart#PolyOperationPart(PolyDataType)
   */
  public PolyReturn(PolyDataType dataType)
  {
    super(dataType);
  }

  /**
   * Constructs a new class-typed return.
   * <p>
   * Sets the data type and class identifier for this return. Data type is
   * automatically set to CLASS as the String assumes identifying a
   * non-primitive data type.
   * </p>
   *
   * @param className class name of the return
   *
   * @see PolyDataType#PolyDataType
   * @see PolyDataType#CLASS
   */
  public PolyReturn(String className)
  {
    super(className);
  }
}

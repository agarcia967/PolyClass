/**
 * @(#)PolyOperation.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2017/02/17
 * @lastModified 2017/02/22
 */
package com.zalgebar.PolyClass;

import java.util.List;
import java.util.LinkedList;

public final class PolyOperation extends PolyClassPart
{

  /**
   * Set as true to log constructor calls to the console.
   */
  public static boolean CONSTRLOG = false;
  private boolean isConstructor, isDestructor;
  private List<PolyArgument> arguments;
  private List<PolyReturn> returns;

  public static class Builder
  {
  }

  /**
   * Constructs a basic operation with no visibility and no modifiers.
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param retList list of returns for this operation, may be null which will
   *          indicate a VOID return type
   * @param identifier the identifier of this operation
   *
   * @see #PolyOperation(List, List, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, List<PolyReturn> retList, String identifier)
  {
    this(argList, retList, identifier, 0, false, false, false);
    if (CONSTRLOG)
      System.out.println("OPERATION CONSTRUCTOR NO VISBILITY, NO MODIFIERS");
  }

  /**
   * Constructs a basic operation with no modifiers.
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param retList list of returns for this operation, may be null which will
   *          indicate a VOID return type
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   *
   * @see #PolyOperation(List, List, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, List<PolyReturn> retList, String identifier, int visibility)
  {
    this(argList, retList, identifier, visibility, false, false, false);
    if (CONSTRLOG)
      System.out.println("OPERATION CONSTRUCTOR NO MODIFIERS");
  }

  /**
   * Constructs a basic operation.
   * <p>
   * Sets the arguments, returns, identifier, visibility, and modifiers for this
   * operation. This is neither a constructor nor destructor.
   * </p>
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param retList list of returns for this operation, may be null which will
   *          indicate a VOID return type
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   * @param mfr_static whether or not this operation is static
   * @param mfr_constant whether or not this operation is constant
   * @param mfr_abstract whether or not this operation is abstract
   *
   * @see #PolyOperation(boolean, List, List, boolean, String, int, boolean,
   *      boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, List<PolyReturn> retList, String identifier, int visibility,
      boolean mfr_static, boolean mfr_constant, boolean mfr_abstract)
  {
    this(false, argList, retList, false, identifier, visibility, mfr_static, mfr_constant, mfr_abstract);
    if (CONSTRLOG)
      System.out.println("OPERATION FULL CONSTRUCTOR");
  }

  /**
   * Constructs a constructor with no visibility and no modifiers.
   * 
   * @param isConstructor whether or not this operation is a constructor
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param identifier the identifier of this operation
   *
   * @see #PolyOperation(boolean, List, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(boolean isConstructor, List<PolyArgument> argList, String identifier)
  {
    this(isConstructor, argList, identifier, 0, false, false, false);
    if (CONSTRLOG)
      System.out.println("CONSTRUCTOR CONSTRUCTOR NO VISBILITY, NO MODIFIERS");
  }

  /**
   * Constructs a constructor with no modifiers.
   *
   * @param isConstructor whether or not this operation is a constructor
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   *
   * @see #PolyOperation(boolean, List, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(boolean isConstructor, List<PolyArgument> argList, String identifier, int visibility)
  {
    this(isConstructor, argList, identifier, visibility, false, false, false);
    if (CONSTRLOG)
      System.out.println("CONSTRUCTOR CONSTRUCTOR NO MODIFIERS");
  }

  /**
   * Constructs a constructor.
   * <p>
   * Sets the constructor status, arguments, identifier, visibility, and
   * modifiers for this operation.
   * </p>
   *
   * @param isConstructor whether or not this operation is a constructor
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   * @param mfr_static whether or not this operation is static
   * @param mfr_constant whether or not this operation is constant
   * @param mfr_abstract whether or not this operation is abstract
   *
   * @see #PolyOperation(boolean, List, List, boolean, String, int, boolean,
   *      boolean, boolean)
   */
  public PolyOperation(boolean isConstructor, List<PolyArgument> argList, String identifier, int visibility,
      boolean mfr_static, boolean mfr_constant, boolean mfr_abstract)
  {
    this(isConstructor, argList, null, false, identifier, visibility, mfr_static, mfr_constant, mfr_abstract);
    if (CONSTRLOG)
      System.out.println("CONSTRUCTOR FULL CONSTRUCTOR");
  }

  /**
   * Constructs a destructor with no visibility and no modifiers.
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param isDestructor whether or not this operation is a destructor
   * @param identifier the identifier of this operation
   *
   * @see #PolyOperation(List, boolean, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, boolean isDestructor, String identifier)
  {
    this(argList, isDestructor, identifier, 0, false, false, false);
    if (CONSTRLOG)
      System.out.println("DESTRUCTOR CONSTRUCTOR NO VISIBILITY, NO MODIFIERS");
  }

  /**
   * Constructs a destructor with no modifiers.
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param isDestructor whether or not this operation is a destructor
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   *
   * @see #PolyOperation(List, boolean, String, int, boolean, boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, boolean isDestructor, String identifier, int visibility)
  {
    this(argList, isDestructor, identifier, visibility, false, false, false);
    if (CONSTRLOG)
      System.out.println("DESTRUCTOR CONSTRUCTOR NO MODIFIERS");
  }

  /**
   * Constructs a destructor.
   * <p>
   * Sets the arguments, destructor status, identifier, visibility and modifiers
   * for this operation.
   * </p>
   *
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param isDestructor whether or not this operation is a destructor
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   * @param mfr_static whether or not this operation is static
   * @param mfr_constant whether or not this operation is constant
   * @param mfr_abstract whether or not this operation is abstract
   *
   * @see #PolyOperation(boolean, List, List, boolean, String, int, boolean,
   *      boolean, boolean)
   */
  public PolyOperation(List<PolyArgument> argList, boolean isDestructor, String identifier, int visibility,
      boolean mfr_static, boolean mfr_constant, boolean mfr_abstract)
  {
    this(false, argList, null, isDestructor, identifier, visibility, mfr_static, mfr_constant, mfr_abstract);
    if (CONSTRLOG)
      System.out.println("DESTRUCTOR FULL CONSTRUCTOR");
  }

  /**
   * Constructs a fully formed operation, constructor, or destructor.
   * <p>
   * Sets the arguments, returns, whether or not the operation is a constructor
   * or destructor, identifier, visibility, and any modifiers for this
   * operation.
   * </p>
   *
   * @param isConstructor whether or not this operation is a constructor
   * @param argList list of arguments for this operation, may be null which will
   *          indicate 0 arguments
   * @param retList list of returns for this operation, may be null which will
   *          indicate a VOID return type
   * @param isDestructor whether or not this operation is a destructor
   * @param identifier the identifier of this operation
   * @param visibility the visibility of this operation
   * @param mfr_static whether or not this operation is static
   * @param mfr_constant whether or not this operation is constant
   * @param mfr_abstract whether or not this operation is abstract
   *
   * @see PolyClassPart#PolyClassPart(String, int, boolean, boolean, boolean)
   */
  private PolyOperation(boolean isConstructor, List<PolyArgument> argList, List<PolyReturn> retList,
      boolean isDestructor, String identifier, int visibility, boolean mfr_static, boolean mfr_constant,
      boolean mfr_abstract)
  {
    super(identifier, visibility, mfr_static, mfr_constant, mfr_abstract);
    if (CONSTRLOG)
      System.out.println("SUPER FULL CONSTRUCTOR");
    this.isConstructor = isConstructor;
    if (argList == null)
      argList = new LinkedList<PolyArgument>();
    this.arguments = argList;
    if (retList == null)
    {
      retList = new LinkedList<PolyReturn>();
      retList.add(new PolyReturn());
    }
    this.returns = retList;
    this.isDestructor = isDestructor;
  }

  /**
   * Gets the argument at the specified location.
   *
   * @param index location of the desired argument
   * @return the argument found, null if none found
   */
  public PolyArgument getArgument(int index)
  {
    return this.arguments.get(index);
  }

  /**
   * Gets a String of a list of the arguments.
   *
   * @return String list
   */
  public String getArgumentsTypeList()
  {
    String returnable = "";
    for (PolyArgument a : arguments)
    {
      returnable += a.getDataType().toString();
      if (this.arguments.indexOf(a) < this.arguments.size() - 1)
        returnable += ",";
    }
    return returnable;
  }

  /**
   * Gets the first return data type.
   *
   * @return return object type
   */
  public PolyReturn getReturnType()
  {
    if (this.returns == null || this.returns.size() <= 0)
      return new PolyReturn(PolyDataType.VOID);
    return this.returns.get(0);
  }

  /**
   * Gets a list of the return data types.
   *
   * @return list of returns
   */
  public List<PolyReturn> getReturns()
  {
    return new LinkedList<PolyReturn>(this.returns);
  }

  /**
   * Returns true if the operation is a constructor.
   *
   * @return is or is not a constructor
   */
  public boolean isConstructor()
  {
    return isConstructor;
  }

  /**
   * Returns true if the operation is a destructor.
   *
   * @return is or is not a destructor
   */
  public boolean isDestructor()
  {
    return isDestructor;
  }

  /**
   * Outputs in standard UML formatting.
   *
   * @return the UML format of this operation
   */
  @Override
  public String toString()
  {
    String returnable = super.toString();
    returnable += "(";
    if (this.arguments == null)
      System.out.println("this.arguments is null");
    for (PolyArgument a : this.arguments)
    {
      returnable += a.toString();
      if (this.arguments.indexOf(a) < this.arguments.size() - 1)
        returnable += ", ";
    }
    returnable += ")";
    if (this.isConstructor || this.isDestructor)
    {
      return returnable;
    }
    returnable += " : ";
    for (PolyReturn r : this.returns)
    {
      returnable += r.toString();
      if (this.returns.indexOf(r) < this.returns.size() - 1)
        returnable += ", ";
    }
    return returnable;
  }
}

/**
 * @(#)PolyClassPart.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2016/12/7
 * @lastModified 2017/02/22
 *
 *               The parent class to PolyClass, PolyAttribute, and
 *               PolyOperation.
 */
package com.zalgebar.PolyClass;

public abstract class PolyClassPart
{
  private String identifier;
  private int visibility; // 0-none, 1-private, 2-protected, 3-public
  private boolean mfr_static;
  private boolean mfr_constant;
  private boolean mfr_abstract;

  /**
   * Constructs a new class part with no visibility and no modifiers.
   * <p>
   * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
   * NullPointerException.
   * </p>
   *
   * @param identifier name of this part of the class MAY NOT BE NULL, this will
   *          throw a NullPointerException
   * @see #PolyClassPart(String, int, boolean, boolean, boolean)
   */
  public PolyClassPart(String identifier) throws NullPointerException
  {
    this(identifier, 0, false, false, false);
  }

  /**
   * Constructs a new class part with no modifiers.
   * <p>
   * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
   * NullPointerException.
   * </p>
   * <p>
   * The <code>visibility</code> parameter may be <code>0</code>,
   * <code>1</code>, <code>2</code>, or <code>3</code> which mean no visibility,
   * <code>private</code>, <code>protected</code>, or <code>public</code>,
   * respectively.
   * </p>
   *
   * @param identifier name of this part of the class
   * @param visibility visibility of this part of the class
   */
  public PolyClassPart(String identifier, int visibility) throws NullPointerException
  {
    this(identifier, visibility, false, false, false);
  }

  /**
   * Constructs a new class part with no modifiers.
   * <p>
   * Sets the identifier, visibility, and modifiers for this class part.
   * </p>
   * <p>
   * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
   * NullPointerException.
   * </p>
   * <p>
   * The <code>visibility</code> parameter may be <code>0</code>,
   * <code>1</code>, <code>2</code>, or <code>3</code> which mean no visibility,
   * <code>private</code>, <code>protected</code>, or <code>public</code>,
   * respectively.
   * </p>
   *
   * @param identifier name of this part of the class
   * @param visibility visibility of this part of the class
   * @param mfr_static sets the static status of this part of the class
   * @param mfr_constant sets the constant status of this part of the class
   * @param mfr_abstract sets the abstract status of this part of the class
   */
  public PolyClassPart(String identifier, int visibility, boolean mfr_static, boolean mfr_constant,
      boolean mfr_abstract) throws NullPointerException
  {
    if (identifier == null)
      throw new NullPointerException("Identifier may not be null.");
    this.identifier = identifier;
    this.visibility = visibility;
    this.mfr_static = mfr_static;
    this.mfr_constant = mfr_constant;
    this.mfr_abstract = mfr_abstract;
  }

  /**
   * Sets the identifier of this part of the class.
   * <p>
   * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
   * NullPointerException.
   * </p>
   * 
   * @param identifier the new identifier of the class part
   */
  public void setIdentifier(String identifier) throws NullPointerException
  {
    if (identifier == null)
      throw new NullPointerException("Identifier may not be null.");
    this.identifier = identifier;
  }

  /**
   * Gets the identifier of this part of the class.
   *
   * @return the current identifier of the class part
   */
  public String getIdentifier()
  {
    return this.identifier;
  }

  /**
   * Returns whether or not this part of the class is given the static modifier.
   *
   * @return current boolean value true - static, false - not static
   */
  public boolean isStatic()
  {
    return this.mfr_static;
  }

  /**
   * Returns whether or not this part of the class is given the constant
   * modifier.
   *
   * @return current boolean value true - constant, false - not constant
   */
  public boolean isConstant()
  {
    return this.mfr_constant;
  }

  /**
   * Returns whether or not this part of the class is given the abstract
   * modifier. True is abstract, false is not abstract.
   *
   * @return current boolean value
   */
  public boolean isAbstract()
  {
    return this.mfr_abstract;
  }

  /**
   * Gets the visibility of this part of the class. 0-none, 1-private,
   * 2-protected, 3-public
   *
   * @return visibility (int)
   */
  public int getVisibility()
  {
    return this.visibility;
  }

  /**
   * Outputs in standard UML formatting.
   * 
   * @return the UML format of this class part
   */
  @Override
  public String toString()
  {
    String returnable = "";
    if (this.getVisibility() == 1)
      returnable += "- ";
    else if (this.getVisibility() == 2)
      returnable += "# ";
    else if (this.getVisibility() == 3)
      returnable += "+ ";
    if (this.isStatic())
      returnable += "$ ";
    if (this.isConstant())
      returnable += "constant ";
    if (this.isAbstract())
      returnable += "abstract ";
    returnable += getIdentifier();
    return returnable;
  }
}

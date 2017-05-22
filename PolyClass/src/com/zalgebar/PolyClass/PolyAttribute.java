package com.zalgebar.PolyClass;

/**
 * @(#)PolyAttribute.java
 *
 * @author 			Anthony R. Garcia
 * @version 		1.00
 * @created			2016/12/8
 * @lastModified	2017/02/22
 *
 * A class that holds Class Attribute data.
 */
public final class PolyAttribute extends PolyClassPart {
	private final PolyDataType dataType;
	private final String className;

	/**
	 * Constructs a primitive type attribute with no visibility and no modifiers.
	 *
	 * @param dataType		type of the attribute
	 * @param identifier	name of the attribute
	 *
	 * @see	#PolyAttribute(PolyDataType, String, int, boolean, boolean, boolean)
	 */
	public PolyAttribute(PolyDataType dataType, String identifier){
		this(dataType,identifier,0,false,false,false);
	}

	/**
	 * Constructs a primitive type attribute with no modifiers.
	 *
	 * @param dataType		type of the attribute
	 * @param identifier	name of the attribute
	 * @param visibility	visibility of the attribute
	 *
	 * @see	#PolyAttribute(PolyDataType, String, int, boolean, boolean, boolean)
	 */
	public PolyAttribute(PolyDataType dataType, String identifier, int visibility){
		this(dataType,identifier,visibility,false,false,false);
	}

	/**
	 * Constructs a primitive type attribute.
	 * <p>Sets the data type, identifier, visibility, and modifiers for this
	 * attribute. Data type is explicit.</p>
	 *
	 * @param dataType		type of the attribute
	 * @param identifier	name of the attribute
	 * @param visibility	visibility of the attribute
	 * @param mfr_static	static status of the attribute
	 * @param mfr_constant	constant status of the attribute
	 * @param mfr_abstract	abstract status of the attribute
	 *
	 * @see	PolyClassPart#PolyClassPart(String, int, boolean, boolean, boolean)
	 */
	public PolyAttribute(PolyDataType dataType, String identifier, int visibility, boolean mfr_static, boolean mfr_constant, boolean mfr_abstract){
		super(identifier,visibility,mfr_static,mfr_constant,mfr_abstract);
		this.dataType = dataType;
		this.className = null;
	}

	/**
	 * Constructs a class-typed attribute with no visibility and no modifiers.
	 *
	 * @param className		name of the class type
	 * @param identifier	name of the attribute
	 *
	 * @see	#PolyAttribute(String, String, int, boolean, boolean, boolean)
	 * @see	PolyDataType#PolyDataType
	 */
	public PolyAttribute(String className, String identifier){
		this(className,identifier,0,false,false,false);
	}

	/**
	 * Constructs a class-typed attribute with no modifiers.
	 *
	 * @param className		name of the class type
	 * @param identifier	name of the attribute
	 * @param visibility	visibility of the attribute
	 *
	 * @see	#PolyAttribute(String, String, int, boolean, boolean, boolean)
	 * @see	PolyDataType#PolyDataType
	 */
	public PolyAttribute(String className, String identifier, int visibility){
		this(className,identifier,visibility,false,false,false);
	}

	/**
	 * Constructs a class-typed attribute.
	 * <p>Sets the class name, identifier, visibility, and modifiers for
	 * this attribute. Data type is implicit and is set to
	 * PolyDataType.CLASS as the String assumes identifying
	 * a non-primitive data type.</p>
	 *
	 * @param className		name of the class type
	 * @param identifier	name of the attribute
	 * @param visibility	visibility of the attribute
	 * @param mfr_static	static status of the attribute
	 * @param mfr_constant	constant status of the attribute
	 * @param mfr_abstract	abstract status of the attribute
	 *
	 * @see	#PolyAttribute(PolyDataType, String, int, boolean, boolean, boolean)
	 * @see PolyDataType#PolyDataType
	 * @see PolyDataType#CLASS
	 */
	public PolyAttribute(String className, String identifier, int visibility, boolean mfr_static, boolean mfr_constant, boolean mfr_abstract){
		super(identifier, visibility, mfr_static, mfr_constant, mfr_abstract);
		this.dataType = PolyDataType.CLASS;
		this.className = className;
	}

	/**
	 * Gets the data type for this attribute.
	 *
	 * @return	current data type
	 */
	public PolyDataType getDataType(){
		return this.dataType;
	}

	/**
	 * Gets the non-primitive data type class name for
	 * this attribute.
	 *
	 * @return	current class name
	 */
	public String getClassName(){
		return this.className;
	}

	/**
	 * Outputs in standard UML formatting.
	 *
	 * @return	the UML format of this attribute
	 */
	@Override
	public String toString(){
		String returnable = super.toString();
		returnable += " : ";
		if(this.dataType==PolyDataType.CLASS) returnable += this.className.toString();
		else returnable += this.dataType.toString();
		return returnable;
	}
}
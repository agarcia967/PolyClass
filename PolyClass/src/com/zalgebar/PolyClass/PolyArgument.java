package com.zalgebar.PolyClass;

/**
 * @(#)PolyArgument.java
 *
 * @author 			Anthony R. Garcia
 * @version 		1.00
 * @created			2017/02/17
 * @lastModified	2017/02/22
 */
public final class PolyArgument extends PolyOperationPart {
	private String identifier;

	/**
	 * Constructs a primitive type argument.
	 * <p>
	 * Sets the identifier and data type for this argument.
	 * </p>
	 * <p>
	 * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
	 * NullPointerException.
	 * </p>
	 *
	 * @param dataType
	 *            type of the attribute
	 * @param identifier
	 *            name of the attribute
	 */
	public PolyArgument(PolyDataType dataType, String identifier) throws NullPointerException {
		super(dataType);
		if (identifier == null)
			throw new NullPointerException("Identifier may not be null.");
		this.identifier = identifier;
	}

	/**
	 * Constructs a class-typed argument.
	 * <p>
	 * Sets the data type and class identifier for this argument. Data type is
	 * automatically set to CLASS as the String assumes identifying a
	 * non-primitive data type.
	 * </p>
	 * <p>
	 * The <code>identifier</code> parameter MAY NOT BE NULL, this will throw a
	 * NullPointerException.
	 * </p>
	 *
	 * @see PolyDataType#PolyDataType
	 * @param className
	 *            name of the class type
	 * @param identifier
	 *            name of the attribute
	 */
	public PolyArgument(String className, String identifier) throws NullPointerException {
		super(className);
		if (identifier == null)
			throw new NullPointerException("Identifier may not be null.");
		this.identifier = identifier;
	}

	/**
	 * Gets the identifier of this argument.
	 *
	 * @return the identifier of the argument
	 */
	public String getIdentifier() {
		return this.identifier;
	}

	/**
	 * Outputs in standard UML formatting.
	 * 
	 * @return the UML format of this argument
	 */
	@Override
	public String toString() {
		String returnable = identifier;
		returnable += " : ";
		returnable += super.toString();
		return returnable;
	}
}

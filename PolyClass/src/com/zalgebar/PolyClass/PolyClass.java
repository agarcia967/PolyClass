package com.zalgebar.PolyClass;

import java.util.HashMap;

/**
 * @(#)PolyClass.java
 *
 * @author 			Anthony R. Garcia
 * @version 		1.00
 * @created			2017/02/25
 * @lastModified	2017/02/26
 */
public final class PolyClass {
	private HashMap<String,PolyAttribute> attributes;
	private HashMap<String,PolyOperation> operations;

	/**
	 * Constructs a new PolyClass object.
	 */
	public PolyClass() {
		// TODO: Add your code here
	}

	/**
	 * Adds a new attribute to the class's attribute list.
	 * <p>As the list uses a HashMap, if duplicate entries are entered
	 * with the same identifier, the previous one will be overwritten.</p>
	 *
	 * @param attribute	already generated attribute to add to the list
	 */
	public void putAttribute(PolyAttribute attribute) {
		this.attributes.put(attribute.getIdentifier(), attribute);
	}

	/**
	 * Adds a new operation to the class's operation list.
	 * <p>As the list uses a HashMap, if duplicate entries are entered with the
	 * same identifier and argument list, the previous one will be overwritten.</p>
	 *
	 * @param operation	already generated operation to add to the list
	 */
	public void putOperation(PolyOperation operation){
		this.operations.put((operation.getIdentifier()+"("+operation.getArgumentsTypeList()+")"), operation);
	}
}

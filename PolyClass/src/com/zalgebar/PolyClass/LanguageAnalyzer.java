package com.zalgebar.PolyClass;

/**
 * @(#)LanguageAnalyzer.java
 *
 * @author Anthony R. Garcia
 * @version 1.00
 * @created 2016/10/3
 * @lastModified 2017/02/27
 */
public interface LanguageAnalyzer {

	/**
	 * Analyzes a whole file.
	 *
	 * @param filename
	 *            name of the file to be analyzed
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeFile(String filename) throws FileFormatException;

	/**
	 * Analyzes whole classes. Depending upon the language, this method should
	 * call {@link #analyzeAttribute() analyzeAttribute()} and/or
	 * {@link #analyzeOperation() analyzeOperation()} one or more times.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post Must have created a PolyClass object in this object's polyClass
	 *       member.
	 */
	void analyzeClass() throws FileFormatException;

	/**
	 * Analyzes attributes. Depending upon the language, this method may call
	 * {@link #analyzeVisibility() analyzeVisibility()},
	 * {@link #analyzeMfrConstant() analyzeMfrConstant()},
	 * {@link #analyzeMfrAbstract() analyzeMfrAbstract()},
	 * {@link #analyzeMfrStatic() analyzeMfrStatic()}, and/or
	 * {@link #analyzeDataType() analyzeDataType()}, and must call
	 * {@link #analyzeIdentifier() analyzeIdentifier()}.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post Must have added a PolyOperation object to this object's polyClass
	 *       member.
	 */
	void analyzeAttribute() throws FileFormatException;

	/**
	 * Analyzes operations. Depending upon the language, this method may calls
	 * {@link #analyzeVisibility() analyzeVisibility()},
	 * {@link #analyzeMfrConstant() analyzeMfrConstant()},
	 * {@link #analyzeMfrAbstract() analyzeMfrAbstract()},
	 * {@link #analyzeMfrStatic() analyzeMfrStatic()}, and/or
	 * {@link #analyzeDataType() analyzeDataType()}, and must call
	 * {@link #analyzeIdentifier() analyzeIdentifier()} and
	 * {@link #analyzeReturns() analyzeReturns()}.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post Must have added a PolyAttribute object to this object's polyClass
	 *       member.
	 */
	void analyzeOperation() throws FileFormatException;

	/**
	 * Analyzes operation return types.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeReturns() throws FileFormatException;

	/**
	 * Analyzes operation arguments.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeArguments() throws FileFormatException;

	/**
	 * Analyzes operation arguments.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeVisibility() throws FileFormatException;

	/**
	 * Analyzes a constant modifier.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeMfrConstant() throws FileFormatException;

	/**
	 * Analyzes an abstract modifier.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeMfrAbstract() throws FileFormatException;

	/**
	 * Analyzes a static modifier.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeMfrStatic() throws FileFormatException;

	/**
	 * Analyzes an identifier.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeIdentifier() throws FileFormatException;

	/**
	 * Analyzes a data type.
	 *
	 * @throws FileFormatException
	 *             if the analyzer encounters an unexpected formatting error
	 * @pre TODO
	 * @post TODO
	 */
	void analyzeDataType() throws FileFormatException;

	/**
	 * Returns a complete and fully formed PolyClass object.
	 *
	 * @return The complete PolyClass object.
	 * @pre TODO
	 */
	PolyClass getPolyClass();
}

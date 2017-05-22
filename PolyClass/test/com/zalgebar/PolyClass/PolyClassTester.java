package com.zalgebar.PolyClass;

import com.zalgebar.*;
import com.zalgebar.PolyClass.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;

/**
 * @(#)PolyClassPart.java
 * Tests parts of the PolyClass program.
 *
 * @author 			Anthony R. Garcia
 * @version 		1.00
 * @created			2016/12/8
 * @lastModified	2017/02/22
 *
 */
public class PolyClassTester {
	/**
	 * PolyClass Testing program
	 * @param args	program arguments
	 */
	public static void main(String[] args) {
		FileTokenizer ft = new FileTokenizer();
		/*try{
			ft.LOG = new PrintStream(new FileOutputStream("errorLog-java.txt"));
			ft.tokenizeFile("src/com/zalgebar/FileTokenizer.java");
			ft.LOG = new PrintStream(new FileOutputStream("errorLog-py.txt"));
			ft.tokenizeFile("test/testclass.py");
			ft.LOG = new PrintStream(new FileOutputStream("errorLog-xml.txt"));
			ft.tokenizeFile("test/SampleXMLClass.xml");
		}
		catch(FileNotFoundException e){
			System.out.println(e);
			System.exit(0);
		}
		catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}*/

		PolyAttribute a = new PolyAttribute(PolyDataType.INTEGER,"myInt");
		System.out.println(a.toString());
		PolyAttribute a2 = new PolyAttribute(PolyDataType.SHORT,"myShort", 2);
		System.out.println(a2.toString());
		PolyAttribute a3 = new PolyAttribute("Scanner","myScanner", 3, true, true, true);
		System.out.println(a3.toString());

		List<PolyArgument> arguments = new LinkedList<PolyArgument>();
		arguments.add(new PolyArgument(PolyDataType.BOOLEAN,"myInt"));
		arguments.add(new PolyArgument("Scanner","myScanner"));
		List<PolyReturn> returns = new LinkedList<PolyReturn>();
		returns.add(new PolyReturn(PolyDataType.BOOLEAN));
		returns.add(new PolyReturn("PrintWriter"));


		PolyOperation o = new PolyOperation(null,null,"myVoidOp");
		System.out.println(o.toString());

		PolyOperation o2 = new PolyOperation(arguments,returns,"myComplexOper",3,true,false,false);
		System.out.println(o2.toString());

		PolyOperation o3 = new PolyOperation(true,null,"Constructor1");
		System.out.println(o3.toString());

		PolyOperation o4 = new PolyOperation(null,true,"Destructor1");
		System.out.println(o4.toString());

		PolyOperation o5 = new PolyOperation(true,arguments,"Constructor1",2);
		System.out.println(o5.toString());

		PolyOperation o6 = new PolyOperation(arguments,true,"Destructor1",3,true,false,false);
		System.out.println(o6.toString());


		FileTokenizer.stackReset();
		FileTokenizer.stackUpdate("{");
		System.out.println(FileTokenizer.stackList() + ", " + FileTokenizer.stackIsBalanced());

		FileTokenizer.stackUpdate("(");
		System.out.println(FileTokenizer.stackList() + ", " + FileTokenizer.stackIsBalanced());

		FileTokenizer.stackUpdate(")");
		System.out.println(FileTokenizer.stackList() + ", " + FileTokenizer.stackIsBalanced());

		FileTokenizer.stackUpdate("}");
		System.out.println(FileTokenizer.stackList() + ", " + FileTokenizer.stackIsBalanced());
	}
}

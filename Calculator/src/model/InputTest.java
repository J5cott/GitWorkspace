package model;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class InputTest {
	private Input in;
	
	
	private Stack<String> math2plus = new Stack<String>();
	private Stack<String> math2plus2 = new Stack<String>();
	private Stack<String> math2plus2plus2 = new Stack<String>();
	
	
	
	
	private Stack<String> math2minus = new Stack<String>();
	private Stack<String> math4minus2 = new Stack<String>();
	

	@Before
	public void setUp() throws Exception {
		
		math2plus.push("2");
		math2plus.push("+");
		
		math2plus2.push("2");
		math2plus2.push("+");
		math2plus2.push("2");
		
		math2minus.push("2");
		math2minus.push("-");
		 
		math4minus2.push("4");
		math4minus2.push("-");
		math4minus2.push("2");
		
		 
	}

	@Test
	public void testCalucate2inputs() {
		
		
		in = new Input();
		Stack<String> testStack = math2plus2;
		
		double testdouble = 4;
		String testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		in = new Input();
		testStack = math4minus2;
		
		testdouble = 2;
		testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
	}
	@Test
	public void testCalucate2inputsWithClear(){
		
		in = new Input();
		Stack<String> testStack = math2plus2;
		
		double testdouble = 4;
		String testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		in.clear();
		
		testStack = math4minus2;
		
		testdouble = 2;
		testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
	}
	
	@Test
	public void testCalucate2inputThen1input(){
		
		in = new Input();
		Stack<String> testStack = math2plus2;
		
		double testdouble = 4;
		String testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		testStack = math2plus;
		testdouble = 6;
		testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		
		in = new Input();
		testStack = math4minus2;
		
		testdouble = 2;
		testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		testStack = math2minus;
		testdouble = 0;
		testString = Double.toString(testdouble);
		
		assertEquals(testString,in.calucate(testStack));
		
		
		
	}
	
	@Test
	public void testCalucate3inputs(){
		
		
		
	}

}

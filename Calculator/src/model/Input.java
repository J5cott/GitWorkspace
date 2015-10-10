package model;
import java.util.*;

public class Input {
	
private double[] input = new double[100];

int indexoflastelement;

/**
 * A constructor that takes a single number.
 * @param d The number to initialize the ArrayList.
 */
public Input(double d){
	input[0] = d;
}

/**
 * A constructor that takes an ArrayList.
 * @param input The ArrayList to initialize input.
 */
public Input(double[] input){
	this.input = input;
	
	int i = 0;
}

/**
 * This method adds a value to the input array.
 * @param d The value to add to the end of the nonzero values in the array.
 */
public void addInput(double d){
	for(double elem : input){
		if(elem == 0.0){
			elem = d;
		}
	}
}

/**
 * This method sets the input variable to
 * the provided list
 */
public void setInput(double[] d){
	input  = d;
}

/**
 * This method returns the stored input
 * @return An ArrayList<Double>
 */
public double[] getInput(){
	return input;
}


}

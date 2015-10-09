package model;
import java.util.*;

public class Input {
	
private ArrayList<Double> input = new ArrayList<Double>();

/**
 * A constructor that takes a single number.
 * @param d The number to initialize the ArrayList.
 */
public Input(double d){
	this.input.add(d);
}

/**
 * A constructor that takes an ArrayList.
 * @param input The ArrayList to initialize input.
 */
public Input(ArrayList<Double> input){
	this.input = input;
}

/**
 * This method adds a value to the input array.
 * @param d The value to add to the end of the array.
 */
public void addInput(double d){
	input.add(d);
}

/**
 * This method sets the input variable to
 * the provided list
 */
public void setInput(ArrayList<Double> d){
	input  = d;
}

/**
 * This method returns the stored input
 * @return An ArrayList<Double>
 */
public ArrayList<Double> getInput(){
	return input;
}


}

package model;
import java.util.*;

public class BasicAlgebra {
	
private double[] numbers;

public BasicAlgebra(double[]input){
	numbers = input;
}

public void setNumbers(double[] num){
	int i = 0;
	for(double d : num){
		numbers[i] = d;
	}
}

public double[] getNumbers(){
	return numbers;
}

/**
 * Adds all of the numbers stored in a provided list
 * @param list The list with the numbers to be added
 * @return the sum of 
 */
public double addAll(double[] list){
	
	double returnnum = 0;
	

	if(list.length >= 1){
	for(double d : list){
		returnnum += d;
	}
	}

	return returnnum;
}
/**
 * Subtracts all of the values in the list from the first value in the list.
 * @param list The list with the values to be subtracted
 * @return The first value after all the values after it in the list have subtracted from it.
 */
public double subAll(double[] list){
	double returnnum = 0;
	
	int i = 0;
	for( double elem : list){
		
		
		if(i == 0){
			returnnum = elem;
			i = 1;
		} else{
			returnnum -= elem;
		}
	}
	
	return returnnum;
}
}

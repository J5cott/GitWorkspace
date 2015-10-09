package model;

public class BasicAlgebra {
	
private double[] numbers;

public void BasicAlgebra(double[]input){
	setNumbers(input);
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

public double addAll(){
	
}
}

package model;
import java.util.*;

public class Input {
	

private double lastnumber;

	public double calucate(Stack<String> math){
		
		while(math.isEmpty() == false){
			String var1 = math.pop();
		
			if(var1 == "+"){
				
				String var2 = math.pop();
				
				
				double input2 = Double.parseDouble(var2);
				
				lastnumber = BasicAlgebra.add(lastnumber,input2);
				
			}
			else{
				
				double input1 = Double.parseDouble(var1);
				String function = math.pop();
				double input2 = Double.parseDouble(math.pop());
				
				switch(function){
					
					case("+"):
						lastnumber = BasicAlgebra.add(input1,input2);
						break;
					case("-"):
						lastnumber = BasicAlgebra.substract(input1,input2);
						
					
				}
				
			}
		
		}
		
		return lastnumber;
	}

	
	
	
}

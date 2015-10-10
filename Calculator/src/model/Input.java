package model;
import java.util.*;

public class Input {
	

private double lastnumber;

	public String calucate(Stack<String> math){
		
		try{
			while(math.isEmpty() == false){
				String var1 = math.pop();
			
				if(var1 == "+"){					
					if (math.isEmpty() == false ) {
						String var2 = math.pop();
						double input2 = Double.parseDouble(var2);
						lastnumber = BasicAlgebra.add(lastnumber, input2);
					}
					else{
						return Double.toString(lastnumber);
					}
					
				}
				else{
					
					double input1 = Double.parseDouble(var1);
					String function = math.pop();
					double input2 = Double.parseDouble(math.pop());
					
					switch(function){
						
						case("+"):
							lastnumber = lastnumber + BasicAlgebra.add(input1,input2);
							break;
						case("-"):
							lastnumber = lastnumber + BasicAlgebra.substract(input1,input2);
								
					}
					
				}
			
			}
			return Double.toString(lastnumber);
		
		}
		catch(NumberFormatException ex){
			return "Syntax error";
			
		}
		
		catch(Exception ex){
			return ex.getMessage();
				
		}	
	}
	
	public void clear(){
		lastnumber = 0;
	}

	
	
	
}

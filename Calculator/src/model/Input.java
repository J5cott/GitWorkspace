package model;
import java.util.*;

public class Input {
	

private double lastnumber;

	public String calucate(Stack<String> math){
		
		try{
			while(math.isEmpty() == false){
				String var1 = math.pop();
			
				if(var1.matches("\\D+")){					
					if (math.isEmpty() == false ) {
						String var2 = math.pop();
						double input2 = Double.parseDouble(var2);
						lastnumber = algebraCaller(lastnumber,var1,input2);
					}
					else{
						return Double.toString(lastnumber);
					}
					
				}
				else{
					
					double input2 = Double.parseDouble(var1);
					String function = math.pop();
					double input1 = Double.parseDouble(math.pop());
					
					lastnumber = lastnumber + algebraCaller(input1,function,input2);
					
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
	
	private double algebraCaller(double input1,String function, double input2){
		
		Double var = null;
		
		switch(function){
		
		case("+"):
			var = BasicAlgebra.add(input1,input2);
			break;
		case("-"):
			var = BasicAlgebra.substract(input1,input2);
			break;
		}
		return var;
		
	}
	
	
	
	public void clear(){
		lastnumber = 0;
	}

	
	
	
}

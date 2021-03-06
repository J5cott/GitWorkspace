package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input1 {

	private double memory = 0;
	private boolean memoryon = false;

	public String calculate(Stack<String> math) {
		
		//Stack<String> math = new Stack<String>();
		 double decimal = 0;
		 double num1 = 0;
		 double num2 = 0;
		 boolean add = false;
		 boolean subtract = false;
		 boolean var1parsed = false;
		 boolean num1valid = false;
		 boolean num2valid = false;
		 boolean operatorvalid = false;
		 boolean adddecimal = false;
		 
		/**
		 while(mathreverse.isEmpty() == false){
			 math.push(mathreverse.pop());
		 }
		 */
		 
		Pattern per = Pattern.compile("\\.");
		Pattern digper = Pattern.compile("\\d|\\.");
		Pattern plus = Pattern.compile("\\+");
		Pattern minus = Pattern.compile("\\-");

		try {
			int i = 0;
			while (math.isEmpty() == false) {
				
				String var1 = math.pop();
				Matcher m1 = per.matcher(var1);
				Matcher m2 = digper.matcher(var1);
				
				if (m2.matches()) {

					if (m1.matches()) {
						adddecimal = true;
						i = 1;
						continue;
					}

					if (var1parsed == false) {
						num1valid = true;
						if (adddecimal == false) {
							num1 += (Double.valueOf(var1) * Math.pow(10, i));
						} else {

							num1 += (Double.valueOf(var1) / Math.pow(10, i));
						}
						i++;
					} else {
						num2valid = true;
						if (adddecimal == false) {
							num2 += (Double.valueOf(var1) * Math.pow(10, i));
						} else {

							num2 += (Double.valueOf(var1) / Math.pow(10, i));
						}
						i++;
					}
				} else {
					i = 0;
					var1parsed = true;
					adddecimal = false;
					Matcher m3 = plus.matcher(var1);
					Matcher m4 = minus.matcher(var1);
					if (m3.matches()) {
						if (operatorvalid == false) {
							operatorvalid = true;
						} else {
							operatorvalid = false;
						}
						add = true;
					} else if (m4.matches()) {
						if (operatorvalid == false) {
							operatorvalid = true;
						} else {
							operatorvalid = false;
						}
						subtract = true;
					}
				}

			}

			double number = 0;
			if (num1valid == true && num2valid == true && operatorvalid == true) {
				if (subtract == true) {
					number = BasicAlgebra.substract(num1, num2);
				} else if (add == true) {
					number = BasicAlgebra.add(num1, num2);
				} else{
					return "Unknown command";
				}
			}else if(num1valid == true && memoryon == true && operatorvalid == true){
				if (subtract == true) {
					number = BasicAlgebra.substract(memory, num1);
				} else if (add == true) {
					number = BasicAlgebra.add(memory, num1);
				} else{
					return "Unknown command";
				}
			}else {
				return "Invalid input";
			}
			
			memoryon = true;
			memory = number;
			return Double.toString(number);

		} catch (NumberFormatException ex) {
			return "Syntax error";

		}

		catch (Exception ex) {
			return ex.getMessage();

		}
	}
	
	public void clear(){
		memory = 0;
		memoryon = false;
	}
}

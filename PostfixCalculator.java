package Cs102hw2;

import Cs102hw2.Converter.stack;

public class PostfixCalculator {

	public static double Calculate(String inputString) {
		stack numstack = new stack();
		char cnext;
		for(int i=0;i<inputString.length();i++) {
			Character c = inputString.charAt(i);
			
			if (Character.isDigit(c)) {
	            int num = 0;
	            while (Character.isDigit(c)) {
	                num = num * 10 + (c - '0');
	                i++;
	                c = inputString.charAt(i);
	            }
	            i--;
	            numstack.push(String.valueOf(num));
	        }
			else  {
				if(c=='+') {
					double num1 = Double.valueOf(numstack.pop());
					double num2 = Double.valueOf(numstack.pop());
					double result = num2+num1;	
					numstack.push(String.valueOf(result));
					//System.out.println(numstack.peek());
				}
				else if(c=='-') {
					double num1 = Double.valueOf(numstack.pop());
					double num2 = Double.valueOf(numstack.pop());
					double result = num2-num1;	
					numstack.push(String.valueOf(result));
					//System.out.println(numstack.peek());
				}
				else if(c=='*') {
					double num1 = Double.valueOf(numstack.pop());
					double num2 = Double.valueOf(numstack.pop());
					double result = num2*num1;	
					numstack.push(String.valueOf(result));
					//System.out.println(numstack.peek());
				}
				else if(c=='/') {
					double num1 = Double.valueOf(numstack.pop());
					double num2 = Double.valueOf(numstack.pop());
					double result = num2/num1;	
					numstack.push(String.valueOf(result));
					//System.out.println(numstack.peek());
				}
				else if(c=='^') {
					double num1 = Double.valueOf(numstack.pop());
					double num2 = Double.valueOf(numstack.pop());
					double result = Math.pow(num2, num1);	
					numstack.push(String.valueOf(result));
					//System.out.println(numstack.peek());
				}
				
			}
			
		}
		//System.out.println(numstack.peek());
		
		return  Double.valueOf(numstack.pop());
	}


}

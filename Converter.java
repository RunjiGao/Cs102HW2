package Cs102hw2;
import java.util.Scanner; 

import java.util.List;

public class Converter {
	  public static class stack{
		  

	    
	    public static class Node{  
	        String item;  
	        Node link;  			
	    } 
	    int size =0;
	    static Node top = null;
	    stack(){
	    	this.top = null;
	    	size = 0;
	    }
	   public boolean isEmpty() {
		   return top==null;
	   }
	   public int size() {
		   return size;
	   }
	   public void push(String s) {
		   Node temp = new Node();
		   if(temp==null) {
			   System.out.print("Heap Overflow");
			   return;
		   }
		   temp.item = s;
		   temp.link = top;
		   top=temp;
		   size+=1;
		   
	   }
	   
	   public String pop() {		   
		   if(top==null) {
			   System.out.print("Stack Underflow");
			   return null;
		   }
		   Node popshow = top;
		   top = (top).link;
		   size-=1;
		   return popshow.item;
		   
		   }
		  


	//print all the nodes of doubly linked list  
	   
	    public String peek() {  
	    	String wholeStack="";
	        if(top == null) {  
	            System.out.println("Stack is empty");  
	              
	        } 
	        else {
	        	Node temp = top;
	        	while(temp!=null) {
	        		wholeStack+=temp.item;
	        		
	        		temp = temp.link;
	        	}
	    }
	        return wholeStack;
	  }
	   
	  public String top() {
		  String topNode = "";
		  if(top==null) {
			  System.out.println("Stack is empty");
		  }else {
			  Node temp = top;
			  topNode = temp.item;
			  
	  }
		  return topNode;
	  }
	 
	    
	  }

	  public static stack pushNumber(stack NumStack,char[]inputCharArray, int i) {
		  
		 if(Character.isDigit(inputCharArray[i])&&i<inputCharArray.length) {
				NumStack.push(String.valueOf(inputCharArray[i]));
				}
		  return NumStack;

		  
	  }
	public static char[] toChararray(String inputString) {
		char[] Chararray = inputString.toCharArray();
		return Chararray;
	}
	 public static int checker(char x) {
		  if(x=='+'||x=='-') {
			  return 1;
		  }
		  if(x=='*'||x=='/') {
			  return 2;
		  }
		  if(x=='^') {
			  return 3;
		  }
		  return 0;
	  }
	 
	
	public static void toPostFix(char[] inputCharArray){

		stack operatorStack = new stack();
		String finalPostFix = "";

		char c;
		char cnext;
		
		for(int i=0;i<inputCharArray.length;i++) {
			c =inputCharArray[i];
			if(i<inputCharArray.length-1) {
			cnext = inputCharArray[i+1];
			}
			else {
				cnext=c;
			}
			if(Character.isDigit(c)) {
				if(Character.isDigit(cnext)) {
				finalPostFix+=Character.toString(c);
				}
				else {
					finalPostFix+=Character.toString(c);
					finalPostFix+=" ";
				}
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
				
	            while (!operatorStack.isEmpty() && operatorStack.top().charAt(0) != '(' && checker(c) <= checker(operatorStack.top().charAt(0))) {
	            	finalPostFix+=(operatorStack.pop());
	            }
	            operatorStack.push(Character.toString(c));
	            
			}
			else if(c == '(' ) {
				operatorStack.push(Character.toString(c));
				
			}
			else if(c==')') {
				while (!operatorStack.isEmpty() && operatorStack.top().charAt(0) != '(') {
					finalPostFix+=(operatorStack.pop());
	            }
	            if (!operatorStack.isEmpty() && operatorStack.top().charAt(0) == '(') {
	                operatorStack.pop();
	            }
	            
			}
			
				
		}
		
		
			
			while(operatorStack.size!=0) {
				finalPostFix+=operatorStack.pop();

				}
			
		
		
		
		
		System.out.println("converted to postfix: "+finalPostFix);
		System.out.println("Result: "+PostfixCalculator.Calculate(finalPostFix));
	}
		


		
	public static void main(String[] args) {
		 Scanner myObj = new Scanner(System.in);
		 System.out.println("type your infix expression: ");
		 String testString = myObj.nextLine();
		//String testString = "(300+23)*(43-21)/(84+7)";
		char[] inputCharArray= toChararray(testString);
		
	    toPostFix(inputCharArray);
	   
		 

	}
}
	
	
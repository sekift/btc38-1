package com.btc38.www.util;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionUtil {
	public static void main(String args[]){
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		String message = (String) exp.getValue();
		System.out.println("The message is " + message);
		
		Expression exp1 = parser.parseExpression("'Hello World'.bytes.length");
		Integer length = (Integer) exp1.getValue();
		System.out.println("The length is " + length);
	}

}

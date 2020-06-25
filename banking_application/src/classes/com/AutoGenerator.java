package com;

import java.util.*;

public class AutoGenerator {
	static String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String Small_chars = "abcdefghijklmnopqrstuvwxyz";
    static String numbers = "123456789";
    static String symbols = "!@#$%^&*_=+-/.?<>)";
    
    public static String getPassword() {
    	 
        String values = Capital_chars + Small_chars +
                        numbers + symbols;
 
        Random rndm_method = new Random();
        int len = 9;
        int i=0;
        char[] password = new char[len];
        for (i = 0; i < len-1; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
              values.charAt(rndm_method.nextInt(values.length()));
        }
        password[i] =
                symbols.charAt(rndm_method.nextInt(symbols.length()));
    	
        return new String(password);
	}

	public static Long getAccountNumber() {
 
        Random rndm_method = new Random(System.currentTimeMillis());
        int len = 13;
        char[] ac = new char[len];
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ac[i] =
              numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
    	
        return Long.parseLong(new String(ac));
	}
	
	public static int getCustomerId() {
		
        Random rndm_method = new Random(System.currentTimeMillis());
        int len = 8;
        char[] ci = new char[len];
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ci[i] =
              numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
    	
        return Integer.parseInt(new String(ci));
	}
	
	public static int getTransactionId() {
		 
        Random rndm_method = new Random(System.currentTimeMillis());
        int len = 5;
        char[] ci = new char[len];
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ci[i] =
              numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
    	
        return Integer.parseInt(new String(ci));
	}
	
	public static int getBenNumber() {
		 
        Random rndm_method = new Random(System.currentTimeMillis());
        int len = 3;
        char[] ac = new char[len];
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ac[i] =
              numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
    	
        return Integer.parseInt(new String(ac));
	}
}
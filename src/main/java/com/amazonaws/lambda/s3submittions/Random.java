package com.amazonaws.lambda.s3submittions;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class Random {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(35, random).toString(32);
         }
  
   public static void main(String args[])
   {
	   Random r=new Random();
	   System.out.println(r.nextSessionId());
   }
}
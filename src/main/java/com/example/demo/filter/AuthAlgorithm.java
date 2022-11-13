package com.example.demo.filter;

import java.io.File;
import java.util.Scanner;

import org.apache.tomcat.util.codec.binary.Base64;

import com.auth0.jwt.algorithms.Algorithm;

public final class AuthAlgorithm {
	
	
	public static Algorithm getAlgo() {
		
		String secret = "code";
		
		try {
			File secretCodeFile = new File("src/main/control/sch.txt");
			Scanner scn = new Scanner(secretCodeFile);
			String secretCode = scn.nextLine();
			byte[] bytesEncoded = Base64.encodeBase64(secretCode.getBytes());
			secret = new String(bytesEncoded);
			scn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return Algorithm.HMAC256(secret.getBytes());
	}
}

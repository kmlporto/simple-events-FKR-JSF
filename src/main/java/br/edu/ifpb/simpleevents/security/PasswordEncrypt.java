//package br.edu.ifpb.simpleevents.security;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.KeySpec;
//
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.PBEKeySpec;
//
//public class PasswordEncrypt {
//	
//	public String encrypt (String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
//		SecureRandom random = new SecureRandom();
//		byte[] salt = new byte[16];
//		random.nextBytes(salt);
//		
//		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
//		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//		
//		byte[] hash = factory.generateSecret(spec).getEncoded();
//		
//		return hash.toString();
//		
//	}
//
//}

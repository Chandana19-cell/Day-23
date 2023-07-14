package Tests;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Enc {
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	  public static String encrypt(String message, String key) throws GeneralSecurityException, UnsupportedEncodingException {
	    if(message == null || key == null){
	      throw new IllegalArgumentException("text to be encrypted and key should not be null");
	    }
	    Cipher cipher = Cipher.getInstance(ALGORITHM);
	    byte[] messageArr = message.getBytes();
	    byte[] keyparam=key.getBytes();
	    SecretKeySpec keySpec = new SecretKeySpec(keyparam, "AES");
	    byte[] ivParams = new byte[16];
	    byte[] encoded = new byte[messageArr.length + 16];
	    System.arraycopy(ivParams,0,encoded,0,16);
	    System.arraycopy(messageArr, 0, encoded, 16, messageArr.length);
	    cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivParams));
	    byte[] encryptedBytes = cipher.doFinal(encoded);
	    encryptedBytes = Base64.getEncoder().encode(encryptedBytes);
	    return new String(encryptedBytes);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

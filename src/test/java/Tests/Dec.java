package Tests;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Dec {
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	public static String decrypt(String encryptedStr, String key) throws GeneralSecurityException, UnsupportedEncodingException {
	    if(encryptedStr == null || key == null){
	      throw new IllegalArgumentException("text to be decrypted and key should not be null");
	    }
	   Cipher cipher = Cipher.getInstance(ALGORITHM);
	   byte[] keyparam=key.getBytes();
	    SecretKeySpec keySpec = new SecretKeySpec(keyparam, "AES");
	    byte[] encoded = encryptedStr.getBytes();
	    encoded = Base64.getDecoder().decode(encoded);
	    byte[] decodedEncrypted = new byte[encoded.length-16];
	    System.arraycopy(encoded, 16, decodedEncrypted, 0,encoded.length-16);
	    byte[] ivParams = new byte[16];
	    System.arraycopy(encoded,0, ivParams,0, ivParams.length);
	    cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivParams));
	    byte[] decryptedBytes = cipher.doFinal(decodedEncrypted);
	    return new String(decryptedBytes);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

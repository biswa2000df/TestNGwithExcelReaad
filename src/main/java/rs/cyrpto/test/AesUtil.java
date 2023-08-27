package rs.cyrpto.test;

/**
 * Created by Ankush on 13-12-2022.
 */

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class AesUtil {

	private final int keySize = 128;
	private final int iterationCount = 1000;
	private final Cipher cipher;
	private String passphrase = "RUPEEWEBSITE";
	private String iv = "320ef7705d1030f0a1a55b3dcf676cb8";
	private String salt = "498960e491150a0fc0f21822a147fd62";

	public AesUtil() {
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (Exception e) {
			throw fail(e);
		}
	}

	public String decrypt(String ciphertext) {
		// System.out.println("salt-----"+salt+"iv------"+iv+"passphrase------"+passphrase+"ciphertext"+ciphertext);
		try {
			System.out.println("kjdgblakjhkjahlkjshflkjgahlkjhaljskhkljhaslkjhakjl");
			SecretKey key = generateKey(salt, passphrase);
			// System.out.println("key"+key);
			byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, base64(ciphertext));
 System.out.println("alkhskjlghs;lfhljhasl;kjl;");
			// System.out.println("decrypted--------------"+decrypted);
			return new String(decrypted, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
		try {
			cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
			return cipher.doFinal(bytes);
		} catch (Exception e) {
			return null;
		}
	}

	public String encrypt(String message) {

		try {

			if (message.indexOf("Session Invalidate") != -1) {
				try {
					JSONObject tempObj = new JSONObject(message);
					return tempObj.getString("message");
				} catch (Exception e) {
					e.printStackTrace();
					// return message;
				}

				return message;
			}

			SecretKey key = generateKey(salt, passphrase);

			byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, message.getBytes("UTF-8"));
			String encryptedtext = Base64.encodeBase64String(encrypted);

			// println "code "+encryptedtext

			return encryptedtext;

		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
			// return null;
		}

	}

	private SecretKey generateKey(String salt, String passphrase) {
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
			SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
			return key;
		} catch (Exception e) {
			return null;
		}
	}

	private static byte[] base64(String str) {
		return Base64.decodeBase64(str);
	}

	private static byte[] hex(String str) {
		try {
			return Hex.decodeHex(str.toCharArray());
		} catch (DecoderException e) {

			throw new IllegalStateException(e);
		}
	}

	public String generateJWT(String userName, String pan) {
		try {
			JSONObject jObj = new JSONObject();
			jObj.put("userName", userName);
			jObj.put("pan", pan);
			jObj.put("role", "admin");
			return new JwtGenerator().generate(jObj);
		} catch (Exception e) {
			fail(e);
			return null;
		}

	}

	private IllegalStateException fail(Exception e) {
		return null;
	}

	public static void main(String args[]) {
		String s="bisw";
		AesUtil ob=new AesUtil();
				ob.decrypt(s);
	}
}

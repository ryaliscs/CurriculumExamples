package algorithm;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * This example shows you a few of Java AES encryption and decryption examples:
 * 
 * <pre>
  	AES String encryption – (encrypt and decrypt a string). 
  	AES Password-based encryption – (The secret key will derive from a given password).
  	
  	 The IV (initial value or initial vector), it is random bytes, typically 12 bytes or 16 bytes. In Java, we can use SecureRandom to generate the random IV.
  	 
  	 We use salt to protect rainbow attacks, and it is also a random byte,
  	 
  	 For password-based encryption, we can use the Password-Based Cryptography Specification (PKCS), defined RFC 8018, to generate a key from a given password.

	For PKCS inputs:
	
	Password, you provide this.
	
	Salt – At least 64 bits (8 bytes) random bytes.
	Iteration Count – Recommend a minimum iteration count of 1,000
 * 
 * </pre>
 * 
 * @author saryal
 *
 */
public class AESEncryption {
	private static final String AES = "AES";
	private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final String AES_CBC_ALGORITHM = "AES/CBC/PKCS5Padding";

	private SecretKey key;

	/**
	 * creates AESEncryption instance
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public AESEncryption() throws NoSuchAlgorithmException {
		init();
	}

	/**
	 * initializes the AES key
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private void init() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance(AES);
		keyGen.init(256, SecureRandom.getInstanceStrong()); // key size, random
		this.key = keyGen.generateKey();
	}

	/**
	 * encrypt: AES String encryption
	 * 
	 * @param aStringToEncrypt plan text to encrypt
	 * @return encrypted string
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String encrypt(String aStringToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, this.key);
		byte[] cipherText = cipher.doFinal(aStringToEncrypt.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}

	/**
	 * customEncrypt: AES Password-based encryption – (The secret key will derive
	 * from a given password)
	 * 
	 * @param aStringToEncrypt plain text to encrypt
	 * @param aKey             key to encrypt the text
	 * @param aSalt            salt used for encryption
	 * @return encrypted string
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 */
	public String customEncrypt(String aStringToEncrypt, String aKey, String aSalt)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException {
		SecretKey secret = getAESKeyFromCustomKey(aKey, aSalt);

		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] cipherText = cipher.doFinal(aStringToEncrypt.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}

	/**
	 * customEncryptCBC: AES Password-based encryption, it uses CBC MODE (Cipher
	 * Block Chaining)– (The secret key will derive from a given password), on top
	 * of salt it also uses IV (initial value or initial vector) in encrypting the
	 * string
	 * 
	 * @param aStringToEncrypt plain text to encrypt
	 * @param aKey             key to encrypt the text
	 * @param aSalt            salt used for encryption
	 * @return encrypted string (the encrypted string contains, IV+cipher text
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidAlgorithmParameterException
	 */
	public String customEncryptCBC(String aStringToEncrypt, String aKey, String aSalt) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
		SecretKey secret = getAESKeyFromCustomKey(aKey, aSalt);

		Cipher cipher = Cipher.getInstance(AES_CBC_ALGORITHM);
		IvParameterSpec iv = generateIv();
		cipher.init(Cipher.ENCRYPT_MODE, secret, iv);
		byte[] cipherText = cipher.doFinal(aStringToEncrypt.getBytes());

		byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.getIV().length + cipherText.length).put(iv.getIV())
				.put(cipherText).array();

		// string representation, base64, send this string to other for decryption.
		return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);
	}

	/**
	 * decrypt: AES String decryption
	 * 
	 * @param aEncryptedString encrypted string
	 * @return decrypted string
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypt(String aEncryptedString) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(aEncryptedString));
		return new String(plainText);
	}

	/**
	 * customDecrypt: AES Password-based encryption – (The secret key will derive
	 * from a given password)
	 * 
	 * @param aStringToEncrypt plain text to encrypt
	 * @param aKey             key to encrypt the text
	 * @param aSalt            salt used for encryption
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 */
	public String customDecrypt(String aEncryptedString, String aKey, String aSalt)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException {

		SecretKey secret = getAESKeyFromCustomKey(aKey, aSalt);

		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(aEncryptedString));
		return new String(plainText);
	}

	/**
	 * customDecryptCBC: AES Password-based decryption, it uses CBC MODE (Cipher
	 * Block Chaining)– (The secret key will derive from a given password), on top
	 * of salt it also uses IV (initial value or initial vector) in decrypting the
	 * string
	 * 
	 * @param aEncryptedString encrypted string which contains iv+ciphertext
	 * @param aKey             key to encrypt the text
	 * @param aSalt            salt used for encryption
	 * @return decrypted string
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidAlgorithmParameterException
	 */
	public String customDecryptCBC(String aEncryptedString, String aKey, String aSalt) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException, UnsupportedEncodingException, InvalidAlgorithmParameterException {

		byte[] decode = Base64.getDecoder().decode(aEncryptedString.getBytes(StandardCharsets.UTF_8));
		// get back the iv and salt from the cipher text
		ByteBuffer bb = ByteBuffer.wrap(decode);
		byte[] iv = new byte[16];
		bb.get(iv);
		byte[] cipherText = new byte[bb.remaining()];
		bb.get(cipherText);
		SecretKey secret = getAESKeyFromCustomKey(aKey, aSalt);

		Cipher cipher = Cipher.getInstance(AES_CBC_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
		byte[] plainText = cipher.doFinal(cipherText);
		return new String(plainText);
	}

	/**
	 * getAESKeyFromCustomKey: SecretKey generated from the key and salt
	 * 
	 * @param aKey  text/password used to encrypt
	 * @param aSalt salt used in the encryption
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 */
	private SecretKey getAESKeyFromCustomKey(String aKey, String aSalt)
			throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

		byte[] key = (aKey).getBytes("UTF-8");

		KeySpec spec = new PBEKeySpec((new String(key)).toCharArray(), aSalt.getBytes(), 65536, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), AES);

		return secret;
	}

	/**
	 * generateIv: IV is a pseudo-random value and has the same size as the block
	 * that is encrypted.
	 * 
	 * @return IvParameterSpec
	 */
	private IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	public static void main(String[] args) {

		try {
			AESEncryption aes = new AESEncryption();
			String plainString = "https://morioh.com/p/f716674e3196?f=5c21fb01c16e2556b555ab32";
			System.out.println("Plan String :" + plainString);
			String encryptedString = aes.encrypt(plainString);
			System.out.println("Simple AES encrypted string: " + encryptedString);
			String decryptedString = aes.decrypt(encryptedString);
			System.out.println("Simple AES decrypted string: " + decryptedString);
			System.out.println("----------- Custom encryption with addtional salt -----------------");
			String salt = "sarat";
			String secretKey = UUID.randomUUID().toString();
			System.out.println("Custom Key :" + secretKey);
			encryptedString = aes.customEncrypt(plainString, secretKey, salt);
			System.out.println("AES encrypted string with salt: " + encryptedString);
			decryptedString = aes.customDecrypt(encryptedString, secretKey, salt);
			System.out.println("AES decrypted string with salt: " + decryptedString);

			encryptedString = aes.customEncryptCBC(plainString, secretKey, salt);
			System.out.println("AES encrypted string with CBC: " + encryptedString);
			decryptedString = aes.customDecryptCBC(encryptedString, secretKey, salt);
			System.out.println("AES decrypted string with CBC: " + decryptedString);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | InvalidKeySpecException | UnsupportedEncodingException
				| InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}
}

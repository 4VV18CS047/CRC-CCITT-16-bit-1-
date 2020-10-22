package javaprojects;
import java.security.*;
import java.io.*;
import javax.crypto.Cipher;
public class RSA 
{
	public static void main(String args[])
	{
		String srci="";
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter any string you want to encrypt");
			srci=br.readLine();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		try
		{
			KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
			kpg.initialize(512);//initialize key pairs to 512 bits ,you can also take 1024 or 2048 bits
			KeyPair kp=kpg.genKeyPair();
			PublicKey publi=kp.getPublic();
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publi);
			byte[]src=srci.getBytes();//converting source data into byte array
			byte[] cipherData = cipher.doFinal(src);//use this method to finally encrypt data
			String srco=new String(cipherData);//converting byte array into string
			System.out.println();
			System.out.println("Encrypted data is:-"+srco);
			PrivateKey privatei=kp.getPrivate();//Generating private key
			Cipher cipheri=Cipher.getInstance("RSA");//Intializing 2nd instance of Cipher class	
			cipheri.init(Cipher.DECRYPT_MODE, privatei);//Setting to decrypt_mode
			byte[] cipherDat = cipheri.doFinal(cipherData);//Finally decrypting data
			String decryptdata=new String(cipherDat);
			System.out.println("Decrypted data:-"+decryptdata);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
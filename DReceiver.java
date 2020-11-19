import java.net.*;  
public class DReciever
{  
	public static void main(String[] args) throws Exception 
	{  
		byte[] buf = new byte[1024];
		System.out.println("Receiver");  
		DatagramSocket ds = new DatagramSocket(3000);  

		while(true)
		{
			DatagramPacket dp = new DatagramPacket(buf, 1024);  
			ds.receive(dp);  
			String msg = new String(dp.getData(), 0, dp.getLength());  
			System.out.println(msg);  
		} 
	}  
}  
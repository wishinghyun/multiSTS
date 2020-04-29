package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

//IP를 표현하기 위한 객체
public class InetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName(args[0]);
			System.out.println("ia.getHostName()=>"+ia.getHostName());
			System.out.println("ia.getHostAddress()=>"+ia.getHostAddress());
			//InetAddress.getLocalHost()는 static이므로 클래스에서 호출한다
			System.out.println("InetAddress.getLocalHost()=>"+
												InetAddress.getLocalHost());
			
			InetAddress[] ialist = InetAddress.getAllByName(args[0]);
			for (int i = 0; i < ialist.length; i++) {
				System.out.println("ia.getHostName()=>"+
											ialist[i].getHostName());
				System.out.println("ia.getHostAddress()=>"+
											ialist[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}

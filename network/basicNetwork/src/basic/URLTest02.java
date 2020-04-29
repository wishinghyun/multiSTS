package basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest02 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			URL url = new URL("http://cafefiles.naver.net/20120209_226/pododumok_13287752996753FNE4_jpg/%C0%E5%B5%BF%B0%C7_5_pododumok.jpg");
			
			//BufferedInputStream으로 읽어서
			//FileOutputStream으로 copy
			BufferedInputStream bis = 
					new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/image/jangImg.jpg");
			while(true) {
				int data_byte = bis.read();
				if(data_byte==-1) {
					break;
				}
				fos.write(data_byte);
			}
		} catch (MalformedURLException e) {//내가 입력한 주소의 형식이 잘못됐을때 발생하는 에러
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fos!=null)fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

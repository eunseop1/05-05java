package kr.human.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		//서버에 접속하는 클라이언트를 만들자
		Socket client = null;
		
		try {
			// 1.IP주소와 포트번호를 이용하여 서버에 접속
			client = new Socket("127.0.0.1", 10004);
			System.out.println("연결성공 : " + client);
			
			//2.통신 한다
			//3.연결되면 클라이언트로부터 정보를 보내고 받는다
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			//보내기
			PrintWriter pw = new PrintWriter(os);
			pw.write("반갑다 서버야!\n");
			pw.flush();
			//받기
			Scanner sc = new Scanner(is);
			System.out.println("받는 내용 : " + sc.nextLine());

			sc.close();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

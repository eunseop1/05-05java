package kr.human.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) {
		//서버
		ServerSocket sSocket = null;
		Socket client = null;
		
		try {
			//1.포트번호를 인수로 서버를 시작
			sSocket = new ServerSocket(10004);
			System.out.println("127.0.0.1의 10004번 포트를 열어 서버를 시작!");
			
			//2.클라이언트의 요청을 무한 대기
			System.out.println("클라이언트의 접속을 기다립니다");
			client = sSocket.accept();
			System.out.println("연결 성공 : " + client);
			
			//3.연결되면 클라이언트로부터 정보를 받고 보낸다
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			//받기
			Scanner sc = new Scanner(is);
			System.out.println("받는 내용 : " + sc.nextLine());
			//보내기
			PrintWriter pw = new PrintWriter(os);
			pw.write("반갑다 클라이언트!\n");
			pw.flush();
			
			pw.close();
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//4.닫기
				client.close();
				sSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

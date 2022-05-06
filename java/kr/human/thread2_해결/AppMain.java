package kr.human.thread2_해결;

public class AppMain {
	public static void main(String[] args) {
		// 32에서는 답이 바로 나오지만 64비트에서는 무한루프에 빠진다
		// 원주율 계산이 true가 되서 출력이 되야하지만 print에 문제가 생긴것이다.
		
		SharedArea sharedArea = new SharedArea();
		
		CalcThread thread1 = new CalcThread();
		thread1.setSharedArea(sharedArea);
		
		PrintThread thread2 = new PrintThread();
		thread2.setSharedArea(sharedArea);
		
		thread1.start();
		thread2.start();
	}
}

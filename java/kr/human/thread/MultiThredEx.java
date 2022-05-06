package kr.human.thread;

import javax.swing.JOptionPane;

// 멀티스레드 : 프로세스 내에 실행 흐름이 여러개인 프로그램!!!. 모든 스레드가 종료해야 프로그램 종료
public class MultiThredEx {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println(i);
					try {
						Thread.sleep(500); //0.5초 쉰다
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start(); // 스레드 객체를 만들어 실행 -> CPU가 무한 대기하지 않고 동시에 실행
		
		String name = JOptionPane.showInputDialog("이름이 뭐니?");
		JOptionPane.showMessageDialog(null, name + "씨, 반갑습니다!");
		
		
		
	}
}

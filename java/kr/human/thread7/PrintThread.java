package kr.human.thread7;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 소비자 스레드 : 공유 영역의 데이터를 소모하는 스레드-> 결과를 출력해준다
@NoArgsConstructor
@Getter
@Setter
public class PrintThread extends Thread {
    private SharedArea sharedArea;
    public void run() {
    	if(!sharedArea.isReady()) {
    		try {
    			synchronized (sharedArea) {
    				sharedArea.wait();//wait 메서드는 반드시 동기화 블록으로 감싸줘야한다 -> 안하면 예외발생
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //스레드를 대기상태로 만든다
    	}
        System.out.println(sharedArea.getResult());
    }
}

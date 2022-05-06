package kr.human.thread2_해결;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 소비자 스레드 : 공유 영역의 데이터를 소모하는 스레드-> 결과를 출력해준다
@NoArgsConstructor
@Getter
@Setter
public class PrintThread extends Thread {
    private volatile SharedArea sharedArea;
    public void run() {
    	
    	//반복문 안에서 isReady값이 변경되지 않는다 -> 자바 컴파일러는 알아서 무한루프로 변경해서 컴파일한다
    	
    	// 그러나 나는 반복문 내에서 isReady값이 변경되지 않지만 
    	// 외부에서 변경되어 종료되는 프로그램으로 하고 싶다 
    	//-> 이럴때 컴파일러에게 제멋대로 해석하지 말라고 지정해줘야 한다
    	//이때 사용하는 지시어가 "volatile"이다
    	
    	//계산이 완료되기 전까지는 헛돌기를 한다
    	while(sharedArea.isReady() != true){
    		continue;
    	}
    	
        System.out.println(sharedArea.getResult());
    }
}

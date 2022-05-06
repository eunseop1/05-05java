package kr.human.thread2_해결;

import lombok.Data;

// 두개의 스레드가 데이터를 공유하는 클래스 -> 데이터를 공유하면 문제가 발생한다
@Data
public class SharedArea {
    private double result;
    private boolean Ready; // 계산완료 유무 나타내는 변수
}

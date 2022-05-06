package kr.human.thread6;

// 공유영역 : 은행의 모든 계좌 정보
public class SharedArea {
    Account account1;   // 1번 계좌
    Account account2;   // 2번 계좌
    
    //계좌를 처리하는 내용은 여기에 있는게 더 효율적이다
    /*
    public void getTotal() {
    	synchronized (this) {
    		int sum = account1.balance + account2.balance;
    		System.out.println("계좌 합계 : " + sum);
    	}
    }
    
    public void transper() {
    	for (int cnt = 0; cnt < 12; cnt ++) {
    		synchronized (this) {
    			//동기화 블록 : 작업전환이 이루어 지지 말라
    			
    			//이 단락은 반드시 한 블록으로 작동해야 하는 ciritical section
    			account1.withdraw(1000000);
    			System.out.print("이몽룡 계좌에서 1000000원 출금");
    			// 이분에서 작업 전환이 이루어지면 잔액이 29000000원 된다.
    			account2.deposit(1000000);
    			System.out.println("성춘향 계좌에 1000000원 입금");
    		}
    	}
    	
    }
    */
    //위의 두개 메서드를 보면 메서드 내용 전체가 동기화 블록이다
    //동기화 블록보다는 동기화 메서드로 만드는것이 더 효과적이다
    //메서드 선언시 synchronized 예약어를 쓰면 동기화 메서드가 된다
    public synchronized void getTotal() {
    	
    	int sum = account1.balance + account2.balance;
    	System.out.println("계좌 합계 : " + sum);
    	
    }
    public synchronized void transper() {
    	for (int cnt = 0; cnt < 12; cnt ++) {
    		
    		//동기화 블록 : 작업전환이 이루어 지지 말라
    		
    		//이 단락은 반드시 한 블록으로 작동해야 하는 ciritical section
    		account1.withdraw(1000000);
    		System.out.print("이몽룡 계좌에서 1000000원 출금");
    		// 이분에서 작업 전환이 이루어지면 잔액이 29000000원 된다.
    		account2.deposit(1000000);
    		System.out.println("성춘향 계좌에 1000000원 입금");
    		
    	}
    }
}
     

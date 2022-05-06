package kr.human.selenium;

import java.io.File;import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Selenium 4는 Chrome v75이상과 호환 
// Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.
// log4j는 최근 취약점 때문에 말이 많다. 쓰지 않는게 좋다
public class Ex02 {
	public static void main(String[] args) {
		// 1. 웹드라이버의 경로를 지정해 준다.
		System.setProperty("webdriver.chrome.driver", 
				new File("src/main/resources/chromedriver.exe").getAbsolutePath());
		
		// 2. Selenium으로 브라우져 열기
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		//원하는 주소로 이동
		driver.get("https://www.naver.com");
		//브라우저를 최대화 시켜보자
		driver.manage().window().maximize();
		//암시적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); //0.5초 대기
		
		// name 속성의 값이 query인 요소를 찾는다 (네이버 검색창의 아이디 값이다)
		//driver는 웹과 동의어라 생각하자
		WebElement searchBox = driver.findElement(By.name("query"));
		// 문자열을 보낸다 -> 검색창에 글자가 써진다
		searchBox.sendKeys("Selenium");
		
		//검색 버튼 찾기 (name은 없고 아이디만 존재하기에 아이디로 찾자)
		WebElement searchBtn = driver.findElement(By.id("search_btn"));
		//버튼을 클릭해줘야 한다
		searchBtn.click();
		
		//결과가 화면에 나올때까지 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		
		String title = driver.getTitle();
		System.out.println("제목 : " + title);
		
		System.out.println(driver.findElement(By.id("nx_query")).getAttribute("placeholder"));
		
		
		// 3. Selenium으로 브라우져 닫기
		driver.quit();
	}
}

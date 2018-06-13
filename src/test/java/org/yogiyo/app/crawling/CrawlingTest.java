package org.yogiyo.app.crawling;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CrawlingTest {

	private WebDriver driver;
    
	@Before(value="mainTest")
    public void setUp()throws Exception{
        System.setProperty("webdriver.chrome.driver", "/Yogiyo/src/test/resources/driver/chromedriver"); // �ٿ���� ChromeDriver ��ġ�� �־��ݴϴ�.
        driver = new ChromeDriver(); // Driver ����
    }
    @After(value="mainTest")
    public void tearDown()throws Exception{
        driver.quit();  // Driver ����
    }
	@Test
	public void mainTest() throws Exception{
		System.out.println("�׽�Ʈ");
	}
	


}

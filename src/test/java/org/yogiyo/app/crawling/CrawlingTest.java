package org.yogiyo.app.crawling;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;





public class CrawlingTest {

	private WebDriver driver;
	private String baseURL = "https://www.yogiyo.co.kr/api/v1/";
    
	@Before(value="mainTest")
    public void setUp()throws Exception{
        System.setProperty("webdriver.chrome.driver", "/Yogiyo/src/test/resources/driver/chromedriver"); // 다운받은 ChromeDriver 위치를 넣어줍니다.
        driver = new ChromeDriver(); // Driver 생성
    }
    @After(value="mainTest")
    public void tearDown()throws Exception{
        driver.quit();  // Driver 종료
    }
	@Test
	public void mainTest() throws Exception{
	/*	System.out.println("테스트");*/
		
		Document doc = Jsoup.connect(baseURL+"restaurants-geo/")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36")
				.header("Accept", "application/json")
				.header("X-ApiKey", "iphoneap")
				.header("X-ApiSecret","fe5183cc3dea12bd0ce299cf110a75a2")
				.header("X-MOD-SBB-CTYPE", "xhr")
				
				.data("items","20")
				.data("order","rank")
				.data("page","0")
				.data("search","")
				.data("zip_code","415060")
				.ignoreContentType(true)
				.get();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		String jsonText =doc.text();
		jsonObject = (JSONObject) jsonParser.parse(jsonText);
		System.out.println(jsonObject);
		
		
	}
	


}

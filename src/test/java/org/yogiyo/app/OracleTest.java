package org.yogiyo.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;



public class OracleTest {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1522:orcl1";
	private static final String USER="admin";
	private static final String PW="1234";
	
	@Test
	public void TestOracle()throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("성공");
			System.out.println(con);
		}catch(Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		
	}
	
}

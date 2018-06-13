package org.yogiyo.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlTest {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://13.125.162.53:6060/YOGIYO_COPY?autoReconnection=true";
	private static final String USER="root";
	private static final String PW="0000";
	
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

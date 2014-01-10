package fr.ekito.windchill.part.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import wt.fc.QueryResult;
import wt.method.RemoteMethodServer;
import wt.util.WTException;

public class PartServiceIT {

	private static final String WT_USERNAME = "wt.admin.username";
	private static final String WT_PASSWORD = "wt.admin.password";

	private RemoteMethodServer remotemethodserver;

	@Before
	public void init() {

		try {
			InputStream propsStream = PartServiceIT.class.getClassLoader()
					.getResourceAsStream("connection-parameters.properties");
			Properties props = new Properties();
			props.load(propsStream);

			String wtUsername = props.getProperty(WT_USERNAME);
			String wtPassword = props.getProperty(WT_PASSWORD);

			remotemethodserver = RemoteMethodServer.getDefault();
			remotemethodserver.setUserName(wtUsername);
			remotemethodserver.setPassword(wtPassword);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testFindByNumber() {

		QueryResult result = null;
		try {
			System.out.println("testing PartQueryService.findByNumber()");
			result = PartQueryHelper.service.findByNumber("%");
			System.out.println("Result size : " + result.size());

		} catch (WTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(result);
	}

}

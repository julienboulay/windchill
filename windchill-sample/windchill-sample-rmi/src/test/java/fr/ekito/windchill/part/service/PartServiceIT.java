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

	private RemoteMethodServer remotemethodserver;

	@Before
	public void init() {

		remotemethodserver = RemoteMethodServer.getDefault();
		remotemethodserver.setUserName("wcadmin");
		remotemethodserver.setPassword("wcadmin");
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

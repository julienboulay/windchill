package fr.ekito.windchill.part.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import wt.fc.QueryResult;
import wt.method.RemoteMethodServer;
import wt.util.WTException;

public class PartServiceIT {

	private static RemoteMethodServer remotemethodserver;

	@BeforeClass
	public static void init() {

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
			e.printStackTrace();
		}
		Assert.assertNotNull(result);
	}

}

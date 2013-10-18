package fr.ekito.windchill.sample.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wt.httpgw.GatewayAuthenticator;
import wt.method.RemoteMethodServer;

public class HelloWorldIT {

	private static final String WT_HOST = "wt.host";
	private static final String WT_WEBAPP_NAME = "wt.webapp.name";
	private static final String WT_ADMIN_USERNAME = "wt.admin.username";
	private static final String WT_ADMIN_PASSWORD = "wt.admin.password";
	
	private RemoteMethodServer remotemethodserver;

	@Before
	public void init() {

		try {
			 InputStream propsStream = HelloWorldIT.class.getClassLoader().getResourceAsStream("helloworld.properties");
			 Properties props = new Properties();
			 props.load(propsStream);
			 
			 String wtHost = props.getProperty(WT_HOST);
			 String wtWebappName = props.getProperty(WT_WEBAPP_NAME);
			 String wtUsername = props.getProperty(WT_ADMIN_USERNAME);
			 String wtPassword = props.getProperty(WT_ADMIN_PASSWORD);
			 
			remotemethodserver = RemoteMethodServer.getInstance(new URL("http://" + wtHost + "/" + wtWebappName + "/"));
			remotemethodserver.setUserName(wtUsername);
			remotemethodserver.setPassword(wtPassword);
			
			GatewayAuthenticator gatewayAuth = new GatewayAuthenticator();
			gatewayAuth.setRemoteUser(wtUsername);
			remotemethodserver.setAuthenticator(gatewayAuth);
			

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testSayHello() {
		
		String helloMessage = null;
		try {
			helloMessage = (String) remotemethodserver.invoke("sayHello", HelloWorldService.class.getName(), null, null, null);
			System.out.println(helloMessage);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(helloMessage);
	}

}

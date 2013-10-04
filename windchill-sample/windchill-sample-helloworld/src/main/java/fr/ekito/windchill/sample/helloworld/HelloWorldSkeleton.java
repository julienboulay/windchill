package fr.ekito.windchill.sample.helloworld;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import wt.method.RemoteAccess;
import wt.method.RemoteMethodServer;
import wt.org.WTPrincipal;
import wt.session.SessionHelper;
import wt.util.WTException;

public class HelloWorldSkeleton {


	public static class HelloWorldService implements RemoteAccess
	{
		public static String sayHello() throws WTException
		{
			WTPrincipal principal = SessionHelper.getPrincipal();
			String helloMessage = "Hi " + principal.getName() + ", welcome to your windchill server powered by " + principal.getOrganization();
			System.out.println(helloMessage);
			return helloMessage;

		}
	}

	public String sayHello(String user, String password) {

		String helloMessage = "none";
		try {
			RemoteMethodServer remotemethodserver = RemoteMethodServer.getInstance(new URL("http://ekito-srv01.ekito.fr/Windchill/"));
			remotemethodserver.setUserName(user);
			remotemethodserver.setPassword(password);

			//		Class argTypes[] = {String.class, String.class};//add all remote method parameter data types
			//		Object argValues[] = {"param_1_value", "param_2_value"};//respective data value


			helloMessage = (String) remotemethodserver.invoke("sayHello", HelloWorldService.class.getName(), null, null, null);
			System.out.println(helloMessage);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return helloMessage;

	}
}

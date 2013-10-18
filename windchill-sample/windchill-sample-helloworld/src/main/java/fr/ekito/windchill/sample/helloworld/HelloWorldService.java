package fr.ekito.windchill.sample.helloworld;

import wt.method.RemoteAccess;
import wt.org.WTPrincipal;
import wt.session.SessionHelper;
import wt.util.WTException;

public class HelloWorldService implements RemoteAccess{

		public static String sayHello() throws WTException
		{
			WTPrincipal principal = SessionHelper.getPrincipal();
			String helloMessage = "Hi " + principal.getName() + ", welcome on this windchill service powered by Ekito.";
			System.out.println(helloMessage);
			return helloMessage;

		}
}

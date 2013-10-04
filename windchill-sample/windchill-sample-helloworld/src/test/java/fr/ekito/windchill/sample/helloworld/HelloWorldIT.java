package fr.ekito.windchill.sample.helloworld;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldIT {

	@Test
	public void testSayHello() {
		HelloWorldSkeleton hw = new HelloWorldSkeleton();
		hw.sayHello("wcadmin", "wcadmin");
	}

}

package main;

import com.beust.testng.TestNG;

@SuppressWarnings("deprecation")
public class Main {

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
         TestNG testng = new TestNG();
         Class[] classes = new Class[]{TestSuite1.class};
         testng.setTestClasses(classes);
         testng.run();

    }
}
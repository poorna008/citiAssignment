package com.facebook.www.runner;		


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
	

@RunWith(JUnitPlatform.class)
@SelectPackages("com.framework.www.Tests")
public class SuiteRunner {

}

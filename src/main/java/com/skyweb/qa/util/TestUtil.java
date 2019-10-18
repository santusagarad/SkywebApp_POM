package com.skyweb.qa.util;

import com.skyweb.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	



public void SwitchToFrame() {
	
	driver.switchTo().defaultContent();
	
}}
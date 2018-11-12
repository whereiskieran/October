package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	// Pre conditions - start with a @Before
	@BeforeSuite // 1
	public void setUp() {
		System.out.println("1, Setup system property for chrome - @BeforeSuite");
	}

	@BeforeTest // 2
	public void login() {
		System.out.println("2, Launch Chrome browser - @BeforeTest");
	}

	@BeforeClass // 3
	public void loginToApp() {
		System.out.println("3, Login to app - @BeforeClass");
	}

	@BeforeMethod // 4
	public void enterURL() {
		System.out.println("4, Enter URL - @BeforeMethod");
	}

	// Test case start with @Test
	@Test // 5
	public void googleTitleTest() {
		System.out.println("5, Google title test - @Test");
	}

	@Test // 5.1
	public void searchTest() {
		System.out.println("5.1, Search test - @Test");
	}

	@Test // 5.2
	public void logoTest() {
		System.out.println("5.2, Logo test - @Test");
	}

	// post conditions start with @After
	@AfterMethod // 6
	public void logOut() {
		System.out.println("6, Log out from app - @AfterMethod");
	}

	@AfterClass // 7
	public void closeBrowser() {
		System.out.println("7, Close browser - @AfterClass");
	}

	@AfterTest // 8
	public void deleteAllCookies() {
		System.out.println("8, Delete all cookies - @AfterTest");
	}

	@AfterSuite // 9
	public void generateTestReport() {
		System.out.println("9, Generate a report - @AfterSuite");
	}

}

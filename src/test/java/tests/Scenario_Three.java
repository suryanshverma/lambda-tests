package tests;

import java.util.function.Function;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

import QListeners.RetryAnalyzer;
import base.Base;

public class Scenario_Three extends Base {
	String simpleform="//a[contains(text(),'Input Form Submit')]";
	String submit="//div[@class='container']//button[@type='submit']";
	private static Function<String, String> input_field = 
	        (field_name) -> String.format("//input[@id='%s']", field_name);
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void test3() {
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.click(simpleform);
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.click(submit);
		page.fill(input_field.apply("name"), "John");
		page.fill(input_field.apply("inputEmail4"), "John@john.com");
		page.fill(input_field.apply("inputPassword4"), "John@john.com");
		page.fill(input_field.apply("company"), "abc");
		page.fill(input_field.apply("websitename"), "xyz");
		page.fill(input_field.apply("inputCity"), "Noida");
		page.fill(input_field.apply("inputAddress1"), "153");
		page.fill(input_field.apply("inputAddress2"), "GR Garden");
		page.fill(input_field.apply("inputState"), "Uttar Pradesh");
		page.fill(input_field.apply("inputZip"), "201009");
		page.click(submit);
		page.isVisible("//p[contains(text(),'Thanks for contacting us, we will get back to you shortly.')]");
		
		
	}
}

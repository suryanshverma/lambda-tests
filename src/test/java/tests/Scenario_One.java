package tests;

import java.util.function.Function;

import org.testng.annotations.Test;

import com.microsoft.playwright.options.LoadState;

import QListeners.RetryAnalyzer;
import base.Base;

public class Scenario_One extends Base{
	String select_simpleform="//a[contains(text(),'Simple Form Demo')]";
	String input_msg="//input[@placeholder='Please enter your Message']";
	String val="WelcometoLambdaTest";
	String get_button = "//button[contains(text(),'Get Checked Value')]";
	private static Function<String, String> message = 
	        (msg) -> String.format("//div[@id=\"user-message\"]/p[contains(text(),'%s')]", msg);
	
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void test1() {
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.click(select_simpleform);
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		String current_url=page.url();
		if(!current_url.contains("simple-form-demo")) {
			System.out.println("Url does not contain expected url: simple-form-demo");
		}
		page.fill(input_msg, val);
		page.click(get_button);
		page.isVisible(message.apply(val));
		
	}
}

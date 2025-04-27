package tests;

import org.testng.annotations.Test;


import com.microsoft.playwright.options.LoadState;

import QListeners.RetryAnalyzer;
import base.Base;

public class Scenario_Two extends Base {
	String sliders="//a[contains(text(),'Drag & Drop Sliders')]";
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void test2() {
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.click(sliders);
		page.waitForLoadState(LoadState.LOAD);
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.evaluate("document.querySelector('#slider3 input[type=range]').value = 95;");
        page.evaluate("document.querySelector('#slider3 input[type=range]').dispatchEvent(new Event('input'));");
        page.isVisible("//div[@id='slider3']//output[contains(text(),'95')]");

		
		
	}
}

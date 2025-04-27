package base;

import java.nio.file.Paths;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;

import setup.PlaywrightFactory;


public class Base {

	PlaywrightFactory pf;
	protected Page page;
	
	@BeforeTest
	@Parameters("bname")
	public void setup(String bname) {
		pf = new PlaywrightFactory();
		page = pf.initBrowser(bname);
		page.context().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
		
		
	}

	@AfterTest
	public void tearDown() {
		String path = System.getProperty("user.dir") + "/tracing/" + System.currentTimeMillis() + ".zip";
		page.context().browser().close();
		page.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get(path)));
	}

}
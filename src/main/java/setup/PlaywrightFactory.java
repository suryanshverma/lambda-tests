package setup;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<APIRequestContext> request = new ThreadLocal<>();
	

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}
	
	public static APIRequestContext getAPIRequestContext() {
		return request.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	public Page initBrowser(String bname) {
       tlPlaywright.set(Playwright.create());
       if (bname.equalsIgnoreCase("chrome")){
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));		
		}
		if (bname.equalsIgnoreCase("firefox")){
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));		
		}
		Path jsonFilePath = Paths.get(System.getProperty("user.dir"), "state.json");
		boolean bool = Files.exists(jsonFilePath);
		System.out.println(bool);
		if (Files.exists(jsonFilePath)) { 
			tlBrowserContext.set(getBrowser().newContext(
					new Browser.NewContextOptions().setStorageStatePath(jsonFilePath)));
		}else {
			tlBrowserContext.set(getBrowser().newContext());
		}
		tlPage.set(getBrowserContext().newPage());
		request.set(getPlaywright().request().newContext());
		getPage().navigate("https://www.lambdatest.com/selenium-playground");
		return getPage();

	}

	/**
	 * take screenshot
	 * 
	 */

	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}

}
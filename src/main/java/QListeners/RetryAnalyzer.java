package QListeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	    private int retryCount = 0;
	    private final int maxRetryCount = 2; // Number of retries
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            System.out.println("Retrying " + result.getName() + " (Retry " + retryCount + ")");
	            return true;
	        }
	        return false;
	    }
}



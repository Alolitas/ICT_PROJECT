import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * @Author: A_dog.fang
 *
 * 页面操作对象driver，前台每个用例继承CallSystemBase
 */
public class CallSystemBase {

    WebDriver driver;
/*
    @DataProvider(name="loginid")
    public Object[][] data(){
        return new Object[][]{{"jscmcc","123456"},{"sz0512","0512sz"}};
    }
*/

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\SeleniumDemo2\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginMovie loginMovie = new LoginMovie(driver);
        //打开网址
        loginMovie.openBrower();
        //输入正确的用户名密码
        loginMovie.login("025001","123456");
        this.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

/*
    @AfterMethod
    public void tearDown() throws InterruptedException {
        PublicUtils.sleepTime(2);
        this.driver.close();
    }
*/

}

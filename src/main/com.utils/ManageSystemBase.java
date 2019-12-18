import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author: A_dog.fang
 *
 * 页面操作对象driver，管理系统每个用例继承ManageSystemBase
 *
 *
 */
public class ManageSystemBase {

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
        LoginMovie loginMovie = new LoginMovie(driver);
        //打开网址
        loginMovie.openBrower();
        //输入正确的用户名密码
        loginMovie.login("jscmcc","123456");
        this.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        PublicUtils.sleepTime(2);
        this.driver.close();
    }

/*    public WebDriver getDriver(){
        return this.driver;
    }*/


}




















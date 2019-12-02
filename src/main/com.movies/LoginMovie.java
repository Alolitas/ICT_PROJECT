import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 *   登录页面逻辑的封装，供业务层测试用例调用
 */

public class LoginMovie extends LoginPage{

    WebDriver driver;
    public static final String url="http://10.32.71.239:18082/am-hosting-web/main.do";

    public  LoginMovie(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

  //打开浏览器地址
    public void openBrower() {
        this.driver.get(url);
    }



    public  void login(String name,String pwd){
        //LoginPage loginPage = new LoginPage(driver);
        //输入用户名
        super.sendUserName(name);
        //输入密码
        super.sendPassWord(pwd);
        //拖动滑块
        super.moveHuaKuai();
        //点击登陆
        super.submitButton();
    }


}

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    WebDriver driver;
    /**
     * 登陆页面元素路径
     */
        //用户名输入框
        public static By user_inbox = By.id("loginName");
        //密码输入框
        public static By pwd_inbox = By.name("loginPassword");
        //滑块
        public static By slide_block = By.xpath("//*[@id=\"slider\"]/div[3]");
        //登陆按钮
        public static By submit_button = By.id("loginSumit");
        //登陆后右上角用户名路径
        public static By is_load = By.className("dropdown J_tabClose");

    //构造方法
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * 登陆页面基本操作封装
     */


    //定位用户名输入框
    public void sendUserName(String username){
        driver.findElement(user_inbox).clear();
        driver.findElement(user_inbox).sendKeys(username);
    }
    //定位密码输入框
    public void sendPassWord(String pwd){
        driver.findElement(pwd_inbox).clear();
        driver.findElement(pwd_inbox).sendKeys(pwd);
    }
    //定位拖动滑块
    public void moveHuaKuai(){
        try {
            Actions actions = new Actions(driver);
            WebElement slidelement = driver.findElement(slide_block);
            int x  = slidelement.getLocation().getX();
            int y = slidelement.getLocation().getY();
            Thread.sleep(3000);
            //定位到滑块并点击——>移动到目标位置——>松开释放鼠标
            actions.clickAndHold(slidelement).moveToElement(slidelement,x+246,y).release().perform();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //定位登陆按钮
    public void submitButton(){

        driver.findElement(submit_button).click();
    }



}




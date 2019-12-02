import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author: A_dog.fang
 *
 * 页面常用方法封装
 */
public class PublicUtils {

    WebDriver driver;
    public PublicUtils(WebDriver driver){
        this.driver = driver;
    }

    //显示等待二次封装
    public  Boolean webElementWait(By locator,int times){
        try{
            new WebDriverWait(driver,times).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //判断指定时间内获取到的页面文本是否是期望的文本
    public Boolean isTextPresent(WebElement element,String textcontent){
        try {
            return element.getText().contains(textcontent);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //select下拉框选择
    public static void selectWhat(WebElement selectelement,String selecttext){
        Select select = new Select(selectelement);
        select.selectByVisibleText(selecttext);
    }

    //自定义等待时间
    public static void sleepTime(int timekey) throws InterruptedException {
        switch (timekey){
            case 0:
                Thread.sleep(1000);
                break;
            case 1:
                Thread.sleep(3000);
                break;
            case 2:
                Thread.sleep(5000);
                break;
            default:
                System.out.println("时间key值错误");
                break;
        }
    }



}

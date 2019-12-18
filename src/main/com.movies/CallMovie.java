import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @Author: A_dog.fang
 * 前台外呼逻辑封装
 */
public class CallMovie extends CallPage{

    WebDriver driver;
    public CallMovie(WebDriver driver){
        super(driver);
        this.driver = driver;
        //元素初始化
        //PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5),this);
    }

    /*点击签入按钮,输入电话号码，点击签入*/
    public void clickqianruBtn(String phonenumber) throws InterruptedException {
        super.qianru.click();
        super.phonenumber.sendKeys(phonenumber);
        PublicUtils.sleepTime(0);
        super.confirm_qianru.click();
    }

    /*点击左侧菜单外呼名单按钮*/
    public void clickWaiHuButton() throws InterruptedException {
        PublicUtils.sleepTime(1);
        super.waihubutton.click();
    }

    /*点击部门任务,点击第一个任务获取*/
    public void clickDepartmentTask() throws InterruptedException {
        super.departmenttask.click();
        PublicUtils.sleepTime(1);
        super.huoqubutton.click();
    }

    /*点击电话小图标拨打*/
    public void clickCallButton(){
        /*//浏览器缩放
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='0.5'");*/
        //切换表单
        driver.switchTo().frame(super.showiframe);
        super.callbutton.click();
    }




}

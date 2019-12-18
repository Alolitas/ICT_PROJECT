import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @Author: A_dog.fang
 */
public class CallPage {

    WebDriver driver;
    public CallPage(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,5),CallPage.class);
    }

    //签入按钮定位
    @FindBy(how = How.ID,id="_checkin")
    @CacheLookup
    public  WebElement qianru;
    //签入电话号码定位
    @FindBy(how = How.ID,id="_pcPhoneNumber")
    @CacheLookup
    public  WebElement phonenumber;
    //签入按钮定位
    @FindBy(how = How.XPATH,xpath = "//*[starts-with(@id,\"layui-layer\")]/div[3]/a[1]")
    @CacheLookup
    public  WebElement confirm_qianru;
    //左侧菜单栏外呼名单按钮
    @FindBy(xpath = "//*[@id=\"_outbound\"]/i/img")
    @CacheLookup
    public WebElement waihubutton;
    //部门任务
    @FindBy(partialLinkText = "部门任务")
    @CacheLookup
    public WebElement departmenttask;
    //获取按钮
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/div/div[1]/div/div/div[2]/div/ul/li/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/div")
    @CacheLookup
    public WebElement huoqubutton;
    //iframe
    @FindBy(xpath = "//*[@id=\"showiframe\"]")
    @CacheLookup
    public WebElement showiframe;
    //小电话图标
    @FindBy(xpath = "//*[@id=\"updateUserInfo\"]/div/div[1]/div[2]/div/i[1]/img")
    @CacheLookup
    public WebElement callbutton;
    //呼叫结果
    @FindBy(id = "callResult")
    @CacheLookup
    public WebElement callresult;
    //备注
    @FindBy(id = "comments")
    @CacheLookup
    public WebElement comments;
    //提交示忙
    @FindBy(xpath = "//*[starts-with(@id,\"div\")]/div[3]/div/button[1]")
    @CacheLookup
    public WebElement shimangbutton;
    //继续拨打
    @FindBy(xpath = "//*[starts-with(@id,\"div\")]/div[3]/div/button[2]")
    @CacheLookup
    public WebElement continuebutton;





}

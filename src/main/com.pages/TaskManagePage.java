import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Author: A_dog.fang
 *
 * 外呼任务管理模块元素路径
 * 元素定位
 */
public class TaskManagePage {

    WebDriver driver;
    public TaskManagePage(WebDriver driver){
        this.driver = driver;
    }

    //上方菜单栏“外呼营销”
    public static By callmarkting = By.xpath("//*[@id=\"tabsholder\"]/div[1]/div[1]/ul/li[1]");
    //左侧“外呼任务管理”
    public static By taskmanage = By.xpath("//*[@id=\"tabsholder\"]/div[2]/div[1]/ul[1]/li[2]/a");
    //任务新增按钮
    public static By taskadd = By.xpath("/html/body/div/div/div/div[2]/div[1]/button[1]");
    //外呼任务页面表单
    public static By taskmangeframe = By.xpath("//*[@id=\"content-main\"]/iframe[2]");
    //任务新增form
    public static By taskform = By.xpath("//*[@id=\"wizard\"]");
    //任务名称输入框
    public static By taskname = By.id("taskName");
    //开始日期框
    public static By starttime = By.xpath("//*[@id=\"startTime\"]");
    //结束日期时间框
    public static By endtime = By.xpath("//*[@id=\"endTime\"]");
    //是否填写备注框
    public static By iscomments = By.id("comments");
    //任务来源选择框
    public static By taskfrom = By.id("taskFrom");
    //任务类型选择框
    public static By tasktype = By.id("taskType");
    //项目类型选择框
    public static By projecttype = By.id("projectType");
    //业务大类选择框
    public static By projectbigtype = By.id("projectTypeBigType");
    //业务小类选择框
    public static By projectsmalltype = By.id("projectTypeSmallType");
    //短信验证模板引用按钮
    public static By msgmodebutton = By.id("msgModelBind");
    //短信模板动态iframe
    public static By msgmodeframe = By.xpath("//*[starts-with(@id,\"layui-layer-iframe\")]");
    //短信验证复选框
    public static By msgcheckbox = By.id("tempTreeBox_4_check");
    //短信验证确认按钮
    public static By msgmodeconfirm = By.xpath("//*[starts-with(@id,\"layui-layer\")]/div[3]/a[1]");
    //描述
    public static By taskdesc = By.id("taskDesc");
    //下一步按钮
    public static By nextstep = By.linkText("下一步");
    //名单导入模板选择
    public static By tasktemplate = By.id("taskTemplate");
    //浏览
    public static By rosterfile = By.xpath("//*[@id=\"rosterFile\"]");



    public WebElement callMarketing(){
        return driver.findElement(callmarkting);
    }

    public WebElement taskManage(){
        return driver.findElement(taskmanage);
    }

    public WebElement taskAdd(){
        new PublicUtils(driver).webElementWait(taskadd,4);
        return driver.findElement(taskadd);
    }

    public WebElement taskManageFrame(){
        return driver.findElement(taskmangeframe);
    }

    public WebElement taskForm(){
        return driver.findElement(taskform);
    }

    public WebElement taskName(){
        new PublicUtils(driver).webElementWait(taskname,4);
        //form层级定位
        return taskForm().findElement(taskname);
    }

    //使用js定位开始日期控件，并去掉控件的readonly属性
    public WebElement removeStartAttribute() {
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;
        removeAttribute.executeScript("var setDate=document.getElementById(\"startTime\");setDate.removeAttribute('readonly');");
        new PublicUtils(driver).webElementWait(starttime,4);
        WebElement statrtelement = driver.findElement(starttime);
        return statrtelement;
    }

    //使用js定位结束日期控件，并去掉控件的readonly属性
    public WebElement removeEndAttribute() {
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;
        removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
        new PublicUtils(driver).webElementWait(endtime,4);
        WebElement endelement = driver.findElement(endtime);
        return endelement;
    }

    public WebElement isComments(){
        new PublicUtils(driver).webElementWait(iscomments,4);
        return taskForm().findElement(iscomments);
    }

    public WebElement taskFrom(){
        new PublicUtils(driver).webElementWait(taskfrom,4);
        return taskForm().findElement(taskfrom);
    }

    public WebElement taskType(){
        return taskForm().findElement(tasktype);
    }

    public WebElement projectType(){
        return taskForm().findElement(projecttype);
    }

    public WebElement projectBigType(){
        return taskForm().findElement(projectbigtype);
    }

    public WebElement projectSmallType(){
        return taskForm().findElement(projectsmalltype);
    }

    public WebElement msgModeButton(){
        return taskForm().findElement(msgmodebutton);
    }

    public WebElement msgModeFrame(){
        return driver.findElement(msgmodeframe);
    }

    public WebElement msgCheckBoxs(){
        new PublicUtils(driver).webElementWait(msgcheckbox,4);
        return driver.findElement(msgcheckbox);
    }

    public WebElement msgModeConfirm(){
        return driver.findElement(msgmodeconfirm);
    }

    public WebElement taskDesc(){
        return taskForm().findElement(taskdesc);
    }

    public WebElement nextStep(){
        return taskForm().findElement(nextstep);
    }

    public WebElement taskTemplate(){
        return taskForm().findElement(tasktemplate);
    }

    public WebElement rosterFile(){
        return taskForm().findElement(rosterfile);
    }

}

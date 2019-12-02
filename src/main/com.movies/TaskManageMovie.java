import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * @Author: A_dog.fang
 *
 *外呼任务管理逻辑封装
 */
public class TaskManageMovie extends TaskManagePage{

    WebDriver driver;
    public TaskManageMovie(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    /*点击营销外呼-->外呼任务管理*/
    public void clickTaskManage(){
        super.callMarketing().click();
        super.taskManage().click();
    }

    /*点击新增按钮*/
    public void clickTaskAdd() throws InterruptedException {
        //切换表单
        driver.switchTo().frame(super.taskManageFrame());
        PublicUtils.sleepTime(0);
        //点击新增
        super.taskAdd().click();
    }

    /*输入任务名称*/
    public void sendTaskName(String tasknames) throws InterruptedException {
        PublicUtils.sleepTime(0);
        super.taskName().sendKeys(tasknames);
    }

    /*选择开始结束时间*/
    public void selectTaskTime(String starttime,String endtime) throws InterruptedException {
        super.removeStartAttribute().click();
        PublicUtils.sleepTime(0);
        super.removeStartAttribute().sendKeys(starttime);
        PublicUtils.sleepTime(0);
        super.removeEndAttribute().sendKeys(endtime);
    }

    /*选择是否填写备注*/
    public void selectTaskComments(String comments){
        //new一个select对象
        PublicUtils.selectWhat(super.isComments(),comments);
    }

    /*选择任务来源*/
    public void selectTaskFrom(String taskfromname){
        PublicUtils.selectWhat(super.taskFrom(),taskfromname);
    }

    /*选择任务类型*/
    public void selectTaskType(String tasktypename){
        PublicUtils.selectWhat(super.taskType(),tasktypename);
    }

    /*选择项目类型*/
    public void selectProjectType(String projecttypename){
        PublicUtils.selectWhat(super.projectType(),projecttypename);
    }

    /*选择业务大类*/
    public void selectProjectBigType(String projectbigtypename){
        PublicUtils.selectWhat(super.projectBigType(),projectbigtypename);
    }

    /*选择业务小类*/
    public void selectProjectSmallType(String projectsmallname){
        PublicUtils.selectWhat(super.projectSmallType(),projectsmallname);
    }

    /*点击短信验证模板的引用按钮*/
    public void clickMsgModeButton(){
        super.msgModeButton().click();
    }

    /*选择短信验证模板*/
    public void selectMsgMode() throws InterruptedException {
        driver.switchTo().parentFrame();
        driver.switchTo().frame(super.msgModeFrame());
        PublicUtils.sleepTime(0);
        super.msgCheckBoxs().click();
    }

    /*点击短信模板确认按钮选择*/
    public void clickMsgConfirm() throws InterruptedException {
        PublicUtils.sleepTime(0);
        driver.switchTo().parentFrame();
        super.msgModeConfirm().click();
    }

    /*描述*/
    public void sendTaskDesc(String taskdesctext){
        driver.switchTo().frame(taskManageFrame());
        super.taskDesc().sendKeys(taskdesctext);
    }

    /*点击下一步*/
    public void clickNextStep(){
        super.nextStep().click();
    }

    /*选择名单模板*/
    public void selectTaskTemplate(String taskTemplateName){
        PublicUtils.selectWhat(super.taskTemplate(),taskTemplateName);
    }

    /*点击浏览*/
    public void clickRosterFile() throws IOException, InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(super.rosterFile());
        PublicUtils.sleepTime(2);
        //super.rosterFile().click();
        Runtime.getRuntime().exec("E:\\rosterfile.exe");
    }

}

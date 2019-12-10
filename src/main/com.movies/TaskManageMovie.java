import org.openqa.selenium.WebDriver;

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
    public void selectTaskTime(String starttime,String endtime) throws InterruptedException, IOException {
        super.removeStartAttribute().click();
        PublicUtils.sleepTime(0);
        super.removeStartAttribute().sendKeys(starttime);
        //对开始日期与当前日期进行判断
        new PublicUtils(driver).dataAssert(starttime);
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

    /*点击基本信息下一步按钮*/
    public void clickFirstNextStep(){
        super.firstNextStep().click();
    }

    /*选择名单模板*/
    public void selectTaskTemplate(String taskTemplateName){
        PublicUtils.selectWhat(super.taskTemplate(),taskTemplateName);
    }

    /*点击浏览上传模板*/
    public void clickRosterFile(String filepath) throws IOException, InterruptedException {
        super.rosterFile().sendKeys(filepath);
        PublicUtils.sleepTime(2);
    }

    /*点击名称匹配*/
    public void clickNameMatch(){
        super.nameMatch().click();
    }

    /*点击名单导入下一步按钮*/
    public void clickSecondNextStep(){
        super.secondNextStep().click();
    }

    /*点击确认导入按钮*/
    public void clickConfirmImportBtn(){
        //表单切换
        driver.switchTo().defaultContent();
        super.confirmImport().click();
    }

    /*点击导入成功确认按钮*/
    public void clickConfirmImportSecussBtn() throws InterruptedException {
        driver.switchTo().defaultContent();
        PublicUtils.sleepTime(1);
        super.confirmImportSucess().click();
    }

    /*点击问卷配置的引用按钮*/
    public void clickReferQnaieBtn(){
        driver.switchTo().frame(taskManageFrame());
        super.referQnaire().click();
    }

    /*选择第一个问卷并确定*/
    public void selectFirstQnair() throws InterruptedException {
        //切换表单
        //driver.switchTo().parentFrame();
        driver.switchTo().frame(super.qnairFrame());
        PublicUtils.sleepTime(0);
        super.qnairCheckBox().click();
        super.qnairConfirm().click();
    }

    /*问卷配置点击下一步*/
    public void clickThirdNextStep(){
        driver.switchTo().parentFrame();
        super.thirdNextStep().click();
    }

    /*点击自动分配*/
    public void clickAutoDistribute(){
        super.autoDistribute().click();
    }

    /*选择按厅分配,完成分配*/
    public void selectHallNoSecuss() throws InterruptedException {
        driver.switchTo().parentFrame();
        driver.switchTo().frame(super.autoDistributeFrame());
        PublicUtils.sleepTime(0);
        super.hallNoCheckBox().click();
        PublicUtils.sleepTime(0);
        super.distributeToHallNo().click();
        driver.switchTo().defaultContent();
        super.distributeSecussConfirm().click();
    }
}

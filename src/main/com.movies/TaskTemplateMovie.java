import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

/**
 * @Author: A_dog.fang
 *
 * 任务名单模板逻辑封装
 */

public class TaskTemplateMovie extends TaskTemplatePage{

    WebDriver driver;

    public  TaskTemplateMovie(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    /*点击营销外呼--->任务名单模板*/
    public void clickTemplateMenu(){
        //TaskTemplatePage taskTemplatePage = new TaskTemplatePage(driver);
        //点击营销外呼
        super.callMarketing().click();
        //点击任务名单模板
        super.taskTemplate().click();
    }

    /*点击新增按钮*/
    public void clickAdd(){
        //切换表单
        driver.switchTo().frame(super.iframe1());
        //点击新增
        super.templateAdd().click();
        //driver控制权转交给父级
        driver.switchTo().parentFrame();
    }

    /*新增任务模板操作*/
    public void newTemplate(String templatename,String templateinfo){
        //切换新增页面表单
        driver.switchTo().frame(super.iframe2());
        //输入模板名称
        super.inputName().sendKeys(templatename);
        //输入模板描述信息
        super.inputInfo().sendKeys(templateinfo);
    }

    /*点击扩展按钮*/
    public void clickExtendBtn(){
        super.buttonExtrnd().click();
    }

    /*点击保存按钮*/
    public void clickSaveBtn(){
        super.buttonSave().click();
    }

    /*需要修改第几行的页面标签名称*/
    public void modifyPageLabel(int index,String labelname) throws InterruptedException {
        //先清空扩展行的默认内容
        super.labelPage(index).clear();
        //选择标签行数重命名
        Thread.sleep(200);
        super.labelPage(index).sendKeys(labelname);
    }

    /*判断复选框是否选中，未选中则选中*/
    public void checkBoxSelect(){
        List<WebElement> list = driver.findElements(labelcheckboxs);
        for (WebElement checklist:list
             ) {
            boolean flag = checklist.isSelected();
            if(flag == false){
                checklist.click();
            }else {continue;}
        }
    }

    /*点击批量扩展按钮-->输入扩展个数*/
    public void clickManyExtend(String extendnum){
        super.buttonManyExtend().click();
        //跳出新增页面的iframe
        driver.switchTo().defaultContent();
        super.numExtendInput().sendKeys(extendnum);
    }

    /*点击批量扩展确认按钮*/
    public void clickConfirm(){
        super.confirmExtend().click();
        driver.switchTo().frame(super.iframe2());
    }

    /*不勾选点击修改按钮，判断弹框显示文字是否是预期的*/
    public void clickUpdateButton(){
        //切换表单
        driver.switchTo().frame(super.iframe1());
        //点击修改按钮
        super.buttonUpdate().click();
        //跳出表单
        driver.switchTo().defaultContent();
        //调用isTextPresent方法判断获取文字是否和预期一样
        PublicUtils publicUtils = new PublicUtils(driver);
        publicUtils.isTextPresent(super.warn_Update(),"请选择需要修改的模板信息");
    }

    /*选一个模板前的复选框点击*/
    public void clickTemplateCheckBoxs(){
        //切换表单
        driver.switchTo().frame(super.iframe1());
        List<WebElement> list = driver.findElements(templatecheckboxs);
        //生成0~9的随机数
        int min = 0;
        int max = 10;
        int randomindex = new Random().nextInt(max - min) + min;
        //随机点击一个复选框
        WebElement checkboxElement = list.get(randomindex);
        checkboxElement.click();
    }

    /*点击删除按钮*/
    public void clickDeleteButton(){
        super.buttonDelete().click();
    }

    /*点击删除提示框的确认按钮,引用模板无法删除的提示和删除成功的提示信息断言*/
    public void clickDelConfirm(){
        //表单跳出
        driver.switchTo().defaultContent();
        //点击确认
        super.buttonDelConfirm().click();
        //抓取提示框文字
        String deltext = super.warn_Delete().getText();
        if(deltext.equals("引用模板不能删！")){
            return;
        }else if (deltext.equals("删除成功")){
            return;
        }else {
            System.out.println("提示信息不正确");
        }
    }


}

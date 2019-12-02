import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * @Author: A_dog.fang
 *
 * @role: 任务名单模板元素路径
 *        基本操作步骤
 */
public class TaskTemplatePage {

    WebDriver driver;
    //上方菜单栏“外呼营销”定位
    public static By callmarkting = By.xpath("//*[@id=\"tabsholder\"]/div[1]/div[1]/ul/li[1]");
    //左侧 “任务名单模板” 菜单栏路径
    public static By templatemenu = By.xpath("//*[@id=\"tabsholder\"]/div[2]/div[1]/ul[1]/li[1]/a");
    //新增按钮
    public  static By newbutton = By.id("add_button");
    //修改按钮
    public  static By updatebutton = By.id("update_button");
    //删除按钮
    public static By delbutton = By.id("del_button");
    //查看按钮
    public static By viewbutton = By.xpath("//*[@id=\"del_button\"]");
    //查询按钮
    public static By lookbutton = By.xpath("/html/body/div/div/div/div[1]/div/div[2]/button[1]");
    //重置按钮
    public static By resetbutton = By.id("resetBtn");
    //模板名称搜索框
    public static By searchbox = By.id("templateName");
    //模板名称多选框元素
    public static By checkbox = By.xpath("//*[@name=\"checkbox_mainGrid\"]");
    //表单路径
    public static By iframexpath1 = By.xpath("//*[@id=\"content-main\"]/iframe[2]");
    //新增页面动态表单
    public static By iframexpath2 = By.xpath("//*[starts-with(@id,\"layui-layer-iframe\")]");
    //新增模板名称输入框
    public static By nameinput = By.id("templateName");
    //新增模板描述信息
    public static By infoinput = By.id("templateDesc");
    //扩展按钮
    public static By extendbutton = By.xpath("//*[@id=\"addForm\"]/div[2]/div/button[1]");
    //批量扩展按钮
    public static By extendmanybutton = By.xpath("//*[@id=\"addForm\"]/div[2]/div/button[2]");
    //批量扩展个数输入框
    public static By extendnum = By.xpath("/html/body/div[5]/div[2]/input");
    //批量扩展框确认按钮
    public static By extendconfirm = By.xpath("//*[@id=\"layui-layer2\"]/div[3]/a[1]");
    //保存按钮
    public static By savebutton = By.xpath("//*[@id=\"addForm\"]/div[2]/div/button[3]");
    //页面标签列，修改第几行标签就写行数
    public By labelby(int index){
        return By.xpath(String.format("//*[@id=\"addGrid\"]/tbody/tr[%d]/td[2]/input", index));
    }
    //新增模板页面复选框
    public static By labelcheckboxs = By.xpath("//*[@id=\"addForm\"]//tr/td/input[@type=\"checkbox\"]");
    //直接点击修改的弹窗提示信息
    public static By updatewarnning = By.xpath("/html/body/div[3]/div[2]");
    //模板名称前的复选框
    public static By templatecheckboxs =By.xpath("//*[@id=\"mainGrid\"]/tbody/tr/td[1]/input");
    //删除提示框确认按钮
    public static By delconfirm = By.xpath("/html/body/div[3]/div[3]/a[1]");
    //删除模板弹框提示信息
    public static By delwarnning = By.xpath("/html/body/div[3]/div[2]");


    /**
     * 任务名单模板基本操作
     * @return
     */

    //构造方法
    public TaskTemplatePage(WebDriver driver){
        this.driver = driver;
    }

    //定位"外呼营销"菜单
    public WebElement callMarketing(){
        return driver.findElement(callmarkting);
    }

    //定位左侧菜单栏"任务名单模板"
    public WebElement taskTemplate(){
        return driver.findElement(templatemenu);
    }

    //定位"新增"
    public WebElement templateAdd(){
        //元素等待
        new PublicUtils(driver).webElementWait(newbutton,4);
        return driver.findElement(newbutton);
    }

    //将整个iframe当作元素定位
    public WebElement iframe1(){
        return driver.findElement(iframexpath1);
    }
    public WebElement iframe2(){
        return driver.findElement(iframexpath2);
    }

    //模板名称输入框定位
    public  WebElement inputName(){
        new PublicUtils(driver).webElementWait(nameinput,4);
        return driver.findElement(nameinput);
    }

    //模板描述信息输入框定位
    public WebElement inputInfo(){
        new PublicUtils(driver).webElementWait(infoinput,4);
        return driver.findElement(infoinput);
    }

    //扩展按钮定位
    public WebElement buttonExtrnd(){
        return driver.findElement(extendbutton);
    }

    //保存按钮定位
    public WebElement buttonSave(){
        return driver.findElement(savebutton);
    }

    //页面标签列定位
    public WebElement labelPage(int index){
        return driver.findElement(this.labelby(index));
    }
    //批量扩展操作按钮定位
    public WebElement buttonManyExtend(){
        return  driver.findElement(extendmanybutton);
    }
    public WebElement numExtendInput(){
        return driver.findElement(extendnum);
    }
    public WebElement confirmExtend(){
        return driver.findElement(extendconfirm);
    }

    //修改按钮定位
    public WebElement buttonUpdate(){
        return driver.findElement(updatebutton);
    }

    //直接点击修改的弹窗提示定位
    public WebElement warn_Update(){
        new PublicUtils(driver).webElementWait(updatewarnning,4);
        return driver.findElement(updatewarnning);
    }

    //模板名称前复选框定位
/*    public WebElement templateCheckBoxs(){
        return driver.findElement(templatecheckboxs);
    }*/

    //删除按钮定位
    public WebElement buttonDelete(){
        return driver.findElement(delbutton);
    }

    //删除确认按钮定位
    public WebElement buttonDelConfirm(){
        return driver.findElement(delconfirm);
    }

    //删除模板提示信息定位
    public WebElement warn_Delete(){
        new PublicUtils(driver).webElementWait(updatewarnning,4);
        return driver.findElement(delwarnning);
    }

}
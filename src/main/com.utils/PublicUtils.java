import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: A_dog.fang
 *
 * 页面常用方法封装
 */
public class PublicUtils {

    WebDriver driver;
    //WebDriver driver;
    public PublicUtils(WebDriver driver){
        this.driver = driver;
    }

    //显示等待二次封装
    public void webElementWait(int timeoutsecond,By by){
       new WebDriverWait(driver,timeoutsecond).until(ExpectedConditions.presenceOfElementLocated(by));
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

    //判断日期框开始时间是否大于等于当前时间
    public void dataAssert(String startdata) throws IOException, InterruptedException {
        try {
            //将字符串日期格式化
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
            Date date1 = dateformat.parse(startdata);
            //获取当前时间
            Date currentdate = new Date();
            //比较两个日期
            int flag = date1.compareTo(currentdate);
            if(flag==0){
                //如果日期相等，返回
                return;
            }else if(flag>0){
                //小于0，当前日期在输入日期之前
                return;
            }else {
                System.out.println("输入日期小于当前日期，不合法");
                //截图退出
                this.screenShoot();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    //屏幕截图
    public void screenShoot() throws IOException, InterruptedException {
        //转换时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //获取当前时间
        String time = dateFormat.format(Calendar.getInstance().getTime());
        //执行屏幕截取
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        FileUtils.copyFile(srcFile, new File("ScreenPhotos", time + ".png"));
        Thread.sleep(2000);
        driver.quit();
    }



}

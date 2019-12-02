import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: A_dog.fang
 *
 * 外呼任务管理测试用例
 */
public class TaskManageTest extends TestCaseBase{

    /*打开外呼任务管理界面*/
    @Test
    public void taskManageTest(){
        TaskManageMovie taskManageMovie = new TaskManageMovie(driver);
        taskManageMovie.clickTaskManage();
    }

    /*新增一个任务*/
    @Test
    public void newTask() throws InterruptedException, IOException {
        this.taskManageTest();
        TaskManageMovie taskManageMovie = new TaskManageMovie(driver);
        taskManageMovie.clickTaskAdd();
        taskManageMovie.sendTaskName("1125外呼任务");
        taskManageMovie.selectTaskTime("2019-12-06","2019-12-21");
        taskManageMovie.selectTaskComments("是");
        taskManageMovie.selectTaskFrom("掌中店");
        taskManageMovie.selectTaskType("号卡预约");
        taskManageMovie.selectProjectType("营销推广类");
        taskManageMovie.selectProjectBigType("视频");
        taskManageMovie.selectProjectSmallType("任我看/视频会员");
        taskManageMovie.clickMsgModeButton();
        taskManageMovie.selectMsgMode();
        taskManageMovie.clickMsgConfirm();
        taskManageMovie.sendTaskDesc("很长很长很长很长的任务描述，断言字数长度");
        taskManageMovie.clickNextStep();
        taskManageMovie.selectTaskTemplate("默认模板");
        taskManageMovie.clickRosterFile();

    }
}

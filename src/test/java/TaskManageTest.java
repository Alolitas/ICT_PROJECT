import org.testng.annotations.Test;

/**
 * @Author: A_dog.fang
 *
 * 外呼任务管理测试用例
 */
public class TaskManageTest extends ManageSystemBase {

    /*打开外呼任务管理界面*/
    @Test
    public void taskManageTest(){
        TaskManageMovie taskManageMovie = new TaskManageMovie(driver);
        taskManageMovie.clickTaskManage();
    }

    /*新增一个任务*/
    @Test
    public void newTask() throws Exception {
        this.taskManageTest();
        TaskManageMovie taskManageMovie = new TaskManageMovie(driver);
        taskManageMovie.clickTaskAdd();
        taskManageMovie.sendTaskName("1125外呼任务");
        taskManageMovie.selectTaskTime("2019-12-12","2019-12-21");
        taskManageMovie.selectTaskComments("是");
        taskManageMovie.selectTaskFrom("掌中店");
        taskManageMovie.selectTaskType("号卡预约");
        taskManageMovie.selectProjectType("营销推广类");
        taskManageMovie.selectProjectBigType("视频");
        taskManageMovie.selectProjectSmallType("任我看/视频会员");
        taskManageMovie.clickMsgModeButton();
        taskManageMovie.selectMsgMode();
        taskManageMovie.clickMsgConfirm();
        taskManageMovie.sendTaskDesc("很长很长很长很长的任务描述，字数长度");
        taskManageMovie.clickFirstNextStep();
        taskManageMovie.selectTaskTemplate("默认模板");
        taskManageMovie.clickRosterFile("C:\\Users\\Administrator\\Downloads\\外包三.xlsx");
        taskManageMovie.clickNameMatch();
        taskManageMovie.clickSecondNextStep();
        taskManageMovie.clickConfirmImportBtn();
        taskManageMovie.clickConfirmImportSecussBtn();
        taskManageMovie.clickReferQnaieBtn();
        taskManageMovie.selectFirstQnair();
        taskManageMovie.clickThirdNextStep();
        taskManageMovie.clickAutoDistribute();
        taskManageMovie.selectHallNoSecuss();

    }

    /*点击导出按钮，断言是否导出成功提示*/
    @Test
    public void outTaskNames(){
        this.taskManageTest();
        TaskManageMovie taskManageMovie = new TaskManageMovie(driver);
        taskManageMovie.clickOutButton();
    }
}

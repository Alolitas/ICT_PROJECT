import org.testng.annotations.Test;

/**
 * @Author: A_dog.fang
 *
 * 任务名单测试用例
 *
 */
public class TaskTemplateTest extends ManageSystemBase {

    @Test
    public void taskTemplateTest() {
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        //调用TaskTemplateMovie的clickTemplateMenu方法打开任务名单模板
        taskTemplateMovie.clickTemplateMenu();
    }

    /*成功新增一个基础模板*/
    @Test
    public void createTemplateBase(){
        this.taskTemplateTest();
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        //点击新增
        taskTemplateMovie.clickAdd();
        //输入模板名称，描述信息
        taskTemplateMovie.newTemplate("2019外呼测试模板","江苏移动外呼基本模板信息展示");
        //点击保存按钮
        //taskTemplateMovie.clickSaveBtn();
    }

    /*新增一个扩展属性的模板*/
    @Test
    public void ceateTemplateOneExtend() throws InterruptedException {
        this.taskTemplateTest();
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        //新增模板
        taskTemplateMovie.clickAdd();
        taskTemplateMovie.newTemplate("2019外呼测试模板1","江苏移动外呼基本模板信息展示");
        //点击扩展按钮
        taskTemplateMovie.clickExtendBtn();
        //输入需要修改的页面标签行数--->标签重命名
        taskTemplateMovie.modifyPageLabel(5,"套餐类型");
        //勾选复选框
        taskTemplateMovie.checkBoxSelect();
        //点击保存
        taskTemplateMovie.clickSaveBtn();
    }

    /*批量扩展多个标签的模板*/
    @Test
    public void ceateTemplateManyExtend() throws InterruptedException {
        //点击新增-->输入模板名称和描述信息
        this.createTemplateBase();
        //点击批量扩展按钮,输入扩展个数
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        taskTemplateMovie.clickManyExtend("3");
        //点击确认，扩展成功
        taskTemplateMovie.clickConfirm();
        //根据扩展个数修改页面标签名称
        taskTemplateMovie.modifyPageLabel(5,"家庭住址");
        taskTemplateMovie.modifyPageLabel(6,"流量剩余");
        taskTemplateMovie.modifyPageLabel(7,"话费剩余");
        //勾选复选框
        taskTemplateMovie.checkBoxSelect();
        //点击保存
        taskTemplateMovie.clickSaveBtn();
    }

    /*不勾选直接点击修改按钮*/
    @Test
    public void noSelectUpdate(){
        this.taskTemplateTest();
        //直接点击修改按钮-->断言弹框的提示 "请选择需要修改的模板信息"是否符合预期值
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        taskTemplateMovie.clickUpdateButton();
    }

    /*勾选一条或多条模板点击删除-->确认删除-->断言提示框信息是否符合预期*/
    @Test
    public void selectDeleteTemplate(){
        TaskTemplateMovie taskTemplateMovie = new TaskTemplateMovie(driver);
        taskTemplateMovie.clickTemplateCheckBoxs();
//        taskTemplateMovie.clickDeleteButton();
//        taskTemplateMovie.clickDelConfirm();

    }





}

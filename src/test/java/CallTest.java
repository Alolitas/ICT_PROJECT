import org.testng.annotations.Test;

/**
 * @Author: A_dog.fang
 */
public class CallTest extends CallSystemBase{

    @Test
    public void callSystemTest() throws InterruptedException {
        CallMovie callMovie = new CallMovie(driver);
        callMovie.clickqianruBtn("15895806533");
        callMovie.clickWaiHuButton();
        callMovie.clickDepartmentTask();
        callMovie.clickCallButton();
    }
}

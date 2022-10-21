import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/changeProfile.feature",
        plugin = {"pretty", "html:report"})
public class ChangeUserInfo_Run {
}

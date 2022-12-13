package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        //fuse the steps together with glue keyword
        glue = "steps",

        //when you set dryRun to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we reset to false,starts execution again
        dryRun = false,
        tags = "@excel", //use tag to bring up all the test cases that were done in those Sprints
        //to remove irrelevant information from console we need to set monochrome to true
        monochrome=true,
        //pretty keyword prints the steps in the console to increase readability
        plugin = {"pretty"}
)

public class SmokeRunner {

}

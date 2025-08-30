package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
“Funny Guys Tag Parties, Publish Many Dramas.”
Funny → Features
Guys → Glue
Tag → Tags
Parties → Plugin
Publish → Publish
Many → Monochrome
Dramas → DryRun
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {"src/test/resources/features/ScenarioOutline.feature"},
        features = {"src/test/resources/features"},
        //features = {"@target/rerun.txt"},//for failed scenarios
glue = {"stepdefinitions"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/report.json",
                "rerun:target/rerun.txt"
        },
        // extend report u can add with grasshopper
//tags = "@sanity",
        //tags = "@sanity" and not @regression
        //tags = "@sanity" or @regression
        monochrome = true,
        publish = true
)
public class Runner {
}

/*
pretty → nice console output
html → HTML report
json → JSON report
junit → JUnit XML report
rerun → rerun failed tests
timeline → parallel execution timeline
usage → step usage stats
progress → minimal dots output
 */
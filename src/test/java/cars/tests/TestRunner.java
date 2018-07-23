package cars.tests;


import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/cars/features/",
        glue = "cars.steps"
)

public class TestRunner extends AbstractTestNGCucumberTests {




}

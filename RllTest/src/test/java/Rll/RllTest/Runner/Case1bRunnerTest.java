package Rll.RllTest.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"classpath:Rll/RllTest/StepDefinition"},
        features = {"src/test/java/Rll/RllTest/Feature/Case1b.feature"}
)
public class Case1bRunnerTest {}

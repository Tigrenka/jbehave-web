package org.jbehave.web.selenium;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterScenario.Outcome;
import org.jbehave.core.steps.CorrelatedException;

/**
 * WebDriverSteps that save screen-shot upon failure in a scenario outcome.
 * Not all WebDriver implement screen-shot capability
 */
public class WebDriverScreenshotOnFailure extends WebDriverSteps {

    public WebDriverScreenshotOnFailure(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @AfterScenario(uponOutcome = Outcome.FAILURE)
    public void afterScenarioFailure(CorrelatedException failureCorrelation) throws Exception {

        String screenshotPath = "target/jbehave/screenshots/failed-scenario-" + failureCorrelation.getUUID() + ".png";
        if ( driverProvider.saveScreenshotTo(screenshotPath) ){
            System.out.println("Screenshot has been saved to '" + screenshotPath +"'");
        } else {
            System.out.println(driverProvider.get().getClass().getName() + " does not support taking screenshots.");
        }
    }

}
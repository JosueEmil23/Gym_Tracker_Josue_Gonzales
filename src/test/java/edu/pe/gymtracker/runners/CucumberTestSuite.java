package edu.pe.gymtracker.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/exercise.feature")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "edu.pe.gymtracker.stepdefinitions"
)
public class CucumberTestSuite {
}

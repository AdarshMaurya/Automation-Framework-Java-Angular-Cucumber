package com.simonk.gui.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.simonk.gui.configurations.CucumberWorld;
import com.simonk.gui.configurations.springconfig.SpringConfig;
import com.simonk.gui.utility.localisation.LocaleHelper;

import cucumber.api.Scenario;

@ContextConfiguration(classes = SpringConfig.class)
public abstract class AbstractBaseStepDefinition {
	private static final Logger LOG = LogManager.getLogger(AbstractBaseStepDefinition.class);

	protected Scenario scenario;

	@Autowired
	private LocaleHelper localeHelper;

	@Autowired
	private CucumberWorld cucumberWorld;

	public LocaleHelper getLocaleHelper() {
		return localeHelper;
	}

	public CucumberWorld getCucumberWorld() {
		return cucumberWorld;
	}

	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	protected void embedTextInReport(String text) {
		LOG.info("Embedding text into the report");
		scenario.write(text);
	}

}

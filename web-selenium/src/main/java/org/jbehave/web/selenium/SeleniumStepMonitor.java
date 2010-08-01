package org.jbehave.web.selenium;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.jbehave.core.steps.StepMonitor;
import org.jbehave.core.steps.StepType;

import com.thoughtworks.selenium.Selenium;

public class SeleniumStepMonitor implements StepMonitor {

    private final Selenium selenium;
	private final SeleniumContext seleniumContext;
	private final StepMonitor delegate;

	public SeleniumStepMonitor(Selenium selenium,
			SeleniumContext seleniumContext, StepMonitor delegate) {
		this.selenium = selenium;
		this.seleniumContext = seleniumContext;
		this.delegate = delegate;
	}

	public void performing(String step, boolean dryRun){
		String context = seleniumContext.getCurrentScenario() + "<br/>" + step;
		selenium.setContext(context);
		delegate.performing(step, dryRun);
	}

	public void convertedValueOfType(String value, Type type, Object converted,
			Class<?> converterClass) {
		delegate.convertedValueOfType(value, type, converted, converterClass);
	}

	public void stepMatchesType(String stepAsString, String previousAsString,
			boolean matchesType, StepType stepType, Method method, Object stepsInstance){
		delegate.stepMatchesType(stepAsString, previousAsString, matchesType, stepType, method, stepsInstance);		
	}

	public void stepMatchesPattern(String step, boolean matches, String pattern, Method method, Object stepsInstance){
		delegate.stepMatchesPattern(step, matches, pattern, method, stepsInstance);		
	}

	public void foundParameter(String parameter, int position) {
		delegate.foundParameter(parameter, position);		
	}

	public void usingAnnotatedNameForParameter(String name, int position) {
		delegate.usingAnnotatedNameForParameter(name, position);
	}

	public void usingNaturalOrderForParameter(int position) {
		delegate.usingNaturalOrderForParameter(position);
	}

	public void usingParameterNameForParameter(String name, int position) {
		delegate.usingParameterNameForParameter(name, position);
	}

	public void usingTableAnnotatedNameForParameter(String name, int position) {
		delegate.usingTableAnnotatedNameForParameter(name, position);
	}

	public void usingTableParameterNameForParameter(String name, int position) {
		delegate.usingTableParameterNameForParameter(name, position);
	}

}
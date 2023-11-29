package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features={"C:\\Users\\mamid\\Sai-eclipse-work-space\\SeleniumCucumberBDD29Nov_03\\src\\main\\java\\features\\LoginModule.feature"
		},
				glue= {"stepDefinition"},
				tags= {"@run"}
//				format= {"pretty","html:test=output"} //if we want to generate output in test output folder in html 
               //	format= {"pretty","json:json_output/cucumber.json"} 
		
//		format= {"pretty","junit:junit_xml/cucumber.xml"} if we want to generate report in xml
		
//		if we want to generate output in json format in a json file (test report in json format in a json file)
	//we want any folder name 	
		
		
		
		
//				monochrome=true ,//display the console output in a proper readable format
		
//				dryRun=true                 //mapping between feature file and stepdefinition file
		//it will check that proper steps are written in stepdefinition filr or not and that step can be seen in the console
		//if you miss any feature related step in stepdefinition file it will say us to do that in stepdefinition file
		//if dryRun=false it will execute our testcases		
		
		)

     
public class TestRunner {

}
//1.what is feature?the path of the feature files
//glue? path of the stepdefinition files

//2.what is format?
//to generate different types of reporting means we can generate html report,xml report,json report

//3. strict=true means it will check if any step is not defined in step definition file this will be used when dryRun=false

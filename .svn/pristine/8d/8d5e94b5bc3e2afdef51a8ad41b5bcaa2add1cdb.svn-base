package ch.post.pf.nf.ta.execution;

import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Test;

import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
import ch.post.pf.nf.ta.scenarios.HomePageMenuValidationScenario;

public class HomePageMenuListValidation extends Setup {

	protected HomePageMenuValidationScenario scenario = new HomePageMenuValidationScenario();
	protected CreateNFScenarios Scenario = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	@Test(priority = 0, dataProvider = "getLaungageDataReader", dataProviderClass = ReadData.class, description = "To check wheather the Home Page of NAPF application is getting open.")
	public void HomepageMenuListValidation(Map<String, String> testdata) throws Exception {
		if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
			CommonUtils.waitTime(2000);
			log.info("***************** START TEST *****************");
			this.browserLaunch(CHROME);
			common.loadURL();
			logger = parent.createNode(methodName + " :" + testdata.get("Language"));
			Scenario.profileMenuSelect(testdata.get(LANGUAGE));
			scenario.appmenulistValidation(testdata.get(FIELD_NAMES), testdata.get(OPEN_NF_HEADERNAME),
					testdata.get(OPEN_NF_BUTTON_NAME));
		} else {
			logger = parent.createNode(methodName + testdata.get("Menu 1"));
			throw new SkipException(methodName);
		}
	}

}
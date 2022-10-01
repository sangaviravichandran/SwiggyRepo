package ch.post.pf.nf.ta.execution;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
import ch.post.pf.nf.ta.scenarios.HomePageMenuValidationScenario;

public class HomePageMenuListValidationTestcase extends Setup {

	protected HomePageMenuValidationScenario scenario = new HomePageMenuValidationScenario();
	protected CreateNFScenarios Scenario = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Home page MenuList Validation*/
	
	@Test(priority = 0, dataProvider = "getmenuPage", dataProviderClass = ReadData.class)
	public void HomepageMenuListValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + " :" + testdata.get(HEADERS));
				Scenario.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				scenario.appmenulistValidation(testdata.get("FieldNames"), testdata.get(OPEN_NF_HEADERNAME),
						testdata.get(OPEN_NF_BUTTON_NAME));
			} else {
				logger = parent.createNode(methodName + testdata.get(MENU_1));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}
}

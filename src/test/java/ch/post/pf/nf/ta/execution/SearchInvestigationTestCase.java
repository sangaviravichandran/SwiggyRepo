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
import ch.post.pf.nf.ta.scenarios.SearchInvestigationScenarios;

public class SearchInvestigationTestCase extends Setup {

	protected SearchInvestigationScenarios scenario = new SearchInvestigationScenarios();
	protected CreateNFScenarios cfScenario = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Search Investigation all Fields validation */

	@Test(priority =0, dataProvider = "getSearchInvestigationField", dataProviderClass = ReadData.class)
	public void searchInvestigationFieldVerification(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				common.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				cfScenario.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				String[] testinput = {testdata.get(APP_MENU),testdata.get(FIELD_NAMES)};
				scenario.searchInvestigationFields_buttons(testinput);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/* This Testcase help on Search Investigation search data and validation */

	@Test(priority = 1, dataProvider = "getSearchInvestigation", dataProviderClass = ReadData.class)
	public void SearchInvestigation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				common.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				common.waitTime(2000);
				logger = parent.createNode(methodName + testdata.get("Headers"));
				log.info(testdata.toString());
				cfScenario.profileMenuSelect(testdata.get(LANGUAGE));
				scenario.SearchDataInSearchInvestigation(testdata);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/*
	 * This Testcase help on Search Investigation More button and Less button and
	 * reset button if working Check
	 */

	@Test(priority =2, dataProvider = "getSearchInvestigationField", dataProviderClass = ReadData.class)
	public void MoreLessResetButtonCheckSearchInvestigation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				common.waitTime(2000);
				logger = parent.createNode(methodName);
				cfScenario.profileMenuSelect(testdata.get(LANGUAGE1));
				common.waitTime(3000);
				scenario.ResetClickFunction(testdata);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/* This Testcase help on Search Investigation Check to Click Download button is work? */
	
	@Test(priority =3, dataProvider = "getSearchInvestigationField", dataProviderClass = ReadData.class)
	public void SearchInvestigationdownloadClick(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				common.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				common.waitTime(2000);
				logger = parent.createNode(methodName);
				cfScenario.profileMenuSelect(testdata.get(LANGUAGE1));
				scenario.SearchInvestigationDownload(testdata);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}
}
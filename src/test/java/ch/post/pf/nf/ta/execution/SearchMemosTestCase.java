package ch.post.pf.nf.ta.execution;

import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;
import ch.post.pf.nf.ta.scenarios.SearchMemosScenario;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;

public class SearchMemosTestCase extends Setup {

	protected SearchMemosScenario scenario = new SearchMemosScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();
	DAOTest daoTest = new DAOTest();

	/*
	 * This Testecase is used to validate the Feilds name present in search memo in
	 * four languages
	 */

	@Test(priority = 0, dataProvider = "getSearchMemosFields", dataProviderClass = ReadData.class)
	public void SearchMemosFieldValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				common.waitTime(2000);
				daoTest.appMenuList(testdata.get(MENU_1));
				common.waitTime(2000);
				scenario.SearchmemosFieldValidation(testdata.get(FIELD_NAMES));
			} else {
				logger = parent.createNode(methodName + testdata.get("Headers"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/* This Testcase help on Search Memos all Fields validation and Search data */

	@Test(priority = 1, dataProvider = "getSearchMemos", dataProviderClass = ReadData.class)
	public void CreateSearchmemosAndValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				scenario.SearchDataInSearchMemos(testdata);
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

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
import ch.post.pf.nf.ta.scenarios.ActivitiesScenario;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;

public class ActivitiesTestCase extends Setup {

	protected ActivitiesScenario scenario = new ActivitiesScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();
	protected DAOTest daoTest = new DAOTest();

	/* This Testcase help on Activities All fields validate*/
	
	@Test(priority = 0, dataProvider = "getActivitesDataReader", dataProviderClass = ReadData.class)
	public void Activities(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + " for PA and TA :" + testdata.get("Process Name")
						+ testdata.get("TA") + "DC:" + testdata.get("Headers"));
				if (testdata.get(HEADERS).equalsIgnoreCase(ONLINE)) {
					Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
					Scenarios.createNFWithPaTa(testdata);
					scenario.activitiesTab(testdata);
				} else {
					daoTest.searchAndMovetoUserinbox(testdata.get(LANGUAGE), testdata.get(MENU_1),
							testdata.get(NFID));
					scenario.activitiesTab(testdata);
				}
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
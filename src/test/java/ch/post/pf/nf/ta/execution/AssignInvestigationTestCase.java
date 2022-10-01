package ch.post.pf.nf.ta.execution;

import static org.testng.Assert.assertTrue;

import java.util.Map;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.scenarios.AssignInvestigationScenario;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;

public class AssignInvestigationTestCase extends Setup {

	protected AssignInvestigationScenario scenario = new AssignInvestigationScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Assign Investigation All fields validation */

	@Test(priority = 1, dataProvider = "getAssigninvestigationFieldvalidation", dataProviderClass = ReadData.class)
	public void AssignInvestigationFieldsvalidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
						testdata.get(GROUP_QUEUE_NAME), testdata.get(GROUP_QUEUE_SUB_NAME),
						testdata.get(GROUP_QUEUE_MENU), testdata.get(GROUP_SUMMARY) };
				scenario.AssignInvestigation(testinput);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/*
	 * This Testcase help on select the Nf id and then move to perticuler Group
	 * element
	 */

	@Test(priority = 2, dataProvider = "getAssignInvestigation", dataProviderClass = ReadData.class)
	public void AssignInvestigationGropqueuemove(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get("DataValidationLanguage"));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
						testdata.get(GROUP_QUEUE_NAME), testdata.get(GROUP_QUEUE_SUB_NAME),
						testdata.get(GROUP_QUEUE_MENU), testdata.get(GROUP_SUMMARY), testdata.get(MENU_TAB) };
				scenario.AssignInvestigation(testinput);
				scenario.AssignInvestigationGroupMove(testinput);
			} else {
				logger = parent.createNode(methodName + testdata.get("Menu 1"));
				throw new SkipException(methodName);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			logger = parent.createNode(methodName + "CanExecute check");
			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
			assertTrue(false);
		}
	}

	/*
	 * This Testcase help on select the Nf id and then move to particular Group
	 * element and goto GroupQueue summary and search in the group Queue Summary
	 * page
	 */

	@Test(priority = 3, dataProvider = "getAssignInvestigation", dataProviderClass = ReadData.class)
	public void AssignInvestigationMovedGroupVerificationinGroupQueuSummary(Map<String, String> testdata)
			throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
						testdata.get(GROUP_QUEUE_NAME), testdata.get(GROUP_QUEUE_SUB_NAME),
						testdata.get(GROUP_QUEUE_MENU), testdata.get(GROUP_SUMMARY), testdata.get(MENU_TAB) };
				scenario.AssignInvestigation(testinput);
				String assignInvestigationGroupMove = scenario.AssignInvestigationGroupMove(testinput);
				if (assignInvestigationGroupMove == null) {
					String[] testinputnew = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
							testdata.get(GROUP_QUEUE_NAME), testdata.get(GROUP_QUEUE_SUB_NAME),
							testdata.get(GROUP_QUEUE_MENU), testdata.get(GROUP_SUMMARY) };
					scenario.AssignInvestMovedGroupVerificationinGroupQueuSummary(testinputnew);
				} else {
					String[] testinputnew = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
							testdata.get(GROUP_QUEUE_NAME), assignInvestigationGroupMove,
							testdata.get(GROUP_QUEUE_MENU), testdata.get(GROUP_SUMMARY) };
					scenario.AssignInvestMovedGroupVerificationinGroupQueuSummary(testinputnew);
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

	/* This Testcase help on Assign Investigation State Filter Validation */

	@Test(priority = 4, dataProvider = "getAssignInvestigation", dataProviderClass = ReadData.class)
	public void AssignInvestigationStateFilterValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get("DataValidationLanguage"));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER), testdata.get(STATE_VALUE) };

				scenario.AssignInvestigationStateValidation(testinput);
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

	@Test(priority = 5, dataProvider = "getAssignInvestigation", dataProviderClass = ReadData.class)
	public void AssignInvestigationpriorityFilterValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
						testdata.get(PRIORITY_VALUE) };

				scenario.AssignInvestigationpriorityValidation(testinput);
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

	@Test(priority = 6, dataProvider = "getAssignInvestigation", dataProviderClass = ReadData.class)
	public void AssignInvestigationmovesourceGrop(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				String[] testinput = { testdata.get(APP_MENU), testdata.get(SELECT_USER),
						testdata.get(GROUP_QUEUE_NAME) };
				scenario.AssignInvestigation(testinput);
				scenario.AssignInvestigationGroupMoveErrorvalidation(testinput);
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
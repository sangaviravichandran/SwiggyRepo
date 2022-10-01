package ch.post.pf.nf.ta.execution;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.scenarios.ActivitiesScenario;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
import ch.post.pf.nf.ta.scenarios.WorkFlowScenario;

public class WorkFlowTestCase extends Setup {

	protected WorkFlowScenario scenario = new WorkFlowScenario() ;
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Work Flow App menu Fields validation*/
	
	@Test(priority = 0, dataProvider = "getWorkFlowData", dataProviderClass = ReadData.class)
	public void WorkFlowAppmenuValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				for (int i = 1; i <= 1; i++) {
					if (i == 1) {
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						Scenarios.createNFWithPaTa(testdata);
						scenario.WorkFlowAppMenu(testdata.get(FIELD_NAMES));
					} else {
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						scenario.WorkFlowAppMenu(testdata.get(FIELD_NAMES));
					}
				}
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

	/* This Testcase help on Work Flow Tree Dot Fields validation*/
	
	@Test(priority = 1, dataProvider = "getWorkFlowData", dataProviderClass = ReadData.class, dependsOnMethods = {"WorkFlowAppmenuValidation" })
	public void WorkFlowThreeDotFieldValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				for (int i = 1; i <= 1; i++) {
					if (i == 1) {
						scenario.openNFInvestigation(scenario.readNFNumber.replace("NF | ", ""));
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						scenario.WorkflowThreeDotFieldCheck(testdata.get(ARROW_FLOW_THREE_DOT_FIELD));
					} else {
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						scenario.WorkflowThreeDotFieldCheck(testdata.get(ARROW_FLOW_THREE_DOT_FIELD));
					}
				}
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
	
	/* This Testcase help on Work Flow Side Work Flow Fields validation*/

	@Test(priority = 2, dataProvider = "getWorkFlowData", dataProviderClass = ReadData.class)
	public void WorkFlowsideArrowValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				for (int i = 1; i <= 1; i++) {
					if (i == 1) {
						scenario.openNFInvestigation(scenario.readNFNumber.replace("NF | ", ""));
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						scenario.SideArrowflowDataCheck(testdata.get(SIDE_ARROW_FLOW_FIELD));
					} else {
						Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
						scenario.SideArrowflowDataCheck(testdata.get(SIDE_ARROW_FLOW_FIELD));
					}
				}
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

}
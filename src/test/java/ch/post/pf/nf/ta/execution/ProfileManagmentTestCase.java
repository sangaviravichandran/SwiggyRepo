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
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
import ch.post.pf.nf.ta.scenarios.ProfileMenuValidationScenario;

public class ProfileManagmentTestCase extends Setup {

	protected ProfileMenuValidationScenario scenario = new ProfileMenuValidationScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();
	protected DAOTest daoTest = new DAOTest();

	/* This Testcase help on Profile Managemnet All fields validate */

	@Test(priority = 0, dataProvider = "getProfileManagementFields", dataProviderClass = ReadData.class)
	public void ProfileManagmentFieldValidate(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				common.waitTime(2000);
				scenario.ProfilemanagementFieldValidation(testdata.get(FIELD_NAMES));
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

	@Test(priority = 1, dataProvider = "getProfilemanagment", dataProviderClass = ReadData.class)
	public void CreateNewProfile(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				common.waitTime(2000);
				scenario.CreateProfileManagement(testdata);
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
	
	@Test(priority = 2, dataProvider = "getProfilemanagment", dataProviderClass = ReadData.class)
	public void EditUserProfile(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				common.waitTime(2000);
				scenario.EditingProfileManagement(testdata);
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
	
	@Test(priority = 3, dataProvider = "getProfilemanagment", dataProviderClass = ReadData.class)
	public void DeleteUserProfile(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				common.waitTime(2000);
				scenario.DeleteProfileManagement(testdata);
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
	
	@Test(priority = 4, dataProvider = "getProfileManagementFields", dataProviderClass = ReadData.class)
	public void ProfileManagementValuevalidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(DATA_VALIDATION_LANGUAGE));
				common.waitTime(2000);
				scenario.ProfileManagementdatavalueValidation(testdata);
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
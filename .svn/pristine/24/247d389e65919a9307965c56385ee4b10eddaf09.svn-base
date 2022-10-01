package ch.post.pf.nf.ta.execution;

import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.scenarios.AttachmentScenario;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;

public class AttachMentTestCase extends Setup {

	protected AttachmentScenario scenario = new AttachmentScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Attachment all field validation */

	@Test(priority = 0, dataProvider = "getAttachment", dataProviderClass = ReadData.class)
	public void Attachmentvalidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				scenario.AttachmenttabValidation(testdata);
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

	/* This Testcase help on Attachment SI Details field validation */

	@Test(priority = 1, dataProvider = "getAttachment", dataProviderClass = ReadData.class, dependsOnMethods = {
			"Attachmentvalidation" })
	public void AttachmentSIDetailvalidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				scenario.AttachmentSIDetailsValidation(testdata);
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
	 * This Testcase help on Attachment Drop Area field validation and upload file
	 * in drop area
	 */

	@Test(priority = 2, dataProvider = "getAttachment", dataProviderClass = ReadData.class, dependsOnMethods = {
			"Attachmentvalidation" })
	public void AttachmentDropAreavalidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName);
				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
				scenario.AttachmentDropAreaValidation(testdata);
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
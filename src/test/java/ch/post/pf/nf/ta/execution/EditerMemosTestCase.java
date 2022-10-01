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
import ch.post.pf.nf.ta.scenarios.EditerMemosScenario;

public class EditerMemosTestCase extends Setup {

	protected EditerMemosScenario scenario = new EditerMemosScenario();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected CommonUtils common = new CommonUtils();

	/* This Testcase help on Editer memos All Fields Validation*/
	
	@Test(priority = 0, dataProvider = "getEditerMemos", dataProviderClass = ReadData.class)
	public void EditermemosFieldsValidation(Map<String, String> testdata) throws Exception {
		try {
			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
				CommonUtils.waitTime(2000);
				log.info("***************** START TEST *****************");
				common.NAPFBrowserLaunch();
				logger = parent.createNode(methodName + testdata.get("Headers"));
				common.waitTime(2000);
				Scenarios.profileMenuSelect(testdata.get(DATA_LANGUAGE));
				String[] testinput = { testdata.get(EDITER_MEMO_FIELDS), testdata.get(EDITOR_MENU),
						common.splitString(testdata.get(NFID)) };
				Scenarios.openNfInvestigation(testinput[2]);
				scenario.EditerMemosFieldsCheck(testinput);
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

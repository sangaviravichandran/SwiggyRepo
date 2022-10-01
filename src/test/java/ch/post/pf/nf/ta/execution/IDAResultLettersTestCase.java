//package ch.post.pf.nf.ta.execution;
//
//import static org.testng.Assert.assertTrue;
//
//import java.util.Map;
//
//import org.openqa.selenium.WebElement;
//import org.testng.SkipException;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//
//import ch.post.pf.nf.ta.baseutils.CommonUtils;
//import ch.post.pf.nf.ta.baseutils.ReadData;
//import ch.post.pf.nf.ta.baseutils.Setup;
//import ch.post.pf.nf.ta.dao.DAOTest;
//import ch.post.pf.nf.ta.pagefactory.NAPFLocators;
//import ch.post.pf.nf.ta.scenarios.ActivitiesScenario;
//import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
//import ch.post.pf.nf.ta.scenarios.IDAResultLettersScenario;
//
//public class IDAResultLettersTestCase extends Setup {
//
//	protected IDAResultLettersScenario scenario = new IDAResultLettersScenario();
//	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
//	protected CommonUtils commonUtils = new CommonUtils();
//	protected DAOTest daoTest = new DAOTest();
//
//	@Test(priority = 0, dataProvider = "getProductTabFieldvalue", dataProviderClass = ReadData.class)
//	public void productTabValidation(Map<String, String> testdata) throws Exception {
//		NAPFLocators ls = new NAPFLocators();
//		try {
//			if (testdata.get("CanExecute").equalsIgnoreCase("yes")) {
//				CommonUtils.waitTime(2000);
//				log.info("***************** START TEST *****************");
//				commonUtils.NAPFBrowserLaunch();
//				logger = parent.createNode(methodName + " for PA and TA :" + testdata.get("Process Name")
//						+ testdata.get("TA") + "IDA Result field enter the value:" + testdata.get("Headers"));
//				Scenarios.profileMenuSelect(testdata.get("Language"));
//				commonUtils.waitTime(2000);
//				scenario.ProductTabFieldvalueAndAttachIDA(testdata);
//			} else {
//				logger = parent.createNode(methodName + testdata.get("Menu 1"));
//				throw new SkipException(methodName);
//			}
//		} catch (NullPointerException e) {
//			// TODO: handle exception
//			logger = parent.createNode(methodName + "CanExecute check");
//			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
//			assertTrue(false);
//		}
//	}
//	
//	
//	
//	
//}
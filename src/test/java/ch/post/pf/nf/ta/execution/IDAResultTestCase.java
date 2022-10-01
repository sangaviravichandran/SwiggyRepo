//package ch.post.pf.nf.ta.execution;
//
//import static org.testng.Assert.assertTrue;
//import java.util.Map;
//import org.openqa.selenium.WebElement;
//import org.testng.SkipException;
//import org.testng.annotations.Test;
//import com.aventstack.extentreports.Status;
//import ch.post.pf.nf.ta.baseutils.CommonUtils;
//import ch.post.pf.nf.ta.baseutils.ReadData;
//import ch.post.pf.nf.ta.baseutils.Setup;
//import ch.post.pf.nf.ta.dao.DAOTest;
//import ch.post.pf.nf.ta.pagefactory.NAPFLocators;
//import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
//import ch.post.pf.nf.ta.scenarios.IDAResultsScenarios;
//
//public class IDAResultTestCase extends Setup {
//
//	protected IDAResultsScenarios scenario = new IDAResultsScenarios();
//	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
//	protected CommonUtils commonUtils = new CommonUtils();
//	protected DAOTest daoTest = new DAOTest();
//
//	@Test(priority = 0, dataProvider = "getProductTabFieldvalue", dataProviderClass = ReadData.class)
//	public void productTabValidation(Map<String, String> testdata) throws Exception {
//		NAPFLocators ls = new NAPFLocators();
//		try {
//			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
//				CommonUtils.waitTime(2000);
//				log.info("***************** START TEST *****************");
//				commonUtils.NAPFBrowserLaunch();
//				logger = parent.createNode(methodName + " for PA and TA :" + testdata.get("Process Name")
//						+ testdata.get("TA") + "IDA Result field enter the value:" + testdata.get("Headers"));
//				Scenarios.profileMenuSelect(testdata.get(LANGUAGE));
//				commonUtils.waitTime(2000);
//				scenario.ProductTabFieldValidation(testdata);
//				daoTest.saveButton();
//				commonUtils.waitTime(10000);
//				WebElement headersearchButton = commonUtils.expandRootElement(ls.headersearchButton);
//				commonUtils.waitTime(2000);
//				commonUtils.click(headersearchButton);
//			} else {
//				logger = parent.createNode(methodName + testdata.get("Menu 1"));
//				throw new SkipException(methodName);
//			}
//		} catch (NullPointerException e) {
//			logger = parent.createNode(methodName + "CanExecute check");
//			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
//			assertTrue(false);
//		}
//	}
//
//	@Test(priority = 1, dataProvider = "getProductTabFieldvalue", dataProviderClass = ReadData.class)
//	public void IDAResultsValidation(Map<String, String> testdata) throws Exception {
//		NAPFLocators ls = new NAPFLocators();
//		try {
//			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
//				CommonUtils.waitTime(2000);
//				log.info("***************** START TEST *****************");
//				commonUtils.NAPFBrowserLaunch();
//				logger = parent.createNode(methodName + " for PA and TA :" + testdata.get("Process Name")
//						+ testdata.get("TA") + "IDA Result field enter the value:" + testdata.get("Headers"));
//				Scenarios.profileMenuSelect(testdata.get(FIELDS_LANGUAGE));
//				commonUtils.waitTime(2000);
//				scenario.IDAResultsFieldsCheck(testdata.get(MENU_TAB1));
//			} else {
//				logger = parent.createNode(methodName + testdata.get("menuTab1"));
//				throw new SkipException(methodName);
//			}
//		} catch (NullPointerException e) {
//			logger = parent.createNode(methodName + "CanExecute check");
//			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
//			assertTrue(false);
//		}
//	}
//
//	@Test(priority = 2, dataProvider = "getIDAresultFields", dataProviderClass = ReadData.class)
//	public void IDAResultsVIEWValidation(Map<String, String> testdata) throws Exception {
//		NAPFLocators ls = new NAPFLocators();
//		try {
//			if (testdata.get(CAN_EXECUTE).equalsIgnoreCase(YES)) {
//				CommonUtils.waitTime(2000);
//				log.info("***************** START TEST *****************");
//				commonUtils.NAPFBrowserLaunch();
//				logger = parent.createNode(methodName + " for PA and TA :" + testdata.get("Process Name")
//						+ testdata.get("TA") + "IDA Result field enter the value:" + testdata.get("Headers"));
//				Scenarios.profileMenuSelect(testdata.get(FIELDS_LANGUAGE));
//				commonUtils.waitTime(2000);
//				scenario.IDAResultsFieldValidation(testdata);
//			} else {
//				logger = parent.createNode(methodName + testdata.get("Menu 1"));
//				throw new SkipException(methodName);
//			}
//		} catch (NullPointerException e) {
//			logger = parent.createNode(methodName + "CanExecute check");
//			logger.log(Status.FAIL, "canexecute Field is manditory should be updated as yes /no");
//			assertTrue(false);
//		}
//	}
//
//	@Test(priority = 3, dataProvider = "GetProductIDA", dataProviderClass = ReadData.class)
//	public void ProductValueAndIDAResultsVIEWValueValidation(Map<String, String> testdata) throws Exception {
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
//				Scenarios.createNFWithPaTa(testdata);
//				scenario.ProductFieldIdafieldCheck(testdata);
//				commonUtils.waitTime(2000);
//				scenario.ProductvalueIDAvalueCheck(testdata);
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
//}
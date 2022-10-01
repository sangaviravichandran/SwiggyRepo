//package ch.post.pf.nf.ta.scenarios;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Currency;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v85.page.Page.SetWebLifecycleStateState;
//import org.slf4j.Logger;
//import org.testng.Assert;
//
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.model.Log;
//
//import ch.post.pf.nf.ta.baseutils.CommonUtils;
//import ch.post.pf.nf.ta.baseutils.Log4jUtil;
//import ch.post.pf.nf.ta.baseutils.ReadData;
//import ch.post.pf.nf.ta.baseutils.Setup;
//import ch.post.pf.nf.ta.dao.DAOTest;
//import ch.post.pf.nf.ta.pagefactory.NAPFLocators;
//
//public class IDAResultLettersScenario extends Setup {
//
//	Logger log = Log4jUtil.loadLogger(IDAResultLettersScenario.class);
//	CommonUtils commonUtils = new CommonUtils();
//	CreateNFScenarios CNFScenarios = new CreateNFScenarios();
//	String readNFNumber=null;
//	
///* This Scenario help on Open Nf id and stay same window*/
//	
//	public void openNFInvestigation(String testdata) throws IOException, Exception {
//		logger.log(Status.INFO, "Opening the Nf id of DC ");
//		DAOTest daoTest = new DAOTest();
//		boolean openNf = daoTest.openNf(testdata);
//		assertTrue(openNf, "The NF page could not be found.");
//		constructOpenNfAndLoad(testdata);
//	}
//	
//	
//	public void constructOpenNfAndLoad(String number) throws Exception {
//		driver.get(ReadData.getTestProperty("opennfurl") + number);
//		logger.log(Status.INFO, "opened the nf id :" + number);
//		commonUtils.waitTime(6000);
//	}
//	
//	
//	public void ProductTabFieldvalueAndAttachIDA(Map<String, String> testdata) throws Exception {
//		DAOTest daoTest = new DAOTest();
//		NAPFLocators ls = new NAPFLocators();
//		logger.log(Status.INFO, "Validating the product tab field for Pa : " + testdata.get("Process Name") + " Ta : "
//				+ testdata.get("TA"));
//		CNFScenarios.createNFWithPaTa(testdata);
//		commonUtils.waitTime(1000);
//		readNFNumber = daoTest.readNFNumber();
//		daoTest.editorMenuSelect(testdata.get("menutab"));
//		commonUtils.waitTime(3000);
//		List<String> readFiledNameFromXLSheet = daoTest.readFiledNameFromXLSheet(testdata.get("Field Name"),
//				"ProductManditaryField");
//		int size = readFiledNameFromXLSheet.size();
//		for (int i = 0; i < size; i++) {
//			daoTest.ProductfieldValidationAndClick(testdata.get("Mode"), readFiledNameFromXLSheet.get(i),
//					testdata.get(readFiledNameFromXLSheet.get(i)));
//			commonUtils.waitTime(2000);
//		}
//		daoTest.saveButton();
//		commonUtils.waitTime(6000);
//		WebElement headersearchButton =commonUtils.expandRootElement(ls.headersearchButton);
//		commonUtils.waitTime(2000);
//		commonUtils.click(headersearchButton);
//		commonUtils.waitTime(10000);
//		String clickCheckboxAndPopulatevalue = daoTest.ClickCheckboxAndPopulatevalue(testdata.get("populate"));
//		commonUtils.waitTime(3000);
//	}
//	
//	public void IDAPartnertypevalidation(Map<String, String> testdata) throws Exception {
//		DAOTest daoTest = new DAOTest();
//		NAPFLocators ls = new NAPFLocators();
//}

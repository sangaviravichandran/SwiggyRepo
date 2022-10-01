package ch.post.pf.nf.ta.scenarios;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;

public class AttachmentScenario extends Setup {

	Logger log = Log4jUtil.loadLogger(AttachmentScenario.class);
	CommonUtils commonUtils = new CommonUtils();
	CreateNFScenarios CNFScenarios =new CreateNFScenarios();
	String readNFNumber=null;

	/* This Scenario help on Open Nf id and stay same window*/
	
	public void openNFInvestigation(String testdata) throws IOException, Exception {
		logger.log(Status.INFO, "Opening the Nf id of DC ");
		DAOTest daoTest = new DAOTest();
		boolean openNf = daoTest.openNf(testdata);
		assertTrue(openNf, "The NF page could not be found.");
		constructOpenNfAndLoad(testdata);
	}
	
	/* This Scenario help on load nf number in Open NF id Field*/
	
	public void constructOpenNfAndLoad(String number) throws Exception {
		
		driver.get(ReadData.getTestProperty(OPEN_NF_URL) + number);
		logger.log(Status.INFO, "opened the nf id :" + number);
		commonUtils.waitTime(6000);
	}
	
	/*
	 * This Scenario help on Validating the attachment tab field validation  	
	 */
	public void AttachmenttabValidation(Map<String,String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		CNFScenarios.createNFWithPaTa(testdata);
		readNFNumber = daoTest.readNFNumber();
		daoTest.editorMenuSelect(testdata.get(MENU_TAB));
		daoTest.AttachmentTabValidation();
	}
	
	/*
	 * This Scenario help on validating the attachement tab SI detail part
	 */
	public void AttachmentSIDetailsValidation(Map<String,String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		String NFNumber=readNFNumber.replace("NF | ", "");
		openNFInvestigation(NFNumber);
		daoTest.editorMenuSelect(testdata.get(MENU_TAB));
		commonUtils.waitTime(2000);
		commonUtils.scrolltoPageHeight();
		daoTest.AttachmentSIDetails();
	}
	
	/*
	 * This Scenario help on valdiating the attachement tabDrop area validation
	 */
	public void AttachmentDropAreaValidation(Map<String,String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		CNFScenarios.createNFWithPaTa(testdata);
		readNFNumber = daoTest.readNFNumber();
		String NFNumber=readNFNumber.replace("NF | ", "");
		openNFInvestigation(NFNumber);
		daoTest.editorMenuSelect(testdata.get(MENU_TAB));
		commonUtils.waitTime(2000);
		commonUtils.scrolltoPageHeight();
		daoTest.AttachmentInDropArea();
	}
	
}

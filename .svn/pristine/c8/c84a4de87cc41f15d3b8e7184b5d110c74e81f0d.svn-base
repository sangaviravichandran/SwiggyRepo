package ch.post.pf.nf.ta.scenarios;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;

public class WorkFlowScenario extends Setup {

	Logger log = Log4jUtil.loadLogger(WorkFlowScenario.class);
	CommonUtils commonUtils = new CommonUtils();
	CreateNFScenarios CNFScenarios = new CreateNFScenarios();
	public String readNFNumber = null;

	/* This Scenario help on Work Flow AppMenu validation*/ 
	
	public void WorkFlowAppMenu(String data) throws Exception {
		DAOTest daoTest = new DAOTest();
		commonUtils.waitTime(2000);
		readNFNumber = daoTest.readNFNumber();
		daoTest.ArrowFlowAppMenu(data);
	}

	/* This Scenario help on Work Flow Three Dot Field validation*/
	
	public void WorkflowThreeDotFieldCheck(String data) throws Exception {
		DAOTest daoTest = new DAOTest();
		commonUtils.waitTime(2000);
		daoTest.ArrowFlowThreeDotFieldCheck(data);
		commonUtils.waitTime(2000);
	}

	/* This Scenario help on Side Work Flow  Field validation*/
	
	public void SideArrowflowDataCheck(String data) throws Exception {
		DAOTest daoTest = new DAOTest();
		commonUtils.waitTime(2000);
		daoTest.SideArrowDataCheck(data);
		commonUtils.waitTime(2000);
	}

	/* This Scenario help on Open Nf id and stay same window*/
	
	public void openNFInvestigation(String testdata) throws IOException, Exception {
		logger.log(Status.INFO, "Opening the Nf id of DC ");
		DAOTest daoTest = new DAOTest();
		boolean openNf = daoTest.openNf(testdata);
		assertTrue(openNf, "The NF page could not be found.");
		constructOpenNfAndLoad(testdata);
		commonUtils.waitTime(5000);
	}

	/* This Scenario help on load nf number in Open NF id Field*/
	
	public void constructOpenNfAndLoad(String number) throws Exception {
		driver.get(ReadData.getTestProperty(OPEN_NF_URL) + number);
		logger.log(Status.INFO, "opened the nf id :" + number);
		commonUtils.waitTime(6000);
	}

}

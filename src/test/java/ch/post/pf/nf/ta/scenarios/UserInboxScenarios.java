package ch.post.pf.nf.ta.scenarios;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;
public class UserInboxScenarios extends Setup {

	Logger log = Log4jUtil.loadLogger(UserInboxScenarios.class);
	CommonUtils commonUtils = new CommonUtils();

	/*
	 *This Scenario help on method to valdiate all field inside user inbox with column field sorting..
	 */

	public void userInboxFieldValidation(String menu) throws Exception {
		DAOTest daoTest = new DAOTest();
		logger.log(Status.INFO, "Validating theuser inbox fields");
		daoTest.appMenuList(menu);
		daoTest.column_field_sorting_validation(menu);
		commonUtils.waitTime(2000);
		boolean userInboxGroupElementCheck = daoTest.userInboxGroupElementCheck();
		if (userInboxGroupElementCheck) {
			assertTrue(false, "The group element are in enabled status");
		} else {
			assertEquals(userInboxGroupElementCheck, false, "The group element are in disabled status");
		}
	}

	/*
	 * This Scenario help on nf id search in userinbox and check the group elements status..
	 */

	public void userInboxNFsearchAndGroupcheck(String Menu) throws Exception {
		DAOTest daoTest = new DAOTest();
		String readNFNumber2 = daoTest.readNFNumber();
		logger.log(Status.INFO, "searching the NF-number created :" + readNFNumber2);
		commonUtils.loadURL();
		daoTest.appMenuList(Menu);
		commonUtils.waitTime(5000);
		WebElement nfsearchInUserInbox = daoTest.NfsearchInUserInbox(readNFNumber2.replaceAll("NF | ", ""), "search",
				"");
		boolean userInboxGroupElementCheck = daoTest.userInboxGroupElementCheck();
		if (userInboxGroupElementCheck) {
			assertTrue(true);
		} else {
			assertTrue(userInboxGroupElementCheck,
					"The group element are in disabled status after selecting the checkbox");
		}
	}

	/*
	 * This Scenario help on to nf id search in userinbox and opening the nf id from userinbox and create a
	 * customer mess..
	 */
	public void userInboxNFsearchAndopenCreateMess(String NFId, String menutab, String menu2) throws Exception {
		DAOTest daoTest = new DAOTest();
		logger.log(Status.INFO, "Searching and opening the NF id: " + NFId);
		boolean open_Searched_NF = daoTest.open_Searched_NF(NFId, "", menu2);
		assertTrue(open_Searched_NF, "Unable to iopen the Searched NF");
		boolean createMessTab = daoTest.CreateMessTab("Create a new mess", menutab);
		assertTrue(createMessTab, "Create mess is not working as execpted");
	}

	/*
	 *This Scenario help on to nf id search in userinbox and move the searched nf id to appropriate group
	 * and check the same is moved to appropriate group..
	 */

	public void userGroupNavigate(Map<String, String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		String readNFNumber2 = daoTest.readNFNumber();
		logger.log(Status.INFO, "searching the NF-number created :" + readNFNumber2);
		commonUtils.loadURL();
		daoTest.appMenuList(testdata.get(MENU_1));
		commonUtils.waitTime(3000);
		WebElement nfsearchInUserInbox = daoTest.NfsearchInUserInbox(readNFNumber2.replaceAll("NF | ", ""), "search",
				"");
		boolean userInboxGroupElementCheck = daoTest.userInboxGroupElementCheck();
		if (userInboxGroupElementCheck) {
			assertTrue(true);
		} else {
			assertTrue(userInboxGroupElementCheck,
					"The group element are in disabled status after selecting the checkbox");
		}
		daoTest.seelctGroupOption(testdata.get("Group1"), testdata.get(GROUP_SUMMARY));
		daoTest.appMenuList(testdata.get("Menu"));
		log.info("Searching the NF moved to " + testdata.get("Group1"));
		logger.log(Status.INFO, "Searching the NF moved to " + testdata.get("Group1"));
		daoTest.groupQueueSummary(testdata.get("Groupsummary"));
		// driver.get(ReadData.getTestProperty("groupsummaryUrl"));
		commonUtils.waitTime(5000);
		WebElement nfsearchIngroupsummary = daoTest.NfsearchInUserInbox(readNFNumber2.replaceAll("NF | ", ""), "",
				testdata.get(GROUP_SUMMARY));
		try {
			if (nfsearchIngroupsummary.isDisplayed()) {
				log.info("Found the searched NF id in GroupQueuesummary");
				logger.log(Status.INFO,"Found the searched NF id in GroupQueuesummary");
				assertTrue(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Unable to find the searched NF id in GroupQueuesummary");
			logger.log(Status.ERROR,"Unable to find the searched NF id in GroupQueuesummary");
			assertTrue(false,"the NF id is not found in the Groupqueue summary moved");
		}

	}

}

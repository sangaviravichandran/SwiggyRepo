package ch.post.pf.nf.ta.scenarios;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;
import ch.post.pf.nf.ta.pagefactory.NAPFLocators;

public class SearchMemosScenario extends Setup {

	Logger log = Log4jUtil.loadLogger(SearchMemosScenario.class);
	CommonUtils commonUtils = new CommonUtils();
	CreateNFScenarios CNFScenarios = new CreateNFScenarios();
	
	/*This Scenario help on to Search memos Fields Validation*/
	
	public void SearchmemosFieldValidation(String testdata) throws InterruptedException, Exception {
		DAOTest daoTest = new DAOTest();
		logger.log(Status.INFO, "Validating the Search Memos fields" + testdata);
		commonUtils.waitTime(2000);
		List<String> browserField = daoTest.SearchMemosField();
		Collections.sort(browserField);
		List<String> readFiledNameFromSheet = daoTest.readFiledNameFromXLSheet(testdata,
				SEARCH_MEMOS_FIELD_VALIDATION);
		Collections.sort(readFiledNameFromSheet);
		commonUtils.waitTime(2000);
		System.out.println(browserField);
		System.out.println(readFiledNameFromSheet);
		assertEquals(browserField, readFiledNameFromSheet,
				"Both the repository and Webpage data field are not same in product tab");
	}
	
	/*This Scenario help on to Search data in search memos tab page*/
	
	public void SearchDataInSearchMemos(Map<String, String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Search Data In Search Memos " + testdata.get("Headers"));
		logger.log(Status.INFO, "Search Data In Search Memos" + testdata.get("Headers"));
		switch (testdata.get(HEADERS)) {
		case MEMOTYPE:
			commonUtils.waitTime(3000);
			daoTest.appMenuList(testdata.get(MENU_1));
			commonUtils.waitTime(2000);
			daoTest.MemoSearchpageHeadingValidation(testdata.get(MENU_1));
			log.info(testdata.get("Memotyp"));
			daoTest.SearchMemosINsearch(ls.MemoType, testdata.get(HEADERS), testdata.get(MEMOTYPE));
			commonUtils.downenter(commonUtils.expandRootElement(ls.MemoType));
			commonUtils.waitTime(2000);
			daoTest.MemossearchClick();
			String[] searchMemosFieldCheck4 = daoTest.SearchMemosFieldCheck(testdata.get(MEMO_FIELD));
			if(searchMemosFieldCheck4!=null) {
			CNFScenarios.openNfInvestigation(searchMemosFieldCheck4[1]);
			daoTest.editorMenuSelect(MENU_TAB);
			daoTest.readMemoId(searchMemosFieldCheck4[0]);
			}else {
				log.info("No search memo result found");
			}
			break;
		case STATUS_DES_MEMOS:
			commonUtils.waitTime(3000);
			daoTest.appMenuList(testdata.get(MENU_1));
			commonUtils.waitTime(3000);
			daoTest.MemoSearchpageHeadingValidation(testdata.get(MENU_1));
			log.info(testdata.get("StatusOfMemos"));
			commonUtils.waitTime(2000);
			WebElement SearchInField = commonUtils.expandRootElement(ls.StatusOfMemos);
			commonUtils.JSClick(SearchInField);
			commonUtils.waitTime(2000);
			commonUtils.type(SearchInField,testdata.get(HEADERS), testdata.get(STATUS_DES_MEMOS) );
			commonUtils.waitTime(1000);
			commonUtils.downenterkey(SearchInField);
			//daoTest.SearchMemosINsearch(ls.StatusOfMemos, testdata.get("Status des Memos"), testdata.get("Headers"));
			commonUtils.waitTime(2000);
			daoTest.MemossearchClick();
			String[] searchMemosFieldCheck3 = daoTest.SearchMemosFieldCheck(testdata.get(MEMO_FIELD));
			if(searchMemosFieldCheck3!=null) {
			CNFScenarios.openNfInvestigation(searchMemosFieldCheck3[1]);
			daoTest.editorMenuSelect("menutab");
			daoTest.readMemoId(searchMemosFieldCheck3[0]);
			}else {
				log.info("No search memo result found");
			}
			break;
		case MEMO_DATUMSBEREICH:
			commonUtils.waitTime(3000);
			daoTest.appMenuList(testdata.get(MENU_1));
			commonUtils.waitTime(3000);
			daoTest.MemoSearchpageHeadingValidation(testdata.get(MENU_1));
			log.info(testdata.get("MemoCreatedDate"));
			WebElement MemoCreatedFromDate = commonUtils.expandRootElement(ls.MemoCreatedFromDate);
			commonUtils.JSClick(MemoCreatedFromDate);
			commonUtils.waitTime(2000);
			commonUtils.type(MemoCreatedFromDate,testdata.get(HEADERS),testdata.get(MEMO_DATUMSBEREICH_VON));
			commonUtils.waitTime(2000);
			WebElement MemoCreatedToDate = commonUtils.expandRootElement(ls.MemoCreatedToDate);
			commonUtils.JSClick(MemoCreatedToDate);
			commonUtils.waitTime(2000);
			commonUtils.type(MemoCreatedToDate,testdata.get(HEADERS),testdata.get(MEMO_DATUMSBEREICH_BIS));
			commonUtils.waitTime(2000);
			Actions ac=new Actions(driver);
			ac.sendKeys(Keys.TAB).build().perform();
			ac.sendKeys(Keys.TAB).build().perform();
			ac.sendKeys(Keys.TAB).build().perform();
			ac.sendKeys(Keys.ENTER).build().perform();
			commonUtils.waitTime(2000);
			daoTest.MemossearchClick();
			String[] searchMemosFieldCheck2 = daoTest.SearchMemosFieldCheck(testdata.get(MEMO_FIELD));
			if(searchMemosFieldCheck2!=null) {
			CNFScenarios.openNfInvestigation(searchMemosFieldCheck2[1]);
			daoTest.editorMenuSelect(MENU_TAB);
			daoTest.readMemoId(searchMemosFieldCheck2[0]);
			}else {
				log.info("No search memo result found");
			}
			break;
		case NF_MEMO_ID:
			commonUtils.waitTime(3000);
			daoTest.appMenuList(testdata.get(MENU_1));
			commonUtils.waitTime(3000);
			daoTest.MemoSearchpageHeadingValidation(testdata.get(MENU_1));
			log.info(testdata.get("MemoCreatedDate"));
			daoTest.SearchMemosINsearch(ls.NFMemosIdfrom,testdata.get(HEADERS) , testdata.get(NF_MEMO_ID_VON));
			commonUtils.waitTime(3000);
			daoTest.SearchMemosINsearch(ls.NFMemosIdto,testdata.get("Headers"), testdata.get(NF_MEMO_ID_BIS));
			daoTest.MemossearchClick();
			String[] searchMemosFieldCheck1 = daoTest.SearchMemosFieldCheck(testdata.get(MEMO_FIELD));
			if(searchMemosFieldCheck1!=null) {
			CNFScenarios.openNfInvestigation(searchMemosFieldCheck1[1]);
			daoTest.editorMenuSelect(MENU_TAB);
			daoTest.readMemoId(searchMemosFieldCheck1[0]);
			}else {
				log.info("No search memo result found");
			}
			break;
		case ANLIEFERUNG:
			commonUtils.waitTime(3000);
			daoTest.appMenuList(testdata.get(MENU_1));
			commonUtils.waitTime(3000);
			daoTest.MemoSearchpageHeadingValidation(testdata.get(MENU_1));
			log.info(testdata.get("Anlieferung"));
			daoTest.SearchMemosINsearch(ls.deleiveryChannelMemos, testdata.get(HEADERS), testdata.get(ANLIEFERUNG));
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(commonUtils.expandRootElement(ls.deleiveryChannelMemos));
			commonUtils.waitTime(2000);
			daoTest.MemossearchClick();
			String[] searchMemosFieldCheck = daoTest.SearchMemosFieldCheck(testdata.get(MEMO_FIELD));
			if(searchMemosFieldCheck!=null) {
			CNFScenarios.openNfInvestigation(searchMemosFieldCheck[1]);
			daoTest.editorMenuSelect(testdata.get(MENU_TAB));
			daoTest.readMemoId(searchMemosFieldCheck[0]);
			}else {
				log.info("No search memo result found");
			}
		default:
			log.info("the given key is not found in a case");
			break;
		}
	}

}

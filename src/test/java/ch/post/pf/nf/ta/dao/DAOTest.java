package ch.post.pf.nf.ta.dao;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.collections4.list.TreeList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.InterfaceConstants;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.ReadData;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.pagefactory.NAPFLocators;
import ch.post.pf.nf.ta.scenarios.CreateNFScenarios;
import ch.post.pf.nf.ta.scenarios.ProductTabValidationScenarios;

public class DAOTest extends Setup implements InterfaceConstants {

	Logger log = Log4jUtil.loadLogger(DAOTest.class);
	CommonUtils commonUtils = new CommonUtils();
	protected CreateNFScenarios Scenarios = new CreateNFScenarios();
	protected ProductTabValidationScenarios scenario = new ProductTabValidationScenarios();
	String NFNumber = null;
	public String searchedCreatedNF = null;

	/* This method help as to Click on ProfileMenu header. */

	public boolean appLanguage() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		boolean click = commonUtils.click(commonUtils.jsElementFinder(ls.headerProfileMenu));
		if (click) {
			flag = true;
		}
		return flag;
	}

	/* This method help as to Click on Select Lanuguage */

	public boolean langugeselect(String Language) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		List<WebElement> profilemenuList = ls.profilemenuList;
		for (int i = 0; i < profilemenuList.size(); i++) {
			String label = profilemenuList.get(i).getAttribute(ACTUAL_LABEL);
			if (label.equalsIgnoreCase(Language)) {
				commonUtils.waitTime(3000);
				try {
					profilemenuList.get(i).click();
					flag = true;
					assertTrue(flag);
				} catch (Exception e) {
					commonUtils.loadURL();
					appLanguage();
					flag = langugeselect(Language);
					assertTrue(flag);
				}
				break;
			}
		}
		return flag;
	}

	/* This method help as App Menu Field Validation in Multiple Langugeuage */

	public boolean appMenuListValidation(String data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		List<WebElement> app_Menu_List = ls.app_Menu_List;
		String[] fields = data.split("@@");
		for (int i = 0; i < app_Menu_List.size(); i++) {
			String text = app_Menu_List.get(i).getAttribute("label");
			WebElement element = app_Menu_List.get(i);
			if (element.isDisplayed()) {
				if (fields[i].equalsIgnoreCase(text)) {
					if (commonUtils.isClickable(element)) {
						log.info("the element :" + text + " is present in the page");
						logger.log(Status.INFO, "the element :" + text + " is present in the page");
						commonUtils.click(app_Menu_List.get(i));
						logger.log(Status.INFO, "And landed in " + text + "page");
						logger.addScreenCaptureFromPath(
								commonUtils.getScreenhot(driver, text.replace("*", "") + "page"));
						flag = true;
					} else {
						assertTrue(flag, "the element is interepected from clicking");
					}
				}
			} else {
				assertTrue(flag, "the name in repository and name in webpage are not same");
			}
		}
		return flag;
	}

	/* This method help on Select the App Menu */

	public boolean appMenuList(String appname) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		List<WebElement> app_Menu_List = ls.app_Menu_List;
		for (int i = 0; i < app_Menu_List.size(); i++) {
			String text = app_Menu_List.get(i).getAttribute("label");
			WebElement element = app_Menu_List.get(i);
			if (text.equalsIgnoreCase(appname)) {
				log.info("the element :" + text + " is present in the page");
				logger.log(Status.INFO, "the element :" + text + " is present in the page");
				commonUtils.click(app_Menu_List.get(i));
				logger.log(Status.INFO, "And landed in " + text + "page");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, text + "page"));
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* This method help on Typing the NF ID in Open NF Field */

	public boolean open_NF_input_field(String name, String name1) throws Exception {
		boolean flag = false;
		NAPFLocators ll = new NAPFLocators();
		WebElement open_NF_input = ll.open_NF_input;
		boolean click = commonUtils.click(open_NF_input);
		logger.log(Status.INFO, "Open Nf input field is found and editable.");
		String openNfText = commonUtils.expandRootElement(ll.openNfText).getText();
		String openNfButtontext = commonUtils.expandRootElement(ll.openNfButtontext).getText();
		if (name.equalsIgnoreCase(openNfText) && name1.equalsIgnoreCase(openNfButtontext)) {
			flag = true;
			if (click) {
				flag = true;
			}
		} else {
			assertTrue(flag, "the name in repository and name in webpage are not same");
		}
		return flag;
	}

	/* This method help on Click as Create Investigation Button */

	public boolean CreateInvestigation() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		commonUtils.click(commonUtils.jsElementFinder(ls.createInvestigation));
		commonUtils.switchToWindow(1);
		commonUtils.waitTime(6000);
		WebElement jsElementFinder = commonUtils.jsElementFinder(ls.create_Inves_page);
		if (jsElementFinder.isDisplayed()) {
			log.info(jsElementFinder.getText());
			logger.log(Status.INFO, "clicked in Create investgation icon");
			flag = true;
		}

		return flag;
	}

	/*
	 * This method help on Select the Process name and TA name in Inverstigation
	 * page
	 */

	public boolean selectPATADD(String pa, String ta) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		try {
			log.info("selecting the PA and TA");
			logger.log(Status.INFO, "selecting the PA");
			commonUtils.waitTime(4000);
			WebElement ProcessNameElement = commonUtils.expandRootElement(ls.PaInitiator);
			boolean type = commonUtils.type(ProcessNameElement, "selecting Process name", pa);
			commonUtils.downenter(ProcessNameElement);
			commonUtils.waitTime(5000);
			logger.log(Status.INFO, "selecting the TA");
			WebElement TaElement = commonUtils.expandRootElement(ls.TaInitiator);
			boolean type2 = commonUtils.type(TaElement, "selecting Process name", ta);
			commonUtils.downenter(TaElement);
			if (type && type2) {
				flag = true;
				logger.addScreenCaptureFromPath(
						commonUtils.getScreenhot(driver, pa + " " + ta.substring(0, 2) + "page"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return flag;
	}

	/* This method help on Invertigation Save Button Click */

	public boolean saveButton() {
		boolean flag = false;
		log.info("selecting the save icon");
		logger.log(Status.INFO, "selecting the save icon");
		NAPFLocators ls = new NAPFLocators();
		try {
			WebElement element = commonUtils.expandRootElement(ls.savecss);
			if (element.isDisplayed()) {
				logger.log(Status.INFO, "Save icon is present and Clicked");
				element.click();
				CommonUtils.waitTime(1000);
				flag = true;
				WebElement SavePopup = commonUtils.expandRootElement(ls.SavePopup);
				CommonUtils.waitTime(2000);
				WebElement SavePopupClick = commonUtils.expandRootElement(ls.SavePopupClick);
				if (SavePopup.isDisplayed()) {
					CommonUtils.waitTime(1000);
					SavePopupClick.click();
					flag = true;
				} else {
					log.info("Unable to Click the PopUp Save okey Button");
					logger.log(Status.INFO, "Unable to Click the PopUp Save okey Button");
					flag = false;
					assertTrue(flag, "Unable to Click the PopUp Save okey Button");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}

		return flag;
	}

	public boolean saveButtonAftercreate() {
		boolean flag = false;
		log.info("selecting the save icon");
		logger.log(Status.INFO, "selecting the save icon");
		NAPFLocators ls = new NAPFLocators();
		try {
			WebElement element = commonUtils.expandRootElement(ls.savecss);
			if (element.isDisplayed()) {
				logger.log(Status.INFO, "Save icon is present and Clicked");
				element.click();
				CommonUtils.waitTime(1000);
				flag = true;
			} else {
				log.info("Unable to Click the PopUp Save okey Button");
				logger.log(Status.INFO, "Unable to Click the PopUp Save okey Button");
				flag = false;
				assertTrue(flag, "Unable to Click the PopUp Save okey Button");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}

		return flag;
	}

	/* This method help on Reading the Browser field and validation fields works */

	public List<String> fieldValidation(String Mode) throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Reading the Feild from web page");
		logger.log(Status.INFO, "Reading the Fields of " + Mode + " DC from web page");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.ScreenMaxzoomout();
		commonUtils.waitTime(4000);
		commonUtils.scrollintoView();
		List<String> browserField = new ArrayList<String>();
		try {
			ls.accountField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});
			ls.datepicketField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.pf_pktnr_account_field.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.textField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.comboboxField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.textareaField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});
			ls.checkboxField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});
			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils.expandRootElement(ls.custom_field);
						browserField.add(expandRootElement.getText().trim());
					}
				}

			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
			// sort the list browserField
			Collections.sort(browserField);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		Screenzoomin();
		return browserField;
	}

	/* This method help on field validation in perticuler Open Nf field */

	public List<String> fieldValidationOnOpenNF(String mode) throws Exception {
		constructOpenNfAndLoad(mode);
		commonUtils.scrollintoView();
		List<String> field = fieldValidation(mode);
		return field;
	}

	/* This method help on input a NF-ID in Open NF Field and load */

	public void constructOpenNfAndLoad(String mode) throws Exception {
		String split = ReadData.getTestProperty(mode);
		driver.get(ReadData.getTestProperty("opennfurl") + split);
		logger.log(Status.INFO, "opened the mode: " + mode + " nf id :" + split);
		commonUtils.waitTime(6000);

	}

	/* This method help to reading data From Xl sheet */

	public List<String> readFiledNameFromSheet(String sheet) throws Exception {
		List<String> li = new ArrayList<String>();
		log.info("Reading the date from repository");
		logger.log(Status.INFO, "Reading the date from repository");
		Map<String, String> readDataField = ReadData.readDataField(sheet + " NF");
		// reading the values from map
		Collection<String> values = readDataField.values();
		li.addAll(values);
		Collections.sort(li);

		return li;

	}

	/*
	 * This method help on also read data from Xl sheet and Split a (@@) and Add set
	 */

	public Set<String> readFiledNameFromPATA(String feild, String name) throws Exception {
		log.info("Reading" + name + "data from repository ");
		logger.log(Status.INFO, "Reading" + name + "data from repository ");

		String[] split = feild.split("@@");
		Set<String> li = new TreeSet<String>();
		for (String string2 : split) {
			li.add(string2.trim());
		}
		return li;
	}

	/* This method help on also read data from Xl sheet and Split a (@@) add List */

	public List<String> readFiledNameFromXLSheet(String feild, String name) throws Exception {
		log.info("Reading" + name + "data from repository ");
		logger.log(Status.INFO, "Reading" + name + "data from repository ");

		String[] split = feild.split("@@");
		List<String> li = new TreeList<String>();
		for (String string2 : split) {
			li.add(string2.trim());
		}
		return li;
	}

	/* This method help on After Create Investigation then Store a NF-ID */
	public String readNFNumber() {
		try {
			log.info("Reading the NF number created");
			logger.log(Status.INFO, "Reading the NF number created");
			NAPFLocators ls = new NAPFLocators();
			commonUtils.waitTime(3000);
			boolean displayed = commonUtils.expandRootElement(ls.NfNumber).isDisplayed();
			if (displayed) {
				NFNumber = commonUtils.expandRootElement(ls.NfNumber).getText();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			assertTrue(false);
			logger.log(Status.ERROR, e);
		}
		return NFNumber;
	}

	/* This method help on Click as Open Nf button Only */

	public boolean openNfClick() throws AWTException {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		try {
			log.info("current window id: " + driver.getWindowHandle());
			WebElement expandRootElement = commonUtils.expandRootElement(ls.openNFclick);
			expandRootElement.click();
			if (flag != true) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			assertTrue(false);
			logger.log(Status.ERROR, e);
		}
		return flag;

	}

	/* This method help on paste NF-Number then Click as Open Nf button */

	public boolean openNf(String number) throws Exception {
		boolean flag = false;
		try {
			NAPFLocators ll = new NAPFLocators();
			WebElement open_NF_input = ll.open_NF_input;
			boolean click = commonUtils.click(open_NF_input);
			open_NF_input.sendKeys(number);
			boolean openNfClick = openNfClick();
			if (openNfClick) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
			logger.log(Status.ERROR, e);
		}

		return flag;
	}

	/* This method help on validation Closure field values in General Tab */

	public Set<String> closureValuesValidation(int size, String Headers) throws Exception {
		Set<String> li = new TreeSet<String>();
		try {
			logger.log(Status.INFO, "Selecting the closure values");
			NAPFLocators ls = new NAPFLocators();
			WebElement clouserReason = commonUtils.expandRootElement(ls.clouserReason);
			if (Headers.equalsIgnoreCase("Swift")) {
				commonUtils.click(clouserReason);
				commonUtils.selectAllClean(clouserReason);
				commonUtils.click(commonUtils.expandRootElement(ls.clouserReasonToggle));
			}
			for (int i = 0; i < size; i++) {
				commonUtils.click(clouserReason);
				commonUtils.waitTime(1000);
				commonUtils.downenterkey(clouserReason);
				commonUtils.waitTime(2000);
				String attribute = commonUtils.expandRootElement(ls.clouserReason).getAttribute("value").trim();
				li.add(attribute);
			}
			if (Headers.equals("Online")) {
				commonUtils.expandRootElement(ls.clouserReason).clear();
			} else {
				commonUtils.expandRootElement(ls.clouserReason).clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
			logger.log(Status.ERROR, e);
		}

		return li;
	}

	/* This method help on validation Product field values in General Tab */

	public Set<String> productValuesValidation(int size, String Headers) throws Exception {
		Set<String> li = new TreeSet<String>();
		try {
			logger.log(Status.INFO, "Selecting the product values");
			NAPFLocators ls = new NAPFLocators();
			WebElement productReason = commonUtils.expandRootElement(ls.productReason);
			commonUtils.scrolltoPageHeight();
			if (Headers.equalsIgnoreCase("Swift")) {
				commonUtils.click(productReason);
				commonUtils.selectAllClean(productReason);
				commonUtils.click(commonUtils.expandRootElement(ls.productReasonToggle));
			}
			for (int i = 0; i < size; i++) {
				commonUtils.click(productReason);
				commonUtils.waitTime(1000);
				commonUtils.downenterkey(productReason);
				commonUtils.waitTime(2000);
				String attribute = commonUtils.expandRootElement(ls.productReason).getAttribute("value").trim();
				li.add(attribute);
			}
			if (Headers.equals("Online")) {
				commonUtils.expandRootElement(ls.productReason).clear();
			} else {
				commonUtils.expandRootElement(ls.productReason).clear();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(Status.ERROR, "product Values Validation");
			e.printStackTrace();
			assertTrue(false);
			logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, "productValuesValidation"));
			logger.log(Status.ERROR, e);
		}

		return li;
	}

	/*
	 * This method help on Closure value from sheet, and Closure value from browser
	 * are same validation
	 */
	public boolean listvalidation(Set<String> readclosureNameFromPATA, Set<String> closureValuesValidation) {
		logger.log(Status.INFO, "Validating the data between repository and web page");
		List<String> li = new ArrayList<String>();
		for (String string : readclosureNameFromPATA) {
			li.add(string);
		}
		List<String> li2 = new ArrayList<String>();
		for (String string : closureValuesValidation) {
			li2.add(string);
		}
		boolean flag = false;
		for (int i = 0; i < li.size(); i++) {
			if (li2.contains(li)) {
				flag = true;
			} else {
				flag = false;
				assertTrue(flag);
				logger.log(Status.ERROR, "both repository and webpage data are not same");
			}
		}
		return flag;
	}

	/* this method help on Select the Editor menu what we want */

	public boolean editorMenuSelect(String tabname) throws Exception {
		boolean flag = false;
		logger.log(Status.INFO, "Moving to " + tabname + " tab");
		commonUtils.waitTime(6000);
		NAPFLocators ns = new NAPFLocators();
		List<WebElement> menunames = commonUtils.expandRootsElement(ns.editormenu);
		for (int i = 0; i < menunames.size(); i++) {
			String attribute = menunames.get(i).getAttribute("actual-label");
			if (attribute.equalsIgnoreCase(tabname)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", menunames.get(i));
				logger.log(Status.INFO, "Clicking on the Tab:" + attribute);
				log.info("Clicking on the Tab:" + attribute);
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* this method help on Validation in Activity tab */

	public Map<String, String> ActivityTableData() {
		logger.log(Status.INFO, "Reading the Data from Activities tab");
		Map<String, String> ma = new TreeMap<String, String>();
		try {
			NAPFLocators ns = new NAPFLocators();
			commonUtils.waitTime(2000);
			WebElement firstfield = commonUtils.expandRootElement(ns.firstfield);
			WebElement secondfield = commonUtils.expandRootElement(ns.secondfield);
			WebElement thirdfield = commonUtils.expandRootElement(ns.thirdfield);
			WebElement fourthfield = commonUtils.expandRootElement(ns.fourthfield);
			WebElement fifthfield = commonUtils.expandRootElement(ns.fifthfield);
			ma.put("Erstelldatum", firstfield.getText());
			ma.put("Typ", secondfield.getText());
			ma.put("durch", thirdfield.getText());
			ma.put("Briefkasten", fourthfield.getText());
			ma.put("Status", fifthfield.getText());
			logger.log(Status.INFO, "table data found in activity tab");
			logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, "ActivityTableData"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return ma;
	}

	/* this method help on Stay in same window */

	public void defaultWindow() {
		commonUtils.switchToWindow(0);
	}

	/* This method help on Adding data in Notes Tab */

	public boolean notesAdd() {
		boolean flag = false;
		try {
			NAPFLocators ns = new NAPFLocators();
			commonUtils.waitTime(4000);
			logger.log(Status.INFO, "Clicking on Add notes");
			commonUtils.click(commonUtils.expandRootElement(ns.notesadd));
			WebElement textareades = commonUtils.expandRootElement(ns.textarea);
			commonUtils.type(textareades, "note area description", "note description");
			commonUtils.waitTime(2000);
			commonUtils.click(ns.saveButton);
			logger.log(Status.INFO, "Saving the notes created");
			commonUtils.waitTime(2000);
			WebElement expandRootElement3 = commonUtils.expandRootElement(ns.activityFieldValue);
			commonUtils.waitTime(2000);
			if (commonUtils.isElementPresent(expandRootElement3)) {
				flag = true;
				assertTrue(flag);
				logger.log(Status.INFO, "notes table edit and delete icon are present");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, null));
			}
		} catch (Exception e) {
    		e.printStackTrace();
			assertTrue(flag);
			logger.log(Status.ERROR, e);
		}

		return flag;
	}

	/* This method help on That notes Edit Fuction is checing Work in Notes Tab */

	public boolean notesEditFunction(String Content) {
		boolean flag = false;
		try {
			NAPFLocators ns = new NAPFLocators();
			logger.log(Status.INFO, "Notes table edit and delete icon Vaidation");
			WebElement notesEdit = commonUtils.expandRootElement(ns.notesEdit);
			commonUtils.JSClick(notesEdit);
			WebElement textareades = commonUtils.expandRootElement(ns.textarea);
			commonUtils.type(textareades, "note area description", Content);
			commonUtils.click(ns.saveButton);
			commonUtils.waitTime(2000);
			WebElement NoteTexttable = commonUtils.expandRootElement(ns.NoteTexttable);
			String text = NoteTexttable.getText();
			commonUtils.waitTime(2000);
			if (text.equalsIgnoreCase(Content)) {
				log.info("notes tabled edit action has been performed");
				logger.log(Status.INFO, "Notes table edit icon is present");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, null));
				flag = true;
				assertTrue(flag);
			} else {
				log.info("Unable to perform edit Action");
				logger.log(Status.INFO, "Unable to perform edit Action");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, null));
				assertTrue(flag);
			}
		} catch (Exception e) {
    		e.printStackTrace();
			assertTrue(flag);
			logger.log(Status.ERROR, e);
		}
		return flag;
	}

	/* This method help on That notes Delete Fuction is checing Work in Notes Tab */

	public boolean DeleteNotesFunction() throws Exception {
		boolean flag = false;
		try {
			NAPFLocators ns = new NAPFLocators();
			logger.log(Status.INFO, "Notes table edit and delete icon Vaidation");
			commonUtils.waitTime(4000);
			WebElement delete = commonUtils.expandRootElement(ns.notesDelete);
			if (commonUtils.isElementPresent(delete)) {
				delete.click();
				commonUtils.waitTime(2000);
				WebElement deletepopup = commonUtils.expandRootElement(ns.notesdeletepopup);
				WebElement deletepopupbutton = commonUtils.expandRootElement(ns.notesdeletepopupButton);
				commonUtils.waitTime(1000);
				deletepopupbutton.click();
				log.info("Notes tabled delete action has been performed");
				logger.log(Status.INFO, "Notes table delete icon is present and performed");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, null));
				commonUtils.waitTime(4000);
				if (true) {
					boolean hiddenjs = commonUtils.isHiddenjs(ns.activityFieldValue);
					if (hiddenjs == true) {
						flag = true;
						assertTrue(flag);
					} else {
						assertTrue(flag, "could not perform Note delete Action");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
			logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, null));
			assertTrue(flag);
		}
		return flag;
	}

	public boolean AppMenuSelection(String menuName) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		List<WebElement> app_Menu_List = ls.app_Menu_List;
		for (int i = 0; i < app_Menu_List.size(); i++) {
			String text = app_Menu_List.get(i).getAttribute("label");
			if (text.equals(menuName)) {
				log.info("the element :" + text + " is present in the page");
				logger.log(Status.INFO, "the element :" + text + " is present in the page");
				commonUtils.click(app_Menu_List.get(i));
				logger.log(Status.INFO, "And landed in " + text + "page");
				logger.addScreenCaptureFromPath(commonUtils.getScreenhot(driver, text + "page"));
				String text2 = commonUtils.expandRootElement(ls.landingPage_text).getText();
				if (text2.equalsIgnoreCase(menuName)) {
					flag = true;
					assertTrue(flag);
				}
			}
		}
		return flag;
	}

	/* This method help on Columm Fields Are Work to Sorting Check */

	public boolean column_field_sorting_validation(String menu) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<WebElement> userInboxNfField = commonUtils.expandRootsElement(ls.userInboxNfField);
		for (int i = 0; i < 1; i++) {
			boolean checkBox = userInboxNfField.get(i).isEnabled();
			boolean NF_Id_Sorting = userInboxNfField.get(i + 2).isEnabled();
			boolean status_def_Nf = userInboxNfField.get(i + 3).isEnabled();
			boolean transaktion = userInboxNfField.get(i + 4).isEnabled();
			boolean prozesssname = userInboxNfField.get(i + 5).isEnabled();
			boolean Letzte = userInboxNfField.get(i + 6).isEnabled();
			boolean Briefkasten = userInboxNfField.get(i + 7).isEnabled();
			boolean Anlieferung = userInboxNfField.get(i + 8).isEnabled();
			if (checkBox && NF_Id_Sorting && status_def_Nf && transaktion && Letzte && Briefkasten && Anlieferung
					&& prozesssname) {
				log.info("All field are present in Benutzerbriefkasten page");
				logger.log(Status.INFO, "All field are present in Benutzerbriefkasten page");
				commonUtils.scrollByright("pf-table");
				String firstNumber = null;
				if (menu.equalsIgnoreCase(NACHFORSCHUNGEN_ZUWEISEN) || menu.equalsIgnoreCase(ASSIGN_INVESTIGATION)
						|| menu.equalsIgnoreCase(ATTRIBUER_DES_RECHERCHES)
						|| menu.equalsIgnoreCase(ATTRIBUISCI_A_RICERCA)) {
					firstNumber = ls.FirstNf_number + "35]";
				} else {
					firstNumber = ls.FirstNf_number + "32]";
				}
				String text = commonUtils.expandRootElement(firstNumber).getText();
				log.info(text);
				WebElement NFField = userInboxNfField.get(i + 2);
				commonUtils.waitTime(2000);
				NFField.click();
				commonUtils.waitTime(2000);
				NFField.click();
				log.info("sorting the Nf Id field");
				logger.log(Status.INFO, "sorting the Nf Id field");
				String text2 = commonUtils.expandRootElement(firstNumber).getText();
				log.info(text2);
				if (!text.equals(text2)) {
					flag = true;
					assertTrue(true, "Nf Id sorting is working as expected");
					logger.log(Status.INFO, "Nf Id sorting is working as expected");
				} else {
					assertTrue(false, "Nf sorting is not working as expected");
					logger.log(Status.ERROR, "Nf sorting is not working as expected");
				}
			} else {
				logger.log(Status.ERROR, "Field is not displayed in User inbox");
				assertTrue(flag);
			}
		}
		return flag;
	}

	/* This method help on Checking User InboxGroupElement are disable or enable */

	public boolean userInboxGroupElementCheck() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(5000);
		log.info("Validating the group elements");
		logger.log(Status.INFO, "Validating the group elements ");
		boolean sourceGroupQueue = commonUtils.isdisabledjs(ls.SourceGroupQueue);
		boolean previousGroupQueue = commonUtils.isdisabledjs(ls.PreviousGroupQueue);
		boolean otherGroupQueue = commonUtils.isdisabledjs(ls.OtherGroupQueue);
		if (sourceGroupQueue && previousGroupQueue && otherGroupQueue) {
			log.info("All the group elements is disabled ");
			logger.log(Status.INFO, "All the group elements is disabled ");
		} else {
			log.info("All the group elements is enabled since the Nf id check box is clicked");
			logger.log(Status.INFO, "All the group elements is enabled since the Nf id check box is clicked");
			flag = true;
		}
		return flag;
	}

	/*
	 * This method help on Checking Assign Inverstigation User InboxGroupElement are
	 * disable or enable
	 */

	public boolean AssignInvesuserInboxGroupElementCheck() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(5000);
		log.info("Validating the group elements");
		logger.log(Status.INFO, "Validating the group elements ");
		boolean sourceGroupQueue = commonUtils.isdisabledjs(ls.AISourceGroupQueue);
		boolean previousGroupQueue = commonUtils.isdisabledjs(ls.AIPreviousGroupQueue);
		boolean otherGroupQueue = commonUtils.isdisabledjs(ls.AIOtherGroupQueue);
		if (sourceGroupQueue && previousGroupQueue && otherGroupQueue) {
			log.info("All the group elements is disabled ");
			logger.log(Status.INFO, "All the group elements is disabled ");
		} else {
			log.info("All the group elements is enabled since the Nf id check box is clicked");
			logger.log(Status.INFO, "All the group elements is enabled since the Nf id check box is clicked");
			flag = true;
		}
		return flag;
	}

	/*
	 * This method help on Search the NF id in User Inbox And return type is Nf-Id
	 */

	public WebElement NfsearchInUserInbox(String NFID, String data, String GroupQueySummary) throws Exception {
		String replace = null;
		if (NFID.contains("|")) {
			replace = NFID.replace("|", "");
		}
		NAPFLocators ls = new NAPFLocators();
		log.info("Searching the Nf number in Benutzerbriefkasten and moving to appropriate group");
		logger.log(Status.INFO, "Searching the Nf number in Benutzerbriefkasten and moving to appropriate group");
		commonUtils.scrollByright("pf-table");
		if (driver.getCurrentUrl().contains("userInbox")) {
			WebElement NFIdSort = commonUtils.expandRootElement(ls.NFIdSort);
			commonUtils.waitTime(3000);
			commonUtils.click(NFIdSort);
			commonUtils.click(NFIdSort);
		} else if (driver.getCurrentUrl().contains("assignInvestigation")) {
			commonUtils.waitTime(3000);
			log.info("landed in assign investigation");

		} else {
			WebElement NFIdSort = commonUtils.expandRootElement(ls.NFIdSort);
			commonUtils.waitTime(3000);
			commonUtils.click(NFIdSort);
		}

		WebElement Nf_id_text_data = null;
		commonUtils.scrollBy("pf-table", 100000);
		List<WebElement> userinboxrowcount = commonUtils.expandRootsElement(ls.userinboxrowcount);
		String rowindex = userinboxrowcount.get(userinboxrowcount.size() - 1).getAttribute("aria-rowindex");
		int totaluserInboxRow = Integer.parseInt(rowindex);
		commonUtils.scrollBy("pf-table", 0);
		int j = 0;
		int k = 0;
		int l = 0;
		for (int i = 0; i < totaluserInboxRow; i++) {
			if (k > 77) {
				k = 0;
				l = 0;
			}
			WebElement Nf_id_text = commonUtils.expandRootElement(ls.all_NfNumber_search + k + "]");
			commonUtils.waitTime(1000);
			String text = Nf_id_text.getText();
			if (text.equals(replace) || text.equals(NFID)) {
				String Nf_edit_icon = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('pf-toolbar > pf-menu-item')["
						+ l + "]";
				Nf_id_text_data = commonUtils.expandRootElement(Nf_edit_icon);

				if (data.equalsIgnoreCase("search")) {
					log.info("Found the NFid and click on the checkbox to check the group element enabling");
					logger.log(Status.INFO,
							"Found the NFid and click on the checkbox to check the group element enabling");
					commonUtils.scrollByleft("pf-table");
					WebElement expandRootElement = commonUtils
							.expandRootElement(ls.all_NfNumber_search_2 + j + 1 + ls.all_NfNumber_search_checkbox);
					commonUtils.JSClick(expandRootElement);
					log.info("clicked in respective checkbox");
				}
				break;
			}
			commonUtils.scrollBy("pf-table", j);
			k = k + 7;
			j++;
			l++;
		}

		return Nf_id_text_data;
	}

	/*
	 * This method help on perticuler NF number Search in SearchInverstigation and
	 * then a move Group Inbox
	 */

	public boolean open_Searched_NF(String Nf_id_element, String data, String menu2) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		log.info("scrolling to NF Id searched");
		logger.log(Status.INFO, "Scrolling to NF Id searched");
		WebElement nfsearchInUserInbox = NfsearchInUserInbox(Nf_id_element, data, "");
		if (nfsearchInUserInbox == null) {
			log.info("Unable to find the element from User Inbox");
			appMenuList(menu2);
			commonUtils.click(commonUtils.expandRootElement(ls.MoreOption));
			commonUtils.scrollintoView();
			commonUtils.waitTime(2000);
			commonUtils.click(ls.NFIdRangeFrom);
			commonUtils.type(ls.NFIdRangeFrom, "typing reading nf id in searchInvestigasion",
					Nf_id_element.replace("|", ""));
			commonUtils.scrolltoPageHeight();
			searchClick();
			commonUtils.waitTime(2000);
			String nfIdnew = commonUtils.expandRootElement(ls.NfIDMessCreate).getText();
			if (Nf_id_element.contains(nfIdnew)) {
				flag = true;
				if (commonUtils.isdisabledjs(ls.MovetouserInbox) && commonUtils.isdisabledjs(ls.movetounlock)) {
					WebElement checkbox = commonUtils.expandRootElement(ls.NfCheckBoxmess);
					commonUtils.click(checkbox);
					commonUtils.waitTime(2000);
					if (commonUtils.isdisabledjs(ls.MovetouserInbox) && commonUtils.isdisabledjs(ls.movetounlock)) {
						log.info("The searched NF is already found in userinbox and UnlockInvestigation is disabled");
						logger.log(Status.INFO,
								"The searched NF is already found in userinbox and UnlockInvestigation is disabled");
						assertTrue(flag,
								"The searched NF is already found in userinbox but unable to find while searching");
					} else {
						log.info("The searched NF id is not moved to userinbox");
						logger.log(Status.INFO, "The searched NF id is not moved to userinbox");
						log.info("clicking in searched NF edit button");
						logger.log(Status.INFO, "clicking in searched NF edit button");
						commonUtils.waitTime(2000);
						commonUtils.JSClick(ls.MovetouserInboxButton);
					}
				} else {
					flag = false;
					assertTrue(false, "ToUserInbox and UnlockInvestigation are is enabled");

				}
			} else {
				flag = false;
				assertTrue(false, "The searched NF-ID is not found on searching");
			}
		} else {
			if (nfsearchInUserInbox.isDisplayed()) {
				log.info("Edit search nf is displayed");
				logger.log(Status.INFO, "Edit search nf is displayed");
				assertTrue(true);
				log.info("clicking in searched NF edit button");
				logger.log(Status.INFO, "clicking in searched NF edit button");
				commonUtils.waitTime(2000);
				commonUtils.JSClick(nfsearchInUserInbox);
			}
		}
		commonUtils.waitTime(2000);
		commonUtils.switchToWindow(1);
		String readNFNumber = readNFNumber();
		if (readNFNumber.contains(Nf_id_element.replace("|", ""))) {
			log.info("opened the correct NF id");
			logger.log(Status.INFO, "Opened the correct NF id");
			flag = true;
			assertTrue(flag);
		} else {
			assertTrue(flag);
			logger.log(Status.ERROR, "Opened the in-correct NF id");
		}
		return flag;
	}

	/* This method help on Creating message Tab */

	public boolean CreateMessTab(String mess, String menu) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		boolean Kundenmitteilung = editorMenuSelect(menu);
		commonUtils.waitTime(2000);
		boolean enabled = ls.customer_description.isDisplayed();
		if (enabled) {
			log.info("customer description is disabled");
			logger.log(Status.INFO, "Customer description is disabled");
			assertTrue(true);
			WebElement createmess = ls.CreateMess;
			if (createmess.isEnabled()) {
				log.info("clicking on create mess");
				logger.log(Status.INFO, "Clicking on create mess");
				boolean jsClick = commonUtils.JSClick(createmess);
				boolean customer_description = ls.customer_description.isEnabled();
				if (customer_description) {
					log.info("Customer description is enabled");
					logger.log(Status.INFO, "Customer description is enabled");
					commonUtils.waitTime(2000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('value','" + mess + "')", ls.customer_description);
					// commonUtils.type(ls.customer_description, "Enter mess", mess);
					log.info("Saving the mess created");
					logger.log(Status.INFO, "Saving the mess created");
					commonUtils.waitTime(2000);
					WebElement element = (WebElement) js.executeScript(
							"return document.querySelector(\"pf-section.col-md-4.hydrated.inside-grid > pf-menu-item\").shadowRoot.querySelector(\"div.outer.leaf > a\")");
					js.executeScript("arguments[0].click();", element);
					assertTrue(jsClick, "The mess created is not added to the table row");
					logger.log(Status.INFO, "The mess created is added to the table row");
					flag = true;
				}
			} else {
				assertTrue(false);
				log.info("create mess is disabled");
				logger.log(Status.ERROR, "create mess is disabled");

			}
		} else {
			assertTrue(false, "customer description is enabled");
			log.info("customer description is enabled");
			logger.log(Status.ERROR, "customer description is enabled it should be disbaled");

		}
		return flag;
	}

	/* This method Help on What we want to move Group Option */

	public void seelctGroupOption(String group, String groupname) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		log.info("Selecting the Group " + group);
		logger.log(Status.INFO, "Selecting the Group " + group);
		List<WebElement> userInboxHeader = ls.userInboxHeader;
		for (int i = 0; i < userInboxHeader.size(); i++) {
			String text = userInboxHeader.get(i).getText().trim();
			if (group.equalsIgnoreCase(text)) {
				boolean click = commonUtils.click(userInboxHeader.get(i));
				log.info("clicked in " + text);
				if (group.equalsIgnoreCase("zu anderem GBK")) {
					WebElement expandRootElement = commonUtils.expandRootElement(ls.groupQueueMoveDataUserInbox);
					commonUtils.JSClick(expandRootElement);
					commonUtils.waitTime(2000);
					commonUtils.selectAllClean(expandRootElement);
					commonUtils.type(expandRootElement, "moving to repective group queue", groupname);
					commonUtils.downenter(expandRootElement);
					WebElement saveGroup = ls.saveGroup;
					saveGroup.click();
					logger.log(Status.INFO, "clicked in " + text + " Gbk");
					commonUtils.waitTime(5000);
					break;
				}

			}

		}

	}

	/*
	 * this method help on Select the NF number in Assign Inverstigation tab Then
	 * move a Group queue
	 */

	public boolean assignInvestigationSoruceGropvalidation(String group) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		log.info("Selecting the Group " + group);
		logger.log(Status.INFO, "Selecting the Group " + group);
		List<WebElement> userInboxHeader = commonUtils.expandRootsElement(ls.AIGroupQueButton);
		for (int i = 0; i < userInboxHeader.size(); i++) {
			WebElement AiGroupQueButrequired = userInboxHeader.get(i);
			String text = AiGroupQueButrequired.getText().trim();
			commonUtils.waitTime(3000);
			if (group.equalsIgnoreCase(text)) {
				log.info("Selecting the Group " + group);
				commonUtils.waitTime(2000);
				WebElement AIFirstViewButton1 = commonUtils.expandRootElement(ls.AIFirstViewButton);
				commonUtils.click(AIFirstViewButton1);
				commonUtils.waitTime(2000);
				commonUtils.switchToWindow(1);
				commonUtils.waitTime(2000);
				commonUtils.switchToWindow(0);
				// Actions ac=new Actions(driver);
				// ac.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).build().perform();
				commonUtils.waitTime(2000);
				WebElement aISourceGroup = commonUtils.expandRootElement(ls.AISourceGroup);
				aISourceGroup.click();
				commonUtils.waitTime(2000);
				break;
			}
		}
		try {
			WebElement SwichwindowError = commonUtils.expandRootElement(ls.SwichwindowError);
			if (commonUtils.isElementPresent(SwichwindowError)) {
				commonUtils.waitTime(2000);
				WebElement SwichwindowerrorText = commonUtils.expandRootElement(ls.SwichwindowerrorText);
				commonUtils.waitTime(2000);
				WebElement SwichwindowPOPupclose = commonUtils.expandRootElement(ls.SwichwindowPOPupclose);
				commonUtils.waitTime(2000);
				commonUtils.click(SwichwindowPOPupclose);
				flag = true;
				log.info("Unable to move source group becouse another window is open please close window");
				logger.log(Status.INFO,
						"Unable to move source group becouse another window is open please close window");
				assertTrue(flag);
			}
		} catch (Exception e) {
			log.info("Successfully move to source group with no error pop up");
			logger.log(Status.INFO, "Successfully move to source group with no error pop up");
			assertTrue(flag);
		}
		return flag;
	}

	public String assignInvestigationselectGrouOption(String appmenu, String user, String group, String data,
			String menu, String nfid) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		List<String> tosourceQueName = null;
		commonUtils.waitTime(2000);
		log.info("Selecting the Group " + group);
		logger.log(Status.INFO, "Selecting the Group " + group);
		List<WebElement> userInboxHeader = commonUtils.expandRootsElement(ls.AIGroupQueButton);
		for (int i = 0; i < userInboxHeader.size(); i++) {
			WebElement AiGroupQueButrequired = userInboxHeader.get(i);
			String text = AiGroupQueButrequired.getText().trim();
			commonUtils.waitTime(3000);
			if (group.equalsIgnoreCase(text)) {
				commonUtils.waitTime(3000);
				boolean click = commonUtils.click(AiGroupQueButrequired);
				commonUtils.waitTime(5000);
				if (click) {
					assertTrue(click);
				} else {
					assertTrue(click, "unable to click the group queue button");
				}
				logger.log(Status.INFO, "clicked in " + text + " Gbk");
				commonUtils.waitTime(5000);
				break;
			} else if (group.equalsIgnoreCase("ad altro gruppo") || group.equalsIgnoreCase("� un autre groupe")
					|| group.equalsIgnoreCase("zu anderem GBK") || group.equalsIgnoreCase("to other group")) {
				boolean click = commonUtils.click(userInboxHeader.get(userInboxHeader.size() - 1));
				commonUtils.waitTime(5000);
				WebElement expandRootElement = commonUtils.expandRootElement(ls.groupQueueMoveData);
				commonUtils.JSClick(expandRootElement);
				commonUtils.waitTime(2000);
				commonUtils.selectAllClean(expandRootElement);
				commonUtils.type(expandRootElement, "moving to repective group queue", data);
				commonUtils.downenter(expandRootElement);
				WebElement saveGroup = ls.saveGroup;
				saveGroup.click();
				break;
			} else if (group.equalsIgnoreCase("to source group") || group.equalsIgnoreCase("zu originalem GBK")
					|| group.equalsIgnoreCase("au groupe d'origine") || group.equalsIgnoreCase("al gruppo fonte")) {
				log.info("Selecting the Group " + group);
				commonUtils.waitTime(2000);
				WebElement AIFirstViewButton1 = commonUtils.expandRootElement(ls.AIFirstViewButton);
				commonUtils.click(AIFirstViewButton1);
				commonUtils.switchToWindow(1);
				commonUtils.waitTime(3000);
				editorMenuSelect(menu);
				commonUtils.waitTime(2000);
				List<WebElement> activitiesRow = commonUtils.expandRootsElement(ls.AIActivietisRows);
				tosourceQueName = new ArrayList<String>();
				int k = 3;
				for (int j = 0; j < activitiesRow.size(); j++) {
					WebElement queueName = commonUtils.expandRootElement(ls.ActivityQueueName + k + "]");
					commonUtils.waitTime(1000);
					String tosourceName = queueName.getText();
					tosourceQueName.add(tosourceName);
					k = k + 8;
				}
				commonUtils.loadURL();
				appMenuList(appmenu);
				AssignInvestigationValidation(user, null);
				NfsearchInUserInbox(nfid, "search", "");
				commonUtils.waitTime(2000);
				WebElement aISourceGroup = commonUtils.expandRootElement(ls.AISourceGroup);
				aISourceGroup.click();
				commonUtils.waitTime(2000);
				break;
			}

		}
		String sourceQueueName;
		if (tosourceQueName == null) {
			sourceQueueName = null;
		} else {
			sourceQueueName = tosourceQueName.get(tosourceQueName.size() - 1);
		}
		return sourceQueueName;

	}

	/*
	 * This method help on Select the GroupQueue Option in Group Queue Summary Tab
	 */

	public boolean groupQueueSummary(String Groupsummary) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		log.info("Selecting the Group queue summary app menu");
		logger.log(Status.INFO, "Selecting the Group queue summary app menu");
		List<WebElement> groupQueueList = commonUtils.expandRootsElement(ls.groupQueueList);
		for (int i = 12; i < groupQueueList.size(); i++) {
			String text = groupQueueList.get(i).getText();
			if (text.equals(Groupsummary)) {
				log.info("Selecting the Group summary :" + Groupsummary);
				logger.log(Status.INFO, "Selecting the Group summary :" + Groupsummary);
				// commonUtils.scrollintoView(groupQueueList.get(i));
				commonUtils.click(groupQueueList.get(i));
				flag = true;
				assertTrue(flag);
				log.info("clicked in Group summary :" + Groupsummary);
				logger.log(Status.INFO, "Clicked in Group summary :" + Groupsummary);
				break;
			}
			i = i + 3;
		}
		commonUtils.waitTime(7000);
		return flag;
	}

	/* this method help on Screen Zoom Out */
	public void Screenzoomout() throws Exception {
		Robot r = new Robot();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	/* this method help on Screen Zoom Out at 2 times only */
	public void zoominwith2() throws AWTException {
		// TODO Auto-generated method stub
		Robot r = new Robot();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_SUBTRACT);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	/* this method help on Screen Zoom In */
	public void Screenzoomin() throws Exception {
		Robot r = new Robot();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_ADD);
			r.keyRelease(KeyEvent.VK_ADD);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	/* this method help on open a tab and Swith to next Window */
	public void opentabandSwitch() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + ReadData.getTestProperty("groupsummaryUrl") + "','_blank');");
		commonUtils.switchToWindow(1);
	}

	/* This method help on Checking the CalanderDays In Onhold Remainder */

	public boolean onHoldcalanderdayscheck(String testdata) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		Screenzoomout();
		commonUtils.waitTime(3000);
		if (testdata.equalsIgnoreCase("Ausland") || testdata.equalsIgnoreCase("Foreign payments")
				|| testdata.equalsIgnoreCase("Etranger") || testdata.equalsIgnoreCase("estero")) {
			WebElement periodcalederdays = ls.periodcalederdays;
			periodcalederdays.sendKeys("d");
		} else {
			WebElement periodcalederday = ls.periodcalederday;
			periodcalederday.sendKeys("d");
		}
		commonUtils.waitTime(5000);
		String errormess = null;
		log.info("periodcalanderdayserrormess");
		WebElement ele = commonUtils.expandRootElement(ls.periodcalanderdayserrormess);
		String attribute = ele.getAttribute("aria-hidden");
		if (attribute.equalsIgnoreCase("false")) {
			flag = true;
			assertTrue(flag);
			log.info("Period of days doesnt accept alphabets");
			logger.log(Status.INFO, "Period of days doesnt accept alphabets");
			logger.log(Status.INFO, commonUtils.getScreenhot(driver, "onHoldcalanderdayscheck"));
		} else {
			log.info("Period of days accept alphabets");
			logger.log(Status.FAIL, commonUtils.getScreenhot(driver, "onHoldcalanderdayscheck"));
			assertTrue(flag, "Period of days accept alphabets hence skiping the other language validation");
		}
		commonUtils.waitTime(3000);
		Screenzoomin();
		return flag;
	}

	/* This method help on landing the what we want page */

	String landinfpageheading(WebElement locator) {
		log.info("Validating the Header Text in Landing page");
		logger.log(Status.INFO, "Validating the Header Text in Landing page");
		String text = locator.getText();
		return text;
	}

	/* This method help on App menu select name and Check landing as same name */

	public boolean searchpageHeadingValidation(String appmenu) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		WebElement landinfpageheading = commonUtils.expandRootElement(ls.SearchInvestigationLandingText);
		String text = landinfpageheading.getText();
		if (text.equalsIgnoreCase(appmenu)) {
			log.info("Landed in " + text + " page");
			logger.log(Status.INFO, "Landed in " + text + "page");
			flag = true;
			assertTrue(true);
		} else {
			log.info("Landed in " + text + "page");
			logger.log(Status.ERROR, "Landed in " + text + "page");
		}
		return flag;
	}

	/*
	 * This method help on Checking the Search Inverstigation option button are is
	 * clickable or non-Clickable
	 */

	public boolean searchpageoptionbutton() throws Exception {
		boolean flag = false;
		log.info("Validating the more option - reset and search buttons are displayed and clickable");
		logger.log(Status.INFO, "Validating the more option - reset and search buttons are displayed and clickable");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(4000);
		commonUtils.scrollintoView();
		if (commonUtils.isClickable(commonUtils.expandRootElement(ls.MoreOption))) {
			if (commonUtils.isClickable(ls.ResetButton) == true) {
				if (commonUtils.isClickable(ls.SearchButton) == true) {
					flag = true;
					assertTrue(flag, "the fields in search investigation is not displayed and clickable");

				}
			}
		} else {
			assertTrue(flag, "the fields in search investigation is displayed and non clickable");
		}

		return flag;
	}

	/* This method help on search investigation Field validation */

	public List<String> allSearchFieldValidation() throws Exception {
		boolean flag = false;
		log.info("Reading the search Field from web page on clicking more options");
		logger.log(Status.INFO, "Reading the Search Fields of DC from web page on clicking more options");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.click(commonUtils.expandRootElement(ls.MoreOption));
		commonUtils.waitTime(2000);
		commonUtils.scrolltoPageHeight();
		List<String> browserField = new ArrayList<String>();
		try {
			// reading all field label and adding it to list
			ls.allSearchcomboboxField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.allSearchaccountField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.allSearchcheckboxField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.pfpktnraccountfield.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			ls.allSearchpfTextField.forEach((WebElement name) -> {
				browserField.add(name.getAttribute("label").trim());
			});

			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				log.info("custom_field element is present in this page");
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils
								.expandRootElement(ls.custom_field_one + i + ls.custom_field_two);
						browserField.add(expandRootElement.getText().trim());
					}
				}

			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	/* This method help on What we want to search in data in Search Investigation */

	public void SearchInvestigationsearch(String locator, String name, String data) throws Exception {
		log.info(name + " search validation");
		logger.log(Status.INFO, name + " search validation");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		WebElement processNameInput = commonUtils.expandRootElement(locator);
		commonUtils.waitTime(3000);
		commonUtils.JSClick(processNameInput);
		commonUtils.waitTime(2000);
		commonUtils.type(processNameInput, "type data in " + name, data);
	}

	/* This method help on Click Search button in Search Investigation */

	public void searchClick() throws Exception {
		log.info("clicking in search button");
		logger.log(Status.INFO, "clicking in search button");
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		commonUtils.JSClick(ls.SearchButton);
	}

	/*
	 * This method help on Click Search button in Search Investigation then Show a
	 * Result validation
	 */

	public boolean SearchResult(String data, String data2, String HeaderName) throws Exception {
		boolean flag = false;
		log.info("search Results validation");
		logger.log(Status.INFO, "Search Results validation");
		commonUtils.waitTime(4000);
		NAPFLocators ls = new NAPFLocators();
		try {
			if (commonUtils.expandRootElement(ls.PopUPtab).isDisplayed()) {
				WebElement PopUptext = commonUtils.expandRootElement(ls.PopUptext);
				if (PopUptext.getText().equalsIgnoreCase("Zu viele Resultate gefunden.")) {
					WebElement ClosButton = commonUtils.expandRootElement(ls.CloseButton);
					ClosButton.click();
					flag = true;
					assertTrue(flag, "the popup is present and the close button is not found");

				} else {
					log.info("Text in PopUp is not same as expected");
					logger.log(Status.INFO, "Text in PopUp is not same as expected");
					assertTrue(flag, "the popup is present and the close button is not found");
				}
			}
		} catch (Exception e) {
			log.info("Popup is not found");
			logger.log(Status.INFO, "Pop up is not found");
			String text = ls.searchResults.getText();
			if (text.equals("Suchresultate")) {
				log.info("Search result data is found");
				logger.log(Status.INFO, "Search result data is found");
				int SearchResultNumber = noOfSearchResult();
				if (commonUtils.isdisabledjs(ls.touserInbox) != true
						&& commonUtils.isdisabledjs(ls.unlockInverstigation) != true) {
					log.info("To user inbox and Unlock investigation are in enabled status");
					logger.log(Status.INFO, "To user inbox and Unlock investigation are in enabled status");
					assertTrue(flag);
				} else {
					log.info("To user inbox and Unlock investigation are in disabled status");
					logger.log(Status.INFO, "To user inbox and Unlock investigation are in disabled status");
					int noofResultDataValidation = NoofResultDataValidation(SearchResultNumber, data, HeaderName,
							data2);
					if (SearchResultNumber == noofResultDataValidation) {
						flag = true;
						assertTrue(flag, "the userinbox search result is not same");
					}
				}
			}
		}
		return flag;
	}

	/* this method help on how many data if we want Check */

	public int NoofResultDataValidation(int NoOfRow, String data, String headername, String data2) throws Exception {
		log.info("Table Data Validation ");
		logger.log(Status.INFO, "Table Data Validation ");
		NAPFLocators ls = new NAPFLocators();
		int tableDatacount = 0;
		if (headername.equalsIgnoreCase("Prozessname") || headername.equalsIgnoreCase("Transaktion")
				|| headername.equalsIgnoreCase("Status der NF") || headername.equalsIgnoreCase("W�hrung")
				|| headername.equalsIgnoreCase("Anlieferung")
				|| headername.equalsIgnoreCase("Postkonto-Nr. Auftraggeber")) {
			List<WebElement> searchTableDatas = commonUtils.expandRootsElement(ls.searchTableData);
			int j = 1;
			int k = 34;
			for (int i = 0; i < NoOfRow; i++) {
				if (k > 164) {
					k = 34;
				}
				String text = searchTableDatas.get(k).getText();
				commonUtils.scrollBy("pf-table", j);
				if (text.equalsIgnoreCase(data)) {
					k = k + 10;
					tableDatacount++;
					commonUtils.waitTime(1000);
					log.info("Search result as per search we done");
				}
				j++;
			}

		} else if (headername.equalsIgnoreCase("Betrag") || headername.equalsIgnoreCase("NF-ID")) {
			int j = 1;
			int k = 34;
			for (int i = 0; i < NoOfRow; i++) {
				if (k > 117) {
					k = 34;
				}
				String query = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid-cell-content')["
						+ k + "]";
				WebElement nfid = commonUtils.expandRootElement(query);
				String text = nfid.getText();
				if (text.equalsIgnoreCase(data)) {
					double pagedata = Double.parseDouble(text);
					double pagefromdata = Double.parseDouble(data);
					double pagetodata = Double.parseDouble(data2);
					if ((pagefromdata == pagedata || pagedata > pagefromdata)
							&& (pagedata == pagetodata || pagedata < pagetodata)) {
						k = k + 11;
						tableDatacount++;
						commonUtils.scrollBy("pf-table", j);
						commonUtils.waitTime(2000);
						log.info("Search result as per search we done");
					}
				} else {
					if (headername.equalsIgnoreCase("NF-ID")) {
						k = k + 11;
					} else {
						k = k + 6;
						String query1 = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid-cell-content')["
								+ k + "]";
						WebElement amount = commonUtils.expandRootElement(query1);
						String amounttext = amount.getText();
						double pagedata = Double.parseDouble(amounttext);
						double pagefromdata = Double.parseDouble(data);
						double pagetodata = Double.parseDouble(data2);
						if ((pagefromdata == pagedata || pagedata > pagefromdata)
								&& (pagedata == pagetodata || pagedata < pagetodata)) {
							tableDatacount++;
							commonUtils.scrollBy("pf-table", j);
							commonUtils.waitTime(1000);
							log.info("Search result as per search we done");
						}
						k = k + 5;
					}

				}
				j++;
			}
		} else {
			int k = 5;
//			for (int i = 1; i <= NoOfRow; i++) {
//				if (k > 11) {
//					k = 0;
//				}
			commonUtils.waitTime(2000);
			commonUtils.scrollBy("pf-table", 10000);
			String query1 = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-tooltip')["
					+ k + "]";
			WebElement tooltip = commonUtils.expandRootElement(query1);
			if (commonUtils.isElementPresent(tooltip)) {
				commonUtils.waitTime(1000);
				commonUtils.mouseHover(tooltip);
				commonUtils.waitTime(1000);
				String erstellDatum = ls.erstellDatum.getText();
				commonUtils.waitTime(2000);
				String[] date = erstellDatum.split(" ");
				String dateinput = date[0].replace(".", "");
				String dataFrom = data.replace(".", "");
				String dataTo = data2.replace(".", "");
				int inputdate = Integer.parseInt(dateinput);
				int fromdata = Integer.parseInt(dataFrom);
				int todata = Integer.parseInt(dataTo);
				if ((inputdate >= fromdata) && (inputdate <= todata)) {
					commonUtils.waitTime(1000);
					log.info("The data present in the search table in inside the NF data range searched");
				}
			}
		}
		return tableDatacount;
	}

	/* This method help on edit the Search investigation data */

	public boolean NFdatevalidation(String data) throws Exception {
		boolean flag = false;
		log.info("NF date from and to date validation");
		logger.log(Status.INFO, "NF date from and to date validation");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.scrolloutView();
		commonUtils.waitTime(3000);
		commonUtils.scrollBy("pf-table", 10000);
		commonUtils.waitTime(2000);
		WebElement ibutton = commonUtils.expandRootElement(ls.ibutton);
		commonUtils.waitTime(2000);
		commonUtils.click(ibutton);
		String erstellDatum = ls.erstellDatum.getText();
		commonUtils.waitTime(2000);
		String[] date = erstellDatum.split(" ");
		String dateinput = date[0];
		commonUtils.waitTime(2000);
		if (dateinput.equalsIgnoreCase(data)) {
			log.info("from date and to date same as expected");
			logger.log(Status.INFO, "from date and to date same as expected");
			flag = true;
			assertTrue(flag);
		} else {
			log.info("From date and to date is not same as expected");
			logger.log(Status.INFO, "From date and to date is not same as expected");
			assertTrue(flag, "From date and to date is not same as expected");
		}

		return flag;
	}

	/* This method help on Click Reset Button in Search investigation tab */

	public void ClickReset() throws Exception {
		log.info("click reset button works ");
		logger.log(Status.INFO, "click reset button works ");
		NAPFLocators ls = new NAPFLocators();
		WebElement resetbutton = ls.ResetButton;
		commonUtils.click(resetbutton);

	}

	/* This method help on Click Download Button in Search investigation tab */

	public void downloadClick() throws Exception {
		log.info("clicking on download button");
		logger.log(Status.INFO, "clicking on download button");
		NAPFLocators ls = new NAPFLocators();
		WebElement downloadClick = ls.downloadclick;
		commonUtils.click(downloadClick);
		log.info("download button is working ");
		logger.log(Status.INFO, "download button is working ");
	}

	/* This method help on How many data gaven in Search investigation tab */

	public int noOfSearchResult() throws Exception {
		commonUtils.waitTime(4000);
		NAPFLocators ls = new NAPFLocators();
		String NumberText = ls.NoOfResults.getText();
		log.info("reading the number search result of data");
		logger.log(Status.INFO, "reading the number search result of data");
		String[] Number = NumberText.split("Anzahl Resultate:");
		String string = Number[1];
		int SearchResultNumber = Integer.parseInt(string);
		return SearchResultNumber;
	}

	/*
	 * This method help on Click app header Search Button
	 * 
	 * public void headersearchButton() throws Exception {
	 * log.info("headersearchButton button goes to Click "); logger.log(Status.INFO,
	 * "headersearchButton button goes to Click "); commonUtils.waitTime(3000);
	 * NAPFLocators ls = new NAPFLocators(); WebElement headersearchButton =
	 * ls.headersearchButton; commonUtils.waitTime(2000);
	 * commonUtils.click(headersearchButton); }
	 */

	/*
	 * This method help on Validating the ABP PopUptab and Click GoToDab option in
	 * Popup
	 */

	public boolean ABPPopupTab() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(3000);
		NAPFLocators ls = new NAPFLocators();
		log.info("APB PopUp tab is open");
		logger.log(Status.INFO, "APB PopUp tab is open");
		commonUtils.waitTime(3000);
		if (commonUtils.expandRootElement(ls.APBPopupTab).isDisplayed()) {
			WebElement APBPopupheadtext = commonUtils.expandRootElement(ls.APBPopupheadtext);
			flag = true;
			assertTrue(flag);
			if (APBPopupheadtext.getText().equalsIgnoreCase("ABP automatische Suche")) {
				flag = true;
				assertTrue(flag);
				WebElement APBPopupText = ls.APBPopupText;
				WebElement APBPopup2text = ls.APBPopup2text;
				if (APBPopupText.getText().equalsIgnoreCase("Insufficient search criteria to perform automatic search.")
						&& APBPopup2text.getText()
								.equalsIgnoreCase("Please go to DAB application for doing manual search.DE")) {
					flag = true;
					assertTrue(flag);
				} else {
					log.info("APB PopUp FirstLine and SecondLine name is not same");
					logger.log(Status.INFO, "APB PopUp FirstLine and SecondLine name is not same");
					assertTrue(flag, "APB PopUp FirstLine and SecondLine name is not same");
				}

			} else {
				log.info("Text in APB PopUp header is not same as expected");
				logger.log(Status.INFO, "Text in APB PopUp header is not same as expected");
				assertTrue(flag, "Text in APB PopUp header is not same as expected");
			}
			if (commonUtils.isClickable(ls.GoToDab) && commonUtils.isClickable(ls.abbrechen)) {
				commonUtils.click(ls.GoToDab);
				commonUtils.waitTime(4000);
				log.info("GO TO Dab is Clickable");
				logger.log(Status.INFO, "GO TO Dab is Clickable");
				flag = true;
				assertTrue(flag);
			} else {
				log.info("GOTODab button is not Clickable");
				logger.log(Status.INFO, "GOTODab button is not Clickable");
				assertTrue(flag, "GOTODab button is not Clickable");
			}
		} else {
			log.info("APB PopUp header is not opend");
			logger.log(Status.INFO, "APB PopUp header is not opend");
			assertTrue(flag, "APB PopUp header is not opend");
		}
		if (flag) {
			assertTrue(flag);
		} else {
			assertTrue(flag, "unable to find popup element");
		}
		return flag;
	}

	/* This method help on Select Data from Attach Transaction Option */

	public boolean attachTransactionSelecter(String data) throws Exception {
		boolean flag = true;
		commonUtils.waitTime(3000);
		NAPFLocators ls = new NAPFLocators();
		log.info("Landing attach Transaction tab ");
		logger.log(Status.INFO, "Landing attach Transaction tab ");
		if (data.equalsIgnoreCase("PostFinance Card")) {
			flag = true;
			assertTrue(flag);
			if (driver.getCurrentUrl().contains("KARTEN")) {
				commonUtils.click(ls.SelectTRKARTEN);
				commonUtils.downenter(null);
				commonUtils.click(ls.AttachTransactionButton);
				flag = true;
				assertTrue(flag);
			} else {
				log.info("unable to click attach Transaction button in KARTEN ");
				logger.log(Status.INFO, "unable to click attach Transaction button in KARTEN ");
				assertTrue(flag, "unable to click attach Transaction button in KARTEN ");
			}
		} else {
			if (driver.getCurrentUrl().contains("ZAHLUNG")) {
				commonUtils.click(ls.SelectTRZAHLUNG);
				commonUtils.downenter(null);
				commonUtils.click(ls.AttachTransactionButton);
				flag = true;
				assertTrue(flag);

			} else {
				log.info("unable to click attach Transaction button in ZAHLUNG ");
				logger.log(Status.INFO, "unable to click attach Transaction button in ZAHLUNG ");
				assertTrue(flag, "unable to click attach Transaction button in ZAHLUNG ");
			}
		}
		return flag;
	}

	/* This method help on Click the Reuest Status button After AttachTracnsation */

	public boolean RequestStatus() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		log.info("Going to click Request Status button");
		logger.log(Status.INFO, "Going to click Request Status button");
		if (ls.RequestStatus.isDisplayed() && commonUtils.isClickable(ls.RequestStatus)) {
			commonUtils.click(ls.RequestStatus);
			if (commonUtils.expandRootElement(ls.ABPAutomaticSearchPopup).isDisplayed()) {
				assertTrue(flag,
						"Attaching transaction taking long time, Please try opening investigation after some time.");
			}
			log.info("Request Status button is Clickable");
			logger.log(Status.INFO, "Request Status button is Clickable");
			flag = true;
			assertTrue(flag);
		} else {
			log.info("unable to click Request Status button");
			logger.log(Status.INFO, "unable to click Request Status button");
			assertTrue(flag, "unable to click Request Status button");
		}
		return flag;

	}

	/* This method help on IDA results Fields validating */

	public boolean IDAResultsfieldValidation() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(4000);
		NAPFLocators ls = new NAPFLocators();
		String text = commonUtils.expandRootElement(ls.IDA_Result).getText();
		if (text.equals("Resultate von IDA")) {
			log.info("Landing in IDA Result Editor Tab");
			logger.log(Status.INFO, "Landing in IDA Result Editor Tab");
			List<WebElement> headerIDAResult = commonUtils.expandRootsElement(ls.headerIDAResult);
			for (int i = 0; i < headerIDAResult.size(); i++) {
				boolean displayed = headerIDAResult.get(i).isDisplayed();
				if (displayed) {
					String headername = headerIDAResult.get(i).getText();
					log.info(headername + " is found in IDA REsult Tab");
					logger.log(Status.INFO, headername + " is found in IDA REsult Tab");
					flag = true;
					assertTrue(flag);
				} else {
					assertTrue(flag, "The Field are not present in IDA REsult since no transaction is added");
				}
			}
		}
		return flag;
	}

	/* This method help on IDA results Headers validating */

	public boolean IDAResultHeaderValidation() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		log.info("Validating the Buttons and dropdown in IDA result");
		logger.log(Status.INFO, "Validating the Buttons and dropdown in IDA result");
		boolean idaDetailsFromDropDown = ls.idaDetailsFromDropDown.isDisplayed();
		boolean populateProductfield = ls.populateProductfield.isDisplayed();
		boolean getAllLinkedTrans = ls.getAllLinkedTrans.isDisplayed();
		if (idaDetailsFromDropDown && getAllLinkedTrans) {
			log.info("Found the ida Details From DropDown getAllLinkedTrans are in enabled status ");
			logger.log(Status.INFO, "Found the ida Details From DropDown getAllLinkedTrans are in enabled status ");
			flag = true;
			assertTrue(flag);
			if (populateProductfield != true) {
				log.info("Found the populateProductfield getAllLinkedTrans are in disabled status ");
				logger.log(Status.INFO, "Found the populateProductfield getAllLinkedTrans are in disabled status ");
				assertTrue(flag);
			} else {
				log.info(
						"Found the populateProductfield getAllLinkedTrans are in enabled status since the transaction checkbox is selected");
				logger.log(Status.INFO,
						"Found the populateProductfield getAllLinkedTrans are in enabled status since the transaction checkbox is selected");
				flag = false;
			}
		} else {
			log.info("Found the idaDetailsFromDropDown getAllLinkedTrans are in disabled status ");
			logger.log(Status.INFO, "Found the idaDetailsFromDropDown getAllLinkedTrans are in enabled status ");
			assertTrue(flag);
		}
		return flag;
	}

	public boolean IDAResultViewanddeletevalidation() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		log.info("Validating the view Buttons and delete and toolkit button");
		logger.log(Status.INFO, "Validating the view Buttons and delete and toolkit button");
		WebElement IDACheckBoxTrans = commonUtils.expandRootElement(ls.IDACheckBoxTrans);
		WebElement IDAActionViewTrans = commonUtils.expandRootElement(ls.IDAActionViewTrans);
		WebElement IDAActionDeleteTrans = commonUtils.expandRootElement(ls.IDAActionDeleteTrans);
		WebElement IDAActionToolTip = commonUtils.expandRootElement(ls.IDAActionToolTip);
		if (commonUtils.isClickable(IDAActionViewTrans) && commonUtils.isClickable(IDAActionDeleteTrans)
				&& commonUtils.isClickable(IDAActionToolTip) && commonUtils.isClickable(IDACheckBoxTrans)) {
			log.info("Found the ida Details From All buttons are in Clickable status ");
			logger.log(Status.INFO, "Found the ida Details From All buttons are in Clickable status");
			flag = true;
			assertTrue(flag);
		} else {
			log.info("Found the ida Details From All buttons are in disable status ");
			logger.log(Status.INFO, "Found the ida Details From All buttons are in disable status ");
			assertTrue(flag);
		}
		return flag;
	}

	/* This method help on Read the IDA results Transaction number */

	public String IDAResultTransNumber() throws Exception {
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		log.info("Validating the Buttons and dropdown in IDA result");
		logger.log(Status.INFO, "Validating the Buttons and dropdown in IDA result");
		String transactioNumber = commonUtils.expandRootElement(ls.IDAResultTransacnumber).getText();
		return transactioNumber;
	}

	/* This method help on create Check back for third party */

	public boolean createCheckbackforThirdparty() throws Exception {
		boolean flag = false;
		commonUtils.waitTime(2000);
		log.info("Checking the create Check back for third party");
		logger.log(Status.INFO, "Checking the create Check back for third party");
		NAPFLocators ls = new NAPFLocators();
		boolean click = commonUtils.click(ls.createCheckboxbocThirdParty);
		if (click) {
			flag = true;
			assertTrue(flag);
		}
		return flag;
	}

	/* This method help on create Check back for third party and validating Popup */

	public boolean createcheckbackpopup(String buttonname) throws Exception {
		boolean flag = false;
		commonUtils.waitTime(2000);
		log.info("Checking the create check backup popup with cancel letter Mt/Amct enabled");
		logger.log(Status.INFO, "Checking the create check backup popup with cancel letter Mt/Amct is enabled");
		NAPFLocators ls = new NAPFLocators();
		boolean initiateMemopopup = commonUtils.expandRootElement(ls.initiateMemopopup).isDisplayed();
		if (initiateMemopopup) {
			log.info("Create check back pop up is enabled");
			logger.log(Status.INFO, "Create check back pop up is enabled");
			String text = ls.initiateMemopopupText.getText();
			if (text.equalsIgnoreCase("Medium f�r Benachrichtigung ausw�hlen")) {
				flag = true;
				assertTrue(flag);
				log.info("Create check back pop up is text is same as exepceted");
				logger.log(Status.INFO, "Create check back pop up is text is same as exepceted");
				boolean cancelMemoTypeSelectionDialog = ls.cancelMemoTypeSelectionDialog.isDisplayed();
				boolean devaButton = ls.devaButton.isDisplayed();
				boolean swiftButton = ls.swiftButton.isDisplayed();
				if (cancelMemoTypeSelectionDialog && devaButton && swiftButton) {
					if (ls.cancelMemoTypeSelectionDialog.getText().equalsIgnoreCase(buttonname)) {
						commonUtils.click(ls.cancelMemoTypeSelectionDialog);
						flag = true;
					} else if (ls.devaButton.getText().equalsIgnoreCase(buttonname)) {
						commonUtils.click(ls.devaButton);
						flag = true;
					} else if (ls.swiftButton.getText().equalsIgnoreCase(buttonname)) {
						commonUtils.click(ls.swiftButton);
						flag = true;
					}
				}

			} else {
				logger.log(Status.INFO, "Popup message is not same as  Medium f�r Benachrichtigung ausw�hlen ");
				assertTrue(flag, "Popup message is not same as  Medium f�r Benachrichtigung ausw�hlen ");
			}

		} else {
			logger.log(Status.INFO, "Create check back pop up is not found");
			assertTrue(flag, "Create check back pop up is not found");
		}

		return flag;
	}

	/* This method help on create Check back for third party heading validation */

	public void Createcheckbackthirdpartyheading() {
		NAPFLocators ls = new NAPFLocators();
		if (ls.Createcheckbackthirdpartyheader.isDisplayed()) {
			String headerText = ls.Createcheckbackthirdpartyheader.getText();
			if (headerText.equalsIgnoreCase("R�ckfrage an Drittpartei")) {
				log.info(" landing pageCreate checkback for thirdparty Successfully ");
				logger.log(Status.INFO, "Landing page in Create checkback for thirdparty");
			} else {
				log.info(" Unable to landing page Create checkback for thirdparty");
				logger.log(Status.INFO, " Unable to landing page Create checkback for thirdparty");
			}
		}
	}

	/* This method help on Transaction Result Validation Check */

	public boolean TransactionResultValidation() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("Transaction Result Validation");
		logger.log(Status.INFO, "Transaction Result Validation");
		WebElement TransactionResultheader = commonUtils.expandRootElement(ls.TransactionResultheader);
		if (TransactionResultheader.isDisplayed()) {
			log.info("landing Transaction Result Validation");
			flag = true;
			String TransactionNum = commonUtils.expandRootElement(ls.transactionNumber).getText();
			String beforeNumber = IDAResultTransNumber();
			if (TransactionNum.equalsIgnoreCase(beforeNumber)) {
				flag = true;
				WebElement CheckBox = commonUtils.expandRootElement(ls.transactionCheckBox);
				if (CheckBox.isSelected()) {
					flag = true;
				} else {
					log.info("Check Box is Not select");
					logger.log(Status.INFO, "Check Box is Not select");
					flag = false;
					assertTrue(flag, "Check Box is Not select");
				}
			} else {
				log.info("Transaction Number is not as same");
				logger.log(Status.INFO, "Transaction Number is not as same");
				flag = false;
				assertTrue(flag, "Transaction Number is not as same");
			}
		} else {
			log.info("Select Transaction Result Heading is not as same");
			logger.log(Status.INFO, "Select Transaction Result Heading is not as same");
			flag = false;
			assertTrue(flag, "Select Transaction Result Heading is not as same");
		}
		return flag;
	}

	/* This method help on Create a Bank Identification In IDA - result */

	public boolean BankIdentificationCreate(String data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("Creating Bank Identification code ");
		logger.log(Status.INFO, "Creating Bank Identification code ");
		WebElement BankIdentificationheader = commonUtils.expandRootElement(ls.BankIdentificationheader);
		if (BankIdentificationheader.isDisplayed()) {
			log.info("landing Bank Identification code page");
			flag = true;
			assertTrue(flag);
			WebElement ChannelInformationStatus = commonUtils.expandRootElement(ls.ChannelInformationStatus);
			if (ChannelInformationStatus.isEnabled()) {
				flag = false;
				assertTrue(flag, "the channel information status is enabled");
			} else {
				WebElement OutBICInputBox = commonUtils.expandRootElement(ls.OutBICInputBox);
				commonUtils.click(OutBICInputBox);
				commonUtils.type(OutBICInputBox, "enter a value in outbic", data);
				commonUtils.click(commonUtils.expandRootElement(ls.OutBICtext));
				String aria_hidden = commonUtils.expandRootElement(ls.errorMesscheckoutBIC).getAttribute("aria-hidden");
				if (aria_hidden.equalsIgnoreCase("true")) {
					log.info("enter Bic is valid data : " + data);
					flag = true;
					assertTrue(flag);
				} else {
					log.info("enter Bic is invalid data : " + data);
					if (commonUtils.expandRootElement(ls.errorMesscheckoutBIC).getText()
							.equalsIgnoreCase("BIC ist ung�ltig. Bitte g�ltigen BIC angeben.")) {
						log.info("Error mess throws the correct error mess");
						flag = true;
						assertTrue(flag);
					} else {
						log.info("Error mess is throwing with incorrect text");
						flag = false;
						assertTrue(flag, "Error mess is throwing with incorrect text");
					}

				}

			}
			WebElement IDAOverridecheckBox = commonUtils.expandRootElement(ls.IDAOverridecheckBox);
			commonUtils.click(IDAOverridecheckBox);
		}

		return flag;
	}

	/* This method help on Click the channel Information */

	public boolean channelInformationClick(boolean data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("Clicking ChennelInformation Button");
		logger.log(Status.INFO, "Clicking ChennelInformation Button");
		String ChannelInformationStatus = commonUtils.expandRootElement(ls.ChannelInformationStatus).getText();
		if (data) {
			commonUtils.click(ls.CancelInformationButton);
			flag = true;
			WebElement OutputContactPersion = commonUtils.expandRootElement(ls.OutputContactPersion);
			WebElement OutputDeleveryChennal = commonUtils.expandRootElement(ls.OutputDeleveryChennal);
			WebElement OutputSubTemplateId = commonUtils.expandRootElement(ls.OutputSubTemplateId);
			WebElement OutputTemplateId = commonUtils.expandRootElement(ls.OutputTemplateId);
			if (ChannelInformationStatus.equalsIgnoreCase("Channel information retrieved*DE")) {
				commonUtils.scrolltoPageHeight();
				commonUtils.waitTime(2000);
				if (OutputContactPersion.isDisplayed() && OutputDeleveryChennal.isDisplayed()
						&& OutputSubTemplateId.isDisplayed() && OutputTemplateId.isDisplayed()) {
					flag = true;
				} else {
					log.info("All field is not displyed");
					logger.log(Status.INFO, "All field is not displyed");
					flag = false;
					assertTrue(flag, "All field is not displyed");
				}
			} else {
				log.info("Chennel Information name as not same");
				logger.log(Status.INFO, "Chennel Information name as not same");
				flag = false;
				assertTrue(flag, "Chennel Information name as not same");
			}
		}

		return false;
	}

	/* This method help on click Preview Letter */

	public void PreviewLetterClick() throws Exception {
		NAPFLocators ls = new NAPFLocators();
		log.info("Clicking Preview Button");
		logger.log(Status.INFO, "Clicking Preview Button");
		if (ls.PreviewLetterButton.isDisplayed() && ls.CancelLetterButton.isDisplayed()) {
			commonUtils.click(ls.PreviewLetterButton);
		} else {
			log.info("Unable to Click Preview Button");
			logger.log(Status.INFO, "Unable to Click Preview Button");
		}
	}

	/* This method help on Zero count of jobs validation and validating PopUp */

	public boolean ZeroCountOfJobs() throws Exception {
		boolean flag = false;
		log.info("Zero count of jobs validation");
		logger.log(Status.INFO, "Zero count of jobs validation");
		NAPFLocators ls = new NAPFLocators();
		List<WebElement> CountOfJobTable = commonUtils.expandRootsElement(ls.CountOfJobTable);
		for (int i = 13; i < CountOfJobTable.size(); i++) {
			String query = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-section > pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid > vaadin-grid-cell-content\")["
					+ i + "]";
			WebElement countOfJobs = commonUtils.expandRootElement(query);
			String text = countOfJobs.getText();
			int number = Integer.parseInt(text);
			WebElement Popupcountheadname = commonUtils.expandRootElement(ls.Popupcountheadname);
			WebElement Popupcount1text = commonUtils.expandRootElement(ls.Popupcount1text);
			if (number == 0) {
				commonUtils.click(countOfJobs);
				flag = true;
				assertTrue(flag);
				if (commonUtils.expandRootElement(ls.PopUpCountJob).isDisplayed()) {
					String Popupcountheadnametext = Popupcountheadname.getText();
					String Popupcount1textread = Popupcount1text.getText();
					if (Popupcountheadnametext.equalsIgnoreCase("Business Valiation.")
							|| Popupcount1textread.equalsIgnoreCase("No Records available.")) {
						WebElement PopupCloseButton = commonUtils.expandRootElement(ls.PopupCloseButton);
						if (commonUtils.isClickable(PopupCloseButton)) {
							commonUtils.click(PopupCloseButton);
							flag = true;
							assertTrue(flag);
						} else {
							log.info("Unable to Click Close Button");
							logger.log(Status.INFO, "Unable to Click Close Button");
							flag = false;
							assertTrue(flag, "Unable to Click Close Button");
						}

					} else {
						log.info("Both Text are not same in PopUp Tab");
						logger.log(Status.INFO, "Both Text are not same in PopUp Tab");
						flag = false;
						assertTrue(flag, "Both Text are not same in PopUp Tab");
					}

				} else {
					log.info("Count Of Jobs PopUp notification is not opened");
					logger.log(Status.INFO, "Count Of Jobs PopUp notification is not opened");
					flag = false;
					assertTrue(flag, "Count Of Jobs PopUp notification is not opened");
				}
			} else {
				i = i + 3;
				if (number != 0) {
					commonUtils.click(countOfJobs);
					flag = true;
					WebElement headerotherCount3 = commonUtils.expandRootElement(ls.headerotherCount3);
					if (ls.headerotherCount.isDisplayed() && ls.headerotherCount1.isDisplayed()
							&& ls.headerotherCount2.isDisplayed() && headerotherCount3.isDisplayed()) {
						flag = true;
						assertTrue(flag);
					} else {
						log.info("Not Open the Count of Job tab");
						logger.log(Status.INFO, "Not Open the Count of Job tab");
						flag = false;
						assertTrue(flag, "Not Open the Count of Job tab");
					}
				} else {
					log.info("Unable to Click Other Count OF Jobs Number");
					logger.log(Status.INFO, "Unable to Click Other Count OF Jobs Number");
					flag = false;
					assertTrue(flag, "Unable to Click Other Count OF Jobs Number");
				}
				break;
			}
		}
		return flag;
	}

	/* This method help on valiadation on Assaign Investigation Tab */

	public boolean AssignInvestigationValidation(String data, String menu) throws Exception {
		boolean flag = false;
		log.info("Assign Investigation Validation");
		logger.log(Status.INFO, "Assign Investigation Validation");
		NAPFLocators ls = new NAPFLocators();
		WebElement AssignInvestigation = commonUtils.expandRootElement(ls.AssignInvestigation);
		if (AssignInvestigation.isDisplayed()) {
			WebElement SelectUser = commonUtils.expandRootElement(ls.SelectUser);
			flag = true;
			assertTrue(flag);
			if (commonUtils.isClickable(SelectUser)) {
				commonUtils.click(SelectUser);
				commonUtils.type(SelectUser, "select the user detail", data);
				commonUtils.downenter(SelectUser);
				commonUtils.waitTime(4000);
				flag = true;
				assertTrue(flag);
				WebElement STATE = commonUtils.expandRootElement(ls.STATE);
				WebElement ALL = commonUtils.expandRootElement(ls.ALL);
				WebElement AIPriorityAllText = commonUtils.expandRootElement(ls.AIPriorityAllText);
				WebElement AIPriorityText = commonUtils.expandRootElement(ls.AIPriorityText);
				commonUtils.waitTime(5000);
				if (STATE.isDisplayed() && ALL.isDisplayed() && AIPriorityAllText.isDisplayed()
						&& AIPriorityText.isDisplayed()) {
					flag = true;
					assertTrue(flag);
					commonUtils.waitTime(2000);
					// boolean column_field_sorting_validation =
					// column_field_sorting_validation(menu);
				} else {
					log.info("State and all Both value of not showing");
					logger.log(Status.INFO, "State and all Both value of not showing");
					assertTrue(flag, "State and all Both value of not showing");
				}
			} else {
				log.info("Unable to enter data in Select User inbox");
				logger.log(Status.INFO, "Unable to enter data in Select User inbox");
				assertTrue(flag, "Unable to enter data in Select User inbox");
			}
		} else {
			log.info("Assign Investigation tab is not opend");
			logger.log(Status.INFO, "Assign Investigation tab is not opend");
			assertTrue(flag, "Assign Investigation tab is not opend");
		}

		return flag;
	}

	/* This method help on What we want Group name if seleceted */

	public boolean selectheGroupname(WebElement element, int num) throws Exception {
		boolean flag = false;
		for (int i = 0; i < 50; i++) {
			commonUtils.downenter(null);
			commonUtils.waitTime(1000);
			if (i == num) {
				log.info("selected the Group name");
				flag = true;
				break;
			} else {
				log.info("selecting the next data from dropdown");
				element.click();

			}
		}
		return flag;
	}

	/* This method help on Search Memos fields validation */

	public String[] SearchMemosFieldCheck(String data) throws Exception {
		log.info("Search Memos Field Validation Check");
		logger.log(Status.INFO, "Search Memos Field Validation Check");
		NAPFLocators ls = new NAPFLocators();
		String[] nfidmedoid = null;
		try {
			commonUtils.waitTime(3000);
			WebElement NoResultFullPopup = commonUtils.expandRootElement(ls.NoResultFullPopup);
			WebElement NoResultPopupText = commonUtils.expandRootElement(ls.NoResultPopupText);
			if (NoResultPopupText.getText().equalsIgnoreCase("Es konnten keine Resultate gefunden werden")) {
				WebElement NoResultPopupClose = commonUtils.expandRootElement(ls.NoResultPopupClose);
				commonUtils.waitTime(3000);
				NoResultPopupClose.click();
				commonUtils.waitTime(3000);
				log.info("Found Too manu entries popup and closed the popup");
				logger.log(Status.INFO, "Found Too manu entries popup and closed the popup");
				assertTrue(true);
			} else if (NoResultPopupText.getText().equalsIgnoreCase("Zu viele Resultate gefunden.")) {
				WebElement NoResultPopupClose = commonUtils.expandRootElement(ls.NoResultPopupClose);
				commonUtils.waitTime(3000);
				NoResultPopupClose.click();
				log.info("found no Result popup and closed the popup");
				logger.log(Status.INFO, "found no Result popup and closed the popup");
				assertTrue(true);
			}
		} catch (Exception e) {
			log.info("Popup is not found");
			logger.log(Status.INFO, "Pop up is not found");
			WebElement headermemosafterSearch = commonUtils.expandRootElement(ls.headermemosafterSearch);
			WebElement memoOverViewheader = commonUtils.expandRootElement(ls.memoOverViewheader);
			WebElement memoDetailheader = commonUtils.expandRootElement(ls.memoDetailheader);
			if (commonUtils.isElementPresent(headermemosafterSearch) && commonUtils.isElementPresent(memoOverViewheader)
					&& commonUtils.isElementPresent(memoDetailheader)) {
				commonUtils.waitTime(2000);
				int memosearchlistContentCount = ls.memosearchlistContentCount.size();
				log.info("The Searched list content count is :" + memosearchlistContentCount);
				logger.log(Status.INFO, "The Searched list content count is :" + memosearchlistContentCount);
				String memoid = ls.memosearchlistContentCount.get(0).getAttribute("label");
				log.info("clicking on the memo id :" + memoid);
				logger.log(Status.INFO, "clicking on the memo id :" + memoid);
				commonUtils.waitTime(3000);
				commonUtils.JSClick(ls.memoOverViewFirstBox);
				commonUtils.waitTime(2000);
				List<String> memoFieldList = new ArrayList<String>();
				nfidmedoid = new String[2];
				String valuememo = null;
				String valueNfid = null;
				List<WebElement> memoDetail = commonUtils.expandRootsElement(ls.memoDetail);
				for (int i = 0; i < memoDetail.size(); i++) {
					if (i == 0) {
						valuememo = memoDetail.get(i).getAttribute("value");
						if (memoid.contains(valuememo)) {
							log.info("the opened memo overview is showing the correct memo detail");
							logger.log(Status.INFO, "the opened memo overview is showing the correct memo detail");
						}
						valueNfid = memoDetail.get(6).getAttribute("value");
					}
					memoFieldList.add(memoDetail.get(i).getAttribute("label"));
				}
				nfidmedoid[0] = valuememo;
				nfidmedoid[1] = valueNfid;

				Set<String> repositoryfieldata = readFiledNameFromPATA(data, "Search memo field");
				Collections.sort(memoFieldList);
				assertEquals(memoFieldList, repositoryfieldata, "both repository and webpage field are not same");
			}
		}

		return nfidmedoid;
	}

	/* This method help on page Heading Validation */

	public boolean MemoSearchpageHeadingValidation(String appmenu) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		String landinfpageheading = landinfpageheading(commonUtils.expandRootElement(ls.MemoPageHederText));
		if (landinfpageheading.equalsIgnoreCase(appmenu)) {
			log.info("Landed in " + landinfpageheading + " page");
			logger.log(Status.INFO, "Landed in " + landinfpageheading + "page");
			flag = true;
			assertTrue(true);
		} else {
			log.info("Landed in " + landinfpageheading + "page");
			logger.log(Status.ERROR, "Landed in " + landinfpageheading + "page");
			assertTrue(flag, "Landed in " + landinfpageheading + "page");
		}
		return flag;
	}

	/* This method help on click The Memos Search Button */

	public void MemossearchClick() throws Exception {
		log.info("clicking in Memos search button");
		logger.log(Status.INFO, "clicking in Memos search button");
		commonUtils.waitTime(2000);
		NAPFLocators ls = new NAPFLocators();
		WebElement MemoSearchButton1 = commonUtils.expandRootElement(ls.MemoSearchButton);
		commonUtils.waitTime(5000);
		MemoSearchButton1.click();
		commonUtils.waitTime(3000);
	}

	/* This method help on Search Field in Search memos Tab */

	public void SearchMemosINsearch(String locator, String name, String data) throws Exception {
		log.info(name + " search validation");
		logger.log(Status.INFO, name + " search validation");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		WebElement SearchInField = commonUtils.expandRootElement(locator);
		commonUtils.JSClick(SearchInField);
		commonUtils.waitTime(2000);
		commonUtils.type(SearchInField, name, data);
	}

	/* This method help on Read NF-ID number then Click checkBox */

	public String ReadNFIDClickCheckBox(String menu) throws Exception {
		DAOTest daoTest = new DAOTest();
		log.info("reading the first NF ID ");
		logger.log(Status.INFO, "reading the first NF ID ");
		NAPFLocators ls = new NAPFLocators();
		String firstNumber = null;
		String firstCheckbox = null;
		if (menu.equalsIgnoreCase("Nachforschungen zuweisen") || menu.equalsIgnoreCase("Assign Investigation")
				|| menu.equalsIgnoreCase("Attribuer des recherches")
				|| menu.equalsIgnoreCase("attribuisci a ricerca")) {
			firstNumber = ls.FirstNf_number + "35]";
			firstCheckbox = ls.FirstNf_number + "33]";
		} else {
			firstNumber = ls.FirstNf_number + "32]";
			firstCheckbox = ls.FirstNf_number + "30]";
		}
		WebElement lastchange = commonUtils.expandRootElement(ls.lastchange);
		commonUtils.waitTime(2000);
		commonUtils.click(lastchange);
		commonUtils.waitTime(2000);
		WebElement AIFirstNFID = commonUtils.expandRootElement(firstNumber);
		WebElement AICheckBOX = commonUtils.expandRootElement(firstCheckbox);
		String FirstNFText = AIFirstNFID.getText();
		commonUtils.Actionleft(AIFirstNFID);
		commonUtils.waitTime(2000);
		if (commonUtils.isClickable(AICheckBOX)) {
			commonUtils.click(AICheckBOX);
			log.info("Clicking the CheckBox");
			logger.log(Status.INFO, "Clicking the CheckBox");
			commonUtils.ActionRight();
			assertTrue(true);
		} else {
			log.info("Unable to Click the CheckBox");
			logger.log(Status.INFO, "Unable to Click the CheckBox");
		}
		return FirstNFText;
	}

	/* This method help on Attachment Tab Validation */

	public boolean AttachmentTabValidation() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Attachment Tab Validation");
		logger.log(Status.INFO, "Attachment Tab Validation");
		WebElement AttachmentDetails = commonUtils.expandRootElement(ls.AttachmentDetails);
		commonUtils.waitTime(2000);
		WebElement BLOBFileNameSort = commonUtils.expandRootElement(ls.BLOBFileNameSort);
		WebElement AttachmentTypeSort = commonUtils.expandRootElement(ls.AttachmentTypeSort);
		WebElement AttachmentSort = commonUtils.expandRootElement(ls.AttachmentSort);
		commonUtils.waitTime(2000);
		commonUtils.isClickable(AttachmentSort);
		commonUtils.isClickable(AttachmentTypeSort);
		commonUtils.isClickable(BLOBFileNameSort);

		return flag;
	}

	/* This method help on Attachment Tab Validation in SI Details */

	public boolean AttachmentSIDetails() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("SI Details Validation in Attachment tab");
		logger.log(Status.INFO, "SI Details Validation in Attachment tab");
		WebElement SIdetailsheader = commonUtils.expandRootElement(ls.SIdetailsheader);
		commonUtils.waitTime(3000);
		WebElement SIBLOBFileSort = commonUtils.expandRootElement(ls.SIBLOBFileSort);
		WebElement SIIDSort = commonUtils.expandRootElement(ls.SIIDSort);
		WebElement SITypeSort = commonUtils.expandRootElement(ls.SITypeSort);
		WebElement SICreationSort = commonUtils.expandRootElement(ls.SICreationSort);
		WebElement SICommentSort = commonUtils.expandRootElement(ls.SICommentSort);
		commonUtils.waitTime(3000);
		commonUtils.isClickable(SIBLOBFileSort);
		commonUtils.isClickable(SIIDSort);
		commonUtils.isClickable(SITypeSort);
		commonUtils.isClickable(SICreationSort);
		commonUtils.isClickable(SICommentSort);
		WebElement AttachmentToNFButton = commonUtils.expandRootElement(ls.AttachmentToNFButton);
		flag = true;
		commonUtils.isdisabledjs(ls.AttachmentToNFButton);
		flag = true;

		return flag;
	}

	/*
	 * This method help on Attachment Tab Validation And Attachment In DropArea and
	 * Upload File
	 */

	public boolean AttachmentInDropArea() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info(" Drop Area Validation in Attachment tab");
		logger.log(Status.INFO, " Drop Area Validation in Attachment tab");
		WebElement DropAreaheader = commonUtils.expandRootElement(ls.DropAreaheader);
		commonUtils.waitTime(3000);
		WebElement SelectButtonInDrop = commonUtils.expandRootElement(ls.SelectButtonInDrop);
		WebElement DropImage = commonUtils.expandRootElement(ls.DropImage);
		commonUtils.waitTime(3000);
		commonUtils.expandRootElement(ls.choosefile);
		commonUtils.waitTime(2000);
		commonUtils.expandRootElement(ls.Sendfile).sendKeys(upload().getAbsolutePath());
		try {
			commonUtils.waitTime(4000);
			WebElement validformatpopup = commonUtils.expandRootElement(ls.validformatpopup);
			WebElement validfileuploadbutton = commonUtils.expandRootElement(ls.validfileuploadbutton);
			commonUtils.waitTime(3000);
			WebElement filename = ls.uploadfilename;
			String text1 = filename.getAttribute("value");
			validfileuploadbutton.click();
			commonUtils.waitTime(3000);
			log.info("uploading the valid file in n drop area");
			assertTrue(flag, "uploading the valid file in n drop area");
			commonUtils.waitTime(2000);
			String text = commonUtils.expandRootElement(ls.checkuploadfilename).getText();
			if (text.equalsIgnoreCase(text1)) {
				flag = true;
			}
			assertTrue(flag, "the uploaded file name and the updated file name are found to be different");
		} catch (Exception e) {
			// TODO: handle exception
			commonUtils.waitTime(4000);
			WebElement invalidformentFilepopup = commonUtils.expandRootElement(ls.invalidformentFilepopup);
			WebElement invalidFormatpoupclose = commonUtils.expandRootElement(ls.invalidFormatpoupclose);
			commonUtils.waitTime(2000);
			invalidFormatpoupclose.click();
			commonUtils.waitTime(2000);
			assertTrue(false, "The file is invalide file please upload valid file");
		}

		assertTrue(flag);

		return flag;
	}

	/* This method help on Import File Format */

	public File upload() {
		File f = new File("C:\\Test_data\\attachFile.txt");

		return f;
	}

	/* This method help on validation in NoResult PopUp */

	public boolean NoResultPopup() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("No Result PopUp is opened");
		logger.log(Status.INFO, "No Result PopUp is opened");
		String PopUpText = commonUtils.expandRootElement(ls.NoResultPopupText).getText();
		flag = true;
		if (PopUpText.equalsIgnoreCase(" Es konnten keine Resultate gefunden werden")) {
			WebElement NoResultPopupClose = commonUtils.expandRootElement(ls.NoResultPopupClose);
			flag = true;
			if (commonUtils.isClickable(NoResultPopupClose)) {
				commonUtils.click(NoResultPopupClose);
				flag = true;
			} else {
				log.info("the popup is present and the close button is not found");
				logger.log(Status.INFO, "the popup is present and the close button is not found");
				flag = false;
				assertTrue(flag, "the popup is present and the close button is not found");
			}
		} else {
			log.info("Text in PopUp is not same as expected");
			logger.log(Status.INFO, "Text in PopUp is not same as expected");
			flag = false;
			assertTrue(flag, "Text in PopUp is not same as expected");
		}
		return flag;
	}

	/* This method help on Partner Address Creation buttons Validation */

	public boolean PartnerCreationbuttonsValidation() {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Creating Partner Address");
		logger.log(Status.INFO, "Creating Partner Address");
		WebElement PartnerAdrssheader = commonUtils.expandRootElement(ls.PartnerAdrssheader);
		if (commonUtils.isElementPresent(ls.CreatPADetail) && commonUtils.isElementPresent(ls.ISYPartnerSearch)
				&& commonUtils.isElementPresent(ls.PEDAPartnerSearch)) {
			flag = true;
			if (ls.CreatPADetail.isEnabled() && ls.ISYPartnerSearch.isEnabled() && ls.PEDAPartnerSearch.isEnabled()) {
				flag = true;
			} else {
				log.info("The PA and ISY and PEDA buttons not Enabled");
				logger.log(Status.INFO, "The PA and ISY and PEDA buttons not Enabled");
				flag = false;
				assertTrue(flag, "The PA and ISY and PEDA buttons not Enabled");
			}
		} else {
			log.info("The PA and ISY and PEDA buttons not displyed");
			logger.log(Status.INFO, "The PA and ISY and PEDA buttons not displyed");
			flag = false;
			assertTrue(flag, "The PA and ISY and PEDA buttons not displyed");
		}

		return flag;
	}

	/* This method help on Partner Address Fields validation */

	public boolean PartnerAddressTableFieldCheck() {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Checking the Field of Partner Address");
		logger.log(Status.INFO, "Checking the Field of Partner Address");
		WebElement PartnerAdrssheader = commonUtils.expandRootElement(ls.PartnerAdrssheader);
		if (PartnerAdrssheader.isDisplayed()) {
			flag = true;
			WebElement PaPartnerTypesort = commonUtils.expandRootElement(ls.PaPartnerTypesort);
			WebElement PaSourceTypeSort = commonUtils.expandRootElement(ls.PaSourceTypeSort);
			WebElement PaAddress1sort = commonUtils.expandRootElement(ls.PaAddress1sort);
			WebElement PaAddress2Sort = commonUtils.expandRootElement(ls.PaAddress2Sort);
			WebElement PaAddress3Sort = commonUtils.expandRootElement(ls.PaAddress3Sort);
			WebElement PaAddress4Sort = commonUtils.expandRootElement(ls.PaAddress4Sort);
			WebElement PaAddress5Sort = commonUtils.expandRootElement(ls.PaAddress5Sort);
			if (commonUtils.isElementPresent(PaPartnerTypesort) && commonUtils.isElementPresent(PaSourceTypeSort)
					&& commonUtils.isElementPresent(PaAddress1sort) && commonUtils.isElementPresent(PaAddress2Sort)
					&& commonUtils.isElementPresent(PaAddress3Sort) && commonUtils.isElementPresent(PaAddress4Sort)
					&& commonUtils.isElementPresent(PaAddress5Sort)) {
				flag = true;
			} else {
				log.info("Partner Address heading name not found");
				logger.log(Status.INFO, "Partner Address heading name not found");
				flag = false;
				assertTrue(flag, "Partner Address heading name not found");
			}
		} else {
			log.info("The all field element is not found in Partner Address");
			logger.log(Status.INFO, "The all field element is not found in Partner Address");
			flag = false;
			assertTrue(flag, "The all field element is not found in Partner Address");
		}
		return flag;
	}

	/* This method help on Create PADetails in Partner Address */

	public boolean CreatePADetails(String data, String data1) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Creating PA Details in Partner Address");
		logger.log(Status.INFO, "Creating PA Details in Partner Address");
		commonUtils.isElementPresent(ls.CreatPADetail);
		if (ls.CreatPADetail.isEnabled()) {
			commonUtils.waitTime(2000);
			ls.CreatPADetail.click();
			commonUtils.waitTime(5000);
			flag = true;
			WebElement PopupPartnerheader = commonUtils.expandRootElement(ls.PopupPartnerheader);
			WebElement PopupPartnerType = commonUtils.expandRootElement(ls.PopupPartnerType);
			if (PopupPartnerheader.isDisplayed() && PopupPartnerType.isDisplayed()) {
				flag = true;
				commonUtils.waitTime(4000);
				WebElement PartnerTypeInput = commonUtils.expandRootElement(ls.PartnerTypeInput);
				commonUtils.click(PartnerTypeInput);
				commonUtils.waitTime(3000);
				commonUtils.type(PartnerTypeInput, "Entering the partner type", data);
				commonUtils.waitTime(2000);
				commonUtils.downenter(PartnerTypeInput);
				commonUtils.waitTime(2000);
				WebElement PopupSourceType = commonUtils.expandRootElement(ls.PopupSourceType);
				WebElement OnlineText = commonUtils.expandRootElement(ls.OnlineText);
				// String ONText = OnlineText.getText();
				if (commonUtils.isElementPresent(PopupSourceType) && commonUtils.isElementPresent(OnlineText)) {
					flag = true;
				} else {
					assertTrue(flag, "Unable to read Online");
				}
				WebElement Address1Input = commonUtils.expandRootElement(ls.Address1Input);
				if (commonUtils.isElementPresent(Address1Input)) {
					commonUtils.click(Address1Input);
					commonUtils.type(Address1Input, "type the city", data1);
					commonUtils.waitTime(3000);
					WebElement popupsavebutton = ls.popupsavebutton;
					commonUtils.waitTime(2000);
					commonUtils.click(popupsavebutton);
					flag = true;
					commonUtils.waitTime(7000);
					String text2 = commonUtils.expandRootElement(ls.OnlineCreateCheck).getText();
					if (text2.equalsIgnoreCase("ONLINE")) {
						flag = true;
						log.info("Unable to input type data in Address1 tab");
						logger.log(Status.INFO, "Unable to input type data in Address1 tab");
					} else {
						log.info("After creation of PA the data is not shown in table");
						logger.log(Status.INFO, "After creation of PA the data is not shown in table");
						flag = false;
						assertTrue(flag, "After creation of PA the data is not shown in table");
					}
				} else {
					log.info("Unable to input type data in Address1 tab");
					logger.log(Status.INFO, "Unable to input type data in Address1 tab");
					flag = false;
					assertTrue(flag, "Unable to input type data in Address1 tab");
				}
			} else {
				log.info("Unable to click the Partner type input box");
				logger.log(Status.INFO, "Unable to click the Partner type input box");
				flag = false;
				assertTrue(flag, "Unable to click the Partner type input box");
			}
		} else {
			log.info("Create PA details not displyed");
			logger.log(Status.INFO, "Create PA details not displyed");
			flag = false;
			assertTrue(flag, "Create PA details not displyed");
		}
		return flag;
	}

	/* This method help on Clicking PopUp PA Save Button */

	public void PopupPASaveButton() throws Exception {
		log.info("click Popup Save button works ");
		logger.log(Status.INFO, "click Popup Save button works");
		NAPFLocators ls = new NAPFLocators();
		WebElement PopUpSAVEButton = ls.PopUpSAVEButton;
		commonUtils.click(PopUpSAVEButton);
	}

	/* This method help on Clicking PopUp PA Reset Button */

	public void PopupPAResetButton() throws Exception {
		log.info("click Popup Reset button works ");
		logger.log(Status.INFO, "click Popup Reset button works");
		NAPFLocators ls = new NAPFLocators();
		WebElement PopUpRESETButton = ls.PopUpRESETButton;
		commonUtils.click(PopUpRESETButton);
	}

	/* This method help on Clicking PopUp PA Cancel Button */

	public void PopupPACancelButton() throws Exception {
		log.info("click Popup Cancel button works ");
		logger.log(Status.INFO, "click Popup Cancel button works");
		NAPFLocators ls = new NAPFLocators();
		WebElement PopUpCANCELButton = commonUtils.expandRootElement(ls.PopUpCANCELButton);
		commonUtils.click(PopUpCANCELButton);
	}

	/* This method help on Clicking PopUp ISY Reset Button */

	public void PopupISYResetButton() throws Exception {
		log.info("click Popup ISY Reset button works ");
		logger.log(Status.INFO, "click Popup ISY Reset button works");
		NAPFLocators ls = new NAPFLocators();
		WebElement PopUpISYRESETButton = ls.PopUpISYRESETButton;
		commonUtils.click(PopUpISYRESETButton);
	}

	/* This method help on Clicking PopUp ISY Search Button */

	public void PopupISYSearchButton() throws Exception {
		log.info("click Popup ISY Search button works ");
		logger.log(Status.INFO, "click Popup ISY Search button works ");
		NAPFLocators ls = new NAPFLocators();
		WebElement PopUpSAVEButton = ls.PopUpSAVEButton;
		commonUtils.click(PopUpSAVEButton);
	}

	/* This method help on Create ISYPartnerSearch in Partner Address */

	public boolean CreateISYPartnerSearch(String data, String data1, String data2) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Creating ISYPartner Search Partner Address");
		logger.log(Status.INFO, "Creating ISYPartner Search Partner Address");
		commonUtils.waitTime(2000);
		if (ls.ISYPartnerSearch.isEnabled()) {
			commonUtils.waitTime(3000);
			commonUtils.click(ls.ISYPartnerSearch);
			commonUtils.waitTime(4000);
			flag = true;
			WebElement PopUpISYheader = commonUtils.expandRootElement(ls.PopUpISYheader);
			WebElement ISYPartnerType = commonUtils.expandRootElement(ls.ISYPartnerType);
			if (commonUtils.isElementPresent(PopUpISYheader) && commonUtils.isElementPresent(ISYPartnerType)) {
				commonUtils.waitTime(2000);
				WebElement ISYPartnerType1 = commonUtils.expandRootElement(ls.ISYPartnerType);
				commonUtils.click(ISYPartnerType1);
				commonUtils.waitTime(2000);
				commonUtils.type(ISYPartnerType1, "Entering the ISY partner type", data);
				commonUtils.downenter(ISYPartnerType1);
				commonUtils.waitTime(2000);
				flag = true;
				WebElement ISYPartnerKeyInput = commonUtils.expandRootElement(ls.ISYPartnerKeyInput);
				if (ISYPartnerKeyInput.isDisplayed()) {
					commonUtils.waitTime(2000);
					commonUtils.click(ISYPartnerKeyInput);
					commonUtils.waitTime(2000);
					commonUtils.type(ISYPartnerKeyInput, "Entering the ISY ISO Country type", "1");
					WebElement ISYISOCountry = commonUtils.expandRootElement(ls.ISYISOCountry);
					WebElement ISYISOCountryInput = commonUtils.expandRootElement(ls.ISYISOCountryInput);
					if (ISYISOCountry.isDisplayed() && ISYISOCountryInput.isDisplayed()) {
						commonUtils.expandRootElement(ls.ISYISOCountryInput);
						commonUtils.click(ISYISOCountryInput);
						commonUtils.waitTime(1000);
						commonUtils.type(ISYISOCountryInput, "Entering the ISY ISO Country type", data1);
						commonUtils.downenter(ISYISOCountryInput);
						commonUtils.waitTime(1000);
						PopupISYSearchButton();
						commonUtils.waitTime(10000);
						flag = true;
						WebElement Isypartnertypeinput = commonUtils.expandRootElement(ls.Isypartnertypeinput);
						if (Isypartnertypeinput.isDisplayed()) {
							commonUtils.waitTime(3000);
							commonUtils.click(Isypartnertypeinput);
							commonUtils.waitTime(2000);
							commonUtils.type(Isypartnertypeinput, "enter the value", data2);
							commonUtils.waitTime(3000);
							commonUtils.downenter(Isypartnertypeinput);
							flag = true;
							WebElement Isysavebutton = ls.Isysavebutton;
							commonUtils.waitTime(5000);
							if (Isysavebutton.isDisplayed()) {
								commonUtils.waitTime(2000);
								commonUtils.click(Isysavebutton);
								commonUtils.waitTime(4000);
								flag = true;
								String text2 = commonUtils.expandRootElement(ls.ISYCreatecheckValidation).getText();
								if (text2.equalsIgnoreCase("ISY")) {
									flag = true;
									log.info("creation is sucessully");
									logger.log(Status.INFO, "creation is sucessully");
								} else {
									log.info("After creation of PA the data is not shown in table");
									logger.log(Status.INFO, "After creation of PA the data is not shown in table");
									flag = false;
									assertTrue(flag, "After creation of PA the data is not shown in table");
								}

							} else {
								log.info("Unable to Save Button in ISY Partner Search");
								logger.log(Status.INFO, "Unable to Save Button in ISY Partner Search");
								flag = false;
								assertTrue(flag, "Unable to Save Button in ISY Partner Search");
							}
						} else {
							log.info("Unable to enter data in ISY Partner Type input");
							logger.log(Status.INFO, "Unable to enter data in ISY Partner Type input");
							flag = false;
							assertTrue(flag, "Unable to enter data in ISY Partner Type input");
						}
					} else {
						log.info("Unable to enter data in ISY ISO Country input");
						logger.log(Status.INFO, "Unable to enter data in ISY ISO Country input");
						flag = false;
						assertTrue(flag, "Unable to enter data in ISY ISO Country input");
					}
				} else {
					log.info("Unable to enter the value in PartnerKey");
					logger.log(Status.INFO, "Unable to enter the value in PartnerKey");
					flag = false;
					assertTrue(flag, "Unable to enter the value in PartnerKey");
				}

			} else {
				log.info("Unable to enter data in Partner type input");
				logger.log(Status.INFO, "Unable to enter data in Partner type input");
				flag = false;
				assertTrue(flag, "Unable to enter data in Partner type input");
			}

		} else {
			log.info("ISY Partner Search heading name not found");
			logger.log(Status.INFO, "ISY Partner Search heading name not found");
			flag = false;
			assertTrue(flag, "ISY Partner Search heading name not found");
		}

		return flag;

	}

	/* This method help on Clicking PopUp PEDA Reset Button */

	public void PopupPEDAResetButton() throws Exception {
		log.info("click Popup PEDA Reset button works ");
		logger.log(Status.INFO, "click Popup PEDA Reset button works ");
		NAPFLocators ls = new NAPFLocators();
		WebElement PEDAResetButton = commonUtils.expandRootElement(ls.PEDAResetButton);
		commonUtils.click(PEDAResetButton);
	}

	/* This method help on Clicking PopUp PEDA Search Button */

	public void PopupPEDASearchButton() throws Exception {
		log.info("click Popup PEDA Search button works ");
		logger.log(Status.INFO, "click Popup PEDA Search button works ");
		NAPFLocators ls = new NAPFLocators();
		WebElement PEDASearchButton = ls.PEDASearchButton;
		commonUtils.click(PEDASearchButton);
	}

	/* This method help on Create PEDAPartnerSeach in Partner Address */

	public boolean CreatePEDAPartnerSeach(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Creating PEDA Partner Search in Partner Address");
		logger.log(Status.INFO, "Creating PEDA Partner Search in Partner Address");
		if (ls.PEDAPartnerSearch.isEnabled()) {
			commonUtils.waitTime(2000);
			commonUtils.click(ls.PEDAPartnerSearch);
			flag = true;
			commonUtils.waitTime(5000);
			WebElement PEDALocalCodeInput = commonUtils.expandRootElement(ls.PEDALocalCodeInput);
			WebElement PEDALocalCode = commonUtils.expandRootElement(ls.PEDALocalCode);
			if (commonUtils.isElementPresent(PEDALocalCodeInput) && commonUtils.isElementPresent(PEDALocalCode)) {
				commonUtils.waitTime(3000);
				commonUtils.click(PEDALocalCodeInput);
				commonUtils.waitTime(4000);
				commonUtils.type(PEDALocalCodeInput, "enter the value", "8");
				commonUtils.waitTime(3000);
				WebElement PEDASearchButton = ls.PEDASearchButton;
				commonUtils.waitTime(3000);
				commonUtils.click(PEDASearchButton);
				commonUtils.waitTime(7000);
				flag = true;
				WebElement PEDAPartnerType = commonUtils.expandRootElement(ls.PEDAPartnerType);
				WebElement PEDApartnerTypeInput = commonUtils.expandRootElement(ls.PEDApartnerTypeInput);
				if (PEDAPartnerType.isDisplayed() && PEDApartnerTypeInput.isDisplayed()) {
					commonUtils.waitTime(3000);
					commonUtils.click(PEDApartnerTypeInput);
					commonUtils.waitTime(4000);
					commonUtils.type(PEDApartnerTypeInput, "enter the value", data);
					commonUtils.waitTime(3000);
					commonUtils.downenter(PEDApartnerTypeInput);
					flag = true;
					WebElement PEDASaveButton = commonUtils.expandRootElement(ls.PEDASaveButton);
					if (PEDASaveButton.isDisplayed()) {
						commonUtils.click(PEDASaveButton);
						flag = true;
						commonUtils.waitTime(6000);
						commonUtils.scrollintoView();
						String text2 = commonUtils.expandRootElement(ls.PDEACreateCheck).getText();
						if (text2.equalsIgnoreCase("PEDA")) {
							flag = true;
							log.info("creation is sucessully");
							logger.log(Status.INFO, "creation is sucessully");
						} else {
							log.info("After creation of PA the data is not shown in table");
							logger.log(Status.INFO, "After creation of PA the data is not shown in table");
							flag = false;
							assertTrue(flag, "After creation of PA the data is not shown in table");
						}
					} else {
						log.info("Unable to click the save button ");
						logger.log(Status.INFO, "Unable to click the save button ");
						flag = false;
					}
				} else {
					log.info("Unable to enter the data in PEDA Partner Type");
					logger.log(Status.INFO, "Unable to enter the data in PEDA Partner Type");
					flag = false;
					assertTrue(flag, "Unable to enter the data in PEDA Partner Type");
				}
			} else {
				log.info("Unable to enter the data in Local Code ");
				logger.log(Status.INFO, "Unable to enter the data in Local Code ");
				flag = false;
				assertTrue(flag, "Unable to enter the data in Local Code");
			}
		} else {
			log.info("PEDA Partner Search heading name not found");
			logger.log(Status.INFO, "PEDA Partner Search heading name not found");
			flag = false;
			assertTrue(flag, "PEDA Partner Search heading name not found");
		}
		return flag;
	}

	/* This method help on Sorting PACreate Details */

	public boolean SortingPACreateDetails() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Sorting the PA create details ");
		logger.log(Status.INFO, "Sorting the PA create details");
		WebElement PaSourceTypeSort = commonUtils.expandRootElement(ls.PaSourceTypeSort);
		WebElement SourceTypeStatus = commonUtils.expandRootElement(ls.SourceTypeStatus);
		if (PaSourceTypeSort.isDisplayed()) {
			String SourceTypeStatusData = SourceTypeStatus.getText();
			commonUtils.click(PaSourceTypeSort);
			CommonUtils.waitTime(1000);
			PaSourceTypeSort.click();
			flag = true;
			if (SourceTypeStatusData.equalsIgnoreCase(SourceTypeStatus.getText())) {
				flag = false;
				assertTrue(flag, "Source Type sorting is not working");
			} else {
				log.info("Source Type sorting is working");
				logger.log(Status.INFO, "Source Type sorting is not working");
				flag = true;
				assertTrue(flag);
			}
		} else {
			log.info("PA Source Type is not showing ");
			logger.log(Status.INFO, "PA Source Type is not showing ");
			flag = false;
			assertTrue(flag, "PA Source Type is not showing ");
		}
		return flag;

	}

	/* This method help on PA Details in Partner Address working Edit fucntion */

	public boolean PartnerAddressPADetailEdit(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("PA Details Edit function");
		logger.log(Status.INFO, "PA Details Edit function");
		WebElement PaPartnerTypesort = commonUtils.expandRootElement(ls.PaPartnerTypesort);
		WebElement PartnerTypeStatus = commonUtils.expandRootElement(ls.PartnerTypeStatus);
		log.info("waiting for the Partner Type is displayed");
		commonUtils.waitTime(3000);
		String PartnerTypeStatusData = PartnerTypeStatus.getText();
		commonUtils.waitTime(3000);
		WebElement PAEditButton = commonUtils.expandRootElement(ls.PAEditButton);
		if (PAEditButton.isDisplayed()) {
			commonUtils.waitTime(2000);
			commonUtils.click(PAEditButton);
			commonUtils.waitTime(3000);
			flag = true;
			WebElement PAEditPARTNERTYPE = commonUtils.expandRootElement(ls.PAEditPARTNERTYPE);
			WebElement PAEditPARTNERTYPEINPUT = commonUtils.expandRootElement(ls.PAEditPARTNERTYPEINPUT);
			commonUtils.waitTime(3000);
			if (PAEditPARTNERTYPE.isDisplayed() && PAEditPARTNERTYPEINPUT.isDisplayed()) {
				commonUtils.waitTime(2000);
				commonUtils.click(PAEditPARTNERTYPEINPUT);
				commonUtils.waitTime(2000);
				commonUtils.selectAllClean(PAEditPARTNERTYPEINPUT);
				commonUtils.waitTime(1000);
				commonUtils.type(PAEditPARTNERTYPEINPUT, "Entering the edit partner type", data);
				commonUtils.downenter(PAEditPARTNERTYPEINPUT);
				commonUtils.waitTime(3000);
				commonUtils.click(ls.PAEditPARTNERSAVEButton);
				commonUtils.waitTime(5000);
				flag = true;
				WebElement PaPartnerTypesort1 = commonUtils.expandRootElement(ls.PaPartnerTypesort);
				commonUtils.click(PaPartnerTypesort1);
				commonUtils.waitTime(3000);
				commonUtils.click(PaPartnerTypesort1);
				commonUtils.waitTime(5000);
				WebElement PartnerTypeStatuS = commonUtils.expandRootElement(ls.PartnerTypeStatus);
				String currentStatus = PartnerTypeStatuS.getText();
				if (PartnerTypeStatusData.equalsIgnoreCase(currentStatus)) {
					flag = false;
					assertTrue(flag, "edit function is not working");
				} else {
					flag = true;
					log.info("edit function is working");
					logger.log(Status.INFO, "edit function is working");
					assertTrue(flag);
					WebElement PaPartnerTypesort12 = commonUtils.expandRootElement(ls.PaPartnerTypesort);
					commonUtils.waitTime(2000);
					commonUtils.click(PaPartnerTypesort12);
					commonUtils.waitTime(2000);
					commonUtils.click(PaPartnerTypesort12);
					commonUtils.waitTime(4000);
				}
			} else {
				log.info("Unable to find the element after edit");
				logger.log(Status.INFO, "Unable to find the element after edit");
				flag = false;
				assertTrue(flag, "Unable to find the element after edit");
			}
		} else {
			log.info("Edit Button is not find");
			logger.log(Status.INFO, "Edit Button is not find");
			flag = false;
			assertTrue(flag, "Edit Button is not find");
		}
		return flag;
	}

	/* This method help on PEDA Partner Address working Edit fucntion */

	public boolean EditPEDAPartnerAddress(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("PEDA Details Edit function");
		logger.log(Status.INFO, "PEDA Details Edit function");
		commonUtils.scrollintoView();
		WebElement PEDAPartnerTypeStatus = commonUtils.expandRootElement(ls.PEDAPartnerTypeStatus);
		log.info("waiting for the Partner Type is displayed");
		commonUtils.waitTime(3000);
		String PEDAPartnerTypeStatus1 = PEDAPartnerTypeStatus.getText();
		commonUtils.waitTime(2000);
		WebElement PEDAEditButton = commonUtils.expandRootElement(ls.PEDAEditButton);
		if (PEDAEditButton.isDisplayed()) {
			commonUtils.waitTime(2000);
			commonUtils.click(PEDAEditButton);
			commonUtils.waitTime(5000);
			flag = true;
			WebElement PEDAEditPartnerType = commonUtils.expandRootElement(ls.PEDAEditPartnerType);
			WebElement PEDAEditPartnerTypeINPUT = commonUtils.expandRootElement(ls.PEDAEditPartnerTypeINPUT);
			commonUtils.waitTime(3000);
			if (PEDAEditPartnerType.isDisplayed() && PEDAEditPartnerTypeINPUT.isDisplayed()) {
				commonUtils.waitTime(2000);
				commonUtils.click(PEDAEditPartnerTypeINPUT);
				commonUtils.waitTime(2000);
				commonUtils.selectAllClean(PEDAEditPartnerTypeINPUT);
				commonUtils.waitTime(1000);
				commonUtils.type(PEDAEditPartnerTypeINPUT, "Entering the edit partner type", data);
				commonUtils.downenter(PEDAEditPartnerTypeINPUT);
				commonUtils.waitTime(2000);
				commonUtils.click(ls.PAEditPARTNERSAVEButton);
				commonUtils.waitTime(6000);
				flag = true;
				WebElement PEDAPartnerTypecurrentStatus = commonUtils.expandRootElement(ls.PEDAPartnerTypeStatus);
				String currentStatus = PEDAPartnerTypecurrentStatus.getText();
				if (PEDAPartnerTypeStatus1.equalsIgnoreCase(currentStatus)) {
					flag = false;
					assertTrue(flag, "edit function is not working");
				} else {
					flag = true;
					log.info("edit function is working");
					logger.log(Status.INFO, "edit function is working");
					assertTrue(flag);
				}
			} else {
				log.info("Unable to find the element after edit");
				logger.log(Status.INFO, "Unable to find the element after edit");
				flag = false;
				assertTrue(flag, "Unable to find the element after edit");
			}
		} else {
			log.info("Edit Button is not find");
			logger.log(Status.INFO, "Edit Button is not find");
			flag = false;
			assertTrue(flag, "Edit Button is not find");
		}
		return flag;
	}

	/* This method help on Click the Tick Button */

	public void ClickTickButton() throws Exception {
		log.info("clicking the Tick Button ");
		logger.log(Status.INFO, "clicking the Tick Button ");
		NAPFLocators ls = new NAPFLocators();
		WebElement TickButton = commonUtils.expandRootElement(ls.TickButton);
		if (TickButton.isDisplayed()) {
			commonUtils.click(TickButton);
		} else {
			log.info("Unable to click Tick Button");
			logger.log(Status.INFO, "Unable to click Tick Button");
		}
	}

	/* This method help on PAPartner Address delete function */

	public boolean PartnerAddresdelete() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Partner Address delete function");
		logger.log(Status.INFO, "Partner Address delete function");
		WebElement SourceTypeStatus = commonUtils.expandRootElement(ls.SourceTypeStatus);
		WebElement DELETEButton = commonUtils.expandRootElement(ls.DELETEButtonPA);
		commonUtils.waitTime(1000);
		WebElement SourceTypeStatus1 = commonUtils.expandRootElement(ls.SourceTypeStatus);
		commonUtils.waitTime(1000);
		String SourceTypeStatusData = SourceTypeStatus1.getText();
		commonUtils.waitTime(2000);
		WebElement DELETEButton1 = commonUtils.expandRootElement(ls.DELETEButtonPA);
		commonUtils.waitTime(1000);
		commonUtils.click(DELETEButton1);
		commonUtils.waitTime(4000);
		flag = true;
		WebElement DELETEPopup = commonUtils.expandRootElement(ls.DELETEPopup);
		WebElement DELETEPopupClose = commonUtils.expandRootElement(ls.DELETEPopupClose);
		commonUtils.waitTime(2000);
		if (DELETEPopup.isDisplayed() && DELETEPopupClose.isDisplayed()) {
			commonUtils.waitTime(1000);
			commonUtils.click(DELETEPopupClose);
			commonUtils.waitTime(7000);
			flag = true;
			String currentStatus = commonUtils.expandRootElement(ls.SourceTypeStatus).getText();
			if (SourceTypeStatusData.equalsIgnoreCase(currentStatus)) {
				assertTrue(flag, "Delete function is not working");
			} else {
				log.info("Delete function is working");
				logger.log(Status.INFO, "Delete function is working");
				flag = true;
				assertTrue(flag);
			}
		} else {
			log.info("Unable to click Popup delete");
			logger.log(Status.INFO, "Unable to click Popup delete");
			flag = false;
			assertTrue(flag, "Unable to click Popup delete");
		}

		return flag;
	}

	/* This method help on PEDA Partner Address delete function */

	public boolean PEDAPartnerAddresdelete() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info(" PEDA Partner Address delete function");
		logger.log(Status.INFO, " PEDA Partner Address delete function");
		WebElement PaSourceTypeSort = commonUtils.expandRootElement(ls.PaSourceTypeSort);
		WebElement SourceTypeStatus = commonUtils.expandRootElement(ls.SourceTypeStatus);
		WebElement DELETEButton = commonUtils.expandRootElement(ls.DELETEButtonPEDA);
		commonUtils.waitTime(3000);
		WebElement SourceTypeStatus1 = commonUtils.expandRootElement(ls.SourceTypeStatus);
		commonUtils.waitTime(1000);
		String SourceTypeStatusData = SourceTypeStatus1.getText();
		commonUtils.waitTime(1000);
		WebElement DELETEButton1 = commonUtils.expandRootElement(ls.DELETEButtonPEDA);
		commonUtils.waitTime(1000);
		commonUtils.click(DELETEButton1);
		commonUtils.waitTime(3000);
		flag = true;
		WebElement DELETEPopup = commonUtils.expandRootElement(ls.DELETEPopup);
		WebElement DELETEPopupClose = commonUtils.expandRootElement(ls.DELETEPopupClose);
		commonUtils.waitTime(3000);
		commonUtils.click(DELETEPopupClose);
		commonUtils.waitTime(6000);
		flag = true;
		try {
			String currentStatus = commonUtils.expandRootElement(ls.SourceTypeStatus).getText();
		} catch (Exception e) {
			List<WebElement> sourcetypeStatusList = commonUtils.expandRootsElement(ls.sourcetypeStatusList);
			if (sourcetypeStatusList.size() == 0) {
				log.info("no row found in partner address");
				assertTrue(flag);
			}
		}
		return flag;
	}

	/* This method help on ISY Partner Address delete function */

	public boolean ISYPartnerAddresdelete() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info(" PEDA Partner Address delete function");
		logger.log(Status.INFO, " PEDA Partner Address delete function");
		WebElement PaSourceTypeSort = commonUtils.expandRootElement(ls.PaSourceTypeSort);
		WebElement SourceTypeStatus = commonUtils.expandRootElement(ls.SourceTypeStatus);
		WebElement DELETEButton = commonUtils.expandRootElement(ls.DELETEButtonISY);
		if (PaSourceTypeSort.isDisplayed() && DELETEButton.isDisplayed()) {
			commonUtils.waitTime(2000);
			WebElement SourceTypeStatus1 = commonUtils.expandRootElement(ls.SourceTypeStatus);
			String SourceTypeStatusData = SourceTypeStatus1.getText();
			commonUtils.waitTime(2000);
			WebElement DELETEButton1 = commonUtils.expandRootElement(ls.DELETEButtonISY);
			commonUtils.waitTime(1000);
			commonUtils.click(DELETEButton1);
			commonUtils.waitTime(2000);
			flag = true;
			WebElement DELETEPopup = commonUtils.expandRootElement(ls.DELETEPopup);
			WebElement DELETEPopupClose = commonUtils.expandRootElement(ls.DELETEPopupClose);
			if (DELETEPopup.isDisplayed() && DELETEPopupClose.isDisplayed()) {
				commonUtils.waitTime(2000);
				commonUtils.click(DELETEPopupClose);
				commonUtils.waitTime(3000);
				flag = true;
				String currentStatus = commonUtils.expandRootElement(ls.SourceTypeStatus).getText();
				if (SourceTypeStatusData.equalsIgnoreCase(currentStatus)) {
					assertTrue(flag, "Delete function is not working");
				} else {
					log.info("Delete function is working");
					logger.log(Status.INFO, "Delete function is working");
					assertTrue(flag);
				}
			} else {
				log.info("Unable to click Popup delete");
				logger.log(Status.INFO, "Unable to click Popup delete");
				flag = false;
				assertTrue(flag, "Unable to click Popup delete");
			}
		} else {
			log.info("Delete Button is not displyed");
			logger.log(Status.INFO, "Delete Button is not displyed");
			flag = false;
			assertTrue(flag, "Delete Button is not displyed");
		}

		return flag;
	}

	/* This method help on ISY view Validation in Partner Address function */

	public boolean ISYViewValidation() throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("ISY View Validation");
		logger.log(Status.INFO, "ISY View Validation");
		WebElement SourceTypeStatus = commonUtils.expandRootElement(ls.ISYSourceType);
		WebElement ISYVIEWButton = commonUtils.expandRootElement(ls.ISYVIEWButton);
		commonUtils.waitTime(5000);
		String SourceTypeStatusData = SourceTypeStatus.getText();
		flag = true;
		if (SourceTypeStatusData.equalsIgnoreCase("ISY")) {
			commonUtils.waitTime(2000);
			WebElement ISYVIEWButton1 = commonUtils.expandRootElement(ls.ISYVIEWButton);
			commonUtils.waitTime(2000);
			commonUtils.click(ISYVIEWButton1);
			commonUtils.waitTime(2000);
			flag = true;
		} else {
			log.info("Unable to checking view button");
			logger.log(Status.INFO, "Unable to checking view button");
			flag = false;
			assertTrue(flag, "Unable to checking view button");
		}
		return flag;
	}

	/* This method help on Entering tha value in Account Fees In Product */

	public boolean AccountFeesInProduct(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Entering tha value in AccountFees and Money Receiver");
		logger.log(Status.INFO, "Entering tha value in AccountFees and Money Receiver");
		WebElement AccForFeesINProduct = commonUtils.expandRootElement(ls.AccForFeesINProduct);
		WebElement AccForFeesInput = commonUtils.expandRootElement(ls.AccForFeesInput);
		WebElement SomeoneClick = commonUtils.expandRootElement(ls.SomeoneClick);
		if (AccForFeesINProduct.isDisplayed() && AccForFeesInput.isDisplayed()) {
			commonUtils.click(AccForFeesInput);
			commonUtils.type(AccForFeesInput, "type a value", data);
			commonUtils.waitTime(1000);
			commonUtils.click(SomeoneClick);
			commonUtils.waitTime(1000);
			flag = true;
			String Newdata = AccForFeesInput.getAttribute("value");
			if (Newdata.contains("CH1409000000800000022")) {
				assertTrue(flag, "Entering the data function is working");
			} else {
				log.info("Entering data function is Not working");
				logger.log(Status.INFO, "Entering data function is not working");
				assertTrue(flag);
			}
		} else {
			log.info("Unable to the Enter in Account for fees tab");
			logger.log(Status.INFO, "Unable to the Enter in Account for fees tab");
			flag = false;
			assertTrue(flag, "Unable to Enter value in Account for fees tab");
		}
		return flag;
	}

	/* This method help on Entering tha value in postal Account In Product */

	public boolean postalAccountInProduct(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Entering tha value in postal Account Money Receiver");
		logger.log(Status.INFO, "Entering tha value in AccountFees and Money Receiver");
		WebElement postalAccMoney = commonUtils.expandRootElement(ls.postalAccMoney);
		WebElement postalAccMoneyInput = commonUtils.expandRootElement(ls.postalAccMoneyInput);
		WebElement SomeoneClick = commonUtils.expandRootElement(ls.SomeoneClick);
		if (postalAccMoney.isDisplayed() && postalAccMoneyInput.isDisplayed()) {
			commonUtils.click(postalAccMoneyInput);
			commonUtils.type(postalAccMoneyInput, "type a value", data);
			commonUtils.waitTime(1000);
			commonUtils.click(SomeoneClick);
			commonUtils.waitTime(1000);
			flag = true;
			String Newdata = postalAccMoneyInput.getAttribute("value");
			if (Newdata.contains("CH1409000000800000022")) {
				assertTrue(flag, "Entering the data function is working");
			} else {
				log.info("Entering data function is Not working");
				logger.log(Status.INFO, "Entering data function is Not working");
				assertTrue(flag);
			}
		} else {
			log.info("Unable to Enter value in postal Account tab");
			logger.log(Status.INFO, "Unable to Enter value in postal Account tab");
			flag = false;
			assertTrue(flag, "Unable to Enter value in postal Account tab");
		}
		return flag;
	}

	/* This method help on Entering the value in Iban field And iban check */

	public boolean EnterTheDataUsingIBANorPCNR(String Ibanfield, String ibandata) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Entering the value in " + Ibanfield + " iban check");
		logger.log(Status.INFO, "Entering the value in " + Ibanfield + " iban check");
		List<WebElement> iBANCheckProdcutTab = ls.IBANCheckProdcutTab;
		for (int i = 0; i < iBANCheckProdcutTab.size(); i++) {
			String attribute = iBANCheckProdcutTab.get(i).getAttribute("label");
			if (attribute.equalsIgnoreCase(Ibanfield)) {
				WebElement IBANCheckText = commonUtils.expandRootElement(ls.IBANCheck + i + ls.IBANCheck1);
				commonUtils.waitTime(3000);
				String IBANText = IBANCheckText.getText();
				commonUtils.waitTime(2000);
				if (iBANCheckProdcutTab.get(i).isDisplayed()) {
					if (IBANText.equalsIgnoreCase("IBAN")) {
						commonUtils.waitTime(3000);
						commonUtils.click(iBANCheckProdcutTab.get(i));
						commonUtils.waitTime(2000);
						commonUtils.type(iBANCheckProdcutTab.get(i), "enter the Value", ibandata);
						flag = true;
						String IBANText1 = IBANCheckText.getText();
						WebElement SomewhreClick = commonUtils.expandRootElement(ls.SomewhreClick);
						if (IBANText1.equalsIgnoreCase("PC-Nr")) {
							commonUtils.click(SomewhreClick);
							commonUtils.waitTime(3000);
							flag = true;
							String Newdata = iBANCheckProdcutTab.get(i).getAttribute("value");
							if (IBANText.equalsIgnoreCase("IBAN") && Newdata.contains("CH14")) {
								assertTrue(flag, "Entering the data function is working");
								flag = true;
							} else {
								log.info("Data entered as PC-NR is not converting to IBAN");
								logger.log(Status.INFO, "Data entered as PC-NR is not converting to IBAN");
								flag = false;
								assertTrue(flag);
							}
						} else if (IBANText.equalsIgnoreCase("IBAN")) {
							log.info("Entering data is IBAN Number");
							logger.log(Status.INFO, "Entering data is IBAN Number");
							flag = true;
							assertTrue(flag);
						} else {
							log.info("Entering data is IBAN Number");
							logger.log(Status.INFO, "Entering data is IBAN Number");
							flag = false;
							assertTrue(flag);
						}
					}
				} else {
					log.info("Both Element are not showing");
					logger.log(Status.INFO, "Both Element are not showing");
					flag = false;
					assertTrue(flag);
				}
			}
			break;
		}

		return flag;
	}

	/* This method help on Work flow App menu validation */

	public boolean ArrowFlowAppMenu(String data) {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Work flow App menu validation");
		logger.log(Status.INFO, "Work flow App menu validation");
		List<WebElement> appmenuname = commonUtils.expandRootsElement(ls.appmenuname);
		for (int i = 0; i < appmenuname.size(); i++) {
			WebElement nfid = appmenuname.get(i);
			String text = nfid.getText();
			if (data.contains(text)) {
				log.info("The Element is present and enabled :" + text);
				logger.log(Status.INFO, "The Element is present and enabled :" + text);
				flag = true;
				assertTrue(flag, "The Element is present and enabled :" + text);
			} else {
				log.info("The Element is not present and Enabled");
				logger.log(Status.INFO, "The Element is not present and Enabled");
				flag = false;
				assertTrue(flag);
			}
		}
		return flag;
	}

	/* This method help on Work flow Three Dot Field validation */

	public boolean ArrowFlowThreeDotFieldCheck(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Three dot extra appmenu Element validation");
		logger.log(Status.INFO, "Three dot extra appmenu Element validation");
		WebElement ThreeDotButton = commonUtils.expandRootElement(ls.ThreeDotButton);
		commonUtils.waitTime(1000);
		if (ThreeDotButton.isDisplayed()) {
			commonUtils.waitTime(1000);
			commonUtils.click(ThreeDotButton);
			commonUtils.waitTime(2000);
			flag = true;
			Screenzoomout();
			List<WebElement> ThreeDotHiddenName = ls.ThreeDotHiddenName;
			for (int i = 0; i < ThreeDotHiddenName.size(); i++) {
				String text = ThreeDotHiddenName.get(i).getAttribute("label");
				if (data.contains(text)) {
					log.info("The Element is present and enabled :" + text);
					logger.log(Status.INFO, "The Element is present and enabled :" + text);
					assertTrue(flag, "The Element is present and  enabled :" + text);
					flag = true;
				} else {
					log.info("The Element is not present and Enabled");
					logger.log(Status.INFO, "The Element is not present and Enabled");
					flag = false;
					assertTrue(flag);
				}
			}
		} else {
			log.info("Unable to Click Three Dot Button");
			logger.log(Status.INFO, "Unable to Click Three Dot Button");
			flag = false;
			assertTrue(flag);
		}
		return flag;
	}

	/* This method help on Work flow Side Arrow Data validation */

	public boolean SideArrowDataCheck(String data) throws Exception {
		boolean flag = false;
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("Arrow mark Element validation");
		logger.log(Status.INFO, "Arrow mark Element validation");
		WebElement investigationArrowButton = commonUtils.expandRootElement(ls.investigationArrowButton);
		if (investigationArrowButton.isDisplayed()) {
			commonUtils.waitTime(1000);
			commonUtils.click(investigationArrowButton);
			commonUtils.waitTime(1000);
			flag = true;
			WebElement AttachmentOtlineheader = commonUtils.expandRootElement(ls.AttachmentOtlineheader);
			if (AttachmentOtlineheader.isDisplayed()) {
				List<WebElement> Attachmenttable = ls.Attachmenttable;
				for (int i = 19; i < Attachmenttable.size(); i++) {
					String text = Attachmenttable.get(i).getAttribute("label");
					if (data.contains(text)) {
						log.info("The Element is present and enabled :" + text);
						logger.log(Status.INFO, "The Element is present and enabled :" + text);
						assertTrue(flag, "The Element is present and  enabled :" + text);
						flag = true;
					} else {
						log.info("The Element is not present and Enabled");
						logger.log(Status.INFO, "The Element is not present and Enabled");
						flag = false;
						assertTrue(flag);
					}
				}
			} else {
				log.info("Attachment Outline header name is not find");
				logger.log(Status.INFO, "Attachment Outline header name is not find");
				flag = false;
				assertTrue(flag);
			}
		} else {
			log.info("Unable to Click Arrow mark Button");
			logger.log(Status.INFO, "Unable to Click Arrow mark Button");
			flag = false;
			assertTrue(flag);
		}
		return flag;
	}

	/* This method help on validating the Group Queue Summary */

	public WebElement GroupQueueSummaryValidation(String data, String NFID) throws Exception {
		DAOTest daoTest = new DAOTest();
		NAPFLocators ls = new NAPFLocators();
		log.info("validating the Group Queue Summary");
		logger.log(Status.INFO, "validating the Group Queue Summary");
		WebElement Nf_id_text_data = null;
		List<WebElement> nfsearch = commonUtils.expandRootsElement(ls.all_NfNumber_search);
		int j = 1;
		for (int i = 32; i < nfsearch.size(); i++) {
			WebElement Nf_id_text = nfsearch.get(i);
			if (Nf_id_text.getText().equals(NFID)) {
				String Nf_edit_icon = "return document.querySelector('#userProfileFrom > pf-table').shadowRoot.querySelectorAll('pf-toolbar > pf-menu-item')["
						+ j + "]";
				Nf_id_text_data = commonUtils.expandRootElement(Nf_edit_icon);
				if (data.equalsIgnoreCase("search")) {
					log.info("Found the NFid and click on the checkbox to check the group element enabling");
					logger.log(Status.INFO,
							"Found the NFid and click on the checkbox to check the group element enabling");
					commonUtils.scrollByleft("pf-table");
					WebElement expandRootElement = commonUtils
							.expandRootElement(ls.all_NfNumber_search_2 + j + ls.all_NfNumber_search_checkbox);
					commonUtils.JSClick(expandRootElement);
					log.info("clicked in respective checkbox");
				}
				break;
			}
			commonUtils.scrollBy("pf-table", j);
			i = i + 9;
			j++;
		}
		int tableDatacount = 0;
		List<WebElement> searchTableDatas = commonUtils.expandRootsElement(ls.searchTableData);
		for (int i = 34; i < searchTableDatas.size(); i++) {
			String text = searchTableDatas.get(i).getText();
			if (text.equalsIgnoreCase(data)) {
				i = i + 10;
				tableDatacount++;
				commonUtils.scrollBy("pf-table", j);
				commonUtils.waitTime(1000);
			}
		}
		return Nf_id_text_data;
	}

	/* This method help on Sorting the Group Queue Summary */

	public boolean GroupQueueSorting(String data) throws Exception {
		boolean flag = false;
		log.info("Sorting the Group Queue Summary");
		logger.log(Status.INFO, "Sorting the Group Queue Summary");
		NAPFLocators ls = new NAPFLocators();
		WebElement Groupqueueheader = commonUtils.expandRootElement(ls.Groupqueueheader);
		if (Groupqueueheader.isDisplayed()) {
			List<WebElement> SearchTableDataSort = commonUtils.expandRootsElement(ls.SearchTableDataSort);
			for (int i = 0; i < SearchTableDataSort.size() - 1; i++) {
				String text = SearchTableDataSort.get(i).getText();
				if (text.equalsIgnoreCase(data)) {
					WebElement Groupqueuestatus = commonUtils
							.expandRootElement(ls.Groupqueuestatus + i + ls.fieldNumber);
					String Groupqueuestatus1 = Groupqueuestatus.getText();
					commonUtils.click(SearchTableDataSort.get(i));
					CommonUtils.waitTime(1000);
					String Groupqueuestatus2 = Groupqueuestatus.getText();
					flag = true;
					if (Groupqueuestatus1.equalsIgnoreCase(Groupqueuestatus2)) {
						flag = false;
						assertTrue(flag, "Source Type sorting is not working");
					} else {
						log.info("Source Type sorting is working");
						logger.log(Status.INFO, "Source Type sorting is not working");
						flag = true;
						assertTrue(flag, "Source Type sorting is not working");
					}
				} else {
					log.info("text and data is not as same");
					logger.log(Status.INFO, "text and data is not as same");
					flag = true;
					assertTrue(flag, "text and data is not as same");
				}
			}
		} else {
			log.info("Not Showing Group Queue Summary Heading");
			logger.log(Status.INFO, "Not Showing Group Queue Summary Heading");
			flag = false;
			assertTrue(flag);
		}
		return flag;
	}

	/* This method help on Validating the Local code in general tab */

	public boolean LocalcodeValidation(String data) throws Exception {
		boolean flag = false;
		log.info("Validating the Local code in general tab");
		logger.log(Status.INFO, "Validating the Local code in general tab");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		// WebElement LocalCodeHeader =
		// commonUtils.expandRootElement(ls.LocalCodeHeader);
		if (ls.LocalCodeInput.isDisplayed()) {
			commonUtils.waitTime(3000);
			commonUtils.click(ls.LocalCodeInput);
			commonUtils.waitTime(2000);
			boolean type = commonUtils.type(ls.LocalCodeInput, "enter the value", data);
			try {
				WebElement LocalCodeerrorText = commonUtils.expandRootElement(ls.LocalCodeerrorText);
				if (LocalCodeerrorText.isDisplayed()) {
					log.info("The value is invalid Format : " + data);
					logger.log(Status.INFO, "The value is invalid Format : " + data);
				}
			} catch (Exception e) {
				if (type) {
					flag = type;
					log.info("enter the  value is valid");
					logger.log(Status.INFO, "enter the  value is invalid");
					assertTrue(flag, "enter the  value is invalid");
				}
			}
		}

		return flag;
	}

	/*
	 * This method help on search NF Number in Search Investigation and then move a
	 * group Queue Option
	 */

	public boolean searchAndMovetoUserinbox(String lang, String appmenu, String NFID) throws Exception {
		boolean flag = false;
		CreateNFScenarios Scenarios = new CreateNFScenarios();
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(5000);
		Scenarios.profileMenuSelect(lang);
		commonUtils.waitTime(3000);
		appMenuList(appmenu);
		commonUtils.waitTime(2000);
		commonUtils.scrollintoView();
		commonUtils.click(commonUtils.expandRootElement(ls.MoreOption));
		commonUtils.waitTime(2000);
		NAPFLocators ls1 = new NAPFLocators();
		commonUtils.click(ls1.NFIdRangeFrom);
		commonUtils.waitTime(2000);
		commonUtils.type(ls1.NFIdRangeFrom, "typing nf id in searchInvestigasion", commonUtils.splitString(NFID));
		commonUtils.scrolltoPageHeight();
		searchClick();
		commonUtils.waitTime(2000);
		WebElement checkbox = commonUtils.expandRootElement(ls.NfCheckBoxmess);
		commonUtils.click(checkbox);
		commonUtils.waitTime(3000);
		WebElement MovetouserInbox = commonUtils.expandRootElement(ls.MovetouserInbox);
		if (commonUtils.isdisabledjs(ls.MovetouserInbox)) {
			log.info("The NF ID already landed into the UserInbox ");
			logger.log(Status.INFO, "The NF ID already landed into the UserInbox ");
			commonUtils.waitTime(3000);
			scenario.openNFInvestigation(commonUtils.splitString(NFID));
			flag = true;
		} else {
			commonUtils.click(ls.MovetouserInboxButton);
			commonUtils.waitTime(3000);
			commonUtils.switchToWindow(1);
			log.info("The NF ID moving to the UserInbox");
			logger.log(Status.INFO, "The NF ID moving to the UserInbox");
		}

		return flag;
	}

	/* This method help on Input A Value in State in assign Investigation */

	public boolean AssignInvestigationSelectState(String data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("input a value in State filter");
		logger.log(Status.INFO, "input a value in State filter");
		WebElement STATE = commonUtils.expandRootElement(ls.STATE);
		WebElement ALL = commonUtils.expandRootElement(ls.ALL);
		commonUtils.waitTime(3000);
		if (STATE.isDisplayed() && ALL.isDisplayed()) {
			commonUtils.waitTime(2000);
			commonUtils.click(ALL);
			commonUtils.waitTime(2000);
			commonUtils.type(ALL, "enter the value in state ", data);
			commonUtils.downenter(ALL);
			commonUtils.waitTime(4000);
			flag = true;
		} else {
			log.info("Unable to enter the value in State Filter tab");
			logger.log(Status.INFO, "Unable to enter the value in State Filter tab");
			flag = false;
			assertTrue(flag, "Unable to enter the value in State Filter tab");
		}
		return flag;
	}

	/* This method help on State filter validation in assign Investigation */

	public boolean AssignInvestigationStatevalidation(String data) {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("State filtering validation");
		logger.log(Status.INFO, "State filtering validation");
		WebElement StateData = null;
		List<WebElement> Statesearch = commonUtils.expandRootsElement(ls.StateFilterCheck);
		int j = 1;
		for (int i = 1; i < Statesearch.size(); i++) {
			WebElement Statetabletext = Statesearch.get(i);
			if (Statetabletext.getText().equalsIgnoreCase(data)) {
				String NextdatainState = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')["
						+ i + "]";
				StateData = commonUtils.expandRootElement(NextdatainState);
			} else {
				log.info("Unable to Search State filter tab");
				logger.log(Status.INFO, "Unable to Search State filter tab");
				flag = false;
				assertTrue(flag, "Unable to Search State filter tab");
			}
			commonUtils.scrollBy("pf-table", j);
			i = i + 6;
			j++;
		}
		return flag;
	}

	/* This method help on Input A Value in Priority in assign Investigation */

	public boolean AssignInvestigationSelectPriority(String data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("input a value in Priority filter");
		logger.log(Status.INFO, "input a value in Priority filter");
		WebElement AIPriorityText = commonUtils.expandRootElement(ls.AIPriorityText);
		WebElement AIPriorityAllText = commonUtils.expandRootElement(ls.AIPriorityAllText);
		commonUtils.waitTime(3000);
		if (AIPriorityText.isDisplayed() && AIPriorityAllText.isDisplayed()) {
			commonUtils.waitTime(2000);
			commonUtils.click(AIPriorityAllText);
			commonUtils.waitTime(2000);
			commonUtils.type(AIPriorityAllText, "enter the value in state ", data);
			commonUtils.downenter(AIPriorityAllText);
			commonUtils.waitTime(4000);
			flag = true;
		} else {
			log.info("Unable to enter the value Priority Filter tab");
			logger.log(Status.INFO, "Unable to enter the value Priority Filter tab");
			flag = false;
			assertTrue(flag, "Unable to enter the value Priority Filter tab");
		}
		return flag;
	}

	/* This method help on Priority filter validation in assign Investigation */

	public boolean AssignInvestigationPriorityValidation(String data) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("input a value in Priority filter");
		logger.log(Status.INFO, "input a value in Priority filter");
		commonUtils.scrollBy("pf-table", 10000);
		commonUtils.waitTime(2000);
		List<WebElement> AssaignInvesRowCount = commonUtils.expandRootsElement(ls.AssaignInvesRowCount);
		String rowindex = AssaignInvesRowCount.get(AssaignInvesRowCount.size() - 1).getAttribute("aria-rowindex");
		int totalAssignInboxRow = Integer.parseInt(rowindex);
		commonUtils.waitTime(2000);
		commonUtils.scrollBy("pf-table", 0);
		int j = 0;
		int k = 0;
		for (int i = 0; i < totalAssignInboxRow; i++) {
			if (k > 11) {
				k = 0;
			}
			WebElement Prioritytabletext = commonUtils
					.expandRootElement(ls.PriorityFilterCheck1 + k + ls.PriorityFilterCheck2);
			String text = Prioritytabletext.getText();
			if (text.equalsIgnoreCase(data)) {
				flag = true;
				assertTrue(flag);
			} else {
				log.info("Priority filter is not working as expected");
				logger.log(Status.INFO, "Priority filter is not working as expected");

				assertTrue(flag, "Priority filter is not working as expected");
			}
			commonUtils.scrollBy("pf-table", j);
			j++;
			k++;
		}
		return flag;
	}

	/* This method help on Reading the Memo ID in Search Memos */

	public boolean readMemoId(String text) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("Reading the Memo ID and Checked as same");
		logger.log(Status.INFO, "Reading the Memo ID and Checked as same");
		WebElement memoidnum = commonUtils.expandRootElement(ls.memoidnum);
		if (commonUtils.isElementPresent(memoidnum)) {
			commonUtils.waitTime(4000);
			commonUtils.JSClick(memoidnum);
			commonUtils.waitTime(3000);
			flag = true;
			List<WebElement> memoDetail = commonUtils.expandRootsElement(ls.editermemoDetail);
			String valuememo = null;
			for (int i = 0; i < 1; i++) {
				if (i == 0) {
					valuememo = memoDetail.get(i).getAttribute("value");
					if (text.contains(valuememo)) {
						log.info("Create MemoID and closed Status MemoID is expected as same");
						logger.log(Status.INFO, "Create MemoID and closed Status MemoID is expected as same");
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	/* This method help on memos field Validation in editer menu memo tab */

	public boolean editermemosfieldCheck(String Field) throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("memos field Checking in editer menu memo tab");
		logger.log(Status.INFO, "memos field Checking in editer menu memo tab");
		WebElement editermemoOverViewheader = commonUtils.expandRootElement(ls.editermemoOverViewheader);
		WebElement editermemodetailsheader = commonUtils.expandRootElement(ls.editermemodetailsheader);
		commonUtils.waitTime(10000);
		List<WebElement> memosearchlistcount = ls.memosearchlistContentCount;
		commonUtils.waitTime(2000);
		for (int i = 4; i < memosearchlistcount.size(); i++) {
			commonUtils.waitTime(2000);
			commonUtils.click(memosearchlistcount.get(i));
			String labelname = memosearchlistcount.get(i).getAttribute("label");
			String memoidOverview = labelname.substring(0, 6);
			String memoTypeOverview = labelname.substring(7);
			commonUtils.waitTime(3000);
			List<String> memofieldfromPage = new ArrayList<String>();
			List<WebElement> editermemoDetail = commonUtils.expandRootsElement(ls.editermemoDetail);
			commonUtils.waitTime(3000);
			for (int j = 0; j < editermemoDetail.size(); j++) {
				String attribute = editermemoDetail.get(j).getAttribute("label");
				memofieldfromPage.add(attribute);
			}
			Set<String> readFiledNameFromPATA = readFiledNameFromPATA(Field,
					"Reading the field of memo editor tab field");
			Collections.sort(memofieldfromPage);
			assertEquals(memofieldfromPage, memofieldfromPage,
					"both repository data and web page memo field are not same");
			log.info("All field between the repository and Web page are found to be same");
			log.info(
					"validating the opened memo and memo id are same with same memo type between Overview and Details table");
			String memoidDetails = editermemoDetail.get(0).getAttribute("value");
			commonUtils.waitTime(2000);
			String memoTypeDetails = editermemoDetail.get(3).getAttribute("value");
			commonUtils.waitTime(3000);
			if (memoidDetails.equalsIgnoreCase(memoidOverview) && memoTypeDetails.equalsIgnoreCase(memoTypeOverview)) {
				log.info("Both Overview and Detail moemo id and memotype are found to be same");
				WebElement editermemodetailsheaderwithType = commonUtils.expandRootElement(ls.editermemodetailsheader);
				String text = editermemodetailsheaderwithType.getText();
				if (text.contains(memoTypeDetails)) {
					assertTrue(true);
					log.info("The detail header is showing the memo type name");
				} else {
					assertTrue(false, "The detail header is not showing the memo type name");
				}
			}

		}
		return flag;

	}

	/* This method help on All manditory FIelds Indentify */

	public List<WebElement> AllmanditoryField(String Mode) throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Reading the Feild from web page");
		logger.log(Status.INFO, "Reading the Fields of " + Mode + " DC from web page");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(4000);
		commonUtils.scrollintoView();
		List<WebElement> browserField = new ArrayList<>();
		try {
			// reading all field label and adding it to list
			List<WebElement> accountField = ls.accountField;
			browserField.addAll(accountField);

			List<WebElement> datepicketField = ls.datepicketField;
			browserField.addAll(datepicketField);

			List<WebElement> pf_pktnr_account_field = ls.pf_pktnr_account_field;
			browserField.addAll(pf_pktnr_account_field);

			List<WebElement> textField = ls.textField;
			browserField.addAll(textField);

			List<WebElement> comboboxField = ls.comboboxField;
			browserField.addAll(comboboxField);

			List<WebElement> textareaField = ls.textareaField;
			browserField.addAll(textareaField);

			List<WebElement> checkboxField = ls.checkboxField;
			browserField.addAll(checkboxField);

			try {
				List<WebElement> custom_control = driver.findElements(By.tagName("pf-custom-control"));
				browserField.addAll(custom_control);
			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	public List<WebElement> AllfieldValidation() throws Exception {
		WebElement expandRootElement = commonUtils.expandRootElement(
				"return document.querySelector('#productTabForm > pf-grid > pf-form-layout > pf-date-picker').shadowRoot.querySelector('div > pf-text')");
		expandRootElement.findElement(By.cssSelector(".left-label-container"));
		return null;

	}

	/* This method help on Profile menu all field validation */

	public List<String> ProfileManagementField() throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Profile Management inside fields check");
		logger.log(Status.INFO, "Profile Management inside fields check read from web page");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<String> browserField = new ArrayList<>();
		try {
			// reading all field label and adding it to list
			WebElement UserProfileField = ls.UserProfileField;
			String attribute2 = UserProfileField.getAttribute("label").trim();
			browserField.add(attribute2);

			List<WebElement> allUserProfileField = ls.allUserProfileField;
			for (int i = 0; i < allUserProfileField.size(); i++) {
				String attribute = allUserProfileField.get(i).getAttribute("label").trim();
				browserField.add(attribute);
			}
			commonUtils.scrollintoView();
			List<WebElement> AllUserDefinitionField = ls.AllUserDefinitionField;
			for (int i = 0; i < AllUserDefinitionField.size(); i++) {
				String attribute = AllUserDefinitionField.get(i).getAttribute("label").trim();
				browserField.add(attribute);
			}

			List<WebElement> AllCheckBoxField = ls.AllCheckBoxField;
			for (int i = 0; i < AllCheckBoxField.size(); i++) {
				String attribute = AllCheckBoxField.get(i).getAttribute("label").trim();
				browserField.add(attribute);
			}
			commonUtils.scrollintoView();
			List<WebElement> AllDepartmentField = ls.AllDepartmentField;
			for (int i = 0; i < AllDepartmentField.size(); i++) {
				String attribute = AllDepartmentField.get(i).getAttribute("label").trim();
				browserField.add(attribute);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	/* This method help on Click the Profile Management in Profile menu */

	public boolean ClickProfileManagment() throws Exception {
		boolean flag = false;
		NAPFLocators ls = new NAPFLocators();
		log.info("Clicking the profile menu and profile management");
		logger.log(Status.INFO, "Clicking the profile menu and profile management");
		commonUtils.waitTime(3000);
		commonUtils.jsElementFinder(ls.headerProfileMenu).click();
		commonUtils.waitTime(2000);
		WebElement profilemanagement = commonUtils.expandRootElement(ls.profilemanagement);
		if (commonUtils.isElementPresent(profilemanagement)) {
			commonUtils.click(profilemanagement);
			flag = true;
		} else {
			log.info("Unable to Click the Profile Management profile");
			logger.log(Status.INFO, "Unable to Click the Profile Management profile");
			assertTrue(flag, "Unable to Click the Profile Management profile");
		}
		return flag;
	}

	/* This method help on Click theAdd Profile Button After Profile managment */

	public void AddProfileButton() throws Exception {
		log.info("Click the Add profile button (plus button)");
		logger.log(Status.INFO, "Click the Add profile button (plus button)");
		NAPFLocators ls = new NAPFLocators();
		WebElement ProfileADDButton = commonUtils.expandRootElement(ls.ProfileADDButton);
		if (commonUtils.isElementPresent(ProfileADDButton)) {
			commonUtils.click(ProfileADDButton);
		} else {
			log.info("Unable to Click the Add profile button (plus button)");
			logger.log(Status.INFO, " Unable to Click the Add profile button (plus button)");
		}
	}

	/* This method help on Create User Profile Managemanet */

	public String profileName = null;

	public boolean CreateProfileManagemanet(Map<String, String> testdata) throws Exception {
		boolean flag = false;
		log.info("Creating the User Profile");
		logger.log(Status.INFO, "Creating the User Profile");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.jsElementFinder(ls.headerProfileMenu).click();
		commonUtils.waitTime(2000);
		commonUtils.jsElementFinder(ls.DropDownButton).click();
		List<WebElement> UserProfileList1 = commonUtils.expandRootsElement(ls.UserProfileList1);
		if (UserProfileList1.size() < 5) {
			commonUtils.waitTime(2000);
			AddProfileButton();
			commonUtils.waitTime(1000);
			WebElement profilemanagement = commonUtils.expandRootElement(ls.profilemanagement);
			commonUtils.click(profilemanagement);
			commonUtils.waitTime(2000);
			WebElement ProfileADDButton = commonUtils.expandRootElement(ls.ProfileADDButton);
			commonUtils.waitTime(1000);
			commonUtils.click(ProfileADDButton);
			commonUtils.waitTime(2000);
			WebElement ProNameInput = commonUtils.expandRootElement(ls.ProNameInput);
			commonUtils.waitTime(2000);
			commonUtils.click(ProNameInput);
			commonUtils.waitTime(2000);
			commonUtils.type(ProNameInput, "typing profile name", testdata.get("Profile Name"));
			commonUtils.waitTime(1000);
			WebElement UserFirstnameinput = commonUtils.expandRootElement(ls.UserFirstnameinput);
			commonUtils.waitTime(2000);
			commonUtils.click(UserFirstnameinput);
			commonUtils.waitTime(2000);
			commonUtils.type(UserFirstnameinput, "typing First name", testdata.get("First Name"));
			commonUtils.waitTime(1000);
			WebElement UserlastNameinput = commonUtils.expandRootElement(ls.UserlastNameinput);
			commonUtils.waitTime(2000);
			commonUtils.click(UserlastNameinput);
			commonUtils.waitTime(2000);
			commonUtils.type(UserlastNameinput, "typing Last name", testdata.get("Last Name"));
			commonUtils.waitTime(2000);
			WebElement Printerinput = commonUtils.expandRootElement(ls.Printerinput);
			commonUtils.waitTime(1000);
			commonUtils.click(Printerinput);
			commonUtils.waitTime(2000);
			commonUtils.type(Printerinput, "typing Printer input", testdata.get("Printer Name"));
			commonUtils.waitTime(1000);
			commonUtils.scrollintoViewinpopup(ls.PopupScroll);
			commonUtils.waitTime(1000);
			WebElement Workgroupinput = commonUtils.expandRootElement(ls.Workgroupinput);
			commonUtils.JSClick(Workgroupinput);
			commonUtils.waitTime(2000);
			commonUtils.type(Workgroupinput, "Enter the Work Group tab ", testdata.get("Work Group"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(Workgroupinput);
			WebElement prosnameinput = commonUtils.expandRootElement(ls.prosnameinput);
			commonUtils.JSClick(prosnameinput);
			commonUtils.waitTime(2000);
			commonUtils.type(prosnameinput, "Enter the Process Name tab ", testdata.get("Process Name"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(prosnameinput);
			WebElement UPTAinput = commonUtils.expandRootElement(ls.UPTAinput);
			commonUtils.JSClick(UPTAinput);
			commonUtils.waitTime(2000);
			commonUtils.selectAllClean(UPTAinput);
			commonUtils.type(UPTAinput, "Enter the TA Name tab ", testdata.get("TA Name"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(UPTAinput);
			WebElement Queuenameinput = commonUtils.expandRootElement(ls.Queuenameinput);
			commonUtils.JSClick(Queuenameinput);
			commonUtils.waitTime(2000);
			commonUtils.type(Queuenameinput, "Enter the Queue Name tab ", testdata.get("Queue Name"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(Queuenameinput);
			WebElement Deleverychanneelinput = commonUtils.expandRootElement(ls.Deleverychanneelinput);
			commonUtils.JSClick(Deleverychanneelinput);
			commonUtils.waitTime(2000);
			commonUtils.type(Deleverychanneelinput, "Enter the Delevery Channel tab ",
					testdata.get("Delevery Channel"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(Deleverychanneelinput);
			WebElement TemplateIDinput = commonUtils.expandRootElement(ls.TemplateIDinput);
			commonUtils.JSClick(TemplateIDinput);
			commonUtils.waitTime(2000);
			commonUtils.type(TemplateIDinput, "Enter the Template-ID tab ", testdata.get("Template ID"));
			commonUtils.waitTime(1000);
			commonUtils.downenter(TemplateIDinput);
			flag = true;
			commonUtils.scrollintoViewinpopupUserProfile(ls.PopupScroll);
			commonUtils.waitTime(2000);
			WebElement ProNameInput1 = commonUtils.expandRootElement(ls.ProNameInput);
			profileName = ProNameInput1.getAttribute("value");
		} else {
			commonUtils.waitTime(2000);
			WebElement profilemanagement = commonUtils.expandRootElement(ls.profilemanagement);
			commonUtils.JSClick(profilemanagement);
			commonUtils.waitTime(2000);
			AddProfileButton();
			commonUtils.waitTime(1000);
			WebElement MaxprofilePopup = commonUtils.expandRootElement(ls.MaxprofilePopup);
			WebElement MaxprofilePopupClose = commonUtils.expandRootElement(ls.MaxprofilePopupClose);
			if (commonUtils.isElementPresent(MaxprofilePopup)) {
				commonUtils.waitTime(2000);
				WebElement MaxprofilePopupClose1 = commonUtils.expandRootElement(ls.MaxprofilePopupClose);
				commonUtils.click(MaxprofilePopupClose1);
				log.info("if exceed the maximum profile count");
				logger.log(Status.INFO, "if exceed the maximum profile count");
				flag = true;
				assertTrue(flag, "if exceed the maximum profile count");
			} else {
				log.info("maximum profile count PopUp is not Opened");
				logger.log(Status.INFO, "maximum profile count PopUp is not Opened");
				assertTrue(flag, "maximum profile count PopUp is not Opened");
			}
		}

		return flag;
	}

	public boolean ProfileManagemanetEdit(String data, String data1, String data2) throws Exception {
		boolean flag = false;
		log.info("Editing the New User Profile");
		logger.log(Status.INFO, "Editing the New User Profile");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(1000);
		WebElement UserProfileInput = commonUtils.expandRootElement(ls.UserProfileInput);
		commonUtils.waitTime(2000);
		commonUtils.click(UserProfileInput);
		commonUtils.waitTime(2000);
		commonUtils.selectAllClean(UserProfileInput);
		commonUtils.waitTime(1000);
		commonUtils.type(UserProfileInput, "typing the leatest creating profile", data);
		commonUtils.downenter(UserProfileInput);
		commonUtils.waitTime(1000);
		WebElement FisrtUserName = ls.FisrtUserName;
		String FirstName = FisrtUserName.getAttribute("value");
		WebElement lastUsername = ls.lastUsername;
		String lastname = lastUsername.getAttribute("value");
		WebElement EditButtonProManagment = commonUtils.expandRootElement(ls.EditButtonProManagment);
		commonUtils.waitTime(1000);
		commonUtils.click(EditButtonProManagment);
		commonUtils.waitTime(3000);
		WebElement UserFirstnameinput = commonUtils.expandRootElement(ls.UserFirstnameinput);
		commonUtils.waitTime(2000);
		commonUtils.click(UserFirstnameinput);
		commonUtils.waitTime(1000);
		commonUtils.selectAllClean(UserFirstnameinput);
		commonUtils.waitTime(2000);
		commonUtils.type(UserFirstnameinput, "typing First name", data1);
		commonUtils.waitTime(1000);
		WebElement UserlastNameinput = commonUtils.expandRootElement(ls.UserlastNameinput);
		commonUtils.waitTime(2000);
		commonUtils.click(UserlastNameinput);
		commonUtils.waitTime(1000);
		commonUtils.selectAllClean(UserlastNameinput);
		commonUtils.waitTime(2000);
		commonUtils.type(UserlastNameinput, "typing Last name", data2);
		commonUtils.waitTime(2000);
		SAVEProfileManagement();
		WebElement FisrtUserName1 = ls.FisrtUserName;
		String FirstName2 = FisrtUserName1.getAttribute("value");
		WebElement lastUsername1 = ls.lastUsername;
		String lastname2 = lastUsername1.getAttribute("value");
		if (FirstName.equalsIgnoreCase(FirstName2) && lastname.equalsIgnoreCase(lastname2)) {
			log.info("Edit profile is Not working on Profile Managment");
			logger.log(Status.INFO, "Edit profile is Not working on Profile Managment");
			flag = false;
		} else {
			log.info("Edit profile is working on Profile Managment");
			logger.log(Status.INFO, "Edit profile is working on Profile Managment");
			flag = true;
			assertTrue(flag, "Edit profile is working on Profile Managment");
		}

		return flag;
	}

	/* This method help on Create User Profile Managemanet Delete Function */

	public boolean ProfileManagementDeleteFunction(String data) throws Exception {
		boolean flag = false;
		log.info("Deleteing the User Profile ManageMent Tab");
		logger.log(Status.INFO, "Deleteing the User Profile ManageMent Tab");
		NAPFLocators ls = new NAPFLocators();
		WebElement UserProfileInput = commonUtils.expandRootElement(ls.UserProfileInput);
		commonUtils.waitTime(2000);
		commonUtils.click(UserProfileInput);
		commonUtils.waitTime(2000);
		commonUtils.selectAllClean(UserProfileInput);
		commonUtils.waitTime(1000);
		commonUtils.type(UserProfileInput, "typing the leatest creating profile", data);
		commonUtils.downenter(UserProfileInput);
		commonUtils.waitTime(1000);
		WebElement FisrtUserName = ls.FisrtUserName;
		String AfterFirstName = FisrtUserName.getAttribute("value");
		WebElement lastUsername = ls.lastUsername;
		String Afterlastname = lastUsername.getAttribute("value");
		WebElement ProfileDeleteButton = commonUtils.expandRootElement(ls.ProfileDeleteButton);
		commonUtils.waitTime(2000);
		commonUtils.click(ProfileDeleteButton);
		commonUtils.waitTime(2000);
		WebElement ProfileDeletePopup = commonUtils.expandRootElement(ls.ProfileDeletePopup);
		WebElement ProfileDeletePopupDelete = commonUtils.expandRootElement(ls.ProfileDeletePopupDelete);
		commonUtils.waitTime(2000);
		commonUtils.click(ProfileDeletePopupDelete);
		commonUtils.waitTime(3000);
		WebElement FisrtUserName1 = ls.FisrtUserName;
		String AfterdeleteFirstName = FisrtUserName1.getAttribute("value");
		WebElement lastUsername2 = ls.lastUsername;
		String Afterdeletelastname = lastUsername2.getAttribute("value");
		if (AfterFirstName.equalsIgnoreCase(AfterdeleteFirstName)
				&& Afterlastname.equalsIgnoreCase(Afterdeletelastname)) {
			log.info("Unable to Delete a Profile Management tab");
			logger.log(Status.INFO, "Unable to Delete a Profile Management tab");
			flag = false;
			assertTrue(flag, "Unable to Close a Delete Management tab");
		} else {
			log.info("successfully to Delete a Profile Management tab");
			logger.log(Status.INFO, "successfully to Delete a Profile Management tab");
			flag = true;
			assertTrue(flag, "successfully to Close a Delete Management tab");
		}

		return flag;
	}

	/* This method help on Create User Profile Managemanet SAVE Function */

	public boolean SAVEProfileManagement() throws Exception {
		boolean flag = false;
		log.info("Save to Profile ManageMent Tab");
		logger.log(Status.INFO, "Save to Profile ManageMent Tab");
		NAPFLocators ls = new NAPFLocators();
		WebElement ProfileSaveButton = commonUtils.expandRootElement(ls.ProfileSaveButton);
		commonUtils.waitTime(2000);
		commonUtils.click(ProfileSaveButton);
		log.info("successfully to Saving a Profile Management tab");
		logger.log(Status.INFO, "successfully to Saving a Profile Management tab");
		WebElement ProfileCloseButton = commonUtils.expandRootElement(ls.ProfileCloseButton);
		commonUtils.waitTime(2000);
		commonUtils.click(ProfileCloseButton);
		flag = true;

		return flag;
	}

	public List<String> SearchMemosField() throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Search Memos inside fields check");
		logger.log(Status.INFO, "Search Memos fields check read from web page");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<String> browserField = new ArrayList<>();
		try {
			// reading all field label and adding it to list

			List<WebElement> pfcomboBoxFieldmemos = ls.pfcomboBoxFieldmemos;
			for (int i = 0; i < pfcomboBoxFieldmemos.size(); i++) {
				String attribute = pfcomboBoxFieldmemos.get(i).getAttribute("label").trim();
				browserField.add(attribute);
			}

			List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
			log.info("custom_field element is present in this page");
			for (int i = 0; i < findElement.size(); i++) {
				boolean displayed = findElement.get(i).isDisplayed();
				if (displayed) {
					WebElement expandRootElement = commonUtils
							.expandRootElement(ls.pfcustomcontrolMemos1 + i + ls.pfcustomcontrolMemos2);
					browserField.add(expandRootElement.getText().trim());
				}
			}

			WebElement pftextFieldmemos = ls.pftextFieldmemos;
			String attribute2 = pftextFieldmemos.getAttribute("label").trim();
			browserField.add(attribute2);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	public Set<String> WorkGroupValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		Set<String> list = new TreeSet<String>();
		logger.log(Status.INFO, "Selecting the Work Group Values");
		for (int i = 0; i < size; i++) {
			WebElement Workgroupinput = commonUtils.expandRootElement(ls.Workgroupinput);
			commonUtils.click(Workgroupinput);
			commonUtils.waitTime(3000);
			commonUtils.downenterkey(Workgroupinput);
			commonUtils.waitTime(3000);
			String Workgroupinput1 = commonUtils.expandRootElement(ls.Workgroupinput).getAttribute("value").trim();
			list.add(Workgroupinput1);
		}
		return list;
	}

	public Set<String> ProcessValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		Set<String> list = new TreeSet<String>();
		logger.log(Status.INFO, "Selecting the Process Values");
		WebElement prosnameinput = commonUtils.expandRootElement(ls.prosnameinput);
		for (int i = 0; i < size; i++) {
			commonUtils.click(prosnameinput);
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(prosnameinput);
			commonUtils.waitTime(3000);
			String prosnameinput1 = commonUtils.expandRootElement(ls.prosnameinput).getAttribute("value").trim();
			list.add(prosnameinput1);
		}
		return list;
	}

	public Set<String> TANameValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		Set<String> list = new TreeSet<String>();
		logger.log(Status.INFO, "Selecting the TA name values");
		WebElement UPTAinput = commonUtils.expandRootElement(ls.UPTAinput);
		commonUtils.click(UPTAinput);
		commonUtils.selectAllClean(UPTAinput);
		commonUtils.click(UPTAinput);
		for (int i = 0; i < size; i++) {
			commonUtils.click(UPTAinput);
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(UPTAinput);
			commonUtils.waitTime(3000);
			String UPTAinput1 = commonUtils.expandRootElement(ls.UPTAinput).getAttribute("value").trim();
			list.add(UPTAinput1);
		}
		return list;
	}

	public List<String> QueueNameValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<String> list = new ArrayList<String>();
		logger.log(Status.INFO, "Selecting the Queue name values");
		WebElement Queuenameinput = commonUtils.expandRootElement(ls.Queuenameinput);
		for (int i = 0; i < size; i++) {
			commonUtils.click(Queuenameinput);
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(Queuenameinput);
			commonUtils.waitTime(3000);
			String Queuenameinput1 = commonUtils.expandRootElement(ls.Queuenameinput).getAttribute("value").trim();
			list.add(Queuenameinput1);
		}
		return list;
	}

	public List<String> DeleveryChannelValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<String> list = new ArrayList<String>();
		logger.log(Status.INFO, "Selecting the Delevery Channel values");
		WebElement Deleverychanneelinput = commonUtils.expandRootElement(ls.Deleverychanneelinput);
		commonUtils.click(Deleverychanneelinput);
		commonUtils.waitTime(2000);
		String Deleverychanneelinput1 = commonUtils.expandRootElement(ls.Deleverychanneelinput).getAttribute("value")
				.trim();
		list.add(Deleverychanneelinput1);
		for (int i = 0; i < size; i++) {
			commonUtils.click(Deleverychanneelinput);
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(Deleverychanneelinput);
			commonUtils.waitTime(3000);
			String Deleverychanneelinput2 = commonUtils.expandRootElement(ls.Deleverychanneelinput)
					.getAttribute("value").trim();
			list.add(Deleverychanneelinput2);
		}
		return list;
	}

	public List<String> TemplateIDValuesValidation(int size) throws Exception {
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(2000);
		List<String> list = new ArrayList<String>();
		logger.log(Status.INFO, "Selecting the Template-ID values");
		WebElement TemplateIDinput = commonUtils.expandRootElement(ls.TemplateIDinput);
		commonUtils.click(TemplateIDinput);
		commonUtils.waitTime(2000);
		String TemplateIDinput1 = commonUtils.expandRootElement(ls.TemplateIDinput).getAttribute("value").trim();
		list.add(TemplateIDinput1);
		for (int i = 0; i < size; i++) {
			commonUtils.click(TemplateIDinput);
			commonUtils.waitTime(2000);
			commonUtils.downenterkey(TemplateIDinput);
			commonUtils.waitTime(3000);
			String TemplateIDinput2 = commonUtils.expandRootElement(ls.TemplateIDinput).getAttribute("value").trim();
			list.add(TemplateIDinput2);
		}
		return list;
	}

	public List<String> ProductfieldValidationAndClick(String Mode, String data, String testdata)
			throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Reading the Field from web page");
		logger.log(Status.INFO, "Reading the Fields of " + Mode + " DC from web page");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		commonUtils.scrollintoView();
		List<String> browserField = new ArrayList<String>();
		try {
			List<WebElement> accountField = ls.accountField;
			for (int i = 0; i < accountField.size(); i++) {
				String trim = accountField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(accountField.get(i));
					commonUtils.type(accountField.get(i), "enter data in" + data, testdata);
				}
			}
			List<WebElement> datepicketField = ls.datepicketField;
			for (int i = 0; i < datepicketField.size(); i++) {
				String trim = datepicketField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(datepicketField.get(i));
					commonUtils.type(datepicketField.get(i), "enter data in" + data, testdata);
					commonUtils.waitTime(2000);
					Actions ac = new Actions(driver);
					ac.sendKeys(Keys.TAB).build().perform();
					ac.sendKeys(Keys.TAB).build().perform();
					ac.sendKeys(Keys.TAB).build().perform();
					ac.sendKeys(Keys.ENTER).build().perform();
				}
			}
			List<WebElement> pf_pktnr_account_field = ls.pf_pktnr_account_field;
			for (int i = 0; i < pf_pktnr_account_field.size(); i++) {
				String trim = pf_pktnr_account_field.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(pf_pktnr_account_field.get(i));
					commonUtils.type(pf_pktnr_account_field.get(i), "enter data in" + data, testdata);
				}
			}
			List<WebElement> textField = ls.textField;
			for (int i = 0; i < textField.size(); i++) {
				String trim = textField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(textField.get(i));
					commonUtils.type(textField.get(i), "enter data in" + data, testdata);
				}
			}
			List<WebElement> comboboxField = ls.comboboxField;
			for (int i = 0; i < comboboxField.size(); i++) {
				String trim = comboboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(comboboxField.get(i));
					commonUtils.type(comboboxField.get(i), "enter data in" + data, testdata);
				}
			}
			List<WebElement> textareaField = ls.textareaField;
			for (int i = 0; i < textareaField.size(); i++) {
				String trim = textareaField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(textareaField.get(i));
					commonUtils.type(textareaField.get(i), "enter data in" + data, testdata);
				}
			}
			List<WebElement> checkboxField = ls.checkboxField;
			for (int i = 0; i < checkboxField.size(); i++) {
				String trim = checkboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					commonUtils.click(checkboxField.get(i));
					commonUtils.type(checkboxField.get(i), "enter data in" + data, testdata);
				}
			}
			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils.expandRootElement(ls.custom_field);
						String trim = expandRootElement.getAttribute("label").trim();
						if (trim.equalsIgnoreCase(data)) {
							commonUtils.click(expandRootElement);
							commonUtils.type(expandRootElement, "enter data in" + data, testdata);
						}
					}
				}

			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
			// sort the list browserField
			Collections.sort(browserField);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	public List<String> IdaViewfieldValidation(String Headers) throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Validating the IDA-Results View Fields");
		logger.log(Status.INFO, "Validating the IDA-Results View Fields" + Headers);
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		commonUtils.scrollintoView();
		List<String> browserField = new ArrayList<String>();
		try {
			List<WebElement> accountField = ls.accountField;
			for (int i = 0; i < accountField.size(); i++) {
				String trim = accountField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> datepicketField = ls.datepicketField;
			for (int i = 0; i < datepicketField.size(); i++) {
				String trim = datepicketField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> pf_pktnr_account_field = ls.pf_pktnr_account_field;
			for (int i = 0; i < pf_pktnr_account_field.size(); i++) {
				String trim = pf_pktnr_account_field.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> textField = ls.textField;
			for (int i = 0; i < textField.size(); i++) {
				String trim = textField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> comboboxField = ls.comboboxField;
			for (int i = 0; i < comboboxField.size(); i++) {
				String trim = comboboxField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> textareaField = ls.textareaField;
			for (int i = 0; i < textareaField.size(); i++) {
				String trim = textareaField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			List<WebElement> checkboxField = ls.checkboxField;
			for (int i = 0; i < checkboxField.size(); i++) {
				String trim = checkboxField.get(i).getAttribute("label").trim();
				browserField.add(trim);
			}
			commonUtils.waitTime(2000);
			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils.expandRootElement(ls.custom_field);
						String trim = expandRootElement.getAttribute("label").trim();
						browserField.add(trim);
					}
				}
				commonUtils.waitTime(2000);
			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
			// sort the list browserField
			Collections.sort(browserField);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		return browserField;
	}

	public void ClickIDAViewButton() throws Exception {
		NAPFLocators ls = new NAPFLocators();
		log.info("Click the IDA-Results View ");
		logger.log(Status.INFO, "Click the IDA-Results View ");
		WebElement IDAActionViewTrans = commonUtils.expandRootElement(ls.IDAActionViewTrans);
		commonUtils.waitTime(1000);
		commonUtils.click(IDAActionViewTrans);
	}
	
	public String ClickCheckboxAndPopulatevalue(String data) throws Exception {
		log.info("Click CheckBox And enter the Populate value IDA-Results View Fields");
		logger.log(Status.INFO, "Click CheckBox And enter the Populate value IDA-Results View Fields");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		String NFTransID = null;
		WebElement checkBoxIDA = commonUtils.expandRootElement(ls.checkBoxIDA);
		if (commonUtils.isElementPresent(checkBoxIDA)) {
			commonUtils.waitTime(2000);
			commonUtils.click(checkBoxIDA);
			WebElement StandedInputField = commonUtils.expandRootElement(ls.StandedInputField);
			if (commonUtils.isElementPresent(StandedInputField)) {
				commonUtils.waitTime(2000);
				commonUtils.click(StandedInputField);
				commonUtils.waitTime(2000);
				commonUtils.type(StandedInputField, "Enter the value", data);
				commonUtils.downenter(StandedInputField);
				commonUtils.waitTime(7000);
				NFTransID = commonUtils.expandRootElement(ls.NFTransIDNumber).getText();
				commonUtils.waitTime(2000);
			} else {
				log.info("Unable to Enter Value in Standed Input Field  Box");
				logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
				assertTrue(false, "Unable to Enter Value in Standed Input Field  Box");
			}
		} else {
			log.info("Unable to Enter Value in Standed Input Field  Box");
			logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
			assertTrue(false, "Unable to Enter Value in Standed Input Field  Box");
		}

		return NFTransID;
	}

	public boolean ClickCheckboxAndPopulate(String data) throws Exception {
		boolean flag = false;
		log.info("Click CheckBox And enter the Populate value IDA-Results View Fields");
		logger.log(Status.INFO, "Click CheckBox And enter the Populate value IDA-Results View Fields");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		WebElement checkBoxIDA = commonUtils.expandRootElement(ls.checkBoxIDA);
		if (commonUtils.isElementPresent(checkBoxIDA)) {
			commonUtils.waitTime(2000);
			commonUtils.click(checkBoxIDA);
			flag = true;
			WebElement StandedInputField = commonUtils.expandRootElement(ls.StandedInputField);
			if (commonUtils.isElementPresent(StandedInputField)) {
				commonUtils.waitTime(2000);
				commonUtils.click(StandedInputField);
				commonUtils.waitTime(2000);
				commonUtils.type(StandedInputField, "Enter the value", data);
				commonUtils.downenter(StandedInputField);
				commonUtils.waitTime(7000);
				flag = true;
				WebElement populatebutton = commonUtils.expandRootElement(ls.populatebutton);
				if (populatebutton.isEnabled()) {
					commonUtils.waitTime(2000);
					populatebutton.click();
					commonUtils.waitTime(3000);
					flag = true;
				} else {
					log.info("Unable to Click Populate button");
					logger.log(Status.INFO, "Unable to Click Populate button");
					assertTrue(flag, "Unable to Click Populate button");
				}
			} else {
				log.info("Unable to Enter Value in Standed Input Field  Box");
				logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
				assertTrue(flag, "Unable to Enter Value in Standed Input Field  Box");
			}
		} else {
			log.info("Unable to Enter Value in Standed Input Field  Box");
			logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
			assertTrue(flag, "Unable to Enter Value in Standed Input Field  Box");
		}

		return flag;
	}

	public List<String> IdaViewfieldGetValue(String data) throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Validating the IDA-Results View Fields and get value");
		logger.log(Status.INFO, "Validating the IDA-Results View Fields and get value");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		commonUtils.ScreenMaxzoomout();
		List<String> browserField = new ArrayList<String>();
		try {
			List<WebElement> accountField = ls.accountField;
			for (int i = 0; i < accountField.size(); i++) {
				String trim = accountField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = accountField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> datepicketField = ls.datepicketField;
			for (int i = 0; i < datepicketField.size(); i++) {
				String trim = datepicketField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = datepicketField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> pf_pktnr_account_field = ls.pf_pktnr_account_field;
			for (int i = 0; i < pf_pktnr_account_field.size(); i++) {
				String trim = pf_pktnr_account_field.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = pf_pktnr_account_field.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> textField = ls.textField;
			for (int i = 0; i < textField.size(); i++) {
				String trim = textField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = textField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> comboboxField = ls.comboboxField;
			for (int i = 0; i < comboboxField.size(); i++) {
				String trim = comboboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = comboboxField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> textareaField = ls.textareaField;
			for (int i = 0; i < textareaField.size(); i++) {
				String trim = textareaField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = textareaField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> checkboxField = ls.checkboxField;
			for (int i = 0; i < checkboxField.size(); i++) {
				String trim = checkboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = checkboxField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
					break;
				}
			}
			commonUtils.waitTime(2000);
			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils.expandRootElement(ls.custom_field);
						String trim = expandRootElement.getAttribute("label").trim();
						if (trim.equalsIgnoreCase(data)) {
							String trimvalue = findElement.get(i).getAttribute("value").trim();
							browserField.add(trimvalue);
						}
					}
					break;
				}
				commonUtils.waitTime(2000);
			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
			// sort the list browserField
			Collections.sort(browserField);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		commonUtils.ScreenMaxzoomIN();
		return browserField;

	}

	public List<String> ProductGetvalue(String data) throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Validating the Product TAb Fields and get value");
		logger.log(Status.INFO, "Validating the Product TAb Fields and get value");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		commonUtils.ScreenMaxzoomout();
		List<String> browserField = new ArrayList<String>();
		try {
			List<WebElement> accountField = ls.accountField;
			for (int i = 0; i < accountField.size(); i++) {
				String trim = accountField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = accountField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> datepicketField = ls.datepicketField;
			for (int i = 0; i < datepicketField.size(); i++) {
				String trim = datepicketField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = datepicketField.get(i).getAttribute("value").trim();
					SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
					s.format(trimvalue);
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> pf_pktnr_account_field = ls.pf_pktnr_account_field;
			for (int i = 0; i < pf_pktnr_account_field.size(); i++) {
				String trim = pf_pktnr_account_field.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = pf_pktnr_account_field.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> textField = ls.textField;
			for (int i = 0; i < textField.size(); i++) {
				String trim = textField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = textField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> comboboxField = ls.comboboxField;
			for (int i = 0; i < comboboxField.size(); i++) {
				String trim = comboboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = comboboxField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> textareaField = ls.textareaField;
			for (int i = 0; i < textareaField.size(); i++) {
				String trim = textareaField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = textareaField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			List<WebElement> checkboxField = ls.checkboxField;
			for (int i = 0; i < checkboxField.size(); i++) {
				String trim = checkboxField.get(i).getAttribute("label").trim();
				if (trim.equalsIgnoreCase(data)) {
					String trimvalue = checkboxField.get(i).getAttribute("value").trim();
					browserField.add(trimvalue);
				}
			}
			commonUtils.waitTime(2000);
			try {
				List<WebElement> findElement = driver.findElements(By.tagName("pf-custom-control"));
				for (int i = 0; i < findElement.size(); i++) {
					boolean displayed = findElement.get(i).isDisplayed();
					if (displayed) {
						WebElement expandRootElement = commonUtils.expandRootElement(ls.custom_field);
						String trim = expandRootElement.getAttribute("label").trim();
						if (trim.equalsIgnoreCase(data)) {
							String trimvalue = findElement.get(i).getAttribute("value").trim();
							browserField.add(trimvalue);
						}
					}
				}
				commonUtils.waitTime(2000);
			} catch (Exception e) {
				log.info("custom_field is not presentin this page");
			}
			// sort the list browserField
			Collections.sort(browserField);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.ERROR, e);
		}
		commonUtils.ScreenMaxzoomIN();
		return browserField;
	}

	public List<String> Idapartnertyperead() throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Validating the IDA-Results View Fields");
		logger.log(Status.INFO, "Validating the IDA-Results View Fields");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		List<String> partnerty = new ArrayList<String>();
		commonUtils.scrollBy("pf-table", 1000);
		List<WebElement> userinboxrowcount = commonUtils.expandRootsElement(ls.userinboxrowcount);
		String rowindex = userinboxrowcount.get(userinboxrowcount.size() - 1).getAttribute("aria-rowindex");
		int totaluserInboxRow = Integer.parseInt(rowindex);
		commonUtils.scrollBy("pf-table", 0);
		int k = 21;
		for (int i = 0; i < totaluserInboxRow; i++) {
			WebElement partnertype = commonUtils.expandRootElement(ls.partnertypenames + k + "]");
			commonUtils.waitTime(1000);
			String partnertyp = partnertype.getText();
			partnerty.add(partnertyp);
			commonUtils.waitTime(2000);
			k = k + 7;
		}
		return partnerty;
	}

	public List<String> IdaActiviteread() throws InterruptedException, Exception {
		boolean flag = false;
		log.info("Validating the IDA-Results View Fields");
		logger.log(Status.INFO, "Validating the IDA-Results View Fields");
		NAPFLocators ls = new NAPFLocators();
		commonUtils.waitTime(3000);
		List<String> Activites = new ArrayList<String>();
		commonUtils.scrollBy("pf-table", 1000);
		List<WebElement> userinboxrowcount = commonUtils.expandRootsElement(ls.userinboxrowcount);
		String rowindex = userinboxrowcount.get(userinboxrowcount.size() - 1).getAttribute("aria-rowindex");
		int totaluserInboxRow = Integer.parseInt(rowindex);
		commonUtils.scrollBy("pf-table", 0);
		int k = 29;
		for (int i = 0; i < totaluserInboxRow; i++) {
			WebElement Activite = commonUtils.expandRootElement(ls.Activitesusername + k + "]");
			commonUtils.waitTime(1000);
			String Activitesname = Activite.getText();
			Activites.add(Activitesname);
			commonUtils.waitTime(2000);
			k = k + 9;
		}
		return Activites;

	}

	public boolean ClickThirdParty(String data) throws Exception {
		boolean flag = false;
		log.info("goes to Click Third party function");
		logger.log(Status.INFO, "goes to Click Third party function");
		NAPFLocators ls = new NAPFLocators();
		WebElement CreateCheckpartybutton = commonUtils.expandRootElement(ls.CreateCheckpartybutton);
		if (commonUtils.isElementPresent(CreateCheckpartybutton)) {
			commonUtils.waitTime(2000);
			commonUtils.click(CreateCheckpartybutton);
			commonUtils.waitTime(2000);
			flag = true;
			WebElement letterbuttonpopup = commonUtils.expandRootElement(ls.letterbuttonpopup);
			WebElement MTCAMTbuttonpopup = commonUtils.expandRootElement(ls.MTCAMTbuttonpopup);
			if (commonUtils.isElementPresent(letterbuttonpopup) && commonUtils.isElementPresent(MTCAMTbuttonpopup)) {
				commonUtils.waitTime(2000);
				commonUtils.click(letterbuttonpopup);
				commonUtils.waitTime(2000);
				flag = true;
			} else {
				log.info("Unable to Enter Value in Standed Input Field  Box");
				logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
				assertTrue(flag, "Unable to Enter Value in Standed Input Field  Box");
			}
		} else {
			log.info("Unable to Enter Value in Standed Input Field  Box");
			logger.log(Status.INFO, "Unable to Enter Value in Standed Input Field  Box");
			assertTrue(flag, "Unable to Enter Value in Standed Input Field  Box");
		}

		return flag;
	}

}
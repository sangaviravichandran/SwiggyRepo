/*
 * package ch.post.pf.nf.ta.scenarios;
 * 
 * import static org.testng.Assert.assertEquals; import static
 * org.testng.Assert.assertTrue; import java.io.IOException; import
 * java.util.Collections; import java.util.List; import java.util.Map; import
 * org.slf4j.Logger; import com.aventstack.extentreports.Status; import
 * ch.post.pf.nf.ta.baseutils.CommonUtils; import
 * ch.post.pf.nf.ta.baseutils.Log4jUtil; import
 * ch.post.pf.nf.ta.baseutils.ReadData; import ch.post.pf.nf.ta.baseutils.Setup;
 * import ch.post.pf.nf.ta.dao.DAOTest; import
 * ch.post.pf.nf.ta.pagefactory.NAPFLocators;
 * 
 * public class IDAResultsScenarios extends Setup {
 * 
 * Logger log = Log4jUtil.loadLogger(IDAResultsScenarios.class); CommonUtils
 * commonUtils = new CommonUtils(); CreateNFScenarios CNFScenarios = new
 * CreateNFScenarios(); String readNFNumber=null;
 * 
 * This Scenario help on Open Nf id and stay same window
 * 
 * public void openNFInvestigation(String testdata) throws IOException,
 * Exception { logger.log(Status.INFO, "Opening the Nf id of DC "); DAOTest
 * daoTest = new DAOTest(); boolean openNf = daoTest.openNf(testdata);
 * assertTrue(openNf, "The NF page could not be found.");
 * constructOpenNfAndLoad(testdata); }
 * 
 * This Scenario help on load nf number in Open NF id Field
 * 
 * public void constructOpenNfAndLoad(String number) throws Exception {
 * 
 * driver.get(ReadData.getTestProperty(OPEN_NF_URL) + number);
 * logger.log(Status.INFO, "opened the nf id :" + number);
 * commonUtils.waitTime(6000); }
 * 
 * 
 * public void ProductTabFieldValidation(Map<String, String> testdata) throws
 * Exception { DAOTest daoTest = new DAOTest(); logger.log(Status.INFO,
 * "Validating the product tab field for Pa : " + testdata.get(PROCESS_NAME) +
 * " Ta : " + testdata.get("TA")); CNFScenarios.createNFWithPaTa(testdata);
 * commonUtils.waitTime(1000); readNFNumber = daoTest.readNFNumber();
 * daoTest.editorMenuSelect(testdata.get(MENU_TAB)); commonUtils.waitTime(3000);
 * List<String> readFiledNameFromXLSheet =
 * daoTest.readFiledNameFromXLSheet(testdata.get(FIELD_NAME),
 * PRODUCT_MANDITARY_FIELD); int size = readFiledNameFromXLSheet.size(); for
 * (int i = 0; i < size; i++) {
 * daoTest.ProductfieldValidationAndClick(testdata.get(MODE),
 * readFiledNameFromXLSheet.get(i),
 * testdata.get(readFiledNameFromXLSheet.get(i))); commonUtils.waitTime(1000); }
 * }
 * 
 * public void ProductFieldIdafieldCheck(Map<String, String> testdata) throws
 * Exception { DAOTest daoTest = new DAOTest(); NAPFLocators ls = new
 * NAPFLocators(); commonUtils.waitTime(2000);
 * daoTest.editorMenuSelect(testdata.get("menutab"));
 * commonUtils.waitTime(2000); List<String> readFiledNameFromXLSheet =
 * daoTest.readFiledNameFromXLSheet(testdata.get("Field Name"),
 * "ProductManditaryField"); int size = readFiledNameFromXLSheet.size(); for
 * (int i = 0; i < size; i++) {
 * daoTest.ProductfieldValidationAndClick(testdata.get("Mode"),
 * readFiledNameFromXLSheet.get(i),
 * testdata.get(readFiledNameFromXLSheet.get(i))); commonUtils.waitTime(2000); }
 * daoTest.saveButton(); commonUtils.waitTime(6000); WebElement
 * headersearchButton =commonUtils.expandRootElement(ls.headersearchButton);
 * commonUtils.waitTime(2000); commonUtils.click(headersearchButton);
 * commonUtils.waitTime(10000);
 * daoTest.ClickCheckboxAndPopulate(testdata.get("populate"));
 * commonUtils.waitTime(3000); daoTest.ClickIDAViewButton(); } public void
 * IDAResultsFieldsCheck(String menuTab) throws Exception { DAOTest daoTest =
 * new DAOTest(); String NFNumber=readNFNumber.replace("NF | ", "");
 * openNFInvestigation(NFNumber); commonUtils.waitTime(2000);
 * daoTest.editorMenuSelect(menuTab);
 * log.info("IDA-Results Fields Check and button Are checking Clickble Status");
 * logger.log(Status.INFO,
 * "IDA-Results Fields Check and button Are checking Clickble Status");
 * commonUtils.scrollintoView(); daoTest.IDAResultsfieldValidation();
 * commonUtils.waitTime(2000); commonUtils.scrollintoView();
 * daoTest.IDAResultHeaderValidation(); commonUtils.waitTime(2000);
 * commonUtils.scrollintoView(); daoTest.IDAResultViewanddeletevalidation();
 * commonUtils.waitTime(2000); }
 * 
 * public void IDAResultsFieldValidation(Map<String, String> testdata) throws
 * Exception { DAOTest daoTest = new DAOTest(); String
 * NFNumber=readNFNumber.replace("NF | ", ""); openNFInvestigation(NFNumber);
 * commonUtils.waitTime(3000);
 * daoTest.editorMenuSelect(testdata.get(MENU_TAB1));
 * commonUtils.waitTime(1000); commonUtils.scrollintoView();
 * daoTest.ClickIDAViewButton(); commonUtils.waitTime(4000); List<String>
 * readFiledNameFromXLSheet =
 * daoTest.readFiledNameFromXLSheet(testdata.get(FIELDS_NAME),
 * IDA_RESULTS_VIEW_FIELDS); List<String> IdaViewfieldValidation =
 * daoTest.IdaViewfieldValidation(testdata.get(HEADERS));
 * Collections.sort(readFiledNameFromXLSheet);
 * Collections.sort(IdaViewfieldValidation);
 * System.out.println(readFiledNameFromXLSheet.size());
 * System.out.println(readFiledNameFromXLSheet);
 * System.out.println(IdaViewfieldValidation.size());
 * System.out.println(IdaViewfieldValidation);
 * assertEquals(readFiledNameFromXLSheet, IdaViewfieldValidation,
 * "Both the repository and Webpage data field are not same in product tab"); }
 * 
 * public void ProductvalueIDAvalueCheck(Map<String, String> testdata) throws
 * Exception { DAOTest daoTest = new DAOTest(); commonUtils.waitTime(4000);
 * List<String> readFiledNameFromXLSheet =
 * daoTest.readFiledNameFromXLSheet(testdata.get("Fields NameIDA"),
 * "IDA-ResultsViewFields"); int size = readFiledNameFromXLSheet.size();
 * List<String> IDAViewValues=new ArrayList<String>(); for (int i = 0; i < size;
 * i++) { List<String> idaViewfieldGetValue =
 * daoTest.IdaViewfieldGetValue(readFiledNameFromXLSheet.get(i));
 * commonUtils.waitTime(1000); IDAViewValues.addAll(idaViewfieldGetValue); }
 * daoTest.editorMenuSelect(testdata.get("menuTab1"));
 * commonUtils.waitTime(2000); List<String> readFiledNameFromXLSheet1 =
 * daoTest.readFiledNameFromXLSheet(testdata.get("Fields NameProduct"),"Product"
 * ); int size1 = readFiledNameFromXLSheet1.size(); List<String>
 * PruductValues=new ArrayList<String>(); for (int i = 0; i < size1; i++) {
 * List<String> ProductGetvalue =
 * daoTest.ProductGetvalue(readFiledNameFromXLSheet1.get(i));
 * commonUtils.waitTime(1000); PruductValues.addAll(ProductGetvalue); }
 * System.out.println(IDAViewValues); System.out.println(PruductValues);
 * if(IDAViewValues.equals(PruductValues)) {
 * log.info("Both the repository and Webpage data field are same");
 * logger.log(Status.INFO,
 * "Both the repository and Webpage data field are same");
 * assertTrue(true,"Both the repository and Webpage data field are same"); }else
 * { log.
 * info("Both the repository and Webpage data field are not same in product tab"
 * ); logger.log(Status.INFO,
 * "Both the repository and Webpage data field are not same in product tab");
 * assertTrue(
 * false,"Both the repository and Webpage data field are not same in product tab"
 * ); } } }
 */
package ch.post.pf.nf.ta.pagefactory;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ch.post.pf.nf.ta.baseutils.Setup;

public class NAPFLocators extends Setup {

	public NAPFLocators() {
		PageFactory.initElements(driver, this);
	}

	public String headersearchButton = "return document.querySelector('pf-portal-header > pf-menu-item.hydrated.toolbar_portal.menu-entry-index-1')";

	public String groupQueueMoveDataUserInbox = "return document.querySelector('pf-dialog > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('#vaadin-text-field-input-4 > slot:nth-child(2) > input')";
	public String lastchange = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(18)')";
	@FindBy(tagName = "pf-portal-header")
	public WebElement headerProfileMenulist;

	public String headerProfileMenu = "return document.querySelector(\"body > app-root > app-navigation > pf-portal-header\").shadowRoot.querySelector(\"pf-header > div > pf-dropdown-menu > pf-menu-item.toolbar_portal.hydrated\")";

	@FindBy(xpath = "//pf-menu-item[@visual=\"menu_small\"]")
	public List<WebElement> profilemenuList;

	@FindBy(xpath = "//pf-menu-item[@slot='app-menu']")
	public List<WebElement> app_Menu_List;

	@FindBy(tagName = "pf-text-field")
	public WebElement open_NF_input;

	public String createInvestigation = "return document.querySelector('pf-portal-header > pf-menu-item').shadowRoot.querySelector('div.outer.leaf > a > slot > pf-icon').shadowRoot.querySelector('svg')";
	public String create_Inves_page = "return document.querySelector('pf-editor-page').shadowRoot.querySelector('div > div.main-container > pf-grid > pf-editor-header').shadowRoot.querySelector('pf-text')";

	public String PaInitiator = "return document.querySelector('pf-combobox[testselector=\"gentab.processorName\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String TaInitiator = "return document.querySelector('pf-combobox[testselector=\"gentab.ta\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String savecss = "return document.querySelector('pf-portal-header').shadowRoot.querySelector('pf-menu-item').shadowRoot.querySelector('pf-icon').shadowRoot.querySelector('svg')";

	public String SavePopupText = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-dialog:nth-child(2) > pf-text')";

	public String SavePopupClick = "return document.querySelector('pf-dialog:nth-child(2) > pf-button.hydrated.last-button.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String SavePopup = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-dialog:nth-child(2)').shadowRoot.querySelector('pf-fullscreen-container > pf-card')";

	public String NfNumber = "return document.querySelector('pf-editor-page').shadowRoot.querySelector('pf-editor-header').shadowRoot.querySelector('pf-text')";

	public String openNFclick = "return document.querySelector('pf-tile-card').shadowRoot.querySelector('pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String openNfText = "return document.querySelector('#openNfForm > pf-tile-card').shadowRoot.querySelector('pf-card').shadowRoot.querySelector('div.card-title-line > pf-text > span')";

	public String openNfButtontext = "return document.querySelector('#openNfForm > pf-tile-card').shadowRoot.querySelector('pf-card > pf-button').shadowRoot.querySelector('vaadin-button')";

	public String custom_field = "return document.querySelector('pf-custom-control').shadowRoot.querySelector('div.left-label-container > pf-text')";

 	public String custom_field_one = "return document.querySelectorAll('pf-custom-control')[";

 	public String custom_field_two = "].shadowRoot.querySelector(\"div.vertical-label-container\")";

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-text-area")
	public List<WebElement> textareaField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-checkbox")
	public List<WebElement> checkboxField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-text-field")
	public List<WebElement> textField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-combobox")
	public List<WebElement> comboboxField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-date-picker")
	public List<WebElement> datepicketField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-account-field")
	public List<WebElement> accountField;

	@FindBy(xpath = "(//pf-form-layout[@class=\"hydrated inside-grid\"])[1]/pf-pktnr-account-field")
	public List<WebElement> pf_pktnr_account_field;

	public String dateclosebutton = "return document.querySelector('#productTabForm > pf-grid > pf-form-layout > pf-text-field:nth-child(24)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	@FindBy(tagName = "pf-tile-card")
	public WebElement openNfButton;

	public String clouserReason = "return document.querySelector('pf-combobox[testselector=\"gentab.closureReason\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";
	
	public String clouserReasonToggle = "return document.querySelector('pf-combobox[testselector=\"gentab.closureReason\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#toggleButton')";

	public String productReason = "return document.querySelector('pf-combobox[testselector=\"gentab.productCode\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";
	
	public String productReasonToggle = "return document.querySelector('pf-combobox[testselector=\"gentab.productCode\"]').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#toggleButton')";

	public String editormenu = "return document.querySelector('pf-tabs').shadowRoot.querySelectorAll('pf-menu-item')";

	public String activityFieldValue = "return document.querySelector('app-note-tab > pf-grid > pf-section.col-md-8.hydrated.inside-grid > pf-table').shadowRoot.querySelector('vaadin-grid').shadowRoot.querySelector('#items > tr')";

	public String firstfield = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[0]";
	
	public String secondfield = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[1]";
	
	public String thirdfield = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[2]";
	
	public String fourthfield = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[3]";
	
	public String fifthfield = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[4]";

	public String notesadd = "return document.querySelector('pf-menu-item[test-selector=\"note-detail-add\"]').shadowRoot.querySelector('pf-icon').shadowRoot.querySelector('#Layer_1')";

	public String textarea = "return document.querySelectorAll('pf-text-area[test-selector=\"noteTextArea\"]')[1].shadowRoot.querySelector('vaadin-text-area').shadowRoot.querySelector('textarea')";

	public String NoteTexttable = "return document.querySelector('app-note-tab > pf-grid > pf-section.col-md-8.hydrated.inside-grid > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(27) > div')";

	@FindBy(xpath = "//pf-button[@test-selector='notes-add-edit-save-button']")
	public WebElement saveButton;

	public String editdeletebutton = "vaadin-grid-cell-content";

	public String notesEdit = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(8) > app-note-tab > pf-grid > pf-section.col-md-8.hydrated.inside-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[0]";

	public String notesDelete = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(8) > app-note-tab > pf-grid > pf-section.col-md-8.hydrated.inside-grid > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[1]";

	public String notesdeletepopup = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(8) > app-note-tab > pf-dialog:nth-child(4) > pf-text')";

	public String notesdeletepopupButton = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(8) > app-note-tab > pf-dialog:nth-child(4) > pf-button.hydrated.last-button.button-index-1')";
	
	public String AIGroupQueButton = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid > pf-button-row > pf-button')";
	
	public String AiGroupQueButrequired = "].shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String AISourceGroupQueue = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid > pf-button-row > pf-button')[0].shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String AIPreviousGroupQueue = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid > pf-button-row > pf-button')[1].shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String AIOtherGroupQueue = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid > pf-button-row > pf-button')[2].shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String SourceGroupQueue = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-user-inbox > pf-section > pf-button:nth-child(1)')";
	
	public String PreviousGroupQueue = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-user-inbox > pf-section > pf-button:nth-child(2)')";
	
	public String OtherGroupQueue = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-user-inbox > pf-section > pf-button:nth-child(3)')";

	@FindBy(xpath = "//pf-button[@testselector='editor-header-action--sourceGroupQueue']")
	public WebElement sourceGroupQueue;

	@FindBy(xpath = "//pf-button[@testselector='editor-header-action--previousGroupQueue']")
	public WebElement previousGroupQueue;

	@FindBy(xpath = "//pf-button[@testselector='editor-header-action--otherGroupQueue']")
	public WebElement otherGroupQueue;

	public String userInboxNfField = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')";

	public String landingPage_text = "return document.querySelector('pf-editor-header').shadowRoot.querySelector('pf-text')";
	
	public String nfidSort = "return document.querySelector('pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(13) > vaadin-grid-sorter')";
	
	public String NFIdSort = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[6]";
	
	public String FirstNf_number = "return document.querySelector('pf-table').shadowRoot.querySelectorAll(\"vaadin-grid-cell-content\")[";

	public String userinboxrowcount = "return document.querySelector('pf-table').shadowRoot.querySelector('vaadin-grid').shadowRoot.querySelectorAll('#items > tr')";

	public String AssaignInvesRowCount = "return document.querySelector('app-assign-investigation > pf-section > pf-table').shadowRoot.querySelector('vaadin-grid').shadowRoot.querySelectorAll('#items > tr')";

	public String duenametext = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[";

	public String somewhwreclick = "return document.querySelector('#productTabForm > pf-grid > pf-form-layout > pf-account-field:nth-child(18)').shadowRoot.querySelector('pf-text-field > pf-text')";

	public String all_NfNumber_search = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[";
	
	public String all_NfNumber_search_2 = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content> vaadin-checkbox')[";
	
	public String all_NfNumber_search_checkbox = "].shadowRoot.querySelector('label')";

	@FindBy(xpath = "//pf-masthead-item[@label='Erstell- Datum']/pf-text")
	public WebElement erstellDatum;

	@FindBy(xpath = "//pf-text-area[@test-selector=\"customerTextArea\"]")
	public WebElement customer_description;

	@FindBy(xpath = "//pf-menu-item[@test-selector='customer.mes.add']")
	public WebElement CreateMess;

	@FindBy(xpath = "//pf-menu-item[@test-selector='customer.detail-save']")
	public WebElement save_mess;

	public String checkboxmess_click = "return document.querySelector(\"pf-table\").shadowRoot.querySelector(\"vaadin-grid > vaadin-grid-cell-content:nth-child(25) > vaadin-checkbox\")";
	
	public String To_Do_Mess = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid-cell-content')[0]";

	public String todo_mess_saved = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid-cell-content')[2].querySelector('pf-text')";
	
	@FindBy(xpath = "//pf-section[@testselector='userInboxHeader']/pf-button")
	public List<WebElement> userInboxHeader;

	public String userInboxHeaders = "return document.querySelectorAll('#userProfileFrom > pf-editor-header > pf-button')[";

	public String groupQueueList = "return document.querySelector(\"pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid-cell-content\")";
	
	public String groupqueueselection = "return document.querySelector(\"pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid-cell-content\")[12]document.querySelector(\"pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid-cell-content\")[";
	
	public String groupque2 = "]";

	public String groupQueueMoveData = "document.querySelector('app-assign-investigation > pf-dialog > form > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	@FindBy(xpath = "//pf-button[@testselector=\"saveDialog\"]")
	public WebElement saveGroup;

	@FindBy(xpath = "//pf-text-field[@data-test-selector='onHoldReminder.period_for_first_reminder']")
	public WebElement periodcalederdays;

	@FindBy(xpath = "//pf-text-field[@testselector='onHoldReminder.period_for_onhold']")
	public WebElement periodcalederday;

	public String periodcalanderdayserrormess = "return document.querySelector('#onHoldRemForm > pf-grid > pf-form-layout > pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('div[part=error-message]')";

	public String MoreOption = "return document.querySelector('pf-search-panel').shadowRoot.querySelector('pf-button')";

	@FindBy(xpath = "//pf-button[@testselector='searchInv.reset']")
	public WebElement ResetButton;

	@FindBy(xpath = "//pf-button[@testselector='searchInv.search']")
	public WebElement SearchButton;

	public String LessOption = "return document.querySelector('pf-search-panel').shadowRoot.querySelector('div.search-parameter-container > div > pf-button')";

	public String SearchInvestigationLandingText = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-text')";

	public String SearchEditbutton = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > div > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-button-row > pf-button')";

	public String nfdatetotext = "return document.querySelector('pf-card > app-search-investigation > div > pf-search-panel > pf-custom-control:nth-child(7) > pf-date-picker.ng-pristine.ng-valid.full-width.hydrated.within-custom-control.ng-touched').shadowRoot.querySelector('vaadin-date-picker').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String ibutton = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-tooltip')[5]";

	@FindBy(xpath = "(//pf-search-panel[@testselector=\"inv-search-panel\"])/pf-combobox")
	public List<WebElement> allSearchcomboboxField;

	@FindBy(xpath = "(//pf-search-panel[@testselector=\"inv-search-panel\"])/pf-account-field")
	public List<WebElement> allSearchaccountField;

	@FindBy(xpath = "(//pf-search-panel[@testselector=\"inv-search-panel\"])/pf-checkbox")
	public List<WebElement> allSearchcheckboxField;

	@FindBy(xpath = "(//pf-search-panel[@testselector=\"inv-search-panel\"])/pf-text-field")
	public List<WebElement> allSearchpfTextField;

	@FindBy(xpath = "(//pf-search-panel[@testselector='inv-search-panel'])/pf-pktnr-account-field")
	public List<WebElement> pfpktnraccountfield;

	public String allSearchpfcustomcontrol = "(//pf-form-layout[@slot=\"additional-search-input\"])/pf-custom-control";

	public String processNameInput = "return document.querySelector('pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div[part=input-field] > slot:nth-child(2) > input')";

	@FindBy(xpath = "(//pf-custom-control[@testselector='searchInv.amount_range']/pf-text-field)[1]")
	public WebElement AmountRangeFrom;

	@FindBy(xpath = "(//pf-custom-control[@testselector='searchInv.amount_range']/pf-text-field)[2]")
	public WebElement AmountRangeTo;

	@FindBy(xpath = "//pf-date-picker[@testselector='searchInv.nf_date_range_from']")
	public WebElement NFdateRangeFrom;

	public String nfdatetext = "return document.querySelector('app-search-investigation > div > pf-search-panel > pf-custom-control:nth-child(7) > pf-date-picker').shadowRoot.querySelector('vaadin-date-picker').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	@FindBy(xpath = "//pf-date-picker[@testselector='searchInv.nf_date_range_to']")
	public WebElement NFdateRangeTo;

	@FindBy(xpath = "//pf-text-field[@testselector='searchInv.nf_id_range_from']")
	public WebElement NFIdRangeFrom;

	public String NFidRangeFrom1 = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-search-panel > pf-custom-control:nth-child(12) > pf-text-field.ng-pristine.ng-valid.hydrated.within-custom-control.ng-touched.hide-prefix\").shadowRoot.querySelector(\"vaadin-text-field\").shadowRoot.querySelector(\"div[part=input-field]> slot:nth-child(2) > input\")";

	@FindBy(xpath = "//pf-text-field[@testselector='searchInv.nf_id_range_to']")
	public WebElement NFIdRangeto;

	public String OutBICInput = "return document.querySelector(\"#frmBookRoom > pf-search-panel > pf-form-layout:nth-child(2) > pf-text-field.ng-pristine.ng-valid.hydrated.inside-grid.col-md-6.ng-touched.hide-prefix\").shadowRoot.querySelector(\"vaadin-text-field\").shadowRoot.querySelector(\"div[part=input-field] > slot:nth-child(2) > input\")";

	@FindBy(xpath = "//pf-account-field[@testselector='searchInv.post_account_own_search']")
	public WebElement MoneyReceiver;

	public String PopUPtab = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-status-dialog\").shadowRoot.querySelector(\"pf-dialog\").shadowRoot.querySelector(\"pf-fullscreen-container > pf-card\")";

	public String PopUptext = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-status-dialog\").shadowRoot.querySelector(\"pf-dialog > div > pf-grid > pf-text\")";

	public String CloseButton = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-status-dialog\").shadowRoot.querySelector(\"pf-dialog > pf-button\").shadowRoot.querySelector(\"vaadin-button\").shadowRoot.querySelector(\"#button\")";

	@FindBy(xpath = "(//pf-button-row[@slot='search-result']/pf-text)[1]")
	public WebElement searchResults;

	@FindBy(xpath = "(//pf-button-row[@slot='search-result']/pf-text)[2]")
	public WebElement NoOfResults;

	public String touserInbox = "return document.querySelector('pf-search-panel > pf-button-row:nth-child(33) > pf-button.hydrated.button-index-1')";
	public String unlockInverstigation = "return document.querySelector('pf-search-panel > pf-button-row:nth-child(33) > pf-button.hydrated.button-index-2')";

	@FindBy(xpath = "//*[@data-test-selector=\"moveNfToInboxId\"]")
	public WebElement toUserInbox;

	@FindBy(xpath = "//*[@data-test-selector=\"unleashNfId\"]")
	public WebElement UnlockInverstigation;

	public String State = "return document.querySelector('pf-card > app-search-investigation > pf-search-panel > pf-combobox:nth-child(2)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	@FindBy(xpath = "//pf-combobox[@testselector='searchInv.result_curr_search']")
	public WebElement Currency;

	public String TA = "return document.querySelector(\"#frmBookRoom > pf-search-panel > pf-form-layout:nth-child(2) > pf-combobox.ng-pristine.ng-valid.hydrated.inside-grid.col-md-6.ng-touched\").shadowRoot.querySelector(\"vaadin-combo-box\").shadowRoot.querySelector(\"#input\").shadowRoot.querySelector(\"#vaadin-text-field-input-480 > slot:nth-child(2) > input\")";

	public String searchTableData = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid-cell-content')";

	public String SearchTableDataSort = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > vaadin-grid-sorter')";

	@FindBy(xpath = "//pf-icon-button[@test-selector=\"searchInv.search\"]")
	public WebElement downloadclick;

	public String APBPopupTab = "return document.querySelector('body > app-root > app-navigation > pf-dialog').shadowRoot.querySelector('pf-fullscreen-container').shadowRoot.querySelector('div.content-container')";

	public String APBPopupheadtext = "return document.querySelector('pf-dialog').shadowRoot.querySelector('pf-card').shadowRoot.querySelector('div.card-title-line > pf-text')";

	@FindBy(xpath = "(//pf-text[@text-type='h5'])[1]")
	public WebElement APBPopupText;
	
	@FindBy(xpath = "(//pf-text[@text-type='h5'])[2]")
	public WebElement APBPopup2text;

	@FindBy(xpath = "//pf-link[@href-target='_self']")
	public WebElement GoToDab;

	@FindBy(xpath = "(//pf-button[@role='button'])[1]")
	public WebElement abbrechen;

	@FindBy(xpath = "(//pf-select[@test-selector='pf-select'])[3]")
	public WebElement SelectTRZAHLUNG;

	@FindBy(xpath = "(//pf-select[@test-selector='pf-select'])[4]")
	public WebElement SelectTRKARTEN;

	@FindBy(xpath = "(//pf-button[@role='button'])[4]")
	public WebElement AttachTransactionButton;

	@FindBy(xpath = "//pf-link[@class='hydrated']")
	public WebElement RequestStatus;

	public String IDA_Result = "return document.querySelector('pf-tabs').shadowRoot.querySelector('pf-menu-item.tabs_normal.hydrated.menu-entry-index-4')";

	@FindBy(xpath = "//form[@id='idaDetailsFrom']")
	public WebElement idaDetailsFromDropDown;

	@FindBy(xpath = "//pf-button[@testselector='populateProductFields']")
	public WebElement populateProductfield;

	@FindBy(xpath = "//pf-button[@testselector='getLinkedTransactions']")
	public WebElement getAllLinkedTrans;

	public String headerIDAResult = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > vaadin-grid-sorter')";

	public String IDAResultDatatable = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')";

	public String IDAResultTransacnumber = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[25]";

	public String IDAActionViewTrans = "return document.querySelector('app-ida-results-tab > pf-grid > app-ida-details > app-transaction-table > pf-grid > pf-section > pf-table').shadowRoot.querySelector('pf-icon-button[icon=eye]')";

	public String IDAActionDeleteTrans = "return document.querySelector('app-ida-results-tab > pf-grid > app-ida-details > app-transaction-table > pf-grid > pf-section > pf-table').shadowRoot.querySelector('pf-icon-button[icon=delete]')";

	public String IDAActionToolTip = "return document.querySelector('pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(40) > pf-tooltip')";

	public String IDACheckBoxTrans = "return document.querySelector('pf-tabs > pf-tab:nth-child(5) > app-ida-results-tab > pf-grid > app-ida-details > app-transaction-table > pf-grid > pf-section > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(33) > vaadin-checkbox')";

	public String IDAActionToolTipeDataField = "return document.querySelector('pf-tooltip-bubble > pf-masthead').shadowRoot.querySelectorAll('div > pf-text')";

	public String IDAActionToolTipDataValue = "return document.querySelectorAll('pf-portal > pf-tooltip-bubble > pf-masthead > pf-masthead-item > pf-text')";

	@FindBy(xpath = "//pf-button[@data-test-selector='editor-header-action--thirdPartyCheckback']")
	public WebElement createCheckboxbocThirdParty;

	public String initiateMemopopup = "return document.querySelector('pf-dialog:nth-child(8)').shadowRoot.querySelector('pf-fullscreen-container > pf-card')";

	@FindBy(xpath = "//pf-text[@text-type='h4']")
	public WebElement initiateMemopopupText;

	@FindBy(xpath = "//pf-button[@testselector='cancelMemoTypeSelectionDialog']")
	public WebElement cancelMemoTypeSelectionDialog;

	@FindBy(xpath = "//pf-button[@testselector='devaButton']")
	public WebElement devaButton;

	@FindBy(xpath = "//pf-button[@testselector='swiftButton']")
	public WebElement swiftButton;

	public String CountOfJobTable = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-section > pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid > vaadin-grid-cell-content\")";

	public String PopUpCountJob = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-status-dialog\").shadowRoot.querySelector(\"pf-dialog > div\")";

	@FindBy(xpath = "//pf-link[@testselector='breadcrumb1']")
	public WebElement headerotherCount;

	@FindBy(xpath = "//pf-button[@testselector='movetoInbox']")
	public WebElement headerotherCount1;

	@FindBy(xpath = "//pf-button[@testselector='movetoOtherGroupQueue']")
	public WebElement headerotherCount2;

	public String headerotherCount3 = "return document.querySelector('#userProfileFrom > pf-form-layout')";

	public String Popupcountheadname = "return document.querySelector('pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div > pf-text')";

	public String Groupqueueheader = "return document.querySelector('pf-card > app-group-queue-summary > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String GroupqueueSort = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[0]";

	public String Groupqueuestatus = "return document.querySelector(\"body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-group-queue-summary > pf-section > pf-table\").shadowRoot.querySelectorAll(\"vaadin-grid > vaadin-grid-cell-content > div\")[";
	
	public String fieldNumber = "]";

	public String Popupcount1text = "return document.querySelector('pf-card > app-group-queue-summary > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div > pf-grid > pf-text')";

	public String PopupCloseButton = "return document.querySelector('pf-card > app-group-queue-summary > pf-status-dialog').shadowRoot.querySelector('pf-dialog > pf-button')";

	public String AssignInvestigation = "return document.querySelector('app-assign-investigation > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String SelectUser = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-grid > form > pf-grid > pf-filter-bar > pf-combobox.col-4.ng-untouched.ng-pristine.ng-invalid.hydrated').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String STATE = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-grid > form > pf-grid > pf-filter-bar > pf-combobox:nth-child(2)').shadowRoot.querySelector('div > pf-text')";

	public String ALL = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-grid > form > pf-grid > pf-filter-bar > pf-combobox:nth-child(2)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input[role=combobox]')";

	public String AIPriorityText = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-grid > form > pf-grid > pf-filter-bar > pf-combobox:nth-child(3)').shadowRoot.querySelector('div > pf-text')";

	public String AIPriorityAllText = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid > form > pf-grid > pf-filter-bar > pf-combobox:nth-child(3)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String AINFID = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[2]";

	public String AIstate = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[3]";

	public String AIprcessName = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[4]";

	public String AITA = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[5]";

	public String AILastChange = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[6]";

	public String AIQueueName = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[7]";

	public String AIDeliveryChannel = "return document.querySelector('pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[8]";

	@FindBy(xpath = "//pf-table[@testselector='userInboxTable']")
	public WebElement pfTableGroupquee;

	public String ABPAutomaticSearchPopup = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-dialog:nth-child(11)').shadowRoot.querySelector('pf-fullscreen-container > pf-card')";

	public String AICheckBOX = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[33]";

	public String AIFirstNFID = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[35]";

	public String AIFirstViewButton = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelector('pf-toolbar')";

	public String AIActivietisRows = "return document.querySelector('#activitesForm > pf-grid > pf-table').shadowRoot.querySelector('vaadin-grid').shadowRoot.querySelectorAll('#items > tr')";

	public String ActivityQueueName = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content> div')[";

	public String AISourceGroup = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-grid:nth-child(2) > pf-button-row > pf-button.hydrated.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String AIIButton = "return document.querySelector('pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(54) > pf-tooltip').shadowRoot.querySelector('div > slot > pf-icon')";

	public String AttachmentTab = "return document.querySelector('pf-card > pf-tabs').shadowRoot.querySelector('div.menu-bar > pf-menu-container > pf-menu-item.tabs_normal.hydrated.menu-entry-index-2')";

	public String AttachmentDetails = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section:nth-child(1)').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String BLOBFileNameSort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(2)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[0]";

	public String AttachmentTypeSort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(2)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[1]";

	public String AttachmentSort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(2)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[2]";

	public String SIdetailsheader = "return document.querySelectorAll('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section')[1].shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String SIBLOBFileSort = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[1]";

	public String SIIDSort = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[2]";

	public String SITypeSort = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[3]";

	public String SICreationSort = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[4]";

	public String SICommentSort = "return document.querySelector('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[5]";

	public String AttachmentToNFButton = "return document.querySelector('pf-grid > pf-section:nth-child(3) > pf-button-row > pf-button')";

	public String DropAreaheader = "return document.querySelectorAll('pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section')[2].shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String SelectButtonInDrop = "return document.querySelector('pf-grid > pf-section:nth-child(5) > app-file-upload > pf-file-upload').shadowRoot.querySelector('vaadin-upload').shadowRoot.querySelector('#addButton').shadowRoot.querySelector('#button')";

	public String DropImage = "return document.querySelector('pf-grid > pf-section:nth-child(5) > app-file-upload > pf-file-upload').shadowRoot.querySelector('vaadin-upload').shadowRoot.querySelector('#dropLabelContainer')";

    public String toomanyMemosPopup = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div > pf-grid > pf-text')";

	public String toomanyMemosPopupClose = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-status-dialog').shadowRoot.querySelector('pf-dialog > pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String NoResultFullPopup = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-status-dialog').shadowRoot.querySelector('pf-dialog').shadowRoot.querySelector('pf-fullscreen-container > pf-card')";

	public String NoResultPopupText = "return document.querySelector('app-search-memos > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div > pf-grid > pf-text')";

	public String NoResultPopupClose = "return document.querySelector('app-search-memos > pf-status-dialog').shadowRoot.querySelector('pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String SearchMemosHeader = "return document.querySelector('pf-card > app-search-memos > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-text')";

	
	public String MemoType = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-combobox:nth-child(1)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";
	public String NFMemosIdfrom = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-custom-control:nth-child(2) > pf-text-field:nth-child(1)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String NFMemosIdto = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-custom-control:nth-child(2) > pf-text-field:nth-child(2)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String deleiveryChannelMemos = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-combobox:nth-child(5)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String MemoCreatedFromDate = "return document.querySelector('pf-card > app-search-memos > pf-search-panel > pf-custom-control:nth-child(3) > pf-date-picker:nth-child(1)').shadowRoot.querySelector('vaadin-date-picker').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String MemoCreatedToDate = "return document.querySelector('pf-card > app-search-memos > pf-search-panel > pf-custom-control:nth-child(3) > pf-date-picker:nth-child(2)').shadowRoot.querySelector('vaadin-date-picker').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String StatusOfMemos = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-combobox:nth-child(4)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String MemoPageHederText = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-text')";

	public String MemoSearchButton = "return document.querySelector('pf-grid > pf-card > app-search-memos > pf-search-panel > pf-button.hydrated.last-button.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	@FindBy(xpath = "//pf-menu-container[@visual=\"menu_small\"]/pf-menu-item")
	public List<WebElement> memosearchlistContentCount;

	@FindBy(xpath = "(//pf-menu-item[@kind='ACTION'])[8]")
	public WebElement memoOverViewFirstBox;

	public String headermemosafterSearch = "return document.querySelector('pf-card > app-search-memos > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-text')";

	public String memosEditbutton = "return document.querySelector('pf-card > app-search-memos > pf-search-panel').shadowRoot.querySelector('div.search-title-line > pf-button-row > pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String memoidnum = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(6) > app-memo-tab > pf-grid:nth-child(1) > pf-section:nth-child(1) > app-tree-custom > pf-menu-container > pf-menu-item')";

	public String memoDetail = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-section.col-5.inside-grid.hydrated > pf-form-layout > pf-text-field')";
	
	public String memoDetailTab = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-section.col-5.inside-grid.hydrated > pf-form-layout > pf-text-field')[";
	
	public String memoDetailTab2 = "].shadowRoot.querySelector('div')";

	public String editermemoDetail = "return document.querySelectorAll('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(6) > app-memo-tab > pf-grid:nth-child(1) > pf-section:nth-child(2) > pf-grid > pf-form-layout > pf-text-field')";

	public String memoOverViewheader = "return document.querySelector('pf-card > app-search-memos > pf-search-panel > pf-section.col-7.inside-grid.hydrated').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String memoDetailheader = "return document.querySelector('pf-card > app-search-memos > pf-search-panel > pf-section.col-5.inside-grid.hydrated').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String DeleveryChennalInput = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-combobox:nth-child(5)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div[part=input-field]')";

	public String editermemoOverViewheader = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(6) > app-memo-tab > pf-grid:nth-child(1) > pf-section:nth-child(1)').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String editermemodetailsheader = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(6) > app-memo-tab > pf-grid:nth-child(1) > pf-section:nth-child(2)').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String PartnerAdrssheader = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-grid > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	@FindBy(xpath = "//pf-button[@testselector='createPADetails']")
	public WebElement CreatPADetail;

	@FindBy(xpath = "//pf-button[@testselector='isyPartnerSearch']")
	public WebElement ISYPartnerSearch;

	@FindBy(xpath = "//pf-button[@testselector='pedaPartnerSearch']")
	public WebElement PEDAPartnerSearch;

	public String PaPartnerTypesort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[0]";

	public String PaSourceTypeSort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[1]";

	public String PaAddress1sort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[2]";

	public String PaAddress2Sort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[3]";

	public String PaAddress3Sort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[4]";

	public String PaAddress4Sort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[5]";

	public String PaAddress5Sort = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[6]";

	public String PopupPartnerheader = "return document.querySelector('pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(3)').shadowRoot.querySelector('pf-card').shadowRoot.querySelector('pf-text')";

	public String PopupPartnerType = "return document.querySelector(\"#createPAForm > pf-form-layout > pf-combobox.col-md-6.ng-untouched.ng-pristine.ng-invalid.hydrated\").shadowRoot.querySelector(\"div\")";

	public String PartnerTypeInput = "return document.querySelector(\"#createPAForm > pf-form-layout > pf-combobox.col-md-6.ng-untouched.ng-pristine.ng-invalid.hydrated\").shadowRoot.querySelector(\"vaadin-combo-box\").shadowRoot.querySelector(\"#input\").shadowRoot.querySelector(\"div[part='input-field']\")";

	public String PartnerTypeSearch = "return document.querySelector('#createPAForm > pf-form-layout > pf-combobox.col-md-6.hydrated.ng-touched.ng-dirty.ng-valid').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#dropdown').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#content').shadowRoot.querySelectorAll('#selector > vaadin-combo-box-item')";

	public String PopupSourceType = "return document.querySelector('pf-combobox:nth-child(2)').shadowRoot.querySelector('div > pf-text')";

	public String PopupAddress1 = "return document.querySelector('pf-form-layout > pf-text-area').shadowRoot.querySelector('div > pf-text')";

	public String Address1Input = "return document.querySelector('#createPAForm > pf-form-layout > pf-text-area').shadowRoot.querySelector('vaadin-text-area').shadowRoot.querySelector('div')";

	public String OnlineCreateCheck = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')[1]";

	@FindBy(xpath = "//pf-button[@test-selector='pa.save']")
	public WebElement popupsavebutton;

	@FindBy(xpath = "//pf-button[@test-selector='isy.search']")
	public WebElement PopUpSAVEButton;

	@FindBy(xpath = "//pf-button[@test-selector='pa.reset']")
	public WebElement PopUpRESETButton;

	public String PopUpCANCELButton = "return document.querySelector('pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(3) > pf-button.pull-right.hydrated.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String OnlineText = "return document.querySelector(\"#createPAForm > pf-form-layout > pf-combobox.col-md-6.ng-untouched.ng-pristine.hydrated\").shadowRoot.querySelector(\"div.value\")";

	@FindBy(xpath = "//pf-button[@test-selector='isy.reset']")
	public WebElement PopUpISYRESETButton;

	@FindBy(xpath = "//pf-button[@test-selector='isy.search']")
	public WebElement PopUpISYSearchButton;

	public String PopUpISYheader = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(4) > pf-grid > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String ISYPartnerType = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-combobox:nth-child(1)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div')";

	public String ISYPartnerKeyInput = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String ISYPartnerInputSearch = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-combobox:nth-child(1)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#dropdown').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#content').shadowRoot.querySelectorAll('#selector > vaadin-combo-box-item')";

	public String ISYISOCountry = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-combobox:nth-child(3)').shadowRoot.querySelector('div > pf-text')";

	public String ISYISOCountryInput = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-combobox:nth-child(3)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String ISYISOCountrySearch = "return document.querySelector('#isySearchCriteriaPanel > pf-form-layout > pf-combobox:nth-child(3)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#dropdown').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#content').shadowRoot.querySelectorAll('#selector > vaadin-combo-box-item')";

	public String Isypartnertype = "return document.querySelector('#isySearchResult > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('div > pf-text')";

	public String Isypartnertypeinput = "return document.querySelector('#isySearchResult > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div')";

	@FindBy(xpath = "//pf-button[@test-selector='pa-save-button-isy']")
	public WebElement Isysavebutton;

	public String ISYCreatecheckValidation = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')[8]";

	public String PEDAResetButton = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(5) > pf-button.hydrated.first-button.button-index-0')";

	@FindBy(xpath = "//pf-button[@test-selector='peda.save']")
	public WebElement PEDASearchButton;

	public String PEDAPopPupheader = "return document.querySelector('pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(5) > pf-grid > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String PEDALocalCode = "return document.querySelector('#createPedaForm > pf-form-layout > pf-text-field').shadowRoot.querySelector('div > pf-text')";

	public String PEDAPartnerType = "return document.querySelector('#paPedaForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('div > pf-text')";

	public String PEDApartnerTypeInput = "return document.querySelector('#paPedaForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String PEDASaveButton = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(5) > pf-button:nth-child(4)')";

	public String PEDALocalCodeInput = "return document.querySelector('#createPedaForm > pf-form-layout > pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String PDEACreateCheck = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')[15]";

	public String PASourceType = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[1]";

	public String ISYSourceType = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[8]";

	public String PEDASourceType = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[15]";

	public String SourceTypeStatus = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')[1]";

	public String sourcetypeStatusList = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')";

	public String PartnerTypeStatus = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelector('div')";

	public String PEDAPartnerTypeStatus = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('div')[14]";

	public String PAEditButton = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[0]";

	public String PEDAEditButton = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[6]";

	public String PAEditPARTNERTYPE = "return document.querySelector('#onlineTypeForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('div > pf-text')";

	public String PEDAEditPartnerType = "return document.querySelector('#paPedaForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('div > pf-text')";

	public String PAEditPARTNERTYPEINPUT = "return document.querySelector('#onlineTypeForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div')";

	public String PEDAEditPartnerTypeINPUT = "return document.querySelector('#paPedaForm > pf-grid > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('div')";

	@FindBy(xpath = "//pf-button[@test-selector='pa-save-button-pa']")
	public WebElement PAEditPARTNERINPUTSEARCH;

	@FindBy(xpath = "//pf-button[@test-selector='pa-save-button-pa']")
	public WebElement PAEditPARTNERSAVEButton;

	public String TickButton = "return document.querySelector('pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item.hydrated.last-menu-entry.menu-entry-index-2.toolbar_small').shadowRoot.querySelector('div.outer.leaf > a > slot > pf-icon').shadowRoot.querySelector('#Layer_1')";

	public String DELETEButtonPA = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[1]";

	public String DELETEButtonISY = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[1]";

	public String DELETEButtonPEDA = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[1]";

	public String DELETEPopup = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(9) > pf-text')";

	public String DELETEPopupClose = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(9) >[color=primary]')";

	public String ISYVIEWButton = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-toolbar > pf-menu-item')[3]";

	public String isyPartnerType = "return document.querySelectorAll('#isyTabForm > pf-grid > pf-form-layout > pf-text-field')[0].shadowRoot.querySelector('div.left-label-container > pf-text')";

	public String isyViewCloseButton = "return document.querySelector('pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-dialog:nth-child(6) > pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String AccForFeesINProduct = "return document.querySelector('pf-account-field.inside-grid.hydrated.col-md-6.ng-dirty.ng-touched.ng-invalid').shadowRoot.querySelector('pf-text-field').shadowRoot.querySelector('div > pf-text')";

	public String AccForFeesInput = "return document.querySelector('pf-account-field.inside-grid.hydrated.col-md-6.ng-dirty.ng-touched.ng-invalid').shadowRoot.querySelector('pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('#vaadin-text-field-input-99 > slot:nth-child(2) > input')";

	public String postalAccMoney = "return  document.querySelector('pf-account-field.ng-pristine.ng-invalid.inside-grid.hydrated.col-md-6.ng-touched').shadowRoot.querySelector('pf-text-field').shadowRoot.querySelector('div > pf-text')";

	public String postalAccMoneyInput = "return document.querySelector('pf-account-field.ng-pristine.ng-invalid.inside-grid.hydrated.col-md-6.ng-touched').shadowRoot.querySelector('pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('#vaadin-text-field-input-100 > slot:nth-child(2) > input')";

	public String SomeoneClick = "return document.querySelector('pf-text-field.ng-pristine.ng-valid.hydrated.inside-grid.col-md-6.ng-touched.hide-prefix').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('#vaadin-text-field-input-73 > slot:nth-child(2) > input')";

	@FindBy(xpath = "//pf-group-title[@text-type=\"h2\"]")
	public WebElement Createcheckbackthirdpartyheader;

	public String transactionNumber = "return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[22]";

	public String transactionCheckBox = "return document.querySelector('pf-grid > div > app-step-holder:nth-child(3) > pf-section > app-trstep-swift > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(29) > vaadin-checkbox')";

	@FindBy(xpath = "(//pf-button[@test-selector='bicfield-btn-action-cancel'])[2]")
	public WebElement CancelInformationButton;

	public String OutBICtext = "return document.querySelector('#bicFieldForm > pf-form-layout > pf-text-field').shadowRoot.querySelector('div > pf-text')";

	public String OutBICInputBox = "return document.querySelector('#bicFieldForm > pf-form-layout > pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('#vaadin-text-field-input-74 > slot:nth-child(2) > input')";

	public String errorMesscheckoutBIC = "return document.querySelector(\"#bicFieldForm > pf-form-layout > pf-text-field\").shadowRoot.querySelector(\"vaadin-text-field\").shadowRoot.querySelector(\"div[part=error-message]\")";

	public String ChannelInformationStatus = "return document.querySelector('pf-grid > div > app-step-holder:nth-child(5) > pf-section > app-bicstep > pf-grid > div > pf-button-row > pf-status-chip')";

	public String IDAOverridecheckBox = "return document.querySelector('#bicFieldForm > pf-form-layout > pf-checkbox').shadowRoot.querySelector('vaadin-checkbox')";

	@FindBy(xpath = "//pf-button[@testselector='letter-cancel-button']")
	public WebElement CancelLetterButton;

	@FindBy(xpath = "//pf-button[@testselector='letter-preview-button']")
	public WebElement PreviewLetterButton;

	public String TransactionResultheader = "return document.querySelector('pf-tabs > pf-tab:nth-child(10) > app-letter-creation-tab > pf-grid > div > app-step-holder:nth-child(3) > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String BankIdentificationheader = "return document.querySelector('pf-grid > div > app-step-holder:nth-child(5) > pf-section').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String OutputDeleveryChennal = "return document.querySelectorAll('#channelTemplateDeva > pf-form-layout > pf-combobox')[0].shadowRoot.querySelector('div > pf-text')";

	public String OutputTemplateId = "return document.querySelectorAll('#channelTemplateDeva > pf-form-layout > pf-combobox')[1].shadowRoot.querySelector('div > pf-text')";

	public String OutputSubTemplateId = "return document.querySelectorAll('#channelTemplateDeva > pf-form-layout > pf-combobox')[2].shadowRoot.querySelector('div > pf-text')";

	public String OutputContactPersion = "return document.querySelector('#channelTemplateDeva > pf-form-layout > pf-text-field').shadowRoot.querySelector('div.left-label-container > pf-text')";

	public String NfIDMessCreate = "return document.querySelector('pf-card > app-search-investigation > pf-search-panel > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(46)')";

	public String NfCheckBoxmess = "return document.querySelector('pf-card > app-search-investigation > pf-search-panel > pf-table').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(45) > vaadin-checkbox')";

	@FindBy(xpath = "//pf-button[@testselector='moveNfToInboxId']")
	public WebElement MovetouserInboxButton;

	public String MovetouserInbox = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-investigation > pf-search-panel > pf-button-row:nth-child(33) > pf-button.hydrated.button-index-1')";

	public String movetounlock = "return document.querySelector('pf-card > app-search-investigation > pf-search-panel > pf-button-row:nth-child(33) > pf-button.hydrated.button-index-2')";

	@FindBy(xpath = "(//pf-form-layout[@class='hydrated inside-grid'])[1]/pf-account-field")
	public List<WebElement> IBANCheckProdcutTab;

	public String IbanFieldHeader = "return document.querySelectorAll(\"#productTabForm > pf-grid > pf-form-layout > pf-account-field\")[";
	public String IbanFieldHeader2 = "].shadowRoot.querySelector(\"pf-text-field\").shadowRoot.querySelector(\"div > pf-text\")";

	public String IbanFieldInput = "return document.querySelectorAll('#productTabForm > pf-grid > pf-form-layout > pf-account-field')[";
	public String IbanFieldInput1 = "].shadowRoot.querySelector('pf-text-field').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('div > slot:nth-child(2) > input')";

	public String IBANCheck = "return document.querySelectorAll('#productTabForm > pf-grid > pf-form-layout > pf-account-field')[";
	public String IBANCheck1 = "].shadowRoot.querySelector('pf-text-field > pf-text')";

	public String SomewhreClick = "return document.querySelector('#productTabForm > pf-grid > pf-form-layout > pf-text-field:nth-child(8)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String SomeehreClick1 = "return document.querySelector('#productTabForm > pf-grid > pf-form-layout > pf-pktnr-account-field').shadowRoot.querySelector('pf-text-field > pf-status-chip')";

	public String appmenuname = "return document.querySelectorAll('body > app-root > app-navigation > app-editor > pf-editor-page > pf-button')";
	
	public String appmenuname1 = "]";

	public String ThreeDotButton = "return document.querySelector('pf-editor-page').shadowRoot.querySelector('div > div.main-container > pf-grid > pf-editor-header').shadowRoot.querySelector('pf-button-row > pf-dropdown-menu').shadowRoot.querySelector('slot > pf-icon-button')";

	@FindBy(xpath = "(//pf-editor-page[@testselector='editor-page'])/pf-menu-item")
	public List<WebElement> ThreeDotHiddenName;

	public String investigationArrowButton = "return document.querySelector('app-editor > pf-editor-page > pf-side-drawer').shadowRoot.querySelector('pf-card > div > div.card-micro-toolbar.at-top.at-right > div.toggle-outer > slot > pf-icon').shadowRoot.querySelector('#Layer_1')";

	public String AttachmentOtlineheader = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-side-drawer > pf-text')";

	@FindBy(xpath = "//pf-menu-item[@kind='ACTION']")
	public List<WebElement> Attachmenttable;

	public String uploadfileButton = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section:nth-child(5) > app-file-upload > pf-file-upload').shadowRoot.querySelector('vaadin-upload').shadowRoot.querySelector('#addButton').shadowRoot.querySelector('#button')";

	public String choosefile = "return document.querySelector(\"body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section:nth-child(5) > app-file-upload > pf-file-upload\").shadowRoot.querySelector(\"vaadin-upload\").shadowRoot.querySelector(\"#fileInput\").removeAttribute('hidden')";

	public String Sendfile = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-section:nth-child(5) > app-file-upload > pf-file-upload').shadowRoot.querySelector('vaadin-upload').shadowRoot.querySelector('#fileInput')";

	public String invalidformentFilepopup = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div')";

	public String invalidFormatpoupclose = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-status-dialog').shadowRoot.querySelector('pf-dialog > pf-button').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String validformatpopup = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-dialog:nth-child(3)').shadowRoot.querySelector('pf-fullscreen-container > pf-card').shadowRoot.querySelector('div.card-title-line > pf-text')";

	public String validfileuploadbutton = "return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-dialog:nth-child(3) > pf-button.hydrated.last-button.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	public String checkuploadfilename = "return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(3) > app-attachment-tab > pf-grid > pf-table:nth-child(4)').shadowRoot.querySelector('vaadin-grid > vaadin-grid-cell-content:nth-child(26) > div')";

	@FindBy(xpath = "//pf-text-field[@testselector='upload.blob_file_nam']")
	public WebElement uploadfilename;

	@FindBy(xpath = "//pf-text-field[@testselector='gentab.result_ort']")
	public WebElement LocalCodeInput;

	public String LocalCodeHeader = "return document.querySelector('#editorForm > pf-grid > pf-form-layout > pf-text-field.ng-pristine.ng-valid.hide-prefix.hydrated.inside-grid.col-md-6.ng-touched').shadowRoot.querySelector('div > pf-text')";

	public String LocalCodeerrorText = "return document.querySelector('#editorForm > pf-grid > pf-form-layout > pf-text-field.hydrated.inside-grid.col-md-6.ng-touched.ng-dirty.ng-invalid').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('div[part=error-message]')";

	public String StateFilterCheck = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')";

	public String StateFilterCheck1 = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > div')[ ";

	public String StateFilterCheck2 = "]";

	public String PriorityFilterCheck = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-tooltip > pf-status-chip')";

	public String PriorityFilterCheck1 = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content > pf-tooltip > pf-status-chip')[";

	public String PriorityFilterCheck2 = "].shadowRoot.querySelector('div > slot')";

	public String profilemanagement = "return document.querySelector('body > div > pf-portal > pf-dropdown-menu-bubble > pf-menu-item.hydrated.menu_small.menu-entry-index-4').shadowRoot.querySelector('div.outer.leaf > a > div')";

	@FindBy(xpath = "(//pf-section[@class='col-md-8 hydrated'])/pf-combobox")
	public List<WebElement> allUserProfileField;

	@FindBy(xpath = "(//pf-section[@class='col-md-8 hydrated'])/pf-text-field")
	public List<WebElement> AllUserDefinitionField;

	@FindBy(xpath = "(//pf-section[@class='col-md-4 hydrated'])/pf-text-field")
	public List<WebElement> AllDepartmentField;

	@FindBy(xpath = "//pf-combobox[@testselector='userProfile.profileList']")
	public WebElement UserProfileField;

	@FindBy(xpath = "//pf-checkbox[@class='ng-untouched ng-pristine ng-valid hydrated']")
	public List<WebElement> AllCheckBoxField;

	public String ProfileADDButton = "return document.querySelector('#userProfileFrom > pf-form-layout > pf-icon-button')";

	public String pfcustomcontrolMemos1 = "return document.querySelectorAll('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-search-memos > pf-search-panel > pf-custom-control')[";
	public String pfcustomcontrolMemos2 = "].shadowRoot.querySelector('div > div.vertical-label-container')";

	@FindBy(xpath = "(//pf-search-panel[@testselector='memo-search-panel'])/pf-combobox")
	public List<WebElement> pfcomboBoxFieldmemos;

	@FindBy(xpath = "(//pf-search-panel[@class='ng-valid hydrated ng-touched ng-dirty'])/pf-custom-control")
	public List<WebElement> pfcustomcontrolFieldmemos;

	@FindBy(xpath = "(//pf-search-panel[@testselector='memo-search-panel'])/pf-text-field")
	public WebElement pftextFieldmemos;

	public String ProNameInput = "return document.querySelector('#userProfileFrom > pf-section:nth-child(2) > pf-text-field:nth-child(2)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String UserFirstnameinput = "return document.querySelector('#userProfileFrom > pf-section:nth-child(2) > pf-text-field:nth-child(3)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String UserlastNameinput = "return document.querySelector('#userProfileFrom > pf-section:nth-child(2) > pf-text-field:nth-child(4)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String Printerinput = "return document.querySelector('#userProfileFrom > pf-section:nth-child(2) > pf-text-field:nth-child(7)').shadowRoot.querySelector('vaadin-text-field').shadowRoot.querySelector('input')";

	public String UserProfileDetailHeader = "return document.querySelector('#userProfileFrom > pf-section:nth-child(3)').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String Workgroupinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[0].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String prosnameinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[1].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String UPTAinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[2].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String Queuenameinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[3].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String Deleverychanneelinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[4].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String TemplateIDinput = "return document.querySelectorAll('#userProfileFrom > pf-section:nth-child(3) > pf-combobox')[5].shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String UserProfileDetailsHeader = "return document.querySelector('#userProfileFrom > pf-section:nth-child(3)').shadowRoot.querySelector('div.title-line.normal > pf-text')";

	public String DropDownButton = "return document.querySelector('body > div > pf-portal > pf-dropdown-menu-bubble > pf-menu-item.hydrated.menu_small.menu-entry-index-5').shadowRoot.querySelector('div.outer > div > pf-icon')";

	@FindBy(xpath = "//pf-menu-item[@class='menu_normal hydrated']")
	public List<WebElement> UserProfileList;

	public String UserProfileList1 = "return document.querySelectorAll('body > div > pf-portal > pf-dropdown-menu-bubble > pf-menu-item.hydrated.menu_small.menu-entry-index-5 > pf-menu-item')";

	public String MaxprofilePopup = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div')";

	public String MaxprofilePopupClose = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-status-dialog').shadowRoot.querySelector('pf-dialog > pf-button')";

	// Close Function

	public String ProfileCloseButton = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-button.hydrated.button-index-1')";

	public String ProfileClosePopup = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-dialog:nth-child(8)').shadowRoot.querySelector('pf-fullscreen-container > pf-card > div > div')";

	public String ProfileClosePopupClose = "return document.querySelector('pf-dialog > pf-dialog:nth-child(8) > pf-button.hydrated.last-button.button-index-1').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";

	// delete fuction

	public String ProfileDeletePopup = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-dialog:nth-child(9) > pf-text')";

	public String ProfileDeletePopupDelete = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-dialog:nth-child(9) > pf-button.hydrated.last-button.button-index-1')";

	public String ProfileDeleteButton = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-button.hydrated.first-button.button-index-0')";

	// Save fuction

	public String ProfileSaveButton = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog > pf-button.hydrated.last-button.button-index-2')";

	public String UserProfileInput = "return document.querySelector('#userProfileFrom > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String EditButtonProManagment = "return document.querySelector('#userProfileFrom > pf-section:nth-child(2)').shadowRoot.querySelector('div.title-line.normal > div > pf-toggle').shadowRoot.querySelector('label > span.switch__toggle')";

	public String PopupScroll = "return document.querySelector('body > app-root > app-navigation > app-user-profile > pf-dialog').shadowRoot.querySelector('pf-fullscreen-container > pf-card > div > div')";

	@FindBy(xpath = "//pf-text-field[@test-selector='userprofile.user_first_name']")
	public WebElement FisrtUserName;

	@FindBy(xpath = "//pf-text-field[@test-selector='userProfile.user_last_name']")
	public WebElement lastUsername;

	public String toggleworkGroup = "return document.querySelector('#userProfileFrom > pf-section:nth-child(3) > pf-combobox:nth-child(1)').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#toggleButton')";

	public String valueINWorkGroup = "return document.querySelector('#userProfileFrom > pf-section:nth-child(3) > pf-combobox.ng-pristine.hydrated.ng-invalid.ng-touched').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#dropdown').shadowRoot.querySelector('#overlay').shadowRoot.querySelector('#content').shadowRoot.querySelectorAll('#selector > vaadin-combo-box-item')";

	public String WorkGroupINPUT = "return document.querySelector('#userProfileFrom > pf-section:nth-child(3) > pf-combobox.hydrated.ng-dirty.ng-valid.ng-touched').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";

	public String SwichwindowerrorText = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-status-dialog').shadowRoot.querySelector('pf-dialog > div')";

	public String SwichwindowPOPupclose = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-status-dialog').shadowRoot.querySelector('pf-dialog > pf-button')";

	public String SwichwindowError = "return document.querySelector('body > app-root > app-navigation > pf-page-container > pf-grid > pf-card > app-assign-investigation > pf-status-dialog').shadowRoot.querySelector('pf-dialog').shadowRoot.querySelector('pf-fullscreen-container > pf-card > div')";
	
	//IDA
	
	public String checkBoxIDA="return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(5) > app-ida-results-tab > pf-grid > app-ida-details > app-transaction-table > pf-grid > pf-section > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content> vaadin-checkbox')[1]";
	
	public String StandedInputField="return document.querySelector('#idaDetailsFrom > pf-form-layout > pf-combobox').shadowRoot.querySelector('vaadin-combo-box').shadowRoot.querySelector('#input').shadowRoot.querySelector('input')";
	
	public String populatebutton="return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-card > pf-tabs > pf-tab:nth-child(5) > app-ida-results-tab > pf-grid > app-ida-details > pf-section > pf-button:nth-child(2)').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";
	
	//IDA ALL VAlIDATION
	
	public String Activitesusername="return document.querySelector('pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[";
	
	public String partnertypenames="return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(7) > app-partner-address-tab > pf-table').shadowRoot.querySelectorAll('vaadin-grid > vaadin-grid-cell-content')[";
	
	public String CreateCheckpartybutton="return document.querySelector('body > app-root > app-navigation > app-editor > pf-editor-page > pf-button:nth-child(2)').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";
	
	public String letterbuttonpopup="return document.querySelector('app-editor > pf-dialog:nth-child(9) > pf-grid > pf-button:nth-child(1)').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";
	
	public String MTCAMTbuttonpopup="return document.querySelector('app-editor > pf-dialog:nth-child(9) > pf-grid > pf-button:nth-child(2)').shadowRoot.querySelector('vaadin-button').shadowRoot.querySelector('#button')";
	
	public String NFTransIDNumber="return document.querySelector('pf-card > pf-tabs > pf-tab:nth-child(5) > app-ida-results-tab > pf-grid > app-ida-details > app-transaction-table > pf-grid > pf-section > pf-table').shadowRoot.querySelector('div')";
	
	
}

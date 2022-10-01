package ch.post.pf.nf.ta.scenarios;
import java.util.Map;
import org.slf4j.Logger;
import ch.post.pf.nf.ta.baseutils.CommonUtils;
import ch.post.pf.nf.ta.baseutils.Log4jUtil;
import ch.post.pf.nf.ta.baseutils.Setup;
import ch.post.pf.nf.ta.dao.DAOTest;

public class ActivitiesScenario extends Setup {

	Logger log = Log4jUtil.loadLogger(ActivitiesScenario.class);
	CommonUtils commonUtils = new CommonUtils();
	/*
	 * Verify the activities tab data is present .
	 * 
	 */
	public void activitiesTab(Map<String, String> testdata) throws Exception {
		DAOTest daoTest = new DAOTest();
		commonUtils.waitTime(4000);
		daoTest.editorMenuSelect(testdata.get(MENU_TAB));
		Map<String, String> activityTableData = daoTest.ActivityTableData();
		log.info("Recent Activity table data" + activityTableData);
	}

}

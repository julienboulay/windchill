package fr.ekito.windchill.part.service;

import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.pds.StatementSpec;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.services.StandardManager;
import wt.util.WTException;

public class StandardPartQueryService extends StandardManager implements
		PartQueryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static StandardPartQueryService newStandardPartQueryService()
			throws WTException {
		StandardPartQueryService instance = new StandardPartQueryService();
		instance.initialize();
		return instance;
	}

	@Override
	public QueryResult findByNumber(String partNumber) throws WTException {
		QueryResult qr = null;

		QuerySpec qs = new QuerySpec();

		qs.appendClassList(WTPart.class, true);

		qs.appendWhere(new SearchCondition(WTPart.class, WTPart.NUMBER,
				SearchCondition.LIKE, partNumber), new int[0]);
		qr = PersistenceHelper.manager.find((StatementSpec) qs);

		return qr;
	}

}

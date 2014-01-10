package fr.ekito.windchill.part.service;

import wt.fc.QueryResult;
import wt.method.RemoteAccess;
import wt.services.ServiceFactory;
import wt.util.WTException;

public final class PartQueryHelper implements RemoteAccess{

	public static final PartQueryService service;
	
		public static QueryResult findByNumber(String partNumber) throws WTException
		{
			return service.findByNumber(partNumber);

		}
		
		static {
			service = (PartQueryService) ServiceFactory
					.getService(PartQueryService.class);
		}
}

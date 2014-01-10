package fr.ekito.windchill.part.service;

import wt.fc.ObjectIdentifier;
import wt.fc.QueryResult;
import wt.method.RemoteInterface;
import wt.util.WTException;

@RemoteInterface
public interface PartQueryService {
	
	public QueryResult findByNumber(String partNumber) throws WTException;
	
}

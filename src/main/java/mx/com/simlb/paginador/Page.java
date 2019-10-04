package mx.com.simlb.paginador;


import java.util.List;

import com.mx.simlb.dto.Reservaciones;

import mx.com.simlb.utils.Bootstrap;
import mx.com.simlb.utils.PagerRender;
import mx.com.simlb.utils.Standard;


public abstract class Page {
	
	final private String defaultAdapter = "Standard";
	
	public List<Object> results;

	private int page;

	private int resultsPerPage;

	private int totalCount;

	private String queryString;
	
	public List<Reservaciones> reservaciones;

	

	public List<Object> getResults() {
		return results;
	}

	public void setResults(List<Object> results) {
		this.results = results;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	public PagerRender getRender() {
		return getRender(defaultAdapter);
	}

	
	/**
	 * @return the reservaciones
	 */
	public List<Reservaciones> getReservaciones() {
		return reservaciones;
	}

	/**
	 * @param reservaciones the reservaciones to set
	 */
	public void setReservaciones(List<Reservaciones> reservaciones) {
		this.reservaciones = reservaciones;
	}
	
	public PagerRender getRender(String adapterName) {
		if (null == adapterName){
			adapterName = defaultAdapter;
		}

		if (adapterName.length() == 0) {
			throw new NullPointerException("Adapter name must be specified in a string.");
		}
		
		if(adapterName.equals(defaultAdapter)){
			return new Standard(page, totalCount, resultsPerPage);
		}
		if(adapterName.equals("Bootstrap")){
			return new Bootstrap(page, totalCount, resultsPerPage);
		}
		return new Standard(page, totalCount, resultsPerPage);
	}
}

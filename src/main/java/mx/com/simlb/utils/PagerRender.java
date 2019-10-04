package mx.com.simlb.utils;

public abstract class PagerRender {
	private int page;

	private int resultsPerPage;

	private int totalCount;
	
	private Integer totalPages = null;

	private String requestUri;

	private String textPrevious = new String("< Previous");

	private String textNext = new String("Next >");

	private String output = new String();
	
	public PagerRender(int page, int totalCount, int resultsPerPage){
		this.setPage(page);
		this.setTotalCount(totalCount);
		this.setResultsPerPage(resultsPerPage);
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
	
	public Integer getTotalPages() {
		if (null == this.totalPages) {
			setTotalPages((int) Math.ceil((double) this.getTotalCount()
					/ (double) this.getResultsPerPage()));
		}

		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String str) {
		this.output = str;
	}

	public String getLink(Integer page) {
		return getRequestUri() + "?page=" + page;
	}

	public void setRequestUri(String uri) {
		this.requestUri = uri;
	}

	public String getRequestUri() {
		return this.requestUri;
	}

	public void setTextPrevious(String previous) {
		this.textPrevious = previous;
	}

	public String getTextPrevious() {
		return this.textPrevious;
	}

	public void setTextNext(String previous) {
		this.textNext = previous;
	}

	public String getTextNext() {
		return this.textNext;
	}

	abstract public void render();
}

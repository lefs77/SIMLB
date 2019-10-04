package mx.com.simlb.utils;

public class Bootstrap extends PagerRender{

	public Bootstrap(int page, int totalCount, int resultsPerPage){
		super(page, totalCount, resultsPerPage);
		setTextNext("&raquo;");
		setTextPrevious("&laquo;");
	}
	
	public void render() {
		String strStart = "<nav><ul class=\"pagination\">";
		String strEnd = "</ul></nav>";
		
		String str = "";

		if (getTotalPages() == 1 || getTotalCount() == 0) {
			return;
		}

		Integer onPage = (int) (Math.floor((double) getPage()
				/ (double) getResultsPerPage()) + 1.0);

		if (onPage == 1) {
			str += "<li><a href=\"#\">1</a></li>";
		} else {
			str += "<li><a href=\"" + getLink(0) + "\">1</a></li>";
		}

		if (getTotalPages() > 5) {
			Integer startCnt = Math.min(Math.max(1, onPage - 4),
					getTotalPages() - 5);
			Integer endCnt = Math.max(Math.min(getTotalPages(), onPage + 4), 6);

			if (startCnt > 1) {
				str += "<li><a href=\"#\">...</a></li>";
			}

			for (Integer i = startCnt + 1; i < endCnt; i++) {
				if (i == onPage) {
					str += "<li class=\"active\"><a href=\"#\">" + i
							+ "</a></li>";
				} else {
					str += "<li><a href=\""
							+ getLink(((i - 1) * getResultsPerPage())) + "\">"
							+ i + "</a></li>";
				}
			}
			
			if (endCnt < getTotalPages()) {
				str += "<li><a href=\"#\">...</a></li>";
			}
		} else {
			
			for (Integer i = 2; i < getTotalPages(); i++) {
				if (i == onPage) {
					str += "<li class=\"active\"><a href=\"#\">" + i
							+ "</a></li>";
				} else {
					str += "<li><a href=\""
							+ getLink(((i - 1) * getResultsPerPage())) + "\">"
							+ i + "</a></li>";
				}
			}
		}
		
		
		if ((onPage == getTotalPages())) {
			str += "<li class=\"active\"><a href=\"#\">"
					+ getTotalPages() + "</a></li>";
		} else {
			str += "<li><a href=\""
					+ getLink(((getTotalPages() - 1) * getResultsPerPage()))
					+ "\">" + getTotalPages() + "</a></li>";
		}
	    
	    
		if (onPage != 1) {
			str = "<li><a aria-label=\"Previous\" href=\""
					+ getLink(((onPage - 2) * getResultsPerPage())) + "\"><span aria-hidden=\"true\">"+ getTextPrevious() +"</span></a></li>" + str;
		}

		if (onPage != getTotalPages()) {
			str += "<li><a aria-label=\"Next\" href=\""
					+ getLink((onPage * getResultsPerPage())) + "\"><span aria-hidden=\"true\">"+ getTextNext()+ "</span></a></li>";
		}


		String output = strStart.concat(str).concat(strEnd);
		this.setOutput(output);
	}
}

package mx.com.simlb.utils;

public class Standard extends PagerRender{

	public Standard(int page, int totalCount, int resultsPerPage){
		super(page, totalCount, resultsPerPage);
	}
	
	public void render() {
		String str = "";

		if (getTotalPages() == 1 || getTotalCount() == 0) {
			return;
		}

		Integer onPage = (int) (Math.floor((double) getPage()
				/ (double) getResultsPerPage()) + 1.0);
		//System.out.println(getTotalPages());

		if (onPage == 1) {
			str = "<strong>1</strong>";
		} else {
			str = "<span class='pagelink'><a href='" + getLink(0)
					+ "'>1</a></span>";
		}

		if (getTotalPages() > 5) {
			Integer startCnt = Math.min(Math.max(1, onPage - 4),
					getTotalPages() - 5);
			Integer endCnt = Math.max(Math.min(getTotalPages(), onPage + 4), 6);

			if (startCnt > 1) {
				str = str + " ... ";
			} else {
				str = str + "<span>&nbsp;&nbsp;</span>";
			}

			for (Integer i = startCnt + 1; i < endCnt; i++) {
				if (i == onPage) {
					str = str + "<span class=\"pagecurrent\"><strong>" + i
							+ "</strong></span>";
				} else {
					str = str + "<span class=\"pagelink\"><a href=\""
							+ getLink(((i - 1) * getResultsPerPage())) + "\">"
							+ i + "</a></span>";
				}

				if (i < startCnt - 1) {
					str = str + "<span>&nbsp;&nbsp;</span>";
				}
			}

			if (endCnt < getTotalPages()) {
				str = str + " ... ";
			} else {
				str = str + "<span>&nbsp;&nbsp;</span>";
			}
		} else {
			str = str + "<span>&nbsp;&nbsp;</span>";

			for (Integer i = 2; i < getTotalPages(); i++) {

				if (i == onPage) {
					str = str + "<span class=\"pagecurrent\"><strong>" + i
							+ "</strong></span>";
				} else {
					str = str + "<span class=\"pagelink\"><a href=\""
							+ getLink(((i - 1) * getResultsPerPage())) + "\">"
							+ i + "</a></span>";
				}

				if (i < getTotalPages()) {
					str = str + "<span>&nbsp;&nbsp;</span>";
				}
			}
		}

		if ((onPage == getTotalPages())) {
			str = str + "<span class=\"pagecurrent\"><strong>"
					+ getTotalPages() + "</strong></span>";
		} else {
			str = str + "<span class=\"pagelink\"><a href=\""
					+ getLink(((getTotalPages() - 1) * getResultsPerPage()))
					+ "\">" + getTotalPages() + "</a></span>";
		}

		if (onPage != 1) {
			str = "<span class=\"pagelinklast\"><a href=\""
					+ getLink(((onPage - 2) * getResultsPerPage())) + "\">"
					+ getTextPrevious() + "</a></span>&nbsp;&nbsp;" + str;
		}

		if (onPage != getTotalPages()) {
			str = str + "&nbsp;&nbsp;<span class=\"pagelinklast\"><a href=\""
					+ getLink((onPage * getResultsPerPage())) + "\">"
					+ getTextNext() + "</a></span>";
		}

		str = "<div id=\"pager-id\">Ir a p&aacute;gina:" + " " + str + "</div>";
		this.setOutput(str);
	}
}

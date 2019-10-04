package mx.com.simlb.paginador;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.mx.simlb.dto.Reservaciones;

public class PageHibernate extends Page implements HibernateCallback<Object> {

	private Reservaciones reservaciones;
	
	public PageHibernate() {}

    public PageHibernate(String queryString, String page, int resultsPerPage) {
        
    	Integer pageInt = 0;
    	
		if(page != null){
			pageInt = Integer.valueOf(page);
		}
		
		this.setPage(pageInt);
        this.setResultsPerPage(resultsPerPage);
        this.setQueryString(queryString);
    }

    @SuppressWarnings("unchecked")
    public final Object doInHibernate(Session session)
            throws HibernateException {

    	try {
    		
    		Query query = session.createQuery(this.getQueryString());
            //query.setFirstResult((getPageNumber() - 1) * getResultsPerPage());
            query.setFirstResult(getPage());
            query.setMaxResults(getResultsPerPage());
            
            this.results = query.list();
            return this.results;
    		
    	}catch(HibernateException ex) {
    		throw new HibernateException("Error en : "+ex.getMessage());
    	}
        
    }

}

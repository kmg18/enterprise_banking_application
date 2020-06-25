package listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ReportTransactions;

/**
 * Application Lifecycle Listener implementation class BackgroundJobListener
 *
 */
public class BackgroundJobListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
	private ScheduledExecutorService scheduler;

    public BackgroundJobListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new ReportTransactions(), 0, 1, TimeUnit.DAYS);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	scheduler.shutdownNow();
    }
	
}

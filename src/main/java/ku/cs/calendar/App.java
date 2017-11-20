/* 5810405207 Pimonwan Sutmee */

package ku.cs.calendar;


import controllers.MainController;
import models.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext db = new ClassPathXmlApplicationContext("database.xml");
        Database database = (Database) db.getBean("database");
        for(int i = 0 ; i < database.getEvents().size() ; i++){
            System.out.println(database.getEvents().get(i).getTopic());
        }

    	MainController startApp = new MainController();
		startApp.startApplication();

    }
}

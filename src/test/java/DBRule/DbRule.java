package DBRule;

import dao.Sql2oDepartmentDao;
import dao.Sql2oUserDao;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DbRule extends ExternalResource {

    private Connection conn;
    private Sql2oUserDao userDao;

    @Override
    public void before(){
        String connectionString = "jdbc:postgresql://localhost:5432/organizational_news_test";
        Sql2o sql2o = new Sql2o(connectionString,"moringaschool","1543" );
        userDao = new Sql2oUserDao(sql2o);
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @Override
    public void after(){
        userDao.clearAll();
        conn.close();
    }

}

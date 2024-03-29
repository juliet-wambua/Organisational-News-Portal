package dao;

import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private static Connection conn;
    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentsDao departmentsDao;

    public News setupNews(){
        return new News(1,"snitch","guess who's broke?");
    }

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/newsportal_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringaschool", "1543");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    //Add news
    @Test
    public void addNews() throws Exception{
        News testNews = setupNews();
        newsDao.add(testNews);
        int newId = testNews.getNews_id();
        assertEquals(newId,testNews.getNews_id());
    }
//    @Test
//    public void deleteById() throws Exception {
//        News testNews = setupNews();
//        News otherNews = setupNews();
//        assertEquals(2, newsDao.getAllNews().size());
//       // NewsDao.deleteById(testNews.getNews_id());
//        assertEquals(1, newsDao.getAllNews().size());
//    }






}
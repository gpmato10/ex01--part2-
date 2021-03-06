package org.zerock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by dw on 2016. 2. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
    @Inject
    private DataSource ds;

    @Test
    public void testConection()throws Exception{

        try(Connection con = ds.getConnection()){

            System.out.println(con);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

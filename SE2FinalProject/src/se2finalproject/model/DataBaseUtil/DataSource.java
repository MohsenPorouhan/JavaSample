/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.model.DataBaseUtil;

import java.util.ResourceBundle;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Mohsen
 */
public class DataSource {

    private static DataSource dataSource = new DataSource();
    private static BasicDataSource basicDataSource;

    private DataSource() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("databaseInfo");
        String driver = resourceBundle.getString("db.driver");
        String url = resourceBundle.getString("db.url");
        String userName = resourceBundle.getString("db.userName");
        String password = resourceBundle.getString("db.password");
        String maxConnection = resourceBundle.getString("db.maxConnection");
        String minConnection = resourceBundle.getString("db.minConnection");
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
        basicDataSource.setMaxTotal(Integer.parseInt(maxConnection));
        basicDataSource.setMinIdle(Integer.parseInt(minConnection));
    }

    public static BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }
}

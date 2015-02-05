package db_utils;

import db_objects.SprModelObject;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by velenteenko on 04.02.15.
 */
public class DBUtils {

    private static Connection con;

    public static void openConnection(String path)
    {
        try {
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            String url = "jdbc:sqlite:"+path;

            if (con == null) {
                con = DriverManager.getConnection(url);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection()
    {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<SprModelObject> getResultsList(String sql_query) {

        ArrayList<SprModelObject> list = new ArrayList<SprModelObject>();

        Statement stat = null;
        ResultSet res = null;

        try {
            stat = con.createStatement();
            res = stat.executeQuery(sql_query);

            while (res.next()) {
                SprModelObject obj = new SprModelObject();
                obj.setId(res.getInt("id"));
                obj.setName_ru(res.getString("name_ru"));
                obj.setName_en(res.getString("name_en"));

                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


}

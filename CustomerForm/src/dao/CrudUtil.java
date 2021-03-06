package dao;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {

    private static PreparedStatement getPrepareStatement(String sql,Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            preparedStatement.setObject( (i+1),params[i]  );
        }return preparedStatement;

    }public static boolean executeUpdate(String sql,Object... params) throws SQLException, ClassNotFoundException {
        return getPrepareStatement(sql, params).executeUpdate()>0;

    }public static ResultSet executeQuery(String sql,Object... params) throws SQLException, ClassNotFoundException {
         return getPrepareStatement(sql,params).executeQuery() ;
    }

}

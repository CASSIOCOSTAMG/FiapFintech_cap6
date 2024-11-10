package br.com.fiap.fintechapp.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory conn;
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USER = "rm557226";
    private static final String PASS = "080378";

    public static ConnectionFactory getInstance(){
        if(conn == null){

            conn = new ConnectionFactory();
        }  return conn;
    }

    public Connection getConnection() {
        Connection conexao = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(URL,USER,PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }      return conexao;
    }
}


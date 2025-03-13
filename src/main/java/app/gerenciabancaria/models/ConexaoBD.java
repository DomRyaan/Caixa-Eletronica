package app.gerenciabancaria.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexaoBD {
    private Connection conn = null;
    private final String jbdcDriver = "com.mysql.cj.jdbc.Driver";
    private final String prefixoBD =  "jdbc:mysql://";
    private final String nomeHost = "127.0.0.1";
    private final String porta = "3306";
    private final String nomeBD = "banco";
    private final String usuario = "root";
    private final String senha =  "rf06122004";
    private String url = null;

    public ConexaoBD(){
        url = prefixoBD + nomeHost + ":" + porta + "/" + nomeBD;
    }

    public Connection getConexao(){
        try {
            if (conn == null){
                Class.forName(jbdcDriver);
                conn = DriverManager.getConnection(url, usuario, senha);
            } else if (conn.isClosed()) {
                conn = null;
                return getConexao();
            }
        }catch (ClassNotFoundException ex){
            System.out.println("Driver não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conn;
    }

    public void fecharConexao(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException ex){
                System.out.println(ex);
            }
        }
    }
}

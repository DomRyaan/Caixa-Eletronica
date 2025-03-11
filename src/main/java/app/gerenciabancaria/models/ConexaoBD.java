package app.gerenciabancaria.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexaoBD {
    private Connection conn = null;
    Dotenv dotenv = Dotenv.load();
    private final String jbdcDriver = dotenv.get("JBDCDRIVER");
    private final String prefixoBD = dotenv.get("PREFIXOBD");
    private final String nomeHost = dotenv.get("NOMEHOST");
    private final String porta = dotenv.get("PORTA");
    private final String nomeBD = dotenv.get("NOMEBD");
    private final String usuario = dotenv.get("USER");
    private final String senha = dotenv.get("SENHA");
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

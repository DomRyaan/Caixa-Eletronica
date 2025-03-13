package app.gerenciabancaria.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conta{
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public Conta(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }
    public String getCpf(){
        return this.cpf;
    }

    public static boolean autenticar(Conta conta){
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.getConexao();

        String sql = "SELECT * FROM Conta WHERE cpf = ? and nome = ?";
        try {
            PreparedStatement pStat = conexao.prepareStatement(sql);
            pStat.setString(1, conta.getCpf());
            pStat.setString(2, conta.getNome());
            ResultSet resultado = pStat.executeQuery();

            String nomeBD;
            String sobrenomeBD;

            if (resultado.next()) {
                nomeBD = resultado.getString("nome");
                sobrenomeBD = resultado.getString("sobrenome");

                return conta.getNome().equals(nomeBD) && conta.getSobrenome().equals(sobrenomeBD);
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao autenticar" + ex.getMessage());
        }finally {
            conn.fecharConexao();
        }
        return false;
    }

    public double getSaldo(){
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.getConexao();

        String sql = "SELECT saldo from conta where nome = ? and cpf = ?";
        PreparedStatement preparo;
        ResultSet resultado;

        try {
            preparo = conexao.prepareStatement(sql);
            preparo.setString(1, this.nome);
            preparo.setString(2, this.cpf);
            resultado = preparo.executeQuery();

            if(resultado.next()){
                this.saldo = resultado.getDouble("saldo");
                return this.saldo;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao acessar saldo: " + e.getMessage());
        } finally {
            conn.fecharConexao();
        }
        // Irá servir para tratar erros no futuro, caso dê algo errado.
        return -1.0;
    }

    public boolean depositar(double valor) {
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.getConexao();

        double saldo = getSaldo();
        double saldoAtual =  saldo + valor;

        String sql = "update conta set saldo = ? where cpf = ? and nome = ?";
        PreparedStatement preparo;

        try{
            preparo = conexao.prepareStatement(sql);
            preparo.setDouble(1, saldoAtual);
            preparo.setString(2, this.cpf);
            preparo.setString(3, this.nome);
            preparo.executeUpdate();

            preparo.close();
            return true;
        } catch (SQLException ex){
            System.out.println("Erro ao realizar o deposito: " + ex.getMessage());
        }finally {
            conn.fecharConexao();
        }
        return false;
    }

    public boolean sacar(double valor){
        ConexaoBD conexao = new ConexaoBD();
        Connection conn = conexao.getConexao();

        double saldo = getSaldo();

        if (valor < saldo){
            try {
                double atualizarSaldo = saldo - valor;

                String sql = "update conta set saldo = ? where cpf = ? and nome = ?";
                PreparedStatement preparo = conexao.getConexao().prepareStatement(sql);
                preparo.setDouble(1, atualizarSaldo);
                preparo.setString(2, this.cpf);
                preparo.setString(3, this.nome);
                preparo.executeUpdate();

                preparo.close();
                return true;

            } catch (SQLException ex){
                System.out.println(ex.getMessage());
                return false;
            } finally {
                conexao.fecharConexao();
            }
        }else {
            return false;
        }
    }
}

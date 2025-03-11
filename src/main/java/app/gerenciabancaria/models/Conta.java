package app.gerenciabancaria.models;

public class Conta{
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    public double saldo;

    public Conta(String nome, String sobrenome,String cpf,double saldoInicial){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = saldoInicial;
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

    public double getSaldo(){
        return this.saldo;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public boolean sacar(double valor){
        if (valor < saldo){
            saldo -= valor;
            return true;
        }else {
            return false;
        }
    }
}

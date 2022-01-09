/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PAULO
 */
public class PassageiroModel {
    
    private int IdPassageiro;
    private String CPF;
    private String Telefone;
    private String Cidade;
    private String Email;
    private String CompaniaAerea;
    private int situacao;

    public int getIdPassageiro() {
        return IdPassageiro;
    }

    public void setIdPassageiro(int IdPassageiro) {
        this.IdPassageiro = IdPassageiro;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCompaniaAerea() {
        return CompaniaAerea;
    }

    public void setCompaniaAerea(String CompaniaAerea) {
        this.CompaniaAerea = CompaniaAerea;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    

    
}

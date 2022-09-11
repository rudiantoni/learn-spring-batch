package com.myapps.arquivolargurafixa.dominio;

import ch.qos.logback.core.net.server.Client;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String idade;
    private String email;

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return this.sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getIdade() {
        return this.idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade='" + idade + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

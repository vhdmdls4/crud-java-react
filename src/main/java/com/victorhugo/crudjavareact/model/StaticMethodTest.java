package com.victorhugo.crudjavareact.model;

public class StaticMethodTest {
    private String nome;
    private String sobrenome;
    public static int infId = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public static int getInfId() {
        return infId;
    }

    public static void setInfId(int infId) {
        StaticMethodTest.infId = infId;
    }

    public static void StaticTest() {
        StaticMethodTest test = new StaticMethodTest();
        test.setNome("Victor");
        System.out.println("Nome: " + test.nome + " Sobrenome: ");
    }

    public static void main(String[] args) {
        StaticMethodTest.StaticTest();
    }
}


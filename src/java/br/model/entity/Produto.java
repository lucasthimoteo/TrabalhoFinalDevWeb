/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model.entity;

/**
 *
 * @author leandroall
 */
public class Produto {

    private int id;
    private String nome;
    private int id_categoria;
    private String descricao;
    private double valor;

    public Produto() {
        this.id = -1;
        this.nome = "";
        this.id_categoria = 0;
        this.descricao = "";
        this.valor = 0;
    }

    public Produto(String name,int idcat, String desc,  double val) {
        this.nome = name;
        this.descricao = desc;
        this.id_categoria = idcat;
        this.valor = val;
    }

    public Produto(int id,String name,int idcat, String desc,  double val) {
        this.id = id;
        this.nome = name;
        this.descricao = desc;
        this.id_categoria = idcat;
        this.valor = val;
    }

    public Produto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcat() {
        return id_categoria;
    }

    public void setIdcat(int id) {
        this.id_categoria = id;
    }

    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String desc) {
        this.descricao = desc;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double val) {
        this.valor = val;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

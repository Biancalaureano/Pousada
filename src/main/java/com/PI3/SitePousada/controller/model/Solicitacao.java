/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller.model;

import java.time.LocalDate;



public class Solicitacao {
    
    private int id ;
    private String nome;
    private  String email;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String quartoDesejado;
    private int quantidadeAdultos;
    private int quantidadeCriancas;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getQuartoDesejado() {
        return quartoDesejado;
    }

    public void setQuartoDesejado(String quartoDesejado) {
        this.quartoDesejado = quartoDesejado;
    }

    public int getQuantidadeAdultos() {
        return quantidadeAdultos;
    }

    public void setQuantidadeAdultos(int quantidadeAdultos) {
        this.quantidadeAdultos = quantidadeAdultos;
    }

    public int getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public void setQuantidadeCriancas(int quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
    }
    
}

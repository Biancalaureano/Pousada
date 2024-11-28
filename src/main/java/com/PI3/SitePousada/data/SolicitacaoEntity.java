/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;



@Data 
@Entity(name="solicitacao") 
@Table(name="solicitacao") 
public class SolicitacaoEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id ;
    private String nome;
    private  String email;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String quartoDesejado;
    private int quantidadeAdultos;
    private int quantidadeCriancas;
    private String observacao;

}

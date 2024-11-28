/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;



@Data 
@Entity(name="solicitacao") 
@Table(name="solicitacao") 
public class SolicitacaoEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    
    private String nome;
    private  String email;
    private LocalDate data_entrada;
    private LocalDate data_saida;
    private String quarto_desejado;
    private int quantidade_adultos;
    private int quantidade_criancas;
    private String observacao;

}

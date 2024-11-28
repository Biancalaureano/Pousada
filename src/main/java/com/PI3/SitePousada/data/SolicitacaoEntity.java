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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    
    @NotEmpty(message="Nome obrigatório")
    private String nome;
    
    @Email(message="E-mail inválido")
    private  String email;
    
    @NotNull(message="Data de entrada é obrigatório") 
    private LocalDate data_entrada;
    
    @NotNull(message="Data de saída é obrigatório") 
    private LocalDate data_saida;
    
    @NotBlank(message="Quarto obrigatório")
    private String quarto_desejado;
    
    @NotNull()
    private int quantidade_adultos;
    
    @NotNull()
    private int quantidade_criancas;
    
    private String observacao;

}

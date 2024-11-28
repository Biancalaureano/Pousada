/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import com.PI3.SitePousada.Service.SolicitacaoService;
import com.PI3.SitePousada.data.SolicitacaoEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController 

@RequestMapping("/solicitacao") 
public class SolicitacaoRestController {
    
    @Autowired 
    private  SolicitacaoService solicitacaoService;
    
    @GetMapping("/listar") 

    public ResponseEntity<List> getAllSolicitacoes() { 

        List<SolicitacaoEntity> solicitacaos = solicitacaoService.listarTodasSolicitacoes(); 

        return new ResponseEntity<>(solicitacaos, HttpStatus.OK); 

    } 
    
    @GetMapping("/pesquisar/{id}") 

    public ResponseEntity<SolicitacaoEntity> getSolicitacaoById(@PathVariable Integer id) { 

        SolicitacaoEntity solicitacao = solicitacaoService.getSolicitacaoId(id);

        return new ResponseEntity<>(solicitacao, HttpStatus.OK); 

    } 
    
    
   @PostMapping("/adicionar") 

   public ResponseEntity<SolicitacaoEntity> addSolicitacao(@RequestBody SolicitacaoEntity solicitacao) { 

        var novaAnalise = solicitacaoService.criarSolicitacao(solicitacao);

        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED); 

   } 

   @PutMapping("/atualizar/{id}") 

   public ResponseEntity<SolicitacaoEntity> atualizarSolicitacao(@PathVariable Integer id, @RequestBody SolicitacaoEntity solicitacao) { 

        var solicitacaoAtualizada = solicitacaoService.atualizarSolicitacao(id, solicitacao);

        return new ResponseEntity<>(solicitacaoAtualizada, HttpStatus.OK); 

   } 

   @DeleteMapping("/deletar/{id}") 

   public ResponseEntity deletarSolicitacao(@PathVariable Integer id) { 

        solicitacaoService.deletarSolicitacao(id);

        return new ResponseEntity<>(HttpStatus.OK); 

   } 

}

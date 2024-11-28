/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import com.PI3.SitePousada.Service.SolicitacaoService;
import com.PI3.SitePousada.data.SolicitacaoEntity;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControllerPousada {
    
    @Autowired 
    SolicitacaoService solicitacaoService; 
    
    @GetMapping("/pagina-inicial") 
     public String mostraPaginaInicial(Model model){ 
         
         model.addAttribute("solicitacao", new SolicitacaoEntity()); 
         
         return "pagina-inicial"; 
         
     } 
     
     @PostMapping("/pagina-inicial") 
     public String recebeCadastro(@Valid @ModelAttribute("solicitacao") SolicitacaoEntity solicitacao, BindingResult result){ 
                  
        if (result.hasErrors()) { 

            return "pagina-inicial"; 

        } 

        if (solicitacao.getId()==null) { 
            
            System.out.println(solicitacao.getNome());
            System.out.println(solicitacao.getEmail());
            System.out.println(solicitacao.getData_entrada());
            System.out.println(solicitacao.getData_saida());
            System.out.println(solicitacao.getQuarto_desejado());
            System.out.println(solicitacao.getQuantidade_adultos());
            System.out.println(solicitacao.getQuantidade_criancas());
            System.out.println(solicitacao.getObservacao());

            solicitacaoService.criarSolicitacao(solicitacao);

        } 
     
        return "redirect:/";
     
     } 
     
     @GetMapping("/pagina-quartos") 
     public String mostraPaginaQuarto(){ 
         
         return "pagina-quartos"; 
         
     } 
     
     @GetMapping("/solicitacoes")
    public String mostrarLista(Model model) {
    
        List<SolicitacaoEntity> solicitacoes = solicitacaoService.listarTodasSolicitacoes();
        
        model.addAttribute("solicitacoes", solicitacoes);

        return "solicitacoes";
    }
    
    @DeleteMapping("/solicitacoes/deletar/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Integer id) {
        System.out.println("Chamou deletarSolicitacao com ID: " + id);

        solicitacaoService.deletarSolicitacao(id);
        
        return ResponseEntity.ok("Exclusão bem-sucedida");

    }
    
}

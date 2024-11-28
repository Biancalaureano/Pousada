/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import com.PI3.SitePousada.data.SolicitacaoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControllerPousada {
    
    private List<SolicitacaoEntity> listaSolicitacoes = new ArrayList<>();
    
    @GetMapping("/pagina-inicial") 
     public String mostraPaginaInicial(Model model){ 
         
         model.addAttribute("solicitacao", new SolicitacaoEntity()); 
         
         return "pagina-inicial"; 
         
     } 
     
     @PostMapping("/pagina-inicial") 
     public void recebeCadastro(Model model, @ModelAttribute SolicitacaoEntity solicitacao){ 
                    
     solicitacao.setId(listaSolicitacoes.size());
         
     listaSolicitacoes.add(solicitacao);
     model.addAttribute("solicitacao", solicitacao); 
     
     
     } 
     
     @GetMapping("/pagina-quartos") 
     public String mostraPaginaQuarto(){ 
         
         return "pagina-quartos"; 
         
     } 
     
     @GetMapping("/solicitacoes")
    public String mostrarLista(Model model) {
    
        List<SolicitacaoEntity> solicitacoes = listaSolicitacoes;
        model.addAttribute("solicitacoes", solicitacoes);

        return "solicitacoes";
    }
    
    @DeleteMapping("/solicitacoes/deletar/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Integer id) {
        System.out.println("Chamou deletarSolicitacao com ID: " + id);

        listaSolicitacoes.remove(listaSolicitacoes.get(id));
        
        return ResponseEntity.ok("Exclusão bem-sucedida");

    }
    
}

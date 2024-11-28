/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import com.PI3.SitePousada.controller.model.Solicitacao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControllerPousada {
    
    private List<Solicitacao> listaSolicitacoes = new ArrayList<>();
    
    @GetMapping("/pagina-inicial") 
     public String mostraPaginaInicial(Model model){ 
         
         model.addAttribute("solicitacao", new Solicitacao()); 
         
         return "pagina-inicial"; 
         
     } 
     
     @PostMapping("/pagina-inicial") 
     public String recebeCadastro(Model model, @ModelAttribute Solicitacao solicitacao){ 
                    
     solicitacao.setId(listaSolicitacoes.size());
         
     listaSolicitacoes.add(solicitacao);
     model.addAttribute("solicitacao", solicitacao); 
     
     return "/pagina-inicial"; 
     
     } 
     
     @GetMapping("/pagina-quartos") 
     public String mostraPaginaQuarto(){ 
         
         return "pagina-quartos"; 
         
     } 
    
}

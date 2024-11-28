/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import com.PI3.SitePousada.Service.SolicitacaoService;
import com.PI3.SitePousada.data.SolicitacaoEntity;
import com.PI3.SitePousada.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControllerPousada {
    
    @Autowired 
    SolicitacaoService solicitacaoService; 
    
    @GetMapping("/pagina-inicial") 
     public String mostraPaginaInicial(@CookieValue(name="pref-tema", defaultValue="")String tema, Model model){ 
         
         model.addAttribute("solicitacao", new SolicitacaoEntity()); 
         model.addAttribute("css", tema); 
         
         return "pagina-inicial"; 
         
     } 
     
     @PostMapping("/pagina-inicial") 
     public String recebeCadastro(@Valid @ModelAttribute("solicitacao") SolicitacaoEntity solicitacao, BindingResult result){ 
                  
        if (result.hasErrors()) { 

            return "redirect/l"; 

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
     
        return "pagina-inicial";
     
     } 
     
     @GetMapping("/pagina-quartos") 
     public String mostraPaginaQuarto(@CookieValue(name="pref-tema", defaultValue="")String tema,Model model){ 
         
         model.addAttribute("css", tema); 
         
         return "pagina-quartos"; 
         
     } 
     
     @GetMapping("/solicitacoes")
    public String mostrarLista(@CookieValue(name="pref-tema", defaultValue="")String tema, Model model) {
    
        List<SolicitacaoEntity> solicitacoes = solicitacaoService.listarTodasSolicitacoes();
        
        model.addAttribute("solicitacoes", solicitacoes);
        model.addAttribute("css", tema); 

        return "solicitacoes";
    }
    
    @DeleteMapping("/solicitacoes/deletar/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Integer id) {
        System.out.println("Chamou deletarSolicitacao com ID: " + id);

        solicitacaoService.deletarSolicitacao(id);
        
        return ResponseEntity.ok("Exclusão bem-sucedida");

    }
    
    @PutMapping("/solicitacoes/{id}")
    public ResponseEntity<String> atualizaSolicitacao(@PathVariable(value ="id") Integer id) {

        solicitacaoService.atualizarSolicitacaoId(id);

        return ResponseEntity.ok("Atualizaçao bem-sucedida");
        
    }
    
    @PostMapping("/preferencias") 
    public void gravaPreferencias(@ModelAttribute("preferencia") Preferencia pref, HttpServletResponse response){ 
        
        Cookie cookiePrefTema = new Cookie("pref-tema", pref.getTema()); 
        cookiePrefTema.setDomain("localhost"); //disponível apenas no domínio "localhost" 
        cookiePrefTema.setHttpOnly(true); //acessível apenas por HTTP, JS não 
        cookiePrefTema.setMaxAge(86400); //1 dia 
        response.addCookie(cookiePrefTema); 
        System.out.println(cookiePrefTema);
        
    } 
    
}

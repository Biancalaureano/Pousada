/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;



@Controller
public class ControllerPousada {
    
    @GetMapping("/pagina-inicial") 
     public String mostraPagina(){ 
         
         return "pagina-inicial"; 
         
     } 
    
}

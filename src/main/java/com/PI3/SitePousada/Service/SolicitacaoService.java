/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PI3.SitePousada.Service;

import com.PI3.SitePousada.data.SolicitacaoEntity;
import com.PI3.SitePousada.data.SolicitacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service 
public class SolicitacaoService {
    
    @Autowired 
     private  SolicitacaoRepository solicitacaoRepository;
    
    public SolicitacaoEntity criarSolicitacao(SolicitacaoEntity solicitacao) { 

        solicitacao.setId(null);
        solicitacao.setStatus(false);
        
        solicitacaoRepository.save(solicitacao); 

        return solicitacao; 

    } 
    
    public SolicitacaoEntity atualizarSolicitacao(Integer solicitacaoId, SolicitacaoEntity solicitacaoRequest) { 

        SolicitacaoEntity solicitacao = getSolicitacaoId(solicitacaoId);
        solicitacao.setNome(solicitacaoRequest.getNome());
        solicitacao.setEmail(solicitacaoRequest.getEmail());
        solicitacao.setData_entrada(solicitacaoRequest.getData_entrada());
        solicitacao.setData_saida(solicitacaoRequest.getData_saida());
        solicitacao.setQuarto_desejado(solicitacaoRequest.getQuarto_desejado());
        solicitacao.setQuantidade_adultos(solicitacaoRequest.getQuantidade_adultos());
        solicitacao.setQuantidade_criancas(solicitacaoRequest.getQuantidade_criancas());
        solicitacao.setObservacao(solicitacaoRequest.getObservacao());
        solicitacao.setStatus(solicitacaoRequest.isStatus());
        
        solicitacaoRepository.save(solicitacao); 
        
        return solicitacao;

    } 
    
    public SolicitacaoEntity atualizarSolicitacaoId(Integer solicitacaoId) { 

        SolicitacaoEntity solicitacao = getSolicitacaoId(solicitacaoId);
        solicitacao.setNome(solicitacao.getNome());
        solicitacao.setEmail(solicitacao.getEmail());
        solicitacao.setData_entrada(solicitacao.getData_entrada());
        solicitacao.setData_saida(solicitacao.getData_saida());
        solicitacao.setQuarto_desejado(solicitacao.getQuarto_desejado());
        solicitacao.setQuantidade_adultos(solicitacao.getQuantidade_adultos());
        solicitacao.setQuantidade_criancas(solicitacao.getQuantidade_criancas());
        solicitacao.setObservacao(solicitacao.getObservacao());
        solicitacao.setStatus(true);
        
        solicitacaoRepository.save(solicitacao); 
        
        return solicitacao;

    } 
    
    public SolicitacaoEntity getSolicitacaoId(Integer solicitacaoId) { 

        return solicitacaoRepository.findById(solicitacaoId).orElse(null); 

        } 
    
     public List<SolicitacaoEntity> listarTodasSolicitacoes() { 

        return solicitacaoRepository.findAll(); 

     } 
     
     public void deletarSolicitacao(Integer solicitacaoId) { 

        SolicitacaoEntity solicitacao = getSolicitacaoId(solicitacaoId);

        solicitacaoRepository.deleteById(solicitacao.getId()); 

    } 
     
}

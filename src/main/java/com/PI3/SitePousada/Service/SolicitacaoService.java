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
        
        solicitacaoRepository.save(solicitacao); 

        return solicitacao; 

    } 
    
    public SolicitacaoEntity atualizarSolicitacao(Integer solicitacaoId, SolicitacaoEntity solicitacaoRequest) { 

        SolicitacaoEntity solicitacao = getSolicitacaoId(solicitacaoId);
        solicitacao.setNome(solicitacaoRequest.getNome());
        solicitacao.setEmail(solicitacaoRequest.getEmail());
        solicitacao.setDataEntrada(solicitacaoRequest.getDataEntrada());
        solicitacao.setDataSaida(solicitacaoRequest.getDataSaida());
        solicitacao.setQuartoDesejado(solicitacaoRequest.getQuartoDesejado());
        solicitacao.setQuantidadeAdultos(solicitacaoRequest.getQuantidadeAdultos());
        solicitacao.setQuantidadeCriancas(solicitacaoRequest.getQuantidadeCriancas());
        solicitacao.setObservacao(solicitacaoRequest.getObservacao());
        
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

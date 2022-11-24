/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.associacao.model.respository;

import com.example.associacao.model.entity.ItemVenda;
import com.example.associacao.model.entity.Produto;
import com.example.associacao.model.entity.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

/**
 *
 * @author User
 */
@Repository
public class VendaRespository {
    @PersistenceContext
    private EntityManager em;

    public List<Venda> venda(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }



}

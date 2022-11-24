package com.example.associacao.controller;

import com.example.associacao.model.entity.ItemVenda;
import com.example.associacao.model.entity.Produto;
import com.example.associacao.model.entity.Venda;
import com.example.associacao.model.respository.ProdutoRepository;
import com.example.associacao.model.respository.VendaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@Scope("request")
@RequestMapping("venda")
public class VendaController {

    @Autowired
    VendaRespository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    Venda venda;


    @GetMapping("/carrinho")
    public ModelAndView carrinho(ItemVenda itemVenda) {
        //System.out.println("IDDDD:"+ itemVenda.getProduto().getId());

        Produto p = produtoRepository.findById(itemVenda.getProduto().getId()).get();
        itemVenda.setProduto(p);
        venda.getItensVenda().add(itemVenda);
        return  new ModelAndView("/venda/carrinho");
    }

    @GetMapping("/clear")
    public ModelAndView clear(){
        venda.getItensVenda().clear();
        return new ModelAndView("redirect:/venda/carrinho");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        venda.getItensVenda().remove(id);
        return new ModelAndView("redirect:/venda/carrinho");
    }
}
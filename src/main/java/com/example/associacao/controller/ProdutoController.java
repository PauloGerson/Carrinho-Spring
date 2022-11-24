/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.associacao.controller;

import com.example.associacao.model.entity.ItemVenda;
import com.example.associacao.model.entity.Produto;
import com.example.associacao.model.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Transactional
@Controller
@RequestMapping("produto")
public class ProdutoController {

     @Autowired
     ProdutoRepository produtoRepository;


     @GetMapping("/list")
     public ModelAndView listar(ItemVenda itemVenda,ModelMap model) {
          model.addAttribute("produtos", produtoRepository.findAll());
          return new ModelAndView("/produtos/list", model);
     }

    @GetMapping("/form")
    public ModelAndView cadastrarProduto(Produto produto){
        return new ModelAndView("/produtos/form");
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        produtoRepository.save(produto);
        return new ModelAndView("redirect:/produto/list");
    }



    /*@GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto",  produtoRepository.findById(id));
        return new ModelAndView("/produtos/form", model);
    }*/


}

package com.bla.entrega.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bla.entrega.model.Pessoa;
import com.bla.entrega.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/pessoa");
		mv.addObject("pessoas", service.findAll());
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView("/pessoaADD");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		return add(service.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {
		if (result.hasErrors()) {
			return add(pessoa);
		}
		service.save(pessoa);
		return findAll();
	}
	
}

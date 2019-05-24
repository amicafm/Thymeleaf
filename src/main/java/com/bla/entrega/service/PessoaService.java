package com.bla.entrega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bla.entrega.model.Pessoa;
import com.bla.entrega.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repositorio;
	
	public List<Pessoa> findAll(){
		return repositorio.findAll();
	}
	
	public Pessoa findOne(Integer id) {
		return repositorio.findOne(id);
	}
	
	public Pessoa save(Pessoa pessoa) {
		return repositorio.saveAndFlush(pessoa);
	}
	
	public void delete(Integer id){
		repositorio.delete(id);
	}

}

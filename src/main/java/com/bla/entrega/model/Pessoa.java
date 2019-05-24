package com.bla.entrega.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Hey, nome é uma informação obrigatória!")
	private String nome;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Sobrenome é uma informação obrigatória.")
	private String sobrenome;
	

}

package com.udineisilva.workshopmongo.services.exception;

// RuntimeException -  o compilar NAO exige que seja tratada pelo desenvolvedor, 
//  será desenvolvida uma classe auxiliar pra tratar a exception, a criação dessa classe 
//  é um macete, que dispensa tratar a execao no metodoo que pode disparar a execao 
// Exception - compilador EXIGE que seja tratada pelo desenvolvedor
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String  msg){
		super(msg);
	}
}

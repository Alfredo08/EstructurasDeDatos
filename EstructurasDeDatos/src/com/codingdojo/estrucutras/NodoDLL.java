package com.codingdojo.estrucutras;

public class NodoDLL {
	private int valor;
	private NodoDLL next;
	private NodoDLL prev;
	
	public NodoDLL( int num ) {
		this.valor = num;
		this.next = null;
		this.prev = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoDLL getNext() {
		return next;
	}

	public void setNext(NodoDLL next) {
		this.next = next;
	}

	public NodoDLL getPrev() {
		return prev;
	}

	public void setPrev(NodoDLL prev) {
		this.prev = prev;
	}
	
	
}

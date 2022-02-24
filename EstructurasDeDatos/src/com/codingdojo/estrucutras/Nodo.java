package com.codingdojo.estrucutras;

public class Nodo {
	private NodoArbol nodo;
	private Nodo next;
	
	public Nodo( NodoArbol nodo ) {
		this.nodo = nodo;
		this.next = null;
	}

	public NodoArbol getNodo() {
		return nodo;
	}

	public void setNodo(NodoArbol nodo) {
		this.nodo = nodo;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
	
	
}

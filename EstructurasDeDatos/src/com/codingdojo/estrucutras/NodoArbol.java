package com.codingdojo.estrucutras;

public class NodoArbol {
	private int valor;
	private NodoArbol izquierdo;
	private NodoArbol derecho;
	
	public NodoArbol( int valor ) {
		this.valor = valor;
		izquierdo = null;
		derecho = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoArbol getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoArbol izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoArbol getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoArbol derecho) {
		this.derecho = derecho;
	}
	
	
}

package com.codingdojo.estrucutras;

public class ListaEncadenada {
	private Nodo head;
	private int length;
	
	public ListaEncadenada() {
		this.head = null;
		this.length = 0;
	}
	
	public void insertar( Nodo nuevoNodo ) {
		this.length ++;
		if( this.head == null ) {
			this.head = nuevoNodo;
		}
		else {
			Nodo aux = this.head;
			
			while( aux.getNext() != null ) {
				aux = aux.getNext();
			}
			
			aux.setNext( nuevoNodo );
		}
	}
	
	public Nodo removerDelFrente() {
		Nodo aux = this.head;
		
		this.head = aux.getNext();
		aux.setNext( null );
		
		return aux;
	}

	public Nodo getHead() {
		return head;
	}

	public void setHead(Nodo head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}

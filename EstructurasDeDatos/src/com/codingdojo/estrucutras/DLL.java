package com.codingdojo.estrucutras;

public class DLL {
	private NodoDLL head;
	private NodoDLL tail;
	private int length;
	
	public DLL() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public void agregaAlFrente( NodoDLL nuevoNodo ) {
		if( this.head == null ) {
			this.head = nuevoNodo;
			this.tail = nuevoNodo;
		}
		else {
			nuevoNodo.setNext( this.head );
			this.head.setPrev( nuevoNodo );
			this.head = nuevoNodo;
		}
		this.length ++;
	}
	
	public void agregaAlFinal( NodoDLL nuevoNodo ) {
		if( this.tail == null ) {
			this.head = nuevoNodo;
			this.tail = nuevoNodo;
		}
		else {
			nuevoNodo.setPrev( this.tail );
			this.tail.setNext( nuevoNodo );
			this.tail = nuevoNodo;
		}
		this.length ++;
	}
	
	public void agregaEnPosicion( NodoDLL nuevoNodo, int indice ) {
		if ( indice <= this.length ) {
			if( this.head == null ) {
				agregaAlFrente( nuevoNodo );
			}
			else {
				
				if( indice == this.length ) {
					agregaAlFinal( nuevoNodo );
				}
				else {
					NodoDLL aux1 = this.head;
					NodoDLL aux2 = aux1;
					int cont = 0;
					
					while( cont < indice ) {
						aux1 = aux2;
						aux2 = aux2.getNext();
						cont ++;
					}
					
					aux1.setNext( nuevoNodo );
					aux2.setPrev( nuevoNodo );
					nuevoNodo.setNext( aux2 );
					nuevoNodo.setPrev( aux1 );
					this.length ++;
				}	
			}
		}
		else {
			System.out.println( "La lista aun no contiene el número de nodos correspondiente al indice proporcionado." );
		}
	}
	
	public void imprimePrincipioFin() {
		NodoDLL aux = this.head;
		
		while( aux != null ) {
			System.out.print( aux.getValor() + " -> " );
			aux = aux.getNext();
		}
	}
	
	public void imprimeFinPrincipio() {
		NodoDLL aux = this.tail;
		
		while( aux != null ) {
			System.out.print( aux.getValor() + " -> " );
			aux = aux.getPrev();
		}
	}

	public NodoDLL getHead() {
		return head;
	}

	public void setHead(NodoDLL head) {
		this.head = head;
	}

	public NodoDLL getTail() {
		return tail;
	}

	public void setTail(NodoDLL tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}

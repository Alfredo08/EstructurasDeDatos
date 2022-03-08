package com.codingdojo.estrucutras;

public class ArbolBinario {
	private NodoArbol raiz;
	
	public ArbolBinario() {
		this.raiz = null;
	}
	
	public void agregar( NodoArbol nuevoNodo ) {
		if( this.raiz == null ) {
			this.raiz = nuevoNodo;
		}
		else {
			NodoArbol aux = this.raiz;
			boolean noEncontrado = true;
			
			while( noEncontrado ) {
				if( aux.getValor() > nuevoNodo.getValor() ) {
					if( aux.getIzquierdo() != null ) {
						aux = aux.getIzquierdo();
					}
					else {
						aux.setIzquierdo( nuevoNodo );
						noEncontrado = false;
					}
				}
				else {
					if( aux.getDerecho() != null ) {
						aux = aux.getDerecho();
					}
					else {
						aux.setDerecho( nuevoNodo );
						noEncontrado = false;
					}
				}
			}
		}
	}
	
	public void remover( int numero ) {
		NodoArbol existe = buscaValor( numero );
		
		if( existe == null ) {
			System.out.println( "El nodo no existe en el arbol, no se puede remover." );
		}
		else {
			NodoArbol padre = this.raiz;
			NodoArbol hijo = this.raiz;
			
			if( hijo.getValor() == numero ) {
				if( padre.getIzquierdo() != null ) {
					setRaiz( padre.getIzquierdo() );
					if( padre.getDerecho() != null ) {
						agregar( padre.getDerecho() );
					}
				}
				else {
					if( padre.getDerecho() != null ) {
						setRaiz( padre.getDerecho() );
					}
				}
				
				padre.setIzquierdo( null );
				padre.setDerecho( null );
			}
			else {
				while( hijo.getValor() != numero ) {
					padre = hijo;
					
					if( hijo.getValor() > numero ) {
						hijo = hijo.getIzquierdo();
					}
					else {
						hijo = hijo.getDerecho();
					}
				}
				if( padre.getValor() > numero ) {
					padre.setIzquierdo( null );
				}
				else {
					padre.setDerecho( null );
				}
				
				if( hijo.getIzquierdo() != null ) {
					agregar( hijo.getIzquierdo() );
					hijo.setIzquierdo( null );
				}
				if( hijo.getDerecho() != null ) {
					agregar( hijo.getDerecho() );
					hijo.setDerecho( null );
				}
			}
			
		}
	}
	
	public NodoArbol buscaValor( int numero ) {
		
		NodoArbol aux = this.raiz;
		
		while( aux != null ) {
			if( aux.getValor() == numero ) {
				return aux;
			}
			else {
				if( aux.getValor() > numero ) {
					aux = aux.getIzquierdo();
				}
				else {
					aux = aux.getDerecho();
				}
			}
		}
		
		return null;
		
	}
	
	public void inOrder( NodoArbol nodoActual ) {
		if( nodoActual.getIzquierdo() != null ) {
			inOrder( nodoActual.getIzquierdo() );
		}
		System.out.print( nodoActual.getValor() + " - " );
		if( nodoActual.getDerecho() != null ) {
			inOrder( nodoActual.getDerecho() );
		}
	}
	
	public void preOrder( NodoArbol nodoActual ) {
		System.out.print( nodoActual.getValor() + " - " );
		if( nodoActual.getIzquierdo() != null ) {
			preOrder( nodoActual.getIzquierdo() );
		}
		if( nodoActual.getDerecho() != null ) {
			preOrder( nodoActual.getDerecho() );
		}
	}
	
	public void postOrder( NodoArbol nodoActual ) {
		if( nodoActual.getIzquierdo() != null ) {
			postOrder( nodoActual.getIzquierdo() );
		}
		if( nodoActual.getDerecho() != null ) {
			postOrder( nodoActual.getDerecho() );
		}
		System.out.print( nodoActual.getValor() + " - " );
	}
	
	public NodoArbol getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol raiz) {
		this.raiz = raiz;
	}
	
	
}

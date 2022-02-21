package com.codingdojo.aplicacion;

import com.codingdojo.estrucutras.*;
import java.util.HashMap;

public class Aplicacion {
	
	public static void removerDuplicadosEnDLL( DLL lista ) {
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		
		NodoDLL aux = lista.getHead();
		NodoDLL prevAux = aux;
		
		mapa.put( lista.getHead().getValor(), 1 );
		while( aux.getNext() != null ) {
			prevAux = aux;
			aux = aux.getNext();
			
			if( mapa.get(aux.getValor()) == null ) {
				mapa.put( aux.getValor(), 1 );
			}
			else {
				prevAux.setNext( aux.getNext() );
				aux.setNext( null );
				aux = prevAux;
			}
		}
		
	}
	
	public static void main( String args[] ) {
		DLL listaNumeros = new DLL();
		
		NodoDLL nodo1 = new NodoDLL( 1 );
		NodoDLL nodo2 = new NodoDLL( 3 );
		NodoDLL nodo3 = new NodoDLL( 1 );
		NodoDLL nodo4 = new NodoDLL( 4 );
		NodoDLL nodo5 = new NodoDLL( 1 );
		
		
		listaNumeros.agregaAlFinal( nodo1 );
		listaNumeros.agregaAlFinal( nodo2 );
		listaNumeros.agregaAlFinal( nodo3 );
		listaNumeros.agregaAlFinal( nodo4 );
		listaNumeros.agregaAlFinal( nodo5 );
		
		listaNumeros.imprimePrincipioFin();
		removerDuplicadosEnDLL( listaNumeros );
		System.out.print( "\n" );
		listaNumeros.imprimePrincipioFin();
		

		/*
		listaNumeros.imprimePrincipioFin();
		System.out.print( "\n" );
		listaNumeros.imprimeFinPrincipio();
		System.out.print( "\n" );
		
		ArbolBinario arbolDeNumeros = new ArbolBinario();
		
		NodoArbol nodoArbol1 = new NodoArbol( 100 );
		NodoArbol nodoArbol2 = new NodoArbol( 50 );
		NodoArbol nodoArbol3 = new NodoArbol( 200 );
		NodoArbol nodoArbol4 = new NodoArbol( 10 );
		NodoArbol nodoArbol5 = new NodoArbol( 80 );
		NodoArbol nodoArbol6 = new NodoArbol( 150 );
		NodoArbol nodoArbol7 = new NodoArbol( 500 );
		
		arbolDeNumeros.agregar( nodoArbol1 );
		arbolDeNumeros.agregar( nodoArbol2 );
		arbolDeNumeros.agregar( nodoArbol3 );
		arbolDeNumeros.agregar( nodoArbol4 );
		arbolDeNumeros.agregar( nodoArbol5 );
		arbolDeNumeros.agregar( nodoArbol6 );
		arbolDeNumeros.agregar( nodoArbol7 );
		
		arbolDeNumeros.inOrder( arbolDeNumeros.getRaiz() );
		System.out.print( "\n" );
		
		NodoArbol resultado = arbolDeNumeros.buscaValor( 145 );
		if( resultado == null ) {
			System.out.println( "El valor no se encuentra en el arbol." ); 
		}
		else {
			System.out.println( "El nodo si se encuentra en el arbol: " + resultado.getValor() );
		}
		*/
	}
}

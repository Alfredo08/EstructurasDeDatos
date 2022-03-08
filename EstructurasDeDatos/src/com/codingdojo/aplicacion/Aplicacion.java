package com.codingdojo.aplicacion;

import com.codingdojo.estrucutras.*;

import java.util.Arrays;
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
	
	public static void breathTraversal( Nodo nodoRaiz ) {
		ListaEncadenada listaNodos = new ListaEncadenada();
		listaNodos.insertar( nodoRaiz );
		
		while( listaNodos.getHead() != null ) {
			Nodo nodoActual = listaNodos.removerDelFrente();
			
			System.out.print( nodoActual.getNodo().getValor() +  " - " );
			if( nodoActual.getNodo().getIzquierdo() != null ) {
				listaNodos.insertar( new Nodo(nodoActual.getNodo().getIzquierdo() ) );
			}
			if( nodoActual.getNodo().getDerecho() != null ) {
				listaNodos.insertar( new Nodo( nodoActual.getNodo().getDerecho() ) );
			}
		}
		
	}
	
	public static boolean existeInterseccion( DLL lista1, DLL lista2 ) {
		int longitudLista1 = lista1.getLength();
		int longitudLista2 = lista2.getLength();
		
		System.out.println( longitudLista1 + " " + longitudLista2 );
		
		int resultado = longitudLista1 - longitudLista2;
		
		NodoDLL aux1 = lista1.getHead();
		NodoDLL aux2 = lista2.getHead();
		int contador = 0;
		
		if( resultado > 0 ) {
			while( contador < resultado ) {
				aux1 = aux1.getNext();
				contador ++;
			}
		}
		
		if( resultado < 0 ) {
			while( contador < Math.abs( resultado ) ) {
				aux2 = aux2.getNext();
				contador ++;
			}
		}
		
		while ( aux1 != null ) {
			System.out.println( "Aux1: " + aux1.getValor() + " - Aux2: " + aux2.getValor() );
			if( aux1 == aux2 ) {
				return true;
			}
			else {
				aux1 = aux1.getNext();
				aux2 = aux2.getNext();
			}
		}
		
		return false;
		
	}
	
	public static void recorridoBinario( int numeros [], ArbolBinario arbolNumeros ) {
		if ( numeros.length != 0 ) {
			int centro = numeros.length / 2;
			// Agregar el numero del centro al arbol
			System.out.print( numeros[ centro ] + " - " );
			arbolNumeros.agregar(  new NodoArbol( numeros[ centro ] ) );
			recorridoBinario(Arrays.copyOfRange( numeros, 0, centro ), arbolNumeros);
			if( numeros.length != 1 ) {
				recorridoBinario(Arrays.copyOfRange( numeros, centro + 1, numeros.length ), arbolNumeros);
			}
		}
	}
	
	public static int cuentaNodos( NodoArbol nodo ) {
		if( nodo == null ) {
			return 0;
		}
		else {
			int nodosIzquierdo = cuentaNodos( nodo.getIzquierdo() );
			int nodosDerecho = cuentaNodos( nodo.getDerecho() );
			
			if( nodosIzquierdo - nodosDerecho >= -1 && nodosIzquierdo - nodosDerecho <= 1 ) {
				return nodosIzquierdo + nodosDerecho + 1;
			}
			else {
				return -50;
			}
			
		}
	}
	
	
	public static void main( String args[] ) {
		
		ArbolBinario arbolDeNumeros = new ArbolBinario();
		NodoArbol nodo1 = new NodoArbol( 100 );
		NodoArbol nodo2 = new NodoArbol( 50 );
		NodoArbol nodo3 = new NodoArbol( 25 );
		NodoArbol nodo4 = new NodoArbol( 60 );
		NodoArbol nodo5 = new NodoArbol( 175 );
		NodoArbol nodo6 = new NodoArbol( 180 );
		
		arbolDeNumeros.agregar( nodo1 );
		arbolDeNumeros.agregar( nodo2 );
		arbolDeNumeros.agregar( nodo3 );
		arbolDeNumeros.agregar( nodo4 );
		arbolDeNumeros.agregar( nodo5 );
		arbolDeNumeros.agregar( nodo6 );
		
		arbolDeNumeros.remover( 100 );
		arbolDeNumeros.inOrder( arbolDeNumeros.getRaiz() );
		/*
		int numeros [] = {1,2,3,4,5,6,7,8,9,10};
		ArbolBinario arbolDeNumeros = new ArbolBinario();
		
		recorridoBinario( numeros, arbolDeNumeros );
		arbolDeNumeros.agregar( new NodoArbol( 20 ) );
		arbolDeNumeros.agregar( new NodoArbol( 30 ) );
		
		System.out.print( "\n" );
		arbolDeNumeros.inOrder( arbolDeNumeros.getRaiz() );
		System.out.print( "\n" );
		System.out.println( "Numero de Nodos: " + cuentaNodos(arbolDeNumeros.getRaiz()) );
		if( cuentaNodos(arbolDeNumeros.getRaiz()) == -50 ) {
			System.out.println( "El arbol no esta balanceado" );
		}
		else {
			System.out.println( "El arbol si esta balanceado" );
		}
		
		
		DLL listaNumeros1 = new DLL();
		DLL listaNumeros2 = new DLL();
		
		NodoDLL nodo1 = new NodoDLL( 1 );
		NodoDLL nodo2 = new NodoDLL( 2 );
		NodoDLL nodo3 = new NodoDLL( 3 );
		NodoDLL nodo4 = new NodoDLL( 4 );
		NodoDLL nodo5 = new NodoDLL( 5 );
		
		listaNumeros1.agregaAlFinal( nodo1 );
		listaNumeros1.agregaAlFinal( nodo2 );
		listaNumeros1.agregaAlFinal( nodo3 );
		listaNumeros1.agregaAlFinal( nodo4 );
		listaNumeros1.agregaAlFinal( nodo5 );
		
		NodoDLL nodo6 = new NodoDLL( 6 );
		NodoDLL nodo7 = new NodoDLL( 7 );
		NodoDLL nodo8 = new NodoDLL( 8 );
		
		listaNumeros2.agregaAlFinal( nodo6 );
		listaNumeros2.agregaAlFinal( nodo7 );
		listaNumeros2.agregaAlFinal( nodo8 );
		//listaNumeros2.agregaAlFinal( listaNumeros1.getHead().getNext().getNext() );
		//listaNumeros2.setLength( 6 );
		
		boolean existe = existeInterseccion( listaNumeros2, listaNumeros1 );
		
		if( existe ) {
			System.out.println( "Las listas SI estan intersectadas!" );
		}
		else {
			System.out.println( "No existe interseccion entre las listas!" );
		}
		
		listaNumeros.imprimePrincipioFin();
		removerDuplicadosEnDLL( listaNumeros );
		System.out.print( "\n" );
		listaNumeros.imprimePrincipioFin();
		
		listaNumeros.imprimePrincipioFin();
		System.out.print( "\n" );
		listaNumeros.imprimeFinPrincipio();
		System.out.print( "\n" );
		
		ArbolBinario arbolDeNumeros = new ArbolBinario();
		
		NodoArbol nodoArbol1 = new NodoArbol( 100 );
		NodoArbol nodoArbol2 = new NodoArbol( 50 );
		NodoArbol nodoArbol3 = new NodoArbol( 25 );
		NodoArbol nodoArbol4 = new NodoArbol( 75 );
		NodoArbol nodoArbol5 = new NodoArbol( 150 );
		NodoArbol nodoArbol6 = new NodoArbol( 120 );
		NodoArbol nodoArbol7 = new NodoArbol( 200 );
		NodoArbol nodoArbol8 = new NodoArbol( 180 );
		
		arbolDeNumeros.agregar( nodoArbol1 );
		arbolDeNumeros.agregar( nodoArbol2 );
		arbolDeNumeros.agregar( nodoArbol3 );
		arbolDeNumeros.agregar( nodoArbol4 );
		arbolDeNumeros.agregar( nodoArbol5 );
		arbolDeNumeros.agregar( nodoArbol6 );
		arbolDeNumeros.agregar( nodoArbol7 );
		arbolDeNumeros.agregar( nodoArbol8 );
		
		System.out.println( "In order: " );
		arbolDeNumeros.inOrder( arbolDeNumeros.getRaiz() );
		System.out.print( "\n" );
		System.out.println( "Pre order: " );
		arbolDeNumeros.preOrder( arbolDeNumeros.getRaiz() );
		System.out.print( "\n" );
		System.out.println( "Post order: " );
		arbolDeNumeros.postOrder( arbolDeNumeros.getRaiz() );
		System.out.print( "\n" );
		System.out.println( "Breath traversal: " );
		breathTraversal( new Nodo(arbolDeNumeros.getRaiz()) );
		
		
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

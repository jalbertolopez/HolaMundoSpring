package com.beeva.app.spring.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.beeva.app.spring.core.figures.Figura;
@Component
public class Calculadora {
	@Value("${name}")
	String nombre;
	
	@Autowired
	@Qualifier("triangulo")
	Figura f;
	
	public Calculadora() {
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Figura getF() {
		return f;
	}

	public void setF(Figura f) {
		this.f = f;
	}
	
	public Calculadora(String nombre) {
		this.nombre = nombre;
	}

	public int sumar(int a, int b) {
		return a + b;
	}

	public int resta(int a, int b) {
		return a - b;
	}

	public void saludo() {
		System.out.println("***********HOLA A TODOS***********");
	}

	public void despedida() {
		System.out.println("***********ADIOS A TODOS***********");
	}

	public void pascal(int n) {

		int columnas = n + 1;
		int filas = (n * 2) + 1;
		int[][] pascal = new int[columnas][filas];
		int i;
		int j;
		for (i = 0; i < columnas; i++) {
			for (j = 0; j < filas; j++) {
				pascal[i][j] = 0;
			}
		}

		for (i = 0; i < columnas; i++) {
			for (j = (n - i); j < (columnas + i); j = j + 2) {
				if (i == 0) {
					pascal[i][j] = 1;
				} else if (i == 1) {
					pascal[i][j] = 1;
				} else {
					if (j == (n - i)) {
						pascal[i][j] = 1;
					} else if (j == columnas + i - 1) {
						pascal[i][j] = 1;
					} else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j + 1];
					}
				}

			}
		}

		for (i = 0; i < columnas; i++) {
			for (j = 0; j < filas; j++) {
				if (pascal[i][j] == 0) {
					System.out.print("\t");
				} else {
					System.out.print(pascal[i][j] + "\t");
				}
			}
			System.out.println("\n");
		}

	}
}

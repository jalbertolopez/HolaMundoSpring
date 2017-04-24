package com.beeva.app.spring.core.figures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Rectangulo implements Figura{
	@Value("${base}")
	int base;
	@Value("${altura}")
	int altura;
	@Value("${name}")
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int calculaArea() {
		// TODO Auto-generated method stub
		return base*altura;
	}
	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + ", name=" + name + "]";
	}

	
}

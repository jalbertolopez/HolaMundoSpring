package com.beeva.app.spring.core.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.spring.core.utils.Calculadora;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"core-context.xml"});
		Calculadora c = context.getBean("calculadora", Calculadora.class);
		
		System.out.println("\nArea es: "+c.getF().calculaArea());
		System.out.println("\n"+ c.getF().toString()+"\n");
		
		String url ="jdbc:mysql://localhost:3306/test";
		String userName="root";
		String password = "toor";
		String query = "SELECT * FROM empleado";
		
		
		
		try(Connection connection = DriverManager.getConnection(url, userName,password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				){
			while(rs.next()){
				System.out.println("*******************");
				System.out.println("id: "+ rs.getInt("id"));
				System.out.println("firstName: "+ rs.getString("first_name"));
				System.out.println("lastName: "+ rs.getString("last_name"));
				System.out.println("age: "+ rs.getString("age"));
			}
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		try(Connection connection = DriverManager.getConnection(url, userName,password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				){
			while(rs.next()){
				System.out.println("*******************");
				System.out.println("id: "+ rs.getInt("id"));
				System.out.println("firstName: "+ rs.getString("first_name"));
				System.out.println("lastName: "+ rs.getString("last_name"));
				System.out.println("age: "+ rs.getString("age"));
			}
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
		/*
		if(args[0].compareTo("suma")==0){
			System.out.println("resultado de la operacion es = "+ c.sumar(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
		}else if(args[0].compareTo("resta")==0){
			System.out.println("resultado de la operacion es = "+ c.resta(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
		}else if(args[0].compareTo("pascal")==0){
		   c.pascal(Integer.parseInt(args[1]));
		}else{
			System.out.println("Opcion invalida");
			
		}*/
		
		((AbstractApplicationContext) context).close();
	}
	
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

/**
 *
 * @author francisco
 */
public class Calculadora 
{
  
 /**
  * Suma de enteros : Curso 2022/2023
  * @param a primer entero
  * @param b segundo entero
  * @return La suma de a y b
  */   
 public static int sumar(int a, int b)
 {
   return(a+b);
 }
 
 /**
  * @param a valor a restar
  * @param b valor a restar
  * @return la resta de a y b
  */
 
 public static int restar(int a,int b)
 {
   return(a-b);  
 }
 
 /**
  * 
  * @param a
  * @param b
  * @return un valor entero aletario entre a y b 
  */
 public static int aleatorio(int a,int b)
 {
  return((int)(Math.random()*(b+1-a)+a));   
 }
 
}

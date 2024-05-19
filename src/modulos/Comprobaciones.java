/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobaciones {

	/**
	 * Metodo que calcula la letra de un dni.
	 * 
	 * @param dni dni del que se quiere saber la letra.
	 * @return letra del dni.
	 */
	public static char calcularLetra(int dni) {
		char caracteres[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		int resto = dni % 23;
		return caracteres[resto];
	}
        /**
         * Devuelve True si es un dni correcto de la forma : 99999999X
         * @param cad
         * @return 
         */
        
        
        public static boolean comprobarDni(String cad)
        {
          String trozo=new String();  
          char letra;
          
          if (cad.length()!=9) return(false);
          else 
          {
           trozo=cad.substring(0,8);
           char l=cad.charAt(8);
           
           if (esEntero(trozo))
            {
             if (((letra=calcularLetra(Integer.parseInt(trozo))))!=l)   
              return(false);
             else return(true);
            }
           else return(false);
          }
        }

	
	/**
	 * Metodo que comprueba si un email es correcto o no.
	 * 
	 * @param email email a comprobar
	 * @return verdadero o falso segun comprobacion.
	 */
	public static boolean comprobarEmail(String email) {
		if (email.matches("[a-zA-Z0-9._-]+[@][a-z]+[.][a-z]{2,3}")) {
			return true;
		}
		return false;
	}

	
	/**
	 * Metodo que comprueba si la cadena es un numero entero o no.
	 * 
	 * @param entero cadena de texto a comprobar
	 * @return verdadero o falso segun comprobacion.
	 */
	public static boolean esEntero(String entero) {
		if (entero.matches("-?[0-9]+")) {
			return true;
		}
		return false;
	}

	
	/**
	 * Metodo que comprueba si la cadena es un numero real o no.
	 * 
	 * @param real cadena de texto a comprobar
	 * @return verdadero o falso segun comprobacion.
	 */
	public static boolean esReal(String real) {
		if (real.matches("-?[0-9]+.[0-9]+")) {
			return true;
		}
		return false;
	}
        
        public static boolean esPrimo(int n)
        {
         return(true);   
        }
        
        public static boolean esPerfecto(int n)
        {
         return(true);   
        }     
        
        public static boolean ipValida(String cadIP)
        {
         Pattern patron=Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
         
         Matcher resultado=patron.matcher(cadIP);
         
         return(resultado.matches());
         
        }

}
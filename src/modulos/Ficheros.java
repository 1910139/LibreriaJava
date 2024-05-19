/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author francisco
 * 
 */
public class Ficheros 
{
 /**
     * Lectura de los datos de usuarios de disco
     * @param fich Fichero de datos de la tabla
     * @return true si existe el fichero - false si no existe 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static List<?> leerTabla(File fich) throws FileNotFoundException, IOException, ClassNotFoundException
    {
      List<?> tabla=null;
      
      if (fich.exists()) // Lo leemos
       {
          try (FileInputStream fIn = new FileInputStream(fich); 
               ObjectInputStream regUsuario = new ObjectInputStream(fIn)) 
          {
     
           tabla=(List<?>) regUsuario.readObject();
           fIn.close();
           regUsuario.close();
          }
         
       }
      else // No existe, lo crea
       {
         fich.createNewFile();
          //Ha sido la primera Ejecucución, no existe el fichero fich, se crea
       }
          
     return(tabla);
      
    }
    
    /**
     * Escritura de los datos de usuarios en disco
     * @param tabla Tabla leida
     * @param fich Fichero de datos de la tabla
     * @throws java.io.FileNotFoundException
     */
    public static void escribirTabla(List<?> tabla, File fich) throws FileNotFoundException, IOException
    {
        try (FileOutputStream fOut = new FileOutputStream(fich); 
             ObjectOutputStream regUsOut = new ObjectOutputStream(fOut)) {
            
            regUsOut.writeObject(tabla);
       
            regUsOut.close();
            fOut.close();
            
        }
    }
    
    
}

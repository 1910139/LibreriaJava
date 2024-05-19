/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.UIManager;

/**
 * Clase FuncionesGraficas, con funciones para mostrar....
 *
 * @author francisco
 */


public class FuncionesGraficas {

    
     	/**
	 * Metodo que muestra datos al usuario mediante una ventana.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param datos informacion a mostrar.
         *         * 
	 */
	public static void mostrarDatos(String titulo, String datos) {

                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		String[] opciones = new String[] { "Aceptar" };

		int opcion = JOptionPane.showOptionDialog(null, datos, titulo, JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, opciones, opciones[0]);
		if (opcion != 0) {
			System.exit(0);
		}
	}

  /**
   * Mensaje WARNING
   */
  public static void warning(String titulo, String datos) {

                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		String[] opciones = new String[] { "Aceptar" };

		int opcion = JOptionPane.showOptionDialog(null, datos, titulo, JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, opciones, opciones[0]);
		if (opcion != 0) {
			System.exit(0);
		}
	}      
        
        
        
     /**
     * Método utilizado para mostrar el mensaje indicado a través de una ventana con un icono del sistema.
     * @param mensaje Parámetro que recoge el texto del cuerpo de la ventana.
     * @param titulo Parámetro que recoge el texto del encabezado de la ventana.
     * @param icono Parámetro que recoge un número entero con el icono utilizado en la ventana.
     */
    
    public static void mostrarMensaje(String titulo,String mensaje, int icono) 
    {
        UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
        JOptionPane.showMessageDialog(null, mensaje, titulo, icono);
    }//fin metodo mostrarMensaje(String mensaje, String titulo, int icono)

/******************************************************************************/
	
	/**
	 * Metodo que pide un dato al usuario a traves de una ventana.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param pregunta pregunta de la ventana.
	 * @return respuesta del usuario a la ventana (null en caso de cancelar).
	 */
	public static String pedirDatos(String titulo, String pregunta) {
		//String dato;
		/*JPanel panel = new JPanel();
                                             
		JLabel preg = new JLabel(pregunta);
                                                              
		JTextField escribe = new JTextField(10);

		panel.add(preg);
		panel.add(escribe);
                */
                
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
                String[] opciones = new String[] { "Aceptar","Cancelar" };
		String opcion;
                
                             
		do {
		    opcion=JOptionPane.showInputDialog(null, pregunta, titulo, JOptionPane.QUESTION_MESSAGE);	
                    
                    //opcion = JOptionPane.showOptionDialog(null, pregunta, titulo, JOptionPane.NO_OPTION,
	            //		JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                        
			//if (opcion !=null) {
		       // dato = Integer.parseInt(opcion);
				if (opcion != null )
                                 {//&& !opcion.isEmpty()) {
					return (opcion);
				//}
				//mostrarDatos("Error", "No se ha introducido ningún argumento");
			/*} else if (opcion == 1) {
				return null;*/
			        } else return(null);//System.exit(0);
	           } while (true);
	}

	
	/**
	 * Muestra un menu con diversas opciones.
	 * 
	 * @param titulo titulo de la ventana del menu.
	 * @param opciones opciones a elegir.
	 * @param maxop numero maximo de opciones del menu.
	 * @return el posicion de la opcion elegida.
	 */
	public static int menu(String titulo, String[] opciones, int maxop) {
		int num;
		String opcion;
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		do {
                        
			opcion = JOptionPane.showInputDialog(null, opciones, titulo, JOptionPane.QUESTION_MESSAGE);
			if (opcion == null) //Si pulsamos cancelar
				//System.exit(0);
                                return(-1);

			try {
				num = Integer.parseInt(opcion);
				if (num > maxop || num < 0) {
					mostrarDatos("Opción incorrecta", "La opción elegida no corresponde con ningún valor.");
				} else
					break;
			} catch (NumberFormatException e) {
				mostrarDatos("Valor incorrecto", "Introduzca una opción válida.");
			}
		} while (true);
		return (num-1);
	}

	
	/**
	 * Metodo que genera el menu y determina la opcion escogida por el usuario.
	 * 
	 * @param titulo  titulo del menu.
	 * @param texto texto que aparece en la ventana.
	 * @param opciones  opciones del menu.
	 * @return posicion de la opcion elegida o -1 en cualquier otro caso.
	 */
	public static int menuDesplegable(String titulo, String texto, String[] opciones) {

                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		String opcion = (String) JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.QUESTION_MESSAGE, null,
				opciones, opciones[0]);

		if (opcion != null) {
			for (int i = 0; i < opciones.length; i++) {
				if (opcion.equals(opciones[i])) {
					return i;
				}
			}
		}
		return -1;
	}

        public static String desplegable(String titulo,String texto, String[] opciones)
        {
         //  String opcion= JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.QUESTION_MESSAGE, null,
	//			opciones, opciones[0]);
         //  return(opcion);
          UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
          return((String) JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.QUESTION_MESSAGE, null,
				opciones, opciones[0]));   
        }
                
	
	/**
	 * Metodo que pide una confirmacion al usuario mediante una ventana.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param texto texto incluido en la ventana.
	 * @return verdadero o falso segun confirmacion del usuario.
	 */
	public static boolean pedirBool(String titulo, String texto) {
		JPanel panel = new JPanel();
		JLabel infor = new JLabel(texto);
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));

		panel.add(infor);
		String[] opcs = new String[] { "Si", "No" }; // Botones

		int opcion = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[0]);

		if (opcion == 0) {
			return true;
		} else if (opcion != 1) {
			System.exit(0);
		}
		return false;
	}

	
	/**
	 * Metodo que pide un numero entero al usuario.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param pregunta pregunta que se le hace al usuario.
	 * @return numero entero y -1 en caso de pulsar cancelar.
	 */
	public static int pedirEntero(String titulo, String pregunta) {
		int numero;
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		do {
			try {
				String conversion = pedirDatos(titulo, pregunta);
                                if (conversion != null) {
					numero = Integer.parseInt(conversion);
					return numero;
				}/* else
					return -1;*/
			} catch (NumberFormatException e) {
				mostrarDatos("Error", "Datos introducidos incorrectamente.");
			}
		} while (true);
	}

	
	/**
	 * Metodo que pide un numero en coma flotante al usuario.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param pregunta pregunta que se le hace al usuario.
	 * @return numero en coma flotante y -1 en caso de pulsar cancelar.
	 */
	public static float pedirFloat(String titulo, String pregunta) {
		float numero;
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		do {
			try {
				String conversion = pedirDatos(titulo, pregunta);
				if (conversion != null) {
					numero = Float.parseFloat(conversion);
					return numero;
				}/* else
					return -1;*/
			} catch (NumberFormatException e) {
				mostrarDatos("Error", "Datos introducidos incorrectamente.");
			}
		} while (true);
	}

	
	/**
	 * Metodo que pide un numero en double al usuario.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param pregunta pregunta que se le hace al usuario.
	 * @return numero double y -1 en caso de pulsar cancelar.
	 */
	public static double pedirDouble(String titulo, String pregunta) {
		double numero;
                UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
		do {
			try {
				String conversion = pedirDatos(titulo, pregunta);
				if (conversion != null) {
					numero = Double.parseDouble(conversion);
					return numero;
				} /*else
					return -1;*/
			} catch (NumberFormatException e) {
				mostrarDatos("Error", "Datos introducidos incorrectamente.");
			}
		} while (true);
	}
        
         /**
 * Método auxiliar utilizado para generar barras de porcentaje con las que representar
 * datos estadísticos.
 * Cada 5% de porcentaje, se sumará un símbolo # (donde 100% = ####################).
     * @param valor Parámetro que indica el valor en porcentaje que se quiere representar.
     * @return Devuelve una cadena de texto con el símbolo # que representa gráficamente el porcentaje.
     */

    public static String barraPorcentaje(int valor)
    {
        String porcentaje = new String();
        String aumento = "#";

        for(int i = 0; i < valor/5; i++)
        {
            porcentaje = porcentaje + aumento;
        }
    
        return porcentaje;
    }// fin metodo barraPorcentaje(int valor)

/******************************************************************************/

/**
 * Función para sacar una ventana con imagen y texto
 * @param titulo Título de la Ventana
 * @param nomFichero nombre de la imagen
 * @param texto Texto en la ventana
 * @param factorEscalado valor : 1 -> tamaño original
 * @param full true si queremos pantalla completa
 */        
    
    
  public static void FotoyMensaje(String titulo, String nomFichero,String texto, double factorEscalado, boolean full )
 {
   
   JPanel panel=new JPanel();
   
   
   if (full)
   {
   // Obtener las dimensiones de la pantalla
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int anchoPantalla = screenSize.width;
   int altoPantalla = screenSize.height - 50;
   UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
  
   
   //panel.setLocation(1280/2,1024/2);
   //panel.setSize(200,100);
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
      
   JLabel foto=new JLabel();
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
   
    
   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);
    
   JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
   
   
   
 }
 
  /**
   * 
   * @param titulo
   * @param nomFichero
   * @param pregunta
   * @param factorEscalado
   * @param full
   * @return 
   */
  public static String FotoYPedirDatos(String titulo, String nomFichero,String pregunta, double factorEscalado, boolean full )
 {
   
   JPanel panel=new JPanel();
   
   if (full)
   {
    // Obtener las dimensiones de la pantalla
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int anchoPantalla = screenSize.width;
    int altoPantalla = screenSize.height - 50;
    UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
   
   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
      
   JLabel foto=new JLabel();
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
   
   
      
   return((String)JOptionPane.showInputDialog(panel, pregunta, titulo, PLAIN_MESSAGE, icono, null, null));
           
 }
 
  
  
 /**
  * Función para sacar texto, imagen y opciones posibles
  * @param titulo Titulo de la ventana
  * @param opciones Opciones posibles
  * @param nomFichero Fichero de imagen
  * @param texto Texto de la Imagen
  * @param factorEscalado Escalado de la imagen, 1 = tamaño original
  * @return Opción elegida en orden, valor entero
  */ 
  
  public static int FotoMensajeMenu(String titulo,String[] opciones, String nomFichero,String texto, double factorEscalado, boolean full )
 {
   JPanel panel=new JPanel();
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
   
   int valor=0;
      
   JLabel foto=new JLabel();
   
    if (full)
   {
   // Obtener las dimensiones de la pantalla
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int anchoPantalla = screenSize.width;
   int altoPantalla = screenSize.height - 50;
   UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
   
   
   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);
   
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
    
   //JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
   
   Object[] possibleValues = opciones;

   //
   //   { "First", "Second", "Third" };

   Object selectedValue = JOptionPane.showInputDialog(panel,texto,titulo,JOptionPane.INFORMATION_MESSAGE, icono,possibleValues, possibleValues[0]);
   
   
   for(int i=0;i<opciones.length;i++)
    if (selectedValue.equals(opciones[i])) valor=i;
   
   return(valor);
      
 }
  
   /**
  * Función para sacar texto, imagen, opciones posibles y audio
  * @param titulo Titulo de la ventana
  * @param opciones Opciones posibles
  * @param nomFichero Fichero de imagen
  * @param texto Texto de la Imagen
  * @param nombreAudio Fichero .wav a reproducir
  * @param factorEscalado Escalado de la imagen, 1 = tamaño original
  * @param tipoSonido 0 para wav 1 para MP3
  * @return Opción elegida en orden, valor entero
  * @full true si queremos pantalla completa
  */ 
  
   public static int FotoMensajeMenuSonido(String titulo,String[] opciones, String nomFichero,String texto, String nombreAudio,double factorEscalado,int tipoSonido, boolean full )
 {
   JPanel panel=new JPanel();
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
   
   FuncionesSonidos sonido=new FuncionesSonidos(nombreAudio,tipoSonido);
   
   int valor=0;
      
   JLabel foto=new JLabel();
   
     if (full)
   {
   // Obtener las dimensiones de la pantalla
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int anchoPantalla = screenSize.width;
   int altoPantalla = screenSize.height - 50;
   UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
   
   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);
   
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
    
   //JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
       
   if (tipoSonido==0) sonido.reproducirSonidoWav();
   else sonido.reproducirSonidoMp3(nombreAudio);
   
   Object[] possibleValues = opciones;

   //
   //   { "First", "Second", "Third" };

   Object selectedValue = JOptionPane.showInputDialog(panel,texto,titulo,JOptionPane.INFORMATION_MESSAGE, icono,possibleValues, possibleValues[0]);
   
   
   for(int i=0;i<opciones.length;i++)
    if (selectedValue.equals(opciones[i])) valor=i;
   
   if (tipoSonido==0) sonido.pararSonidoWav();
   else sonido.pausarSonidoMp3();

   
   return(valor);
   
  }
  
    /**
  * Función para sacar texto, imagen y audio
  * @param titulo Titulo de la ventana
  * @param nomFichero Fichero de imagen
  * @param texto Texto de la Imagen
  * @param nombreAudio Fichero .wav a reproducir
  * @param factorEscalado Escalado de la imagen, 1 = tamaño original
  * @param tipoSonido 0 para wav 1 para MP3
  * @param full para tamaño completo de pantalla
  * @return nada
  */ 
  public static void FotoMensajeSonido(String titulo,String nomFichero,String texto, String nombreAudio,double factorEscalado, int tipoSonido, boolean full )
  {
   JPanel panel=new JPanel();
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
   
   FuncionesSonidos sonido=new FuncionesSonidos(nombreAudio,tipoSonido);
        
   JLabel foto=new JLabel();
   
   if (full)
   {
   // Obtener las dimensiones de la pantalla
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int anchoPantalla = screenSize.width;
   int altoPantalla = screenSize.height - 50;
   UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
    
   //JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
   
   if (tipoSonido==0) sonido.reproducirSonidoWav();
   else sonido.reproducirSonidoMp3(nombreAudio);
   
 
   //sonido.reproducirSonido(nombreAudio);
   JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
   //sonido.pararSonido();
           
   if(tipoSonido==0) sonido.pararSonidoWav();
   else sonido.pararSonidoMp3();
 
   
  }

/**
 * 
 * @param titulo Titulo de la venta
 * @param nomFichero Ruta del Fichero con la imagen
 * @param pregunta Texto dela pregunta
 * @param nombreAudio Ruta donde está el fichero de audio
 * @param factorEscalado Escalado de la imagen, 1 tamaño original
 * @param tipoSonido 0 para Wav 1 para MP3
 * @param full para tamaño completo de ventana
 * @return 
 */
public static String FotoPedirDatosYSonido(String titulo,String nomFichero,String pregunta, String nombreAudio,double factorEscalado, int tipoSonido, boolean full )
  {
   JPanel panel=new JPanel();
   
   File fichero=new File(nomFichero);
   
   ImageIcon icon = new ImageIcon(fichero.toString());
   
   Icon icono;
   
   FuncionesSonidos sonido=new FuncionesSonidos(nombreAudio,tipoSonido);
        
   JLabel foto=new JLabel();
   
   if (full)
   {
    // Obtener las dimensiones de la pantalla
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int anchoPantalla = screenSize.width;
    int altoPantalla = screenSize.height - 50;
    UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
   
   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);
   
   
   //foto.setSize(ancho, alto);
  
   //if (escalado) icono = new ImageIcon(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
   //else icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*0.5), (int)((double)icon.getIconHeight()*0.5), Image.SCALE_DEFAULT));
   
  
   icono = new ImageIcon(icon.getImage().getScaledInstance((int)((double)icon.getIconWidth()*factorEscalado), (int)((double)icon.getIconHeight()*factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon( icono );   
   
   panel.add(foto);
    
   //JOptionPane.showMessageDialog(panel, texto, titulo , PLAIN_MESSAGE, icono);
   
   if (tipoSonido==0) sonido.reproducirSonidoWav();
   else sonido.reproducirSonidoMp3(nombreAudio);
   
 
   //sonido.reproducirSonido(nombreAudio);
   String respuesta=(String)JOptionPane.showInputDialog(panel, pregunta, titulo , PLAIN_MESSAGE, icono,null,null);
   //sonido.pararSonido();
           
   if(tipoSonido==0) sonido.pararSonidoWav();
   else sonido.pararSonidoMp3();
 
   return(respuesta);
   
  }
  /**
   * Función para dibujar una ventana que se cierra a los segundos pasado por parámetro, si pulsamos tecla Aceptar se cierra antes
   * @param titulo
   * @param nomFichero
   * @param texto
   * @param nombreAudio
   * @param segundos Tiempo para que se cierre la ventana
   * @param factorEscalado
   * @param tipoSonido
   * @param full ture para pantalla completa
   */
  public static void FotoMensajeSonidoAutomatica(String titulo, String nomFichero, String texto, String nombreAudio, int segundos, double factorEscalado, int tipoSonido, boolean full)
  {
   if (full)
   {
    // Obtener las dimensiones de la pantalla
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int anchoPantalla = screenSize.width;
    int altoPantalla = screenSize.height - 50;
    UIManager.put("OptionPane.minimumSize", new Dimension(anchoPantalla, altoPantalla));
   }
   else UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));

   JPanel panel = new JPanel();
   File fichero = new File(nomFichero);
   ImageIcon icon = new ImageIcon(fichero.toString());
   Icon icono;
   
   FuncionesSonidos sonido = new FuncionesSonidos(nombreAudio, tipoSonido);
   
   JLabel foto = new JLabel();
   icono = new ImageIcon(icon.getImage().getScaledInstance((int) ((double) icon.getIconWidth() * factorEscalado), (int) ((double) icon.getIconHeight() * factorEscalado), Image.SCALE_DEFAULT));
   foto.setIcon(icono);
   panel.add(foto);

   if (tipoSonido == 0) {
     sonido.reproducirSonidoWav();
    } else {
     sonido.reproducirSonidoMp3(nombreAudio);
    }

   // Centrar la ventana en la pantalla
   JOptionPane.getRootFrame().setLocationRelativeTo(null);

   // Crear un JOptionPane personalizado sin botones
   JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{"Omitir"}, null);
   JDialog dialog = optionPane.createDialog(titulo);
   dialog.setModal(true);

   Timer timer = new Timer();
   timer.schedule(new TimerTask() {
   @Override
   public void run() {
      dialog.dispose();
      
     }
   }, segundos * 1000); // Tiempo de segundos a milisegundos
     
   dialog.setVisible(true);
   
   if (tipoSonido == 0) {
    sonido.pararSonidoWav();
    } else {
     sonido.pararSonidoMp3();
    }
   
   }

  
 }
   
   
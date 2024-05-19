/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import clases.Usuario;

public class GestionUsuarios {

    /**
     * @return the usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
	private ArrayList<Usuario> usuarios=new ArrayList<>();
	private Usuario activo;

        
        /**
         * Constructor para crear usuario inicial
         * @param us : usuario
         * @param p : contraseña
         * @param nivel : valor entero
         * @return nada
         */
	public void AñadirUsuario(String us,String p, int nivel) {
		Usuario usa = new Usuario(us,p,nivel);
		getUsuarios().add(usa);
                            
	}

	/**
	 * Metodo que da de alta a un usuario pidiendo sus datos.
	 */
	public void altaUsuario() {
		String usuario = FuncionesGraficas.pedirDatos("Dar de Alta", "Usuario : ");
                
		if (usuario != null) {
			String contra;
			int nivel = 0;

			if (busquedaNombre(usuario) == -1) {
				contra = pedirContra("Dar de Alta", "Contraseña : ");
				if (contra != null) {
					nivel = pedirNivel("Dar de Alta");

					if (nivel != -1) {
						Usuario nuevo = new Usuario(usuario, contra, nivel);
						getUsuarios().add(nuevo);
					} else
						FuncionesGraficas.mostrarDatos("Alta no realizada", "Operación cancelada.");
				} else
					FuncionesGraficas.mostrarDatos("Alta no realizada", "Operación cancelada.");
			} else {
				FuncionesGraficas.mostrarDatos("Alta no realizada", "El nombre de usuario no se encuentra disponible.");
			}
		} else
			FuncionesGraficas.mostrarDatos("Alta no realizada", "Operación cancelada.");
	}

	
	/**
	 * Metodo que da de baja a un usuario, pidiendo al gestor que introduzca el nombre.
	 * 
	 */
	public void bajaUsuario() {
		String usuario = FuncionesGraficas.pedirDatos("Dar de baja", "Usuario : ");
		if (usuario != null) {
			int posicion = busquedaNombre(usuario);

			if (posicion != -1) {
				getUsuarios().remove(posicion);
				FuncionesGraficas.mostrarDatos("Baja realizada", "Usuario " + usuario + " eliminado con éxito.");
			} else {
				FuncionesGraficas.mostrarDatos("Baja no realizada",
						"El nombre de usuario no se encuentra en la base de datos.");
			}
		}
		FuncionesGraficas.mostrarDatos("Baja no realizada", "Operación cancelada.");

	}
              

        /**
	 * Metodo que da de baja a un usuario por nick
	 * 
	 */
	public void bajaUsuario(String nick) {
		

			int posicion = busquedaNombre(nick);
                        
                        //System.out.println("USaurioa dar de baja " + nick);

			if (posicion != -1) {
                                String usuario=usuarios.get(posicion).getNombre();
				usuarios.remove(posicion);
				FuncionesGraficas.mostrarDatos("Baja realizada", "Usuario " + usuario + " eliminado con éxito.");
			} else {
				FuncionesGraficas.mostrarDatos("Baja no realizada",
						"El nombre de usuario no se encuentra en la base de datos.");
			}
		}
		
	
	/**
	 * Metodo que pide el nivel del usuario.
	 * 
	 * @param titulo de la ventana.
	 * @return (0) Administrador, (1) Usuario, (-1) Cancelar.
	 */
	public int pedirNivel(String titulo) {

		JPanel panel = new JPanel();
		JLabel preg = new JLabel("Selecciona un nivel: ");
		JRadioButton admin = new JRadioButton("Administrador", true);
		JRadioButton user = new JRadioButton("Usuario", false);

		panel.add(preg);
		panel.add(admin);
		panel.add(user);

		ButtonGroup grupobotones = new ButtonGroup();
		grupobotones.add(admin);
		grupobotones.add(user);

		String[] opciones = new String[] { "Aceptar", "Cancelar" };

		int opcion = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		if (opcion == 0) {
			if (admin.isSelected()) {
				return 0;
			} else if (user.isSelected()) {
				return 1;
			}
		} else if (opcion != 1) {
			System.exit(0);
		}
		return -1;

	}

	
	/**
	 * Metodo que cambia el usuario activo del programa.
	 */
	public void cambioUsuario() {
		String nuevousuario = FuncionesGraficas.pedirDatos("Introduce el nuevo usuario", " Usuario : ");
		if (nuevousuario != null) {
			int posicion = busquedaNombre(nuevousuario);
			if (posicion != -1) {
				String contra = pedirContra("Introduce la contraseña del nuevo usuario", " Contraseña : ");
				if (contra != null) {
					if (getUsuarios().get(posicion).getContraseña().equals(contra)) {
						activo = getUsuarios().get(posicion);
						FuncionesGraficas.mostrarDatos("Nuevo usuario: " + getActivo().getNombre(),
								"Cambio realizado con éxito");
					} else
						FuncionesGraficas.mostrarDatos("Error", "La contraseña no coincide.");
				} else
					FuncionesGraficas.mostrarDatos("Cambio no realizado", "Operación cancelada.");
			} else
				FuncionesGraficas.mostrarDatos("Error", "El usuario no existe");
		} else
			FuncionesGraficas.mostrarDatos("Cambio no realizado", "Operación cancelada.");
	}

	
	/**
	 * Metodo que modifica el nombre y la contraseña de un usuario
	 */
	public void modificar() {
		String usuario = FuncionesGraficas.pedirDatos("Consultar Usuario", "Usuario : ");
		if (usuario != null) {
			int nivel;
			String nuevacontra;
			int posicion = busquedaNombre(usuario);

			if (posicion != -1) {
				nuevacontra = nuevaContra();
				if (nuevacontra != null) {
					nivel = pedirNivel("Nuevo nivel");

					if (nivel != -1) {
						getUsuarios().get(posicion).setContraseña(nuevacontra);
						getUsuarios().get(posicion).setNivel(nivel);
						FuncionesGraficas.mostrarDatos("Modificación realizada",
								"Usuario " + usuario + " modificado con éxito.");
					} else
						FuncionesGraficas.mostrarDatos("Modificación no realizada", "Operación cancelada.");
				} else
					FuncionesGraficas.mostrarDatos("Modificación no realizada", "Operación cancelada.");
			} else
				FuncionesGraficas.mostrarDatos("Error", "El nombre de usuario no se encuentra registrado.");

		} else
			FuncionesGraficas.mostrarDatos("Modificación no realizada", "Operación cancelada.");
	}

	
	/**
	 * Metodo que devuelve la posicion del usuario buscado por nombre.
	 * 
	 * @param nombre nombre a buscar.
	 * @return posicion del usuario.
	 */
	public int busquedaNombre(String nombre) {
		for (int i = 0; i < getUsuarios().size(); i++) {
			if (getUsuarios().get(i).getNombre().equals(nombre))
				return i;
		}
		return -1;
	}

	
	/**
	 * Metodo que devuelve la posicion del usuario buscado por nombre y contraseña.
	 * 
	 * @param nombre nombre a buscar.
	 * @param contra contraseña del usuario
	 * @return posicion del usuario.
	 */
	public int busqueda(String nombre, String contra) {
		for (int i = 0; i < getUsuarios().size(); i++) {
			if (getUsuarios().get(i).getNombre().equals(nombre) && getUsuarios().get(i).getContraseña().equals(contra))
				return i;
		}
		return -1;
	}
	
	
	/**
	 * Metodo que muestra el nombre y nivel del usuario activo en el momento.
	 * 
	 */
	public void usuarioActivo() {
		if(getActivo() == null) {
			FuncionesGraficas.mostrarDatos("Usuario activo", "En estos momentos, ningún usuario esta activo.");
		}
		else if(getActivo().getNivel() == 0) FuncionesGraficas.mostrarDatos("Usuario activo", "Usuario :" + getActivo().getNombre() +"  Nivel: Administrador");
		else FuncionesGraficas.mostrarDatos("Usuario activo", "Usuario :" + getActivo().getNombre() + "  Nivel: Usuario");
	}
	
	
	/**
	 * Metodo para controlar el acceso a la aplicacion con intentos.
	 * 
	 * @return verdadero o falso si la contraseña coincide.
	 */
        
        //PARAMETRIZAR
	public boolean contraseñaIntentos() {
		int contador = 0, opcion;

		JPanel panel = new JPanel();
		JLabel etiquetanombre = new JLabel("Nombre: ");
		JTextField nom = new JTextField(10);
		JLabel etiquetacontra = new JLabel("Contraseña: ");
		JPasswordField password = new JPasswordField(10);
		JLabel mensaje = new JLabel("(Quedan 3 intentos)");

		panel.add(etiquetanombre);
		panel.add(nom);
		panel.add(etiquetacontra);
		panel.add(password);
		panel.add(mensaje);

		String[] opciones = new String[] { "Aceptar" };

		do {
			opcion = JOptionPane.showOptionDialog(null, panel, "Introduzca la contraseña", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

			if (opcion == 0) { // Al pulsar Aceptar, introduces password.
				String nombre = new String(nom.getText());
				String psswd = new String(password.getPassword());
				int posicion = 	busqueda(nombre, psswd);
				if (posicion != -1){
					activo = getUsuarios().get(posicion);
					return (true);
				} else {
					contador++;
                                        nom.setText("");
					password.setText("");

					if (contador != 2) {
						mensaje.setText("(Quedan " + (3 - contador) + " intentos)");
					} else {
						mensaje.setText("(Queda " + (3 - contador) + " intento)");
					}

					if (contador == 3) {
						return (false);
					}
				}

			} else {
				System.exit(0);
			}
		} while (true);

	}

	/**
	 * Metodo para introducir una contraseña.
	 * 
	 * @param titulo titulo de la ventana.
	 * @param texto texto de la ventana.
	 * @return contraseña introducida.
	 */
	public String pedirContra(String titulo, String texto) {
		JPanel panel = new JPanel();

		JLabel ps1 = new JLabel(texto);
		JPasswordField pass1 = new JPasswordField(10);

		panel.add(ps1);
		panel.add(pass1);

		String[] opciones = new String[] { "Aceptar", "Cancelar" };
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (opcion == 0) { // Al pulsar el botón Aceptar
				String contra1 = new String(pass1.getPassword());

				if (!contra1.isEmpty()) {
					return (contra1);
				} else {
					FuncionesGraficas.mostrarDatos("Error", "Introduzca una contraseña por favor.");
				}
			} else if (opcion == 1) { // Al pulsar el botón Cancelar
				return null;
			} else { // Al pulsar X
				System.exit(0);
			}
		} while (true);
	}

	/**
	 * Metodo para cambiar la contraseña de un usuario.
	 * 
	 * @return nueva contraseña o null en caso de cancelar.
	 */
	public String nuevaContra() {
		JPanel panel = new JPanel();

		JLabel ps1 = new JLabel("Contraseña : ");
		JPasswordField pass1 = new JPasswordField(10);
		JLabel ps2 = new JLabel("Repite contraseña : ");
		JPasswordField pass2 = new JPasswordField(10);

		panel.add(ps1);
		panel.add(pass1);
		panel.add(ps2);
		panel.add(pass2);

		String[] opciones = new String[] { "Aceptar", "Cancelar" };

		int opcion = JOptionPane.showOptionDialog(null, panel, "Nueva contraseña de usuario", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
		if (opcion == 0) { // Al pulsar el botón Aceptar
			char[] password1 = pass1.getPassword();
			String contra1 = new String(password1);

			char[] password2 = pass2.getPassword();
			String contra2 = new String(password2);

			if (contra1.equals(contra2)) {
				return (contra1);
			} else {
				FuncionesGraficas.mostrarDatos("Error", "No coinciden las contraseñas");
				return null;
			}
		} else if (opcion != 1) { // Al pulsar X
			System.exit(0);
		}
		return null; // Al pulsar el botón Cancelar o si no coinciden contraseñas
	}

	
	/**
	 * Metodo para controlar el acceso.
	 *
	 *@param titulo titulo de la ventana. 
	 * @return posicion, -1 en caso de no encontrar coincidencias y -2 en caso de no introducir datos.
	 */
	public int acceso(String titulo) {

		JPanel panel = new JPanel();
		JLabel etiquetanombre = new JLabel("Nombre: ");
		JTextField nom = new JTextField(10);
		JLabel etiquetacontra = new JLabel("Contraseña: ");
		JPasswordField password = new JPasswordField(10);

		panel.add(etiquetanombre);
		panel.add(nom);
		panel.add(etiquetacontra);
		panel.add(password);

		String[] opciones = new String[] { "Aceptar", "Cancelar" };

		int	opcion = JOptionPane.showOptionDialog(null, panel,titulo, JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

		if (opcion == 0) { // Al pulsar Aceptar, introduces password.
			String nombre = nom.getText();
			String psswd = new String(password.getPassword());
			if (nombre != null && psswd != null){ 			
				return busqueda(nombre, psswd);
			}
			else {
				FuncionesGraficas.mostrarDatos("Error","No se han introducido datos.");
				return -2;
			}		
		} else if (opcion != 1) {
			System.exit(0);
		}
		return -1;
	}
   /**
    * ver String con el nombre del usuario activo actual
    * ( obtenido de contraseña() )
    * @return usuario activo actual 
    **/
   public String nombreUsuActivo()
   {
     return(getActivo().getNombre());  
   }
   
   /**
    * Devuelve el nivel del Usuario activo
    * @return 0 Administrador 1 Usuario
    */
   public int nivelUsuActivo()
   {
     return(getActivo().getNivel());   
   }

   /**
    * Posición del usuario activo
    */
   public int posUsuarioActivo()
   {
    return(busquedaNombre(getActivo().getNombre()));   
   }
      
    /**
     * @return the activo
     */
    public Usuario getActivo() {
        return activo;
    }
    
    public void setActivo(int n)
    {
     activo=getUsuarios().get(n);
    }
       
    public int posActivo()
    {
     return(getUsuarios().indexOf(nombreUsuActivo()));   
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FuncionesFechas {

	/**
	 * Metodo para crear una fecha.
	 * 
	 * @param titulo titulo de la ventana.
	 * @return fecha creada, null en caso contrario.
	 */
	public static GregorianCalendar crearFecha(String titulo) {

		JPanel panel = new JPanel();
		JLabel dia = new JLabel("Día : ");
		JTextField d = new JTextField(2);
		JLabel mes = new JLabel("   Mes : ");
		JTextField m = new JTextField(2);
		JLabel año = new JLabel("   Año : ");
		JTextField a = new JTextField(4);

		int numd = 0;
		int numm = 0;
		int numa = 0;

		panel.add(dia);
		panel.add(d);
		panel.add(mes);
		panel.add(m);
		panel.add(año);
		panel.add(a);

		String[] opciones = new String[] { "Aceptar", "Cancelar" };
		boolean correcta = false;

		do {
			int opcion = JOptionPane.showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
			if (opcion == 0) {
				try {

					numd = Integer.parseInt(d.getText());
					numm = Integer.parseInt(m.getText());
					numa = Integer.parseInt(a.getText());

					if (fechaCorrecta(numd, numm, numa)) {
						correcta = true;
					} else {
						FuncionesGraficas.mostrarDatos("Fecha inválida", "La fecha introducida no es válida.");
					}

				} catch (NumberFormatException e) {
					FuncionesGraficas.mostrarDatos("Error de conversión", "La fecha introducida no es correcta.");
				}

				d.setText("");
				m.setText("");
				a.setText("");
			} else if (opcion == 1) {
				return null;
			} else {
				System.exit(0);
			}

		} while (!correcta);

		GregorianCalendar fecha = new GregorianCalendar(numa,numm-1,numd);
                return fecha;
	}

	
	/**
	 * Metodo que calcula la edad mediante una fecha.
	 * 
	 * @param fecha fecha de la que se quiere conocer la edad
	 * @return edad calculada
	 */
	public static int calculaEdad(GregorianCalendar fecha) {
		GregorianCalendar fechaactual = new GregorianCalendar();
		int años = fechaactual.get(GregorianCalendar.YEAR)-fecha.get(GregorianCalendar.YEAR);
		
                if (fechaactual.get(GregorianCalendar.MONTH) < fecha.get(GregorianCalendar.MONTH)) {
			años--;
		} else if (fechaactual.get(GregorianCalendar.MONTH) == fecha.get(GregorianCalendar.MONTH)) {
			if (fechaactual.get(GregorianCalendar.DATE) < fecha.get(GregorianCalendar.DATE)) {
				años--;
			}
		}
		return años;
	}

	
	/**
	 * Metodo que comprueba si una fecha esta en un rango de fechas.
	 * 
	 * @param fechaInicio fecha inicial del rango.
	 * @param fechaFin fecha final del rango.
	 * @param fecha fecha a comprobar.
	 * @return verdadero si esta en el rango, falso en caso contrario.
	 */
	public static boolean fechaRango(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, GregorianCalendar fecha) {
            
                if (fechaInicio.after(fechaFin)) return(false);
                
                if (((fechaInicio.before(fecha)) && ((fechaFin.after(fecha)))) 
                   ||
                   ( (fecha.get(GregorianCalendar.YEAR)==fechaInicio.get(GregorianCalendar.YEAR))
                      &&
                     (fecha.get(GregorianCalendar.MONTH)==fechaInicio.get(GregorianCalendar.MONTH))
                      &&
                     (fecha.get(GregorianCalendar.DAY_OF_MONTH)==fechaInicio.get(GregorianCalendar.DAY_OF_MONTH)))) return true;
		else return false;
		
	}

	
	/**
	 * Metodo para comprobar si una fecha es correcta o no.
	 * 
	 * @param dia es el dia de la fecha a comprobar.
	 * @param mes es el dia del mes a comprobar.
	 * @param año es el dia del año a comprobar.
	 * @return verdadero o falso si la fecha es correta.
	 */
	public static boolean fechaCorrecta(int dia, int mes, int año) {
		if (año > 0) {
			if (mes == 2) { // Mes de Febrero
				if (dia > 0 && dia <= 28) {
					return true;
				} else if (dia == 29) {
					return esBisiesto(año);
				} else {
					return false;
				}
			} else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) { 
				// Meses de 31 días
				if (dia > 0 && dia <= 31) {
					return true;
				}
			} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // Meses de 30 días
				if (dia > 0 && dia <= 30) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	
	/**
	 * Metodo para calcular si un año es bisiesto.
	 * 
	 * @param año es el año del que se desea preguntar.
	 * @return verdadero o falso si es bisiesto.
	 */
	public static boolean esBisiesto(int año) {
		return (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));
	}

	
	/**
	 * Metodo para dar formato a una fecha.
	 * 
	 * @param fecha fecha a la que queremos dar formato.
	 * @return fecha en dd - mm - yyyy.
	 */
	public static String formatoFecha(GregorianCalendar fecha){
                //String cadena = fecha.get(fecha.DAY_OF_MONTH) + "-" + fecha.get(fecha.MONTH) + "-" + fecha.get(fecha.YEAR);
		SimpleDateFormat ffecha = new SimpleDateFormat("dd-MM-yyyy");
                String cadena = ffecha.format(fecha.getTime());
                return(cadena);
                                
	}
}
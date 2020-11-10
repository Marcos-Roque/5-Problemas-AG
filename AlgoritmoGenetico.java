package genetico;

import java.util.Random;
import java.util.Scanner;

public class AlgoritmoGenetico {
	
	static int filas = 6;
	static int columnas = 5;
	static int Numganadores = 3;

	static String[][] poblacion = new String[filas][columnas];
	static String[][] poblacionTemp = new String[filas][columnas];
	static String[] parejas = new String[filas];
	static String[] ganadores = new String[Numganadores];
	static double sumatoria = 0;

	public static void main(String[] args) {
		Scanner op = new Scanner(System.in);
		int i = 0;
		while(i < 6 ) {
	    	String menu = "\n____________________Menu Problemas____________________\n"
					+ "1.Ejemplo 1: Demanda de producto\n"
					+ "2.Ejemplo 2: Administracion del transporte publico\n"
					+ "3.Ejemplo 3: Administracion del inventario\n"
					+ "4.Ejemplo 4: Minimizacion del costo promedio por unidad\n"
					+ "5.Ejemplo 5: Asignacion de la fuerza de ventas\n";
	    	System.out.println(menu);
			int opc = op.nextInt();
			menuProblema(opc);
			i++;
		}
		op.close();
    }
    
    public static void menuProblema(int opc) {
    	switch (opc) {
		case 1:
			llamarFuncion1();
			System.out.println("______________________Termina Opcion 1___________________________");
			break;
		case 2:
			llamarFuncion2();
			System.out.println("______________________Termina Opcion 2___________________________");
			break;
		case 3:
			llamarFuncion3();
			System.out.println("______________________Termina Opcion 3___________________________");
			break;
		case 4:
			llamarFuncion4();
			System.out.println("______________________Termina Opcion 4___________________________");
			break;
		case 5:
			llamarFuncion5();
			System.out.println("______________________Termina Opcion 5___________________________");
			break;
		}
    }
	//Metodo Llamar Funcion Ejemplo 1
	public static void llamarFuncion1() {
		poblacionInicial(poblacion);
		verpoblacion(poblacion, false);
		double adaptados = 0;
		while (adaptados < 1000) {
			genesIndividuo(poblacion);
			adaptados = mejorAdaptado_f1(poblacion);
			adaptabilidad(poblacion, sumatoria);
			verpoblacion(poblacion, true);
			seleccionparejas(poblacion);
			torneoIndividuos(poblacion);
			verganadores(ganadores);
			clonarMejorIndividuos(poblacion, poblacionTemp);
			verpoblacion(poblacionTemp, true);
			seleccionparejas(poblacion);
			combinacionMutacion(poblacion, poblacionTemp);
		}
		adaptados = mejorAdaptado_f1(poblacion);
		verpoblacion(poblacion, false);
	}
	//Metodo Llamar Funcion Ejemplo 2
		public static void llamarFuncion2() {
			poblacionInicial(poblacion);
			verpoblacion(poblacion, false);
			double adaptados = 0;
			while (adaptados < 1000) {
				genesIndividuo(poblacion);
				adaptados = mejorAdaptado_f2(poblacion);
				adaptabilidad(poblacion, sumatoria);
				verpoblacion(poblacion, true);
				seleccionparejas(poblacion);
				torneoIndividuos(poblacion);
				verganadores(ganadores);
				clonarMejorIndividuos(poblacion, poblacionTemp);
				verpoblacion(poblacionTemp, true);
				seleccionparejas(poblacion);
				combinacionMutacion(poblacion, poblacionTemp);
			}
			adaptados = mejorAdaptado_f2(poblacion);
			verpoblacion(poblacion, false);
		}
		//Metodo Llamar Funcion Ejemplo 3
		public static void llamarFuncion3() {
			poblacionInicial(poblacion);
			verpoblacion(poblacion, false);
			double adaptados = 0;
			while (adaptados < 1000) {
				genesIndividuo(poblacion);
				adaptados = mejorAdaptado_f3(poblacion);
				adaptabilidad(poblacion, sumatoria);
				verpoblacion(poblacion, true);
				seleccionparejas(poblacion);
				torneoIndividuos(poblacion);
				verganadores(ganadores);
				clonarMejorIndividuos(poblacion, poblacionTemp);
				verpoblacion(poblacionTemp, true);
				seleccionparejas(poblacion);
				combinacionMutacion(poblacion, poblacionTemp);
			}
			adaptados = mejorAdaptado_f3(poblacion);
			verpoblacion(poblacion, false);
		}
		//Metodo Llamar Funcion Ejemplo 4
		public static void llamarFuncion4() {
			poblacionInicial(poblacion);
			verpoblacion(poblacion, false);
			double adaptados = 0;
			while (adaptados < 1000) {
				genesIndividuo(poblacion);
				adaptados = mejorAdaptado_f4(poblacion);
				adaptabilidad(poblacion, sumatoria);
				verpoblacion(poblacion, true);
				seleccionparejas(poblacion);
				torneoIndividuos(poblacion);
				verganadores(ganadores);
				clonarMejorIndividuos(poblacion, poblacionTemp);
				verpoblacion(poblacionTemp, true);
				seleccionparejas(poblacion);
				combinacionMutacion(poblacion, poblacionTemp);
			}
			adaptados = mejorAdaptado_f4(poblacion);
			verpoblacion(poblacion, false);
		}
		//Metodo Llamar Funcion Ejemplo 5
		public static void llamarFuncion5() {
			poblacionInicial(poblacion);
			verpoblacion(poblacion, false);
			double adaptados = 0;
			while (adaptados < 1000) {
				genesIndividuo(poblacion);
				adaptados = mejorAdaptado_f5(poblacion);
				adaptabilidad(poblacion, sumatoria);
				verpoblacion(poblacion, true);
				seleccionparejas(poblacion);
				torneoIndividuos(poblacion);
				verganadores(ganadores);
				clonarMejorIndividuos(poblacion, poblacionTemp);
				verpoblacion(poblacionTemp, true);
				seleccionparejas(poblacion);
				combinacionMutacion(poblacion, poblacionTemp);
			}
			adaptados = mejorAdaptado_f5(poblacion);
			verpoblacion(poblacion, false);
		}
	// Cap.17.Ejemplo 1 : Funcion -50x^2 + 500x
	public static double fx_E1() {
		double x = 5.0;		// Valor critico
		return ((-50 * x * x) + (500 * x));
	}
	// Cap.17.Ejemplo 2 : Funcion 10000*x + 250*x
	public static double fx_E2() {
		double x = 40.0;	// Valor critico
		return (10000*x) - (125*x*x);
	}
	// Cap.17.Ejemplo 3 : Funcion 4860/x + 15*x + 750000
	public static double fx_E3() {
		double x = 18.0;	// Valor critico
		return ((4860/x) + (15*x) + 750000);
	}
	// Cap.17.Ejemplo 4 : Funcion 100000/x + 1500 + 0.2*x
	public static double fx_E4() {
		double x = 707.11; 	// Valor critico
		return ((100000/x) + 1500 + (0.2*x));
	}
	// Cap.17.Ejemplo 5 : Funcion -12.5*x*x + 1375*x - 1500
	public static double fx_E5() {
		double x = 55.0;	// Valor critico
		return ((-12.5*x*x) + (1375*x) - 1500);
	}
	// Inicia en nulos la poblacion de Individuos
	public static void poblacionInicial(String[][] poblacion) {
		System.out.println("_________________________Iniciar poblacion__________________________");
		String individuo = "";
		Random ri = new Random();
		for (int i = 0; i < parejas.length; i++) {
			individuo = "0,0,1,0,";
			individuo += ri.nextInt(2) + ",";
			poblacion[i][0] = "" + i;
			poblacion[i][1] = individuo;
		}
	}

	// Calculo del valor del individuo de acuerdo a sus genes 0 y 1*/
	public static void genesIndividuo(String[][] poblacion) {
		double valor = 0;
		for (int i = 0; i < parejas.length; i++) {
			valor = 0;
			String[] valores = poblacion[i][1].split(",");
			int indice = 0;
			for (int k = valores.length - 1; k >= 0; k--) {
				valor = valor + (Double.parseDouble(valores[k]) * Math.pow(2, indice));
				indice++;
			}
			poblacion[i][2] = "" + valor;
			sumatoria += valor;
		}
	}

	// Se busca el mejor adaptado
	public static double mejorAdaptado_f1(String[][] poblacion) {
		double mayor = Double.parseDouble(poblacion[0][2]);
		double valor = 0;
		for (int i = 0; i < parejas.length; i++) {
			valor = fx_E1();
			poblacion[i][3] = "" + valor;
			if (mayor < valor) {
				mayor = valor;
			}
		}
		System.out.println("Mejor Adaptado: " + mayor);
		return (mayor);
	}
	
	// Se busca el mejor adaptado
		public static double mejorAdaptado_f2(String[][] poblacion) {
			double mayor = Double.parseDouble(poblacion[0][2]);
			double valor = 0;
			for (int i = 0; i < parejas.length; i++) {
				valor = fx_E2();
				poblacion[i][3] = "" + valor;
				if (mayor < valor) {
					mayor = valor;
				}
			}
			System.out.println("Mejor Adaptado: " + mayor);
			return (mayor);
		}
		
		// Se busca el mejor adaptado
		public static double mejorAdaptado_f3(String[][] poblacion) {
			double mayor = Double.parseDouble(poblacion[0][2]);
			double valor = 0;
			for (int i = 0; i < parejas.length; i++) {
				valor = fx_E3();
				poblacion[i][3] = "" + valor;
				if (mayor < valor) {
					mayor = valor;
				}
			}
			System.out.println("Mejor Adaptado: " + mayor);
			return (mayor);
		}
		
		// Se busca el mejor adaptado
		public static double mejorAdaptado_f4(String[][] poblacion) {
			double mayor = Double.parseDouble(poblacion[0][2]);
			double valor = 0;
			for (int i = 0; i < parejas.length; i++) {
				valor = fx_E4();
				poblacion[i][3] = "" + valor;
				if (mayor < valor) {
					mayor = valor;
				}
			}
			System.out.println("Mejor Adaptado: " + mayor);
			return (mayor);
		}
		
		// Se busca el mejor adaptado
		public static double mejorAdaptado_f5(String[][] poblacion) {
			double mayor = Double.parseDouble(poblacion[0][2]);
			double valor = 0;
			for (int i = 0; i < parejas.length; i++) {
				valor = fx_E5();
				poblacion[i][3] = "" + valor;
				if (mayor < valor) {
					mayor = valor;
				}
			}
			System.out.println("Mejor Adaptado: " + mayor);
			return (mayor);
		}

	// Combinacion y mutacion
	public static void combinacionMutacion(String[][] poblacion, String[][] poblacionTemp) {
		System.out.println("______________________Combiancion y Mutacion________________________");
		Random ri = new Random();
		int puntocruce = 0;
		String[] individuoA;
		String[] individuoB;
		String ParejaA = "";
		for (int i = 0; i < parejas.length / 2; i++) {
			individuoA = poblacion[i][1].split(",");
			ParejaA = parejas[i];
			String cadAdn = "";
			individuoB = poblacion[Integer.parseInt(ParejaA)][1].split(",");
			puntocruce = ri.nextInt(4);
			System.out.println("punto cruce [" + puntocruce + "][" + poblacion[i][0] + "]" + "[" + poblacion[i][1]
					+ "][Cruzado con] [" + poblacion[Integer.parseInt(ParejaA)][0] + "]" + "["
					+ poblacion[Integer.parseInt(ParejaA)][1] + "]");
			for (int t = 0; t < puntocruce; t++) {
				cadAdn += individuoA[t] + ",";
			}
			for (int t = puntocruce; t < individuoA.length; t++) {
				cadAdn += individuoB[t] + ",";
			}
			System.out.println("Nuevo Individuo [" + cadAdn + "]");
			poblacionTemp[i][0] = "" + i;
			poblacionTemp[i][1] = cadAdn;
		}
		for (int i = 0; i < parejas.length; i++) {
			poblacion[i][0] = poblacionTemp[i][0];
			poblacion[i][1] = poblacionTemp[i][1];
		}
		// Mutacion del gen despues de la combinacion
		int mutado = (parejas.length / 2) + 1;
		individuoA = poblacion[mutado][1].split(",");
		System.out.println("____________________________Mutacion__________________________________");
		System.out.println("__________Individuo______________________________Resultado____________");
		int gen = ri.nextInt(4);
		if (individuoA[gen].equals("0")) {
			individuoA[gen] = "1";
		} else {
			individuoA[gen] = "0";
		}
		// Se genera el ADN para mutar el gen
		String cadAdn = "";
		for (int t = 0; t < individuoA.length; t++) {
			cadAdn += individuoA[t] + ",";
		}
		System.out.println("[" + poblacion[mutado][0] + "]" + "[" + poblacion[mutado][1] + "]" + " Gen mutado" + "["
				+ gen + "] Resultado=> [" + poblacion[mutado][0] + "]" + "[" + cadAdn + "]");
		poblacion[mutado][1] = cadAdn;
	}

	// Se clonan los mejores individuos
	public static void clonarMejorIndividuos(String[][] poblacion, String[][] poblacionTemp) {
		System.out.println("________________________Copiarse___________________________");
		int indice = 0;
		int t = 0;
		for (int i = 0; i < ganadores.length; i++) {
			int ganador = Integer.parseInt(ganadores[i]);
			poblacionTemp[indice][0] = "" + (i + t);
			poblacionTemp[indice + 1][0] = "" + (i + 1 + t);
			for (int f = 1; f < columnas; f++) {
				poblacionTemp[indice][f] = poblacion[ganador][f];
				poblacionTemp[indice + 1][f] = poblacion[ganador][f];
			}
			indice += 2;
			t++;
		}
		for (int i = 0; i < parejas.length; i++) {
			poblacion[i][0] = poblacionTemp[i][0];
			poblacion[i][1] = poblacionTemp[i][1];
		}

	}

	// Mostrar ganadores de cada torneo
	public static void verganadores(String[] ganadores) {
		System.out.println("____________________________ganadores_________________________________");
		int gano = 0;
		for (int i = 0; i < ganadores.length; i++) {
			gano = Integer.parseInt(ganadores[i]);
			System.out.println("[" + poblacion[gano][0] + "][ " + poblacion[gano][1] + "][" + poblacion[gano][2] + "]["
					+ poblacion[gano][3] + "]");
		}
	}

	// Se crea un torneo para saber quien es el mejor individuo
	public static void torneoIndividuos(String[][] poblacion) {
		System.out.println("____________________________Torneo__________________________________");
		String A = "";
		String ParejaA = "";
		String B = "";
		int aux = 0;
		for (int i = 0; i < parejas.length / 2; i++) {
			A = poblacion[i][3];
			ParejaA = parejas[i];
			B = poblacion[Integer.parseInt(ParejaA)][3];
			System.out.println("[" + poblacion[i][0] + "][ " + poblacion[i][1] + "][" + poblacion[i][2] + "][ "
					+ A + "] contra [" + poblacion[Integer.parseInt(ParejaA)][0] + "] ["
					+ poblacion[Integer.parseInt(ParejaA)][1] + "][" + poblacion[Integer.parseInt(ParejaA)][2] + "] ["
					+ B + "]");
			if (Double.parseDouble(A) >= Double.parseDouble(B)) {
				ganadores[aux] = poblacion[i][0];
			} else {
				ganadores[aux] = ParejaA;
			}
			aux++;
		}
	}

	//Se realiza una seleccion rotando las parejas
	public static void seleccionparejas(String[][] poblacion) {
		System.out.println("__________________________Seleccion parejas_____________________________");
		for (int i = 0; i < parejas.length; i++) {
			parejas[(parejas.length - 1) - i] = poblacion[i][0];
		}
	}

	// Se calcula la adaptabilidad de cada individuo
	public static void adaptabilidad(String[][] poblacion, double sumatoria) {
		for (int i = 0; i < parejas.length; i++) {
			poblacion[i][4] = "" + (Double.parseDouble(poblacion[i][2]) / sumatoria);
		}
	}

	// Mostramos la poblacion de individuos y sus valores
	public static void verpoblacion(String[][] poblacion, boolean pareja) {
		System.out.println("____________________________Pablacion Actual______________________________");
		String cadena = "";
		for (int i = 0; i < filas; i++) {
			for (int k = 0; k < columnas; k++) {
				cadena += "[" + poblacion[i][k] + "]";
			}
			if (pareja)
				cadena += "  Pareja " + parejas[i] + "\n";
			else
				cadena += "" + "\n";
		}
		System.out.print(cadena);
	}
}

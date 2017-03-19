package floyd;

import java.io.FileNotFoundException;

import graph.Graph;

/**
 * La clase FloydMain comprueba el funcionamiento de 
 * FloydAlgorithm.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class FloydMain {
	
	/**
	 * Método principal que se encarga de crear el grafo y 
	 * ejecutar Floyd.
	 * @param args Nombre del fichero que contiene el grafo.
	 */
	public static void main(String[] args) {
		try { 	
			if (args.length != 1)
				throw new IllegalArgumentException (" parameters have to be exactly 1");
			
			Graph graph = new Graph (args[0]);
			FloydAlgorithm floyd = new FloydAlgorithm(graph);
			floyd.execute();
		
			System.out.println(floyd.toString());
			
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException has ocurred:" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException has ocurred:" + e.getMessage());
		}
	}

}

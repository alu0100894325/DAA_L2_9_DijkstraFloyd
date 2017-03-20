package floydRec;

import java.io.FileNotFoundException;

import graph.Graph;

/**
 * La clase FloydRecMain comprueba el funcionamiento de 
 * FloydRecAlgorithm.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class FloydRecMain {
	
	/**
	 * Método principal que se encarga de crear el grafo y 
	 * ejecutar Floyd recursivo.
	 * @param args Nombre del fichero que contiene el grafo.
	 */
	public static void main(String[] args) {
		try { 	
			if (args.length != 1)
				throw new IllegalArgumentException (" parameters have to be exactly 1");
			
			Graph graph = new Graph (args[0]);
			
			long startTime = System.nanoTime();
			
			FloydRecAlgorithm floyd = new FloydRecAlgorithm(graph);
			floyd.execute();
			
			long stopTime = System.nanoTime();
		    long elapsedTime = stopTime - startTime;
		    System.out.println("Tiempo de ejecución: " + elapsedTime + " ns");
			
		    // Descomentar para mostrar matrices.
			//System.out.println(floyd.toString());
			
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException has ocurred:" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException has ocurred:" + e.getMessage());
		}

	}

}

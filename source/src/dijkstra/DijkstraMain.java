package dijkstra;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import graph.Graph;
import graph.Vertex;

/**
 * La clase DijkstraMain comprueba el funcionamiento de 
 * DijkstraAlgorithm.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class DijkstraMain {
	
	/**
	 * Método principal que se encarga de crear el grafo y 
	 * ejecutar Dijkstra.
	 * @param args Nombre del fichero que contiene el grafo.
	 */
	public static void main(String[] args) {
		try { 	
			if (args.length != 1)
				throw new IllegalArgumentException (" parameters have to be exactly 1");
			
			Graph graph = new Graph (args[0]);
			//Ejecutamos n veces para poder comparar tiempo de ejecución con Floyd.
			
			long startTime = System.nanoTime();
			for (int i = 0; i < graph.getVertexes().size(); i++) {
				DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
				Vertex source = graph.getVertexes().get(i);
				dijkstra.execute(source);
			}
			
			long stopTime = System.nanoTime();
		    long elapsedTime = stopTime - startTime;
		    System.out.println("Tiempo de ejecución: " + elapsedTime + " ns");
		
			//Descomentar para mostrar el camino.
			/*LinkedList<Vertex> path = dijkstra.getPath(graph.getVertexes().get(graph.getVertexes().size() - 1));
			for (int i = 0; i < path.size(); i++)
				System.out.println(path.get(i));*/
			
		} catch (IllegalArgumentException e) {
			System.err.println("IllegalArgumentException has ocurred:" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException has ocurred:" + e.getMessage());
		}
	}
}

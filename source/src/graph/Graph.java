package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Graph representa un grafo
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class Graph {
	
	private ArrayList<Vertex> vertexes; /** Lista de vértices */
	private ArrayList<Edge> edges; /** Lista de aristas/arcos */

	/**
	 * Constructor a partir de listas.
	 * @param vertexes lista de vértices
	 * @param edges lista de aristas/arcos
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
		setEdges(new ArrayList<Edge>(edges));
		setVertexes(new ArrayList<Vertex>(vertexes));
	}
	
	/**
	 * Constructor a partir de fichero.
	 * @param fInput fichero de entrada
	 * @throws FileNotFoundException
	 */
	public Graph (String fInput) throws FileNotFoundException {
		setVertexes(new ArrayList<Vertex>());
		setEdges(new ArrayList<Edge>());
		Scanner scan = new Scanner( new File (fInput));
		
		// Leemos los vértices.
		String numVertexes = scan.nextLine();
		for (int i = 0; i < Integer.valueOf(numVertexes); i++) {
			String vertex = scan.nextLine();
			String [] arrayVertex = vertex.split(" ");
			Vertex temp = new Vertex (arrayVertex[0], arrayVertex[1]);
			getVertexes().add(temp);
		}
		
		// Leemos l@s aristas/arcos
		String numEdges = scan.nextLine();
		for (int i = 0; i < Integer.valueOf(numEdges); i++) {
			String edge = scan.nextLine();
			String [] arrayEdge = edge.split(" ");
			Vertex sourceVertex = new Vertex ();
			Vertex destVertex = new Vertex ();
			
			for (int j = 0; j < getVertexes().size(); j++) {
				if (getVertexes().get(j).getId().equals(arrayEdge[1]))
					sourceVertex = getVertexes().get(j);
				if (getVertexes().get(j).getId().equals(arrayEdge[2]))
					destVertex = getVertexes().get(j);
			}
			
			getEdges().add(new Edge (arrayEdge[0], sourceVertex, destVertex, Integer.valueOf(arrayEdge[3])));
		}
		
		scan.close();
	}

	/**
	 * @return the vertexes
	 */
	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}

	/**
	 * @param vertexes the vertexes to set
	 */
	public void setVertexes(ArrayList<Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	/**
	 * @return the edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 * @param edges the edges to set
	 */
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
}

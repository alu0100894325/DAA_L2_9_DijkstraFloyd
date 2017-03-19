package floyd;

import java.util.ArrayList;

import graph.Graph;
import graph.Vertex;
/**
 * La clase FloydAlgorithm representa el algoritmo Floyd
 * para la resolución del problema del camino mínimo.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class FloydAlgorithm {
	
	private Graph graph; /** Grafo */
	private ArrayList<Integer> weights; /** Matriz de pesos representada como vector*/
	private ArrayList<Vertex> paths; /** Matriz de predecesores representada como vector*/
	private Integer side; /** Número de vértices, lado de las matrices */
	final static private Integer MAX = 9999; /** Valor máximo del peso */
	
	/**
	 * Constructor a partir de un grafo.
	 * @param graph grafo
	 */
	public FloydAlgorithm (Graph graph) {
		setGraph(graph);
		setPaths(new ArrayList<Vertex>());
		setWeights(new ArrayList<Integer>());
		setSide(getGraph().getVertexes().size());
		
		for (int i = 0; i < getSide() * getSide(); i++) {
			getWeights().add(getMax());
			getPaths().add(new Vertex());
		}
	}

	/**
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * @param graph the graph to set
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * @return the weights
	 */
	public ArrayList<Integer> getWeights() {
		return weights;
	}

	/**
	 * @param weights the weights to set
	 */
	public void setWeights(ArrayList<Integer> weights) {
		this.weights = weights;
	}

	/**
	 * @return the paths
	 */
	public ArrayList<Vertex> getPaths() {
		return paths;
	}

	/**
	 * @param paths the paths to set
	 */
	public void setPaths(ArrayList<Vertex> paths) {
		this.paths = paths;
	}

	/**
	 * @return the max
	 */
	public static Integer getMax() {
		return MAX;
	}
	
	/**
	 * @return the side
	 */
	public Integer getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(Integer side) {
		this.side = side;
	}
	
	/**
	 * Devuelve el peso situado en los índices de la matrix indicados
	 * @param i fila
	 * @param j columna
	 * @return peso en (i, j)
	 */
	public Integer getElementWeights (int i, int j) {
		return getWeights().get(i * getSide() + j);
	}
	
	/**
	 * Devuelve el predecesor situado en los índices de la matrix indicados
	 * @param i fila
	 * @param j columna
	 * @return predecesor en (i, j)
	 */
	public Vertex getElementPaths (int i, int j) {
		return getPaths().get(i * getSide() + j);
	}
	
	/**
	 * Cambia el valor del peso en los índices de la matriz indicados.
	 * @param i fila 
	 * @param j columna
	 * @param value nuevo peso.
	 */
	public void setElementWeights (int i, int j, int value) {
		getWeights().set(i * getSide() + j, value);
	}
	
	/**
	 * Cambia el valor del predecesor en los índices de la matriz indicados.
	 * @param i fila 
	 * @param j columna
	 * @param value nuevo predecesor.
	 */
	public void setElementPaths (int i, int j, Vertex value) {
		getPaths().set(i * getSide() + j, value);
	}
	
	/**
	 * Ejecuta el algoritmo de Floyd.
	 */
	public void execute () {
		initialize();
		
		for (int k = 0; k < getSide(); k++)
			for (int i = 0; i < getSide(); i++)
				for (int j = 0; j < getSide(); j++) {
					int first = getElementWeights(i, j);
					int second = getElementWeights(i, k) + getElementWeights(k, j);
					if (first > second) {
						setElementWeights(i, j, second); 
						setElementPaths(i, j, getElementPaths(k, j));
					}
				}
	}
	
	/**
	 * Inicializa las matrices al comienzo del algoritmo.
	 */
	public void initialize () {
		for (int i = 0; i < getSide(); i++) {
			for (int j = 0; j < getSide(); j++) {
				if (i == j)
					setElementWeights(i, j, 0);
				setElementPaths(i, j, getGraph().getVertexes().get(i));
			}
		}
		
		for (int i = 0; i < getGraph().getEdges().size(); i++) {
			Vertex source = getGraph().getEdges().get(i).getSource();
			Vertex dest = getGraph().getEdges().get(i).getDestination();
			int weight = getGraph().getEdges().get(i).getWeight();
			
			int rod = getGraph().getVertexes().indexOf(source);
			int column = getGraph().getVertexes().indexOf(dest);
			
			setElementWeights(rod, column, weight);
		}
	}
	
	/**
	 * Muestra las dos matrices como una cadena.
	 * @return cadena con  las dos matrices.
	 */
	public String toString () {
		String string = "Pesos\n";
		for (int i = 0; i < getSide(); i++) {
			for (int j = 0; j < getSide(); j++) {
				string += "\t" + getElementWeights(i, j);
			}
			string += "\n";
		}
		
		string += "Recorridos\n";
		for (int i = 0; i < getSide(); i++) {
			for (int j = 0; j < getSide(); j++) {
				string += "\t" + getElementPaths(i, j).toString();
			}
			string += "\n";
		}
		
		return string;
	}

}

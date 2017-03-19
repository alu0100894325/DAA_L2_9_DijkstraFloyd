package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

/**
 * La clase DijkstraAlgorithm representa el algoritmo Dijkstra
 * para la resolución del problema del camino mínimo.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class DijkstraAlgorithm {
	
	private List<Vertex> nodes; /** Nodos del grafo */
    private List<Edge> edges; /** Aristas/arcos del grafo */
    private Set<Vertex> settledNodes; /** Nodos definitivos */
    private Set<Vertex> unSettledNodes; /** Nodos no definitivos */
    private Map<Vertex, Vertex> predecessors; /** Predecesores */
    private Map<Vertex, Integer> distance; /** Distancias */
    
    final static private Integer MAX = Integer.MAX_VALUE; /** Máximo valor de la distancia */

    /**
     * Constructor a partir de un grafo.
     * @param graph grafo
     */
    public DijkstraAlgorithm(Graph graph) {
    	setNodes(new ArrayList<Vertex>(graph.getVertexes()));
        setEdges(new ArrayList<Edge>(graph.getEdges()));
    }

    /**
	 * @return the max
	 */
	public static Integer getMax() {
		return MAX;
	}

	/**
	 * @return the nodes
	 */
	public List<Vertex> getNodes() {
		return nodes;
	}

	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<Vertex> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the edges
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * @param edges the edges to set
	 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * @return the settledNodes
	 */
	public Set<Vertex> getSettledNodes() {
		return settledNodes;
	}

	/**
	 * @param settledNodes the settledNodes to set
	 */
	public void setSettledNodes(Set<Vertex> settledNodes) {
		this.settledNodes = settledNodes;
	}

	/**
	 * @return the unSettledNodes
	 */
	public Set<Vertex> getUnSettledNodes() {
		return unSettledNodes;
	}

	/**
	 * @param unSettledNodes the unSettledNodes to set
	 */
	public void setUnSettledNodes(Set<Vertex> unSettledNodes) {
		this.unSettledNodes = unSettledNodes;
	}

	/**
	 * @return the predecessors
	 */
	public Map<Vertex, Vertex> getPredecessors() {
		return predecessors;
	}

	/**
	 * @param predecessors the predecessors to set
	 */
	public void setPredecessors(Map<Vertex, Vertex> predecessors) {
		this.predecessors = predecessors;
	}

	/**
	 * @return the distance
	 */
	public Map<Vertex, Integer> getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Map<Vertex, Integer> distance) {
		this.distance = distance;
	}

	/**
	 * Método para ejecutar el algoritmo de Dijkstra.
	 * @param source nodo origen
	 */
	public void execute(Vertex source) {
	    setSettledNodes(new HashSet<Vertex>());
	    setUnSettledNodes(new HashSet<Vertex>());
	    
	    setDistance(new HashMap<Vertex, Integer>());
	    setPredecessors(new HashMap<Vertex, Vertex>());
	            
	    getDistance().put(source, 0);
	    getUnSettledNodes().add(source);
	            
	    while (getUnSettledNodes().size() > 0) {
		    Vertex node = getMinimum(getUnSettledNodes());
		    getSettledNodes().add(node);
		    getUnSettledNodes().remove(node);
		    findMinimalDistances(node);
		    }
    }

	/**
	 * Encuentra las distancias mínimas del nodo.
	 * @param node nodo
	 */
    private void findMinimalDistances(Vertex node) {
    	List<Vertex> adjacentNodes = getNeighbors(node);
    	for (Vertex target : adjacentNodes) {
    		if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
    			getDistance().put(target, getShortestDistance(node) + getDistance(node, target));
                getPredecessors().put(target, node);
                getUnSettledNodes().add(target);
            }
         }

    }
    
    /**
     * Devuelve la distancia entre el nodo node y nodo target
     * @param node origen
     * @param target destino
     * @return distancia entre node y target
     */
    private int getDistance(Vertex node, Vertex target) {
    	for (Edge edge : getEdges())
    		if (edge.getSource().equals(node) && edge.getDestination().equals(target)) 
    			return edge.getWeight();
        throw new RuntimeException("Should not happen");
    }

    /**
     * Devuelve los vecinos del nodo pasado como parámetro.
     * @param node nodo
     * @return vecinos del nodo
     */
    private List<Vertex> getNeighbors(Vertex node) {
    	List<Vertex> neighbors = new ArrayList<Vertex>();
    	for (Edge edge : getEdges())
        	if (edge.getSource().equals(node) && !isSettled(edge.getDestination()))
        		neighbors.add(edge.getDestination());
        return neighbors;
    }
    
    /**
     * Obtiene el vértice con la mínima distancia.
     * @param vértices a revisar.
     * @return nodo con la mínima distancia.
     */
    private Vertex getMinimum(Set<Vertex> vertexes) {
    	Vertex minimum = null;
    	for (Vertex vertex : vertexes)
        	if (minimum == null)
            	minimum = vertex;
            else if (getShortestDistance(vertex) < getShortestDistance(minimum)) 
            	minimum = vertex;
    	return minimum;
    }
    
    /**
     * Devuelve TRUE si el nodo pasado como parámetro es definitivo.
     * @param vertex nodo a revisar.
     * @return TRUE si es definitivo, FALSE si no.
     */
    private boolean isSettled(Vertex vertex) {
            return getSettledNodes().contains(vertex);
    }

    /**
     * Devuelve la distancia más corta asociada a un nodo.
     * @param destination nodo a revisar.
     * @return distancia.
     */
    private int getShortestDistance(Vertex destination) {
    	Integer d = getDistance().get(destination);
    	if (d == null)
    		return getMax();
        else
        	return d;
    }

    /**
     * Método que devuelve una lista con el camino desde el nodo target hasta el origen.
     * @param target nodo destino
     * @return lista con el camino 
     */
    public LinkedList<Vertex> getPath(Vertex target) {
    	LinkedList<Vertex> path = new LinkedList<Vertex>();
    	Vertex step = target;
           
    	if (getPredecessors().get(step) == null)
        	return null;
        
        path.add(step);
        while (getPredecessors().get(step) != null) {
        	step = getPredecessors().get(step);
        	path.add(step);
        }
            
        Collections.reverse(path);
        	return path;
    }

}

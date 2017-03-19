package graph;

/**
 * La clase Edge representa un arco/arista de un grafo.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class Edge {
	
	private String id; /** Identificador */
    private Vertex source; /** Origen */
    private Vertex destination; /** Destino */
    private int weight; /** Peso */
    
    /**
     * Constructor a partir de los valores de los atributos.
     * @param id identificador
     * @param source origen
     * @param destination destino
     * @param weight peso
     */
    public Edge(String id, Vertex source, Vertex destination, int weight) {
    	setId(id);
    	setSource(source);
    	setDestination(destination);
    	setWeight(weight);
    }

    /**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Vertex source) {
		this.source = source;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the source
	 */
	public Vertex getSource() {
		return source;
	}

	/**
	 * @return the destination
	 */
	public Vertex getDestination() {
		return destination;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Representa la arista como una cadena.
	 */
	@Override
    public String toString() {
            return getId() + " " + getSource().toString() + " " + getDestination() + " " + getWeight();
    }
}

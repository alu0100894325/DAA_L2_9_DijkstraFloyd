package graph;

/**
 * La clase Vertex representa un vértice del grafo.
 * 
 * Fecha: 18-03-2017
 * Asignatura: Diseño y Análisis de algoritmos.
 * @author Pamela Jiménez, Jesús Plasencia, Alberto Sarabia
 * @version 1.0
 * @since 1.0
 *
 */
public class Vertex {
	
    private String id; /** Identificador del vértice */
    private String name; /** Nombre del vértice */

    /** 
     * Constructor a partir de identificador y nombre.
     * @param id Identificador
     * @param name Nombre
     */
    public Vertex(String id, String name) {
    	setId(id);
        setName(name);
    }
    
    public Vertex() {
    	setId("");
        setName("");
	}

	/**
     * Setter para id
	 * @param id nuevo id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Setter para name
	 * @param name nuevo name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter para id
	 * @return id
	 */
	public String getId() {
        return id;
    }
	
	/**
	 * Getter para name
	 * @return name
	 */
    public String getName() {
    	return name;
    }
    
    /**
     * Devuelve el código hash.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Compara dos vértices.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        	return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
            	return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    /**
     * Representa el vértice como una cadena.
     * @return la cadena que representa al vértice.
     */
    @Override
    public String toString() {
        return name;
    }
}

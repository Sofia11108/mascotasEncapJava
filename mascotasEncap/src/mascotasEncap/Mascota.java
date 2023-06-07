package mascotasEncap;

public class Mascota {
	
	private String identificacion;
    private String nombre;
    private String especie;
    private int edad;
    

    public Mascota() {

    }

    public Mascota(String identificacion, String nombre, String especie, int edad) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
    }
    

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public void setEspecie(String especie) {
		this.especie = especie;			
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	


    
    public String getNombre() {
    	return nombre;
    }
    	
    public String getIdentificacion() {
    	return identificacion;
    }
    	
    public String getEspecie() {
    	return especie;
    }
    	
	public int getEdad() {
		return edad;
	}


    
    public String hacerSonido() {

        String sonido = "";

        if (especie.equalsIgnoreCase("perro")) {
            sonido = "Guau Guauu";
        } else if (especie.equalsIgnoreCase("gato")) {
            sonido = "Miau Miauu";
        } else {
            sonido = "La mascota no hace sonidos conocidos.";
        }

        return sonido;
    }
    

    public String comer(String nombre) {
    	String comer;
    	
    	comer = nombre + " está comiendo";
    	return comer;
    }

    
    public String actividades() {
    	
    	String resultado;
    	
		if (especie.equalsIgnoreCase("perro")) {
			resultado = "estoy corriendo";
			
		} else if (especie.equalsIgnoreCase("gato")) {
			resultado = "estoy arañando";
	
		} else {
			resultado = "estoy durmiendo";
		}
		
		return resultado;
	}

}

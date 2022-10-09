package Ayudantia6;

public class Persona {
    private String nombre;
    private String rut;
    private int edad;


    //Constructores con y sin paramentros
    public Persona(String nombre, String rut, int edad) throws Exception{
        setNombre(nombre);
        setRut(rut);
        setEdad(edad);
    }


    //Setters
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setRut(String rut) throws Exception{
        validarRut(rut);
        this.rut = quitarPuntosYGuion(rut);
    }

    private void setEdad(int edad) throws Exception{
        validarEdad(edad);
        this.edad = edad;
    }


    //Validacion de RUT
    private void validarRut(String rut) throws Exception{
        String rutSinPuntosNiGuion = quitarPuntosYGuion(rut);
        String mensajeError = "Ingrese un RUT valido.";

        if (rutSinPuntosNiGuion.length() > 9){
            throw new Exception(mensajeError);
        }

        if(!rutSinPuntosNiGuion.substring(8,9).equalsIgnoreCase("k")){
            try {
                Integer.parseInt(rut.substring(8,9));
            }catch (Exception e){
                throw new Exception(mensajeError);
            }
        }

        try {
            Integer.parseInt(rutSinPuntosNiGuion.substring(0,8));
        }catch (Exception e){
            throw new Exception(mensajeError);
        }
    }

    private String quitarPuntosYGuion(String rut){
        String rutSinPuntos;
        rutSinPuntos = rut.replace(".", "");
        String rutSinPuntosNiGuion = rutSinPuntos.replace("-", "");
        String rutLimpio = rutSinPuntosNiGuion.replace(" ", "");
        return rutLimpio;
    }

    //Validacion de Edad
    private void validarEdad(int edad) throws Exception{
        String mensajeError = "Ingrese una edad valida.";
        try {
            if(edad < 0){
                throw new Exception(mensajeError);
            }
        }catch (NumberFormatException e){
            throw new Exception(mensajeError);
        }
    }


    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre: " + nombre + "\n" +
                "RUT: " + rut + "\n"+
                "Edad: "+ edad + "}";
    }
}

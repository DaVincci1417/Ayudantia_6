package Ayudantia6;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Persona> pacientes = new ArrayList<>();

    //Constructor
    public Registro(){
    }

    //Metodos
    public void agregarPaciente(Persona paciente){
        pacientes.add(paciente);
    }

    public Persona eliminarPaciente(String nombre){
        if(this.pacientes == null){
            return null;
        } else {
            Persona pacienteEliminado = encontrarPaciente(nombre);
            pacientes.remove(pacienteEliminado);

            return pacienteEliminado;
        }
    }

    public Persona encontrarPaciente(String nombre) {
       if(this.pacientes== null){
           return null;
       } else {
           int posicion = -1;
           for (int i = 0; i < pacientes.size(); i++) {
               if (pacientes.get(i).getNombre().equalsIgnoreCase(nombre)){
                   posicion = i;
               }
           }
           if (posicion != -1) {
               return pacientes.get(posicion);
           } else {
               return null;
           }
       }

    }


    public void pacientesMayoresASesenta(){
        if(this.pacientes == null){
                System.out.println("No hay pacientes mayores a 60 años");
            } else {
                for (int i = 0; i < pacientes.size(); i++){
                    if(pacientes.get(i).getEdad() > 60) {
                        System.out.println(
                                "Los pacientes mayores a 60 años son: \n"+
                                pacientes.get(i)+"\n");
                    }
                }
            System.out.println("No hay pacientes mayores a 60 años");
        }
    }

}

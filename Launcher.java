package Ayudantia6;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class Launcher{
    public static void main(String[] args){
        principal();
    }

    public static void principal(){
        Registro registro = new Registro();
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do{
            menuPrincipal();
            opc = leer.nextInt();
            segunPrincipal(opc, registro);
        }while (opc != 0);
        System.out.println("Ha salido.");
    }
    public static void menuPrincipal(){
        System.out.println(
                "Bienvenido. Ingrese opción según corresponda:\n" +
                        "0. Salir\n" +
                        "1. Agregar paciente.\n" +
                        "2. Eliminar paciente.\n" +
                        "3. Buscar paciente (por el nombre).\n" +
                        "4. Pacientes mayores a 60 años.\n"
        );
    }
    public static void segunPrincipal(int opc, Registro registro){
        switch (opc){
            case 0:
                break;
            case 1:
                try {
                    agregarPaciente(registro);
                } catch (Exception e){
                    System.out.println("Has ingresadoa algo mal, vuelve a intentarlo");
                }
                break;
            case 2:
                eliminarPaciente(registro);
                break;
            case 3:
                bucarPacientePorElNombre(registro);
                break;
            case 4:
                registro.pacientesMayoresASesenta();
                break;
            default: System.out.println("Agregue una opción valida");
        }
    }

    public static void agregarPaciente(Registro registro) throws Exception{
        Scanner leer = new Scanner(System.in);

        String nombre;
        String rut;
        int edad;

        System.out.println("Ingre el nombre (completo) del paciente");
        nombre = leer.nextLine();
        System.out.println("Ingre el RUT");
        rut = leer.nextLine();
        System.out.println("Ingre la edad del paciente");
        edad = leer.nextInt();
        Persona paciente = new Persona(nombre, rut, edad);
        registro.agregarPaciente(paciente);

        System.out.println("Ha agregado con exito a paciente: ");
        System.out.println(paciente.toString());
    }

    public static void eliminarPaciente(Registro registro){
        Scanner leer = new Scanner(System.in);
        String nombre;

            System.out.println("Ingre el nombre (completo) del paciente");
            nombre = leer.nextLine();
            if(registro.eliminarPaciente(nombre) != null){
                System.out.println(
                        "Se ha eliminado al paciente."
                );

            }else{
                System.out.println("No se ha encontrado al paciente a eliminar.");
            }

    }

    public static void bucarPacientePorElNombre(Registro registro){
        Scanner leer = new Scanner(System.in);
        String nombre;

        System.out.println("Ingre el nombre (completo) del paciente");
        nombre = leer.nextLine();

        if(registro.encontrarPaciente(nombre) != null){
            System.out.println(
                    "Se ha encontrado al paciente: " +
                            registro.encontrarPaciente(nombre)
            );
        }else{
            System.out.println("No se ha encontrado al paciente.");
        }

    }



}

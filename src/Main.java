import java.util.List;
import java.util.ArrayList;


class Materia {
    String nombre_materia;
    List<Materia> correlativas = new ArrayList<Materia>();

    void Agregar_Correlativa(Materia correlativa){
        this.correlativas.add(correlativa);
    }
}

class Alumno {
    String nombre_alumno;
    List<Materia> materias_cursadas = new ArrayList<Materia>();

    void Cursar_materia(Materia materia){
        this.materias_cursadas.add(materia);
    }
}

class Inscripcion {
    List<Materia> inscripcion_alumno = new ArrayList<Materia>();
    Alumno alumno;

    boolean Verificar_Correlativas() {
        for (Materia materia : this.inscripcion_alumno) {
            if (!Aprobada(materia)) {
                System.out.println(("Inscripcion rechazada."));
                return false; // Al menos una materia no tiene la correlativa aprobada
            }
        }
        System.out.println(("Inscripcion aprobada."));
        return true; // Todas las materias tienen sus correlativas aprobadas
    }

    boolean Aprobada(Materia materia) {
        for (Materia correlativa_a_evaluar : materia.correlativas) {
            if (!(alumno.materias_cursadas.contains(correlativa_a_evaluar))) {
                return false; // El alumno no aprobó algunas de las correlativas necesarias.
            }
        }
        return true; // El alumno aprobó todas las correlativas necesarias.
    }

    void Asignar_Alumno(Alumno alumno){
        this.alumno = alumno;
    }

    void Asignar_materia(Materia materia){
        this.inscripcion_alumno.add(materia);
    }
}


public class Main {
    public static void main(String[] args) {
    //Materias
        //Materias primer nivel
        Materia matematica_discreta = new Materia();
        Materia algebra = new Materia();
        Materia analisis_matematico_uno = new Materia();
        Materia sistemas_y_organizaciones = new Materia();
        Materia algoritmos = new Materia();


        //Materias segundo nivel
        Materia paradigmas_de_programacion = new Materia();
        paradigmas_de_programacion.Agregar_Correlativa(matematica_discreta);

        Materia fisica_uno = new Materia();

        Materia analisis_matematico_dos = new Materia();
        analisis_matematico_dos.Agregar_Correlativa(algebra);
        analisis_matematico_dos.Agregar_Correlativa(analisis_matematico_uno);

        Materia analisis_de_sistemas = new Materia();
        analisis_de_sistemas.Agregar_Correlativa(sistemas_y_organizaciones);
        analisis_de_sistemas.Agregar_Correlativa(algoritmos);

        //Materias tercer nivel
        Materia fisica_dos = new Materia();
        fisica_dos.Agregar_Correlativa(fisica_uno);
        fisica_dos.Agregar_Correlativa(analisis_matematico_dos);

        Materia disenio_de_sistemas = new Materia();
        disenio_de_sistemas.Agregar_Correlativa(analisis_de_sistemas);
        disenio_de_sistemas.Agregar_Correlativa(paradigmas_de_programacion);
        disenio_de_sistemas.Agregar_Correlativa(matematica_discreta);
        disenio_de_sistemas.Agregar_Correlativa(algoritmos);
        disenio_de_sistemas.Agregar_Correlativa(sistemas_y_organizaciones);

        Materia matematica_superior = new Materia();
        matematica_superior.Agregar_Correlativa(analisis_matematico_dos);
        matematica_superior.Agregar_Correlativa(algebra);
        matematica_superior.Agregar_Correlativa(analisis_matematico_uno);


        Materia economia = new Materia();
        economia.Agregar_Correlativa(analisis_de_sistemas);
        economia.Agregar_Correlativa(algoritmos);
        economia.Agregar_Correlativa(sistemas_y_organizaciones);

        Materia metodologia = new Materia();
        metodologia.Agregar_Correlativa(analisis_de_sistemas);
        metodologia.Agregar_Correlativa(paradigmas_de_programacion);


  //Alumno
        Alumno tomas = new Alumno();
        tomas.Cursar_materia(matematica_discreta);
        tomas.Cursar_materia(algebra);
        tomas.Cursar_materia(analisis_matematico_uno);
        tomas.Cursar_materia(sistemas_y_organizaciones);
        tomas.Cursar_materia(algoritmos);
        tomas.Cursar_materia(paradigmas_de_programacion);
        tomas.Cursar_materia(fisica_uno);
        tomas.Cursar_materia(analisis_matematico_dos);
        tomas.Cursar_materia(analisis_de_sistemas);

        Alumno franco = new Alumno();
        franco.Cursar_materia(matematica_discreta);
        franco.Cursar_materia(algebra);
        franco.Cursar_materia(analisis_matematico_uno);

        Alumno facundo = new Alumno();




   //Inscprcion
        Inscripcion inscripcion_tomas = new Inscripcion();
        inscripcion_tomas.Asignar_Alumno(tomas);
        inscripcion_tomas.Asignar_materia(fisica_dos);
        inscripcion_tomas.Asignar_materia(disenio_de_sistemas);
        inscripcion_tomas.Asignar_materia(matematica_superior);
        inscripcion_tomas.Asignar_materia(economia);
        inscripcion_tomas.Asignar_materia(metodologia);

        Inscripcion inscripcion_franco = new Inscripcion();
        inscripcion_franco.Asignar_Alumno(franco);
        inscripcion_franco.Asignar_materia(fisica_dos);
        inscripcion_franco.Asignar_materia(disenio_de_sistemas);
        inscripcion_franco.Asignar_materia(matematica_superior);
        inscripcion_franco.Asignar_materia(economia);
        inscripcion_franco.Asignar_materia(metodologia);

        Inscripcion inscripcion_facundo = new Inscripcion();
        inscripcion_facundo.Asignar_Alumno(facundo);
        inscripcion_facundo.Asignar_materia(matematica_discreta);
        inscripcion_facundo.Asignar_materia(algebra);



        //Prueba 1: Inscripcion tomas deberia ser aprobada
        inscripcion_tomas.Verificar_Correlativas();

        //Prueba 2: Inscripcion franco deberia ser rechazada
        inscripcion_franco.Verificar_Correlativas();

        //Prueba 3: Inscripcion facundo deberia ser aprobada
        inscripcion_facundo.Verificar_Correlativas();

}
}


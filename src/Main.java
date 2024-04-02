import java.util.List;
import java.util.ArrayList;


class Materia {
    String nombre_materia;
    List<Materia> correlativas = new ArrayList<Materia>();
}

class Alumno {
    String nombre_alumno;
    List<Materia> materias_cursadas = new ArrayList<Materia>();
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
        paradigmas_de_programacion.correlativas.add(matematica_discreta);

        Materia fisica_uno = new Materia();

        Materia analisis_matematico_dos = new Materia();
        analisis_matematico_dos.correlativas.add(algebra);
        analisis_matematico_dos.correlativas.add(analisis_matematico_uno);

        Materia analisis_de_sistemas = new Materia();
        analisis_de_sistemas.correlativas.add(sistemas_y_organizaciones);
        analisis_de_sistemas.correlativas.add(algoritmos);

        //Materias tercer nivel
        Materia fisica_dos = new Materia();
        fisica_dos.correlativas.add(fisica_uno);
        fisica_dos.correlativas.add(analisis_matematico_dos);

        Materia disenio_de_sistemas = new Materia();
        disenio_de_sistemas.correlativas.add(analisis_de_sistemas);
        disenio_de_sistemas.correlativas.add(paradigmas_de_programacion);
        disenio_de_sistemas.correlativas.add(matematica_discreta);
        disenio_de_sistemas.correlativas.add(algoritmos);
        disenio_de_sistemas.correlativas.add(sistemas_y_organizaciones);

        Materia matematica_superior = new Materia();
        matematica_superior.correlativas.add(analisis_matematico_dos);
        matematica_superior.correlativas.add(algebra);
        matematica_superior.correlativas.add(analisis_matematico_uno);


        Materia economia = new Materia();
        economia.correlativas.add(analisis_de_sistemas);
        economia.correlativas.add(algoritmos);
        economia.correlativas.add(sistemas_y_organizaciones);

        Materia metodologia = new Materia();
        metodologia.correlativas.add(analisis_de_sistemas);
        metodologia.correlativas.add(paradigmas_de_programacion);


  //Alumno
        Alumno tomas = new Alumno();
        tomas.materias_cursadas.add(matematica_discreta);
        tomas.materias_cursadas.add(algebra);
        tomas.materias_cursadas.add(analisis_matematico_uno);
        tomas.materias_cursadas.add(sistemas_y_organizaciones);
        tomas.materias_cursadas.add(algoritmos);
        tomas.materias_cursadas.add(paradigmas_de_programacion);
        tomas.materias_cursadas.add(fisica_uno);
        tomas.materias_cursadas.add(analisis_matematico_dos);
        tomas.materias_cursadas.add(analisis_de_sistemas);

        Alumno franco = new Alumno();
        franco.materias_cursadas.add(matematica_discreta);
        franco.materias_cursadas.add(algebra);
        franco.materias_cursadas.add(analisis_matematico_uno);

        Alumno facundo = new Alumno();




   //Inscprcion
        Inscripcion inscripcion_tomas = new Inscripcion();
        inscripcion_tomas.alumno = tomas;
        inscripcion_tomas.inscripcion_alumno.add(fisica_dos);
        inscripcion_tomas.inscripcion_alumno.add(disenio_de_sistemas);
        inscripcion_tomas.inscripcion_alumno.add(matematica_superior);
        inscripcion_tomas.inscripcion_alumno.add(economia);
        inscripcion_tomas.inscripcion_alumno.add(metodologia);

        Inscripcion inscripcion_franco = new Inscripcion();
        inscripcion_franco.alumno = franco;
        inscripcion_franco.inscripcion_alumno.add(fisica_dos);
        inscripcion_franco.inscripcion_alumno.add(disenio_de_sistemas);
        inscripcion_franco.inscripcion_alumno.add(matematica_superior);
        inscripcion_franco.inscripcion_alumno.add(economia);
        inscripcion_franco.inscripcion_alumno.add(metodologia);

        Inscripcion inscripcion_facundo = new Inscripcion();
        inscripcion_facundo.alumno = facundo;
        inscripcion_facundo.inscripcion_alumno.add(matematica_discreta);
        inscripcion_facundo.inscripcion_alumno.add(algebra);



        //Prueba 1: Inscripcion tomas deberia ser aprobada
        inscripcion_tomas.Verificar_Correlativas();

        //Prueba 2: Inscripcion franco deberia ser rechazada
        inscripcion_franco.Verificar_Correlativas();

        //Prueba 3: Inscripcion facundo deberia ser aprobada
        inscripcion_facundo.Verificar_Correlativas();

}
}


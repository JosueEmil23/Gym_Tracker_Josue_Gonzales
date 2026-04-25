package edu.pe.gymtracker.tasks;

import edu.pe.gymtracker.ui.ExerciseForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddExercise implements Task {
    private final String nombre;
    private final String grupoMuscular;
    private final String tipo;

    public AddExercise(String nombre, String grupoMuscular, String tipo) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.tipo = tipo;
    }

    public static AddExercise withData(String nombre, String grupoMuscular, String tipo) {
        return new AddExercise(nombre, grupoMuscular, tipo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ExerciseForm.ADD_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ExerciseForm.ADD_BUTTON)
        );

        actor.attemptsTo(
                WaitUntil.the(ExerciseForm.NOMBRE_INPUT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ExerciseForm.NOMBRE_INPUT),
                Enter.theValue(nombre).into(ExerciseForm.NOMBRE_INPUT)
        );

        actor.attemptsTo(
                Click.on(ExerciseForm.GRUPO_MUSCULAR_DROPDOWN),
                WaitUntil.the(ExerciseForm.dropdownOption(grupoMuscular), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(ExerciseForm.dropdownOption(grupoMuscular))
        );
        actor.attemptsTo(
                Click.on(ExerciseForm.TIPO_DROPDOW),
                WaitUntil.the(ExerciseForm.dropdownOption(tipo), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(ExerciseForm.dropdownOption(tipo))
        );

        actor.attemptsTo(
                Click.on(ExerciseForm.GUARDAR_BUTTON)
        );


    }
}

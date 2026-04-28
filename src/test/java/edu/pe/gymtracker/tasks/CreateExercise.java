package edu.pe.gymtracker.tasks;

import edu.pe.gymtracker.ui.ExerciseForm;
import edu.pe.gymtracker.ui.ExercisePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateExercise implements Task {

    private final String name;
    private final String muscle;
    private final String type;




    public CreateExercise(String name, String muscle, String type){
        this.name = name;
        this.muscle = muscle;
        this.type = type;
    }


    public static CreateExercise whitDetails(String name, String muscle, String type){
        return Tasks.instrumented(CreateExercise.class, name, muscle, type);
    }

    @Override public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Enter.theValue(name).into(ExercisePage.NAME_IMPUT),

                Click.on(ExercisePage.MUSCLE_GROUP_DROPDOWN),
                Click.on(ExercisePage.GENERIC_OPTION.of(muscle)),
                Click.on(ExercisePage.TYPE_DROPDOWN),
                WaitUntil.the(ExercisePage.GENERIC_OPTION.of(type), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ExercisePage.GENERIC_OPTION.of(type)),
                Click.on(ExercisePage.SAVE_BUTTON)
        );
    }
}

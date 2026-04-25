package edu.pe.gymtracker.questions;

import edu.pe.gymtracker.ui.ExerciseForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ExerciseVisible implements Question<Boolean> {

    private final String exerciseName;

    public ExerciseVisible(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public static  ExerciseVisible named(String exerciseName) {
        return new ExerciseVisible(exerciseName);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ExerciseForm.exerciseInList(exerciseName)).answeredBy(actor);
    }
}

package edu.pe.gymtracker.stepdefinitions;

import edu.pe.gymtracker.questions.ExerciseVisible;
import edu.pe.gymtracker.tasks.CreateExercise;
import edu.pe.gymtracker.ui.ExercisePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.steps.StepEventBus;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GymTrackerStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        if (net.thucydides.core.steps.StepEventBus.getEventBus() != null) {
            net.thucydides.core.steps.StepEventBus.getEventBus().registerListener(
                    new net.thucydides.core.steps.BaseStepListener(new java.io.File("target/site/serenity"))
            );
        }

        OnStage.theActorCalled("Josue");
    }



    @Given("que el usuario abre la app GymTracker")
    public void elUsuarioAbreLaAppGymTracker(){
        OnStage.theActorCalled("Josue");
    }

    @When("presiona el boton de agregar ejercicio")
    public void presionaElBotonDeAgregarEjercicio(){
        theActorInTheSpotlight().attemptsTo(
                Click.on(ExercisePage.ADD_BUTTON)
        );
    }

    @When("ingresa el nombre {string}")
    public void ingresaElNombre(String name){

    }

    @When("selecciona el grupo muscular {string}")
    public void seleccionaElGrupoMuscular(String group){

    }

    @When("selecciona el tipo {string}")
    public void seleccionaElTipo(String type){

    }

    @When("guarda el ejercicio")
    public void guardaElEjercicio(){
        theActorInTheSpotlight().attemptsTo(
                CreateExercise.whitDetails("Correr en cinta", "Piernas", "Cardio")
        );
    }


    @Then("deberia ver el ejercicio {string} en la lista")
    public void deberiaVerElEjercicio(String nombre){
        theActorInTheSpotlight().should(
                seeThat(ExerciseVisible.named(nombre), Matchers.is(true))
        );
    }
}

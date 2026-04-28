package edu.pe.gymtracker.stepdefinitions;


import edu.pe.gymtracker.questions.ExerciseVisible;
import edu.pe.gymtracker.tasks.CreateExercise;
import edu.pe.gymtracker.ui.ExercisePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;
import net.thucydides.core.steps.StepEventBus;
import nonapi.io.github.classgraph.utils.Assert;
import org.hamcrest.Matchers;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


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
        boolean encontrado = false;
        for(int i=0; i<3; i++) {
            if(ExercisePage.EXERCISE_BY_NAME.of(nombre).resolveFor(theActorInTheSpotlight()).isVisible()) {
                encontrado = true;
                break;
            }
            try { Thread.sleep(2000); } catch (Exception e) {}
        }

        if (!encontrado) {
            throw new RuntimeException("ERROR: El ejercicio '" + nombre + "' no apareció tras 3 intentos.");
        }

    }



    @Given("existe el ejercicio {string} en la lista")
    public void existeElEjercicioEnLaLista(String nombre) {
        theActorInTheSpotlight().should(
                seeThat(the(ExercisePage.EXERCISE_BY_NAME.of(nombre)), isVisible())
                        .orComplainWith(AssertionError.class, "El ejercicio '" + nombre + "' no aparece.")
        );
    }

    @When("selecciona el ejercicio {string}")
    public void seleccionaElEjercicio(String nombre) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ExercisePage.EXERCISE_BY_NAME.of(nombre))
        );
    }


    @And("cambia el nombre a {string}")
    public void cambiaElNombreA(String nuevoNombre) {
        theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.actions.Clear.field(ExercisePage.NAME_IMPUT),
                Enter.theValue(nuevoNombre).into(ExercisePage.NAME_IMPUT)
        );
    }



    }


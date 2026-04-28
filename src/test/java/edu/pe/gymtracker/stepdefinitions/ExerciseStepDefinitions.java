package edu.pe.gymtracker.stepdefinitions;

import edu.pe.gymtracker.questions.ExerciseVisible;
import edu.pe.gymtracker.tasks.AddExercise;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ExerciseStepDefinitions {

    @Managed
    private WebDriver driver;

    private Actor actor;
    private String nombre;
    private String grupoMuscular;
    private String tipo;

    /*
    @Given("que el usuario abre la app GymTracker")
    public void que_el_usuario_abre_la_app_GymTracker() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(driver));
    }


    @When("presiona el boton de agregar ejercicio")
    public void presiona_el_boton_de_agregar_ejercicio() {
    }



    @And("ingresa el nombre {string}")
    public void ingresa_el_nombre(String nombre) {
        this.nombre = nombre;
    }

    @And("selecciona el grupo muscular {string}")
    public void selecciona_el_grupo_muscular(String grupo) {
        this.grupoMuscular = grupo;
    }

    @And("selecciona el tipo {string}")
    public void selecciona_el_tipo(String tipo) {
        this.tipo = tipo;
    }

    @And("guarda el ejercicio")
    public void guarda_el_ejercicio() {
        actor.attemptsTo(
                AddExercise.withData(this.nombre, this.grupoMuscular, this.tipo)
        );
    }

    @Then("deberia ver el ejercicio {string} en la lista")
    public void deberia_ver_el_ejercicio_en_la_lista(String nombre) {
        assertTrue(actor.asksFor(ExerciseVisible.named(nombre)));
    }
    */

}

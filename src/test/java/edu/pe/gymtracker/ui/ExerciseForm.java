package edu.pe.gymtracker.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ExerciseForm {

    public static final Target ADD_BUTTON = Target.the("boton agregar ejercicio")
            .located(AppiumBy.xpath("//android.widget.Button"));

    public static final Target NOMBRE_INPUT = Target.the("Campo nombre del ejercicio")
            .located(AppiumBy.xpath("//android.widget.EditText[1]"));

    public static final Target GRUPO_MUSCULAR_DROPDOWN = Target.the("dropdown grupo muscular")
            .located(AppiumBy.xpath("//android.widget.EditText[@text='Pecho']/android.view.View[2]"));

    public static final Target TIPO_DROPDOW = Target.the("dropdown tipo")
            .located(AppiumBy.xpath("//android.widget.EditText[@text='Fuerza']/android.view.View[2]"));

    public static final Target GUARDAR_BUTTON = Target.the("boton guardar")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Guardar']"));


    public static Target dropdownOption(String option) {
        return Target.the("ejercicio " + option + " en lista")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + option + "']"));
    }

    public static Target exerciseInList(String name) {
        return Target.the("ejercicio " + name + " en lista")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']"));
    }


}
package edu.pe.gymtracker.ui;


import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ExercisePage {

    public static final Target ADD_BUTTON = Target.the("boton agregar")
            .located(AppiumBy.xpath("//android.view.View[@content-desc='Agregar Ejercicio']"));

    public static final Target NAME_IMPUT = Target.the("campo nombre ejercicio")
            .located(AppiumBy.xpath("(//android.widget.EditText)[1]"));

    public static final Target MUSCLE_GROUP_DROPDOWN = Target.the("selector grupo muscular")
            .located(AppiumBy.xpath("(//android.widget.EditText)[2]"));

    public static final Target TYPE_DROPDOWN = Target.the("selector tipo")
            .located(AppiumBy.xpath("(//android.widget.EditText)[3]"));

    public static final Target SAVE_BUTTON = Target.the("boton guardar")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Guardar']"));

    public static final Target GENERIC_OPTION = Target.the("opcion {0}")
            .locatedBy("//*[@text='{0}']");


}

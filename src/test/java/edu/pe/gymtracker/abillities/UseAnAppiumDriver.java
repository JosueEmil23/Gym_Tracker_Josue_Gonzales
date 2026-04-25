package edu.pe.gymtracker.abillities;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class UseAnAppiumDriver implements Ability {
    private final AndroidDriver driver;

    public UseAnAppiumDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    public static  UseAnAppiumDriver with(AndroidDriver driver){
        return new UseAnAppiumDriver(driver);
    }

    public AndroidDriver getDriver(){
        return driver;
    }
    public static AndroidDriver as (Actor actor){
        return actor.abilityTo(UseAnAppiumDriver.class).getDriver();
    }


}

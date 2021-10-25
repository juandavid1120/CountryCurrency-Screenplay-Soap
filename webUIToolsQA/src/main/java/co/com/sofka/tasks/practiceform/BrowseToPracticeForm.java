package co.com.sofka.tasks.practiceform;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.practiceform.PracticeForm.*;

public class BrowseToPracticeForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ELEMENTS),
                Click.on(ELEMENTS),

                Scroll.to(FORMS),
                Click.on(FORMS),

                Scroll.to(PRACTICE_FORM),
                Click.on(PRACTICE_FORM)

        );
    }

    public static BrowseToPracticeForm browseToPracticeForm(){
        return new BrowseToPracticeForm();
    }
}

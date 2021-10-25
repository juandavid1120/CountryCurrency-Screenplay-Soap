package co.com.sofka.stepdefnitions.soap.calculator.add;

import co.com.sofka.stepdefnitions.soap.calculator.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofka.questions.ReturnStringValue.systemValue;
import static co.com.sofka.tasks.calculator.DoPost.doPost;
import static co.com.sofka.util.FileUtilities.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.containsString;

public class AddWithCucumberStepDefinition extends SetUp {

    private static final String ADD_XML = System.getProperty("user.dir") + "\\src\\test\\resources\\calculator\\add.xml";
    private static final String INT_A = "[codigoISO]";



    @Given("que el usuario de la aplicacion ha definido como codigo el {string}")
    public void que_el_usuario_de_la_aplicacion_ha_definido_como_codigo_el(String StringA) {
        setUp();
        bodyRequest = defineBodyRequest(StringA);
    }

    @When("el usuario de la aplicacion ejecuta la busqueda")
    public void el_usuario_de_la_aplicacion_ejecuta_la_busqueda() {
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("el usuario debería obtener el resultado {string} y {string}")
    public void el_usuario_debería_obtener_el_resultado_y(String codigoISO, String moneda) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El resultado de la peticion debe ser: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString("<m:sName>"+moneda+"</m:sName>" )
                )
        );
    }

    @Given("que el usuario de la aplicacion ha definido como codigoISO el {string}")
    public void que_el_usuario_de_la_aplicacion_ha_definido_como_codigoISO_el(String StringA) {
        setUp();
        bodyRequest = defineBodyRequest(StringA);
    }
    @When("el usuario de la aplicacion ejecuta la busqueda en aplicacion ")
    public void el_usuario_de_la_aplicacion_ejecuta_la_busqueda_en_aplicacion() {
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }
    @Then("el usuario debería obtener el resultado {string}")
    public void el_usuario_debería_obtener_el_resultado(String stringB) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El resultado de la peticion debe ser: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString( "<m:sName>"+stringB+"</m:sName>")
                )
        );
    }

    /*@Given("que el usuario de la calculadora ha definido como sumandos el {int} y el {int}")
    public void queElUsuarioDeLaCalculadoraHaDefinidoComoSumandosElYEl(Integer intA, Integer intB) {
        setUp();
        bodyRequest = defineBodyRequest(intA, intB);
    }

    @When("el usuario de la calculadora ejecuta el cálculo")
    public void elUsuarioDeLaCalculadoraEjecutaElCalculo() {
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("el ususario debería obtener el resultado {int}")
    public void elUsusarioDeberiaObtenerElResultado(Integer total) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El resultado de la suma debe ser: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString("<AddResult>" + total + "</AddResult>")
                )
        );
    }
*/
    private String defineBodyRequest(String StringA){
        return readFile(ADD_XML)
                .replace(INT_A, StringA.toString());

    }





}

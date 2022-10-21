package step_definitions;

import cucumber.api.java.en.*;
import java.util.List;

public class MyStepdefs {
    @Given("something is done")
    public void somethingIsDone() {
        System.out.println("udało sie skonfigurowac ogórka");
    }

    @When("{word} is printed")
    public void sampleIsPrinted(String sample) {
        sample = sample + " drugie słowo";
        System.out.println(sample);
    }


    @And("{string} przykład")
    public void kolejnyPrzykład(String przykład) {
        System.out.println(przykład);
    }

    @And("{int} is printed.")
    public void isPrinted(int arg0) {
        System.out.println(arg0);
    }

    @But("we can use list as well")
    public void weCanUseListAsWell(List<String> list) {
        for(String animal : list){
            System.out.println(animal);
        }
    }

    @Given("people tryingi singing")
    public void peopleTryingiSinging() {
        System.out.println("******singing*******");
    }

    @When("now (.*) trying")
    public void nowPersonTrying(String person) {
        System.out.println("*****" + person + "*****");
    }

    @Then("sings (.*)")
    public void singsUgly(String how) {
        System.out.println("****" + how + "****");
    }
}

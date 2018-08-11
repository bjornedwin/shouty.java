package shouty;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();
    private Map<String, PeopleLocation> priceList;

    @Given("^(.*) is at (\\d+),(\\d+)$")
    public void sean_is_at(String shouter, int xCoord, int yCoord) throws Throwable {
        shouty.setLocation(shouter, new Coordinate(xCoord, yCoord));
    }

    @When("^(.*) shouts$")
    public void sean_shouts(String shouter) throws Throwable {
        shouty.shout(shouter, ARBITRARY_MESSAGE);
    }

    @Then("^Lucy should hear Sean")
    public void lucy_should_hear_sean() throws Throwable {
        assertEquals(true, shouty.getShoutsHeardBy("Lucy").containsKey("Sean"));
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }


    @And("^Lucy should not hear Oscar$")
    public void lucyShouldNotHearOscar() throws Throwable {
        assertEquals(false, shouty.getShoutsHeardBy("Lucy").containsKey("Oscar"));
    }

    @Then("^Lucy should not hear her own shout$")
    public void lucyShouldNotHearHerOwnShout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(false, shouty.getShoutsHeardBy("Lucy").containsKey("Lucy"));
    }

    @Given("^people are located at$")
    public void peopleAreLocatedAt(List<PeopleLocation> peopleLocation) throws Throwable {
        //Initialize data table
//        System.out.println(peopleLocation);
//        PriceList = new HashMap<String, PeopleLocation>();

        for (PeopleLocation people : peopleLocation) {
//            String key = name.getName();
            shouty.setLocation(people.getName(), new Coordinate(people.getXCord(),people.getYCord()));
        }
    }

    @When("^they shout$")
    public void theyShout() throws Throwable {

    }

    @Then("^others should hear if they are within range$")
    public void othersShouldHearIfTheyAreWithinRange() throws Throwable {

    }

    @Then("^Lucy should hear (\\d+) shouts from Sean$")
    public void lucyShouldHearShoutsFromSean(int numOfShouts) throws Throwable {
        assertEquals(numOfShouts, shouty.getShoutsHeardBy("Lucy").get("Sean").size());
    }
}



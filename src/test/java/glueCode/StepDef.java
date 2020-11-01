package glueCode;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.models.PageData;

import static org.hamcrest.Matchers.equalTo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

import static org.junit.Assert.assertEquals;

import utilities.Utils;
import java.util.List;

public class StepDef extends Utils {


    private Response response;
    private List<PageData> pageList ;


    @Given("^To initiate Rest service to get country details with code as \"([^\"]*)\"$")
    public void to_initiate_Rest_service_to_get_country_details_with_code_as(String arg1) throws Throwable {

    	 RestAssured.baseURI = "https://reqres.in";
    	 String EndPointUrl = "/api/users?page=1";
    	 response = RestAssured.given()
    			 .headers("Content-Type", "application/json")
    			 .get(EndPointUrl);
    	 
    	 System.out.println("Response Body is =>  " + response.asString());
    	 Configuration config = Configuration.defaultConfiguration().jsonProvider(new GsonJsonProvider())
    			 .mappingProvider(new GsonMappingProvider());
    			 TypeRef<List<PageData>> typeRef = new TypeRef<List<PageData>>() {
    			 };
    			 pageList = com.jayway.jsonpath.JsonPath.using(config)
    			 .parse(response.asString()).read("data..[?(@.id == 1)]", typeRef);
    	
    }


    @Then("^Respose status code should be \"([^\"]*)\"$")
    public void respose_status_code_should_be(Integer arg1) throws Throwable {
        // To verify the response status code
        assertEquals("Status Check Failed!", 200, response.getStatusCode());

    }

    @Then("^response should includes the following$")
    public void response_includes_the_following(DataTable arg1) throws Throwable {
    	
    	List < List < String >> data = arg1.raw();
                
        Assert.assertEquals(data.get(1).get(1), pageList.get(0).email);
        Assert.assertEquals(data.get(1).get(2), pageList.get(0).first_name);

    }

}
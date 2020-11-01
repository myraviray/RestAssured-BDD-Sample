$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("API_Test_Scenarios.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#This feature file contains few test scenarios to verify Rest API services"
    },
    {
      "line": 2,
      "value": "#Author: Jagan Duraisamy"
    }
  ],
  "line": 3,
  "name": "To verify API automation with Rest Assured",
  "description": "",
  "id": "to-verify-api-automation-with-rest-assured",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "To verify Rest service - GET Method",
  "description": "",
  "id": "to-verify-api-automation-with-rest-assured;to-verify-rest-service---get-method",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@API_Test"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "To initiate Rest service to get country details with code as \"IN\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Respose status code should be \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "response should includes the following",
  "rows": [
    {
      "cells": [
        "id",
        "email",
        "first_name"
      ],
      "line": 10
    },
    {
      "cells": [
        "1",
        "george.bluth@reqres.in",
        "George"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "IN",
      "offset": 62
    }
  ],
  "location": "StepDef.to_initiate_Rest_service_to_get_country_details_with_code_as(String)"
});
formatter.result({
  "duration": 2542664100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 31
    }
  ],
  "location": "StepDef.respose_status_code_should_be(Integer)"
});
formatter.result({
  "duration": 1529400,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.response_includes_the_following(DataTable)"
});
formatter.result({
  "duration": 1493800,
  "status": "passed"
});
});
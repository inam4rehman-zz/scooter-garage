package scooterGarage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import scooterGarage.garageForce.FleetEngineer;
import scooterGarage.garageForce.GarageForce;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScooterGarageApplicationTests {
	@Autowired
	TestRestTemplate template;
	
	@Test
	public void getRequiredFEs_testCase1() {
		int[] scooters = {15, 10};
		GarageForce garageForce = new GarageForce(scooters, 12, 5);
		HttpEntity<GarageForce> entity = new HttpEntity<>(garageForce);
		ResponseEntity<FleetEngineer> response = template.exchange(("/"),HttpMethod.PUT, entity, FleetEngineer.class);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(3, response.getBody().getFleet_engineers());
	}

	@Test
	public void getRequiredFEs_testCase2() {
		int[] scooters = {11, 15, 13};
		GarageForce garageForce = new GarageForce(scooters, 9, 5);
		HttpEntity<GarageForce> entity = new HttpEntity<>(garageForce);
		ResponseEntity<FleetEngineer> response = template.exchange(("/"),HttpMethod.PUT, entity, FleetEngineer.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(7, response.getBody().getFleet_engineers());
	}

	@Test
	public void getRequiredFEs_testCase3() {
		int[] scooters = {8,16,17,29,40};
		GarageForce garageForce = new GarageForce(scooters, 12, 8);
		HttpEntity<GarageForce> entity = new HttpEntity<>(garageForce);
		ResponseEntity<FleetEngineer> response = template.exchange(("/"),HttpMethod.PUT, entity, FleetEngineer.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(13, response.getBody().getFleet_engineers());
	}

	@Test
	public void getRequiredFEs_testCase4() {
		int[] scooters = {8,16,17,18,19,20};
		GarageForce garageForce = new GarageForce(scooters, 12, 8);
		HttpEntity<GarageForce> entity = new HttpEntity<>(garageForce);
		ResponseEntity<FleetEngineer> response = template.exchange(("/"),HttpMethod.PUT, entity, FleetEngineer.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(13, response.getBody().getFleet_engineers());
	}

	@Test
	public void getRequiredFEs_testCase5() {
		int[] scooters = {0,1000,500,10,13,999};
		GarageForce garageForce = new GarageForce(scooters, 85, 900);
		HttpEntity<GarageForce> entity = new HttpEntity<>(garageForce);
		ResponseEntity<FleetEngineer> response = template.exchange(("/"),HttpMethod.PUT, entity, FleetEngineer.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(6, response.getBody().getFleet_engineers());
	}
}
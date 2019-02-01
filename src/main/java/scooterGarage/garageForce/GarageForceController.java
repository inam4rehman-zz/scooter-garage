package scooterGarage.garageForce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GarageForceController {
    private  GarageForceService garageForceService;

    @Autowired
    GarageForceController(GarageForceService garageForceService){
        this.garageForceService = garageForceService;
    }

    @PutMapping
    ResponseEntity getRequiredFEs(@RequestBody GarageForce garageForce) {
        FleetEngineer fleetEngineer = new FleetEngineer();
        fleetEngineer.fleet_engineers = garageForceService.getRequiredFEs(garageForce);
        return new ResponseEntity(fleetEngineer, HttpStatus.OK);
    }
}

package scooterGarage.garageForce;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Service
public class GarageForceService {
    String getRequiredFEs(@NotNull GarageForce garageForce) {

        int[] scootersArray = garageForce.getScooters(); // # of scooters in all districts
        int FMServe = garageForce.getC(); // FM is able to maintain up to C scooters
        int FEServe = garageForce.getP(); // FE is able to maintain up to P scooters
        ArrayList<Integer> requiredFEs =  new ArrayList<>();
        ArrayList<Integer> reqMinimumFEs =  new ArrayList<>();

        /* Populate an array with # of FEs required to work in a single district
            and another array with # of FEs required to help FM in a single district */
        for (int scooters : scootersArray) {
            // round the # of FE, e.g 1.x should be 2
            int fe = scooters/FEServe + ((scooters % FEServe == 0) ? 0 : 1);
            requiredFEs.add(fe);
            
            int remainingScooters = scooters - FMServe; // # scooters not maintained, and required FE's intention
            if (remainingScooters <= 0) {
                reqMinimumFEs.add(0);
            }
            else if (remainingScooters <= FEServe){
                reqMinimumFEs.add(1);
            }
            else {
                reqMinimumFEs.add(remainingScooters / FEServe + ((remainingScooters % FEServe == 0) ? 0 : 1));
            }
        }

        // Now use these two array (requiredFEs and reqMinimumFEs) to find most optimum districts for FM to work
        int minimumFEs = 0;
        for (int i = 0; i < scootersArray.length; i++) {
            int temp = requiredFEs.get(i);
            requiredFEs.set(i,reqMinimumFEs.get(i));

            // if FM works at district [i] then how many FEs required to cover all districts
            int totalFEs = requiredFEs.stream().mapToInt(Integer::intValue).sum();
            if(minimumFEs > 0){
                if(totalFEs < minimumFEs){
                    minimumFEs = totalFEs;
                }
            }
            else{
                minimumFEs = totalFEs;
            }
            requiredFEs.set(i,temp);
        }
        return "{fleet_engineers: "+ minimumFEs + "}";
    }
}
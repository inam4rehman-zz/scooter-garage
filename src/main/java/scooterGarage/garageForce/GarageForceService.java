package scooterGarage.garageForce;

import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;

@Service
public class GarageForceService {
    int getRequiredFEs(@NotNull GarageForce garageForce) {
        int[] scootersArray = garageForce.getScooters(); // # of scooters in all districts
        int FMServe = garageForce.getC(); // FM is able to maintain up to C scooters
        int FEServe = garageForce.getP(); // FE is able to maintain up to P scooters
        int totalFEs = 0;
        int FEsupervise;
        int FEremain = 0;

        for (int scooters : scootersArray) {
            int FErequired = scooters / FEServe + ((scooters % FEServe == 0) ? 0 : 1);
            totalFEs += FErequired;
            int remainingScooters = Math.max(scooters - FMServe, 0); // -ve means 0
            FEsupervise = remainingScooters / FEServe + ((remainingScooters % FEServe == 0) ? 0 : 1);
            int minimumFEs = FErequired - FEsupervise;
            FEremain = minimumFEs > FEremain ? minimumFEs : FEremain;

        }
        return totalFEs-FEremain;
    }
}
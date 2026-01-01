package sweets;

import java.util.Arrays;
import java.util.Objects;
public class Present {
    private Sweet[] sweets;
    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
        return Arrays.stream(sweets)
            .filter(sweet -> sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight)
                .toArray(Sweet[]::new);
    }
    public double calculateTotalWeight() {
        return Arrays.stream(sweets).mapToDouble(Sweet::getWeight).sum();
    }
    // the method that adds sweet to the present
    public void addSweet(Sweet sweet) {
        
    }
    public Sweet[] getSweets() {
        return Arrays.stream(sweets)
            .filter(Objects::nonNull)
                .toArray(Sweet[]::new);
    }

}

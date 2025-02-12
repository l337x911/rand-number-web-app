package org.vaadin.example;

import java.io.Serializable;
import java.util.Random;
import java.util.function.Function;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberGeneratorService implements Serializable, Function<String, String> {

    public String apply(String seed) {
        Random rng = null;
        if (seed == null || seed.equals("")) {
            rng = new Random();
        } else {
            try {
                long lSeed = Long.parseLong(seed);
                rng = new Random(lSeed);
            } catch (NumberFormatException e) {
                return "seed is not a number.";
            }

        }
        return "" + rng.nextLong();
    }

}

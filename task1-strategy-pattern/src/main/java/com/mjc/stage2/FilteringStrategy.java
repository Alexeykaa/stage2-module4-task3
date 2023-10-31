package com.mjc.stage2;

import java.util.function.Predicate;

public interface FilteringStrategy extends Predicate<Product> {
    boolean filter(Product product);

    default boolean test(Product product) {
        return filter(product);
    }
}

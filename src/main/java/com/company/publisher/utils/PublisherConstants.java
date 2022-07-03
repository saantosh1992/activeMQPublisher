package com.company.publisher.utils;

import java.util.Arrays;
import java.util.List;

public final class PublisherConstants {

    private PublisherConstants() {
        // Default constructor
    }

    public static final String QUEUE_NAME = "TASK-QUEUE-5";
    public static final String CLIENT_ID = "CLIENT_ID_1001";

    public static final int ITEM_COUNT = 5;
    public static final List<String> AVAILABLE_ITEMS = Arrays.asList("Coke", "Sprite", "Maaza", "Fanta", "Pepsi");

    public static final List<String> ITEM_AVAILABLE_LOCATION = Arrays.asList("Cold-Drink-Store-1",
            "Cold-Drink-Store-2",
            "Cold-Drink-Store-3",
            "Cold-Drink-Store-4",
            "Cold-Drink-Store-5");

}

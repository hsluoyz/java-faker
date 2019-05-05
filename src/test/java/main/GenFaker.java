package main;

import com.github.javafaker.Faker;
import org.junit.Test;

import static main.TestUtil.generateRandomUseragents;

public class GenFaker {
    @Test
    public void main() {
        Faker faker = new Faker();

        generateRandomUseragents("faker", faker.internet()::userAgentAny, 70);
    }
}

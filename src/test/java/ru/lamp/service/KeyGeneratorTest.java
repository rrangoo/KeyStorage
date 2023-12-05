package ru.lamp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lamp.model.PublicKey;

import java.util.Random;

class KeyGeneratorTest {

    private KeyGenerator keyGenerator;
    private Random random;

    @BeforeEach
    public void init() {
        random = new Random();
        keyGenerator = new KeyGeneratorImpl(random);
    }

    @Test
    public void generateKeyWithInValidLengthTest() {
        int length = 0;

        Assertions.assertThrows(RuntimeException.class, () -> keyGenerator.generatePublicKey(length));
    }

    @Test
    public void generateKeyWithValidLengthTest() {
        int length = 3;

        PublicKey publicKey = keyGenerator.generatePublicKey(length);

        Assertions.assertEquals(length, publicKey.getKey().length);
    }
}
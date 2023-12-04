package ru.lamp;

import ru.lamp.model.PublicKeyInfo;
import ru.lamp.service.KeyGenerator;
import ru.lamp.service.KeyGeneratorImpl;
import ru.lamp.service.KeyStorage;
import ru.lamp.service.KeyStorageImpl;
import ru.lamp.model.PublicKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<Long, PublicKey> storage = new HashMap<>();
        KeyStorage keyStorage = new KeyStorageImpl(storage);

        KeyGenerator generator = new KeyGeneratorImpl(new Random());


        PublicKeyInfo publicKeyInfo1 = generator.generatePublicKey(4);
        PublicKeyInfo publicKeyInfo2 = generator.generatePublicKey(7);
        PublicKeyInfo publicKeyInfo3 = generator.generatePublicKey(20);
        PublicKeyInfo publicKeyInfo4 = generator.generatePublicKey(8);

        PublicKey publicKey1 = keyStorage.addNewKey(publicKeyInfo1);
        PublicKey publicKey2 = keyStorage.addNewKey(publicKeyInfo2);
        PublicKey publicKey3 = keyStorage.addNewKey(publicKeyInfo3);
        PublicKey publicKey4 = keyStorage.addNewKey(publicKeyInfo4);

        PublicKey getKey1 = keyStorage.getKeyById(publicKey1.getKeyId());
    }
}
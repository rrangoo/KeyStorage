package ru.lamp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lamp.model.Client;
import ru.lamp.model.PublicKey;

import java.util.HashMap;
import java.util.Map;

class KeyStorageTest {
    private KeyStorage keyStorage;
    private Map<Client, PublicKey> storage;

    private String name;
    private Client client;

    private byte[] key;
    private PublicKey publicKey;

    @BeforeEach
    public void init() {
        storage = new HashMap<>();
        keyStorage = new KeyStorageImpl(storage);

        name = "client";
        client = new Client("");
        key = new byte[]{1, 2, 3};
        publicKey = new PublicKey(key);

    }

    @Test
    public void getExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());

        PublicKey newKey = keyStorage.addNewKey(client, publicKey);
        Assertions.assertEquals(publicKey.getKey(), newKey.getKey());

        Assertions.assertEquals(1, storage.size());

        PublicKey actual = keyStorage.getKey(client);
        Assertions.assertEquals(newKey.getKey(), actual.getKey());
    }

    @Test
    public void getNonExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());

        Assertions.assertThrows(RuntimeException.class, () -> keyStorage.getKey(client));
    }

    @Test
    public void addNonExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());
        PublicKey actual = keyStorage.addNewKey(client, publicKey);

        Assertions.assertEquals(1, storage.size());
        Assertions.assertEquals(key, actual.getKey());

        PublicKey obtainedKey = keyStorage.getKey(client);
        Assertions.assertEquals(key, obtainedKey.getKey());
    }

    @Test
    public void addExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());

        keyStorage.addNewKey(client, publicKey);
        Assertions.assertEquals(1, storage.size());

        Assertions.assertThrows(RuntimeException.class, () -> keyStorage.addNewKey(client, publicKey));
        Assertions.assertEquals(1, storage.size());
    }

    @Test
    public void updateNonExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());

        Assertions.assertThrows(RuntimeException.class, () -> keyStorage.updateKey(client, publicKey));
    }

    @Test
    public void updateExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());
        PublicKey actual = keyStorage.addNewKey(client, publicKey);

        Assertions.assertEquals(1, storage.size());
        Assertions.assertEquals(key, actual.getKey());

        byte[] newKey = new byte[]{5, 6, 7};
        PublicKey newPublicKey = new PublicKey(newKey);

        PublicKey prevKey = keyStorage.updateKey(client, newPublicKey);
        Assertions.assertEquals(key, prevKey.getKey());

        PublicKey editedKey = keyStorage.getKey(client);

        Assertions.assertEquals(newKey, editedKey.getKey());
    }

    @Test
    public void deleteNonExistedPublicKeyTest() {
        Assertions.assertEquals(0, storage.size());
        Assertions.assertThrows(RuntimeException.class, () -> keyStorage.deleteKey(client));
    }

    @Test
    public void deleteExistedPublicKeyTest() {
        keyStorage.addNewKey(client, publicKey);
        Assertions.assertEquals(1, storage.size());

        PublicKey actual = keyStorage.deleteKey(client);

        Assertions.assertEquals(0, storage.size());
        Assertions.assertEquals(key, actual.getKey());
        Assertions.assertThrows(RuntimeException.class, () -> keyStorage.getKey(client));
    }
}
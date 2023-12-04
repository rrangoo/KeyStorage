package ru.lamp.service;

import ru.lamp.model.PublicKey;
import ru.lamp.model.PublicKeyInfo;

import java.util.Map;
import java.util.Random;

/**
 * Реализация интерфейса системы хранения ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class KeyStorageImpl implements KeyStorage {

    /**
     * База данных ключей.
     */
    private final Map<Long, PublicKey> storage;

    /**
     * Конструктор для создания хранилища.
     * @param storage объект таблицы ключей.
     */
    public KeyStorageImpl(Map<Long, PublicKey> storage) {
        this.storage = storage;
    }

    /**
     * Метод для получения ключа по уникальному идентификатору.
     * Проверяет наличие ключа в таблице и, если он там есть, достает его.
     * @param keyId уникальный идентификатор ключа.
     * @return В случае наличия ключа, возвращает его.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey getKeyById(Long keyId) {
        if (containsKey(keyId)){
            return storage.get(keyId);
        }

        throw new RuntimeException(String.format("Key with id: %s was not found!", keyId));
    }

    /**
     * Метод для регистрации ключа в системе.
     * Создает новый объект ключа и сохраняет его в таблице {@link storage}.
     * @param publicKeyInfo объект ключа для регистрации.
     * @return Новый объект ключа.
     */
    @Override
    public PublicKey addNewKey(PublicKeyInfo publicKeyInfo) {
        Random random = new Random();
        Long keyId = random.nextLong();

        while (!containsKey(keyId)) {
            keyId = random.nextLong();
        }

        PublicKey publicKey = new PublicKey(keyId, publicKeyInfo);
        storage.put(keyId, publicKey);

        return publicKey;
    }

    /**
     * Метод для изменения данных в существующем ключе.
     * Проверяет наличие ключа в таблице и, если он там есть, изменяет его.
     * @param keyId Идентификатор ключа для изменения.
     * @param publicKey Ключ с новыми данными.
     * @return Возвращает предыдущую версию ключа.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey updateKey(Long keyId, PublicKey publicKey) {
        if (containsKey(keyId)) {
            return storage.put(keyId, publicKey);
        }

        throw new RuntimeException(String.format("Key with id: %s was not found!", keyId));
    }

    /**
     * Метод для удаления данных в существующем ключе.
     * Проверяет наличие ключа в таблице и, если он там есть, удаляет его.
     * @param keyId Идентификатор ключа для удаления.
     * @return Возвращает удаленный ключ.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey deleteKey(Long keyId) {
        if (containsKey(keyId)) {
            return storage.remove(keyId);
        }

        throw new RuntimeException(String.format("Key with id: %s was not found!", keyId));
    }

    /**
     * Метод для проверки существования ключа в таблице.
     * @param keyId Идентификатор ключа для проверки.
     * @return Возвращает true если ключ с представленным id есть в таблице, и false если такого ключа нет.
     */
    private boolean containsKey(Long keyId){
        return storage.containsKey(keyId);
    }
}

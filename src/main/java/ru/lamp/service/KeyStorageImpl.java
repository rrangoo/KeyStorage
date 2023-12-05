package ru.lamp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lamp.model.Client;
import ru.lamp.model.PublicKey;

import java.util.Arrays;
import java.util.Map;

/**
 * Реализация интерфейса системы хранения ключей.
 *
 * @author Бажов Никита
 * @version 1.0.0
 */
public class KeyStorageImpl implements KeyStorage {

    /**
     * Логгер.
     */
    private static Logger logger = LoggerFactory.getLogger(KeyStorageImpl.class);

    /**
     * База данных ключей.
     */
    private final Map<Client, PublicKey> storage;

    /**
     * Конструктор для создания хранилища.
     *
     * @param storage объект таблицы ключей.
     */
    public KeyStorageImpl(Map<Client, PublicKey> storage) {
        this.storage = storage;
    }

    /**
     * Метод для получения ключа по уникальному идентификатору.
     * Проверяет наличие ключа в таблице и, если он там есть, достает его.
     *
     * @param client уникальный идентификатор ключа.
     * @return В случае наличия ключа, возвращает его.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey getKey(Client client) {
        if (containsKey(client)) {
            logger.info(String.format("Key with client: %s was found.", client));
            return storage.get(client);
        }

        throw new RuntimeException(String.format("Key with id: %s was not found!", client));
    }

    /**
     * Метод сохраняет ключ в таблице и связывает его с клиентом {@link storage}.
     *
     * @param publicKey объект ключа для регистрации.
     * @param client    клиент, сохраняющий ключ.
     * @return Новый объект ключа.
     * @throws RuntimeException В случае наличия клиента в хранилище, выбрасывается исключение.
     */
    @Override
    public PublicKey addNewKey(Client client, PublicKey publicKey) {
        if (containsKey(client)) {
            logger.info(String.format("Key with client: %s already exist!", client));
            throw new RuntimeException(String.format("Key with client: %s already existed!", client));
        }

        logger.info("Adding new key.");
        storage.put(client, publicKey);

        return publicKey;
    }

    /**
     * Метод для изменения данных в существующем ключе.
     * Проверяет наличие ключа в таблице и, если он там есть, изменяет его.
     *
     * @param client    Идентификатор ключа для изменения.
     * @param publicKey Ключ с новыми данными.
     * @return Возвращает предыдущую версию ключа.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey updateKey(Client client, PublicKey publicKey) {
        if (containsKey(client)) {
            logger.info(String.format("Updating key with client: %s.", client));
            return storage.put(client, publicKey);
        }


        throw new RuntimeException(String.format("Key with id: %s was not found!", client));
    }

    /**
     * Метод для удаления данных в существующем ключе.
     * Проверяет наличие ключа в таблице и, если он там есть, удаляет его.
     *
     * @param client Идентификатор ключа для удаления.
     * @return Возвращает удаленный ключ.
     * @throws RuntimeException Если ключ не найден, выбрасывает исключение с сообщением.
     */
    @Override
    public PublicKey deleteKey(Client client) {
        if (containsKey(client)) {
            logger.info(String.format("Deleting key with client: %s.", client));
            return storage.remove(client);
        }

        throw new RuntimeException(String.format("Key with id: %s was not found!", client));
    }

    /**
     * Метод для проверки существования ключа в таблице.
     *
     * @param client Идентификатор ключа для проверки.
     * @return Возвращает true если ключ с представленным id есть в таблице, и false если такого ключа нет.
     */
    private boolean containsKey(Client client) {
        logger.info("Search key in storage.");
        return storage.containsKey(client);
    }
}

package ru.lamp.service;

import ru.lamp.model.Client;
import ru.lamp.model.PublicKey;

/**
 * Интерфейс, описывающий систему хранения ключей.
 * Содержит методы для создания, удаления, изменения и чтения ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public interface KeyStorage {

    /**
     * Метод для получения ключа по клиенту.
     * @param client клиент.
     * @return В случае наличия ключа, возвращает его.
     */
    PublicKey getKey(Client client);

    /**
     * Метод для регистрации ключа в системе.
     * @param publicKey объект ключа для регистрации.
     * @param client клиент для привязки ключа.
     * @return Возвращает объект нового ключа, сохраненного в системе.
     */
    PublicKey addNewKey(Client client, PublicKey publicKey);

    /**
     * Метод для изменения данных в существующем ключе.
     * @param client Идентификатор ключа для изменения.
     * @param publicKey Ключ с новыми данными.
     * @return В случае успеха, возвращает предыдущую версию ключа.
     */
    PublicKey updateKey(Client client, PublicKey publicKey);

    /**
     * Метод для удаления существующего ключа.
     * @param client Идентификатор ключа для изменения.
     * @return В случае успеха, возвращает удаленный ключ.
     */
    PublicKey deleteKey(Client client);
}

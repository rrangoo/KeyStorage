package ru.lamp.service;

import ru.lamp.model.PublicKey;
import ru.lamp.model.PublicKeyInfo;

/**
 * Интерфейс, описывающий систему хранения ключей.
 * Содержит методы для создания, удаления, изменения и чтения ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public interface KeyStorage {

    /**
     * Метод для получения ключа по уникальному идентификатору.
     * @param keyId уникальный идентификатор ключа.
     * @return В случае наличия ключа, возвращает его.
     */
    PublicKey getKeyById(Long keyId);

    /**
     * Метод для регистрации ключа в системе.
     * @param publicKeyInfo объект ключа для регистрации.
     * @return Возвращает объект нового ключа, сохраненного в системе.
     */
    PublicKey addNewKey(PublicKeyInfo publicKeyInfo);

    /**
     * Метод для изменения данных в существующем ключе.
     * @param keyId Идентификатор ключа для изменения.
     * @param publicKey Ключ с новыми данными.
     * @return В случае успеха, возвращает предыдущую версию ключа.
     */
    PublicKey updateKey(Long keyId, PublicKey publicKey);

    /**
     * Метод для удаления существующего ключа.
     * @param keyId Идентификатор ключа для изменения.
     * @return В случае успеха, возвращает удаленный ключ.
     */
    PublicKey deleteKey(Long keyId);
}

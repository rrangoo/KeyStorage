package ru.lamp.model;

/**
 * Класс побличного ключа, который зарегистрирован в системе.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class PublicKey {
    /**
     * Уникальный идентификатор ключа в системе.
     */
    private final Long keyId;

    /**
     * Представление ключа в виде массива байт.
     */
    private final byte[] key;

    /**
     * Конструктор для создания объекта ключа в системе из полученных данных.
     * @param keyId Уникальный идентификатор ключа в системе.
     * @param publicKeyInfo Класс, хранящий только представление ключа {@link key}.
     */
    public PublicKey(Long keyId, PublicKeyInfo publicKeyInfo){
        this.keyId = keyId;
        this.key = publicKeyInfo.getKey();
    }

    /**
     * Геттер для поля keyId {@link keyId}.
     * @return Возвращает уникальный идентификатор ключа.
     */
    public Long getKeyId() {
        return keyId;
    }

    /**
     * Геттер для поля key {@link key}.
     * @return Возвращает представление ключа в виде массива байт.
     */
    public byte[] getKey() {
        return key;
    }
}

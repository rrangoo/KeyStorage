package ru.lamp.model;

/**
 * Класс побличного ключа, который еще не зарегистрирован в системе.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class PublicKeyInfo {

    /**
     * Представление ключа в виде массива байт.
     */
    private final byte[] key;

    /**
     * Конструктор для создания объекта представления ключа.
     * @param key представление ключа в виде массива байт.
     */
    public PublicKeyInfo(byte[] key) {
        this.key = key;
    }

    /**
     * Геттер для поля key {@link key}.
     * @return Возвращает представление ключа в виде массива байт.
     */
    public byte[] getKey() {
        return key;
    }
}

package ru.lamp.model;

/**
 * Класс публичного ключа.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class PublicKey {

    /**
     * Представление ключа в виде массива байт.
     */
    private final byte[] key;

    /**
     * Конструктор для создания объекта ключа в системе из полученных данных.
     * @param key Класс, хранящий только представление ключа {@link key}.
     */
    public PublicKey(byte[] key){
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

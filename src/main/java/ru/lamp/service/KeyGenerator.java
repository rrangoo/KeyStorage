package ru.lamp.service;

import ru.lamp.model.PublicKey;

/**
 * Интерфейс, описывающий генератор ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public interface KeyGenerator {
    /**
     * Метод, генерирующий новый ключ.
     * @param length длина генерируемого ключа.
     * @return Возвращает объект публичного ключа.
     */
    PublicKey generatePublicKey(int length);
}

package ru.lamp.service;

import ru.lamp.model.PublicKeyInfo;

/**
 * Интерфейс, описывающий генератор ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public interface KeyGenerator {
    /**
     * Метод, генерирующий новый ключ, который не зарегистрирован в системе.
     * @param length длина генерируемого ключа.
     * @return Возвращает объект публичного ключа, который еще не зарегистрирован в системе.
     */
    PublicKeyInfo generatePublicKey(int length);
}

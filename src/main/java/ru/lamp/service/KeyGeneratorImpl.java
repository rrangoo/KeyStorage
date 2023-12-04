package ru.lamp.service;

import ru.lamp.model.PublicKeyInfo;
import java.util.Random;

/**
 * Реализация интерфейса генератора ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class KeyGeneratorImpl implements KeyGenerator {
    /**
     * Рандом-компонент для генерации ключа.
     */
    private final Random random;

    /**
     * Конструктор для создания генератора ключей.
     * @param random рандом-компонент для генерации.
     */
    public KeyGeneratorImpl(Random random) {
        this.random = random;
    }

    /**
     * Функция генерирует ключ, не зарегистрированный в системе, по заданной длинне.
     * @param length длина генерируемого ключа.
     * @return Ключ, не зарегистрированный в системе.
     */
    @Override
    public PublicKeyInfo generatePublicKey(int length) {
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return new PublicKeyInfo(bytes);
    }
}

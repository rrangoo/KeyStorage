package ru.lamp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lamp.model.PublicKey;

import java.util.Random;

/**
 * Реализация интерфейса генератора ключей.
 * @author Бажов Никита
 * @version 1.0.0
 */

public class KeyGeneratorImpl implements KeyGenerator {

    /**
     * Логгер.
     */
    private static Logger logger = LoggerFactory.getLogger(KeyGeneratorImpl.class);
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
     * Функция генерирует ключ по заданной длинне.
     * @param length длина генерируемого ключа.
     * @return Возвращает публичный ключ.
     * @throws RuntimeException Если длинна ключа меньше 1, выбрасывает исключение.
     */
    @Override
    public PublicKey generatePublicKey(int length) {
        logger.info("Check key length. . .");
        if (length < 1) {
            logger.info("Check failed!");
            throw new RuntimeException(String.format("Length: %s is invalid!", length));
        }

        logger.info("Check pass.");
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);

        logger.info("Generated new key.");
        return new PublicKey(bytes);
    }
}

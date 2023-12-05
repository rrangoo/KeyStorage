package ru.lamp.model;

/**
 * Класс клиента, имеющего ключ.
 * @author Бажов Никита
 * @version 1.0.0
 */
public class Client {

    /**
     * Имя клиента.
     */
    private String name;

    /**
     * Конструктор для создания клиента.
     * @param name имя клиента.
     */
    public Client(String name) {
        this.name = name;
    }

    /**
     * Геттер для имени.
     * @return возвращает имя клиента.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для имени.
     * @param name новое имя клиента.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Переопределения метода сравнения.
     * @param o объект для сравнения.
     * @return true - если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name);
    }

    /**
     * Переопределение хэш-кода.
     * @return хэш-код имени.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

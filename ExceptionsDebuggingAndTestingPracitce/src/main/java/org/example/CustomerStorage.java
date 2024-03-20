package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private static final Logger logger = LogManager.getLogger();
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)  {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        isOverflowed(components.length);
        components[INDEX_PHONE] = phoneChek(components[INDEX_PHONE]);
        emailChek(components[INDEX_EMAIL]);
        logger.info("Все проверки прошли, всё шекспир");
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        logger.info("Добавление отработало.");

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
    public String phoneChek(String number) throws WrongPhoneFormEx{
        String cleaner = "[^0-9]";
        String regPhone = "[0-9]{11}";
        number=number.replaceAll(cleaner,"");
        char firstNumber = number.charAt(0);

        if (firstNumber=='8' || firstNumber=='7'){
            number=number.replaceFirst("8","7");
        }
        else {
            logger.error("Собственное исключение : невалидный номер телефона");
            throw new WrongPhoneFormEx("Неверный формат номера");
        }
        if (!number.matches(regPhone)){
            logger.error("Собственное исключение : невалидный номер телефона");
            throw new WrongPhoneFormEx("Неверный формат номера");
        }
        logger.info("Проверка и форматирование телефона отработала. Будет добавлен номер "+"+"+number);
        return "+"+number;
    }
    public void emailChek(String email) throws WrongEmailFormEx {
        String regEmail = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        Pattern pattern = Pattern.compile(regEmail);
        Matcher matcher = pattern.matcher(email);
        boolean isCorrectEmail = matcher.matches();
        if (!isCorrectEmail){
            logger.error("Собственное исключение : введен невалидный адрес электронной почты");
            throw new WrongEmailFormEx("Электронная почта введена неверно");
        }
        logger.info("Проверка почты отработала.Будет добавлена почта "+email);
    }
    public void isOverflowed(Integer fiveElement) throws OverflowedStringEx {
        if (!(fiveElement ==4)){
            logger.error("Собственное исключение : введено некорректное число строк");
            throw new OverflowedStringEx("Некорректное число строк");
        }
        logger.info("Проверка количества строк отработала.");
    }
}
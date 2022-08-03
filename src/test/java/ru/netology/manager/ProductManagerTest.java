package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductsManager;
import ru.netology.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductsManager manager = new ProductsManager(repository);
    Smartphone phone1 = new Smartphone(1250, "phone1", 54500, "Honor");
    Smartphone phone2 = new Smartphone(4012, "phone2", 52300, "Panasonic");
    Book book1 = new Book(1010, "Confrontation", 810, "King");
    Book book2 = new Book(1004, "The Bronze Horseman", 790, "Pushkin");


    //сохранение
    @Test
    public void shouldFindAll() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = repository.findAll();
        Product[] expected = {phone1, phone2, book1, book2};
        assertArrayEquals(actual, expected);

    }

    //нет добавленных товаров
    @Test
    public void noProducts() {
        Product[] actual = repository.findAll();
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }


    //удаление gj id
    @Test
    public void shouldRemoveById() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);

        manager.removeById(4012);

        Product[] actual = repository.findAll();
        Product[] expected = {phone1, book1, book2};
        assertArrayEquals(actual, expected);
    }


    //поиск

    //подходят все
    @Test

    public void shouldSearchAll() {
        ProductsManager manager = new ProductsManager(repository);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = manager.searchBy("on");
        Product[] expected = {phone1, phone2, book1, book2};
        assertArrayEquals(actual, expected);
    }

    //подходят несколько
    @Test
    public void shouldSearchSeveral() {
        ProductsManager manager = new ProductsManager(repository);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = manager.searchBy("ro");
        Product[] expected = {book1, book2};
        assertArrayEquals(actual, expected);
    }

    //ни один не подходит
    @Test
    public void shouldFndNothing() {
        ProductsManager manager = new ProductsManager(repository);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = manager.searchBy("pro");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }
}

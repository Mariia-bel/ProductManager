package ru.netology.repository;

import ru.netology.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    //сохранение
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];

        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    //получить все сохраненные
    public Product[] findAll() {
        if (products.length == 0) {
            System.out.println("Мы уже работаем над добавлением товаров. Спасибо за понимание.");
        } else {
            return products;
        }
        return products;
    }


    //удаление
    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

}

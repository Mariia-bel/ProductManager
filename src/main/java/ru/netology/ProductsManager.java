package ru.netology;

import ru.netology.repository.ProductRepository;

public class ProductsManager {

    private ProductRepository repository;
    private Product[] products = new Product[0];

    public ProductsManager(ProductRepository repository) {
        this.repository = repository;// передаем репозиторий менеджеру
    }


    //добавление
    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    //поиск
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; //массив для хранения результата поиска

        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}



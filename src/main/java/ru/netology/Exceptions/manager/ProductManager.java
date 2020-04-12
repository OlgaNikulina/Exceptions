package ru.netology.Exceptions.manager;

import ru.netology.Exceptions.NotFoundException;
import ru.netology.Exceptions.repository.ProductRepository;
import ru.netology.Product;

public class ProductManager {
    private ProductRepository repository;

    public void removeById(int id) {
        repository.removeById(id);
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

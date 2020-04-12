package ru.netology.Exceptions.repository;

import ru.netology.Exceptions.NotFoundException;
import ru.netology.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;

        if (findById(id) == null) {
            throwNotFoundException();
        } else {
            removeById(id);
        }
    }

    public void throwRuntimeException() throws RuntimeException {
        throw new RuntimeException();
    }

    public void throwNotFoundException() throws NotFoundException {
        throw new NotFoundException();
    }
}

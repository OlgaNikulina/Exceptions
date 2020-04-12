package ru.netology.Exceptions.manager;

import org.junit.jupiter.api.Test;
import ru.netology.Exceptions.repository.ProductRepository;
import ru.netology.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product[] product = new Product[]{};
    private Product first = new Product(1, "first", 500);
    private Product second = new Product(2, "second", 550);
    private Product third = new Product(3, "third", 4500);

    @Test
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetEmpty() {
        manager.getAll();

        Product[] expected = new Product[]{};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTwoBooks() {
        ProductManager manager = new ProductManager(repository);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.getAll();

        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
package ru.netology.Exceptions.repository;

import org.junit.jupiter.api.Test;
import ru.netology.Exceptions.NotFoundException;
import ru.netology.Exceptions.manager.ProductManager;
import ru.netology.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product first = new Product(1, "first", 500);
    private Product second = new Product(2, "second", 550);
    private Product third = new Product(3, "third", 4500);

    @Test
    void shouldSaveOneItem() {
        repository.save(first);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        repository.removeById(idToRemove);

        Product[] expected = new Product[]{first, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);
        try {
            System.out.println("Element with id: ");
            repository.removeById(idToRemove);
            System.out.println("+");
        }
        catch (NotFoundException e){
            System.out.println(2);
        }
        finally {
            System.out.println(" not found");
        }

        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldThrowRuntimeException(){
        assertThrows(RuntimeException.class), () -> repository.throwRuntimeException();
    }

    @Test
    public void shouldThrowNotFoundException(){
        assertThrows(NotFoundException.class), -> try {
            repository.throwNotFoundException();
        } catch (NotFoundException e) {
            e.printStackTrace();
        };
    }
}

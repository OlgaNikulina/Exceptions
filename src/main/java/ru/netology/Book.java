package ru.netology;

import java.util.Objects;

public class Book extends Product {
    private String author;
    private int pages;
    private int publishedYear;

    public Book() {
    }

    public Book(String author, int pages, int publishedYear) {
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book1 = (Book) o;
        return getPages() == book1.getPages() &&
                getPublishedYear() == book1.getPublishedYear() &&
                getAuthor().equals(book1.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getPages(), getPublishedYear());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pages=" + pages +
                ", publishedYear=" + publishedYear +
                '}';
    }
}

package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    private FilmRepository repository = new FilmRepository();
    private Film first = new Film(1, "Mind Games", "ts", "Animation", false);
    private Film second = new Film(2, "Black Mirror", "ia", "Animation", false);
    private Film third = new Film(3, "Avatar", "i", "Science fiction", false);

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldSaveOne() {
        repository.save(first);
        Film[] expected = new Film[]{first};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        setUp();
        Film[] expected = new Film[]{first, second, third};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        setUp();
        repository.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByID() {
        setUp();
        repository.removeByID(2);
        Film[] expected = new Film[]{first, third};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByFilmID() {
        setUp();
        Film[] expected = new Film[]{first};
        Film[] actual = repository.findByID(1);
        assertArrayEquals(expected, actual);
    }
}
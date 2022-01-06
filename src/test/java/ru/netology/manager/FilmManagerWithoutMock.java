package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTestWithoutMock {

    private FilmRepository repository = new FilmRepository();
    private FilmManager manager = new FilmManager(repository);
    private Film first = new Film(1, "Mind Games", "ts", "Animation", false);
    private Film second = new Film(2, "Black Mirror", "ia", "Animation", false);
    private Film third = new Film(3, "Avatar", "i", "Animation", false);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 1;
        manager.removeByID(idToRemove);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFilmId() {
        int idToFind = 1;
        Film[] expected = new Film[]{first};
        Film[] actual = manager.findByID(idToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByArrayID() {
        int idToFind = 2;
        Film[] expected = new Film[]{first};
        Film[] actual = manager.findByArrayID(idToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        manager.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSeveral() {
        manager.filmsQuantity(2);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getSeveral();
        assertArrayEquals(expected, actual);
    }
}
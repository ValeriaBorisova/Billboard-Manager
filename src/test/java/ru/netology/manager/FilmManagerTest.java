package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmManagerTest {
    @Mock
    private FilmRepository repository;
    @InjectMocks
    private FilmManager manager;
    private Film first = new Film(1, "Mind Games", "mg", "Animation", false);
    private Film second = new Film(2, "Black Mirror", "bm", "Animation", false);
    private Film third = new Film(3, "Avatar", "a", "Animation", false);

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetEmpty() {
        Film[] returned = new Film[0];
        doReturn(returned).when(repository).findAll();

        Film[] expected = new Film[0];
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveByID() {
        setUp();
        int idToRemove = 1;
        Film[] returned = new Film[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeByID(idToRemove);

        manager.removeByID(idToRemove);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeByID(idToRemove);
    }

    @Test
    public void shouldFindByID() {
        setUp();
        int idToFind = 1;
        Film[] returned = new Film[]{first};
        doReturn(returned).when(repository).findByID(idToFind);


        Film[] expected = new Film[]{first};
        Film[] actual = manager.findByID(idToFind);
        assertArrayEquals(expected, actual);

        verify(repository).findByID(idToFind);
    }

    @Test
    public void shouldFindByArrayID() {
        setUp();
        int idToFind = 2;
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        Film[] expected = new Film[]{first};
        Film[] actual = manager.findByArrayID(idToFind);
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveAll() {
        setUp();
        Film[] returned = new Film[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeAll();

        manager.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
        verify(repository).removeAll();
    }

    @Test
    public void shouldGetSeveral() {
        setUp();
        int quantity = 2;
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        manager.filmsQuantity(quantity);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getSeveral();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
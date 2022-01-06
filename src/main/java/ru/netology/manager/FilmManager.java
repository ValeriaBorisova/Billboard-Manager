package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

@Data

public class FilmManager {
    int filmsQuantity = 10;
    FilmRepository repository;

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }

    public void removeByID(int id) {
        repository.removeByID(id);
    }

    public Film[] getSeveral() {
        Film[] tmp = getAll();
        Film[] result = new Film[filmsQuantity()];
        System.arraycopy(tmp, 0, result, 0, filmsQuantity());
        return result;
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Film[] findByID(int id) {
        Film[] result = repository.findByID(id);
        return result;
    }

    public Film[] findByArrayID(int id) {
        Film[] tmp = getAll();
        Film[] result = new Film[1];
        System.arraycopy(tmp, id, result, 0, 1);
        return result;
    }
}
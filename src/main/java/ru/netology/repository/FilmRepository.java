package ru.netology.repository;

import ru.netology.domain.Film;

public class FilmRepository {
    Film[] films = new Film[0];

    public Film[] findAll() {
        return films;
    }

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] findByID(int id) {
        Film[] result = new Film[1];
        for (Film film : films) {
            if (film.id() == id) {
                result[0] = film;
            }
        }
        return result;
    }

    public void removeByID(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.id() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        Film[] del = new Film[0];
        films = del;
    }
}
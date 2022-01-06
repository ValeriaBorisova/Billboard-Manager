package ru.netology.manager;

import lombok.*;
import ru.netology.domain.Film;

@Data

public class FilmManager {
    Film[] films = new Film[0];
    int filmsQuantity = 10;

    public void addFilm(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] getAll() {
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] getSeveral() {
        Film[] result = new Film[filmsQuantity()];
        Film[] tmp = getAll();
        System.arraycopy(tmp, 0, result, 0, filmsQuantity());
        return result;
    }
}
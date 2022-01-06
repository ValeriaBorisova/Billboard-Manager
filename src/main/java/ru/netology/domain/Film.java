package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Film {
    int id;
    String filmName;
    String filmPicture;
    String filmGenre;
    boolean premiereTomorrow;
}


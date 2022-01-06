package ru.netology.domain;

import lombok.*;

@AllArgsConstructor

public class Film {
    int id;
    String filmName;
    String filmPicture;
    String filmGenre;
    boolean premiereTomorrow;
}

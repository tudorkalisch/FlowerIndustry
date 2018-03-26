package com.example.tudorckalisch.flowerindustry.ui.main;

import com.example.tudorckalisch.flowerindustry.model.Flower;

import java.util.List;

public interface MainView {
    void displayFlowers(List<Flower> flowerList);

    void displayError(Throwable error);

    void navigateDetail(Flower flower);
}

package com.example.tudorckalisch.flowerindustry.ui.main;

import com.example.tudorckalisch.flowerindustry.data.FlowerAPI;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private FlowerAPI flowerApi;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        flowerApi = new FlowerAPI(new FlowerAPI.AsyncResponse() {
            @Override
            public void onSuccess(List flowers) {
                view.displayFlowers(flowers);
            }

            @Override
            public void onFail(Throwable error) {
                view.displayError(error);
            }
        });
    }

    @Override
    public void getAllFlowers() {
        flowerApi.loadFlowers();
    }
}

package com.example.tudorckalisch.flowerindustry.data;

import android.util.Log;

import com.example.tudorckalisch.flowerindustry.model.Flower;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlowerAPI {
    private FlowerService flowerService;
    private AsyncResponse asyncResponse;

    public FlowerAPI(AsyncResponse response) {
        Retrofit retrofit = createRetrofit();
        flowerService = retrofit.create(FlowerService.class);
        this.asyncResponse = response;
    }

    public interface AsyncResponse {
        void onSuccess(List flowers);

        void onFail(Throwable error);
    }

    public void loadFlowers() {
        flowerService.loadFlowers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(List<Flower> flowers) {
        Log.e(FlowerAPI.class.getSimpleName(), "Success request from API");
        asyncResponse.onSuccess(flowers);
    }

    private void handleError(Throwable error) {
        Log.e(FlowerAPI.class.getSimpleName(), "Error request from API");
        asyncResponse.onFail(error);
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://demo6165676.mockable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}

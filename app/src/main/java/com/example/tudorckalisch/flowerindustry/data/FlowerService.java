package com.example.tudorckalisch.flowerindustry.data;

import com.example.tudorckalisch.flowerindustry.model.Flower;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FlowerService {
    @GET("/all")
    Observable<List<Flower>> loadFlowers();
}

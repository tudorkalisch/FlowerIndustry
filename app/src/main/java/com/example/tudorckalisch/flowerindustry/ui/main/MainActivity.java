package com.example.tudorckalisch.flowerindustry.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tudorckalisch.flowerindustry.R;
import com.example.tudorckalisch.flowerindustry.model.Flower;
import com.example.tudorckalisch.flowerindustry.ui.detail.DetailActivity;
import com.example.tudorckalisch.flowerindustry.ui.main.adapter.FlowerAdapter;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mainPresenter;

    @BindView(R.id.flowerList)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    void init() {
        mainPresenter = new MainPresenterImpl(this);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mainPresenter.getAllFlowers();
    }

    @Override
    public void displayFlowers(List<Flower> flowerList) {
        adapter = new FlowerAdapter(flowerList, this::navigateDetail);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayError(Throwable error) {
        Toast.makeText(this, "Error getting flowers from server", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateDetail(Flower flower) {
        Intent intent = new Intent(this, DetailActivity.class);
        Parcelable wrapped = Parcels.wrap(flower);
        intent.putExtra("flower", (wrapped));
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}

package com.example.tudorckalisch.flowerindustry.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.example.tudorckalisch.flowerindustry.R;
import com.example.tudorckalisch.flowerindustry.model.Flower;
import com.example.tudorckalisch.flowerindustry.ui.main.MainActivity;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends Activity implements DetailView {
    @BindView(R.id.detail_description)
    TextView description;
    @BindView(R.id.detail_price)
    TextView price;
    @BindView(R.id.detail_deliver_To)
    TextView deliver_to;
    @BindView(R.id.detail_backBtn)
    Button backBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        init();
    }

    void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Parcelable wrapped = extras.getParcelable("flower");
            Flower flower = Parcels.unwrap(wrapped);
            if (flower != null) {
                description.setText(flower.getDescription());
                String pricefromflower = Integer.toString((int) flower.getPrice());
                price.setText(pricefromflower);
                deliver_to.setText(flower.getDeliver_to());
            }
        }
    }

    @OnClick(R.id.detail_backBtn)
    public void setBackBtn() {
        navigateHome();
    }

    @Override
    public void navigateHome() {
        startActivity(new Intent(this, MainActivity.class));
    }
}

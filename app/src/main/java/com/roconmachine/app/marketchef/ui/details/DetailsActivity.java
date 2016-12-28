package com.roconmachine.app.marketchef.ui.details;

import android.os.Bundle;

import com.roconmachine.app.marketchef.R;
import com.roconmachine.app.marketchef.ui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by asus on 12/26/2016.
 */
public class DetailsActivity extends BaseActivity implements DetailsMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activityComponent().inject(this);

        getSupportActionBar().hide();
        setContentView(R.layout.details);
        ButterKnife.bind(this);

        
    }
    @Override
    public void showError(String title, String error) throws Exception {

    }

    @Override
    public void showInfo(String title, String body) throws Exception {

    }
}

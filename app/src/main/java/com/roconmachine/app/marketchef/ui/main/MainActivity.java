package com.roconmachine.app.marketchef.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roconmachine.app.marketchef.R;
import com.roconmachine.app.marketchef.data.model.SearchedItem;
import com.roconmachine.app.marketchef.ui.base.BaseActivity;
import com.roconmachine.app.marketchef.ui.details.DetailsActivity;
import com.roconmachine.app.marketchef.util.MyGson;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String EXTRA_TRIGGER_SYNC_FLAG = "MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @Inject
    MainPresenter mMainPresenter;
    @Inject
    MainListAdapter mainListAdapter;

    @BindView(R.id.listView) RecyclerView mRecyclerView;

    /**
     * Return an Intent to start this Activity.
     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
     * only be set to false during testing.
     */
    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPresenter.attachView(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mainListAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SearchedItem searchedItem = mainListAdapter.getItem(position);
                String json = MyGson.getInstance().objectToJson(searchedItem);
                Map<String, String> stringMap = new HashMap<String, String>();
                stringMap.put(SearchedItem.KEY, json);
                startMarketChefActivity(new Intent(MainActivity.this, DetailsActivity.class), null);
                //Toast.makeText(getApplicationContext(), "clicked position " + position , Toast.LENGTH_LONG).show();
            }
        }));
        mMainPresenter.showSearchedItems();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMainPresenter.detachView();
    }

    /***** MVP View methods implementation *****/

    @Override
    public void showError(String title, String error) throws Exception {

    }

    @Override
    public void showInfo(String title, String body) throws Exception {

    }

    @Override
    public void showSearchedItems(List<SearchedItem> searchedItems) {
        mainListAdapter.setData(searchedItems);
        mainListAdapter.notifyDataSetChanged();
    }



}

package com.roconmachine.app.marketchef.ui.main;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

import com.roconmachine.app.marketchef.R;
import com.roconmachine.app.marketchef.data.DataManager;
import com.roconmachine.app.marketchef.data.model.Ribot;
import com.roconmachine.app.marketchef.data.model.SearchedItem;
import com.roconmachine.app.marketchef.injection.ConfigPersistent;
import com.roconmachine.app.marketchef.ui.base.BasePresenter;
import com.roconmachine.app.marketchef.util.RxUtil;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;


    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();

    }

    public void showSearchedItems()
    {
        Drawable myIcon = getMvpView().getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        SearchedItem searchedItem = new SearchedItem();
        searchedItem.setThumb(myIcon);

        List<SearchedItem> searchedItems = new ArrayList<>(0);
        searchedItem.setDescription("asdf as dfasd sd asdf sdf ");
        searchedItem.setPrice("90.89");
        searchedItem.setTitle("phone cover");
        searchedItems.add(searchedItem);

        searchedItem.setDescription("asdf as dfasd sd asdf sdf ");
        searchedItem.setPrice("90.89");
        searchedItem.setTitle("phone cover");
        searchedItems.add(searchedItem);

        searchedItem.setDescription("asdf as dfasd sd asdf sdf ");
        searchedItem.setPrice("90.89");
        searchedItem.setTitle("phone ");
        searchedItems.add(searchedItem);

        getMvpView().showSearchedItems(searchedItems);

    }

    public void searchedItemSelect(SearchedItem searchedItem)
    {

    }

}

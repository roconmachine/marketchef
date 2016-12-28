package com.roconmachine.app.marketchef.ui.main;

import android.graphics.drawable.Drawable;

import java.util.List;

import com.roconmachine.app.marketchef.data.model.Ribot;
import com.roconmachine.app.marketchef.data.model.SearchedItem;
import com.roconmachine.app.marketchef.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showSearchedItems(List<SearchedItem> searchedItems);
    Drawable getDrawable(int resourceId);

}

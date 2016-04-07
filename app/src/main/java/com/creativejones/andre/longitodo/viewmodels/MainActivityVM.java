package com.creativejones.andre.longitodo.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.creativejones.andre.longitodo.handler.MapHelper;

public class MainActivityVM {

    Context mContext;
    MapHelper mMapHelper;

    /**
     * <p>
     *     Initializes the ViewModel.  If the bundle is not null
     *     The properties are reset from it.
     * </p>
     * @param context
     * @param savedInstanceState
     * @return self
     */
    public MainActivityVM build(Context context, Bundle savedInstanceState) {
        mContext = context;

        mMapHelper = new MapHelper();

        recreateViewModel(savedInstanceState);

        return this;
    }

    @SuppressWarnings("unused")
    public int listVisibility(){
        return true ? View.VISIBLE : View.GONE;
    }

    @SuppressWarnings("unused")
    public int emptyListDisplay(){
        return false ? View.VISIBLE : View.GONE;
    }

    public void saveInstanceState(Bundle outState) {

    }

    //region Private Helpers
    private void recreateViewModel(Bundle from) {
        if(from == null) return;
    }

    public MapHelper getMapHelper() {
        return mMapHelper;
    }
    //endregion
}

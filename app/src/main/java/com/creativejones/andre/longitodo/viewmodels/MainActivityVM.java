package com.creativejones.andre.longitodo.viewmodels;

import android.content.Context;
import android.os.Bundle;

import com.creativejones.andre.longitodo.helper.MapHelper;

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
    public static MainActivityVM newInstance(Context context, Bundle savedInstanceState) {
        MainActivityVM vm = new MainActivityVM();
        vm.mContext = context;
        vm.mMapHelper = new MapHelper();
        vm.recreateViewModel(savedInstanceState);
        return vm;
    }

    @SuppressWarnings("unused")
    public boolean hasTasks(){
        return true;
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

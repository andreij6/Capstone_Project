package com.creativejones.andre.longitodo.viewmodels;

import android.content.Context;
import android.os.Bundle;

public class MapListViewModel {

    Context mContext;

    /**
     * <p>
     *     Initializes the ViewModel.  If the bundle is not null
     *     The properties are reset from it.
     * </p>
     * @param context
     * @param savedInstanceState
     * @return self
     */
    public static MapListViewModel newInstance(Context context, Bundle savedInstanceState) {
        MapListViewModel vm = new MapListViewModel();
        vm.mContext = context;

        if(savedInstanceState != null)
            vm.recreateViewModel(savedInstanceState);

        return vm;
    }

    @SuppressWarnings("unused")
    public boolean hasTasks(){
        return true;
    }

    public void saveInstanceState(Bundle outState) {

    }

    //region Helpers
    private void recreateViewModel(Bundle from) {
        if(from == null) return;
    }
    //endregion
}

package com.creativejones.andre.longitodo.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivityVM {

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
    public MainActivityVM build(Context context, Bundle savedInstanceState) {
        mContext = context;

        recreateViewModel(savedInstanceState);

        return this;
    }

    @SuppressWarnings("unused")
    public int listVisibility(){
        return false ? View.VISIBLE : View.GONE;
    }

    @SuppressWarnings("unused")
    public int emptyListDisplay(){
        return true ? View.VISIBLE : View.GONE;
    }

    public void saveInstanceState(Bundle outState) {

    }

    //region Private Helpers
    private void recreateViewModel(Bundle from) {
        if(from == null) return;
    }


    //endregion
}

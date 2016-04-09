package com.creativejones.andre.longitodo.google;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;

public class GoogleServicesHelper implements GoogleApiClient.ConnectionCallbacks,
                            GoogleApiClient.OnConnectionFailedListener
{
    private static final int REQUEST_CODE_AVAILABILITY = -100;
    private static final int REQUEST_CODE_RESOLUTION = -101;

    GoogleServicesListener mListener;
    Activity mActivity;
    GoogleApiClient mClient;

    public GoogleServicesHelper(GoogleServicesListener listener){
        mListener = listener;
        mActivity = (Activity)listener;

       mClient = new GoogleApiClient.Builder(mActivity)
               .addConnectionCallbacks(this)
               .addOnConnectionFailedListener(this)
               .addApi(Plus.API, Plus.PlusOptions.builder()
                       .setServerClientId("798656238650-r40fl6esh1uj21niehckfn85jtg6cgib.apps.googleusercontent.com")
                       .build())
               .build();
    }

    public void connect(){
        if(isGooglePlayServicesAvailable())
            mClient.connect();
        else
            mListener.onDisconnected();
    }

    public void disconnect(){
        if(isGooglePlayServicesAvailable())
            mClient.disconnect();
        else
            mListener.onDisconnected();
    }

    private boolean isGooglePlayServicesAvailable(){
        int availability = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mActivity);

        boolean isAvailable = true;

        if(availability != ConnectionResult.SUCCESS) {
            GooglePlayServicesUtil.getErrorDialog(availability, mActivity, REQUEST_CODE_AVAILABILITY).show();
            isAvailable = false;
        }

        return isAvailable;
    }

    @Override
    public void onConnected(Bundle bundle) {
        mListener.onConnected();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mListener.onDisconnected();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if(connectionResult.hasResolution()){
            try {
                connectionResult.startResolutionForResult(mActivity, REQUEST_CODE_RESOLUTION);
            } catch (IntentSender.SendIntentException e){
                connect();
            }
        } else {
            mListener.onDisconnected();
        }
    }

    public interface GoogleServicesListener {
        void onConnected();
        void onDisconnected();
    }
}

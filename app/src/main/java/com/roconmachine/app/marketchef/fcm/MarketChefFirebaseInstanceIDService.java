package com.roconmachine.app.marketchef.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import timber.log.Timber;

/**
 * Created by asus on 12/22/2016.
 */
public class MarketChefFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MarketChefFirebaseInstanceIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Timber.d(TAG, "Token :: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Send any registration to your app's servers.
    }
}

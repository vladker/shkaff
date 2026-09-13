package com.appdev.standard.page;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.f;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalFlutterBoostActivity$activityResultRegistry$1 extends ActivityResultRegistry {
    final /* synthetic */ LocalFlutterBoostActivity this$0;

    public LocalFlutterBoostActivity$activityResultRegistry$1(LocalFlutterBoostActivity localFlutterBoostActivity) {
        this.this$0 = localFlutterBoostActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$0(LocalFlutterBoostActivity$activityResultRegistry$1 localFlutterBoostActivity$activityResultRegistry$1, int i5, ActivityResultContract.SynchronousResult synchronousResult) {
        localFlutterBoostActivity$activityResultRegistry$1.dispatchResult(i5, synchronousResult.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(LocalFlutterBoostActivity$activityResultRegistry$1 localFlutterBoostActivity$activityResultRegistry$1, int i5, IntentSender.SendIntentException sendIntentException) {
        localFlutterBoostActivity$activityResultRegistry$1.dispatchResult(i5, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, sendIntentException));
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public <I, O> void onLaunch(int i5, ActivityResultContract<I, O> contract, I i6, ActivityOptionsCompat activityOptionsCompat) {
        Bundle bundle;
        int i7;
        E.f(contract, "contract");
        LocalFlutterBoostActivity localFlutterBoostActivity = this.this$0;
        ActivityResultContract.SynchronousResult<O> synchronousResult = contract.getSynchronousResult(localFlutterBoostActivity, i6);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new f(this, i5, synchronousResult, 3));
            return;
        }
        Intent intentCreateIntent = contract.createIntent(localFlutterBoostActivity, i6);
        if (intentCreateIntent.getExtras() != null) {
            Bundle extras = intentCreateIntent.getExtras();
            E.c(extras);
            if (extras.getClassLoader() == null) {
                intentCreateIntent.setExtrasClassLoader(localFlutterBoostActivity.getClassLoader());
            }
        }
        if (intentCreateIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundle = intentCreateIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            intentCreateIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else {
            bundle = activityOptionsCompat != null ? activityOptionsCompat.toBundle() : null;
        }
        Bundle bundle2 = bundle;
        if (ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(intentCreateIntent.getAction())) {
            String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.requestPermissions(localFlutterBoostActivity, stringArrayExtra, i5);
            return;
        }
        if (!ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(intentCreateIntent.getAction())) {
            ActivityCompat.startActivityForResult(localFlutterBoostActivity, intentCreateIntent, i5, bundle2);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentCreateIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
        try {
            E.c(intentSenderRequest);
            i7 = i5;
            try {
                ActivityCompat.startIntentSenderForResult(localFlutterBoostActivity, intentSenderRequest.getIntentSender(), i7, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new f(this, i7, e, 4));
            }
        } catch (IntentSender.SendIntentException e6) {
            e = e6;
            i7 = i5;
        }
    }
}

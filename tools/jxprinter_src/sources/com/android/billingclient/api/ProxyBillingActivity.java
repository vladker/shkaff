package com.android.billingclient.api;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzla;
import com.google.android.gms.internal.play_billing.zzld;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {
    static final String EXTERNAL_BROADCAST_PERMISSION = "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST";
    private static final String KEY_ACTIVITY_CODE = "activity_code";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;

    @VisibleForTesting
    static final int RESULT_CODE_PLAY_CANCELED_WITH_ON_CREATE_RUNTIME_EXCEPTION = 5;

    @VisibleForTesting
    static final int RESULT_CODE_PLAY_CANCELLED = 3;

    @VisibleForTesting
    static final int RESULT_CODE_PLAY_CANCELLED_WITHOUT_COMPLETE_ACTION = 4;
    private static final String TAG = "ProxyBillingActivity";
    private int activityCode;
    private long billingClientTransactionId;

    @Nullable
    @VisibleForTesting
    j1 billingLogger;

    @Nullable
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;

    @Nullable
    @VisibleForTesting
    t1 proxyBillingBroadcastReceiver;
    private boolean sendCancelledBroadcastIfFinished;
    private boolean wasServiceAutoReconnected;

    private zzjs getLoggingErrorReason(int i5, @Nullable Intent intent) {
        if (intent != null) {
            if (intent.getExtras() == null) {
                return zzjs.NULL_BUNDLE_IN_ACTIVITY_RESULT;
            }
            return i5 == 5 ? zzjs.PLAY_STORE_ON_CREATE_RUNTIME_EXCEPTION : zzjs.REASON_UNSPECIFIED;
        }
        if (i5 == -1) {
            return zzjs.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i5 == 0) {
            return zzjs.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i5 != 3) {
            return i5 != 4 ? zzjs.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzjs.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE;
        }
        return zzjs.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE;
    }

    private boolean isInAppMessageFlow(@Nullable Bundle bundle) {
        if (bundle != null) {
            return bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
        }
        if (getIntent() == null) {
            return false;
        }
        return getIntent().hasExtra("IN_APP_MESSAGE_INTENT");
    }

    private boolean isKnownError(int i5, @Nullable Intent intent) {
        return !getLoggingErrorReason(i5, intent).equals(zzjs.REASON_UNSPECIFIED);
    }

    private boolean isProxyBillingBroadcastReceiverRegistered() {
        return this.proxyBillingBroadcastReceiver != null;
    }

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0064  */
    private Intent makePurchaseUpdatedIntentWithResponseCodeAndReason(zzjs zzjsVar, long j6, boolean z6) {
        Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        if (!z6) {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
            G gNewBuilder = H.newBuilder();
            gNewBuilder.setResponseCode(6);
            gNewBuilder.setDebugMessage("An internal error occurred.");
            H hBuild = gNewBuilder.build();
            int i5 = i1.f2481a;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", i1.zzb(zzjsVar, 2, hBuild, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        } else if (isProxyBillingBroadcastReceiverRegistered() && this.proxyBillingBroadcastReceiver.zza() != null) {
            H hZza = this.proxyBillingBroadcastReceiver.zza();
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", hZza.f2433a);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", hZza.getDebugMessage());
        } else if (!isProxyBillingBroadcastReceiverRegistered() || this.proxyBillingBroadcastReceiver.f2578a) {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
            G gNewBuilder2 = H.newBuilder();
            gNewBuilder2.setResponseCode(6);
            gNewBuilder2.setDebugMessage("An internal error occurred.");
            H hBuild2 = gNewBuilder2.build();
            int i6 = i1.f2481a;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", i1.zzb(zzjsVar, 2, hBuild2, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        } else {
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 3);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Play Store is blocked.");
            G gNewBuilder3 = H.newBuilder();
            gNewBuilder3.setResponseCode(3);
            gNewBuilder3.setDebugMessage("Play Store is blocked.");
            H hBuild3 = gNewBuilder3.build();
            zzjs zzjsVar2 = zzjs.PLAY_STORE_APP_BLOCKED;
            int i7 = i1.f2481a;
            intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", i1.zzb(zzjsVar2, 2, hBuild3, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        }
        intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j6);
        intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return intentMakePurchasesUpdatedIntent;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0037 A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:5:0x001d, B:28:0x006b, B:21:0x0031, B:23:0x0037, B:25:0x0062, B:24:0x004d), top: B:30:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004d A[Catch: all -> 0x0022, TryCatch #1 {all -> 0x0022, blocks: (B:5:0x001d, B:28:0x006b, B:21:0x0031, B:23:0x0037, B:25:0x0062, B:24:0x004d), top: B:30:0x0001 }] */
    private synchronized void registerProxyBillingBroadcastReceiver() throws Throwable {
        ProxyBillingActivity proxyBillingActivity;
        try {
            try {
                this.proxyBillingBroadcastReceiver = new t1(this.billingLogger);
                IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.IN_APP_BILLING_RESULT_UPDATE_ACTION");
                intentFilter.addAction("com.android.vending.billing.PLAY_BILLING_ACTIVITY_CREATED_ACTION");
                proxyBillingActivity = this;
                try {
                    ContextCompat.registerReceiver(proxyBillingActivity, this.proxyBillingBroadcastReceiver, intentFilter, EXTERNAL_BROADCAST_PERMISSION, null, 2);
                } catch (NoSuchMethodError e) {
                    e = e;
                    proxyBillingActivity.proxyBillingBroadcastReceiver = null;
                    if (e instanceof NoSuchMethodError) {
                        j1 j1Var = proxyBillingActivity.billingLogger;
                        zzla zzlaVarZza = zzld.zza();
                        zzlaVarZza.zza(2);
                        ((m1) j1Var).e((zzld) zzlaVarZza.zzi());
                    } else {
                        j1 j1Var2 = proxyBillingActivity.billingLogger;
                        zzla zzlaVarZza2 = zzld.zza();
                        zzlaVarZza2.zza(1);
                        ((m1) j1Var2).e((zzld) zzlaVarZza2.zzi());
                    }
                    zzc.zzo(TAG, "Failed to register receiver.", e);
                } catch (RuntimeException e6) {
                    e = e6;
                    proxyBillingActivity.proxyBillingBroadcastReceiver = null;
                    if (e instanceof NoSuchMethodError) {
                        j1 j1Var3 = proxyBillingActivity.billingLogger;
                        zzla zzlaVarZza3 = zzld.zza();
                        zzlaVarZza3.zza(2);
                        ((m1) j1Var3).e((zzld) zzlaVarZza3.zzi());
                    } else {
                        j1 j1Var4 = proxyBillingActivity.billingLogger;
                        zzla zzlaVarZza4 = zzld.zza();
                        zzlaVarZza4.zza(1);
                        ((m1) j1Var4).e((zzld) zzlaVarZza4.zzi());
                    }
                    zzc.zzo(TAG, "Failed to register receiver.", e);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (NoSuchMethodError e7) {
            e = e7;
            proxyBillingActivity = this;
            proxyBillingActivity.proxyBillingBroadcastReceiver = null;
            if (e instanceof NoSuchMethodError) {
                j1 j1Var5 = proxyBillingActivity.billingLogger;
                zzla zzlaVarZza5 = zzld.zza();
                zzlaVarZza5.zza(2);
                ((m1) j1Var5).e((zzld) zzlaVarZza5.zzi());
            } else {
                j1 j1Var6 = proxyBillingActivity.billingLogger;
                zzla zzlaVarZza6 = zzld.zza();
                zzlaVarZza6.zza(1);
                ((m1) j1Var6).e((zzld) zzlaVarZza6.zzi());
            }
            zzc.zzo(TAG, "Failed to register receiver.", e);
        } catch (RuntimeException e8) {
            e = e8;
            proxyBillingActivity = this;
            proxyBillingActivity.proxyBillingBroadcastReceiver = null;
            if (e instanceof NoSuchMethodError) {
                j1 j1Var7 = proxyBillingActivity.billingLogger;
                zzla zzlaVarZza7 = zzld.zza();
                zzlaVarZza7.zza(2);
                ((m1) j1Var7).e((zzld) zzlaVarZza7.zzi());
            } else {
                j1 j1Var8 = proxyBillingActivity.billingLogger;
                zzla zzlaVarZza8 = zzld.zza();
                zzlaVarZza8.zza(1);
                ((m1) j1Var8).e((zzld) zzlaVarZza8.zzi());
            }
            zzc.zzo(TAG, "Failed to register receiver.", e);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x0065 A[PHI: r10
  0x0065: PHI (r10v1 int) = (r10v0 int), (r10v15 int) binds: [B:24:0x0060, B:26:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:30:0x0098  */
    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:6:0x0011  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0065, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0081, please report this as an issue */
    @Override // android.app.Activity
    public void onActivityResult(int i5, int i6, @Nullable Intent intent) {
        boolean z6;
        int i7;
        int i8;
        String string;
        Intent intentMakePurchasesUpdatedIntent;
        boolean z7;
        int iZza;
        super.onActivityResult(i5, i6, intent);
        if (i5 == 100) {
            if (intent == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            i7 = zzc.zzi(intent, TAG).f2433a;
            i8 = -1;
            if (i6 != -1) {
                zzc.zzn(TAG, "Activity finished with resultCode " + i6 + " and billing's responseCode: " + i7);
                i8 = i6;
            } else if (i7 != 0) {
                i6 = -1;
                zzc.zzn(TAG, "Activity finished with resultCode " + i6 + " and billing's responseCode: " + i7);
                i8 = i6;
            }
            if (true != z6) {
                zzc.zzn(TAG, "Got null data with resultCode " + i8 + "!");
            } else if (intent.getExtras() == null) {
                zzc.zzn(TAG, "Got null bundle!");
            }
            if (isKnownError(i8, intent)) {
                zzjs loggingErrorReason = getLoggingErrorReason(i8, intent);
                long j6 = this.billingClientTransactionId;
                if (intent == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithResponseCodeAndReason(loggingErrorReason, j6, z7);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i5 == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i5 == 110) {
            if (intent == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            i7 = zzc.zzi(intent, TAG).f2433a;
            i8 = -1;
            if (i6 != -1) {
                zzc.zzn(TAG, "Activity finished with resultCode " + i6 + " and billing's responseCode: " + i7);
                i8 = i6;
            } else if (i7 != 0) {
                i6 = -1;
                zzc.zzn(TAG, "Activity finished with resultCode " + i6 + " and billing's responseCode: " + i7);
                i8 = i6;
            }
            if (true != z6) {
                zzc.zzn(TAG, "Got null data with resultCode " + i8 + "!");
            } else if (intent.getExtras() == null) {
                zzc.zzn(TAG, "Got null bundle!");
            }
            if (isKnownError(i8, intent)) {
                zzjs loggingErrorReason2 = getLoggingErrorReason(i8, intent);
                long j7 = this.billingClientTransactionId;
                if (intent == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithResponseCodeAndReason(loggingErrorReason2, j7, z7);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i5 == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i5 == 101) {
            int i9 = zzc.zza;
            if (intent == null) {
                zzc.zzn(TAG, "Got null intent!");
                intent = null;
                iZza = 0;
            } else {
                iZza = zzc.zza(intent.getExtras(), TAG);
            }
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(iZza, intent != null ? intent.getExtras() : null);
            }
        } else {
            zzc.zzn(TAG, "Got onActivityResult with wrong requestCode: " + i5 + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        if (isProxyBillingBroadcastReceiverRegistered()) {
            this.proxyBillingBroadcastReceiver.a();
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) throws Throwable {
        int i5;
        PendingIntent pendingIntent;
        Bundle bundle2;
        Bundle bundle3;
        super.onCreate(bundle);
        if (!isInAppMessageFlow(bundle)) {
            try {
                i5 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                zzc.zzo(TAG, "Failed to get package info for current package.", e);
                i5 = -1;
            }
            if (this.billingLogger == null) {
                Context applicationContext = getApplicationContext();
                zzke zzkeVarZza = zzkg.zza();
                zzkeVarZza.zzq(getPackageName());
                zzkeVarZza.zzx("9.1.0");
                zzkeVarZza.zzb(i5);
                zzkeVarZza.zza(Build.VERSION.SDK_INT);
                zzkeVarZza.zzp(926300087L);
                this.billingLogger = new m1(applicationContext, (zzkg) zzkeVarZza.zzi());
            }
            registerProxyBillingBroadcastReceiver();
        }
        if (bundle != null) {
            zzc.zzm(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.activityCode = bundle.getInt(KEY_ACTIVITY_CODE, 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        zzc.zzm(TAG, "Launching Play Store billing flow");
        this.activityCode = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                this.activityCode = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            this.activityCode = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 36) {
                if (i6 >= 34) {
                    bundle3 = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle();
                } else {
                    bundle2 = null;
                }
                startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0, bundle2);
            }
            bundle3 = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(3).toBundle();
            bundle2 = bundle3;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0, bundle2);
        } catch (IntentSender.SendIntentException e6) {
            zzc.zzo(TAG, "Got exception while trying to start a purchase flow.", e6);
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentMakePurchaseUpdatedIntentWithResponseCodeAndReason = makePurchaseUpdatedIntentWithResponseCodeAndReason(zzjs.INTENT_SENDER_EXCEPTION, this.billingClientTransactionId, false);
                if (this.isFlowFromFirstPartyClient) {
                    intentMakePurchaseUpdatedIntentWithResponseCodeAndReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentMakePurchaseUpdatedIntentWithResponseCodeAndReason);
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        H hZza;
        super.onDestroy();
        if (isProxyBillingBroadcastReceiverRegistered()) {
            hZza = this.proxyBillingBroadcastReceiver.zza();
            try {
                unregisterReceiver(this.proxyBillingBroadcastReceiver);
            } catch (RuntimeException e) {
                zzc.zzo(TAG, "Failed to unregister receiver.", e);
            }
        } else {
            hZza = null;
        }
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            if (hZza != null) {
                intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", hZza.f2433a);
                intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", hZza.getDebugMessage());
            } else {
                intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
                intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            }
            if (this.isFlowFromFirstPartyClient) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i5 = this.activityCode;
            if (i5 == 110 || i5 == 100) {
                intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt(KEY_ACTIVITY_CODE, this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}

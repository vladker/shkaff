package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityOptionsCompat;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivityV2 extends ComponentActivity {
    private ActivityResultLauncher zza;
    private ActivityResultLauncher zzb;
    private ActivityResultLauncher zzc;
    private ActivityResultLauncher zzd;
    private ActivityResultLauncher zze;
    private ActivityResultLauncher zzf;

    @Nullable
    private ResultReceiver zzg;

    @Nullable
    private ResultReceiver zzh;

    @Nullable
    private ResultReceiver zzi;

    @Nullable
    private ResultReceiver zzj;

    @Nullable
    private ResultReceiver zzk;

    @Nullable
    private ResultReceiver zzl;

    @Nullable
    private static final ActivityOptionsCompat zzg() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 36) {
            return ActivityOptionsCompat.makeBasic().setPendingIntentBackgroundActivityStartMode(3);
        }
        if (i5 >= 34) {
            return ActivityOptionsCompat.makeBasic().setPendingIntentBackgroundActivityStartMode(1);
        }
        return null;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        final int i5 = 0;
        this.zza = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.r1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i5) {
                    case 0:
                        this.b.zza((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zzd((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzb((ActivityResult) obj);
                        break;
                }
            }
        });
        this.zzb = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.s1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i5) {
                    case 0:
                        this.b.zzc((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zze((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzf((ActivityResult) obj);
                        break;
                }
            }
        });
        final int i6 = 1;
        this.zzc = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.r1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i6) {
                    case 0:
                        this.b.zza((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zzd((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzb((ActivityResult) obj);
                        break;
                }
            }
        });
        this.zzd = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.s1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i6) {
                    case 0:
                        this.b.zzc((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zze((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzf((ActivityResult) obj);
                        break;
                }
            }
        });
        final int i7 = 2;
        this.zze = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.r1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i7) {
                    case 0:
                        this.b.zza((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zzd((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzb((ActivityResult) obj);
                        break;
                }
            }
        });
        this.zzf = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.s1
            public final /* synthetic */ ProxyBillingActivityV2 b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i7) {
                    case 0:
                        this.b.zzc((ActivityResult) obj);
                        break;
                    case 1:
                        this.b.zze((ActivityResult) obj);
                        break;
                    default:
                        this.b.zzf((ActivityResult) obj);
                        break;
                }
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.zzg = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                this.zzh = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
            }
            if (bundle.containsKey("external_offer_flow_result_receiver")) {
                this.zzi = (ResultReceiver) bundle.getParcelable("external_offer_flow_result_receiver");
            }
            if (bundle.containsKey("launch_external_link_result_receiver")) {
                this.zzj = (ResultReceiver) bundle.getParcelable("launch_external_link_result_receiver");
            }
            if (bundle.containsKey("billing_program_information_dialog_result_receiver")) {
                this.zzk = (ResultReceiver) bundle.getParcelable("billing_program_information_dialog_result_receiver");
            }
            if (bundle.containsKey("subscription_management_action_result_receiver")) {
                this.zzl = (ResultReceiver) bundle.getParcelable("subscription_management_action_result_receiver");
                return;
            }
            return;
        }
        zzc.zzm("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.zzg = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.zza.launch(new IntentSenderRequest.Builder(pendingIntent).build(), zzg());
            return;
        }
        if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.zzh = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.zzb.launch(new IntentSenderRequest.Builder(pendingIntent2).build(), zzg());
            return;
        }
        if (getIntent().hasExtra("external_offer_flow_pending_intent")) {
            PendingIntent pendingIntent3 = (PendingIntent) getIntent().getParcelableExtra("external_offer_flow_pending_intent");
            this.zzi = (ResultReceiver) getIntent().getParcelableExtra("external_offer_flow_result_receiver");
            this.zzc.launch(new IntentSenderRequest.Builder(pendingIntent3).build(), zzg());
            return;
        }
        if (getIntent().hasExtra("launch_external_link_flow_pending_intent")) {
            PendingIntent pendingIntent4 = (PendingIntent) getIntent().getParcelableExtra("launch_external_link_flow_pending_intent");
            this.zzj = (ResultReceiver) getIntent().getParcelableExtra("launch_external_link_result_receiver");
            this.zzd.launch(new IntentSenderRequest.Builder(pendingIntent4).build(), zzg());
        } else if (getIntent().hasExtra("billing_program_information_dialog_pending_intent")) {
            PendingIntent pendingIntent5 = (PendingIntent) getIntent().getParcelableExtra("billing_program_information_dialog_pending_intent");
            this.zzk = (ResultReceiver) getIntent().getParcelableExtra("billing_program_information_dialog_result_receiver");
            this.zze.launch(new IntentSenderRequest.Builder(pendingIntent5).build(), zzg());
        } else if (getIntent().hasExtra("SUBSCRIPTION_MANAGEMENT_INTENT")) {
            PendingIntent pendingIntent6 = (PendingIntent) getIntent().getParcelableExtra("SUBSCRIPTION_MANAGEMENT_INTENT");
            this.zzl = (ResultReceiver) getIntent().getParcelableExtra("subscription_management_action_result_receiver");
            this.zzf.launch(new IntentSenderRequest.Builder(pendingIntent6).build(), zzg());
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.zzg;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.zzh;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.zzi;
        if (resultReceiver3 != null) {
            bundle.putParcelable("external_offer_flow_result_receiver", resultReceiver3);
        }
        ResultReceiver resultReceiver4 = this.zzj;
        if (resultReceiver4 != null) {
            bundle.putParcelable("launch_external_link_result_receiver", resultReceiver4);
        }
        ResultReceiver resultReceiver5 = this.zzk;
        if (resultReceiver5 != null) {
            bundle.putParcelable("billing_program_information_dialog_result_receiver", resultReceiver5);
        }
        ResultReceiver resultReceiver6 = this.zzl;
        if (resultReceiver6 != null) {
            bundle.putParcelable("subscription_management_action_result_receiver", resultReceiver6);
        }
    }

    @VisibleForTesting
    public final void zza(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzg;
        if (resultReceiver != null) {
            resultReceiver.send(i5, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + i5);
        }
        finish();
    }

    @VisibleForTesting
    public final void zzb(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzk;
        if (resultReceiver != null) {
            resultReceiver.send(i5, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "Billing program info dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + i5);
        }
        finish();
    }

    @VisibleForTesting
    public final void zzc(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzh;
        if (resultReceiver != null) {
            resultReceiver.send(i5, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + activityResult.getResultCode() + " and billing's responseCode: " + i5);
        }
        finish();
    }

    @VisibleForTesting
    public final void zzd(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        Bundle extras = data == null ? null : data.getExtras();
        if (activityResult.getResultCode() != -1) {
            if (extras == null) {
                extras = new Bundle();
            }
            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with resultCode: " + activityResult.getResultCode());
            extras.putInt("INTERNAL_LOG_ERROR_REASON", zzjs.ERROR_IN_ACTIVITY_RESULT.zza());
            extras.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", "External offer flow finished with error resultCode: " + activityResult.getResultCode());
        }
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzi;
        if (resultReceiver != null) {
            resultReceiver.send(i5, extras);
        } else {
            zzc.zzn("ProxyBillingActivityV2", "External offer flow result receiver is null");
        }
        if (i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with billing responseCode: " + i5);
        }
        finish();
    }

    @VisibleForTesting
    public final void zze(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        Bundle extras = data == null ? null : data.getExtras();
        if (activityResult.getResultCode() != -1) {
            if (extras == null) {
                extras = new Bundle();
            }
            zzc.zzn("ProxyBillingActivityV2", "Launch external link flow finished with resultCode: " + activityResult.getResultCode());
            extras.putInt("INTERNAL_LOG_ERROR_REASON", zzjs.ERROR_IN_ACTIVITY_RESULT.zza());
            extras.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", "Launch external link flow finished with error resultCode: " + activityResult.getResultCode());
        }
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzj;
        if (resultReceiver != null) {
            resultReceiver.send(i5, extras);
        } else {
            zzc.zzn("ProxyBillingActivityV2", "Launch external link flow result receiver is null");
        }
        if (i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "Launch external link flow finished with billing responseCode: " + i5);
        }
        finish();
    }

    @VisibleForTesting
    public final void zzf(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int i5 = zzc.zzi(data, "ProxyBillingActivityV2").f2433a;
        ResultReceiver resultReceiver = this.zzl;
        if (resultReceiver != null) {
            resultReceiver.send(i5, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || i5 != 0) {
            zzc.zzn("ProxyBillingActivityV2", "Subscription management action finished with resultCode: " + activityResult.getResultCode() + " and billing's responseCode: " + i5);
        }
        finish();
    }
}

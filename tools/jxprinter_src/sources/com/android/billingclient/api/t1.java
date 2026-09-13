package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzka;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzkw;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2578a = false;

    @Nullable
    private H zza;

    @Nullable
    private final j1 zzc;

    public t1(@Nullable j1 j1Var) {
        this.zzc = j1Var;
    }

    public final void a() {
        this.zza = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, @Nullable Intent intent) {
        zzkg zzkgVar;
        if (intent == null) {
            zzc.zzn("ProxyBillingReceiver", "Null intent!");
            return;
        }
        zzc.zzm("ProxyBillingReceiver", "Received intent action: ".concat(String.valueOf(intent.getAction())));
        if (Objects.equals(intent.getAction(), "com.android.vending.billing.IN_APP_BILLING_RESULT_UPDATE_ACTION")) {
            if (!intent.hasExtra("RESPONSE_CODE")) {
                zzc.zzn("ProxyBillingReceiver", "Missing RESPONSE_CODE in intent.");
                j1 j1Var = this.zzc;
                if (j1Var != null) {
                    ((m1) j1Var).zzj(null, intent.getLongExtra("billingClientTransactionId", 0L));
                    return;
                }
                return;
            }
            G gNewBuilder = H.newBuilder();
            gNewBuilder.setResponseCode(intent.getIntExtra("RESPONSE_CODE", 0));
            gNewBuilder.setDebugMessage(zzbo.zzc(intent.getStringExtra("DEBUG_MESSAGE")));
            H hBuild = gNewBuilder.build();
            this.zza = hBuild;
            j1 j1Var2 = this.zzc;
            if (j1Var2 != null) {
                ((m1) j1Var2).zzj(hBuild, intent.getLongExtra("billingClientTransactionId", 0L));
                return;
            }
            return;
        }
        if (!Objects.equals(intent.getAction(), "com.android.vending.billing.PLAY_BILLING_ACTIVITY_CREATED_ACTION")) {
            zzc.zzn("ProxyBillingReceiver", "Unexpected broadcast action: ".concat(String.valueOf(intent.getAction())));
            return;
        }
        this.f2578a = true;
        j1 j1Var3 = this.zzc;
        if (j1Var3 != null) {
            long longExtra = intent.getLongExtra("billingClientTransactionId", 0L);
            m1 m1Var = (m1) j1Var3;
            try {
                zzka zzkaVarZza = zzkd.zza();
                zzkaVarZza.zze(4);
                zzkaVarZza.zza(zzjz.PLAY_BILLING_ACTIVITY_CREATED_ACTION);
                zzkd zzkdVar = (zzkd) zzkaVarZza.zzi();
                zzku zzkuVarZza = zzkw.zza();
                if (longExtra == 0) {
                    zzkgVar = m1Var.b;
                } else {
                    zzke zzkeVar = (zzke) m1Var.b.zzq();
                    zzkeVar.zze(longExtra);
                    zzkgVar = (zzkg) zzkeVar.zzi();
                }
                zzkuVarZza.zzp(zzkgVar);
                zzkuVarZza.zze(zzkdVar);
                m1Var.c.a((zzkw) zzkuVarZza.zzi());
            } catch (Throwable th) {
                zzc.zzo("BillingLogger", "Unable to log.", th);
            }
        }
    }

    @Nullable
    public final H zza() {
        return this.zza;
    }
}

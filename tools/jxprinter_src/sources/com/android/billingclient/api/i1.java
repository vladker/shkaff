package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjz;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2481a = 0;

    static {
        int i5 = j1.f2483a;
    }

    @Nullable
    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + zzbo.zzc(exc.getMessage());
            int i5 = zzc.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    @Nullable
    public static zzjl zzb(@Nullable zzjs zzjsVar, int i5, H h6, @Nullable String str, zzjz zzjzVar) {
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(h6.f2433a);
            zzjqVarZza.zzb(h6.getDebugMessage());
            if (h6.getOnPurchasesUpdatedSubResponseCode() != 0) {
                zzjqVarZza.zzd(h6.getOnPurchasesUpdatedSubResponseCode());
            }
            if (zzjsVar != null) {
                zzjqVarZza.zze(zzjsVar);
            }
            if (str != null) {
                zzjqVarZza.zza(str);
            }
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(i5);
            if (!zzjzVar.equals(zzjz.BROADCAST_ACTION_UNSPECIFIED)) {
                zzjjVarZza.zza(zzjzVar);
            }
            return (zzjl) zzjjVarZza.zzi();
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    @Nullable
    public static zzjp zzc(int i5, zzjz zzjzVar) {
        try {
            zzjn zzjnVarZza = zzjp.zza();
            zzjnVarZza.zze(i5);
            if (!zzjzVar.equals(zzjz.BROADCAST_ACTION_UNSPECIFIED)) {
                zzjnVarZza.zza(zzjzVar);
            }
            return (zzjp) zzjnVarZza.zzi();
        } catch (Exception e) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}

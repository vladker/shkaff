package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzka;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzko;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzkw;
import com.google.android.gms.internal.play_billing.zzld;
import com.google.android.gms.internal.play_billing.zzlg;
import com.google.android.gms.internal.play_billing.zzlk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements j1 {
    public zzkg b;
    public final M2.a c;

    public m1(Context context, zzkg zzkgVar) {
        M2.a aVar = new M2.a();
        try {
            TransportRuntime.initialize(context);
            aVar.b = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zzkw.class, Encoding.of("proto"), new V1.b(8));
        } catch (Throwable unused) {
            aVar.f470a = true;
        }
        this.c = aVar;
        this.b = zzkgVar;
    }

    private final void zzo(@Nullable zzjl zzjlVar, zzkg zzkgVar) {
        if (zzjlVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zza(zzjlVar);
            this.c.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    private final void zzp(@Nullable zzjp zzjpVar, zzkg zzkgVar) {
        if (zzjpVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zzb(zzjpVar);
            this.c.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void a(zzjl zzjlVar, int i5, long j6) {
        try {
            zzke zzkeVar = (zzke) this.b.zzq();
            zzkeVar.zzc(i5);
            zzkg zzkgVar = (zzkg) zzkeVar.zzi();
            this.b = zzkgVar;
            if (j6 != 0) {
                zzke zzkeVar2 = (zzke) zzkgVar.zzq();
                zzkeVar2.zze(j6);
                zzkgVar = (zzkg) zzkeVar2.zzi();
            }
            zzo(zzjlVar, zzkgVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void b(zzjl zzjlVar, long j6, boolean z6) {
        zzkg zzkgVar;
        try {
            zzjj zzjjVar = (zzjj) zzjlVar.zzq();
            zzko zzkoVar = (zzko) zzjlVar.zze().zzq();
            zzkoVar.zza(z6);
            zzjjVar.zzd(zzkoVar);
            zzjl zzjlVar2 = (zzjl) zzjjVar.zzi();
            if (j6 == 0) {
                zzkgVar = this.b;
            } else {
                zzke zzkeVar = (zzke) this.b.zzq();
                zzkeVar.zze(j6);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzo(zzjlVar2, zzkgVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void c(zzjl zzjlVar, int i5, long j6, boolean z6) {
        zzkg zzkgVar;
        try {
            zzke zzkeVar = (zzke) this.b.zzq();
            zzkeVar.zzc(i5);
            this.b = (zzkg) zzkeVar.zzi();
            zzjj zzjjVar = (zzjj) zzjlVar.zzq();
            zzko zzkoVar = (zzko) zzjlVar.zze().zzq();
            zzkoVar.zza(z6);
            zzjjVar.zzd(zzkoVar);
            zzjl zzjlVar2 = (zzjl) zzjjVar.zzi();
            if (j6 == 0) {
                zzkgVar = this.b;
            } else {
                zzke zzkeVar2 = (zzke) this.b.zzq();
                zzkeVar2.zze(j6);
                zzkgVar = (zzkg) zzkeVar2.zzi();
            }
            zzo(zzjlVar2, zzkgVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void d(zzjp zzjpVar, long j6, boolean z6) {
        zzkg zzkgVar;
        try {
            zzjn zzjnVar = (zzjn) zzjpVar.zzq();
            zzko zzkoVar = (zzko) zzjpVar.zzc().zzq();
            zzkoVar.zza(z6);
            zzjnVar.zzc(zzkoVar);
            zzjp zzjpVar2 = (zzjp) zzjnVar.zzi();
            if (j6 == 0) {
                zzkgVar = this.b;
            } else {
                zzke zzkeVar = (zzke) this.b.zzq();
                zzkeVar.zze(j6);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzp(zzjpVar2, zzkgVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void e(zzld zzldVar) {
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.b);
            zzka zzkaVarZza = zzkd.zza();
            zzkaVarZza.zzc("ProxyBillingBroadcastReceiver");
            zzkaVarZza.zze(2);
            zzkaVarZza.zzd(zzldVar);
            zzkuVarZza.zzd(zzkaVarZza);
            this.c.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void f(zzlg zzlgVar) {
        try {
            M2.a aVar = this.c;
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.b);
            zzkuVarZza.zzq(zzlgVar);
            aVar.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void zza(@Nullable zzjl zzjlVar) {
        try {
            zzo(zzjlVar, this.b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.j1
    public final void zzb(@Nullable zzjl zzjlVar, int i5) {
        try {
            zzke zzkeVar = (zzke) this.b.zzq();
            zzkeVar.zzc(i5);
            this.b = (zzkg) zzkeVar.zzi();
            zza(zzjlVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.j1
    public final void zzf(@Nullable zzjp zzjpVar) {
        try {
            zzp(zzjpVar, this.b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.j1
    public final void zzg(@Nullable zzjp zzjpVar, int i5) {
        try {
            zzke zzkeVar = (zzke) this.b.zzq();
            zzkeVar.zzc(i5);
            this.b = (zzkg) zzkeVar.zzi();
            zzf(zzjpVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.j1
    public final void zzj(@Nullable H h6, long j6) {
        zzkg zzkgVar;
        try {
            zzka zzkaVarZza = zzkd.zza();
            zzkaVarZza.zze(4);
            zzkaVarZza.zza(zzjz.IN_APP_BILLING_RESULT_UPDATE_ACTION);
            if (h6 != null) {
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zzp(h6.f2433a);
                zzjqVarZza.zzb(h6.getDebugMessage());
                zzkaVarZza.zzb(zzjqVarZza);
            }
            zzku zzkuVarZza = zzkw.zza();
            if (j6 == 0) {
                zzkgVar = this.b;
            } else {
                zzke zzkeVar = (zzke) this.b.zzq();
                zzkeVar.zze(j6);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zzd(zzkaVarZza);
            this.c.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.j1
    public final void zzn(@Nullable zzlk zzlkVar) {
        if (zzlkVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.b);
            zzkuVarZza.zzr(zzlkVar);
            this.c.a((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }
}

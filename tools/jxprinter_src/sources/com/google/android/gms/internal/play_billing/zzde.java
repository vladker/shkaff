package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzde implements Runnable {
    final zzdk zza;
    final zzdd zzb;

    public zzde(zzdk zzdkVar, zzdd zzddVar) {
        this.zza = zzdkVar;
        this.zzb = zzddVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        zzdk zzdkVar = this.zza;
        if ((zzdkVar instanceof zzdq) && (thZza = zzdr.zza((zzdq) zzdkVar)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            if (!zzdkVar.isDone()) {
                throw new IllegalStateException(zzbo.zzb("Future was expected to be done: %s", zzdkVar));
            }
            boolean z6 = false;
            Future future = zzdkVar;
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z6 = true;
                    future = future;
                } catch (Throwable th) {
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z6) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzbh zzbhVarZza = zzbj.zza(this);
        zzbhVarZza.zza(this.zzb);
        return zzbhVarZza.toString();
    }
}

package p122v2;

import android.os.Bundle;
import androidx.core.location.LocationRequestCompat;
import com.android.billingclient.api.G;
import com.android.billingclient.api.H;
import com.android.billingclient.api.i1;
import com.android.billingclient.api.j1;
import com.android.billingclient.api.k1;
import com.android.billingclient.api.l1;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzeq;
import com.google.android.gms.internal.play_billing.zzjs;
import io.reactivex.AbstractC0979l;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import p027e3.g;
import p039g3.A;
import p039g3.z;
import p088p3.d;
import p088p3.e;
import p088p3.j;
import p100r3.n;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static long a(AtomicLong atomicLong, long j6) {
        long j7;
        do {
            j7 = atomicLong.get();
            if (j7 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!atomicLong.compareAndSet(j7, c(j7, j6)));
        return j7;
    }

    public static long b(AtomicLong atomicLong, long j6) {
        long j7;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j7 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!atomicLong.compareAndSet(j7, c(j7, j6)));
        return j7;
    }

    public static long c(long j6, long j7) {
        long j8 = j6 + j7;
        return j8 < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j8;
    }

    public static long d(long j6, long j7) {
        long j8 = j6 * j7;
        return (((j6 | j7) >>> 31) == 0 || j8 / j6 == j7) ? j8 : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static void e(AtomicLong atomicLong, long j6) {
        long j7;
        long j8;
        do {
            j7 = atomicLong.get();
            if (j7 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return;
            }
            j8 = j7 - j6;
            if (j8 < 0) {
                io.reactivex.plugins.a.onError(new IllegalStateException(androidx.collection.a.j(j8, "More produced than requested: ")));
                j8 = 0;
            }
        } while (!atomicLong.compareAndSet(j7, j8));
    }

    public static void f(AbstractC0979l abstractC0979l, g gVar, g gVar2, p027e3.a aVar) {
        A.b(gVar, "onNext is null");
        A.b(gVar2, "onError is null");
        A.b(aVar, "onComplete is null");
        h(abstractC0979l, new j(gVar, gVar2, aVar, z.f4016k));
    }

    public static void g(AbstractC0979l abstractC0979l, g gVar, g gVar2, p027e3.a aVar, int i5) {
        A.b(gVar, "onNext is null");
        A.b(gVar2, "onError is null");
        A.b(aVar, "onComplete is null");
        A.c(i5, "number > 0 required");
        h(abstractC0979l, new e(gVar, gVar2, aVar, new p039g3.e(i5), i5));
    }

    public static void h(AbstractC0979l abstractC0979l, c cVar) {
        Object objPoll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        d dVar = new d(linkedBlockingQueue);
        abstractC0979l.subscribe((c) dVar);
        do {
            try {
                Object obj = dVar.get();
                p094q3.g gVar = p094q3.g.f7849a;
                if (obj == gVar) {
                    return;
                }
                objPoll = linkedBlockingQueue.poll();
                if (objPoll == null) {
                    if (dVar.get() == gVar) {
                        return;
                    } else {
                        objPoll = linkedBlockingQueue.take();
                    }
                }
                if ((dVar.get() == gVar) || objPoll == d.b) {
                    return;
                }
            } catch (InterruptedException e) {
                dVar.cancel();
                cVar.onError(e);
                return;
            }
        } while (!n.b(objPoll, cVar));
    }

    public static H i(Bundle bundle, String str, int i5, j1 j1Var, int i6) {
        if (!bundle.containsKey("BILLING_RESULT")) {
            zzc.zzn(str, "delegateToBackendAsync does not contain a billing result in the response");
            zzjs zzjsVar = zzjs.MISSING_BILLING_RESULT_IN_DELEGATE_TO_BACKEND_RESPONSE;
            H h6 = k1.f2514h;
            l1.a(zzjsVar, h6, j1Var, i5, i6);
            return h6;
        }
        try {
            byte[] byteArray = bundle.getByteArray("BILLING_RESULT");
            if (byteArray == null) {
                throw new Exception("Billing result is null");
            }
            zzeq zzeqVarZzc = zzeq.zzc(byteArray);
            G gNewBuilder = H.newBuilder();
            gNewBuilder.setResponseCode(zzeqVarZzc.zza());
            gNewBuilder.setDebugMessage(zzeqVarZzc.zze());
            H hBuild = gNewBuilder.build();
            if (hBuild.f2433a != 0) {
                l1.a(zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, hBuild, j1Var, i5, i6);
                return hBuild;
            }
            if (bundle.containsKey("RESPONSE_DATA")) {
                return hBuild;
            }
            zzc.zzn(str, "delegateToBackendAsync returned a bundle with neither an error nor response data");
            zzjs zzjsVar2 = zzjs.MISSING_RESPONSE_DATA_IN_DELEGATE_TO_BACKEND_RESPONSE;
            H h7 = k1.f2514h;
            l1.a(zzjsVar2, h7, j1Var, i5, i6);
            return h7;
        } catch (Exception e) {
            zzc.zzo(str, "Failed parsing BillingResult.", e);
            zzjs zzjsVar3 = zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_BILLING_RESULT;
            H h8 = k1.f2514h;
            l1.zzb(zzjsVar3, h8, j1Var, i5, i6, i1.zza(e));
            return h8;
        }
    }
}

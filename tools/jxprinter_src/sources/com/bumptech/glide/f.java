package com.bumptech.glide;

import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import io.reactivex.I;
import io.reactivex.internal.operators.flowable.C0802u;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements k, com.library.base.frame.d {
    public static String a(byte b) {
        return String.format("%02X", Byte.valueOf(b));
    }

    public static boolean b(boolean z6, boolean z7, I i5, p083o3.b bVar, p011b3.c cVar, p048i3.s sVar) {
        if (sVar.d) {
            bVar.clear();
            cVar.dispose();
            return true;
        }
        if (!z6) {
            return false;
        }
        Throwable th = sVar.f4061f;
        if (th != null) {
            bVar.clear();
            if (cVar != null) {
                cVar.dispose();
            }
            i5.onError(th);
            return true;
        }
        if (!z7) {
            return false;
        }
        if (cVar != null) {
            cVar.dispose();
        }
        i5.onComplete();
        return true;
    }

    public static void c(p083o3.b bVar, p112t3.e eVar, p011b3.c cVar, p048i3.s sVar) {
        int iAddAndGet = 1;
        while (true) {
            p083o3.b bVar2 = bVar;
            p112t3.e eVar2 = eVar;
            p011b3.c cVar2 = cVar;
            p048i3.s sVar2 = sVar;
            if (b(sVar.e, bVar.isEmpty(), eVar2, bVar2, cVar2, sVar2)) {
                return;
            }
            while (true) {
                boolean z6 = sVar2.e;
                Object objPoll = bVar2.poll();
                boolean z7 = objPoll == null;
                boolean z8 = z7;
                if (b(z6, z7, eVar2, bVar2, cVar2, sVar2)) {
                    return;
                }
                if (z8) {
                    break;
                } else {
                    sVar2.b(eVar2, objPoll);
                }
            }
            iAddAndGet = sVar2.f4060a.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            eVar = eVar2;
            bVar = bVar2;
            cVar = cVar2;
            sVar = sVar2;
        }
    }

    public static void d(p083o3.b bVar, p135x3.c cVar, p011b3.c cVar2, p088p3.k kVar) {
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = kVar.f7748f;
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            if (kVar.e) {
                bVar.clear();
                break;
            }
            if (z6) {
                Throwable th = kVar.f7749g;
                if (th == null) {
                    if (z7) {
                        cVar.onComplete();
                        break;
                    }
                } else {
                    bVar.clear();
                    cVar.onError(th);
                    break;
                }
            }
            if (z7) {
                iAddAndGet = kVar.f7747a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                long j6 = kVar.b.get();
                if (j6 == 0) {
                    bVar.clear();
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                    cVar.onError(new p017c3.e("Could not emit value due to lack of requests."));
                    return;
                }
                if (kVar.o(objPoll, cVar) && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    kVar.t(1L);
                }
            }
        }
        if (cVar2 != null) {
            cVar2.dispose();
        }
    }

    public static void e(String str, Throwable th) {
        Log.e("android-crop", str, th);
    }

    public static boolean f(long j6, t5.c cVar, ArrayDeque arrayDeque, C0802u c0802u, C0802u c0802u2) {
        boolean z6;
        boolean z7;
        long j7 = j6 & Long.MIN_VALUE;
        while (true) {
            if (j7 != j6) {
                try {
                    z6 = c0802u2.f4792j;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    z6 = true;
                }
                if (z6) {
                    break;
                }
                Object objPoll = arrayDeque.poll();
                if (objPoll == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(objPoll);
                j7++;
            } else {
                try {
                    z7 = c0802u2.f4792j;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    z7 = true;
                }
                if (z7) {
                    break;
                }
                if (arrayDeque.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j6 = c0802u.get();
                if (j6 == j7) {
                    long jAddAndGet = c0802u.addAndGet(-(j7 & LocationRequestCompat.PASSIVE_INTERVAL));
                    if ((LocationRequestCompat.PASSIVE_INTERVAL & jAddAndGet) == 0) {
                        return false;
                    }
                    j7 = jAddAndGet & Long.MIN_VALUE;
                    j6 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
        return true;
    }
}

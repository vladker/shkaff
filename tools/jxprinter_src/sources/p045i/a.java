package p045i;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import dalvik.system.DexFile;
import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.b;
import p053j3.M;
import p053j3.O;
import p061l.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4042a = 1;
    public final Serializable b;
    public final Object c;
    public final Object d;
    public final /* synthetic */ Object e;

    public a(String str, String str2, HashSet hashSet, CountDownLatch countDownLatch) {
        this.b = str;
        this.c = str2;
        this.d = hashSet;
        this.e = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4042a) {
            case 0:
                CountDownLatch countDownLatch = (CountDownLatch) this.e;
                String str = (String) this.b;
                DexFile dexFileLoadDex = null;
                try {
                    try {
                        dexFileLoadDex = str.endsWith(".zip") ? DexFile.loadDex(str, str.concat(".tmp"), 0) : new DexFile(str);
                        Enumeration<String> enumerationEntries = dexFileLoadDex.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            String strNextElement = enumerationEntries.nextElement();
                            if (strNextElement.startsWith((String) this.c)) {
                                ((HashSet) this.d).add(strNextElement);
                            }
                            break;
                        }
                    } catch (Throwable th) {
                        try {
                            Log.e(Consts.SDK_NAME, "Scan map file in dex files made error.", th);
                            return;
                        } finally {
                            if (dexFileLoadDex != null) {
                                try {
                                    dexFileLoadDex.close();
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                            countDownLatch.countDown();
                        }
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return;
            default:
                if (((AtomicBoolean) this.b).compareAndSet(false, true)) {
                    b bVar = (b) this.c;
                    if (!bVar.b) {
                        synchronized (bVar) {
                            try {
                                if (!bVar.b) {
                                    c cVar = bVar.f1087a;
                                    bVar.f1087a = null;
                                    b.a(cVar);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        break;
                    }
                    InterfaceC0682i interfaceC0682i = ((O) this.e).e;
                    if (interfaceC0682i != null) {
                        ((AbstractC0676c) interfaceC0682i).subscribe(new M(this));
                        return;
                    }
                    InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.d;
                    O o6 = (O) this.e;
                    interfaceC0679f.onError(new TimeoutException(g.c(o6.b, o6.c)));
                    return;
                }
                return;
        }
    }

    public a(O o6, AtomicBoolean atomicBoolean, b bVar, InterfaceC0679f interfaceC0679f) {
        this.e = o6;
        this.b = atomicBoolean;
        this.c = bVar;
        this.d = interfaceC0679f;
    }
}

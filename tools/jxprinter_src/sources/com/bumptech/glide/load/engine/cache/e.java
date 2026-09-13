package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.load.engine.C0491g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static e f3005f;
    public final File b;
    public final long c;
    public p120v0.f e;
    public final xyz.doikki.videoplayer.player.k d = new xyz.doikki.videoplayer.player.k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3006a = new m();

    @Deprecated
    public e(File file, long j6) {
        this.b = file;
        this.c = j6;
    }

    @Deprecated
    public static synchronized c get(File file, long j6) {
        try {
            if (f3005f == null) {
                f3005f = new e(file, j6);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3005f;
    }

    private synchronized p120v0.f getDiskCache() {
        try {
            if (this.e == null) {
                this.e = p120v0.f.open(this.b, 1, 1, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public final void a(q qVar, C0491g c0491g) {
        d dVar;
        String strA = this.f3006a.a(qVar);
        xyz.doikki.videoplayer.player.k kVar = this.d;
        synchronized (kVar) {
            dVar = (d) ((HashMap) kVar.b).get(strA);
            if (dVar == null) {
                S4.h hVar = (S4.h) kVar.c;
                synchronized (((ArrayDeque) hVar.b)) {
                    dVar = (d) ((ArrayDeque) hVar.b).poll();
                }
                if (dVar == null) {
                    dVar = new d();
                }
                ((HashMap) kVar.b).put(strA, dVar);
            }
            dVar.b++;
        }
        dVar.f3004a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strA + " for for Key: " + qVar);
            }
            try {
                p120v0.f diskCache = getDiskCache();
                if (diskCache.get(strA) == null) {
                    p120v0.c cVarEdit = diskCache.edit(strA);
                    if (cVarEdit == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strA);
                    }
                    try {
                        if (c0491g.write(cVarEdit.getFile(0))) {
                            cVarEdit.commit();
                        }
                        if (!cVarEdit.c) {
                            try {
                                cVarEdit.abort();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th) {
                        if (!cVarEdit.c) {
                            try {
                                cVarEdit.abort();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            this.d.j(strA);
        } catch (Throwable th2) {
            this.d.j(strA);
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public final synchronized void clear() {
        try {
            try {
                getDiskCache().delete();
                synchronized (this) {
                    this.e = null;
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e);
                }
                synchronized (this) {
                    this.e = null;
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.e = null;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.c
    public final File get(q qVar) throws Throwable {
        String strA = this.f3006a.a(qVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strA + " for for Key: " + qVar);
        }
        try {
            p120v0.e eVar = getDiskCache().get(strA);
            if (eVar != null) {
                return eVar.c[0];
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }
}

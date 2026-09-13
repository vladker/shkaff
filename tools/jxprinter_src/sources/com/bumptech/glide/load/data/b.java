package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2917a;
    public final AssetManager b;
    public Object c;

    public b(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.f2917a = str;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        Object obj = this.c;
        if (obj == null) {
            return;
        }
        try {
            close(obj);
        } catch (IOException unused) {
        }
    }

    public abstract void close(Object obj);

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public abstract /* synthetic */ Class getDataClass();

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public p126w0.a getDataSource() {
        return p126w0.a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull com.bumptech.glide.o oVar, @NonNull d dVar) {
        try {
            Object objLoadResource = loadResource(this.b, this.f2917a);
            this.c = objLoadResource;
            dVar.onDataReady(objLoadResource);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dVar.onLoadFailed(e);
        }
    }

    public abstract Object loadResource(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

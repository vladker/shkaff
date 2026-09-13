package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2926a;
    public final ContentResolver b;
    public Object c;

    public s(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.f2926a = uri;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        Object obj = this.c;
        if (obj != null) {
            try {
                close(obj);
            } catch (IOException unused) {
            }
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
    public final void loadData(@NonNull com.bumptech.glide.o oVar, @NonNull d dVar) {
        try {
            Object objLoadResource = loadResource(this.f2926a, this.b);
            this.c = objLoadResource;
            dVar.onDataReady(objLoadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dVar.onLoadFailed(e);
        }
    }

    public abstract Object loadResource(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

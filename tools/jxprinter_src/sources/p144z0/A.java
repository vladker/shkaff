package p144z0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p126w0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class A implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9054a;
    public final B b;
    public Object c;

    public A(File file, B b) {
        this.f9054a = file;
        this.b = b;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        Object obj = this.c;
        if (obj != null) {
            try {
                this.b.close(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<Object> getDataClass() {
        return this.b.getDataClass();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        try {
            Object objOpen = this.b.open(this.f9054a);
            this.c = objOpen;
            dVar.onDataReady(objOpen);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("FileLoader", 3)) {
                Log.d("FileLoader", "Failed to open file", e);
            }
            dVar.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

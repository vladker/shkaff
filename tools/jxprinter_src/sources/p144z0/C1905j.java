package p144z0;

import L0.c;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p126w0.a;

/* JADX INFO: renamed from: z0.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1905j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9085a;

    public C1905j(File file) {
        this.f9085a = file;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        try {
            dVar.onDataReady(c.fromFile(this.f9085a));
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
            }
            dVar.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

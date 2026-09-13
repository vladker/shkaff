package p144z0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import java.io.IOException;
import java.io.InputStream;
import p126w0.a;

/* JADX INFO: renamed from: z0.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1909n implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9087a;
    public final C1910o b;
    public Object c;

    public C1909n(String str, C1910o c1910o) {
        this.f9087a = str;
        this.b = c1910o;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        try {
            this.b.close(this.c);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<Object> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        try {
            Object objDecode = this.b.decode(this.f9087a);
            this.c = objDecode;
            dVar.onDataReady(objDecode);
        } catch (IllegalArgumentException e) {
            dVar.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

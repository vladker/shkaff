package p144z0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import p126w0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9092a;

    public p0(Object obj) {
        this.f9092a = obj;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<Object> getDataClass() {
        return this.f9092a.getClass();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        dVar.onDataReady(this.f9092a);
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

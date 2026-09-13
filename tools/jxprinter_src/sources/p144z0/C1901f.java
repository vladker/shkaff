package p144z0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import io.reactivex.internal.operators.observable.C0953x2;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p126w0.a;

/* JADX INFO: renamed from: z0.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1901f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9079a;
    public final C0953x2 b;

    public C1901f(byte[] bArr, C0953x2 c0953x2) {
        this.f9079a = bArr;
        this.b = c0953x2;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public Class<Object> getDataClass() {
        switch (this.b.f5307a) {
            case 13:
                return ByteBuffer.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public a getDataSource() {
        return a.f8801a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void loadData(@NonNull o oVar, @NonNull d dVar) {
        Object objWrap;
        int i5 = this.b.f5307a;
        byte[] bArr = this.f9079a;
        switch (i5) {
            case 13:
                objWrap = ByteBuffer.wrap(bArr);
                break;
            default:
                objWrap = new ByteArrayInputStream(bArr);
                break;
        }
        dVar.onDataReady(objWrap);
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

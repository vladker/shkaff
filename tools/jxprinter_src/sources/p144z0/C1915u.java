package p144z0;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.o;
import java.io.IOException;
import p126w0.a;

/* JADX INFO: renamed from: z0.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1915u implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f9100a;
    public final InterfaceC1916v b;
    public final int c;

    @Nullable
    private Object data;

    @Nullable
    private final Resources.Theme theme;

    public C1915u(@Nullable Resources.Theme theme, Resources resources, InterfaceC1916v interfaceC1916v, int i5) {
        this.theme = theme;
        this.f9100a = resources;
        this.b = interfaceC1916v;
        this.c = i5;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void a() {
        Object obj = this.data;
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
            Object objOpen = this.b.open(this.theme, this.f9100a, this.c);
            this.data = objOpen;
            dVar.onDataReady(objOpen);
        } catch (Resources.NotFoundException e) {
            dVar.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
    }
}

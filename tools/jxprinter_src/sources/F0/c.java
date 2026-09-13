package F0;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import com.bumptech.glide.load.resource.bitmap.C0510e;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.c f239a;
    public final e b;
    public final e c;

    public c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull e eVar, @NonNull e eVar2) {
        this.f239a = cVar;
        this.b = eVar;
        this.c = eVar2;
    }

    @Override // F0.e
    @Nullable
    public O transcode(@NonNull O o6, @NonNull v vVar) {
        Drawable drawable = (Drawable) o6.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.transcode(C0510e.obtain(((BitmapDrawable) drawable).getBitmap(), this.f239a), vVar);
        }
        if (drawable instanceof com.bumptech.glide.load.resource.gif.f) {
            return this.c.transcode(toGifDrawableResource(o6), vVar);
        }
        return null;
    }

    @NonNull
    private static O toGifDrawableResource(@NonNull O o6) {
        return o6;
    }
}

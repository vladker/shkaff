package D0;

import L0.s;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatedImageDrawable f156a;

    public a(AnimatedImageDrawable animatedImageDrawable) {
        this.f156a = animatedImageDrawable;
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Drawable> getResourceClass() {
        return Drawable.class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return s.getBytesPerPixel(Bitmap.Config.ARGB_8888) * this.f156a.getIntrinsicHeight() * this.f156a.getIntrinsicWidth() * 2;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
        this.f156a.stop();
        this.f156a.clearAnimationCallbacks();
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public AnimatedImageDrawable get() {
        return this.f156a;
    }
}

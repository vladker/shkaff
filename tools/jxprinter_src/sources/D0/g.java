package D0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends f {
    @Nullable
    public static O newInstance(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new g(drawable);
        }
        return null;
    }

    @Override // D0.f, com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Drawable> getResourceClass() {
        return this.f161a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        Drawable drawable = this.f161a;
        return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
    }
}

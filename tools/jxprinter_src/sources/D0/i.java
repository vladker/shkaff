package D0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements x {
    @Override // p126w0.x
    @Nullable
    public O decode(@NonNull Drawable drawable, int i5, int i6, @NonNull v vVar) {
        return g.newInstance(drawable);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Drawable drawable, @NonNull v vVar) {
        return true;
    }
}

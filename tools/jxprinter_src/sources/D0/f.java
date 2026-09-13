package D0;

import L0.q;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.K;
import com.bumptech.glide.load.engine.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements O, K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f161a;

    public f(Drawable drawable) {
        this.f161a = (Drawable) q.checkNotNull(drawable);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public abstract /* synthetic */ Class getResourceClass();

    @Override // com.bumptech.glide.load.engine.K
    public void initialize() {
        Drawable drawable = this.f161a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof com.bumptech.glide.load.resource.gif.f) {
            ((com.bumptech.glide.load.resource.gif.f) drawable).b().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public final Drawable get() {
        Drawable drawable = this.f161a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }
}

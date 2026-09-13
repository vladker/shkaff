package p144z0;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f9080a;
    public final Resources b;

    public f0(Resources resources, T t6) {
        this.b = resources;
        this.f9080a = t6;
    }

    @Nullable
    private Uri getResourceUri(Integer num) {
        Resources resources = this.b;
        try {
            return Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Integer num, int i5, int i6, @NonNull v vVar) {
        Uri resourceUri = getResourceUri(num);
        if (resourceUri == null) {
            return null;
        }
        return this.f9080a.buildLoadData(resourceUri, i5, i6, vVar);
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Integer num) {
        return true;
    }
}

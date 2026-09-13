package p144z0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9084a;
    public final T b;

    public i0(Context context, T t6) {
        this.f9084a = context.getApplicationContext();
        this.b = t6;
    }

    @Nullable
    private S parseResourceIdUri(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        try {
            int i7 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i7 != 0) {
                return this.b.buildLoadData(Integer.valueOf(i7), i5, i6, vVar);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    @Nullable
    private S parseResourceNameUri(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        Context context = this.f9084a;
        int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
        if (identifier != 0) {
            return this.b.buildLoadData(Integer.valueOf(identifier), i5, i6, vVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }

    @Override // p144z0.T
    @Nullable
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return parseResourceIdUri(uri, i5, i6, vVar);
        }
        if (pathSegments.size() == 2) {
            return parseResourceNameUri(uri, i5, i6, vVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f9084a.getPackageName().equals(uri.getAuthority());
    }
}

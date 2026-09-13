package D0;

import L0.q;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import java.util.List;
import p126w0.u;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements x {
    public static final u b = u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f162a;

    public h(Context context) {
        this.f162a = context.getApplicationContext();
    }

    @NonNull
    private Context findContextForPackage(Uri uri, @NonNull String str) {
        Context context = this.f162a;
        if (str.equals(context.getPackageName())) {
            return context;
        }
        try {
            return context.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(context.getPackageName())) {
                return context;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    private int findResourceIdFromResourceIdUri(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    @DrawableRes
    private int findResourceIdFromTypeAndNameResourceUri(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int findResourceIdFromUri(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return findResourceIdFromTypeAndNameResourceUri(context, uri);
        }
        if (pathSegments.size() == 1) {
            return findResourceIdFromResourceIdUri(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // p126w0.x
    @Nullable
    public O decode(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalStateException("Package name for " + uri + " is null or empty");
        }
        Context contextFindContextForPackage = findContextForPackage(uri, authority);
        int iFindResourceIdFromUri = findResourceIdFromUri(contextFindContextForPackage, uri);
        String str = (String) q.checkNotNull(authority);
        Context context = this.f162a;
        Resources.Theme theme = str.equals(context.getPackageName()) ? (Resources.Theme) vVar.get(b) : null;
        return g.newInstance(theme == null ? e.getDrawable(context, contextFindContextForPackage, iFindResourceIdFromUri) : e.getDrawable(context, iFindResourceIdFromUri, theme));
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Uri uri, @NonNull v vVar) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}

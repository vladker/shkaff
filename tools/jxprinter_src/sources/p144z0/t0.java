package p144z0;

import K0.d;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements T {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(Constants.FILE, FirebaseAnalytics.Param.CONTENT, "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9099a;

    public t0(r0 r0Var) {
        this.f9099a = r0Var;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, z0.r0] */
    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        return new S(new d(uri), this.f9099a.a(uri));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}

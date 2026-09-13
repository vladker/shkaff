package K0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f386a = new ConcurrentHashMap();

    @Nullable
    private static PackageInfo getPackageInfo(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    @NonNull
    private static String getVersionCode(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    public static q obtain(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap = f386a;
        q qVar = (q) concurrentHashMap.get(packageName);
        if (qVar != null) {
            return qVar;
        }
        q qVarObtainVersionSignature = obtainVersionSignature(context);
        q qVar2 = (q) concurrentHashMap.putIfAbsent(packageName, qVarObtainVersionSignature);
        return qVar2 == null ? qVarObtainVersionSignature : qVar2;
    }

    @NonNull
    private static q obtainVersionSignature(@NonNull Context context) {
        return new d(getVersionCode(getPackageInfo(context)));
    }

    @VisibleForTesting
    public static void reset() {
        f386a.clear();
    }
}

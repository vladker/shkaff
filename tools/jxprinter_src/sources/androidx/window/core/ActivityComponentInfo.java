package androidx.window.core;

import A3.AbstractC0157z;
import android.content.ComponentName;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityComponentInfo {
    private final String className;
    private final String packageName;

    public ActivityComponentInfo(String packageName, String className) {
        E.f(packageName, "packageName");
        E.f(className, "className");
        this.packageName = packageName;
        this.className = className;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ActivityComponentInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        E.d(obj, "null cannot be cast to non-null type androidx.window.core.ActivityComponentInfo");
        ActivityComponentInfo activityComponentInfo = (ActivityComponentInfo) obj;
        return E.a(this.packageName, activityComponentInfo.packageName) && E.a(this.className, activityComponentInfo.className);
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.className.hashCode() + (this.packageName.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClassInfo { packageName: ");
        sb.append(this.packageName);
        sb.append(", className: ");
        return AbstractC0157z.s(sb, this.className, " }");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityComponentInfo(ComponentName componentName) {
        E.f(componentName, "componentName");
        String packageName = componentName.getPackageName();
        E.e(packageName, "componentName.packageName");
        String className = componentName.getClassName();
        E.e(className, "componentName.className");
        this(packageName, className);
    }
}

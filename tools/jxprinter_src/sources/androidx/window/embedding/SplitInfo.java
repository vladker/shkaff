package androidx.window.embedding;

import android.app.Activity;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.E;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SplitInfo {
    private final ActivityStack primaryActivityStack;
    private final ActivityStack secondaryActivityStack;
    private final SplitAttributes splitAttributes;
    private final IBinder token;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SplitInfo(ActivityStack primaryActivityStack, ActivityStack secondaryActivityStack, SplitAttributes splitAttributes, IBinder token) {
        E.f(primaryActivityStack, "primaryActivityStack");
        E.f(secondaryActivityStack, "secondaryActivityStack");
        E.f(splitAttributes, "splitAttributes");
        E.f(token, "token");
        this.primaryActivityStack = primaryActivityStack;
        this.secondaryActivityStack = secondaryActivityStack;
        this.splitAttributes = splitAttributes;
        this.token = token;
    }

    public final boolean contains(Activity activity) {
        E.f(activity, "activity");
        return this.primaryActivityStack.contains(activity) || this.secondaryActivityStack.contains(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        return E.a(this.primaryActivityStack, splitInfo.primaryActivityStack) && E.a(this.secondaryActivityStack, splitInfo.secondaryActivityStack) && E.a(this.splitAttributes, splitInfo.splitAttributes) && E.a(this.token, splitInfo.token);
    }

    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final SplitAttributes getSplitAttributes() {
        return this.splitAttributes;
    }

    public final IBinder getToken$window_release() {
        return this.token;
    }

    public int hashCode() {
        return this.token.hashCode() + ((this.splitAttributes.hashCode() + ((this.secondaryActivityStack.hashCode() + (this.primaryActivityStack.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SplitInfo:{");
        sb.append("primaryActivityStack=" + this.primaryActivityStack + ", ");
        sb.append("secondaryActivityStack=" + this.secondaryActivityStack + ", ");
        sb.append("splitAttributes=" + this.splitAttributes + ", ");
        StringBuilder sb2 = new StringBuilder("token=");
        sb2.append(this.token);
        sb.append(sb2.toString());
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        String string = sb.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

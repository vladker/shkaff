package androidx.window.embedding;

import X3.W;
import X3.b0;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.webkit.ProxyConfig;
import androidx.window.core.ActivityComponentInfo;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!b0.contains((CharSequence) str2, (CharSequence) ProxyConfig.MATCH_ALL_SCHEMES, false)) {
            return false;
        }
        if (E.a(str2, ProxyConfig.MATCH_ALL_SCHEMES)) {
            return true;
        }
        if (b0.e(str2, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6) != b0.g(ProxyConfig.MATCH_ALL_SCHEMES, 0, 6, str2) || !W.endsWith(str2, ProxyConfig.MATCH_ALL_SCHEMES, false)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return W.startsWith(str, strSubstring, false);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x006f A[RETURN] */
    public final boolean areComponentsMatching$window_release(ActivityComponentInfo activityComponentInfo, ActivityComponentInfo ruleComponent) {
        E.f(ruleComponent, "ruleComponent");
        if (activityComponentInfo == null) {
            if (E.a(ruleComponent.getPackageName(), ProxyConfig.MATCH_ALL_SCHEMES) && E.a(ruleComponent.getClassName(), ProxyConfig.MATCH_ALL_SCHEMES)) {
                return true;
            }
            return false;
        }
        if (b0.contains((CharSequence) activityComponentInfo.toString(), (CharSequence) ProxyConfig.MATCH_ALL_SCHEMES, false)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        boolean z6 = E.a(activityComponentInfo.getPackageName(), ruleComponent.getPackageName()) || wildcardMatch(activityComponentInfo.getPackageName(), ruleComponent.getPackageName());
        boolean z7 = E.a(activityComponentInfo.getClassName(), ruleComponent.getClassName()) || wildcardMatch(activityComponentInfo.getClassName(), ruleComponent.getClassName());
        if (z6 && z7) {
            return true;
        }
        return false;
    }

    public final boolean isActivityMatching$window_release(Activity activity, ActivityComponentInfo ruleComponent) {
        E.f(activity, "activity");
        E.f(ruleComponent, "ruleComponent");
        ComponentName componentName = activity.getComponentName();
        E.e(componentName, "activity.componentName");
        if (areComponentsMatching$window_release(new ActivityComponentInfo(componentName), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            return INSTANCE.isIntentMatching$window_release(intent, ruleComponent);
        }
        return false;
    }

    public final boolean isIntentMatching$window_release(Intent intent, ActivityComponentInfo ruleComponent) {
        String str;
        E.f(intent, "intent");
        E.f(ruleComponent, "ruleComponent");
        ComponentName component = intent.getComponent();
        if (areComponentsMatching$window_release(component != null ? new ActivityComponentInfo(component) : null, ruleComponent)) {
            return true;
        }
        if (intent.getComponent() == null && (str = intent.getPackage()) != null) {
            return (str.equals(ruleComponent.getPackageName()) || wildcardMatch(str, ruleComponent.getPackageName())) && E.a(ruleComponent.getClassName(), ProxyConfig.MATCH_ALL_SCHEMES);
        }
        return false;
    }

    public final void validateComponentName$window_release(String packageName, String className) {
        E.f(packageName, "packageName");
        E.f(className, "className");
        if (packageName.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        }
        if (className.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty");
        }
        if (b0.contains((CharSequence) packageName, (CharSequence) ProxyConfig.MATCH_ALL_SCHEMES, false) && b0.e(packageName, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (b0.contains((CharSequence) className, (CharSequence) ProxyConfig.MATCH_ALL_SCHEMES, false) && b0.e(className, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6) != className.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
    }
}

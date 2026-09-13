package androidx.window.embedding;

import android.app.Activity;
import androidx.annotation.VisibleForTesting;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.reflection.ReflectionUtils;
import androidx.window.reflection.WindowExtensionsConstants;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SafeActivityEmbeddingComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;
    private final WindowExtensions windowExtensions;

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isActivityEmbeddingComponentValid$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements O3.a {
        public AnonymousClass1() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method getActivityEmbeddingComponentMethod = SafeActivityEmbeddingComponentProvider.this.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getActivityEmbeddingComponent", null);
            Class<?> activityEmbeddingComponentClass = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass();
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(getActivityEmbeddingComponentMethod, "getActivityEmbeddingComponentMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(getActivityEmbeddingComponentMethod) && reflectionUtils.doesReturn$window_release(getActivityEmbeddingComponentMethod, activityEmbeddingComponentClass));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodClearSplitInfoCallbackValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03571 extends F implements O3.a {
        public C03571() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            Method clearSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearSplitInfoCallback", null);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(clearSplitInfoCallbackMethod, "clearSplitInfoCallbackMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(clearSplitInfoCallbackMethod));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodIsActivityEmbeddedValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03581 extends F implements O3.a {
        public C03581() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            Method isActivityEmbeddedMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("isActivityEmbedded", Activity.class);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(isActivityEmbeddedMethod, "isActivityEmbeddedMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(isActivityEmbeddedMethod) && reflectionUtils.doesReturn$window_release(isActivityEmbeddedMethod, Boolean.TYPE));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodSetEmbeddingRulesValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03591 extends F implements O3.a {
        public C03591() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            Method setEmbeddingRulesMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setEmbeddingRules", Set.class);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(setEmbeddingRulesMethod, "setEmbeddingRulesMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(setEmbeddingRulesMethod));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackJavaConsumerValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03601 extends F implements O3.a {
        public C03601() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            Class<?> clsConsumerClassOrNull$window_release = SafeActivityEmbeddingComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
            if (clsConsumerClassOrNull$window_release == null) {
                return Boolean.FALSE;
            }
            Method setSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", clsConsumerClassOrNull$window_release);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(setSplitInfoCallbackMethod, "setSplitInfoCallbackMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(setSplitInfoCallbackMethod));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackWindowConsumerValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03611 extends F implements O3.a {
        public C03611() {
            super(0);
        }

        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            Method setSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", Consumer.class);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(setSplitInfoCallbackMethod, "setSplitInfoCallbackMethod");
            return Boolean.valueOf(reflectionUtils.isPublic$window_release(setSplitInfoCallbackMethod));
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03621 extends F implements O3.a {
        public C03621() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0039  */
        @Override // O3.a
        public final Boolean invoke() throws NoSuchMethodException {
            boolean z6;
            Method setSplitAttributesCalculatorMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitAttributesCalculator", Function.class);
            Method clearSplitAttributesCalculatorMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearSplitAttributesCalculator", null);
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            E.e(setSplitAttributesCalculatorMethod, "setSplitAttributesCalculatorMethod");
            if (reflectionUtils.isPublic$window_release(setSplitAttributesCalculatorMethod)) {
                E.e(clearSplitAttributesCalculatorMethod, "clearSplitAttributesCalculatorMethod");
                if (reflectionUtils.isPublic$window_release(clearSplitAttributesCalculatorMethod)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } else {
                z6 = false;
            }
            return Boolean.valueOf(z6);
        }
    }

    public SafeActivityEmbeddingComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter, WindowExtensions windowExtensions) {
        E.f(loader, "loader");
        E.f(consumerAdapter, "consumerAdapter");
        E.f(windowExtensions, "windowExtensions");
        this.loader = loader;
        this.consumerAdapter = consumerAdapter;
        this.windowExtensions = windowExtensions;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(loader);
    }

    private final boolean canUseActivityEmbeddingComponent() {
        if (!isActivityEmbeddingComponentAccessible$window_release()) {
            return false;
        }
        int safeVendorApiLevel = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        if (safeVendorApiLevel == 1) {
            return hasValidVendorApiLevel1$window_release();
        }
        if (2 > safeVendorApiLevel || safeVendorApiLevel > Integer.MAX_VALUE) {
            return false;
        }
        return hasValidVendorApiLevel2$window_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getActivityEmbeddingComponentClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass(WindowExtensionsConstants.ACTIVITY_EMBEDDING_COMPONENT_CLASS);
        E.e(clsLoadClass, "loader.loadClass(ACTIVIT…MBEDDING_COMPONENT_CLASS)");
        return clsLoadClass;
    }

    private final boolean isActivityEmbeddingComponentValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getActivityEmbeddingComponent is not valid", new AnonymousClass1());
    }

    private final boolean isMethodClearSplitInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new C03571());
    }

    private final boolean isMethodIsActivityEmbeddedValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new C03581());
    }

    private final boolean isMethodSetEmbeddingRulesValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new C03591());
    }

    private final boolean isMethodSetSplitInfoCallbackJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new C03601());
    }

    private final boolean isMethodSetSplitInfoCallbackWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new C03611());
    }

    private final boolean isMethodSplitAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new C03621());
    }

    public final ActivityEmbeddingComponent getActivityEmbeddingComponent() {
        if (!canUseActivityEmbeddingComponent()) {
            return null;
        }
        try {
            return this.windowExtensions.getActivityEmbeddingComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @VisibleForTesting
    public final boolean hasValidVendorApiLevel1$window_release() {
        return isMethodSetEmbeddingRulesValid() && isMethodIsActivityEmbeddedValid() && isMethodSetSplitInfoCallbackJavaConsumerValid();
    }

    @VisibleForTesting
    public final boolean hasValidVendorApiLevel2$window_release() {
        return hasValidVendorApiLevel1$window_release() && isMethodSetSplitInfoCallbackWindowConsumerValid() && isMethodClearSplitInfoCallbackValid() && isMethodSplitAttributesCalculatorValid();
    }

    @VisibleForTesting
    public final boolean isActivityEmbeddingComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && isActivityEmbeddingComponentValid();
    }
}

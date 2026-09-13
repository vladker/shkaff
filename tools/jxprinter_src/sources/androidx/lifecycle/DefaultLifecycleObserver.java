package androidx.lifecycle;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    default void onCreate(LifecycleOwner owner) {
        E.f(owner, "owner");
    }

    default void onDestroy(LifecycleOwner owner) {
        E.f(owner, "owner");
    }

    default void onPause(LifecycleOwner owner) {
        E.f(owner, "owner");
    }

    default void onResume(LifecycleOwner owner) {
        E.f(owner, "owner");
    }

    default void onStart(LifecycleOwner owner) {
        E.f(owner, "owner");
    }

    default void onStop(LifecycleOwner owner) {
        E.f(owner, "owner");
    }
}

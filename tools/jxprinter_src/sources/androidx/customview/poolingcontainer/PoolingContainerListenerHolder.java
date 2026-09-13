package androidx.customview.poolingcontainer;

import A3.I;
import java.util.ArrayList;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener listener) {
        E.f(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onRelease() {
        for (int lastIndex = I.getLastIndex(this.listeners); -1 < lastIndex; lastIndex--) {
            this.listeners.get(lastIndex).onRelease();
        }
    }

    public final void removeListener(PoolingContainerListener listener) {
        E.f(listener, "listener");
        this.listeners.remove(listener);
    }
}

package androidx.datastore.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicBoolean {
    private final java.util.concurrent.atomic.AtomicBoolean delegate;

    public AtomicBoolean(boolean z6) {
        this.delegate = new java.util.concurrent.atomic.AtomicBoolean(z6);
    }

    public final boolean get() {
        return this.delegate.get();
    }

    public final void set(boolean z6) {
        this.delegate.set(z6);
    }
}

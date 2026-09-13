package androidx.datastore.core;

import kotlin.jvm.internal.AbstractC1107v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i5, AbstractC1107v abstractC1107v) {
        this(i5);
    }

    public final int getVersion() {
        return this.version;
    }

    private State(int i5) {
        this.version = i5;
    }
}

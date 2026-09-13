package p123v3;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AbstractC0979l implements t5.a, InterfaceC0984q {
    public abstract Throwable getThrowable();

    public final a toSerialized() {
        return this instanceof b ? this : new b(this);
    }
}

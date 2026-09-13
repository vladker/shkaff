package p039g3;

import java.util.Map;
import p027e3.b;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f4007a;

    public w(o oVar) {
        this.f4007a = oVar;
    }

    @Override // p027e3.b
    public void accept(Map<Object, Object> map, Object obj) {
        map.put(this.f4007a.apply(obj), obj);
    }
}

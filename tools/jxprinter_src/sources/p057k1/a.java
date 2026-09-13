package p057k1;

import V1.b;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public static final Map b;

    static {
        HashMap map = new HashMap();
        map.put(Bundle.class, new b(19));
        map.put(Intent.class, new b(20));
        b = Collections.unmodifiableMap(map);
    }

    @Override // p057k1.b
    public final Map a() {
        return b;
    }

    @Override // p057k1.b
    public final p069m1.b b() {
        p069m1.a aVar = new p069m1.a();
        aVar.b = false;
        aVar.f6117a = 4000;
        return aVar;
    }

    @Override // p057k1.b
    public final void c() {
        Log.w("XLog", "XLog is already initialized, do not initialize again");
    }

    @Override // p057k1.b
    public final String lineSeparator() {
        return System.lineSeparator();
    }
}

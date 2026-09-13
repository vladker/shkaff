package p057k1;

import S4.h;
import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5472a;

    static {
        b bVar;
        try {
            Class.forName("android.os.Build");
            bVar = new a();
        } catch (ClassNotFoundException unused) {
            bVar = new b();
        }
        f5472a = bVar;
    }

    public Map a() {
        return Collections.EMPTY_MAP;
    }

    public p069m1.b b() {
        h hVar = new h(13, false);
        hVar.b = new V1.b(7);
        return hVar;
    }

    public void c() {
        System.out.println("XLog is already initialized, do not initialize again");
    }

    @SuppressLint({"NewApi"})
    public String lineSeparator() {
        return System.lineSeparator();
    }
}

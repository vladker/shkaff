package p145z1;

import B1.a;
import android.graphics.PorterDuff;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9109a;
    public final int b;
    public final int c;
    public final int d;
    private final byte[] img;
    private final String type;

    public j(Map<?, ?> map) {
        E.f(map, "map");
        Object obj = map.get(TypedValues.AttributesType.S_TARGET);
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Object obj2 = ((Map) obj).get("memory");
        E.d(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
        this.img = (byte[]) obj2;
        Object obj3 = map.get("x");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        this.f9109a = ((Integer) obj3).intValue();
        Object obj4 = map.get("y");
        E.d(obj4, "null cannot be cast to non-null type kotlin.Int");
        this.b = ((Integer) obj4).intValue();
        Object obj5 = map.get("w");
        E.d(obj5, "null cannot be cast to non-null type kotlin.Int");
        this.c = ((Integer) obj5).intValue();
        Object obj6 = map.get("h");
        E.d(obj6, "null cannot be cast to non-null type kotlin.Int");
        this.d = ((Integer) obj6).intValue();
        Object obj7 = map.get("mixMode");
        E.d(obj7, "null cannot be cast to non-null type kotlin.String");
        this.type = (String) obj7;
    }

    public final byte[] getImg() {
        return this.img;
    }

    public final PorterDuff.Mode getPorterDuffMode() {
        return a.INSTANCE.convertToPorterDuffMode(this.type);
    }
}

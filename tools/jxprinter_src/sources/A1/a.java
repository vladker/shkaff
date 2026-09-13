package A1;

import android.graphics.Rect;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22a;
    private final Rect rect;
    private final Number start;
    private final Number sweep;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        this.rect = getRect("rect");
        Object obj = map.get("start");
        E.d(obj, "null cannot be cast to non-null type kotlin.Number");
        this.start = (Number) obj;
        Object obj2 = map.get("sweep");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Number");
        this.sweep = (Number) obj2;
        Object obj3 = map.get("useCenter");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
        this.f22a = ((Boolean) obj3).booleanValue();
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final Number getStart() {
        return this.start;
    }

    public final Number getSweep() {
        return this.sweep;
    }
}

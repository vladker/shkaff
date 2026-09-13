package A1;

import android.graphics.Point;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23a;
    private final Point control1;
    private final Point control2;
    private final Point target;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        Object obj = map.get("kind");
        E.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        this.f23a = iIntValue;
        this.target = getOffset(TypedValues.AttributesType.S_TARGET);
        this.control1 = getOffset("c1");
        this.control2 = iIntValue == 3 ? getOffset("c2") : null;
    }

    public final Point getControl1() {
        return this.control1;
    }

    public final Point getControl2() {
        return this.control2;
    }

    public final Point getTarget() {
        return this.target;
    }
}

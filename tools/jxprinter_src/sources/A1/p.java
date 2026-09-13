package A1;

import android.graphics.Paint;
import android.graphics.Point;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends e implements g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
    }

    public final List<Point> getOffsets() {
        ArrayList arrayList = new ArrayList();
        Object obj = getMap().get(TypedValues.CycleType.S_WAVE_OFFSET);
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj2 : (List) obj) {
            if (obj2 instanceof Map) {
                arrayList.add(convertMapToOffset((Map) obj2));
            }
        }
        return arrayList;
    }

    @Override // A1.g
    public Paint getPaint() {
        return f.getPaint(this);
    }
}

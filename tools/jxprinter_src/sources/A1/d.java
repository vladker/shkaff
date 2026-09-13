package A1;

import android.graphics.Paint;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
    }

    public final Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(getColor(TypedValues.Custom.S_COLOR));
        Object obj = getMap().get("lineWeight");
        E.d(obj, "null cannot be cast to non-null type kotlin.Number");
        paint.setStrokeWidth(((Number) obj).floatValue());
        Object obj2 = getMap().get("paintStyleFill");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
        paint.setStyle(((Boolean) obj2).booleanValue() ? Paint.Style.FILL : Paint.Style.STROKE);
        return paint;
    }
}

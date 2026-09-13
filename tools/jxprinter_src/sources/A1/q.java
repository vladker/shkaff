package A1;

import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends e implements g {
    private final Rect rect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        this.rect = getRect("rect");
    }

    @Override // A1.g
    public Paint getPaint() {
        return f.getPaint(this);
    }

    public final Rect getRect() {
        return this.rect;
    }
}

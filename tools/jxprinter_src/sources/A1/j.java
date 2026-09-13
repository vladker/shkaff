package A1;

import android.graphics.Paint;
import android.graphics.Point;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends e implements g {
    private final Point end;
    private final Point start;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        this.start = getOffset("start");
        this.end = getOffset("end");
    }

    public final Point getEnd() {
        return this.end;
    }

    @Override // A1.g
    public Paint getPaint() {
        return f.getPaint(this);
    }

    public final Point getStart() {
        return this.start;
    }
}

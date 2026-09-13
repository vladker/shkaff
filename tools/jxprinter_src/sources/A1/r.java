package A1;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements i {
    private final Map<?, ?> map;

    public r(Map<?, ?> map) {
        E.f(map, "map");
        this.map = map;
    }

    @Override // A1.i
    public Point convertMapToOffset(Map<?, ?> map) {
        return h.convertMapToOffset(this, map);
    }

    @Override // A1.i
    public int getColor(String str) {
        return h.getColor(this, str);
    }

    @Override // A1.i
    public Map<?, ?> getMap() {
        return this.map;
    }

    @Override // A1.i
    public Point getOffset(String str) {
        return h.getOffset(this, str);
    }

    @Override // A1.i
    public Rect getRect(String str) {
        return h.getRect(this, str);
    }
}

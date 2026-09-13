package A1;

import android.graphics.Point;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends o {
    private final Point offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        this.offset = getOffset(TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final Point getOffset() {
        return this.offset;
    }
}

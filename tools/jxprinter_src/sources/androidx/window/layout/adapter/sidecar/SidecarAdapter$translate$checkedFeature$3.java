package androidx.window.layout.adapter.sidecar;

import O3.l;
import androidx.window.sidecar.SidecarDisplayFeature;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$3 extends F implements l {
    public static final SidecarAdapter$translate$checkedFeature$3 INSTANCE = new SidecarAdapter$translate$checkedFeature$3();

    public SidecarAdapter$translate$checkedFeature$3() {
        super(1);
    }

    @Override // O3.l
    public final Boolean invoke(SidecarDisplayFeature require) {
        E.f(require, "$this$require");
        boolean z6 = true;
        if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
            z6 = false;
        }
        return Boolean.valueOf(z6);
    }
}

package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z6) {
        super(fragment, "Attempting to set user visible hint to " + z6 + " for fragment " + fragment);
        E.f(fragment, "fragment");
        this.isVisibleToUser = z6;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}

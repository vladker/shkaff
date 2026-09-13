package p147z3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends Error {
    public /* synthetic */ r() {
        this("An operation is not implemented.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String message) {
        super(message);
        E.f(message, "message");
    }
}

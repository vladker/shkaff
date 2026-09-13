package S2;

import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: S2.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0203a extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public C0203a(String code, String str, Object obj) {
        E.f(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
    }

    public final String getCode() {
        return this.code;
    }

    public final Object getDetails() {
        return this.details;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}

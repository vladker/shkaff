package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC1107v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidWebKitError extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public /* synthetic */ AndroidWebKitError(String str, String str2, Object obj, int i5, AbstractC1107v abstractC1107v) {
        this(str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : obj);
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

    public AndroidWebKitError(String code, String str, Object obj) {
        kotlin.jvm.internal.E.f(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
    }
}

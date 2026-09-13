package retrofit2;

import java.util.Objects;

/* JADX INFO: renamed from: retrofit2.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class C1625x extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient r0 f8165a;

    public C1625x(r0 r0Var) {
        Objects.requireNonNull(r0Var, "response == null");
        StringBuilder sb = new StringBuilder("HTTP ");
        okhttp3.T t6 = r0Var.f8159a;
        sb.append(t6.c);
        sb.append(" ");
        sb.append(t6.d);
        super(sb.toString());
        int i5 = t6.c;
        String str = t6.d;
        this.f8165a = r0Var;
    }

    public r0<?> response() {
        return this.f8165a;
    }
}

package g5;

import A3.AbstractC0157z;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4024a;
    public String b;
    public boolean c = true;
    public boolean d = false;
    public String e = "";

    public final boolean a() {
        return "_id".equalsIgnoreCase(this.f4024a) || "id".equalsIgnoreCase(this.f4024a);
    }

    public final void b(String str) {
        if (!"text".equalsIgnoreCase(this.b)) {
            this.e = str;
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e = AbstractC0157z.o("'", str, "'");
        }
    }
}

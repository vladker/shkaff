package p079o;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p050j.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6355a = null;
    public final ArrayList b = null;
    public final ArrayList c = null;
    public final ArrayList d = null;
    public final ArrayList e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f6356f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f6357g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f6358h = null;

    public final void a(G g6) {
        ArrayList arrayList = g6.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.c;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final void b(G g6) {
        ArrayList arrayList = g6.f6356f;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.f6356f;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final void c(G g6, String str) {
        ArrayList arrayList = g6.e;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final Object d(G g6, Object obj, C1281j c1281j) {
        boolean z6;
        if (obj != null) {
            if ((g6.f6325j.f6373i || !(c1281j == null || (c1281j.f6413a.f7888i & c0.WriteNonStringValueAsString.f6406a) == 0)) && (((z6 = obj instanceof Number)) || (obj instanceof Boolean))) {
                String str = (!z6 || c1281j == null) ? null : c1281j.b;
                obj = str != null ? new DecimalFormat(str).format(obj) : obj.toString();
            } else if (c1281j != null && c1281j.f6413a.f7894o) {
                obj = a.f((String) obj);
            }
        }
        ArrayList arrayList = g6.d;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.d;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
        ArrayList arrayList3 = g6.f6358h;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            if (it3.hasNext()) {
                throw AbstractC1125a.g(it3);
            }
        }
        ArrayList arrayList4 = this.f6358h;
        if (arrayList4 != null) {
            Iterator it4 = arrayList4.iterator();
            if (it4.hasNext()) {
                throw AbstractC1125a.g(it4);
            }
        }
        return obj;
    }
}

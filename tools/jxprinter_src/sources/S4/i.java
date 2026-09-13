package S4;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static final ArrayList d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f690a;
    public p b;
    public i c;

    public static i a(p pVar, Object obj) {
        ArrayList arrayList = d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size <= 0) {
                    i iVar = new i();
                    iVar.f690a = obj;
                    iVar.b = pVar;
                    return iVar;
                }
                i iVar2 = (i) arrayList.remove(size - 1);
                iVar2.f690a = obj;
                iVar2.b = pVar;
                iVar2.c = null;
                return iVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

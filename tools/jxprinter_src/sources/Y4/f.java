package Y4;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends ArrayList {
    private f siblings(String str, boolean z6, boolean z7) {
        f fVar = new f();
        p pVarH = str != null ? r.h(str) : null;
        int size = size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = get(i5);
            i5++;
            org.jsoup.nodes.m mVarNextElementSibling = (org.jsoup.nodes.m) obj;
            do {
                mVarNextElementSibling = z6 ? mVarNextElementSibling.nextElementSibling() : mVarNextElementSibling.previousElementSibling();
                if (mVarNextElementSibling == null) {
                    break;
                }
                if (pVarH == null) {
                    fVar.add(mVarNextElementSibling);
                } else if (pVarH.a(mVarNextElementSibling.x(), mVarNextElementSibling)) {
                    fVar.add(mVarNextElementSibling);
                }
            } while (z7);
        }
        return fVar;
    }

    @Override // java.util.ArrayList
    public final Object clone() {
        f fVar = new f(size());
        int size = size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = get(i5);
            i5++;
            fVar.add(((org.jsoup.nodes.m) obj).clone());
        }
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public org.jsoup.nodes.m first() {
        if (isEmpty()) {
            return null;
        }
        return (org.jsoup.nodes.m) get(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public org.jsoup.nodes.m last() {
        if (isEmpty()) {
            return null;
        }
        return (org.jsoup.nodes.m) get(size() - 1);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sbB = W4.b.b();
        int size = size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = get(i5);
            i5++;
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) obj;
            if (sbB.length() != 0) {
                sbB.append("\n");
            }
            sbB.append(mVar.s());
        }
        return W4.b.g(sbB);
    }
}

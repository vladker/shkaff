package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f881a;
    private org.jsoup.nodes.m evalRoot = null;
    private org.jsoup.nodes.m match = null;

    public a(p pVar) {
        this.f881a = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public org.jsoup.nodes.m find(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        char c;
        this.evalRoot = mVar;
        this.match = null;
        int i5 = 0;
        org.jsoup.nodes.s sVar = mVar2;
        while (sVar != null) {
            char c6 = 1;
            if (sVar instanceof org.jsoup.nodes.m) {
                org.jsoup.nodes.m mVar3 = (org.jsoup.nodes.m) sVar;
                if (this.f881a.a(this.evalRoot, mVar3)) {
                    this.match = mVar3;
                    c = 5;
                } else {
                    c = 1;
                }
            } else {
                c = 1;
            }
            if (c == 5) {
                break;
            }
            if (c != 1 || sVar.j() <= 0) {
                while (sVar.nextSibling() == null && i5 > 0) {
                    if (c == 1 || c == 2) {
                        c = 1;
                    }
                    org.jsoup.nodes.s sVarParentNode = sVar.parentNode();
                    i5--;
                    if (c == 4) {
                        sVar.u();
                    }
                    sVar = sVarParentNode;
                    c = 1;
                }
                if (c != 1 && c != 2) {
                    c6 = c;
                }
                if (sVar == mVar2) {
                    break;
                }
                org.jsoup.nodes.s sVarNextSibling = sVar.nextSibling();
                if (c6 == 4) {
                    sVar.u();
                }
                sVar = sVarNextSibling;
            } else {
                sVar = (org.jsoup.nodes.s) sVar.n().get(0);
                i5++;
            }
        }
        return this.match;
    }
}

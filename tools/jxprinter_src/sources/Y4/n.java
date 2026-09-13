package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class n extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f888a;
    public final int b;
    public final /* synthetic */ int c;

    public n(int i5, int i6, int i7) {
        this.c = i7;
        this.f888a = i5;
        this.b = i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        int iH;
        org.jsoup.nodes.m mVarParent = mVar2.parent();
        if (mVarParent == null || (mVarParent instanceof org.jsoup.nodes.i)) {
            return false;
        }
        switch (this.c) {
            case 0:
                iH = mVar2.H() + 1;
                break;
            case 1:
                iH = mVar2.parent() == null ? 0 : mVar2.parent().D().size() - mVar2.H();
                break;
            case 2:
                iH = 0;
                if (mVar2.parent() != null) {
                    f fVarD = mVar2.parent().D();
                    for (int iH2 = mVar2.H(); iH2 < fVarD.size(); iH2++) {
                        if (((org.jsoup.nodes.m) fVarD.get(iH2)).c.equals(mVar2.c)) {
                            iH++;
                        }
                    }
                }
                break;
            default:
                iH = 0;
                if (mVar2.parent() != null) {
                    f fVarD2 = mVar2.parent().D();
                    int size = fVarD2.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = fVarD2.get(i5);
                        i5++;
                        org.jsoup.nodes.m mVar3 = (org.jsoup.nodes.m) obj;
                        if (mVar3.c.equals(mVar2.c)) {
                            iH++;
                        }
                        if (mVar3 == mVar2) {
                            break;
                        }
                    }
                }
                break;
        }
        int i6 = this.b;
        int i7 = this.f888a;
        if (i7 == 0) {
            return iH == i6;
        }
        int i8 = iH - i6;
        return i8 * i7 >= 0 && i8 % i7 == 0;
    }

    public final String b() {
        switch (this.c) {
            case 0:
                return "nth-child";
            case 1:
                return "nth-last-child";
            case 2:
                return "nth-last-of-type";
            default:
                return "nth-of-type";
        }
    }

    public String toString() {
        int i5 = this.b;
        int i6 = this.f888a;
        if (i6 == 0) {
            return String.format(":%s(%d)", b(), Integer.valueOf(i5));
        }
        return i5 == 0 ? String.format(":%s(%dn)", b(), Integer.valueOf(i6)) : String.format(":%s(%dn%+d)", b(), Integer.valueOf(i6), Integer.valueOf(i5));
    }
}

package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends w {
    public final /* synthetic */ int b;

    public /* synthetic */ v(int i5) {
        this.b = i5;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        org.jsoup.nodes.m mVarParent;
        org.jsoup.nodes.m mVarPreviousElementSibling;
        switch (this.b) {
            case 0:
                return (mVar == mVar2 || (mVarParent = mVar2.parent()) == null || !this.f893a.a(mVar, mVarParent)) ? false : true;
            case 1:
                return (mVar == mVar2 || (mVarPreviousElementSibling = mVar2.previousElementSibling()) == null || !this.f893a.a(mVar, mVarPreviousElementSibling)) ? false : true;
            case 2:
                return !this.f893a.a(mVar, mVar2);
            case 3:
                if (mVar != mVar2) {
                    for (org.jsoup.nodes.m mVarParent2 = mVar2.parent(); mVarParent2 != null; mVarParent2 = mVarParent2.parent()) {
                        if (this.f893a.a(mVar, mVarParent2)) {
                            return true;
                        }
                        if (mVarParent2 != mVar) {
                        }
                    }
                }
                return false;
            default:
                if (mVar != mVar2) {
                    for (org.jsoup.nodes.m mVarPreviousElementSibling2 = mVar2.previousElementSibling(); mVarPreviousElementSibling2 != null; mVarPreviousElementSibling2 = mVarPreviousElementSibling2.previousElementSibling()) {
                        if (this.f893a.a(mVar, mVarPreviousElementSibling2)) {
                            return true;
                        }
                    }
                }
                return false;
        }
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return String.format("%s > ", this.f893a);
            case 1:
                return String.format("%s + ", this.f893a);
            case 2:
                return String.format(":not(%s)", this.f893a);
            case 3:
                return String.format("%s ", this.f893a);
            default:
                return String.format("%s ~ ", this.f893a);
        }
    }
}

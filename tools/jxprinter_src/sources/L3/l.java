package L3;

import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f450a;
    public int b;
    public final /* synthetic */ m c;
    private File[] fileList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, File rootDir) {
        super(rootDir);
        E.f(rootDir, "rootDir");
        this.c = mVar;
    }

    @Override // L3.i.b
    public File step() {
        O3.p pVar;
        boolean z6 = this.f450a;
        m mVar = this.c;
        if (z6) {
            File[] fileArr = this.fileList;
            if (fileArr == null || this.b < fileArr.length) {
                if (fileArr == null) {
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null && (pVar = mVar.b.onFail) != null) {
                        pVar.invoke(getRoot(), new a(getRoot()));
                    }
                    File[] fileArr2 = this.fileList;
                    if (fileArr2 == null || fileArr2.length == 0) {
                        O3.l lVar = mVar.b.onLeave;
                        if (lVar != null) {
                            lVar.invoke(getRoot());
                        }
                    }
                }
                File[] fileArr3 = this.fileList;
                E.c(fileArr3);
                int i5 = this.b;
                this.b = i5 + 1;
                return fileArr3[i5];
            }
            O3.l lVar2 = mVar.b.onLeave;
            if (lVar2 != null) {
                lVar2.invoke(getRoot());
                return null;
            }
        } else {
            O3.l lVar3 = mVar.b.onEnter;
            if (lVar3 == null || ((Boolean) lVar3.invoke(getRoot())).booleanValue()) {
                this.f450a = true;
                return getRoot();
            }
        }
        return null;
    }
}

package L3;

import java.io.File;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f448a;
    public int b;
    public boolean c;
    public final /* synthetic */ m d;
    private File[] fileList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, File rootDir) {
        super(rootDir);
        E.f(rootDir, "rootDir");
        this.d = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073  */
    @Override // L3.i.b
    public File step() {
        File[] fileArr;
        O3.l lVar;
        boolean z6 = this.c;
        m mVar = this.d;
        if (z6 || this.fileList != null) {
            fileArr = this.fileList;
            if (fileArr == null && this.b < fileArr.length) {
                E.c(fileArr);
                int i5 = this.b;
                this.b = i5 + 1;
                return fileArr[i5];
            }
            if (!this.f448a) {
                this.f448a = true;
                return getRoot();
            }
            lVar = mVar.b.onLeave;
            if (lVar != null) {
                lVar.invoke(getRoot());
            }
        } else {
            O3.l lVar2 = mVar.b.onEnter;
            if (lVar2 == null || ((Boolean) lVar2.invoke(getRoot())).booleanValue()) {
                File[] fileArrListFiles = getRoot().listFiles();
                this.fileList = fileArrListFiles;
                if (fileArrListFiles == null) {
                    O3.p pVar = mVar.b.onFail;
                    if (pVar != null) {
                        pVar.invoke(getRoot(), new a(getRoot()));
                    }
                    this.c = true;
                }
                fileArr = this.fileList;
                if (fileArr == null) {
                }
                if (!this.f448a) {
                    this.f448a = true;
                    return getRoot();
                }
                lVar = mVar.b.onLeave;
                if (lVar != null) {
                    lVar.invoke(getRoot());
                }
            }
        }
        return null;
    }
}

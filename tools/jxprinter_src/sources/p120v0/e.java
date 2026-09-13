package p120v0;

import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8765a;
    public final long b;
    public final File[] c;
    public final /* synthetic */ f d;

    public e(f fVar, String str, long j6, File[] fileArr) {
        this.d = fVar;
        this.f8765a = str;
        this.b = j6;
        this.c = fileArr;
    }

    public c edit() {
        return this.d.edit(this.f8765a, this.b);
    }

    public String getString(int i5) {
        return f.inputStreamToString(new FileInputStream(this.c[i5]));
    }
}

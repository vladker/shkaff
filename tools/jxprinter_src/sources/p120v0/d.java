package p120v0;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8761a;
    public final long[] b;
    public final File[] c;
    public final File[] d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f8762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f8764h;

    public d(f fVar, String str) {
        this.f8764h = fVar;
        this.f8761a = str;
        int i5 = fVar.f8768g;
        File file = fVar.f8766a;
        this.b = new long[i5];
        this.c = new File[i5];
        this.d = new File[i5];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append(i6);
            this.c[i6] = new File(file, sb.toString());
            sb.append(".tmp");
            this.d[i6] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    private IOException invalidLengths(String[] strArr) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLengths(String[] strArr) throws IOException {
        if (strArr.length != this.f8764h.f8768g) {
            throw invalidLengths(strArr);
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            try {
                this.b[i5] = Long.parseLong(strArr[i5]);
            } catch (NumberFormatException unused) {
                throw invalidLengths(strArr);
            }
        }
    }

    public String getLengths() {
        StringBuilder sb = new StringBuilder();
        for (long j6 : this.b) {
            sb.append(Chars.SPACE);
            sb.append(j6);
        }
        return sb.toString();
    }
}

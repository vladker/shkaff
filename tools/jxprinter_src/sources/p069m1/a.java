package p069m1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6117a;
    public boolean b;

    @Override // p069m1.b
    public void b(int i5, String str, String str2) {
        int length = str2.length();
        int i6 = 0;
        while (i6 < length) {
            if (str2.charAt(i6) == '\n') {
                i6++;
            } else {
                int iMin = Math.min(this.f6117a + i6, length);
                if (this.b) {
                    int iIndexOf = str2.indexOf(10, i6);
                    if (iIndexOf != -1) {
                        iMin = iIndexOf;
                    }
                } else if (iMin != str2.length() && str2.charAt(iMin) != '\n') {
                    for (int i7 = iMin - 1; i6 < i7; i7--) {
                        if (str2.charAt(i7) == '\n') {
                            iMin = i7;
                            break;
                        }
                    }
                }
                Log.println(i5, str, str2.substring(i6, iMin));
                i6 = iMin;
            }
        }
    }
}

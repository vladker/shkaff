package C1;

import android.annotation.SuppressLint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements e {
    @Override // C1.e
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // C1.e
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // C1.e
    public String mapLibraryName(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // C1.e
    public String unmapLibraryName(String str) {
        return androidx.collection.a.g(3, 3, str);
    }
}

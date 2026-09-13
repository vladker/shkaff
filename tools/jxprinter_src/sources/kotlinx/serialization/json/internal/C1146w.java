package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1146w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1146w f5745a = new C1146w();

    public final void doWriteEscaping(String text, O3.q writeImpl) {
        kotlin.jvm.internal.E.f(text, "text");
        kotlin.jvm.internal.E.f(writeImpl, "writeImpl");
        int length = text.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = text.charAt(i6);
            if (cCharAt < j0.getESCAPE_STRINGS().length && j0.getESCAPE_STRINGS()[cCharAt] != null) {
                writeImpl.invoke(text, Integer.valueOf(i5), Integer.valueOf(i6));
                String str = j0.getESCAPE_STRINGS()[cCharAt];
                kotlin.jvm.internal.E.c(str);
                writeImpl.invoke(str, 0, Integer.valueOf(str.length()));
                i5 = i6 + 1;
            }
        }
        writeImpl.invoke(text, Integer.valueOf(i5), Integer.valueOf(text.length()));
    }
}

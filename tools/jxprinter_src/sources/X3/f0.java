package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final f0 INSTANCE = new f0();
    public static final String LINE_SEPARATOR;

    static {
        String property = System.getProperty("line.separator");
        kotlin.jvm.internal.E.c(property);
        LINE_SEPARATOR = property;
    }
}

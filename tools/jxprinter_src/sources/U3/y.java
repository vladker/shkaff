package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public static <T extends Comparable<? super T>> boolean contains(z zVar, T value) {
        kotlin.jvm.internal.E.f(value, "value");
        return value.compareTo(zVar.getStart()) >= 0 && value.compareTo(zVar.getEndExclusive()) < 0;
    }

    public static <T extends Comparable<? super T>> boolean isEmpty(z zVar) {
        return zVar.getStart().compareTo(zVar.getEndExclusive()) >= 0;
    }
}

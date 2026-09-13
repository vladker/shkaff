package U3;

/* JADX INFO: renamed from: U3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0212i {
    public static <T extends Comparable<? super T>> boolean contains(InterfaceC0213j interfaceC0213j, T value) {
        kotlin.jvm.internal.E.f(value, "value");
        return value.compareTo(interfaceC0213j.getStart()) >= 0 && value.compareTo(interfaceC0213j.getEndInclusive()) <= 0;
    }

    public static <T extends Comparable<? super T>> boolean isEmpty(InterfaceC0213j interfaceC0213j) {
        return interfaceC0213j.getStart().compareTo(interfaceC0213j.getEndInclusive()) > 0;
    }
}

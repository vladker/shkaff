package p066l4;

import V3.c;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C1099m;
import kotlin.jvm.internal.C1100n;
import kotlin.jvm.internal.C1103q;
import kotlin.jvm.internal.C1108w;
import kotlin.jvm.internal.C1109x;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.W;
import kotlin.jvm.internal.X;
import p060k4.b;
import p084o4.C1306e0;
import p084o4.C1307f;
import p084o4.C1310g0;
import p084o4.C1311h;
import p084o4.C1313i;
import p084o4.C1316j0;
import p084o4.C1317k;
import p084o4.C1318k0;
import p084o4.C1319l;
import p084o4.C1324n0;
import p084o4.C1329q;
import p084o4.C1341w0;
import p084o4.C1343x0;
import p084o4.C1347z0;
import p084o4.D;
import p084o4.L;
import p084o4.M;
import p084o4.O0;
import p084o4.T0;
import p084o4.U0;
import p084o4.V0;
import p084o4.Y;
import p084o4.Y0;
import p084o4.Z;
import p084o4.b1;
import p084o4.c1;
import p084o4.e1;
import p084o4.f1;
import p084o4.h1;
import p084o4.i1;
import p084o4.k1;
import p084o4.l1;
import p084o4.m1;
import p084o4.n1;
import p084o4.r;
import p147z3.F;
import p147z3.I;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final <T, E extends T> b ArraySerializer(c kClass, b elementSerializer) {
        E.f(kClass, "kClass");
        E.f(elementSerializer, "elementSerializer");
        return new O0(kClass, elementSerializer);
    }

    public static final b BooleanArraySerializer() {
        return C1311h.INSTANCE;
    }

    public static final b ByteArraySerializer() {
        return C1317k.INSTANCE;
    }

    public static final b CharArraySerializer() {
        return C1329q.INSTANCE;
    }

    public static final b DoubleArraySerializer() {
        return D.INSTANCE;
    }

    public static final b FloatArraySerializer() {
        return L.INSTANCE;
    }

    public static final b IntArraySerializer() {
        return Y.INSTANCE;
    }

    public static final <T> b ListSerializer(b elementSerializer) {
        E.f(elementSerializer, "elementSerializer");
        return new C1307f(elementSerializer);
    }

    public static final b LongArraySerializer() {
        return C1316j0.INSTANCE;
    }

    public static final <K, V> b MapEntrySerializer(b keySerializer, b valueSerializer) {
        E.f(keySerializer, "keySerializer");
        E.f(valueSerializer, "valueSerializer");
        return new C1324n0(keySerializer, valueSerializer);
    }

    public static final <K, V> b MapSerializer(b keySerializer, b valueSerializer) {
        E.f(keySerializer, "keySerializer");
        E.f(valueSerializer, "valueSerializer");
        return new C1306e0(keySerializer, valueSerializer);
    }

    public static final b NothingSerializer() {
        return C1341w0.INSTANCE;
    }

    public static final <K, V> b PairSerializer(b keySerializer, b valueSerializer) {
        E.f(keySerializer, "keySerializer");
        E.f(valueSerializer, "valueSerializer");
        return new C1347z0(keySerializer, valueSerializer);
    }

    public static final <T> b SetSerializer(b elementSerializer) {
        E.f(elementSerializer, "elementSerializer");
        return new C1310g0(elementSerializer);
    }

    public static final b ShortArraySerializer() {
        return T0.INSTANCE;
    }

    public static final <A, B, C> b TripleSerializer(b aSerializer, b bSerializer, b cSerializer) {
        E.f(aSerializer, "aSerializer");
        E.f(bSerializer, "bSerializer");
        E.f(cSerializer, "cSerializer");
        return new Y0(aSerializer, bSerializer, cSerializer);
    }

    public static final b UByteArraySerializer() {
        return b1.INSTANCE;
    }

    public static final b UIntArraySerializer() {
        return e1.INSTANCE;
    }

    public static final b ULongArraySerializer() {
        return h1.INSTANCE;
    }

    public static final b UShortArraySerializer() {
        return k1.INSTANCE;
    }

    public static final <T> b getNullable(b bVar) {
        E.f(bVar, "<this>");
        return bVar.getDescriptor().a() ? bVar : new C1343x0(bVar);
    }

    public static final b serializer(C1103q c1103q) {
        E.f(c1103q, "<this>");
        return r.INSTANCE;
    }

    public static final <T, E extends T> b ArraySerializer(b elementSerializer) {
        E.f(elementSerializer, "elementSerializer");
        E.l();
        throw null;
    }

    public static final b serializer(C1100n c1100n) {
        E.f(c1100n, "<this>");
        return C1319l.INSTANCE;
    }

    public static final b serializer(W w6) {
        E.f(w6, "<this>");
        return U0.INSTANCE;
    }

    public static final b serializer(C c) {
        E.f(c, "<this>");
        return Z.INSTANCE;
    }

    public static final b serializer(G g6) {
        E.f(g6, "<this>");
        return C1318k0.INSTANCE;
    }

    public static final b serializer(C1109x c1109x) {
        E.f(c1109x, "<this>");
        return M.INSTANCE;
    }

    public static final b serializer(C1108w c1108w) {
        E.f(c1108w, "<this>");
        return p084o4.E.INSTANCE;
    }

    public static final b serializer(C1099m c1099m) {
        E.f(c1099m, "<this>");
        return C1313i.INSTANCE;
    }

    public static final b serializer(Q q6) {
        E.f(q6, "<this>");
        return m1.INSTANCE;
    }

    public static final b serializer(X x6) {
        E.f(x6, "<this>");
        return V0.INSTANCE;
    }

    public static final b serializer(F f6) {
        E.f(f6, "<this>");
        return f1.INSTANCE;
    }

    public static final b serializer(I i5) {
        E.f(i5, "<this>");
        return i1.INSTANCE;
    }

    public static final b serializer(p147z3.C c) {
        E.f(c, "<this>");
        return c1.INSTANCE;
    }

    public static final b serializer(p147z3.M m6) {
        E.f(m6, "<this>");
        return l1.INSTANCE;
    }

    public static final b serializer(Y3.a aVar) {
        E.f(aVar, "<this>");
        return p084o4.F.INSTANCE;
    }

    public static final b serializer(Z3.b bVar) {
        E.f(bVar, "<this>");
        return n1.INSTANCE;
    }
}

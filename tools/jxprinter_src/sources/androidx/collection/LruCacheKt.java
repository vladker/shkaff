package androidx.collection;

import O3.l;
import O3.p;
import O3.r;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // O3.p
        public final Integer invoke(Object obj, Object obj2) {
            E.f(obj, "<anonymous parameter 0>");
            E.f(obj2, "<anonymous parameter 1>");
            return 1;
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass2 extends F implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // O3.l
        public final Object invoke(Object it) {
            E.f(it, "it");
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass3 extends F implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        public final void invoke(boolean z6, Object obj, Object obj2, Object obj3) {
            E.f(obj, "<anonymous parameter 1>");
            E.f(obj2, "<anonymous parameter 2>");
        }

        @Override // O3.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l $create;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(int i5, p pVar, l lVar, r rVar) {
            super(i5);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
        }

        @Override // androidx.collection.LruCache
        public V create(K key) {
            E.f(key, "key");
            return (V) this.$create.invoke(key);
        }

        @Override // androidx.collection.LruCache
        public void entryRemoved(boolean z6, K key, V oldValue, V v6) {
            E.f(key, "key");
            E.f(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z6), key, oldValue, v6);
        }

        @Override // androidx.collection.LruCache
        public int sizeOf(K key, V value) {
            E.f(key, "key");
            E.f(value, "value");
            return ((Number) this.$sizeOf.invoke(key, value)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i5, p sizeOf, l create, r onEntryRemoved) {
        E.f(sizeOf, "sizeOf");
        E.f(create, "create");
        E.f(onEntryRemoved, "onEntryRemoved");
        return new AnonymousClass4(i5, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache lruCache$default(int i5, p sizeOf, l create, r onEntryRemoved, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            sizeOf = AnonymousClass1.INSTANCE;
        }
        if ((i6 & 4) != 0) {
            create = AnonymousClass2.INSTANCE;
        }
        if ((i6 & 8) != 0) {
            onEntryRemoved = AnonymousClass3.INSTANCE;
        }
        E.f(sizeOf, "sizeOf");
        E.f(create, "create");
        E.f(onEntryRemoved, "onEntryRemoved");
        return new AnonymousClass4(i5, sizeOf, create, onEntryRemoved);
    }
}

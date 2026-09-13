package androidx.core.util;

import O3.l;
import O3.p;
import O3.r;
import android.util.LruCache;
import kotlin.jvm.internal.F;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // O3.p
        public final Integer invoke(Object obj, Object obj2) {
            return 1;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass2 extends F implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // O3.l
        public final Object invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass3 extends F implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        public final void invoke(boolean z6, Object obj, Object obj2, Object obj3) {
        }

        @Override // O3.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
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

        @Override // android.util.LruCache
        public V create(K k6) {
            return (V) this.$create.invoke(k6);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z6, K k6, V v6, V v7) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(z6), k6, v6, v7);
        }

        @Override // android.util.LruCache
        public int sizeOf(K k6, V v6) {
            return ((Number) this.$sizeOf.invoke(k6, v6)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i5, p pVar, l lVar, r rVar) {
        return new AnonymousClass4(i5, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i5, p pVar, l lVar, r rVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        if ((i6 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        if ((i6 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        return new AnonymousClass4(i5, pVar, lVar, rVar);
    }
}

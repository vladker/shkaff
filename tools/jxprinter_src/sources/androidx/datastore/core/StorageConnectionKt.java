package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import O3.q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageConnectionKt {

    /* JADX INFO: renamed from: androidx.datastore.core.StorageConnectionKt$readData$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements q {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(g<? super AnonymousClass2> gVar) {
            super(3, gVar);
        }

        public final Object invoke(ReadScope<T> readScope, boolean z6, g<? super T> gVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(gVar);
            anonymousClass2.L$0 = readScope;
            return anonymousClass2.invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                return obj;
            }
            v.throwOnFailure(obj);
            ReadScope readScope = (ReadScope) this.L$0;
            this.label = 1;
            Object data = readScope.readData(this);
            return data == coroutine_suspended ? coroutine_suspended : data;
        }

        @Override // O3.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (g) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.StorageConnectionKt$writeData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03432 extends m implements p {
        final /* synthetic */ T $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03432(T t6, g<? super C03432> gVar) {
            super(2, gVar);
            this.$value = t6;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            C03432 c03432 = new C03432(this.$value, gVar);
            c03432.L$0 = obj;
            return c03432;
        }

        @Override // O3.p
        public final Object invoke(WriteScope<T> writeScope, g<? super Q> gVar) {
            return ((C03432) create(writeScope, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                WriteScope writeScope = (WriteScope) this.L$0;
                T t6 = this.$value;
                this.label = 1;
                if (writeScope.writeData(t6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object readData(StorageConnection<T> storageConnection, g<? super T> gVar) {
        return storageConnection.readScope(new AnonymousClass2(null), gVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t6, g<? super Q> gVar) {
        Object objWriteScope = storageConnection.writeScope(new C03432(t6, null), gVar);
        return objWriteScope == i.getCOROUTINE_SUSPENDED() ? objWriteScope : Q.INSTANCE;
    }
}

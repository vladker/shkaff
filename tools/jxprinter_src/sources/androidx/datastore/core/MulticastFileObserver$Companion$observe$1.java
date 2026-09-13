package androidx.datastore.core;

import E3.g;
import G3.f;
import G3.m;
import O3.p;
import java.io.File;
import kotlin.jvm.internal.F;
import p007a4.InterfaceC0280h0;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", i = {0, 0}, l = {84, 85}, m = "invokeSuspend", n = {"$this$channelFlow", "disposeListener"}, s = {"L$0", "L$1"})
public final class MulticastFileObserver$Companion$observe$1 extends m implements p {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements O3.a {
        final /* synthetic */ InterfaceC0280h0 $disposeListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0280h0 interfaceC0280h0) {
            super(0);
            this.$disposeListener = interfaceC0280h0;
        }

        @Override // O3.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m976invoke();
            return Q.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m976invoke() {
            this.$disposeListener.dispose();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1(File file, g<? super MulticastFileObserver$Companion$observe$1> gVar) {
        super(2, gVar);
        this.$file = file;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, gVar);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // O3.p
    public final Object invoke(x0 x0Var, g<? super Q> gVar) {
        return ((MulticastFileObserver$Companion$observe$1) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (p018c4.v0.awaitClose(r3, r7, r6) == r0) goto L16;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            p147z3.v.throwOnFailure(r7)
            goto L66
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.L$1
            a4.h0 r1 = (p007a4.InterfaceC0280h0) r1
            java.lang.Object r3 = r6.L$0
            c4.x0 r3 = (p018c4.x0) r3
            p147z3.v.throwOnFailure(r7)
            goto L53
        L26:
            p147z3.v.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            c4.x0 r7 = (p018c4.x0) r7
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1 r1 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1
            java.io.File r4 = r6.$file
            r1.<init>(r4, r7)
            androidx.datastore.core.MulticastFileObserver$Companion r4 = androidx.datastore.core.MulticastFileObserver.Companion
            java.io.File r5 = r6.$file
            java.io.File r5 = r5.getParentFile()
            kotlin.jvm.internal.E.c(r5)
            a4.h0 r1 = androidx.datastore.core.MulticastFileObserver.Companion.access$observe(r4, r5, r1)
            z3.Q r4 = p147z3.Q.INSTANCE
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r3 = r7.send(r4, r6)
            if (r3 != r0) goto L52
            goto L65
        L52:
            r3 = r7
        L53:
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1 r7 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1
            r7.<init>(r1)
            r1 = 0
            r6.L$0 = r1
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = p018c4.v0.awaitClose(r3, r7, r6)
            if (r7 != r0) goto L66
        L65:
            return r0
        L66:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MulticastFileObserver$Companion$observe$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

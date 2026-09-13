package p023d4;

import O3.p;

/* JADX INFO: renamed from: d4.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0604l0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f3886a;
    public final /* synthetic */ p b;

    public C0604l0(InterfaceC0612o interfaceC0612o, p pVar) {
        this.f3886a = interfaceC0612o;
        this.b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        if (r8 == r1) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [d4.p] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [d4.p] */
    /* JADX WARN: Type inference failed for: r7v1, types: [G3.d] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v7, types: [G3.d] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p023d4.InterfaceC0612o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(p023d4.InterfaceC0615p r7, E3.g r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p023d4.C0601k0
            if (r0 == 0) goto L13
            r0 = r8
            d4.k0 r0 = (p023d4.C0601k0) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            d4.k0 r0 = new d4.k0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3882a
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.d
            kotlinx.coroutines.flow.internal.F r7 = (kotlinx.coroutines.flow.internal.F) r7
            p147z3.v.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L30
            goto L89
        L30:
            r8 = move-exception
            goto L8d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.jvm.internal.P r7 = r0.f3883f
            d4.p r2 = r0.e
            java.lang.Object r4 = r0.d
            d4.l0 r4 = (p023d4.C0604l0) r4
            p147z3.v.throwOnFailure(r8)
            goto L6a
        L46:
            p147z3.v.throwOnFailure(r8)
            kotlin.jvm.internal.P r8 = new kotlin.jvm.internal.P
            r8.<init>()
            r8.f5686a = r4
            d4.n0 r2 = new d4.n0
            r5 = 0
            r2.<init>(r8, r7, r5)
            r0.d = r6
            r0.e = r7
            r0.f3883f = r8
            r0.b = r4
            d4.o r4 = r6.f3886a
            java.lang.Object r2 = r4.collect(r2, r0)
            if (r2 != r1) goto L67
            goto L88
        L67:
            r4 = r6
            r2 = r7
            r7 = r8
        L6a:
            boolean r7 = r7.f5686a
            if (r7 == 0) goto L91
            kotlinx.coroutines.flow.internal.F r7 = new kotlinx.coroutines.flow.internal.F
            E3.q r8 = r0.getContext()
            r7.<init>(r2, r8)
            O3.p r8 = r4.b     // Catch: java.lang.Throwable -> L30
            r0.d = r7     // Catch: java.lang.Throwable -> L30
            r2 = 0
            r0.e = r2     // Catch: java.lang.Throwable -> L30
            r0.f3883f = r2     // Catch: java.lang.Throwable -> L30
            r0.b = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.invoke(r7, r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L89
        L88:
            return r1
        L89:
            r7.releaseIntercepted()
            goto L91
        L8d:
            r7.releaseIntercepted()
            throw r8
        L91:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.C0604l0.collect(d4.p, E3.g):java.lang.Object");
    }
}

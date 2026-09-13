package X3;

import W3.AbstractC0234s;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Matcher f846a;
    public int b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ G e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CharSequence f847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f848g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(G g6, CharSequence charSequence, int i5, E3.g gVar) {
        super(2, gVar);
        this.e = g6;
        this.f847f = charSequence;
        this.f848g = i5;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        J j6 = new J(this.e, this.f847f, this.f848g, gVar);
        j6.d = obj;
        return j6;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((J) create((AbstractC0234s) obj, (E3.g) obj2)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006d A[PHI: r1 r8 r11
  0x006d: PHI (r1v7 int) = (r1v6 int), (r1v10 int) binds: [B:19:0x006a, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x006d: PHI (r8v2 W3.s) = (r8v1 W3.s), (r8v4 W3.s) binds: [B:19:0x006a, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x006d: PHI (r11v7 java.util.regex.Matcher) = (r11v6 java.util.regex.Matcher), (r11v13 java.util.regex.Matcher) binds: [B:19:0x006a, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        if (r8.yield(r11, r10) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r11.yield(r1, r10) == r0) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006a -> B:21:0x006d). Please report as a decompilation issue!!! */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r10.c
            int r2 = r10.f848g
            r3 = 3
            r4 = 2
            java.lang.CharSequence r5 = r10.f847f
            r6 = 1
            if (r1 == 0) goto L34
            if (r1 == r6) goto L2f
            if (r1 == r4) goto L22
            if (r1 != r3) goto L1a
            p147z3.v.throwOnFailure(r11)
            goto L96
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            int r1 = r10.b
            java.util.regex.Matcher r7 = r10.f846a
            java.lang.Object r8 = r10.d
            W3.s r8 = (W3.AbstractC0234s) r8
            p147z3.v.throwOnFailure(r11)
            r11 = r7
            goto L6d
        L2f:
            p147z3.v.throwOnFailure(r11)
            goto La6
        L34:
            p147z3.v.throwOnFailure(r11)
            java.lang.Object r11 = r10.d
            W3.s r11 = (W3.AbstractC0234s) r11
            X3.G r1 = r10.e
            java.util.regex.Pattern r1 = X3.G.a(r1)
            java.util.regex.Matcher r1 = r1.matcher(r5)
            if (r2 == r6) goto L99
            boolean r7 = r1.find()
            if (r7 != 0) goto L4e
            goto L99
        L4e:
            r7 = 0
            r8 = r11
            r11 = r1
            r1 = r7
        L52:
            int r9 = r11.start()
            java.lang.CharSequence r7 = r5.subSequence(r7, r9)
            java.lang.String r7 = r7.toString()
            r10.d = r8
            r10.f846a = r11
            r10.b = r1
            r10.c = r4
            java.lang.Object r7 = r8.yield(r7, r10)
            if (r7 != r0) goto L6d
            goto La5
        L6d:
            int r7 = r11.end()
            int r1 = r1 + r6
            int r9 = r2 + (-1)
            if (r1 == r9) goto L7c
            boolean r9 = r11.find()
            if (r9 != 0) goto L52
        L7c:
            int r11 = r5.length()
            java.lang.CharSequence r11 = r5.subSequence(r7, r11)
            java.lang.String r11 = r11.toString()
            r1 = 0
            r10.d = r1
            r10.f846a = r1
            r10.c = r3
            java.lang.Object r11 = r8.yield(r11, r10)
            if (r11 != r0) goto L96
            goto La5
        L96:
            z3.Q r11 = p147z3.Q.INSTANCE
            return r11
        L99:
            java.lang.String r1 = r5.toString()
            r10.c = r6
            java.lang.Object r11 = r11.yield(r1, r10)
            if (r11 != r0) goto La6
        La5:
            return r0
        La6:
            z3.Q r11 = p147z3.Q.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.J.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

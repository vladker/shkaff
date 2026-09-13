package A4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class W implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f64a;
    public boolean b;
    private final C0169l buffer;
    public long c;
    private c0 expectedSegment;
    private final InterfaceC0171n upstream;

    public W(InterfaceC0171n upstream) {
        kotlin.jvm.internal.E.f(upstream, "upstream");
        this.upstream = upstream;
        C0169l buffer = upstream.getBuffer();
        this.buffer = buffer;
        c0 c0Var = buffer.head;
        this.expectedSegment = c0Var;
        this.f64a = c0Var != null ? c0Var.pos : -1;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r4.pos) goto L15;
     */
    @Override // A4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long read(A4.C0169l r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.E.f(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L71
            boolean r3 = r8.b
            if (r3 != 0) goto L69
            A4.c0 r3 = r8.expectedSegment
            if (r3 == 0) goto L2b
            A4.l r4 = r8.buffer
            A4.c0 r4 = r4.head
            if (r3 != r4) goto L23
            int r3 = r8.f64a
            kotlin.jvm.internal.E.c(r4)
            int r4 = r4.pos
            if (r3 != r4) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            A4.n r0 = r8.upstream
            long r1 = r8.c
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            A4.c0 r0 = r8.expectedSegment
            if (r0 != 0) goto L4e
            A4.l r0 = r8.buffer
            A4.c0 r0 = r0.head
            if (r0 == 0) goto L4e
            r8.expectedSegment = r0
            int r0 = r0.pos
            r8.f64a = r0
        L4e:
            A4.l r0 = r8.buffer
            long r0 = r0.size()
            long r2 = r8.c
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            A4.l r2 = r8.buffer
            long r4 = r8.c
            r3 = r9
            r2.copyTo(r3, r4, r6)
            long r9 = r8.c
            long r9 = r9 + r6
            r8.c = r9
            return r6
        L69:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L71:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = androidx.collection.a.j(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: A4.W.read(A4.l, long):long");
    }

    @Override // A4.h0
    public k0 timeout() {
        return this.upstream.timeout();
    }
}

package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0964c implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5347a;
    public final C0965d[] b;
    public long c;

    public C0964c(ThreadFactory threadFactory, int i5) {
        this.f5347a = i5;
        this.b = new C0965d[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            this.b[i6] = new C0965d(threadFactory);
        }
    }

    public final C0965d a() {
        int i5 = this.f5347a;
        if (i5 == 0) {
            return C0966e.f5348f;
        }
        long j6 = this.c;
        this.c = 1 + j6;
        return this.b[(int) (j6 % ((long) i5))];
    }

    @Override // io.reactivex.internal.schedulers.z
    public final void createWorkers(int i5, y yVar) {
        int i6 = this.f5347a;
        if (i6 == 0) {
            for (int i7 = 0; i7 < i5; i7++) {
                ((W1.a) yVar).onWorker(i7, C0966e.f5348f);
            }
            return;
        }
        int i8 = ((int) this.c) % i6;
        for (int i9 = 0; i9 < i5; i9++) {
            ((W1.a) yVar).onWorker(i9, new C0963b(this.b[i8]));
            i8++;
            if (i8 == i6) {
                i8 = 0;
            }
        }
        this.c = i8;
    }
}

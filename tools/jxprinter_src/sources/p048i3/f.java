package p048i3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends e {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i5, int i6) {
        super(i5);
        this.e = i6;
    }

    @Override // p048i3.e, io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.e) {
            case 0:
                if (this.f4048a == null) {
                    this.b = th;
                }
                countDown();
                break;
            default:
                this.f4048a = null;
                this.b = th;
                countDown();
                break;
        }
    }

    @Override // p048i3.e, io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.e) {
            case 0:
                if (this.f4048a == null) {
                    this.f4048a = obj;
                    this.c.dispose();
                    countDown();
                }
                break;
            default:
                this.f4048a = obj;
                break;
        }
    }
}

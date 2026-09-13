package J0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {
    public static final b b = new b(0);
    public static final a c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f346a;

    public /* synthetic */ b(int i5) {
        this.f346a = i5;
    }

    @Override // J0.d
    public final void d(com.bumptech.glide.request.target.g gVar) {
        switch (this.f346a) {
            case 0:
                return;
            default:
                if (gVar.getView() == null) {
                    return;
                }
                gVar.getView();
                throw null;
        }
    }

    private final void a(com.bumptech.glide.request.target.g gVar) {
    }
}

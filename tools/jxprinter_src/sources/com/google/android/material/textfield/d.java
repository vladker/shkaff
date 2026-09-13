package com.google.android.material.textfield;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3367a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i5) {
        this.f3367a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3367a) {
            case 0:
                ((ClearTextEndIconDelegate) this.b).lambda$tearDown$2();
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.b).lambda$afterEditTextChanged$3();
                break;
            default:
                ((TextInputLayout) this.b).lambda$onGlobalLayout$1();
                break;
        }
    }
}

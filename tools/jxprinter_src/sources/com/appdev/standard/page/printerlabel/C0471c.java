package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0471c implements LineProgressWidget.OnRangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2726a;
    public final /* synthetic */ AttributeMaterialStyleFragment b;

    public /* synthetic */ C0471c(AttributeMaterialStyleFragment attributeMaterialStyleFragment, int i5) {
        this.f2726a = i5;
        this.b = attributeMaterialStyleFragment;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeListener
    public final void onRange(float f6) {
        switch (this.f2726a) {
            case 0:
                this.b.lambda$setupBinaryModeListeners$6(f6);
                break;
            case 1:
                this.b.lambda$setupShakeModeListeners$3(f6);
                break;
            case 2:
                this.b.lambda$setupShakeModeListeners$4(f6);
                break;
            case 3:
                this.b.lambda$setupShakeModeListeners$5(f6);
                break;
            case 4:
                this.b.lambda$setupOriginalModeListeners$0(f6);
                break;
            case 5:
                this.b.lambda$setupOriginalModeListeners$1(f6);
                break;
            default:
                this.b.lambda$setupOriginalModeListeners$2(f6);
                break;
        }
    }
}

package org.apache.poi.common.usermodel.fonts;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6951a;
    public final /* synthetic */ FontHeader b;

    public /* synthetic */ b(FontHeader fontHeader, int i5) {
        this.f6951a = i5;
        this.b = fontHeader;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6951a) {
            case 0:
                return this.b.getPanoseContrast();
            case 1:
                return this.b.getPanoseStroke();
            case 2:
                return this.b.lambda$getPanoseContrast$15();
            case 3:
                return this.b.lambda$getPanoseWeight$13();
            case 4:
                return this.b.lambda$getPanoseArmStyle$17();
            case 5:
                return this.b.lambda$getPanoseSerif$12();
            case 6:
                return this.b.lambda$getPanoseXHeight$20();
            case 7:
                return this.b.lambda$getPanoseFamily$11();
            default:
                return this.b.lambda$getPanoseProportion$14();
        }
    }
}

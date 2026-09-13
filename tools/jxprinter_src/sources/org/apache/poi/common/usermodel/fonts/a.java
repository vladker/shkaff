package org.apache.poi.common.usermodel.fonts;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6950a;
    public final /* synthetic */ FontHeader b;

    public /* synthetic */ a(FontHeader fontHeader, int i5) {
        this.f6950a = i5;
        this.b = fontHeader;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6950a) {
            case 0:
                return this.b.lambda$getPanoseLetterForm$18();
            case 1:
                return this.b.lambda$getGenericProperties$0();
            case 2:
                return this.b.getPanoseArmStyle();
            case 3:
                return this.b.getPanoseLetterForm();
            case 4:
                return this.b.getPanoseMidLine();
            case 5:
                return this.b.getPanoseXHeight();
            case 6:
                return this.b.getCharset();
            case 7:
                return Boolean.valueOf(this.b.isItalic());
            case 8:
                return Integer.valueOf(this.b.getWeight());
            case 9:
                return this.b.lambda$getGenericProperties$3();
            case 10:
                return this.b.lambda$getGenericProperties$4();
            case 11:
                return this.b.lambda$getPanoseStroke$16();
            case 12:
                return this.b.lambda$getGenericProperties$5();
            case 13:
                return this.b.lambda$getGenericProperties$1();
            case 14:
                return this.b.lambda$getGenericProperties$6();
            case 15:
                return this.b.lambda$getGenericProperties$7();
            case 16:
                return this.b.lambda$getGenericProperties$8();
            case 17:
                return this.b.lambda$getGenericProperties$9();
            case 18:
                return this.b.lambda$getGenericProperties$10();
            case 19:
                return this.b.getFamilyName();
            case 20:
                return this.b.getStyleName();
            case 21:
                return this.b.getVersionName();
            case 22:
                return this.b.lambda$getPanoseMidLine$19();
            case 23:
                return this.b.getFullName();
            case 24:
                return this.b.lambda$getGenericProperties$2();
            case 25:
                return Integer.valueOf(this.b.getFlags());
            case 26:
                return this.b.getPanoseFamily();
            case 27:
                return this.b.getPanoseSerif();
            case 28:
                return this.b.getPanoseWeight();
            default:
                return this.b.getPanoseProportion();
        }
    }
}

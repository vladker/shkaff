package org.apache.poi.sl.draw;

import java.util.function.Function;
import org.apache.poi.sl.usermodel.ColorStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7172a;

    public /* synthetic */ f(int i5) {
        this.f7172a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        ColorStyle colorStyle = (ColorStyle) obj;
        switch (this.f7172a) {
            case 0:
                return DrawPaint.lambda$safeFractions$3(colorStyle);
            default:
                return DrawPaint.applyColorTransform(colorStyle);
        }
    }
}

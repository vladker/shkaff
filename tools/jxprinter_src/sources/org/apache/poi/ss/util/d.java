package org.apache.poi.ss.util;

import java.util.function.Function;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7243a;
    public final /* synthetic */ Sheet b;

    public /* synthetic */ d(Sheet sheet, int i5) {
        this.f7243a = i5;
        this.b = sheet;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7243a) {
            case 0:
                return Float.valueOf(this.b.getColumnWidthInPixels(((Integer) obj).intValue()));
            case 1:
                return ImageUtils.lambda$setPreferredSize$0(this.b, (Integer) obj);
            default:
                return ImageUtils.lambda$getDimensionFromAnchor$1(this.b, (Integer) obj);
        }
    }
}

package org.apache.poi.hssf.record;

import java.util.function.IntFunction;

/* JADX INFO: renamed from: org.apache.poi.hssf.record.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C1434x0 implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7129a;

    public /* synthetic */ C1434x0(int i5) {
        this.f7129a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7129a) {
            case 0:
                return new PaletteRecord.PColor(i5);
            case 1:
                return ExtSSTRecord.lambda$new$0(i5);
            case 2:
                return FeatRecord.lambda$new$0(i5);
            case 3:
                return MergeCellsRecord.lambda$new$0(i5);
            default:
                return SelectionRecord.lambda$new$0(i5);
        }
    }
}

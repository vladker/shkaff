package org.apache.poi.hssf.record.chart;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class m implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7063a;

    public /* synthetic */ m(int i5) {
        this.f7063a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7063a) {
            case 0:
                return ChartFRTInfoRecord.lambda$new$0(i5);
            default:
                return ChartTitleFormatRecord.lambda$new$0(i5);
        }
    }
}

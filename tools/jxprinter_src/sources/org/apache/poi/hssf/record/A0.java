package org.apache.poi.hssf.record;

import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.util.IntMapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class A0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6984a;
    public final /* synthetic */ Duplicatable b;

    public /* synthetic */ A0(Duplicatable duplicatable, int i5) {
        this.f6984a = i5;
        this.b = duplicatable;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6984a) {
            case 0:
                return Integer.valueOf(((PasswordRecord) this.b).getPassword());
            case 1:
                return ((PasswordRev4Record) this.b).lambda$getGenericProperties$0();
            case 2:
                return Boolean.valueOf(((PrecisionRecord) this.b).getFullPrecision());
            case 3:
                return Boolean.valueOf(((PrintGridlinesRecord) this.b).getPrintGridlines());
            case 4:
                return Boolean.valueOf(((PrintHeadersRecord) this.b).getPrintHeaders());
            case 5:
                return Short.valueOf(((RefModeRecord) this.b).getMode());
            case 6:
                return Double.valueOf(((RightMarginRecord) this.b).getMargin());
            case 7:
                return ((IntMapper) this.b).getElements();
            case 8:
                return Boolean.valueOf(((SaveRecalcRecord) this.b).getRecalc());
            case 9:
                return Boolean.valueOf(((ScenarioProtectRecord) this.b).getProtect());
            case 10:
                return ((TabIdRecord) this.b).lambda$getGenericProperties$0();
            case 11:
                return Double.valueOf(((TopMarginRecord) this.b).getMargin());
            case 12:
                return ((UncalcedRecord) this.b).lambda$getGenericProperties$0();
            case 13:
                return ((UseSelFSRecord) this.b).lambda$getGenericProperties$0();
            case 14:
                return ((UserSViewEnd) this.b).lambda$getGenericProperties$0();
            case 15:
                return Boolean.valueOf(((VCenterRecord) this.b).getVCenter());
            default:
                return ((WriteAccessRecord) this.b).getUsername();
        }
    }
}

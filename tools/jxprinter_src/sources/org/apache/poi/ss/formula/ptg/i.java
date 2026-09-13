package org.apache.poi.ss.formula.ptg;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7218a;
    public final /* synthetic */ Ptg b;

    public /* synthetic */ i(Ptg ptg, int i5) {
        this.f7218a = i5;
        this.b = ptg;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7218a) {
            case 0:
                return Boolean.valueOf(((BoolPtg) this.b).getValue());
            case 1:
                return Integer.valueOf(((ErrPtg) this.b).getErrorCode());
            case 2:
                return Integer.valueOf(((IntPtg) this.b).getValue());
            case 3:
                return Integer.valueOf(((MemAreaPtg) this.b).getLenRefSubexpression());
            case 4:
                return Integer.valueOf(((MemErrPtg) this.b).getLenRefSubexpression());
            case 5:
                return Integer.valueOf(((MemFuncPtg) this.b).getLenRefSubexpression());
            case 6:
                return Integer.valueOf(((NamePtg) this.b).getIndex());
            case 7:
                return Double.valueOf(((NumberPtg) this.b).getValue());
            case 8:
                return ((RefErrorPtg) this.b).lambda$getGenericProperties$0();
            default:
                return ((StringPtg) this.b).getValue();
        }
    }
}

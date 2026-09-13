package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class H implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6996a;
    public final /* synthetic */ Object b;

    public /* synthetic */ H(Object obj, int i5) {
        this.f6996a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6996a) {
            case 0:
                ((ArrayList) this.b).add((ExternSheetRecord.RefSubRecord) obj);
                break;
            case 1:
                ((ArrayList) this.b).add((PaletteRecord.PColor) obj);
                break;
            case 2:
                ((ArrayList) this.b).add((SubRecord) obj);
                break;
            default:
                ((PageBreakRecord) this.b).lambda$initMap$0((PageBreakRecord.Break) obj);
                break;
        }
    }
}

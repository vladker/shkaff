package org.apache.poi.ss.usermodel;

import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7231a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f7231a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7231a) {
            case 0:
                ((RangeCopier) this.b).lambda$copyRange$0((CellRangeAddress) obj);
                break;
            default:
                ((ArrayList) this.b).add((WorkbookProvider) obj);
                break;
        }
    }
}

package org.apache.poi.xslf.usermodel;

import java.util.function.Consumer;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7323a;
    public final /* synthetic */ CTHeaderFooter b;

    public /* synthetic */ d(CTHeaderFooter cTHeaderFooter, int i5) {
        this.f7323a = i5;
        this.b = cTHeaderFooter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7323a;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        switch (i5) {
            case 0:
                this.b.setHdr(zBooleanValue);
                break;
            case 1:
                this.b.setFtr(zBooleanValue);
                break;
            case 2:
                this.b.setDt(zBooleanValue);
                break;
            default:
                this.b.setSldNum(zBooleanValue);
                break;
        }
    }
}

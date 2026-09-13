package org.apache.poi.xwpf.usermodel;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7346a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7346a) {
            case 0:
                ((CTTblCellMar) obj).unsetTop();
                break;
            case 1:
                ((CTTblCellMar) obj).unsetLeft();
                break;
            case 2:
                ((CTTblBorders) obj).unsetBottom();
                break;
            case 3:
                ((CTTblBorders) obj).unsetInsideH();
                break;
            case 4:
                ((CTTblBorders) obj).unsetInsideV();
                break;
            case 5:
                ((CTTblBorders) obj).unsetLeft();
                break;
            case 6:
                ((CTTblBorders) obj).unsetTop();
                break;
            case 7:
                ((CTTblBorders) obj).unsetRight();
                break;
            case 8:
                ((CTTblCellMar) obj).unsetBottom();
                break;
            default:
                ((CTTblCellMar) obj).unsetRight();
                break;
        }
    }
}

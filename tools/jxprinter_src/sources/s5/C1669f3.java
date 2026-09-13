package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSectPrImpl;

/* JADX INFO: renamed from: s5.f3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1669f3 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8405a;
    public final /* synthetic */ CTSectPrImpl b;

    public /* synthetic */ C1669f3(CTSectPrImpl cTSectPrImpl, int i5) {
        this.f8405a = i5;
        this.b = cTSectPrImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8405a;
        int iIntValue = ((Integer) obj).intValue();
        CTHdrFtrRef cTHdrFtrRef = (CTHdrFtrRef) obj2;
        switch (i5) {
            case 0:
                this.b.setFooterReferenceArray(iIntValue, cTHdrFtrRef);
                break;
            default:
                this.b.setHeaderReferenceArray(iIntValue, cTHdrFtrRef);
                break;
        }
    }
}

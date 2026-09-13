package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSectPrImpl;

/* JADX INFO: renamed from: s5.h3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1679h3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8417a;
    public final /* synthetic */ CTSectPrImpl b;

    public /* synthetic */ C1679h3(CTSectPrImpl cTSectPrImpl, int i5) {
        this.f8417a = i5;
        this.b = cTSectPrImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFooterReferenceArray;
        switch (this.f8417a) {
            case 0:
                iSizeOfFooterReferenceArray = this.b.sizeOfFooterReferenceArray();
                break;
            default:
                iSizeOfFooterReferenceArray = this.b.sizeOfHeaderReferenceArray();
                break;
        }
        return Integer.valueOf(iSizeOfFooterReferenceArray);
    }
}

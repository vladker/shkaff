package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSectPrImpl;

/* JADX INFO: renamed from: s5.e3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1664e3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8399a;
    public final /* synthetic */ CTSectPrImpl b;

    public /* synthetic */ C1664e3(CTSectPrImpl cTSectPrImpl, int i5) {
        this.f8399a = i5;
        this.b = cTSectPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8399a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFooterReferenceArray(iIntValue);
            case 1:
                return this.b.insertNewFooterReference(iIntValue);
            case 2:
                return this.b.getHeaderReferenceArray(iIntValue);
            default:
                return this.b.insertNewHeaderReference(iIntValue);
        }
    }
}

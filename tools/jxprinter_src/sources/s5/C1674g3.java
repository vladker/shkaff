package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSectPrImpl;

/* JADX INFO: renamed from: s5.g3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1674g3 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8411a;
    public final /* synthetic */ CTSectPrImpl b;

    public /* synthetic */ C1674g3(CTSectPrImpl cTSectPrImpl, int i5) {
        this.f8411a = i5;
        this.b = cTSectPrImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8411a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFooterReference(iIntValue);
                break;
            default:
                this.b.removeHeaderReference(iIntValue);
                break;
        }
    }
}

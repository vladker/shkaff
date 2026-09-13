package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSettingsImpl;

/* JADX INFO: renamed from: s5.j3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1689j3 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8429a;
    public final /* synthetic */ CTSettingsImpl b;

    public /* synthetic */ C1689j3(CTSettingsImpl cTSettingsImpl, int i5) {
        this.f8429a = i5;
        this.b = cTSettingsImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8429a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAttachedSchema(iIntValue);
                break;
            case 1:
                this.b.removeActiveWritingStyle(iIntValue);
                break;
            default:
                this.b.removeSmartTagType(iIntValue);
                break;
        }
    }
}

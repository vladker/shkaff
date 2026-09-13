package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSettingsImpl;

/* JADX INFO: renamed from: s5.k3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1694k3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8434a;
    public final /* synthetic */ CTSettingsImpl b;

    public /* synthetic */ C1694k3(CTSettingsImpl cTSettingsImpl, int i5) {
        this.f8434a = i5;
        this.b = cTSettingsImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAttachedSchemaArray;
        switch (this.f8434a) {
            case 0:
                iSizeOfAttachedSchemaArray = this.b.sizeOfAttachedSchemaArray();
                break;
            case 1:
                iSizeOfAttachedSchemaArray = this.b.sizeOfActiveWritingStyleArray();
                break;
            default:
                iSizeOfAttachedSchemaArray = this.b.sizeOfSmartTagTypeArray();
                break;
        }
        return Integer.valueOf(iSizeOfAttachedSchemaArray);
    }
}

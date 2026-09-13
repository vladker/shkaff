package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSettingsImpl;

/* JADX INFO: renamed from: s5.i3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1684i3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8423a;
    public final /* synthetic */ CTSettingsImpl b;

    public /* synthetic */ C1684i3(CTSettingsImpl cTSettingsImpl, int i5) {
        this.f8423a = i5;
        this.b = cTSettingsImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8423a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getActiveWritingStyleArray(iIntValue);
            case 1:
                return this.b.getAttachedSchemaArray(iIntValue);
            case 2:
                return this.b.insertNewAttachedSchema(iIntValue);
            case 3:
                return this.b.insertNewActiveWritingStyle(iIntValue);
            case 4:
                return this.b.getSmartTagTypeArray(iIntValue);
            default:
                return this.b.insertNewSmartTagType(iIntValue);
        }
    }
}

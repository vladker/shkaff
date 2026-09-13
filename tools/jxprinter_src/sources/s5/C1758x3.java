package s5;

import com.microsoft.schemas.vml.CTF;
import com.microsoft.schemas.vml.CTH;
import com.microsoft.schemas.vml.impl.CTFormulasImpl;
import com.microsoft.schemas.vml.impl.CTHandlesImpl;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTStylesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTabsImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTblGridBaseImpl;

/* JADX INFO: renamed from: s5.x3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1758x3 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8499a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ C1758x3(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8499a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f8499a) {
            case 0:
                ((CTSmartTagPrImpl) this.b).setAttrArray(((Integer) obj).intValue(), (CTAttr) obj2);
                break;
            case 1:
                ((CTStylesImpl) this.b).setStyleArray(((Integer) obj).intValue(), (CTStyle) obj2);
                break;
            case 2:
                ((CTTabsImpl) this.b).setTabArray(((Integer) obj).intValue(), (CTTabStop) obj2);
                break;
            case 3:
                ((CTTblGridBaseImpl) this.b).setGridColArray(((Integer) obj).intValue(), (CTTblGridCol) obj2);
                break;
            case 4:
                ((CTFormulasImpl) this.b).setFArray(((Integer) obj).intValue(), (CTF) obj2);
                break;
            default:
                ((CTHandlesImpl) this.b).setHArray(((Integer) obj).intValue(), (CTH) obj2);
                break;
        }
    }
}

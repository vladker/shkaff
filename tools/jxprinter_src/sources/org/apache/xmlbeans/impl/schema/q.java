package org.apache.xmlbeans.impl.schema;

import java.util.function.Consumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class q implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7382a;
    public final /* synthetic */ Object b;

    public /* synthetic */ q(Object obj, int i5) {
        this.f7382a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7382a) {
            case 0:
                ((XsbReader) this.b).writeString((String) obj);
                break;
            case 1:
                ((XsbReader) this.b).writeQName((QName) obj);
                break;
            case 2:
                ((XsbReader) this.b).writeXmlValueObject((XmlAnySimpleType) obj);
                break;
            default:
                ((SchemaContainer) this.b).addAnnotation((SchemaAnnotation) obj);
                break;
        }
    }
}

package p084o4;

import kotlin.jvm.internal.E;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K0 extends AbstractC1312h0 {
    private final String serialName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(r primitive) {
        super(primitive);
        E.f(primitive, "primitive");
        this.serialName = primitive.getSerialName() + SoapEncSchemaTypeSystem.SOAP_ARRAY;
    }

    @Override // p084o4.AbstractC1312h0, p072m4.r
    public String getSerialName() {
        return this.serialName;
    }
}

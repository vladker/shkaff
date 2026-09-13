package u5;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final DocumentFactory f8745h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final SchemaType f8746i0;

    static {
        DocumentFactory documentFactory = new DocumentFactory(TypeSystemHolder.typeSystem, "signature5269doctype");
        f8745h0 = documentFactory;
        f8746i0 = documentFactory.getType();
    }
}

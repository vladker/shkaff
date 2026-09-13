package Q4;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface l extends XmlObject {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final DocumentFactory f578U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final SchemaType f579V;

    static {
        DocumentFactory documentFactory = new DocumentFactory(TypeSystemHolder.typeSystem, "qualifyingproperties53ccdoctype");
        f578U = documentFactory;
        f579V = documentFactory.getType();
    }
}

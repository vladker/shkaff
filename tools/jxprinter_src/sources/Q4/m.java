package Q4;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface m extends XmlObject {

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final DocumentFactory f580W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final SchemaType f581a0;

    static {
        DocumentFactory documentFactory = new DocumentFactory(TypeSystemHolder.typeSystem, "qualifyingpropertiestype9e16type");
        f580W = documentFactory;
        f581a0 = documentFactory.getType();
    }

    q h();
}

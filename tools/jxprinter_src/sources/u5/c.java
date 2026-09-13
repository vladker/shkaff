package u5;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final DocumentFactory f8747j0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final SchemaType f8748l0;

    static {
        DocumentFactory documentFactory = new DocumentFactory(TypeSystemHolder.typeSystem, "transforme335doctype");
        f8747j0 = documentFactory;
        f8748l0 = documentFactory.getType();
    }
}

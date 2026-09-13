package R4;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final DocumentFactory f612d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final SchemaType f613e0;

    static {
        DocumentFactory documentFactory = new DocumentFactory(TypeSystemHolder.typeSystem, "timestampvalidationdataeb4bdoctype");
        f612d0 = documentFactory;
        f613e0 = documentFactory.getType();
    }
}

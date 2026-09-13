package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPath2DList extends XmlObject {
    public static final DocumentFactory<CTPath2DList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPath2DList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpath2dlistb010type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPath2D addNewPath();

    CTPath2D getPathArray(int i5);

    CTPath2D[] getPathArray();

    List<CTPath2D> getPathList();

    CTPath2D insertNewPath(int i5);

    void removePath(int i5);

    void setPathArray(int i5, CTPath2D cTPath2D);

    void setPathArray(CTPath2D[] cTPath2DArr);

    int sizeOfPathArray();
}

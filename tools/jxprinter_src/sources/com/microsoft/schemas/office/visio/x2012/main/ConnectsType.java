package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface ConnectsType extends XmlObject {
    public static final DocumentFactory<ConnectsType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ConnectsType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "connectstype8750type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    ConnectType addNewConnect();

    ConnectType getConnectArray(int i5);

    ConnectType[] getConnectArray();

    List<ConnectType> getConnectList();

    ConnectType insertNewConnect(int i5);

    void removeConnect(int i5);

    void setConnectArray(int i5, ConnectType connectType);

    void setConnectArray(ConnectType[] connectTypeArr);

    int sizeOfConnectArray();
}

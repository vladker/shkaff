package org.apache.poi.poifs.crypt.dsig;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DSigRelation extends POIXMLRelation {
    private static final Map<String, DSigRelation> _table = new HashMap();
    public static final DSigRelation ORIGIN_SIGS = new DSigRelation(ContentTypes.DIGITAL_SIGNATURE_ORIGIN_PART, PackageRelationshipTypes.DIGITAL_SIGNATURE_ORIGIN, "/_xmlsignatures/origin.sigs");
    public static final DSigRelation SIG = new DSigRelation(ContentTypes.DIGITAL_SIGNATURE_XML_SIGNATURE_PART, PackageRelationshipTypes.DIGITAL_SIGNATURE, "/_xmlsignatures/sig#.xml");

    private DSigRelation(String str, String str2, String str3) {
        super(str, str2, str3);
        _table.put(str2, this);
    }

    public static DSigRelation getInstance(String str) {
        return _table.get(str);
    }
}

package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFMasters extends XDGFXMLDocumentPart {
    protected Map<Long, XDGFMaster> _masters;
    MastersType _mastersObject;

    public XDGFMasters(PackagePart packagePart) {
        super(packagePart);
        this._masters = new HashMap();
    }

    public XDGFMaster getMasterById(long j6) {
        return this._masters.get(Long.valueOf(j6));
    }

    public Collection<XDGFMaster> getMastersList() {
        return Collections.unmodifiableCollection(this._masters.values());
    }

    @Internal
    public MastersType getXmlObject() {
        return this._mastersObject;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            try {
                InputStream inputStream = getPackagePart().getInputStream();
                try {
                    this._mastersObject = MastersDocument.Factory.parse(inputStream).getMasters();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    HashMap map = new HashMap();
                    for (MasterType masterType : this._mastersObject.getMasterArray()) {
                        map.put(masterType.getRel().getId(), masterType);
                    }
                    for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                        POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                        String id = relationPart.getRelationship().getId();
                        MasterType masterType2 = (MasterType) map.get(id);
                        if (masterType2 == null) {
                            throw new POIXMLException("Master relationship for " + id + " not found");
                        }
                        if (!(documentPart instanceof XDGFMasterContents)) {
                            throw new POIXMLException("Unexpected masters relationship for " + id + ": " + documentPart);
                        }
                        XDGFMasterContents xDGFMasterContents = (XDGFMasterContents) documentPart;
                        xDGFMasterContents.onDocumentRead();
                        XDGFMaster xDGFMaster = new XDGFMaster(masterType2, xDGFMasterContents, this._document);
                        this._masters.put(Long.valueOf(xDGFMaster.getID()), xDGFMaster);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (POIXMLException e) {
                throw XDGFException.wrap(this, e);
            }
        } catch (IOException | XmlException e6) {
            throw new POIXMLException(e6);
        }
    }
}

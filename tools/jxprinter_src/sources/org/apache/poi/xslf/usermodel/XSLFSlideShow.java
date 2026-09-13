package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFSlideShow extends POIXMLDocument {
    private final List<PackagePart> embeddedParts;
    private final PresentationDocument presentationDoc;

    public XSLFSlideShow(OPCPackage oPCPackage) throws IOException {
        super(oPCPackage);
        if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
            rebase(getPackage());
        }
        InputStream inputStream = getCorePart().getInputStream();
        try {
            this.presentationDoc = PresentationDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            if (inputStream != null) {
                inputStream.close();
            }
            this.embeddedParts = new LinkedList();
            for (CTSlideIdListEntry cTSlideIdListEntry : getSlideReferences().getSldIdArray()) {
                PackagePart corePart = getCorePart();
                PackagePart relatedPart = corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
                for (PackageRelationship packageRelationship : relatedPart.getRelationshipsByType(POIXMLDocument.OLE_OBJECT_REL_TYPE)) {
                    if (TargetMode.EXTERNAL != packageRelationship.getTargetMode()) {
                        this.embeddedParts.add(relatedPart.getRelatedPart(packageRelationship));
                    }
                }
                Iterator<PackageRelationship> it = relatedPart.getRelationshipsByType(POIXMLDocument.PACK_OBJECT_REL_TYPE).iterator();
                while (it.hasNext()) {
                    this.embeddedParts.add(relatedPart.getRelatedPart(it.next()));
                }
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
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument
    public List<PackagePart> getAllEmbeddedParts() {
        return this.embeddedParts;
    }

    public PackagePart getNodesPart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.NOTES.getRelation());
            if (relationshipsByType.isEmpty()) {
                return null;
            }
            if (relationshipsByType.size() <= 1) {
                try {
                    return slidePart.getRelatedPart(relationshipsByType.getRelationship(0));
                } catch (InvalidFormatException e) {
                    throw new IllegalStateException(e);
                }
            }
            throw new IllegalStateException("Expecting 0 or 1 notes for a slide, but found " + relationshipsByType.size());
        } catch (InvalidFormatException e6) {
            throw new IllegalStateException(e6);
        }
    }

    @Internal
    public CTNotesSlide getNotes(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        PackagePart nodesPart = getNodesPart(cTSlideIdListEntry);
        if (nodesPart == null) {
            return null;
        }
        InputStream inputStream = nodesPart.getInputStream();
        try {
            CTNotesSlide notes = NotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
            if (inputStream != null) {
                inputStream.close();
            }
            return notes;
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
    }

    @Internal
    public CTPresentation getPresentation() {
        return this.presentationDoc.getPresentation();
    }

    @Internal
    public CTSlide getSlide(CTSlideIdListEntry cTSlideIdListEntry) throws IOException {
        InputStream inputStream = getSlidePart(cTSlideIdListEntry).getInputStream();
        try {
            CTSlide sld = SldDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSld();
            if (inputStream != null) {
                inputStream.close();
            }
            return sld;
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
    }

    @Internal
    public CTCommentList getSlideComments(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.COMMENTS.getRelation());
            if (relationshipsByType.isEmpty()) {
                return null;
            }
            if (relationshipsByType.size() > 1) {
                throw new IllegalStateException("Expecting 0 or 1 comments for a slide, but found " + relationshipsByType.size());
            }
            try {
                InputStream inputStream = slidePart.getRelatedPart(relationshipsByType.getRelationship(0)).getInputStream();
                try {
                    CTCommentList cmLst = CmLstDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmLst();
                    if (inputStream == null) {
                        return cmLst;
                    }
                    inputStream.close();
                    return cmLst;
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
            } catch (InvalidFormatException e) {
                throw new IllegalStateException(e);
            }
        } catch (InvalidFormatException e6) {
            throw new IllegalStateException(e6);
        }
    }

    @Internal
    public CTSlideMaster getSlideMaster(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws IOException {
        InputStream inputStream = getSlideMasterPart(cTSlideMasterIdListEntry).getInputStream();
        try {
            CTSlideMaster sldMaster = SldMasterDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldMaster();
            if (inputStream != null) {
                inputStream.close();
            }
            return sldMaster;
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
    }

    public PackagePart getSlideMasterPart(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws XmlException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideMasterIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlideMasterIdList getSlideMasterReferences() {
        return getPresentation().getSldMasterIdLst();
    }

    public PackagePart getSlidePart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlideIdList getSlideReferences() {
        if (!getPresentation().isSetSldIdLst()) {
            getPresentation().setSldIdLst(CTSlideIdList.Factory.newInstance());
        }
        return getPresentation().getSldIdLst();
    }

    public XSLFSlideShow(String str) {
        this(POIXMLDocument.openPackage(str));
    }
}

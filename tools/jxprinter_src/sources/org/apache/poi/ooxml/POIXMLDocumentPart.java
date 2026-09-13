package org.apache.poi.ooxml;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFRelation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIXMLDocumentPart {
    private static final Logger LOG = LogManager.getLogger((Class<?>) POIXMLDocumentPart.class);
    private String coreDocumentRel;
    private boolean isCommitted;
    private PackagePart packagePart;
    private POIXMLDocumentPart parent;
    private int relationCounter;
    private final Map<String, RelationPart> relations;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RelationPart {
        private final POIXMLDocumentPart documentPart;
        private final PackageRelationship relationship;

        public RelationPart(PackageRelationship packageRelationship, POIXMLDocumentPart pOIXMLDocumentPart) {
            this.relationship = packageRelationship;
            this.documentPart = pOIXMLDocumentPart;
        }

        public <T extends POIXMLDocumentPart> T getDocumentPart() {
            return (T) this.documentPart;
        }

        public PackageRelationship getRelationship() {
            return this.relationship;
        }
    }

    public POIXMLDocumentPart(OPCPackage oPCPackage) {
        this(oPCPackage, PackageRelationshipTypes.CORE_DOCUMENT);
    }

    @Internal
    @Deprecated
    public static void _invokeOnDocumentRead(POIXMLDocumentPart pOIXMLDocumentPart) {
        pOIXMLDocumentPart.onDocumentRead();
    }

    private static PackagePart getPartFromOPCPackage(OPCPackage oPCPackage, String str) {
        try {
            PackageRelationship relationship = oPCPackage.getRelationshipsByType(str).getRelationship(0);
            if (relationship == null) {
                if (oPCPackage.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0) != null) {
                    IOUtils.closeQuietly(oPCPackage);
                    throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
                }
                IOUtils.closeQuietly(oPCPackage);
                throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
            }
            PackagePart part = oPCPackage.getPart(relationship);
            if (part != null) {
                return part;
            }
            IOUtils.closeQuietly(oPCPackage);
            throw new POIXMLException("OOXML file structure broken/invalid - core document '" + relationship.getTargetURI() + "' not found.");
        } catch (POIXMLException e) {
            throw e;
        } catch (RuntimeException e6) {
            IOUtils.closeQuietly(oPCPackage);
            throw new POIXMLException("OOXML file structure broken/invalid", e6);
        }
    }

    public final RelationPart addRelation(String str, POIXMLRelation pOIXMLRelation, POIXMLDocumentPart pOIXMLDocumentPart) {
        PackageRelationship packageRelationshipFindExistingRelation = this.packagePart.findExistingRelation(pOIXMLDocumentPart.getPackagePart());
        if (packageRelationshipFindExistingRelation == null) {
            packageRelationshipFindExistingRelation = this.packagePart.addRelationship(pOIXMLDocumentPart.getPackagePart().getPartName(), TargetMode.INTERNAL, pOIXMLRelation.getRelation(), str);
        }
        addRelation(packageRelationshipFindExistingRelation, pOIXMLDocumentPart);
        return new RelationPart(packageRelationshipFindExistingRelation, pOIXMLDocumentPart);
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, -1, false).getDocumentPart();
    }

    public int decrementRelationCounter() {
        int i5 = this.relationCounter - 1;
        this.relationCounter = i5;
        return i5;
    }

    @Internal
    public final int getNextPartNumber(POIXMLRelation pOIXMLRelation, int i5) {
        OPCPackage oPCPackage = this.packagePart.getPackage();
        try {
            String defaultFileName = pOIXMLRelation.getDefaultFileName();
            if (defaultFileName.equals(pOIXMLRelation.getFileName(9999))) {
                return oPCPackage.containPart(PackagingURIHelper.createPartName(defaultFileName)) ? -1 : 0;
            }
            int size = i5 + oPCPackage.getParts().size();
            for (int i6 = i5 < 0 ? 1 : i5; i6 <= size; i6++) {
                if (!oPCPackage.containPart(PackagingURIHelper.createPartName(pOIXMLRelation.getFileName(i6)))) {
                    return i6;
                }
            }
            return -1;
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public final PackagePart getPackagePart() {
        return this.packagePart;
    }

    public final POIXMLDocumentPart getParent() {
        return this.parent;
    }

    public final POIXMLDocumentPart getRelationById(String str) {
        RelationPart relationPartById = getRelationPartById(str);
        if (relationPartById == null) {
            return null;
        }
        return relationPartById.getDocumentPart();
    }

    public int getRelationCounter() {
        return this.relationCounter;
    }

    public final String getRelationId(POIXMLDocumentPart pOIXMLDocumentPart) {
        for (RelationPart relationPart : this.relations.values()) {
            if (relationPart.getDocumentPart() == pOIXMLDocumentPart) {
                return relationPart.getRelationship().getId();
            }
        }
        return null;
    }

    public final RelationPart getRelationPartById(String str) {
        return this.relations.get(str);
    }

    public final List<RelationPart> getRelationParts() {
        return Collections.unmodifiableList(new ArrayList(this.relations.values()));
    }

    public final List<POIXMLDocumentPart> getRelations() {
        ArrayList arrayList = new ArrayList();
        Iterator<RelationPart> it = this.relations.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDocumentPart());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public PackagePart getTargetPart(PackageRelationship packageRelationship) {
        return getPackagePart().getRelatedPart(packageRelationship);
    }

    public int incrementRelationCounter() {
        int i5 = this.relationCounter + 1;
        this.relationCounter = i5;
        return i5;
    }

    public boolean isCommitted() {
        return this.isCommitted;
    }

    public final void onSave(Set<PackagePart> set) {
        if (this.isCommitted) {
            return;
        }
        prepareForCommit();
        commit();
        set.add(getPackagePart());
        Iterator<RelationPart> it = this.relations.values().iterator();
        while (it.hasNext()) {
            POIXMLDocumentPart documentPart = it.next().getDocumentPart();
            if (!set.contains(documentPart.getPackagePart())) {
                documentPart.onSave(set);
            }
        }
    }

    public void prepareForCommit() {
        PackagePart packagePart = getPackagePart();
        if (packagePart != null) {
            packagePart.clear();
        }
    }

    public void read(POIXMLFactory pOIXMLFactory, Map<PackagePart, POIXMLDocumentPart> map) {
        PackagePart packagePart = getPackagePart();
        if (packagePart.getContentType().equals(XWPFRelation.GLOSSARY_DOCUMENT.getContentType())) {
            LOG.atWarn().log("POI does not currently support template.main+xml (glossary) parts.  Skipping this part for now.");
            return;
        }
        POIXMLDocumentPart pOIXMLDocumentPartPut = map.put(packagePart, this);
        if (pOIXMLDocumentPartPut != null && pOIXMLDocumentPartPut != this) {
            throw new POIXMLException("Unique PackagePart-POIXMLDocumentPart relation broken!");
        }
        if (packagePart.hasRelationships()) {
            PackageRelationshipCollection relationships = this.packagePart.getRelationships();
            ArrayList arrayList = new ArrayList();
            for (PackageRelationship packageRelationship : relationships) {
                if (packageRelationship.getTargetMode() == TargetMode.INTERNAL) {
                    URI targetURI = packageRelationship.getTargetURI();
                    PackagePart part = this.packagePart.getPackage().getPart(targetURI.getRawFragment() != null ? PackagingURIHelper.createPartName(targetURI.getPath()) : PackagingURIHelper.createPartName(targetURI));
                    if (part == null) {
                        LOG.atError().log("Skipped invalid entry {}", packageRelationship.getTargetURI());
                    } else {
                        POIXMLDocumentPart pOIXMLDocumentPartCreateDocumentPart = map.get(part);
                        if (pOIXMLDocumentPartCreateDocumentPart == null) {
                            pOIXMLDocumentPartCreateDocumentPart = pOIXMLFactory.createDocumentPart(this, part);
                            if ((this instanceof XDDFChart) && (pOIXMLDocumentPartCreateDocumentPart instanceof XSSFWorkbook)) {
                                ((XDDFChart) this).setWorkbook((XSSFWorkbook) pOIXMLDocumentPartCreateDocumentPart);
                            }
                            pOIXMLDocumentPartCreateDocumentPart.parent = this;
                            map.put(part, pOIXMLDocumentPartCreateDocumentPart);
                            arrayList.add(pOIXMLDocumentPartCreateDocumentPart);
                        }
                        addRelation(packageRelationship, pOIXMLDocumentPartCreateDocumentPart);
                    }
                }
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ((POIXMLDocumentPart) obj).read(pOIXMLFactory, map);
            }
        }
    }

    public final void rebase(OPCPackage oPCPackage) {
        PackageRelationshipCollection relationshipsByType = this.packagePart.getRelationshipsByType(this.coreDocumentRel);
        if (relationshipsByType.size() == 1) {
            this.packagePart = this.packagePart.getRelatedPart(relationshipsByType.getRelationship(0));
            return;
        }
        throw new IllegalStateException("Tried to rebase using " + this.coreDocumentRel + " but found " + relationshipsByType.size() + " parts of the right type");
    }

    public final void removeRelation(POIXMLDocumentPart pOIXMLDocumentPart) {
        removeRelation(pOIXMLDocumentPart, true);
    }

    public void setCommitted(boolean z6) {
        this.isCommitted = z6;
    }

    public String toString() {
        PackagePart packagePart = this.packagePart;
        return packagePart == null ? "" : packagePart.toString();
    }

    public POIXMLDocumentPart(OPCPackage oPCPackage, String str) {
        this(getPartFromOPCPackage(oPCPackage, str));
        this.coreDocumentRel = str;
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i5) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, i5, false).getDocumentPart();
    }

    public final boolean removeRelation(POIXMLDocumentPart pOIXMLDocumentPart, boolean z6) {
        return removeRelation(getRelationId(pOIXMLDocumentPart), z6);
    }

    public final RelationPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i5, boolean z6) {
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(pOIXMLRelation.getFileName(i5));
            PackagePart packagePartCreatePart = this.packagePart.getPackage().createPart(packagePartNameCreatePartName, pOIXMLRelation.getContentType());
            PackageRelationship packageRelationshipAddRelationship = !z6 ? this.packagePart.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, pOIXMLRelation.getRelation()) : null;
            POIXMLDocumentPart pOIXMLDocumentPartNewDocumentPart = pOIXMLFactory.newDocumentPart(pOIXMLRelation);
            pOIXMLDocumentPartNewDocumentPart.packagePart = packagePartCreatePart;
            pOIXMLDocumentPartNewDocumentPart.parent = this;
            if (!z6) {
                addRelation(packageRelationshipAddRelationship, pOIXMLDocumentPartNewDocumentPart);
            }
            return new RelationPart(packageRelationshipAddRelationship, pOIXMLDocumentPartNewDocumentPart);
        } catch (PartAlreadyExistsException e) {
            throw e;
        } catch (Exception e6) {
            throw new POIXMLException(e6);
        }
    }

    public POIXMLDocumentPart() {
        this.coreDocumentRel = PackageRelationshipTypes.CORE_DOCUMENT;
        this.relations = new LinkedHashMap();
        this.isCommitted = false;
    }

    public final void removeRelation(String str) {
        removeRelation(str, true);
    }

    private boolean removeRelation(String str, boolean z6) {
        RelationPart relationPart = this.relations.get(str);
        if (relationPart == null) {
            return false;
        }
        POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
        documentPart.decrementRelationCounter();
        getPackagePart().removeRelationship(str);
        this.relations.remove(str);
        if (!z6 || documentPart.getRelationCounter() != 0) {
            return true;
        }
        try {
            documentPart.onDocumentRemove();
            getPackagePart().getPackage().removePart(documentPart.getPackagePart());
            return true;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    private void addRelation(PackageRelationship packageRelationship, POIXMLDocumentPart pOIXMLDocumentPart) {
        this.relations.put(packageRelationship.getId(), new RelationPart(packageRelationship, pOIXMLDocumentPart));
        pOIXMLDocumentPart.incrementRelationCounter();
    }

    public POIXMLDocumentPart(PackagePart packagePart) {
        this((POIXMLDocumentPart) null, packagePart);
    }

    public POIXMLDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        this.coreDocumentRel = PackageRelationshipTypes.CORE_DOCUMENT;
        this.relations = new LinkedHashMap();
        this.isCommitted = false;
        this.packagePart = packagePart;
        this.parent = pOIXMLDocumentPart;
    }

    public void commit() {
    }

    public void onDocumentCreate() {
    }

    public void onDocumentRead() {
    }

    public void onDocumentRemove() {
    }
}

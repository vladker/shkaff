package org.apache.poi.poifs.crypt.dsig.facets;

import A3.AbstractC0157z;
import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Manifest;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureProperty;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
import org.apache.poi.ss.util.CellUtil;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OOXMLSignatureFacet implements SignatureFacet {
    private static final String ID_PACKAGE_OBJECT = "idPackageObject";
    private static final Logger LOG = LogManager.getLogger((Class<?>) OOXMLSignatureFacet.class);
    private static final Set<String> signed = (Set) Stream.of((Object[]) new String[]{"activeXControlBinary", "aFChunk", "attachedTemplate", "attachedToolbars", "audio", "calcChain", "chart", "chartColorStyle", "chartLayout", "chartsheet", "chartStyle", "chartUserShapes", "commentAuthors", "comments", "connections", "connectorXml", "control", "ctrlProp", "customData", "customData", "customProperty", "customXml", "diagram", "diagramColors", "diagramColorsHeader", "diagramData", "diagramDrawing", "diagramLayout", "diagramLayoutHeader", "diagramQuickStyle", "diagramQuickStyleHeader", "dialogsheet", "dictionary", "documentParts", "downRev", "drawing", "endnotes", "externalLink", "externalLinkPath", CellUtil.FONT, "fontTable", "footer", "footnotes", "functionPrototypes", "glossaryDocument", "graphicFrameDoc", "groupShapeXml", "handoutMaster", "hdphoto", "header", "hyperlink", "image", "ink", "inkXml", "keyMapCustomizations", "legacyDiagramText", "legacyDocTextInfo", "mailMergeHeaderSource", "mailMergeRecipientData", "mailMergeSource", "media", "notesMaster", "notesSlide", "numbering", "officeDocument", "officeDocument", "oleObject", "package", "pictureXml", "pivotCacheDefinition", "pivotCacheRecords", "pivotTable", "powerPivotData", "presProps", "printerSettings", "queryTable", "recipientData", "settings", "shapeXml", "sharedStrings", "sheetMetadata", "slicer", "slicer", "slicerCache", "slicerCache", "slide", "slideLayout", "slideMaster", "slideUpdateInfo", "slideUpdateUrl", "smartTags", "styles", "stylesWithEffects", "table", "tableSingleCells", "tableStyles", "tags", "theme", "themeOverride", "timeline", "timelineCache", "transform", "ui/altText", "ui/buttonSize", "ui/controlID", "ui/description", "ui/enabled", "ui/extensibility", "ui/extensibility", "ui/helperText", "ui/imageID", "ui/imageMso", "ui/keyTip", "ui/label", "ui/lcid", "ui/loud", "ui/pressed", "ui/progID", "ui/ribbonID", "ui/showImage", "ui/showLabel", "ui/supertip", "ui/target", "ui/text", "ui/title", "ui/tooltip", "ui/userCustomization", "ui/visible", "userXmlData", "vbaProject", "video", "viewProps", "vmlDrawing", "volatileDependencies", "webSettings", "wordVbaData", "worksheet", "wsSortMap", "xlBinaryIndex", "xlExternalLinkPath/xlAlternateStartup", "xlExternalLinkPath/xlLibrary", "xlExternalLinkPath/xlPathMissing", "xlExternalLinkPath/xlStartup", "xlIntlMacrosheet", "xlMacrosheet", "xmlMaps"}).collect(Collectors.toSet());

    public static String getRelationshipReferenceURI(String str) {
        return AbstractC0157z.o(PackagingURIHelper.FORWARD_SLASH_STRING, str, "?ContentType=application/vnd.openxmlformats-package.relationships+xml");
    }

    public static String getResourceReferenceURI(String str, String str2) {
        return androidx.exifinterface.media.a.m(PackagingURIHelper.FORWARD_SLASH_STRING, str, "?ContentType=", str2);
    }

    public static boolean isSignedRelationship(String str) {
        LOG.atDebug().log("relationship type: {}", str);
        String strReplaceFirst = str.replaceFirst(".*/relationships/", "");
        return signed.contains(strReplaceFirst) || strReplaceFirst.endsWith("customXml");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    private static String normalizePartName(URI uri, String str) throws XMLSignatureException {
        String aSCIIString = uri.toASCIIString();
        if (!aSCIIString.startsWith(str)) {
            aSCIIString = androidx.collection.a.n(str, aSCIIString);
        }
        try {
            String strReplace = new URI(aSCIIString).normalize().getPath().replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
            LOG.atDebug().log("part name: {}", strReplace);
            return strReplace;
        } catch (URISyntaxException e) {
            throw new XMLSignatureException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public void addManifestObject(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        XMLSignatureFactory signatureFactory = signatureInfo.getSignatureFactory();
        List<Reference> arrayList = new ArrayList<>();
        addManifestReferences(signatureInfo, arrayList);
        Manifest manifestNewManifest = signatureFactory.newManifest(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(manifestNewManifest);
        addSignatureTime(signatureInfo, document, arrayList2);
        list2.add(signatureFactory.newXMLObject(arrayList2, ID_PACKAGE_OBJECT, (String) null, (String) null));
        list.add(SignatureFacetHelper.newReference(signatureInfo, "#idPackageObject", null, "http://www.w3.org/2000/09/xmldsig#Object"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public void addManifestReferences(SignatureInfo signatureInfo, List<Reference> list) throws XMLSignatureException {
        OPCPackage opcPackage = signatureInfo.getOpcPackage();
        ArrayList<PackagePart> partsByContentType = opcPackage.getPartsByContentType(ContentTypes.RELATIONSHIPS_PART);
        HashSet hashSet = new HashSet();
        int size = partsByContentType.size();
        int i5 = 0;
        while (i5 < size) {
            PackagePart packagePart = partsByContentType.get(i5);
            i5++;
            PackagePart packagePart2 = packagePart;
            String strReplaceFirst = packagePart2.getPartName().getName().replaceFirst("(.*)/_rels/.*", "$1");
            try {
                PackageRelationshipCollection packageRelationshipCollection = new PackageRelationshipCollection(opcPackage);
                packageRelationshipCollection.parseRelationshipsPart(packagePart2);
                RelationshipTransformService.RelationshipTransformParameterSpec relationshipTransformParameterSpec = new RelationshipTransformService.RelationshipTransformParameterSpec();
                for (PackageRelationship packageRelationship : packageRelationshipCollection) {
                    String relationshipType = packageRelationship.getRelationshipType();
                    if (TargetMode.EXTERNAL == packageRelationship.getTargetMode()) {
                        relationshipTransformParameterSpec.addRelationshipReference(packageRelationship.getId());
                    } else if (isSignedRelationship(relationshipType)) {
                        relationshipTransformParameterSpec.addRelationshipReference(packageRelationship.getId());
                        String strNormalizePartName = normalizePartName(packageRelationship.getTargetURI(), strReplaceFirst);
                        if (hashSet.contains(strNormalizePartName)) {
                            continue;
                        } else {
                            hashSet.add(strNormalizePartName);
                            try {
                                String contentType = opcPackage.getPart(PackagingURIHelper.createPartName(strNormalizePartName)).getContentType();
                                if (!relationshipType.endsWith("customXml") || contentType.equals("inkml+xml") || contentType.equals(ContentTypes.XML)) {
                                    list.add(SignatureFacetHelper.newReference(signatureInfo, androidx.collection.a.o(strNormalizePartName, "?ContentType=", contentType), null, null));
                                } else {
                                    LOG.atDebug().log("skipping customXml with content type: {}", contentType);
                                }
                            } catch (InvalidFormatException e) {
                                throw new XMLSignatureException(e);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                if (relationshipTransformParameterSpec.hasSourceIds()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(SignatureFacetHelper.newTransform(signatureInfo, RelationshipTransformService.TRANSFORM_URI, relationshipTransformParameterSpec));
                    arrayList.add(SignatureFacetHelper.newTransform(signatureInfo, "http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
                    list.add(SignatureFacetHelper.newReference(signatureInfo, AbstractC0157z.s(new StringBuilder(), normalizePartName(packagePart2.getPartName().getURI(), strReplaceFirst), "?ContentType=application/vnd.openxmlformats-package.relationships+xml"), arrayList, null));
                }
            } catch (InvalidFormatException e6) {
                throw new XMLSignatureException("Invalid relationship descriptor: " + packagePart2.getPartName().getName(), e6);
            }
        }
        list.sort(Comparator.comparing(new b()));
    }

    public void addSignatureInfo(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        XMLSignatureFactory signatureFactory = signatureInfo.getSignatureFactory();
        ArrayList arrayList = new ArrayList();
        Element element = (Element) document.importNode(createSignatureInfoV1(signatureInfo).getSignatureInfoV1().getDomNode(), true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new DOMStructure(element));
        SignatureProperty signaturePropertyNewSignatureProperty = signatureFactory.newSignatureProperty(arrayList2, "#" + signatureConfig.getPackageSignatureId(), "idOfficeV1Details");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(signaturePropertyNewSignatureProperty);
        arrayList.add(signatureFactory.newSignatureProperties(arrayList3, (String) null));
        list2.add(signatureFactory.newXMLObject(arrayList, "idOfficeObject", (String) null, (String) null));
        list.add(SignatureFacetHelper.newReference(signatureInfo, "#idOfficeObject", null, "http://www.w3.org/2000/09/xmldsig#Object"));
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] signatureImageValid = signatureConfig.getSignatureImageValid();
        if (signatureImageValid != null) {
            list2.add(signatureFactory.newXMLObject(Collections.singletonList(new DOMStructure(document.createTextNode(encoder.encodeToString(signatureImageValid)))), "idValidSigLnImg", (String) null, (String) null));
            list.add(SignatureFacetHelper.newReference(signatureInfo, "#idValidSigLnImg", null, "http://www.w3.org/2000/09/xmldsig#Object"));
        }
        byte[] signatureImageInvalid = signatureConfig.getSignatureImageInvalid();
        if (signatureImageInvalid != null) {
            list2.add(signatureFactory.newXMLObject(Collections.singletonList(new DOMStructure(document.createTextNode(encoder.encodeToString(signatureImageInvalid)))), "idInvalidSigLnImg", (String) null, (String) null));
            list.add(SignatureFacetHelper.newReference(signatureInfo, "#idInvalidSigLnImg", null, "http://www.w3.org/2000/09/xmldsig#Object"));
        }
    }

    public void addSignatureTime(SignatureInfo signatureInfo, Document document, List<XMLStructure> list) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        XMLSignatureFactory signatureFactory = signatureInfo.getSignatureFactory();
        CTSignatureTime cTSignatureTimeAddNewSignatureTime = SignatureTimeDocument.Factory.newInstance().addNewSignatureTime();
        cTSignatureTimeAddNewSignatureTime.setFormat("YYYY-MM-DDThh:mm:ssTZD");
        cTSignatureTimeAddNewSignatureTime.setValue(signatureConfig.formatExecutionTime());
        LOG.atDebug().log("execution time: {}", cTSignatureTimeAddNewSignatureTime.getValue());
        Element element = (Element) document.importNode(cTSignatureTimeAddNewSignatureTime.getDomNode(), true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DOMStructure(element));
        SignatureProperty signaturePropertyNewSignatureProperty = signatureFactory.newSignatureProperty(arrayList, "#" + signatureConfig.getPackageSignatureId(), "idSignatureTime");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(signaturePropertyNewSignatureProperty);
        list.add(signatureFactory.newSignatureProperties(arrayList2, (String) null));
    }

    public SignatureInfoV1Document createSignatureInfoV1(SignatureInfo signatureInfo) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        SignatureInfoV1Document signatureInfoV1DocumentNewInstance = SignatureInfoV1Document.Factory.newInstance();
        CTSignatureInfoV1 cTSignatureInfoV1AddNewSignatureInfoV1 = signatureInfoV1DocumentNewInstance.addNewSignatureInfoV1();
        if (signatureConfig.getDigestAlgo() != HashAlgorithm.sha1) {
            cTSignatureInfoV1AddNewSignatureInfoV1.setManifestHashAlgorithm(signatureConfig.getDigestMethodUri());
        }
        String signatureDescription = signatureConfig.getSignatureDescription();
        if (signatureDescription != null) {
            cTSignatureInfoV1AddNewSignatureInfoV1.setSignatureComments(signatureDescription);
        }
        byte[] signatureImage = signatureConfig.getSignatureImage();
        if (signatureImage == null) {
            cTSignatureInfoV1AddNewSignatureInfoV1.setSignatureType(1);
            return signatureInfoV1DocumentNewInstance;
        }
        cTSignatureInfoV1AddNewSignatureInfoV1.setSetupID(signatureConfig.getSignatureImageSetupId().toString());
        cTSignatureInfoV1AddNewSignatureInfoV1.setSignatureImage(signatureImage);
        cTSignatureInfoV1AddNewSignatureInfoV1.setSignatureType(2);
        return signatureInfoV1DocumentNewInstance;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        LOG.atDebug().log("pre sign");
        addManifestObject(signatureInfo, document, list, list2);
        addSignatureInfo(signatureInfo, document, list, list2);
    }
}

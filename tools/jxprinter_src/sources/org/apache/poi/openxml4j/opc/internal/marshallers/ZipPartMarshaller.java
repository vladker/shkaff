package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ZipPartMarshaller implements PartMarshaller {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ZipPartMarshaller.class);

    public static boolean marshallRelationshipPart(PackageRelationshipCollection packageRelationshipCollection, PackagePartName packagePartName, ZipArchiveOutputStream zipArchiveOutputStream) {
        String string;
        Document documentCreateDocument = DocumentHelper.createDocument();
        Element elementCreateElementNS = documentCreateDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIPS_TAG_NAME);
        documentCreateDocument.appendChild(elementCreateElementNS);
        URI sourcePartUriFromRelationshipPartUri = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(packagePartName.getURI());
        for (PackageRelationship packageRelationship : packageRelationshipCollection) {
            Element elementCreateElementNS2 = documentCreateDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIP_TAG_NAME);
            elementCreateElementNS.appendChild(elementCreateElementNS2);
            elementCreateElementNS2.setAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, packageRelationship.getId());
            elementCreateElementNS2.setAttribute(PackageRelationship.TYPE_ATTRIBUTE_NAME, packageRelationship.getRelationshipType());
            URI targetURI = packageRelationship.getTargetURI();
            if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                string = targetURI.toString();
                elementCreateElementNS2.setAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME, "External");
            } else {
                string = PackagingURIHelper.relativizeURI(sourcePartUriFromRelationshipPartUri, packageRelationship.getTargetURI(), true).toString();
            }
            elementCreateElementNS2.setAttribute(PackageRelationship.TARGET_ATTRIBUTE_NAME, string);
        }
        documentCreateDocument.normalize();
        try {
            zipArchiveOutputStream.putArchiveEntry(new ZipArchiveEntry(ZipHelper.getZipURIFromOPCName(packagePartName.getURI().toASCIIString()).getPath()));
            try {
                return StreamHelper.saveXmlInStream(documentCreateDocument, zipArchiveOutputStream);
            } finally {
                zipArchiveOutputStream.closeArchiveEntry();
            }
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("Cannot create zip entry {}", packagePartName);
            return false;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        if (!(outputStream instanceof ZipArchiveOutputStream)) {
            LOG.atError().log("Unexpected class {}", outputStream.getClass().getName());
            throw new OpenXML4JException("ZipOutputStream expected !");
        }
        if (packagePart.getSize() == 0 && packagePart.getPartName().getName().equals(XSSFRelation.SHARED_STRINGS.getDefaultFileName())) {
            return true;
        }
        ZipArchiveOutputStream zipArchiveOutputStream = (ZipArchiveOutputStream) outputStream;
        try {
            zipArchiveOutputStream.putArchiveEntry(new ZipArchiveEntry(ZipHelper.getZipItemNameFromOPCName(packagePart.getPartName().getURI().getPath())));
            try {
                InputStream inputStream = packagePart.getInputStream();
                try {
                    IOUtils.copy(inputStream, zipArchiveOutputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zipArchiveOutputStream.closeArchiveEntry();
                    if (packagePart.hasRelationships()) {
                        marshallRelationshipPart(packagePart.getRelationships(), PackagingURIHelper.getRelationshipPartName(packagePart.getPartName()), zipArchiveOutputStream);
                    }
                    return true;
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
            } catch (Throwable th4) {
                zipArchiveOutputStream.closeArchiveEntry();
                throw th4;
            }
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("Cannot write: {}: in ZIP", packagePart.getPartName());
            return false;
        }
    }
}

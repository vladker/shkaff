package org.apache.poi.poifs.crypt.dsig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.crypto.Data;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.URIReference;
import javax.xml.crypto.URIReferenceException;
import javax.xml.crypto.XMLCryptoContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OOXMLURIDereferencer implements URIDereferencer {
    private static final Logger LOG = LogManager.getLogger((Class<?>) OOXMLURIDereferencer.class);
    private URIDereferencer baseUriDereferencer;
    private SignatureInfo signatureInfo;

    private PackagePart findPart(URI uri) {
        Logger logger = LOG;
        logger.atDebug().log("dereference: {}", uri);
        String path = uri.getPath();
        if (path == null || path.isEmpty()) {
            logger.atDebug().log("illegal part name (expected): {}", uri);
            return null;
        }
        try {
            return this.signatureInfo.getOpcPackage().getPart(PackagingURIHelper.createPartName(path));
        } catch (InvalidFormatException unused) {
            LOG.atWarn().log("illegal part name (not expected) in {}", uri);
            return null;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.URIReferenceException */
    public Data dereference(URIReference uRIReference, XMLCryptoContext xMLCryptoContext) throws URIReferenceException {
        InputStream inputStream;
        IOException e;
        if (uRIReference == null) {
            throw new NullPointerException("URIReference cannot be null - call setSignatureInfo(...) before");
        }
        if (xMLCryptoContext == null) {
            throw new NullPointerException("XMLCryptoContext cannot be null");
        }
        try {
            URI uri = new URI(uRIReference.getURI());
            PackagePart packagePartFindPart = findPart(uri);
            if (packagePartFindPart == null) {
                LOG.atDebug().log("cannot resolve {}, delegating to base DOM URI dereferencer", uri);
                return this.baseUriDereferencer.dereference(uRIReference, xMLCryptoContext);
            }
            try {
                inputStream = packagePartFindPart.getInputStream();
                try {
                    if (packagePartFindPart.getPartName().toString().endsWith(PackagingURIHelper.RELATIONSHIP_PART_EXTENSION_NAME)) {
                        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
                        while (true) {
                            try {
                                int i5 = inputStream.read();
                                if (i5 == -1) {
                                    break;
                                }
                                if (i5 != 10 && i5 != 13) {
                                    unsynchronizedByteArrayOutputStream.write(i5);
                                }
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        unsynchronizedByteArrayOutputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                            e = e;
                            IOUtils.closeQuietly(inputStream);
                            throw new URIReferenceException("I/O error: " + e.getMessage(), e);
                        }
                        inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
                        unsynchronizedByteArrayOutputStream.close();
                    }
                    return new OctetStreamData(inputStream, uri.toString(), (String) null);
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                inputStream = null;
                e = e7;
            }
        } catch (URISyntaxException e8) {
            throw new URIReferenceException("could not URL decode the uri: " + uRIReference.getURI(), e8);
        }
    }

    public void setSignatureInfo(SignatureInfo signatureInfo) {
        this.signatureInfo = signatureInfo;
        this.baseUriDereferencer = signatureInfo.getSignatureFactory().getURIDereferencer();
    }
}

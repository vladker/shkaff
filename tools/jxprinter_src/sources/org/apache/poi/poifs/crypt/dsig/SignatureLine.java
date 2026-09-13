package org.apache.poi.poifs.crypt.dsig;

import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.STExt;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.sl.draw.DrawPictureShape;
import org.apache.poi.sl.draw.ImageRenderer;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.opencv.videoio.Videoio;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SignatureLine {
    private static final String MS_OFFICE_URN = "urn:schemas-microsoft-com:office:office";
    protected static final QName QNAME_SIGNATURE_LINE = new QName(MS_OFFICE_URN, "signatureline");
    private Boolean allowComments;
    private String caption;
    private String contentType;
    private byte[] plainSignature;
    private ClassID setupId;
    private CTShape signatureShape;
    private String suggestedSigner;
    private String suggestedSigner2;
    private String suggestedSignerEmail;
    private String signingInstructions = "Before signing the document, verify that the content you are signing is correct.";
    private String invalidStamp = "invalid";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface AddPictureData {
        String addPictureData(byte[] bArr, PictureType pictureType);
    }

    private void determineContentType() {
        PictureType pictureTypeValueOf = PictureType.valueOf(FileMagic.valueOf(this.plainSignature));
        if (pictureTypeValueOf == PictureType.UNKNOWN) {
            throw new IllegalArgumentException("unknown image type");
        }
        this.contentType = pictureTypeValueOf.contentType;
    }

    public void add(XmlObject xmlObject, AddPictureData addPictureData) {
        try {
            byte[] bArrGenerateImage = generateImage(false, false);
            CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
            cTGroupNewInstance.addNewShape();
            XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
            try {
                xmlCursorNewCursor.toEndToken();
                XmlCursor xmlCursorNewCursor2 = cTGroupNewInstance.newCursor();
                try {
                    xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
                    xmlCursorNewCursor2.close();
                    xmlCursorNewCursor.toPrevSibling();
                    this.signatureShape = (CTShape) xmlCursorNewCursor.getObject();
                    xmlCursorNewCursor.close();
                    this.signatureShape.setAlt("Microsoft Office Signature Line...");
                    this.signatureShape.setStyle("width:191.95pt;height:96.05pt");
                    this.signatureShape.setType("rect");
                    String strAddPictureData = addPictureData.addPictureData(bArrGenerateImage, PictureType.PNG);
                    CTImageData cTImageDataAddNewImagedata = this.signatureShape.addNewImagedata();
                    setRelationId(cTImageDataAddNewImagedata, strAddPictureData);
                    cTImageDataAddNewImagedata.setTitle("");
                    CTSignatureLine cTSignatureLineAddNewSignatureline = this.signatureShape.addNewSignatureline();
                    String str = this.suggestedSigner;
                    if (str != null) {
                        cTSignatureLineAddNewSignatureline.setSuggestedsigner(str);
                    }
                    String str2 = this.suggestedSigner2;
                    if (str2 != null) {
                        cTSignatureLineAddNewSignatureline.setSuggestedsigner2(str2);
                    }
                    String str3 = this.suggestedSignerEmail;
                    if (str3 != null) {
                        cTSignatureLineAddNewSignatureline.setSuggestedsigneremail(str3);
                    }
                    if (this.setupId == null) {
                        this.setupId = new ClassID(VectorFormat.DEFAULT_PREFIX + UUID.randomUUID() + VectorFormat.DEFAULT_SUFFIX);
                    }
                    cTSignatureLineAddNewSignatureline.setId(this.setupId.toString());
                    STTrueFalse.Enum r6 = STTrueFalse.f7724T;
                    cTSignatureLineAddNewSignatureline.setAllowcomments(r6);
                    cTSignatureLineAddNewSignatureline.setIssignatureline(r6);
                    cTSignatureLineAddNewSignatureline.setProvid("{00000000-0000-0000-0000-000000000000}");
                    cTSignatureLineAddNewSignatureline.setExt(STExt.EDIT);
                    cTSignatureLineAddNewSignatureline.setSigninginstructionsset(r6);
                    XmlCursor xmlCursorNewCursor3 = cTSignatureLineAddNewSignatureline.newCursor();
                    try {
                        xmlCursorNewCursor3.setAttributeText(new QName(MS_OFFICE_URN, "signinginstructions"), this.signingInstructions);
                        xmlCursorNewCursor3.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (xmlCursorNewCursor3 != null) {
                                try {
                                    xmlCursorNewCursor3.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (xmlCursorNewCursor2 != null) {
                            try {
                                xmlCursorNewCursor2.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (IOException e) {
            e = e;
            throw new POIXMLException("Can't generate signature line image", e);
        } catch (InvalidFormatException e6) {
            e = e6;
            throw new POIXMLException("Can't generate signature line image", e);
        }
    }

    public byte[] generateImage(boolean z6, boolean z7) {
        String str;
        String str2;
        BufferedImage bufferedImage = new BufferedImage(400, 150, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        String str3 = "X\n" + (new String(new char[Videoio.CAP_QT]).replace(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, " ") + "\n") + (getCaption() == null ? getDefaultCaption() : getCaption()).replaceAll("(?m)^", "    ");
        AttributedString attributedString = new AttributedString(str3);
        attributedString.addAttribute(TextAttribute.FAMILY, "SansSerif");
        attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 2, str3.indexOf(10, 2));
        TextAttribute textAttribute = TextAttribute.SIZE;
        attributedString.addAttribute(textAttribute, 15, 0, 2);
        attributedString.addAttribute(textAttribute, 12, 2, str3.length());
        graphics2DCreateGraphics.setColor(Color.BLACK);
        AttributedCharacterIterator iterator = attributedString.getIterator();
        LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(iterator, graphics2DCreateGraphics.getFontRenderContext());
        float descent = 80.0f;
        int i5 = 0;
        while (lineBreakMeasurer.getPosition() < iterator.getEndIndex()) {
            int iIndexOf = str3.indexOf(10, lineBreakMeasurer.getPosition());
            TextLayout textLayoutNextLayout = lineBreakMeasurer.nextLayout(bufferedImage.getWidth() - 10.0f, iIndexOf == -1 ? str3.length() : iIndexOf + 1, false);
            if (i5 != 1) {
                descent += textLayoutNextLayout.getAscent();
            }
            textLayoutNextLayout.draw(graphics2DCreateGraphics, 5.0f, descent);
            descent += textLayoutNextLayout.getDescent() + textLayoutNextLayout.getLeading();
            i5++;
        }
        if (z6 && this.plainSignature != null && (str2 = this.contentType) != null) {
            ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(graphics2DCreateGraphics, str2);
            imageRenderer.loadImage(this.plainSignature, this.contentType);
            double width = ((double) bufferedImage.getWidth()) - 10.0d;
            Dimension2D dimension = imageRenderer.getDimension();
            double dMin = Math.min(width / dimension.getWidth(), 95.0d / dimension.getHeight());
            double width2 = dimension.getWidth() * dMin;
            double height = dimension.getHeight() * dMin;
            imageRenderer.drawImage(graphics2DCreateGraphics, new Rectangle2D.Double(((((double) bufferedImage.getWidth()) - width2) / 2.0d) + 10.0d, 100.0d - height, width2, height));
        }
        if (z7 && (str = this.invalidStamp) != null && !str.isEmpty()) {
            graphics2DCreateGraphics.setFont(new Font("Lucida Bright", 2, 60));
            graphics2DCreateGraphics.rotate(Math.toRadians(-15.0d), ((double) bufferedImage.getWidth()) / 2.0d, ((double) bufferedImage.getHeight()) / 2.0d);
            TextLayout textLayout = new TextLayout(this.invalidStamp, graphics2DCreateGraphics.getFont(), graphics2DCreateGraphics.getFontRenderContext());
            Rectangle2D bounds = textLayout.getBounds();
            float width3 = (float) (((((double) bufferedImage.getWidth()) - bounds.getWidth()) / 2.0d) - bounds.getX());
            float height2 = (float) (((((double) bufferedImage.getHeight()) - bounds.getHeight()) / 2.0d) - bounds.getY());
            Shape outline = textLayout.getOutline(AffineTransform.getTranslateInstance(2.0f + width3, 1.0f + height2));
            graphics2DCreateGraphics.setComposite(AlphaComposite.getInstance(3, 0.3f));
            graphics2DCreateGraphics.setPaint(Color.RED);
            graphics2DCreateGraphics.draw(outline);
            graphics2DCreateGraphics.setPaint(new GradientPaint(0.0f, 0.0f, Color.RED, 30.0f, 20.0f, new Color(128, 128, 255), true));
            textLayout.draw(graphics2DCreateGraphics, width3, height2);
        }
        graphics2DCreateGraphics.dispose();
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        ImageIO.write(bufferedImage, "PNG", unsynchronizedByteArrayOutputStream);
        return unsynchronizedByteArrayOutputStream.toByteArray();
    }

    public Boolean getAllowComments() {
        return this.allowComments;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getDefaultCaption() {
        return this.suggestedSigner + "\n" + this.suggestedSigner2 + "\n" + this.suggestedSignerEmail;
    }

    public String getInvalidStamp() {
        return this.invalidStamp;
    }

    public byte[] getPlainSignature() {
        return this.plainSignature;
    }

    public ClassID getSetupId() {
        return this.setupId;
    }

    public CTShape getSignatureShape() {
        return this.signatureShape;
    }

    public String getSigningInstructions() {
        return this.signingInstructions;
    }

    public String getSuggestedSigner() {
        return this.suggestedSigner;
    }

    public String getSuggestedSigner2() {
        return this.suggestedSigner2;
    }

    public String getSuggestedSignerEmail() {
        return this.suggestedSignerEmail;
    }

    public void parse() {
        CTShape cTShape = this.signatureShape;
        if (cTShape == null) {
            return;
        }
        CTSignatureLine signaturelineArray = cTShape.getSignaturelineArray(0);
        setSetupId(new ClassID(signaturelineArray.getId()));
        setAllowComments(signaturelineArray.isSetAllowcomments() ? Boolean.valueOf(STTrueFalse.TRUE.equals(signaturelineArray.getAllowcomments())) : null);
        setSuggestedSigner(signaturelineArray.getSuggestedsigner());
        setSuggestedSigner2(signaturelineArray.getSuggestedsigner2());
        setSuggestedSignerEmail(signaturelineArray.getSuggestedsigneremail());
        XmlCursor xmlCursorNewCursor = signaturelineArray.newCursor();
        try {
            setSigningInstructions(xmlCursorNewCursor.getAttributeText(new QName(MS_OFFICE_URN, "signinginstructions")));
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public byte[] plainPng() {
        PictureType pictureTypeValueOf = PictureType.valueOf(FileMagic.valueOf(getPlainSignature()));
        if (pictureTypeValueOf == PictureType.UNKNOWN) {
            throw new IllegalArgumentException("Unsupported picture format");
        }
        ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(null, pictureTypeValueOf.contentType);
        if (imageRenderer == null) {
            throw new UnsupportedOperationException(pictureTypeValueOf + " can't be rendered - did you provide poi-scratchpad and its dependencies (batik et al.)");
        }
        imageRenderer.loadImage(getPlainSignature(), pictureTypeValueOf.contentType);
        Dimension2D dimension = imageRenderer.getDimension();
        double d = 300;
        int height = (int) ((dimension.getHeight() * d) / dimension.getWidth());
        BufferedImage bufferedImage = new BufferedImage(300, height, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        imageRenderer.drawImage(graphics2DCreateGraphics, new Rectangle2D.Double(0.0d, 0.0d, d, height));
        graphics2DCreateGraphics.dispose();
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        ImageIO.write(bufferedImage, "PNG", unsynchronizedByteArrayOutputStream);
        return unsynchronizedByteArrayOutputStream.toByteArray();
    }

    public void setAllowComments(Boolean bool) {
        this.allowComments = bool;
    }

    public void setCaption(String str) {
        this.caption = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setInvalidStamp(String str) {
        this.invalidStamp = str;
    }

    public void setPlainSignature(byte[] bArr) {
        this.plainSignature = bArr;
        this.contentType = null;
    }

    public abstract void setRelationId(CTImageData cTImageData, String str);

    public void setSetupId(ClassID classID) {
        this.setupId = classID;
    }

    public void setSignatureShape(CTShape cTShape) {
        this.signatureShape = cTShape;
    }

    public void setSigningInstructions(String str) {
        this.signingInstructions = str;
    }

    public void setSuggestedSigner(String str) {
        this.suggestedSigner = str;
    }

    public void setSuggestedSigner2(String str) {
        this.suggestedSigner2 = str;
    }

    public void setSuggestedSignerEmail(String str) {
        this.suggestedSignerEmail = str;
    }

    public void updateSignatureConfig(SignatureConfig signatureConfig) {
        if (this.plainSignature == null) {
            throw new IllegalStateException("Plain signature not initialized");
        }
        if (this.contentType == null) {
            determineContentType();
        }
        byte[] bArrGenerateImage = generateImage(true, false);
        byte[] bArrGenerateImage2 = generateImage(true, true);
        signatureConfig.setSignatureImageSetupId(getSetupId());
        signatureConfig.setSignatureImage(plainPng());
        signatureConfig.setSignatureImageValid(bArrGenerateImage);
        signatureConfig.setSignatureImageInvalid(bArrGenerateImage2);
    }

    public void setSignatureShape(CTSignatureLine cTSignatureLine) {
        XmlCursor xmlCursorNewCursor = cTSignatureLine.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            this.signatureShape = (CTShape) xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void update() {
    }
}

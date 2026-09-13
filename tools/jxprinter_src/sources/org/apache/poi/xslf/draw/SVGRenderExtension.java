package org.apache.poi.xslf.draw;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.zip.CRC32;
import javax.imageio.ImageIO;
import org.apache.batik.svggen.DefaultExtensionHandler;
import org.apache.batik.svggen.SVGColor;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGPaintDescriptor;
import org.apache.batik.svggen.SVGTexturePaint;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.sl.draw.BitmapImageRenderer;
import org.apache.poi.sl.draw.DrawTexturePaint;
import org.apache.poi.sl.draw.Drawable;
import org.apache.poi.sl.draw.ImageRenderer;
import org.apache.poi.sl.draw.PathGradientPaint;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.Internal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class SVGRenderExtension extends DefaultExtensionHandler {
    private static final int LINE_LENGTH = 65;
    private static final String XLINK_NS = "http://www.w3.org/1999/xlink";
    private final Map<Long, String> imageMap = new HashMap();
    private WeakReference<SVGGraphics2D> svgGraphics2D = null;

    /* JADX INFO: renamed from: org.apache.poi.xslf.draw.SVGRenderExtension$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$awt$MultipleGradientPaint$CycleMethod;

        static {
            int[] iArr = new int[MultipleGradientPaint.CycleMethod.values().length];
            $SwitchMap$java$awt$MultipleGradientPaint$CycleMethod = iArr;
            try {
                iArr[MultipleGradientPaint.CycleMethod.REFLECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$awt$MultipleGradientPaint$CycleMethod[MultipleGradientPaint.CycleMethod.REPEAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$awt$MultipleGradientPaint$CycleMethod[MultipleGradientPaint.CycleMethod.NO_CYCLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void addMgpAttributes(Element element, SVGGeneratorContext sVGGeneratorContext, MultipleGradientPaint multipleGradientPaint) {
        element.setAttribute("gradientUnits", "userSpaceOnUse");
        int i5 = AnonymousClass1.$SwitchMap$java$awt$MultipleGradientPaint$CycleMethod[multipleGradientPaint.getCycleMethod().ordinal()];
        element.setAttribute("spreadMethod", i5 != 1 ? i5 != 2 ? "pad" : "repeat" : "reflect");
        element.setAttribute("color-interpolation", multipleGradientPaint.getColorSpace() == MultipleGradientPaint.ColorSpaceType.LINEAR_RGB ? "linearRGB" : "sRGB");
        AffineTransform transform = multipleGradientPaint.getTransform();
        if (!transform.isIdentity()) {
            element.setAttribute("gradientTransform", "matrix(" + transform.getScaleX() + " " + transform.getShearY() + " " + transform.getShearX() + " " + transform.getScaleY() + " " + transform.getTranslateX() + " " + transform.getTranslateY() + ")");
        }
        Color[] colors = multipleGradientPaint.getColors();
        float[] fractions = multipleGradientPaint.getFractions();
        for (int i6 = 0; i6 < colors.length; i6++) {
            Element elementCreateElementNS = sVGGeneratorContext.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "stop");
            SVGPaintDescriptor svg = SVGColor.toSVG(colors[i6], sVGGeneratorContext);
            elementCreateElementNS.setAttribute(TypedValues.CycleType.S_WAVE_OFFSET, ((int) (fractions[i6] * 100.0f)) + "%");
            elementCreateElementNS.setAttribute("stop-color", svg.getPaintValue());
            if (colors[i6].getAlpha() != 255) {
                elementCreateElementNS.setAttribute("stop-opacity", svg.getOpacityValue());
            }
            element.appendChild(elementCreateElementNS);
        }
    }

    private SVGPaintDescriptor getDtpDescriptor(DrawTexturePaint drawTexturePaint, SVGGeneratorContext sVGGeneratorContext) {
        String imageID = getImageID(drawTexturePaint, sVGGeneratorContext);
        Document dOMFactory = sVGGeneratorContext.getDOMFactory();
        Element elementCreateElementNS = dOMFactory.createElementNS("http://www.w3.org/2000/svg", "pattern");
        String strGenerateID = sVGGeneratorContext.getIDGenerator().generateID("pattern");
        PaintStyle.TexturePaint fill = drawTexturePaint.getFill();
        Insets2D stretch = fill.getStretch();
        if (stretch == null) {
            stretch = new Insets2D(0.0d, 0.0d, 0.0d, 0.0d);
        }
        Rectangle2D anchorRect = drawTexturePaint.getAnchorRect();
        String strDoubleString = sVGGeneratorContext.doubleString(((-stretch.left) / 100000.0d) * anchorRect.getWidth());
        String strDoubleString2 = sVGGeneratorContext.doubleString(((-stretch.top) / 100000.0d) * anchorRect.getHeight());
        String strDoubleString3 = sVGGeneratorContext.doubleString((((stretch.left + 100000.0d) + stretch.right) / 100000.0d) * anchorRect.getWidth());
        String strDoubleString4 = sVGGeneratorContext.doubleString((((stretch.top + 100000.0d) + stretch.bottom) / 100000.0d) * anchorRect.getHeight());
        Dimension2D scale = fill.getScale();
        if (scale == null) {
            scale = new Dimension2DDouble(1.0d, 1.0d);
        }
        Point2D.Double offset = fill.getOffset();
        if (offset == null) {
            offset = new Point2D.Double(0.0d, 0.0d);
        }
        if (fill.getFlipMode() == null) {
            PaintStyle.FlipMode flipMode = PaintStyle.FlipMode.NONE;
        }
        Double dValueOf = Double.valueOf(offset.getX());
        Double dValueOf2 = Double.valueOf(offset.getY());
        String strS = AbstractC0157z.s(new StringBuilder(), sVGGeneratorContext.doubleString(scale.getWidth() * 100.0d), "%");
        String strS2 = AbstractC0157z.s(new StringBuilder(), sVGGeneratorContext.doubleString(scale.getHeight() * 100.0d), "%");
        StringBuilder sb = new StringBuilder();
        sb.append(strDoubleString);
        sb.append(" ");
        sb.append(strDoubleString2);
        sb.append(" ");
        sb.append(strDoubleString3);
        setAttribute(sVGGeneratorContext, elementCreateElementNS, null, "patternUnits", "objectBoundingBox", null, "id", strGenerateID, null, "x", dValueOf, null, "y", dValueOf2, null, "width", strS, null, "height", strS2, null, "preserveAspectRatio", "none", null, "viewBox", AbstractC0157z.s(sb, " ", strDoubleString4));
        Shape shape = fill.getShape();
        if (!fill.isRotatedWithShape() && (shape instanceof SimpleShape)) {
            double rotation = ((SimpleShape) shape).getRotation();
            if (rotation != 0.0d) {
                setAttribute(sVGGeneratorContext, elementCreateElementNS, null, "patternTransform", AbstractC0157z.s(new StringBuilder("rotate("), sVGGeneratorContext.doubleString(-rotation), ")"));
            }
        }
        Element elementCreateElementNS2 = dOMFactory.createElementNS("http://www.w3.org/2000/svg", "use");
        elementCreateElementNS2.setAttributeNS(null, "href", "#" + imageID);
        elementCreateElementNS.appendChild(elementCreateElementNS2);
        return new SVGPaintDescriptor("url(#" + strGenerateID + ")", "1", elementCreateElementNS);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0035  */
    private String getImageID(DrawTexturePaint drawTexturePaint, SVGGeneratorContext sVGGeneratorContext) {
        byte[] byteArray;
        String cachedContentType;
        ImageRenderer imageRenderer = drawTexturePaint.getImageRenderer();
        if (imageRenderer instanceof BitmapImageRenderer) {
            BitmapImageRenderer bitmapImageRenderer = (BitmapImageRenderer) imageRenderer;
            cachedContentType = bitmapImageRenderer.getCachedContentType();
            if (PictureData.PictureType.PNG.contentType.equals(cachedContentType) || PictureData.PictureType.JPEG.contentType.equals(cachedContentType) || PictureData.PictureType.GIF.contentType.equals(cachedContentType)) {
                byteArray = bitmapImageRenderer.getCachedImage();
            } else {
                byteArray = null;
                cachedContentType = null;
            }
        } else {
            byteArray = null;
            cachedContentType = null;
        }
        if (byteArray == null) {
            BufferedImage image = imageRenderer.getImage();
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                ImageIO.write(image, "PNG", unsynchronizedByteArrayOutputStream);
                byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                cachedContentType = PictureData.PictureType.PNG.contentType;
            } catch (IOException unused) {
                return null;
            }
        }
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray);
        Long lValueOf = Long.valueOf(crc32.getValue());
        String str = this.imageMap.get(lValueOf);
        if (str != null) {
            return str;
        }
        Document dOMFactory = sVGGeneratorContext.getDOMFactory();
        Rectangle2D anchorRect = drawTexturePaint.getAnchorRect();
        String strGenerateID = sVGGeneratorContext.getIDGenerator().generateID("image");
        this.imageMap.put(lValueOf, strGenerateID);
        int iC = a.c(byteArray.length, 4, 3, 3) & (-4);
        StringBuilder sb = new StringBuilder((iC / 65) + 30 + iC);
        sb.append("data:");
        sb.append(cachedContentType);
        sb.append(";base64,\n");
        sb.append(Base64.getMimeEncoder(65, "\n".getBytes(StandardCharsets.US_ASCII)).encodeToString(byteArray));
        Element elementCreateElementNS = dOMFactory.createElementNS("http://www.w3.org/2000/svg", "image");
        setAttribute(sVGGeneratorContext, elementCreateElementNS, null, "id", strGenerateID, null, "preserveAspectRatio", "none", null, "x", Double.valueOf(anchorRect.getX()), null, "y", Double.valueOf(anchorRect.getY()), null, "width", Double.valueOf(anchorRect.getWidth()), null, "height", Double.valueOf(anchorRect.getHeight()), XLINK_NS, "xlink:href", sb.toString());
        getSvgGraphics2D().getDOMTreeManager().addOtherDef(elementCreateElementNS);
        return strGenerateID;
    }

    private SVGPaintDescriptor getLgpDescriptor(LinearGradientPaint linearGradientPaint, SVGGeneratorContext sVGGeneratorContext) {
        Element elementCreateElementNS = sVGGeneratorContext.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "linearGradient");
        String strGenerateID = sVGGeneratorContext.getIDGenerator().generateID("gradient");
        elementCreateElementNS.setAttribute("id", strGenerateID);
        setPoint(elementCreateElementNS, linearGradientPaint.getStartPoint(), "x1", "y1");
        setPoint(elementCreateElementNS, linearGradientPaint.getEndPoint(), "x2", "y2");
        addMgpAttributes(elementCreateElementNS, sVGGeneratorContext, linearGradientPaint);
        return new SVGPaintDescriptor(AbstractC0157z.o("url(#", strGenerateID, ")"), "1", elementCreateElementNS);
    }

    private SVGPaintDescriptor getPathDescriptor(PathGradientPaint pathGradientPaint, SVGGeneratorContext sVGGeneratorContext) {
        RenderingHints renderingHints = sVGGeneratorContext.getGraphicContextDefaults().getRenderingHints();
        java.awt.Shape shape = (java.awt.Shape) renderingHints.get(Drawable.GRADIENT_SHAPE);
        if (shape == null) {
            return null;
        }
        PathGradientPaint.PathGradientContext pathGradientContextCreateContext = pathGradientPaint.createContext(ColorModel.getRGBdefault(), shape.getBounds(), shape.getBounds2D(), new AffineTransform(), renderingHints);
        return new SVGTexturePaint(sVGGeneratorContext).toSVG(new TexturePaint(new BufferedImage(pathGradientContextCreateContext.getColorModel(), pathGradientContextCreateContext.createRaster(), false, (Hashtable) null), shape.getBounds2D()));
    }

    private SVGPaintDescriptor getRgpDescriptor(RadialGradientPaint radialGradientPaint, SVGGeneratorContext sVGGeneratorContext) {
        Element elementCreateElementNS = sVGGeneratorContext.getDOMFactory().createElementNS("http://www.w3.org/2000/svg", "radialGradient");
        String strGenerateID = sVGGeneratorContext.getIDGenerator().generateID("gradient");
        elementCreateElementNS.setAttribute("id", strGenerateID);
        setPoint(elementCreateElementNS, radialGradientPaint.getCenterPoint(), "cx", "cy");
        setPoint(elementCreateElementNS, radialGradientPaint.getFocusPoint(), "fx", "fy");
        elementCreateElementNS.setAttribute("r", String.valueOf(radialGradientPaint.getRadius()));
        addMgpAttributes(elementCreateElementNS, sVGGeneratorContext, radialGradientPaint);
        return new SVGPaintDescriptor(AbstractC0157z.o("url(#", strGenerateID, ")"), "1", elementCreateElementNS);
    }

    private static void setAttribute(SVGGeneratorContext sVGGeneratorContext, Element element, Object... objArr) {
        String string;
        for (int i5 = 0; i5 < objArr.length; i5 += 3) {
            String str = (String) objArr[i5];
            String str2 = (String) objArr[i5 + 1];
            Object obj = objArr[i5 + 2];
            if (obj instanceof String) {
                string = (String) obj;
            } else if (obj instanceof Number) {
                string = sVGGeneratorContext.doubleString(((Number) obj).doubleValue());
            } else {
                string = obj == 0 ? "" : obj.toString();
            }
            element.setAttributeNS(str, str2, string);
        }
    }

    private static void setPoint(Element element, Point2D point2D, String str, String str2) {
        element.setAttribute(str, Double.toString(point2D.getX()));
        element.setAttribute(str2, Double.toString(point2D.getY()));
    }

    public SVGGraphics2D getSvgGraphics2D() {
        WeakReference<SVGGraphics2D> weakReference = this.svgGraphics2D;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public SVGPaintDescriptor handlePaint(Paint paint, SVGGeneratorContext sVGGeneratorContext) {
        if (paint instanceof LinearGradientPaint) {
            return getLgpDescriptor((LinearGradientPaint) paint, sVGGeneratorContext);
        }
        if (paint instanceof RadialGradientPaint) {
            return getRgpDescriptor((RadialGradientPaint) paint, sVGGeneratorContext);
        }
        if (paint instanceof PathGradientPaint) {
            return getPathDescriptor((PathGradientPaint) paint, sVGGeneratorContext);
        }
        return paint instanceof DrawTexturePaint ? getDtpDescriptor((DrawTexturePaint) paint, sVGGeneratorContext) : super.handlePaint(paint, sVGGeneratorContext);
    }

    public void setSvgGraphics2D(SVGGraphics2D sVGGraphics2D) {
        this.svgGraphics2D = new WeakReference<>(sVGGraphics2D);
    }
}

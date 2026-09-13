package org.apache.poi.xslf.util;

import A3.AbstractC0157z;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.PrintStream;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DummyGraphics2d extends Graphics2D {
    private BufferedImage bufimg;
    private final Graphics2D g2D;
    private final PrintStream log;
    private static final String[] COMPOSITE_RULES = {"CLEAR", "SRC", "SRC_OVER", "DST_OVER", "SRC_IN", "DST_IN", "SRC_OUT", "DST_OUT", "DST", "SRC_ATOP", "DST_ATOP", "XOR"};
    private static final Object[] HINTS = {RenderingHints.KEY_ANTIALIASING, "RenderingHints.KEY_ANTIALIASING", RenderingHints.VALUE_ANTIALIAS_ON, "RenderingHints.VALUE_ANTIALIAS_ON", RenderingHints.VALUE_ANTIALIAS_OFF, "RenderingHints.VALUE_ANTIALIAS_OFF", RenderingHints.VALUE_ANTIALIAS_DEFAULT, "RenderingHints.VALUE_ANTIALIAS_DEFAULT", RenderingHints.KEY_RENDERING, "RenderingHints.KEY_RENDERING", RenderingHints.VALUE_RENDER_SPEED, "RenderingHints.VALUE_RENDER_SPEED", RenderingHints.VALUE_RENDER_QUALITY, "RenderingHints.VALUE_RENDER_QUALITY", RenderingHints.VALUE_RENDER_DEFAULT, "RenderingHints.VALUE_RENDER_DEFAULT", RenderingHints.KEY_DITHERING, "RenderingHints.KEY_DITHERING", RenderingHints.VALUE_DITHER_DISABLE, "RenderingHints.VALUE_DITHER_DISABLE", RenderingHints.VALUE_DITHER_ENABLE, "RenderingHints.VALUE_DITHER_ENABLE", RenderingHints.VALUE_DITHER_DEFAULT, "RenderingHints.VALUE_DITHER_DEFAULT", RenderingHints.KEY_TEXT_ANTIALIASING, "RenderingHints.KEY_TEXT_ANTIALIASING", RenderingHints.VALUE_TEXT_ANTIALIAS_ON, "RenderingHints.VALUE_TEXT_ANTIALIAS_ON", RenderingHints.VALUE_TEXT_ANTIALIAS_OFF, "RenderingHints.VALUE_TEXT_ANTIALIAS_OFF", RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT, "RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT", RenderingHints.VALUE_TEXT_ANTIALIAS_GASP, "RenderingHints.VALUE_TEXT_ANTIALIAS_GASP", RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB, "RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB", RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR, "RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR", RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB, "RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB", RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR, "RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR", RenderingHints.KEY_TEXT_LCD_CONTRAST, "RenderingHints.KEY_TEXT_LCD_CONTRAST", RenderingHints.KEY_FRACTIONALMETRICS, "RenderingHints.KEY_FRACTIONALMETRICS", RenderingHints.VALUE_FRACTIONALMETRICS_OFF, "RenderingHints.VALUE_FRACTIONALMETRICS_OFF", RenderingHints.VALUE_FRACTIONALMETRICS_ON, "RenderingHints.VALUE_FRACTIONALMETRICS_ON", RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT, "RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT", RenderingHints.KEY_INTERPOLATION, "RenderingHints.KEY_INTERPOLATION", RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, "RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR", RenderingHints.VALUE_INTERPOLATION_BILINEAR, "RenderingHints.VALUE_INTERPOLATION_BILINEAR", RenderingHints.VALUE_INTERPOLATION_BICUBIC, "RenderingHints.VALUE_INTERPOLATION_BICUBIC", RenderingHints.KEY_ALPHA_INTERPOLATION, "RenderingHints.KEY_ALPHA_INTERPOLATION", RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED, "RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED", RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY, "RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY", RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT, "RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT", RenderingHints.KEY_COLOR_RENDERING, "RenderingHints.KEY_COLOR_RENDERING", RenderingHints.VALUE_COLOR_RENDER_SPEED, "RenderingHints.VALUE_COLOR_RENDER_SPEED", RenderingHints.VALUE_COLOR_RENDER_QUALITY, "RenderingHints.VALUE_COLOR_RENDER_QUALITY", RenderingHints.VALUE_COLOR_RENDER_DEFAULT, "RenderingHints.VALUE_COLOR_RENDER_DEFAULT", RenderingHints.KEY_STROKE_CONTROL, "RenderingHints.KEY_STROKE_CONTROL", RenderingHints.VALUE_STROKE_DEFAULT, "RenderingHints.VALUE_STROKE_DEFAULT", RenderingHints.VALUE_STROKE_NORMALIZE, "RenderingHints.VALUE_STROKE_NORMALIZE", RenderingHints.VALUE_STROKE_PURE, "RenderingHints.VALUE_STROKE_PURE"};
    private static final Object[] ATTRS = {TextAttribute.FAMILY, "TextAttribute.FAMILY", TextAttribute.WEIGHT, "TextAttribute.WEIGHT", TextAttribute.WEIGHT_EXTRA_LIGHT, "TextAttribute.WEIGHT_EXTRA_LIGHT", TextAttribute.WEIGHT_LIGHT, "TextAttribute.WEIGHT_LIGHT", TextAttribute.WEIGHT_DEMILIGHT, "TextAttribute.WEIGHT_DEMILIGHT", TextAttribute.WEIGHT_REGULAR, "TextAttribute.WEIGHT_REGULAR", TextAttribute.WEIGHT_SEMIBOLD, "TextAttribute.WEIGHT_SEMIBOLD", TextAttribute.WEIGHT_MEDIUM, "TextAttribute.WEIGHT_MEDIUM", TextAttribute.WEIGHT_DEMIBOLD, "TextAttribute.WEIGHT_DEMIBOLD", TextAttribute.WEIGHT_BOLD, "TextAttribute.WEIGHT_BOLD", TextAttribute.WEIGHT_HEAVY, "TextAttribute.WEIGHT_HEAVY", TextAttribute.WEIGHT_EXTRABOLD, "TextAttribute.WEIGHT_EXTRABOLD", TextAttribute.WEIGHT_ULTRABOLD, "TextAttribute.WEIGHT_ULTRABOLD", TextAttribute.WIDTH, "TextAttribute.WIDTH", TextAttribute.WIDTH_CONDENSED, "TextAttribute.WIDTH_CONDENSED", TextAttribute.WIDTH_SEMI_CONDENSED, "TextAttribute.WIDTH_SEMI_CONDENSED", TextAttribute.WIDTH_REGULAR, "TextAttribute.WIDTH_REGULAR", TextAttribute.WIDTH_SEMI_EXTENDED, "TextAttribute.WIDTH_SEMI_EXTENDED", TextAttribute.WIDTH_EXTENDED, "TextAttribute.WIDTH_EXTENDED", TextAttribute.POSTURE, "TextAttribute.POSTURE", TextAttribute.POSTURE_REGULAR, "TextAttribute.POSTURE_REGULAR", TextAttribute.POSTURE_OBLIQUE, "TextAttribute.POSTURE_OBLIQUE", TextAttribute.SIZE, "TextAttribute.SIZE", TextAttribute.TRANSFORM, "TextAttribute.TRANSFORM", TextAttribute.SUPERSCRIPT, "TextAttribute.SUPERSCRIPT", TextAttribute.SUPERSCRIPT_SUPER, "TextAttribute.SUPERSCRIPT_SUPER", TextAttribute.SUPERSCRIPT_SUB, "TextAttribute.SUPERSCRIPT_SUB", TextAttribute.FONT, "TextAttribute.FONT", TextAttribute.CHAR_REPLACEMENT, "TextAttribute.CHAR_REPLACEMENT", TextAttribute.FOREGROUND, "TextAttribute.FOREGROUND", TextAttribute.BACKGROUND, "TextAttribute.BACKGROUND", TextAttribute.UNDERLINE, "TextAttribute.UNDERLINE", TextAttribute.UNDERLINE_ON, "TextAttribute.UNDERLINE_ON", TextAttribute.STRIKETHROUGH, "TextAttribute.STRIKETHROUGH", TextAttribute.STRIKETHROUGH_ON, "TextAttribute.STRIKETHROUGH_ON", TextAttribute.RUN_DIRECTION, "TextAttribute.RUN_DIRECTION", TextAttribute.RUN_DIRECTION_LTR, "TextAttribute.RUN_DIRECTION_LTR", TextAttribute.RUN_DIRECTION_RTL, "TextAttribute.RUN_DIRECTION_RTL", TextAttribute.BIDI_EMBEDDING, "TextAttribute.BIDI_EMBEDDING", TextAttribute.JUSTIFICATION, "TextAttribute.JUSTIFICATION", TextAttribute.JUSTIFICATION_FULL, "TextAttribute.JUSTIFICATION_FULL", TextAttribute.JUSTIFICATION_NONE, "TextAttribute.JUSTIFICATION_NONE", TextAttribute.INPUT_METHOD_HIGHLIGHT, "TextAttribute.INPUT_METHOD_HIGHLIGHT", TextAttribute.INPUT_METHOD_UNDERLINE, "TextAttribute.INPUT_METHOD_UNDERLINE", TextAttribute.UNDERLINE_LOW_ONE_PIXEL, "TextAttribute.UNDERLINE_LOW_ONE_PIXEL", TextAttribute.UNDERLINE_LOW_TWO_PIXEL, "TextAttribute.UNDERLINE_LOW_TWO_PIXEL", TextAttribute.UNDERLINE_LOW_DOTTED, "TextAttribute.UNDERLINE_LOW_DOTTED", TextAttribute.UNDERLINE_LOW_GRAY, "TextAttribute.UNDERLINE_LOW_GRAY", TextAttribute.UNDERLINE_LOW_DASHED, "TextAttribute.UNDERLINE_LOW_DASHED", TextAttribute.SWAP_COLORS, "TextAttribute.SWAP_COLORS", TextAttribute.SWAP_COLORS_ON, "TextAttribute.SWAP_COLORS_ON", TextAttribute.NUMERIC_SHAPING, "TextAttribute.NUMERIC_SHAPING", TextAttribute.KERNING, "TextAttribute.KERNING", TextAttribute.KERNING_ON, "TextAttribute.KERNING_ON", TextAttribute.LIGATURES, "TextAttribute.LIGATURES", TextAttribute.LIGATURES_ON, "TextAttribute.LIGATURES_ON", TextAttribute.TRACKING, "TextAttribute.TRACKING", TextAttribute.TRACKING_TIGHT, "TextAttribute.TRACKING_TIGHT", TextAttribute.TRACKING_LOOSE, "TextAttribute.TRACKING_LOOSE"};

    public DummyGraphics2d() {
        this(System.out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$drawString$1(Map map, AttributedCharacterIterator attributedCharacterIterator, AttributedCharacterIterator.Attribute attribute, Object obj) {
        ((Map) map.computeIfAbsent(attribute, new h(1))).put(Integer.valueOf(attributedCharacterIterator.getIndex()), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$null$0(AttributedCharacterIterator.Attribute attribute) {
        return new LinkedHashMap();
    }

    private static String mapAttribute(Object obj) {
        if (obj == null) {
            return AbstractC1127c.NULL;
        }
        if (obj instanceof Font) {
            Font font = (Font) obj;
            StringBuilder sb = new StringBuilder("new Font(\"");
            sb.append(font.getFamily(Locale.ROOT));
            sb.append("\",");
            sb.append(new String[]{"Font.PLAIN", "Font.BOLD", "Font.ITALIC", "Font.BOLD | Font.ITALIC"}[font.getStyle()]);
            sb.append(",");
            return AbstractC0157z.l(")", font.getSize(), sb);
        }
        if (obj instanceof Color) {
            return String.format(Locale.ROOT, "new Color(0x%08X)", Integer.valueOf(((Color) obj).getRGB()));
        }
        int i5 = 0;
        while (true) {
            Object[] objArr = ATTRS;
            if (i5 >= objArr.length) {
                return "\"" + obj + "\"";
            }
            if (obj == objArr[i5]) {
                return (String) objArr[i5 + 1];
            }
            i5 += 2;
        }
    }

    private static String mapHint(Object obj) {
        if (obj == null) {
            return AbstractC1127c.NULL;
        }
        if (obj instanceof AffineTransform) {
            return mapTransform((AffineTransform) obj);
        }
        int i5 = 0;
        while (true) {
            Object[] objArr = HINTS;
            if (i5 >= objArr.length) {
                return "\"" + obj + "\"";
            }
            if (obj == objArr[i5]) {
                return (String) objArr[i5 + 1];
            }
            i5 += 2;
        }
    }

    private static String mapTransform(AffineTransform affineTransform) {
        if (affineTransform.isIdentity()) {
            return "new AffineTransform()";
        }
        return "new AffineTransform(" + affineTransform.getScaleX() + "f," + affineTransform.getShearY() + "f," + affineTransform.getShearX() + "f," + affineTransform.getScaleY() + "f," + affineTransform.getTranslateX() + "f," + affineTransform.getTranslateY() + "f)";
    }

    private void pathToString(StringBuilder sb, Path2D path2D) {
        sb.append("Path2D p = new Path2D.Double(");
        sb.append(path2D.getWindingRule());
        sb.append(");\n");
        double[] dArr = new double[6];
        PathIterator pathIterator = path2D.getPathIterator((AffineTransform) null);
        while (!pathIterator.isDone()) {
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment == 0) {
                sb.append("p.moveTo(");
                sb.append(dArr[0]);
                sb.append(",");
                sb.append(dArr[1]);
                sb.append(");\n");
            } else if (iCurrentSegment == 1) {
                sb.append("p.lineTo(");
                sb.append(dArr[0]);
                sb.append(",");
                sb.append(dArr[1]);
                sb.append(");\n");
            } else if (iCurrentSegment == 2) {
                sb.append("p.quadTo(");
                sb.append(dArr[0]);
                sb.append(",");
                sb.append(dArr[1]);
                sb.append(",");
                sb.append(dArr[2]);
                sb.append(",");
                sb.append(dArr[3]);
                sb.append(");\n");
            } else if (iCurrentSegment == 3) {
                sb.append("p.curveTo(");
                sb.append(dArr[0]);
                sb.append(",");
                sb.append(dArr[1]);
                sb.append(",");
                sb.append(dArr[2]);
                sb.append(",");
                sb.append(dArr[3]);
                sb.append(",");
                sb.append(dArr[4]);
                sb.append(",");
                sb.append(dArr[5]);
                sb.append(");\n");
            } else if (iCurrentSegment == 4) {
                sb.append("p.closePath();\n");
            }
            pathIterator.next();
        }
    }

    public void addRenderingHints(Map<?, ?> map) {
        this.log.println("addRenderingHinds(Map):\n  hints = " + map);
        this.g2D.addRenderingHints(map);
    }

    public void clearRect(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("clearRect(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.clearRect(i5, i6, i7, i8);
    }

    public void clip(Shape shape) {
        this.log.println("clip(Shape):\n  s = " + shape);
        this.g2D.clip(shape);
    }

    public void clipRect(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("height = ", i7, i8, androidx.collection.a.s("clipRect(int, int, int, int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.clipRect(i5, i6, i7, i8);
    }

    public void copyArea(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("copyArea(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.copyArea(i5, i6, i7, i8, i9, i10);
    }

    public Graphics create() {
        this.log.println("create():");
        return this.g2D.create();
    }

    public void dispose() {
        this.log.println("dispose():");
        this.g2D.dispose();
    }

    public void draw(Shape shape) {
        if (shape instanceof Path2D) {
            StringBuilder sb = new StringBuilder();
            pathToString(sb, (Path2D) shape);
            sb.append("g.draw(p);");
            this.log.println(sb);
        } else {
            this.log.println("g.draw(" + shape + ")");
        }
        this.g2D.draw(shape);
    }

    public void draw3DRect(int i5, int i6, int i7, int i8, boolean z6) {
        StringBuilder sbS = androidx.collection.a.s("draw3DRect(int,int,int,int,boolean):\n  x = ", i5, i6, "\n  y = ", "\n  width = ");
        androidx.exifinterface.media.a.y(sbS, i7, "\n  height = ", i8, "\n  raised = ");
        sbS.append(z6);
        this.log.println(sbS.toString());
        this.g2D.draw3DRect(i5, i6, i7, i8, z6);
    }

    public void drawArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        StringBuilder sbS = androidx.collection.a.s("drawArc(int,int,int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ");
        androidx.exifinterface.media.a.y(sbS, i7, "\n  height = ", i8, "\n  startAngle = ");
        this.log.println(androidx.exifinterface.media.a.i("\n  arcAngle = ", i9, i10, sbS));
        this.g2D.drawArc(i5, i6, i7, i8, i9, i10);
    }

    public void drawBytes(byte[] bArr, int i5, int i6, int i7, int i8) {
        StringBuilder sb = new StringBuilder("drawBytes(byte[],int,int,int,int):\n  data = ");
        sb.append(Arrays.toString(bArr));
        sb.append("\n  offset = ");
        sb.append(i5);
        sb.append("\n  length = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  x = ", i7, "\n  y = ");
        sb.append(i8);
        this.log.println(sb.toString());
        this.g2D.drawBytes(bArr, i5, i6, i7, i8);
    }

    public void drawChars(char[] cArr, int i5, int i6, int i7, int i8) {
        StringBuilder sb = new StringBuilder("drawChars(data,int,int,int,int):\n  data = ");
        sb.append(Arrays.toString(cArr));
        sb.append("\n  offset = ");
        sb.append(i5);
        sb.append("\n  length = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  x = ", i7, "\n  y = ");
        sb.append(i8);
        this.log.println(sb.toString());
        this.g2D.drawChars(cArr, i5, i6, i7, i8);
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f6, float f7) {
        this.log.println("drawGlyphVector(GlyphVector, float, float):\n  g = " + glyphVector + "\n  x = " + f6 + "\n  y = " + f7);
        this.g2D.drawGlyphVector(glyphVector, f6, f7);
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i5, int i6) {
        StringBuilder sb = new StringBuilder("drawImage(BufferedImage, BufferedImageOp, x, y):\n  img = ");
        sb.append(bufferedImage);
        sb.append("\n  op = ");
        sb.append(bufferedImageOp);
        sb.append("\n  x = ");
        this.log.println(androidx.exifinterface.media.a.i("\n  y = ", i5, i6, sb));
        this.g2D.drawImage(bufferedImage, bufferedImageOp, i5, i6);
    }

    public void drawLine(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  y2 = ", i7, i8, androidx.collection.a.s("drawLine(int,int,int,int):\n  x1 = ", i5, i6, "\n  y1 = ", "\n  x2 = ")));
        this.g2D.drawLine(i5, i6, i7, i8);
    }

    public void drawOval(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("drawOval(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.drawOval(i5, i6, i7, i8);
    }

    public void drawPolygon(Polygon polygon) {
        this.log.println("drawPolygon(Polygon):\n  p = " + polygon);
        this.g2D.drawPolygon(polygon);
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i5) {
        this.log.println("drawPolyline(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i5);
        this.g2D.drawPolyline(iArr, iArr2, i5);
    }

    public void drawRect(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("drawRect(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.drawRect(i5, i6, i7, i8);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        this.log.println("drawRenderableImage(RenderableImage, AfflineTransform):\n  img = " + renderableImage + "\n  xform = " + affineTransform);
        this.g2D.drawRenderableImage(renderableImage, affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        this.log.println("drawRenderedImage(RenderedImage, AffineTransform):\n  img = " + renderedImage + "\n  xform = " + affineTransform);
        this.g2D.drawRenderedImage(renderedImage, affineTransform);
    }

    public void drawRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        StringBuilder sbS = androidx.collection.a.s("drawRoundRect(int,int,int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ");
        androidx.exifinterface.media.a.y(sbS, i7, "\n  height = ", i8, "\n  arcWidth = ");
        this.log.println(androidx.exifinterface.media.a.i("\n  arcHeight = ", i9, i10, sbS));
        this.g2D.drawRoundRect(i5, i6, i7, i8, i9, i10);
    }

    public void drawString(String str, float f6, float f7) {
        this.log.println("drawString(s,x,y):\n  s = " + str + "\n  x = " + f6 + "\n  y = " + f7);
        this.g2D.drawString(str, f6, f7);
    }

    public void fill(Shape shape) {
        if (shape instanceof Path2D) {
            StringBuilder sb = new StringBuilder();
            pathToString(sb, (Path2D) shape);
            sb.append("g.fill(p);");
            this.log.println(sb);
        } else {
            this.log.println("g.fill(" + shape + ")");
        }
        this.g2D.fill(shape);
    }

    public void fill3DRect(int i5, int i6, int i7, int i8, boolean z6) {
        StringBuilder sbS = androidx.collection.a.s("fill3DRect(int,int,int,int,boolean):\n  x = ", i5, i6, "\n  y = ", "\n  width = ");
        androidx.exifinterface.media.a.y(sbS, i7, "\n  height = ", i8, "\n  raised = ");
        sbS.append(z6);
        this.log.println(sbS.toString());
        this.g2D.fill3DRect(i5, i6, i7, i8, z6);
    }

    public void fillArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        StringBuilder sbS = androidx.collection.a.s("fillArc(int,int,int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ");
        androidx.exifinterface.media.a.y(sbS, i7, "\n  height = ", i8, "\n  startAngle = ");
        this.log.println(androidx.exifinterface.media.a.i("\n  arcAngle = ", i9, i10, sbS));
        this.g2D.fillArc(i5, i6, i7, i8, i9, i10);
    }

    public void fillOval(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("fillOval(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.fillOval(i5, i6, i7, i8);
    }

    public void fillPolygon(Polygon polygon) {
        this.log.println("fillPolygon(Polygon):\n  p = " + polygon);
        this.g2D.fillPolygon(polygon);
    }

    public void fillRect(int i5, int i6, int i7, int i8) {
        PrintStream printStream = this.log;
        StringBuilder sbS = androidx.collection.a.s("g.fillRect(", i5, i6, ",", ",");
        sbS.append(i7);
        sbS.append(",");
        sbS.append(i8);
        sbS.append(");");
        printStream.println(sbS.toString());
        this.g2D.fillRect(i5, i6, i7, i8);
    }

    public void fillRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        PrintStream printStream = this.log;
        StringBuilder sbS = androidx.collection.a.s("fillRoundRect(", i5, i6, ",", ",");
        androidx.exifinterface.media.a.y(sbS, i7, ",", i8, ",");
        sbS.append(i9);
        sbS.append(",");
        sbS.append(i10);
        sbS.append(")");
        printStream.println(sbS.toString());
        this.g2D.fillRoundRect(i5, i6, i7, i8, i9, i10);
    }

    public Color getBackground() {
        this.log.println("getBackground():");
        return this.g2D.getBackground();
    }

    public Shape getClip() {
        this.log.println("getClip():");
        return this.g2D.getClip();
    }

    public Rectangle getClipBounds() {
        this.log.println("getClipBounds():");
        return this.g2D.getClipBounds();
    }

    public Color getColor() {
        this.log.println("getColor():");
        return this.g2D.getColor();
    }

    public Composite getComposite() {
        this.log.println("getComposite():");
        return this.g2D.getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        this.log.println("getDeviceConfiguration():");
        return this.g2D.getDeviceConfiguration();
    }

    public Font getFont() {
        this.log.println("getFont():");
        return this.g2D.getFont();
    }

    public FontMetrics getFontMetrics() {
        this.log.println("getFontMetrics():");
        return this.g2D.getFontMetrics();
    }

    public FontRenderContext getFontRenderContext() {
        this.log.println("getFontRenderContext():");
        return this.g2D.getFontRenderContext();
    }

    public Paint getPaint() {
        this.log.println("getPaint():");
        return this.g2D.getPaint();
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        this.log.println("getRenderingHint(\"" + key + "\")");
        return this.g2D.getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        this.log.println("getRenderingHints():");
        return this.g2D.getRenderingHints();
    }

    public Stroke getStroke() {
        this.log.println("getStroke():");
        return this.g2D.getStroke();
    }

    public AffineTransform getTransform() {
        this.log.println("getTransform():");
        return this.g2D.getTransform();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z6) {
        this.log.println("hit(Rectangle, Shape, onStroke):\n  rect = " + rectangle + "\n  s = " + shape + "\n  onStroke = " + z6);
        return this.g2D.hit(rectangle, shape, z6);
    }

    public boolean hitClip(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("hitClip(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        return this.g2D.hitClip(i5, i6, i7, i8);
    }

    public void rotate(double d) {
        this.log.println("rotate(theta):\n  theta = " + d);
        this.g2D.rotate(d);
    }

    public void scale(double d, double d6) {
        this.log.println("g.scale(" + d + "," + d6 + ");");
        this.g2D.scale(d, d6);
    }

    public void setBackground(Color color) {
        this.log.printf(Locale.ROOT, "setBackground(new Color(0x%08X))%n", Integer.valueOf(color.getRGB()));
        this.g2D.setBackground(color);
    }

    public void setClip(Shape shape) {
        this.log.println("setClip(Shape):\n  clip = " + shape);
        this.g2D.setClip(shape);
    }

    public void setColor(Color color) {
        this.log.printf(Locale.ROOT, "g.setColor(new Color(0x%08X));%n", Integer.valueOf(color.getRGB()));
        this.g2D.setColor(color);
    }

    public void setComposite(Composite composite) {
        String strQ;
        if (composite instanceof AlphaComposite) {
            AlphaComposite alphaComposite = (AlphaComposite) composite;
            StringBuilder sb = new StringBuilder("g.setComposite(AlphaComposite.getInstance(AlphaComposite.");
            String[] strArr = COMPOSITE_RULES;
            sb.append(strArr[Math.max(0, Math.min(strArr.length - 1, alphaComposite.getRule()))]);
            sb.append(", ");
            strQ = androidx.collection.a.q(sb, "f));", alphaComposite.getAlpha());
        } else {
            strQ = "g.setComposite(" + composite.toString() + ");";
        }
        this.log.println(strQ);
        this.g2D.setComposite(composite);
    }

    public void setFont(Font font) {
        this.log.println("setFont(Font):\n  font = " + font);
        this.g2D.setFont(font);
    }

    public void setPaint(Paint paint) {
        String strConcat;
        if (paint instanceof Color) {
            strConcat = "g.setPaint(".concat(String.format(Locale.ROOT, "new Color(0x%08X));", Integer.valueOf(((Color) paint).getRGB())));
        } else {
            strConcat = "g.setPaint(" + paint.toString() + ");";
        }
        this.log.println(strConcat);
        this.g2D.setPaint(paint);
    }

    public void setPaintMode() {
        this.log.println("setPaintMode():");
        this.g2D.setPaintMode();
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        this.log.println("g.setRenderingHint(" + mapHint(key) + ", " + mapHint(obj) + ");");
        this.g2D.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        this.log.println("setRenderingHints(Map):\n  hints = " + map);
        this.g2D.setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        String strQ;
        if (stroke instanceof BasicStroke) {
            BasicStroke basicStroke = (BasicStroke) stroke;
            String str = new String[]{"BUTT", "ROUND", "SQUARE"}[basicStroke.getEndCap()];
            String str2 = new String[]{"MITER", "ROUND", "BEVEL"}[basicStroke.getLineJoin()];
            StringBuilder sb = new StringBuilder("g.setStroke(new BasicStroke(");
            sb.append(basicStroke.getLineWidth());
            sb.append("f, BasicStroke.CAP_");
            sb.append(str);
            sb.append(", BasicStroke.JOIN_");
            sb.append(str2);
            sb.append(", ");
            sb.append(basicStroke.getMiterLimit());
            sb.append("f, ");
            sb.append(Arrays.toString(basicStroke.getDashArray()));
            sb.append(", ");
            strQ = androidx.collection.a.q(sb, "f));", basicStroke.getDashPhase());
        } else {
            strQ = "g.setStroke(" + stroke + ");";
        }
        this.log.println(strQ);
        this.g2D.setStroke(stroke);
    }

    public void setTransform(AffineTransform affineTransform) {
        this.log.println("g.setTransform(" + mapTransform(affineTransform) + ");");
        this.g2D.setTransform(affineTransform);
    }

    public void setXORMode(Color color) {
        this.log.println("setXORMode(Color):\n  c1 = " + color);
        this.g2D.setXORMode(color);
    }

    public void shear(double d, double d6) {
        this.log.println("shear(shx, dhy):\n  shx = " + d + "\n  shy = " + d6);
        this.g2D.shear(d, d6);
    }

    public String toString() {
        this.log.println("toString():");
        return this.g2D.toString();
    }

    public void transform(AffineTransform affineTransform) {
        this.log.println("transform(AffineTransform):\n  Tx = " + affineTransform);
        this.g2D.transform(affineTransform);
    }

    public void translate(double d, double d6) {
        this.log.println("translate(double, double):\n  tx = " + d + "\n  ty = " + d6);
        this.g2D.translate(d, d6);
    }

    public DummyGraphics2d(PrintStream printStream) {
        BufferedImage bufferedImage = new BufferedImage(1000, 1000, 2);
        this.bufimg = bufferedImage;
        this.g2D = bufferedImage.getGraphics();
        this.log = printStream;
    }

    public Graphics create(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("create(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        return this.g2D.create(i5, i6, i7, i8);
    }

    public Rectangle getClipBounds(Rectangle rectangle) {
        this.log.println("getClipBounds(Rectangle):\n  r = " + rectangle);
        return this.g2D.getClipBounds(rectangle);
    }

    public FontMetrics getFontMetrics(Font font) {
        this.log.println("getFontMetrics():");
        return this.g2D.getFontMetrics(font);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i5) {
        this.log.println("drawPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i5);
        this.g2D.drawPolygon(iArr, iArr2, i5);
    }

    public void drawString(final AttributedCharacterIterator attributedCharacterIterator, float f6, float f7) {
        int index = attributedCharacterIterator.getIndex();
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        char cCurrent = attributedCharacterIterator.current();
        while (cCurrent != 65535) {
            sb.append(cCurrent);
            attributedCharacterIterator.getAttributes().forEach(new BiConsumer() { // from class: org.apache.poi.xslf.util.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    DummyGraphics2d.lambda$drawString$1(map, attributedCharacterIterator, (AttributedCharacterIterator.Attribute) obj, obj2);
                }
            });
            cCurrent = attributedCharacterIterator.next();
        }
        sb.setLength(0);
        sb.append("AttributedString as = new AttributedString(\"" + ((Object) sb) + "\");\n");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute) entry.getKey();
            int i5 = -2;
            Object obj = null;
            int i6 = -2;
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                int iIntValue = ((Integer) entry2.getKey()).intValue();
                Object value = entry2.getValue();
                Iterator it2 = it;
                if (i5 < iIntValue - 1 || value != obj) {
                    if (i6 >= 0) {
                        sb.append("as.addAttribute(");
                        sb.append(mapAttribute(attribute));
                        sb.append(",");
                        sb.append(mapAttribute(obj));
                        sb.append(",");
                        sb.append(i6);
                        sb.append(",");
                        sb.append(i5 + 1);
                        sb.append(");\n");
                    }
                    i6 = iIntValue;
                }
                obj = value;
                i5 = iIntValue;
                it = it2;
            }
            Iterator it3 = it;
            if (obj != null) {
                sb.append("as.addAttribute(");
                sb.append(mapAttribute(attribute));
                sb.append(",");
                sb.append(mapAttribute(obj));
                sb.append(",");
                sb.append(i6);
                sb.append(",");
                sb.append(i5 + 1);
                sb.append(");\n");
            }
            it = it3;
        }
        sb.append("g.drawString(as.getIterator(),");
        sb.append(f6);
        sb.append("f,");
        sb.append(f7);
        sb.append("f);");
        this.log.println(sb);
        attributedCharacterIterator.setIndex(index);
        this.g2D.drawString(attributedCharacterIterator, f6, f7);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i5) {
        this.log.println("fillPolygon(int[],int[],int):\n  xPoints = " + Arrays.toString(iArr) + "\n  yPoints = " + Arrays.toString(iArr2) + "\n  nPoints = " + i5);
        this.g2D.fillPolygon(iArr, iArr2, i5);
    }

    public void rotate(double d, double d6, double d7) {
        this.log.println("rotate(double,double,double):\n  theta = " + d + "\n  x = " + d6 + "\n  y = " + d7);
        this.g2D.rotate(d, d6, d7);
    }

    public void setClip(int i5, int i6, int i7, int i8) {
        this.log.println(androidx.exifinterface.media.a.i("\n  height = ", i7, i8, androidx.collection.a.s("setClip(int,int,int,int):\n  x = ", i5, i6, "\n  y = ", "\n  width = ")));
        this.g2D.setClip(i5, i6, i7, i8);
    }

    public void translate(int i5, int i6) {
        this.log.println(androidx.collection.a.h(i5, i6, "translate(int,int):\n  x = ", "\n  y = "));
        this.g2D.translate(i5, i6);
    }

    public DummyGraphics2d(PrintStream printStream, Graphics2D graphics2D) {
        this.g2D = graphics2D;
        this.log = printStream;
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,AfflineTransform,ImageObserver):\n  img = " + image + "\n  xform = " + affineTransform + "\n  obs = " + imageObserver);
        return this.g2D.drawImage(image, affineTransform, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ImageObserver imageObserver) {
        StringBuilder sb = new StringBuilder("drawImage(Image,int,int,int,int,int,int,int,int,ImageObserver):\n  img = ");
        sb.append(image);
        sb.append("\n  dx1 = ");
        sb.append(i5);
        sb.append("\n  dy1 = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  dx2 = ", i7, "\n  dy2 = ");
        androidx.exifinterface.media.a.y(sb, i8, "\n  sx1 = ", i9, "\n  sy1 = ");
        androidx.exifinterface.media.a.y(sb, i10, "\n  sx2 = ", i11, "\n  sy2 = ");
        sb.append(i12);
        sb.append("\n  observer = ");
        sb.append(imageObserver);
        this.log.println(sb.toString());
        return this.g2D.drawImage(image, i5, i6, i7, i8, i9, i10, i11, i12, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Color color, ImageObserver imageObserver) {
        StringBuilder sb = new StringBuilder("drawImage(Image,int,int,int,int,int,int,int,int,Color,ImageObserver):\n  img = ");
        sb.append(image);
        sb.append("\n  dx1 = ");
        sb.append(i5);
        sb.append("\n  dy1 = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  dx2 = ", i7, "\n  dy2 = ");
        androidx.exifinterface.media.a.y(sb, i8, "\n  sx1 = ", i9, "\n  sy1 = ");
        androidx.exifinterface.media.a.y(sb, i10, "\n  sx2 = ", i11, "\n  sy2 = ");
        sb.append(i12);
        sb.append("\n  bgcolor = ");
        sb.append(color);
        sb.append("\n  observer = ");
        sb.append(imageObserver);
        this.log.println(sb.toString());
        return this.g2D.drawImage(image, i5, i6, i7, i8, i9, i10, i11, i12, color, imageObserver);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i5, int i6) {
        drawString(attributedCharacterIterator, i5, i6);
    }

    public void drawString(String str, int i5, int i6) {
        this.log.println("drawString(str,int,int):\n  str = " + str + "\n  x = " + i5 + "\n  y = " + i6);
        this.g2D.drawString(str, i5, i6);
    }

    public boolean drawImage(Image image, int i5, int i6, Color color, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,Color,ImageObserver):\n  img = " + image + "\n  x = " + i5 + "\n  y = " + i6 + "\n  bgcolor = " + color + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i5, i6, color, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, ImageObserver imageObserver) {
        this.log.println("drawImage(Image,int,int,observer):\n  img = " + image + "\n  x = " + i5 + "\n  y = " + i6 + "\n  observer = " + imageObserver);
        return this.g2D.drawImage(image, i5, i6, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        StringBuilder sb = new StringBuilder("drawImage(Image,int,int,int,int,Color,ImageObserver):\n  img = ");
        sb.append(image);
        sb.append("\n  x = ");
        sb.append(i5);
        sb.append("\n  y = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  width = ", i7, "\n  height = ");
        sb.append(i8);
        sb.append("\n  bgcolor = ");
        sb.append(color);
        sb.append("\n  observer = ");
        sb.append(imageObserver);
        this.log.println(sb.toString());
        return this.g2D.drawImage(image, i5, i6, i7, i8, color, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        StringBuilder sb = new StringBuilder("drawImage(Image,int,int,width,height,observer):\n  img = ");
        sb.append(image);
        sb.append("\n  x = ");
        sb.append(i5);
        sb.append("\n  y = ");
        androidx.exifinterface.media.a.y(sb, i6, "\n  width = ", i7, "\n  height = ");
        sb.append(i8);
        sb.append("\n  observer = ");
        sb.append(imageObserver);
        this.log.println(sb.toString());
        return this.g2D.drawImage(image, i5, i6, i7, i8, imageObserver);
    }
}

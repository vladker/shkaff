package org.apache.poi.sl.draw;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.sl.draw.geom.ArcToCommand;
import org.apache.poi.sl.usermodel.AbstractColorStyle;
import org.apache.poi.sl.usermodel.ColorStyle;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.util.Dimension2DDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawPaint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LogManager.getLogger((Class<?>) DrawPaint.class);
    private static final Color TRANSPARENT = new Color(1.0f, 1.0f, 1.0f, 0.0f);
    protected PlaceableShape<?, ?> shape;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawPaint$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$FlipMode;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType;

        static {
            int[] iArr = new int[PaintStyle.FlipMode.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$FlipMode = iArr;
            try {
                iArr[PaintStyle.FlipMode.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$FlipMode[PaintStyle.FlipMode.Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$FlipMode[PaintStyle.FlipMode.XY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PaintStyle.GradientPaint.GradientType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType = iArr2;
            try {
                iArr2[PaintStyle.GradientPaint.GradientType.linear.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType[PaintStyle.GradientPaint.GradientType.rectangular.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType[PaintStyle.GradientPaint.GradientType.circular.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType[PaintStyle.GradientPaint.GradientType.shape.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public DrawPaint(PlaceableShape<?, ?> placeableShape) {
        this.shape = placeableShape;
    }

    public static Color HSL2RGB(double d, double d6, double d7, double d8) {
        double dMax = Math.max(0.0d, Math.min(100.0d, d6));
        double dMax2 = Math.max(0.0d, Math.min(100.0d, d7));
        if (d8 < 0.0d || d8 > 1.0d) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Alpha: " + d8);
        }
        double d9 = (d % 360.0d) / 360.0d;
        double d10 = dMax / 100.0d;
        double d11 = dMax2 / 100.0d;
        double d12 = d11 < 0.5d ? (d10 + 1.0d) * d11 : (d11 + d10) - (d10 * d11);
        double d13 = (d11 * 2.0d) - d12;
        double d14 = d12;
        return new Color((float) Math.min(Math.max(0.0d, HUE2RGB(d13, d14, d9 + 0.3333333333333333d)), 1.0d), (float) Math.min(Math.max(0.0d, HUE2RGB(d13, d14, d9)), 1.0d), (float) Math.min(Math.max(0.0d, HUE2RGB(d13, d14, d9 - 0.3333333333333333d)), 1.0d), (float) d8);
    }

    private static double HUE2RGB(double d, double d6, double d7) {
        double d8 = d7 < 0.0d ? d7 + 1.0d : d7;
        if (d8 > 1.0d) {
            d8 -= 1.0d;
        }
        double d9 = d8;
        if (d9 * 6.0d < 1.0d) {
            return ((d6 - d) * 6.0d * d9) + d;
        }
        if (d9 * 2.0d < 1.0d) {
            return d6;
        }
        return 3.0d * d9 < 2.0d ? androidx.collection.a.a(0.6666666666666666d, d9, (d6 - d) * 6.0d, d) : d;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0029  */
    public static double[] RGB2HSL(Color color) {
        double d;
        float[] rGBColorComponents = color.getRGBColorComponents((float[]) null);
        double d6 = rGBColorComponents[0];
        double d7 = rGBColorComponents[1];
        double d8 = rGBColorComponents[2];
        double dMin = Math.min(d6, Math.min(d7, d8));
        double dMax = Math.max(d6, Math.max(d7, d8));
        double d9 = 0.0d;
        if (dMax == dMin) {
            d = 0.0d;
        } else if (dMax == d6) {
            d = ((((d7 - d8) * 60.0d) / (dMax - dMin)) + 360.0d) % 360.0d;
        } else if (dMax == d7) {
            d = (((d8 - d6) * 60.0d) / (dMax - dMin)) + 120.0d;
        } else if (dMax == d8) {
            d = 240.0d + (((d6 - d7) * 60.0d) / (dMax - dMin));
        } else {
            d = 0.0d;
        }
        double d10 = dMax + dMin;
        double d11 = d10 / 2.0d;
        if (dMax != dMin) {
            d9 = d11 <= 0.5d ? (dMax - dMin) / d10 : (dMax - dMin) / ((2.0d - dMax) - dMin);
        }
        return new double[]{d, d9 * 100.0d, d11 * 100.0d};
    }

    public static double[] RGB2SCRGB(Color color) {
        float[] colorComponents = color.getColorComponents((float[]) null);
        double[] dArr = new double[3];
        for (int i5 = 0; i5 < 3; i5++) {
            float f6 = colorComponents[i5];
            if (f6 < 0.0f) {
                dArr[i5] = 0.0d;
            } else if (f6 <= 0.04045d) {
                dArr[i5] = ((double) f6) / 12.92d;
            } else if (f6 <= 1.0f) {
                dArr[i5] = Math.pow((((double) f6) + 0.055d) / 1.055d, 2.4d);
            } else {
                dArr[i5] = 1.0d;
            }
        }
        return dArr;
    }

    public static Color SCRGB2RGB(double... dArr) {
        double[] dArr2 = new double[3];
        for (int i5 = 0; i5 < 3; i5++) {
            double d = dArr[i5];
            if (d < 0.0d) {
                dArr2[i5] = 0.0d;
            } else if (d <= 0.0031308d) {
                dArr2[i5] = d * 12.92d;
            } else if (d < 1.0d) {
                dArr2[i5] = (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d;
            } else {
                dArr2[i5] = 1.0d;
            }
        }
        return new Color((float) dArr2[0], (float) dArr2[1], (float) dArr2[2]);
    }

    public static Color applyColorTransform(ColorStyle colorStyle) {
        if (colorStyle == null || colorStyle.getColor() == null) {
            return TRANSPARENT;
        }
        Color color = colorStyle.getColor();
        double alpha = getAlpha(color, colorStyle);
        double[] dArrRGB2SCRGB = RGB2SCRGB(color);
        applyShade(dArrRGB2SCRGB, colorStyle);
        applyTint(dArrRGB2SCRGB, colorStyle);
        double[] dArrRGB2HSL = RGB2HSL(SCRGB2RGB(dArrRGB2SCRGB));
        applyHslModOff(dArrRGB2HSL, 0, colorStyle.getHueMod(), colorStyle.getHueOff());
        applyHslModOff(dArrRGB2HSL, 1, colorStyle.getSatMod(), colorStyle.getSatOff());
        applyHslModOff(dArrRGB2HSL, 2, colorStyle.getLumMod(), colorStyle.getLumOff());
        return HSL2RGB(dArrRGB2HSL[0], dArrRGB2HSL[1], dArrRGB2HSL[2], alpha);
    }

    private static void applyHslModOff(double[] dArr, int i5, int i6, int i7) {
        if (i6 != -1) {
            dArr[i5] = (((double) i6) / 100000.0d) * dArr[i5];
        }
        if (i7 != -1) {
            dArr[i5] = (((double) i7) / 1000.0d) + dArr[i5];
        }
    }

    private static void applyShade(double[] dArr, ColorStyle colorStyle) {
        int shade = colorStyle.getShade();
        if (shade == -1) {
            return;
        }
        double d = ((double) shade) / 100000.0d;
        for (int i5 = 0; i5 < 3; i5++) {
            dArr[i5] = Math.max(0.0d, Math.min(1.0d, dArr[i5] * d));
        }
    }

    private static void applyTint(double[] dArr, ColorStyle colorStyle) {
        int tint = colorStyle.getTint();
        if (tint == -1 || tint == 0) {
            return;
        }
        double d = ((double) tint) / 100000.0d;
        for (int i5 = 0; i5 < 3; i5++) {
            dArr[i5] = 1.0d - ((1.0d - dArr[i5]) * d);
        }
    }

    private static BufferedImage colorizePattern(PaintStyle.TexturePaint texturePaint, BufferedImage bufferedImage) {
        List<ColorStyle> duoTone = texturePaint.getDuoTone();
        if (duoTone == null || duoTone.size() != 2) {
            return bufferedImage;
        }
        int sampleSize = bufferedImage.getSampleModel().getSampleSize(0);
        int iMax = Math.max(Math.min(sampleSize, 8), 1);
        int i5 = 1 << iMax;
        double dMax = ((double) i5) / ((double) (1 << Math.max(sampleSize, 1)));
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 13, new IndexColorModel(iMax, i5, linearBlendedColors(duoTone, i5), 0, true, -1, 0));
        WritableRaster raster = bufferedImage.getRaster();
        WritableRaster raster2 = bufferedImage2.getRaster();
        int width = bufferedImage.getWidth();
        int[] iArr = new int[width];
        int i6 = 0;
        while (i6 < bufferedImage.getHeight()) {
            raster.getSamples(0, i6, width, 1, 0, iArr);
            scaleShades(iArr, dMax);
            int[] iArr2 = iArr;
            int i7 = width;
            int i8 = i6;
            raster2.setSamples(0, i8, i7, 1, 0, iArr2);
            width = i7;
            iArr = iArr2;
            i6 = i8 + 1;
        }
        return bufferedImage2;
    }

    public static PaintStyle.SolidPaint createSolidPaint(Color color) {
        if (color == null) {
            return null;
        }
        return new SimpleSolidPaint(color);
    }

    public static void fillPaintWorkaround(Graphics2D graphics2D, Shape shape) {
        try {
            graphics2D.fill(shape);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.atWarn().withThrowable(e).log("IBM JDK failed with TexturePaintContext AIOOBE - try adding the following to the VM parameter:\n-Xjit:exclude={sun/java2d/pipe/AlphaPaintPipe.renderPathTile(Ljava/lang/Object;[BIIIIII)V} and search for 'JIT Problem Determination for IBM SDK using -Xjit' (http://www-01.ibm.com/support/docview.wss?uid=swg21294023) for how to add/determine further excludes");
        }
    }

    private static double getAlpha(Color color, ColorStyle colorStyle) {
        double alpha = ((double) color.getAlpha()) / 255.0d;
        int alpha2 = colorStyle.getAlpha();
        if (alpha2 != -1) {
            alpha *= ((double) alpha2) / 100000.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, alpha));
    }

    private static double getCenterVal(double d, double d6, double d7, double d8) {
        double d9 = d6 - d;
        double d10 = (d9 * d7) + d;
        double d11 = d9 * d8;
        return (((d7 + d8 <= 1.0d ? d6 - d11 : d6 + d11) - d10) / 2.0d) + d10;
    }

    private static double getScale(double d, double d6, double d7, double d8) {
        double d9 = d6 - d;
        double d10 = (d9 * d7) + d;
        double d11 = d7 + d8;
        double d12 = d8 * d9;
        double d13 = d11 <= 1.0d ? d6 - d12 : d6 + d12;
        if (d9 == 0.0d) {
            return 1.0d;
        }
        return (d13 - d10) / d9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Paint lambda$createLinearGradientPaint$1(Point2D point2D, Point2D point2D2, float[] fArr, Color[] colorArr) {
        return new LinearGradientPaint(point2D, point2D2, fArr, colorArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Paint lambda$createRadialGradientPaint$2(Point2D point2D, float f6, Point2D point2D2, AffineTransform affineTransform, float[] fArr, Color[] colorArr) {
        return new RadialGradientPaint(point2D, f6, point2D2, fArr, colorArr, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, affineTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Color[] lambda$linearBlendedColors$0(int i5) {
        return new Color[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Color lambda$safeFractions$3(ColorStyle colorStyle) {
        return colorStyle == null ? TRANSPARENT : applyColorTransform(colorStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toArray$4(float[] fArr, int[] iArr, Float f6) {
        int i5 = iArr[0];
        iArr[0] = i5 + 1;
        fArr[i5] = f6.floatValue();
    }

    private static int[] linearBlendedColors(List<ColorStyle> list, int i5) {
        Color[] colorArr = (Color[]) list.stream().map(new f(1)).toArray(new j());
        BufferedImage bufferedImage = new BufferedImage(i5, 1, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.setPaint(new LinearGradientPaint(0.0f, 0.0f, i5, 0.0f, new float[]{0.0f, 1.0f}, colorArr));
        graphics2DCreateGraphics.fillRect(0, 0, i5, 1);
        graphics2DCreateGraphics.dispose();
        return bufferedImage.getRGB(0, 0, i5, 1, (int[]) null, 0, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Paint safeFractions(BiFunction<float[], Color[], Paint> biFunction, PaintStyle.GradientPaint gradientPaint) {
        Iterator it = Stream.of((Object[]) gradientPaint.getGradientColors()).map(new f(0)).iterator();
        TreeMap treeMap = new TreeMap();
        for (float f6 : gradientPaint.getGradientFractions()) {
            treeMap.put(Float.valueOf(f6), it.next());
        }
        return (Paint) biFunction.apply(toArray(treeMap.keySet()), treeMap.values().toArray(new Color[0]));
    }

    private static void scaleShades(int[] iArr, double d) {
        if (d != 1.0d) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                iArr[i5] = (int) Math.rint(((double) iArr[i5]) * d);
            }
        }
    }

    private static float[] toArray(Collection<Float> collection) {
        final int[] iArr = {0};
        final float[] fArr = new float[collection.size()];
        collection.forEach(new Consumer() { // from class: org.apache.poi.sl.draw.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DrawPaint.lambda$toArray$4(fArr, iArr, (Float) obj);
            }
        });
        return fArr;
    }

    public Paint createLinearGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        double gradientAngle = gradientPaint.getGradientAngle();
        if (!gradientPaint.isRotatedWithShape()) {
            gradientAngle -= this.shape.getRotation();
        }
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, this.shape);
        if (anchor == null) {
            return TRANSPARENT;
        }
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(ArcToCommand.convertOoxml2AwtAngle(-gradientAngle, anchor.getWidth(), anchor.getHeight())), anchor.getCenterX(), anchor.getCenterY());
        final Point2D point2DTransform = rotateInstance.transform(new Point2D.Double(anchor.getCenterX() - (Math.sqrt(Math.pow(anchor.getHeight(), 2.0d) + Math.pow(anchor.getWidth(), 2.0d)) / 2.0d), anchor.getCenterY()), (Point2D) null);
        final Point2D point2DTransform2 = rotateInstance.transform(new Point2D.Double(anchor.getMaxX(), anchor.getCenterY()), (Point2D) null);
        if (point2DTransform.equals(point2DTransform2) || gradientPaint.getGradientFractions().length < 2) {
            return null;
        }
        return safeFractions(new BiFunction() { // from class: org.apache.poi.sl.draw.g
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DrawPaint.lambda$createLinearGradientPaint$1(point2DTransform, point2DTransform2, (float[]) obj, (Color[]) obj2);
            }
        }, gradientPaint);
    }

    public Paint createPathGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        return safeFractions(new i(), gradientPaint);
    }

    public Paint createRadialGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, this.shape);
        if (anchor == null) {
            return TRANSPARENT;
        }
        Insets2D fillToInsets = gradientPaint.getFillToInsets();
        if (fillToInsets == null) {
            fillToInsets = new Insets2D(0.0d, 0.0d, 0.0d, 0.0d);
        }
        final Point2D.Double r6 = new Point2D.Double(anchor.getCenterX(), anchor.getCenterY());
        final Point2D.Double r7 = new Point2D.Double(getCenterVal(anchor.getMinX(), anchor.getMaxX(), fillToInsets.left, fillToInsets.right), getCenterVal(anchor.getMinY(), anchor.getMaxY(), fillToInsets.top, fillToInsets.bottom));
        final float fMax = (float) Math.max(anchor.getWidth(), anchor.getHeight());
        final AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(r7.getX(), r7.getY());
        affineTransform.scale(getScale(anchor.getMinX(), anchor.getMaxX(), fillToInsets.left, fillToInsets.right), getScale(anchor.getMinY(), anchor.getMaxY(), fillToInsets.top, fillToInsets.bottom));
        affineTransform.translate(-r7.getX(), -r7.getY());
        return safeFractions(new BiFunction() { // from class: org.apache.poi.sl.draw.k
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DrawPaint.lambda$createRadialGradientPaint$2(r6, fMax, r7, affineTransform, (float[]) obj, (Color[]) obj2);
            }
        }, gradientPaint);
    }

    public Paint getGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType[gradientPaint.getGradientType().ordinal()];
        if (i5 == 1) {
            return createLinearGradientPaint(gradientPaint, graphics2D);
        }
        if (i5 == 2 || i5 == 3) {
            return createRadialGradientPaint(gradientPaint, graphics2D);
        }
        if (i5 == 4) {
            return createPathGradientPaint(gradientPaint, graphics2D);
        }
        throw new UnsupportedOperationException("gradient fill of type " + gradientPaint + " not supported.");
    }

    public Paint getPaint(Graphics2D graphics2D, PaintStyle paintStyle) {
        return getPaint(graphics2D, paintStyle, PaintStyle.PaintModifier.NORM);
    }

    public Paint getSolidPaint(PaintStyle.SolidPaint solidPaint, Graphics2D graphics2D, final PaintStyle.PaintModifier paintModifier) {
        final ColorStyle solidColor = solidPaint.getSolidColor();
        return applyColorTransform(new AbstractColorStyle() { // from class: org.apache.poi.sl.draw.DrawPaint.1
            private int scale(int i5, PaintStyle.PaintModifier paintModifier2, PaintStyle.PaintModifier paintModifier3) {
                int i6;
                if (i5 == -1) {
                    return -1;
                }
                PaintStyle.PaintModifier paintModifier4 = paintModifier;
                if (paintModifier4 == paintModifier2) {
                    i6 = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
                } else {
                    i6 = paintModifier4 == paintModifier3 ? 40000 : 0;
                }
                return Math.min(BZip2Constants.BASEBLOCKSIZE, Math.max(0, i5) + i6);
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getAlpha() {
                return solidColor.getAlpha();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public Color getColor() {
                return solidColor.getColor();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getHueMod() {
                return solidColor.getHueMod();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getHueOff() {
                return solidColor.getHueOff();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getLumMod() {
                return solidColor.getLumMod();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getLumOff() {
                return solidColor.getLumOff();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getSatMod() {
                return solidColor.getSatMod();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getSatOff() {
                return solidColor.getSatOff();
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getShade() {
                return scale(solidColor.getShade(), PaintStyle.PaintModifier.DARKEN_LESS, PaintStyle.PaintModifier.DARKEN);
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getTint() {
                return scale(solidColor.getTint(), PaintStyle.PaintModifier.LIGHTEN_LESS, PaintStyle.PaintModifier.LIGHTEN);
            }
        });
    }

    public Paint getTexturePaint(PaintStyle.TexturePaint texturePaint, Graphics2D graphics2D) {
        Throwable th;
        InputStream inputStream;
        double d;
        double d6;
        Graphics2D graphics2D2;
        Color color;
        String contentType = texturePaint.getContentType();
        if (contentType == null || contentType.isEmpty()) {
            return TRANSPARENT;
        }
        ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(graphics2D, contentType);
        Rectangle2D anchor = this.shape.getAnchor();
        try {
            InputStream imageData = texturePaint.getImageData();
            try {
                if (imageData != null) {
                    try {
                        Boolean bool = (Boolean) graphics2D.getRenderingHint(Drawable.CACHE_IMAGE_SOURCE);
                        imageRenderer.setCacheInput(bool != null && bool.booleanValue());
                        imageRenderer.loadImage(imageData, contentType);
                        int alpha = texturePaint.getAlpha();
                        if (alpha >= 0 && alpha < 100000) {
                            imageRenderer.setAlpha(alpha / 100000.0f);
                        }
                        Dimension2D dimension = imageRenderer.getDimension();
                        if ("image/x-wmf".contains(contentType)) {
                            dimension = new Dimension2DDouble(anchor.getWidth(), anchor.getHeight());
                        }
                        BufferedImage image = imageRenderer.getImage(dimension);
                        if (image != null) {
                            PaintStyle.FlipMode flipMode = texturePaint.getFlipMode();
                            double d7 = 1.0d;
                            if (flipMode == null || flipMode == PaintStyle.FlipMode.NONE) {
                                inputStream = imageData;
                                d = 1.0d;
                            } else {
                                int width = image.getWidth();
                                int height = image.getHeight();
                                int[] iArr = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$FlipMode;
                                int i5 = iArr[flipMode.ordinal()];
                                if (i5 == 1) {
                                    d6 = 1.0d;
                                    d7 = 2.0d;
                                } else if (i5 != 2) {
                                    d7 = i5 == 3 ? 2.0d : 1.0d;
                                    d6 = d7;
                                } else {
                                    d6 = 2.0d;
                                }
                                inputStream = imageData;
                                double d8 = d7;
                                try {
                                    BufferedImage bufferedImage = new BufferedImage((int) (((double) width) * d7), (int) (((double) height) * d6), 2);
                                    Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
                                    graphics2DCreateGraphics.drawImage(image, 0, 0, (ImageObserver) null);
                                    int i6 = iArr[flipMode.ordinal()];
                                    if (i6 == 1) {
                                        graphics2D2 = graphics2DCreateGraphics;
                                        graphics2D2.drawImage(image, width * 2, 0, -width, height, (ImageObserver) null);
                                    } else if (i6 == 2) {
                                        graphics2D2 = graphics2DCreateGraphics;
                                        graphics2D2.drawImage(image, 0, height * 2, width, -height, (ImageObserver) null);
                                    } else if (i6 != 3) {
                                        graphics2D2 = graphics2DCreateGraphics;
                                    } else {
                                        int i7 = width * 2;
                                        int i8 = -width;
                                        graphics2D2 = graphics2DCreateGraphics;
                                        graphics2D2.drawImage(image, i7, 0, i8, height, (ImageObserver) null);
                                        int i9 = height * 2;
                                        int i10 = -height;
                                        graphics2D2.drawImage(image, 0, i9, width, i10, (ImageObserver) null);
                                        graphics2D2.drawImage(image, i7, i9, i8, i10, (ImageObserver) null);
                                    }
                                    graphics2D2.dispose();
                                    image = bufferedImage;
                                    d = d6;
                                    d7 = d8;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            DrawTexturePaint drawTexturePaint = new DrawTexturePaint(imageRenderer, colorizePattern(texturePaint, image), (Shape) graphics2D.getRenderingHint(Drawable.GRADIENT_SHAPE), texturePaint, d7, d, imageRenderer instanceof BitmapImageRenderer);
                            inputStream.close();
                            return drawTexturePaint;
                        }
                        LOG.atError().log("Can't load image data");
                        color = TRANSPARENT;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = imageData;
                    }
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        if (inputStream == null) {
                            throw th4;
                        }
                        try {
                            inputStream.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th.addSuppressed(th5);
                            throw th4;
                        }
                    }
                }
                color = TRANSPARENT;
                if (imageData == null) {
                    return color;
                }
                imageData.close();
                return color;
            } catch (Throwable th6) {
                th = th6;
                inputStream = imageData;
            }
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("Can't load image data - using transparent color");
            return TRANSPARENT;
        }
    }

    public static PaintStyle.SolidPaint createSolidPaint(ColorStyle colorStyle) {
        if (colorStyle == null) {
            return null;
        }
        return new SimpleSolidPaint(colorStyle);
    }

    public Paint getPaint(Graphics2D graphics2D, PaintStyle paintStyle, PaintStyle.PaintModifier paintModifier) {
        if (paintModifier == PaintStyle.PaintModifier.NONE) {
            return TRANSPARENT;
        }
        if (paintStyle instanceof PaintStyle.SolidPaint) {
            return getSolidPaint((PaintStyle.SolidPaint) paintStyle, graphics2D, paintModifier);
        }
        if (paintStyle instanceof PaintStyle.GradientPaint) {
            return getGradientPaint((PaintStyle.GradientPaint) paintStyle, graphics2D);
        }
        return paintStyle instanceof PaintStyle.TexturePaint ? getTexturePaint((PaintStyle.TexturePaint) paintStyle, graphics2D) : TRANSPARENT;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SimpleSolidPaint implements PaintStyle.SolidPaint {
        private final ColorStyle solidColor;

        public SimpleSolidPaint(final Color color) {
            if (color == null) {
                throw new NullPointerException("Color needs to be specified");
            }
            this.solidColor = new AbstractColorStyle() { // from class: org.apache.poi.sl.draw.DrawPaint.SimpleSolidPaint.1
                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getAlpha() {
                    return (int) Math.round((((double) color.getAlpha()) * 100000.0d) / 255.0d);
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public Color getColor() {
                    return new Color(color.getRed(), color.getGreen(), color.getBlue());
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getHueMod() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getHueOff() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getLumMod() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getLumOff() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getSatMod() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getSatOff() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getShade() {
                    return -1;
                }

                @Override // org.apache.poi.sl.usermodel.ColorStyle
                public int getTint() {
                    return -1;
                }
            };
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PaintStyle.SolidPaint) {
                return Objects.equals(getSolidColor(), ((PaintStyle.SolidPaint) obj).getSolidColor());
            }
            return false;
        }

        @Override // org.apache.poi.sl.usermodel.PaintStyle.SolidPaint
        public ColorStyle getSolidColor() {
            return this.solidColor;
        }

        public int hashCode() {
            return Objects.hash(this.solidColor);
        }

        public SimpleSolidPaint(ColorStyle colorStyle) {
            if (colorStyle != null) {
                this.solidColor = colorStyle;
                return;
            }
            throw new NullPointerException("Color needs to be specified");
        }
    }
}

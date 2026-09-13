package androidx.core.graphics;

import A3.AbstractC0157z;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < pathDataNodeArr.length; i5++) {
            if (pathDataNodeArr[i5].mType != pathDataNodeArr2[i5].mType || pathDataNodeArr[i5].mParams.length != pathDataNodeArr2[i5].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i5 < 0 || i5 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = i6 - i5;
        int iMin = Math.min(i7, length - i5);
        float[] fArr2 = new float[i7];
        System.arraycopy(fArr, i5, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 1;
        while (i6 < str.length()) {
            int iNextStart = nextStart(str, i6);
            String strTrim = str.substring(i5, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i5 = iNextStart;
            i6 = iNextStart + 1;
        }
        if (i6 - i5 == 1 && i5 < str.length()) {
            addNode(arrayList, str.charAt(i5), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(AbstractC0157z.n("Error in parsing ", str), e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i5 = 0; i5 < pathDataNodeArr.length; i5++) {
            pathDataNodeArr2[i5] = new PathDataNode(pathDataNodeArr[i5]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    private static void extract(String str, int i5, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (int i6 = i5; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == ' ') {
                z6 = false;
                z8 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z6 = false;
                        z8 = true;
                        break;
                    case '-':
                        if (i6 == i5 || z6) {
                            z6 = false;
                        } else {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z6 = false;
                            z8 = true;
                        }
                        break;
                    case '.':
                        if (z7) {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z6 = false;
                            z8 = true;
                        } else {
                            z6 = false;
                            z7 = true;
                        }
                        break;
                    default:
                        z6 = false;
                        break;
                }
            } else {
                z6 = true;
            }
            if (z8) {
                extractFloatResult.mEndPosition = i6;
            }
        }
        extractFloatResult.mEndPosition = i6;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i5 = 1;
            int i6 = 0;
            while (i5 < length) {
                extract(str, i5, extractFloatResult);
                int i7 = extractFloatResult.mEndPosition;
                if (i5 < i7) {
                    fArr[i6] = Float.parseFloat(str.substring(i5, i7));
                    i6++;
                }
                i5 = extractFloatResult.mEndWithNegOrDot ? i7 : i7 + 1;
            }
            return copyOfRange(fArr, 0, i6);
        } catch (NumberFormatException e) {
            throw new RuntimeException(AbstractC0157z.o("error in parsing \"", str, "\""), e);
        }
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, float f6, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f6)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    private static int nextStart(String str, int i5) {
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                } else if (cCharAt != 'e' && cCharAt != 'E') {
                    break;
                }
            } else if (cCharAt != 'e') {
                continue;
            }
            i5++;
        }
        return i5;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i5 = 0; i5 < pathDataNodeArr2.length; i5++) {
            pathDataNodeArr[i5].mType = pathDataNodeArr2[i5].mType;
            for (int i6 = 0; i6 < pathDataNodeArr2[i5].mParams.length; i6++) {
                pathDataNodeArr[i5].mParams[i6] = pathDataNodeArr2[i5].mParams[i6];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c6, float[] fArr2) {
            int i5;
            int i6;
            boolean z6;
            boolean z7;
            char c7;
            char c8;
            int i7;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            Path path2 = path;
            boolean z8 = false;
            float f19 = fArr[0];
            boolean z9 = true;
            float f20 = fArr[1];
            char c9 = 2;
            float f21 = fArr[2];
            char c10 = 3;
            float f22 = fArr[3];
            float f23 = fArr[4];
            float f24 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i5 = 7;
                    i6 = i5;
                    break;
                case 'C':
                case 'c':
                    i5 = 6;
                    i6 = i5;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i6 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                    i6 = 2;
                    break;
            }
            float f25 = f19;
            float f26 = f20;
            float f27 = f23;
            float f28 = f24;
            int i8 = 0;
            char c11 = c;
            while (i8 < fArr2.length) {
                if (c6 == 'A') {
                    z6 = z8;
                    z7 = z9;
                    c7 = c9;
                    c8 = c10;
                    i7 = i8;
                    int i9 = i7 + 5;
                    int i10 = i7 + 6;
                    drawArc(path, f25, f26, fArr2[i9], fArr2[i10], fArr2[i7], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f ? z7 : z6, fArr2[i7 + 4] != 0 ? z7 : z6);
                    f21 = fArr2[i9];
                    f25 = f21;
                    f22 = fArr2[i10];
                    f26 = f22;
                } else if (c6 == 'C') {
                    z6 = z8;
                    z7 = z9;
                    c7 = c9;
                    c8 = c10;
                    i7 = i8;
                    int i11 = i7 + 2;
                    int i12 = i7 + 3;
                    int i13 = i7 + 4;
                    int i14 = i7 + 5;
                    path2.cubicTo(fArr2[i7], fArr2[i7 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                    float f29 = fArr2[i13];
                    float f30 = fArr2[i14];
                    float f31 = fArr2[i11];
                    float f32 = fArr2[i12];
                    f25 = f29;
                    f26 = f30;
                    f22 = f32;
                    f21 = f31;
                } else if (c6 != 'H') {
                    if (c6 != 'Q') {
                        z6 = z8;
                        if (c6 == 'V') {
                            z7 = z9;
                            c7 = c9;
                            c8 = c10;
                            i7 = i8;
                            path2.lineTo(f25, fArr2[i7]);
                            f8 = fArr2[i7];
                        } else if (c6 != 'a') {
                            if (c6 != 'c') {
                                z7 = z9;
                                if (c6 != 'h') {
                                    if (c6 != 'q') {
                                        c7 = c9;
                                        if (c6 != 'v') {
                                            if (c6 != 'L') {
                                                if (c6 != 'M') {
                                                    c8 = c10;
                                                    if (c6 == 'S') {
                                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                            f25 = (f25 * 2.0f) - f21;
                                                            f26 = (f26 * 2.0f) - f22;
                                                        }
                                                        float f33 = f25;
                                                        float f34 = f26;
                                                        int i15 = i8 + 1;
                                                        int i16 = i8 + 2;
                                                        int i17 = i8 + 3;
                                                        path2.cubicTo(f33, f34, fArr2[i8], fArr2[i15], fArr2[i16], fArr2[i17]);
                                                        f6 = fArr2[i8];
                                                        f7 = fArr2[i15];
                                                        f25 = fArr2[i16];
                                                        f26 = fArr2[i17];
                                                        i7 = i8;
                                                    } else if (c6 == 'T') {
                                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                            f25 = (f25 * 2.0f) - f21;
                                                            f26 = (f26 * 2.0f) - f22;
                                                        }
                                                        int i18 = i8 + 1;
                                                        path2.quadTo(f25, f26, fArr2[i8], fArr2[i18]);
                                                        float f35 = fArr2[i8];
                                                        f8 = fArr2[i18];
                                                        f21 = f25;
                                                        f22 = f26;
                                                        i7 = i8;
                                                        f25 = f35;
                                                    } else if (c6 == 'l') {
                                                        int i19 = i8 + 1;
                                                        path2.rLineTo(fArr2[i8], fArr2[i19]);
                                                        f25 += fArr2[i8];
                                                        f12 = fArr2[i19];
                                                    } else if (c6 == 'm') {
                                                        float f36 = fArr2[i8];
                                                        f25 += f36;
                                                        float f37 = fArr2[i8 + 1];
                                                        f26 += f37;
                                                        if (i8 > 0) {
                                                            path2.rLineTo(f36, f37);
                                                        } else {
                                                            path2.rMoveTo(f36, f37);
                                                            f27 = f25;
                                                        }
                                                    } else if (c6 == 's') {
                                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                            f15 = f26 - f22;
                                                            f16 = f25 - f21;
                                                        } else {
                                                            f16 = 0.0f;
                                                            f15 = 0.0f;
                                                        }
                                                        int i20 = i8 + 1;
                                                        int i21 = i8 + 2;
                                                        int i22 = i8 + 3;
                                                        path2.rCubicTo(f16, f15, fArr2[i8], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                        f9 = fArr2[i8] + f25;
                                                        f10 = fArr2[i20] + f26;
                                                        f25 += fArr2[i21];
                                                        f11 = fArr2[i22];
                                                    } else if (c6 == 't') {
                                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                            f17 = f25 - f21;
                                                            f18 = f26 - f22;
                                                        } else {
                                                            f18 = 0.0f;
                                                            f17 = 0.0f;
                                                        }
                                                        int i23 = i8 + 1;
                                                        path2.rQuadTo(f17, f18, fArr2[i8], fArr2[i23]);
                                                        float f38 = f17 + f25;
                                                        float f39 = f18 + f26;
                                                        f25 += fArr2[i8];
                                                        f26 += fArr2[i23];
                                                        f22 = f39;
                                                        f21 = f38;
                                                    }
                                                } else {
                                                    c8 = c10;
                                                    f13 = fArr2[i8];
                                                    f14 = fArr2[i8 + 1];
                                                    if (i8 > 0) {
                                                        path2.lineTo(f13, f14);
                                                    } else {
                                                        path2.moveTo(f13, f14);
                                                        f25 = f13;
                                                        f27 = f25;
                                                        f26 = f14;
                                                    }
                                                }
                                                f28 = f26;
                                            } else {
                                                c8 = c10;
                                                int i24 = i8 + 1;
                                                path2.lineTo(fArr2[i8], fArr2[i24]);
                                                f13 = fArr2[i8];
                                                f14 = fArr2[i24];
                                            }
                                            f25 = f13;
                                            f26 = f14;
                                        } else {
                                            c8 = c10;
                                            path2.rLineTo(0.0f, fArr2[i8]);
                                            f12 = fArr2[i8];
                                        }
                                        f26 += f12;
                                    } else {
                                        c7 = c9;
                                        c8 = c10;
                                        int i25 = i8 + 1;
                                        int i26 = i8 + 2;
                                        int i27 = i8 + 3;
                                        path2.rQuadTo(fArr2[i8], fArr2[i25], fArr2[i26], fArr2[i27]);
                                        f9 = fArr2[i8] + f25;
                                        f10 = fArr2[i25] + f26;
                                        f25 += fArr2[i26];
                                        f11 = fArr2[i27];
                                    }
                                    f26 += f11;
                                    f21 = f9;
                                    f22 = f10;
                                } else {
                                    c7 = c9;
                                    c8 = c10;
                                    path2.rLineTo(fArr2[i8], 0.0f);
                                    f25 += fArr2[i8];
                                }
                            } else {
                                z7 = z9;
                                c7 = c9;
                                c8 = c10;
                                int i28 = i8 + 2;
                                int i29 = i8 + 3;
                                int i30 = i8 + 4;
                                int i31 = i8 + 5;
                                path2.rCubicTo(fArr2[i8], fArr2[i8 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                                float f40 = fArr2[i28] + f25;
                                float f41 = fArr2[i29] + f26;
                                f25 += fArr2[i30];
                                f26 += fArr2[i31];
                                f21 = f40;
                                f22 = f41;
                            }
                            i7 = i8;
                        } else {
                            z7 = z9;
                            c7 = c9;
                            c8 = c10;
                            int i32 = i8 + 5;
                            int i33 = i8 + 6;
                            i7 = i8;
                            float f42 = f25;
                            drawArc(path, f42, f26, fArr2[i32] + f25, fArr2[i33] + f26, fArr2[i8], fArr2[i8 + 1], fArr2[i8 + 2], fArr2[i8 + 3] != 0.0f ? z7 : z6, fArr2[i8 + 4] != 0 ? z7 : z6);
                            f25 = f42 + fArr2[i32];
                            f26 += fArr2[i33];
                            f21 = f25;
                            f22 = f26;
                        }
                        f26 = f8;
                    } else {
                        z6 = z8;
                        z7 = z9;
                        c7 = c9;
                        c8 = c10;
                        i7 = i8;
                        int i34 = i7 + 1;
                        int i35 = i7 + 2;
                        int i36 = i7 + 3;
                        path2.quadTo(fArr2[i7], fArr2[i34], fArr2[i35], fArr2[i36]);
                        f6 = fArr2[i7];
                        f7 = fArr2[i34];
                        f25 = fArr2[i35];
                        f26 = fArr2[i36];
                    }
                    f21 = f6;
                    f22 = f7;
                } else {
                    z6 = z8;
                    z7 = z9;
                    c7 = c9;
                    c8 = c10;
                    i7 = i8;
                    path2.lineTo(fArr2[i7], f26);
                    f25 = fArr2[i7];
                }
                i8 = i7 + i6;
                path2 = path;
                c11 = c6;
                z8 = z6;
                z9 = z7;
                c9 = c7;
                c10 = c8;
            }
            fArr[z8 ? 1 : 0] = f25;
            fArr[z9 ? 1 : 0] = f26;
            fArr[c9] = f21;
            fArr[c10] = f22;
            fArr[4] = f27;
            fArr[5] = f28;
        }

        private static void arcToBezier(Path path, double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
            int iCeil = (int) Math.ceil(Math.abs((d13 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d11);
            double dSin = Math.sin(d11);
            double dCos2 = Math.cos(d12);
            double dSin2 = Math.sin(d12);
            double d14 = d7;
            double d15 = -d14;
            double d16 = d15 * dCos;
            double d17 = d8 * dSin;
            double d18 = (d16 * dSin2) - (d17 * dCos2);
            double d19 = d15 * dSin;
            double d20 = d8 * dCos;
            double d21 = (dCos2 * d20) + (dSin2 * d19);
            double d22 = d13 / ((double) iCeil);
            double d23 = d21;
            double d24 = d18;
            int i5 = 0;
            double d25 = d9;
            double d26 = d10;
            double d27 = d12;
            while (i5 < iCeil) {
                double d28 = d27 + d22;
                double dSin3 = Math.sin(d28);
                double dCos3 = Math.cos(d28);
                double d29 = dCos;
                double dC = a.C(d14, d29, dCos3, d) - (d17 * dSin3);
                double d30 = dSin;
                double dC2 = (d20 * dSin3) + a.C(d7, d30, dCos3, d6);
                double d31 = (d16 * dSin3) - (d17 * dCos3);
                double d32 = (dCos3 * d20) + (dSin3 * d19);
                double d33 = d28 - d27;
                double dTan = Math.tan(d33 / 2.0d);
                double dSqrt = ((Math.sqrt(a.C(dTan, 3.0d, dTan, 4.0d)) - 1.0d) * Math.sin(d33)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d24 * dSqrt) + d25), (float) ((d23 * dSqrt) + d26), (float) (dC - (dSqrt * d31)), (float) (dC2 - (dSqrt * d32)), (float) dC, (float) dC2);
                i5++;
                d14 = d7;
                d22 = d22;
                d25 = dC;
                iCeil = iCeil;
                d19 = d19;
                d27 = d28;
                d23 = d32;
                d24 = d31;
                dCos = d29;
                d26 = dC2;
                dSin = d30;
            }
        }

        private static void drawArc(Path path, float f6, float f7, float f8, float f9, float f10, float f11, float f12, boolean z6, boolean z7) {
            double d;
            double d6;
            double radians = Math.toRadians(f12);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d7 = f6;
            double d8 = f7;
            double d9 = f10;
            double d10 = ((d8 * dSin) + (d7 * dCos)) / d9;
            double d11 = f11;
            double d12 = ((d8 * dCos) + (((double) (-f6)) * dSin)) / d11;
            double d13 = f9;
            double D6 = a.D(d13, dSin, ((double) f8) * dCos, d9);
            double D7 = a.D(d13, dCos, ((double) (-f8)) * dSin, d11);
            double d14 = d10 - D6;
            double d15 = d12 - D7;
            double d16 = (d10 + D6) / 2.0d;
            double d17 = (d12 + D7) / 2.0d;
            double d18 = (d15 * d15) + (d14 * d14);
            if (d18 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d18);
                float fSqrt = (float) (Math.sqrt(d18) / 1.99999d);
                drawArc(path, f6, f7, f8, f9, f10 * fSqrt, fSqrt * f11, f12, z6, z7);
                return;
            }
            double dSqrt = Math.sqrt(d19);
            double d20 = d14 * dSqrt;
            double d21 = dSqrt * d15;
            if (z6 == z7) {
                d = d16 - d21;
                d6 = d17 + d20;
            } else {
                d = d16 + d21;
                d6 = d17 - d20;
            }
            double dAtan2 = Math.atan2(d12 - d6, d10 - d);
            double dAtan3 = Math.atan2(D7 - d6, D6 - d) - dAtan2;
            if (z7 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d22 = d * d9;
            double d23 = d6 * d11;
            arcToBezier(path, (d22 * dCos) - (d23 * dSin), (d23 * dCos) + (d22 * dSin), d9, d11, d7, d8, radians, dAtan2, dAtan3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f6) {
            this.mType = pathDataNode.mType;
            int i5 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i5 >= fArr.length) {
                    return;
                }
                this.mParams[i5] = (pathDataNode2.mParams[i5] * f6) + ((1.0f - f6) * fArr[i5]);
                i5++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f6) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i5 = 0; i5 < pathDataNodeArr.length; i5++) {
                pathDataNodeArr[i5].interpolatePathDataNode(pathDataNodeArr2[i5], pathDataNodeArr3[i5], f6);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}

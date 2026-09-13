package org.apache.commons.compress.harmony.pack200;

import androidx.collection.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CodecEncoding {
    private static final BHSDCodec[] canonicalCodec = {null, new BHSDCodec(1, 256), new BHSDCodec(1, 256, 1), new BHSDCodec(1, 256, 0, 1), new BHSDCodec(1, 256, 1, 1), new BHSDCodec(2, 256), new BHSDCodec(2, 256, 1), new BHSDCodec(2, 256, 0, 1), new BHSDCodec(2, 256, 1, 1), new BHSDCodec(3, 256), new BHSDCodec(3, 256, 1), new BHSDCodec(3, 256, 0, 1), new BHSDCodec(3, 256, 1, 1), new BHSDCodec(4, 256), new BHSDCodec(4, 256, 1), new BHSDCodec(4, 256, 0, 1), new BHSDCodec(4, 256, 1, 1), new BHSDCodec(5, 4), new BHSDCodec(5, 4, 1), new BHSDCodec(5, 4, 2), new BHSDCodec(5, 16), new BHSDCodec(5, 16, 1), new BHSDCodec(5, 16, 2), new BHSDCodec(5, 32), new BHSDCodec(5, 32, 1), new BHSDCodec(5, 32, 2), new BHSDCodec(5, 64), new BHSDCodec(5, 64, 1), new BHSDCodec(5, 64, 2), new BHSDCodec(5, 128), new BHSDCodec(5, 128, 1), new BHSDCodec(5, 128, 2), new BHSDCodec(5, 4, 0, 1), new BHSDCodec(5, 4, 1, 1), new BHSDCodec(5, 4, 2, 1), new BHSDCodec(5, 16, 0, 1), new BHSDCodec(5, 16, 1, 1), new BHSDCodec(5, 16, 2, 1), new BHSDCodec(5, 32, 0, 1), new BHSDCodec(5, 32, 1, 1), new BHSDCodec(5, 32, 2, 1), new BHSDCodec(5, 64, 0, 1), new BHSDCodec(5, 64, 1, 1), new BHSDCodec(5, 64, 2, 1), new BHSDCodec(5, 128, 0, 1), new BHSDCodec(5, 128, 1, 1), new BHSDCodec(5, 128, 2, 1), new BHSDCodec(2, 192), new BHSDCodec(2, 224), new BHSDCodec(2, 240), new BHSDCodec(2, 248), new BHSDCodec(2, 252), new BHSDCodec(2, 8, 0, 1), new BHSDCodec(2, 8, 1, 1), new BHSDCodec(2, 16, 0, 1), new BHSDCodec(2, 16, 1, 1), new BHSDCodec(2, 32, 0, 1), new BHSDCodec(2, 32, 1, 1), new BHSDCodec(2, 64, 0, 1), new BHSDCodec(2, 64, 1, 1), new BHSDCodec(2, 128, 0, 1), new BHSDCodec(2, 128, 1, 1), new BHSDCodec(2, 192, 0, 1), new BHSDCodec(2, 192, 1, 1), new BHSDCodec(2, 224, 0, 1), new BHSDCodec(2, 224, 1, 1), new BHSDCodec(2, 240, 0, 1), new BHSDCodec(2, 240, 1, 1), new BHSDCodec(2, 248, 0, 1), new BHSDCodec(2, 248, 1, 1), new BHSDCodec(3, 192), new BHSDCodec(3, 224), new BHSDCodec(3, 240), new BHSDCodec(3, 248), new BHSDCodec(3, 252), new BHSDCodec(3, 8, 0, 1), new BHSDCodec(3, 8, 1, 1), new BHSDCodec(3, 16, 0, 1), new BHSDCodec(3, 16, 1, 1), new BHSDCodec(3, 32, 0, 1), new BHSDCodec(3, 32, 1, 1), new BHSDCodec(3, 64, 0, 1), new BHSDCodec(3, 64, 1, 1), new BHSDCodec(3, 128, 0, 1), new BHSDCodec(3, 128, 1, 1), new BHSDCodec(3, 192, 0, 1), new BHSDCodec(3, 192, 1, 1), new BHSDCodec(3, 224, 0, 1), new BHSDCodec(3, 224, 1, 1), new BHSDCodec(3, 240, 0, 1), new BHSDCodec(3, 240, 1, 1), new BHSDCodec(3, 248, 0, 1), new BHSDCodec(3, 248, 1, 1), new BHSDCodec(4, 192), new BHSDCodec(4, 224), new BHSDCodec(4, 240), new BHSDCodec(4, 248), new BHSDCodec(4, 252), new BHSDCodec(4, 8, 0, 1), new BHSDCodec(4, 8, 1, 1), new BHSDCodec(4, 16, 0, 1), new BHSDCodec(4, 16, 1, 1), new BHSDCodec(4, 32, 0, 1), new BHSDCodec(4, 32, 1, 1), new BHSDCodec(4, 64, 0, 1), new BHSDCodec(4, 64, 1, 1), new BHSDCodec(4, 128, 0, 1), new BHSDCodec(4, 128, 1, 1), new BHSDCodec(4, 192, 0, 1), new BHSDCodec(4, 192, 1, 1), new BHSDCodec(4, 224, 0, 1), new BHSDCodec(4, 224, 1, 1), new BHSDCodec(4, 240, 0, 1), new BHSDCodec(4, 240, 1, 1), new BHSDCodec(4, 248, 0, 1), new BHSDCodec(4, 248, 1, 1)};
    private static Map canonicalCodecsToSpecifiers;

    public static BHSDCodec getCanonicalCodec(int i5) {
        return canonicalCodec[i5];
    }

    public static Codec getCodec(int i5, InputStream inputStream, Codec codec) throws Pack200Exception, IOException {
        BHSDCodec[] bHSDCodecArr = canonicalCodec;
        if (bHSDCodecArr.length != 116) {
            throw new Error("Canonical encodings have been incorrectly modified");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Encoding cannot be less than zero");
        }
        if (i5 == 0) {
            return codec;
        }
        if (i5 <= 115) {
            return bHSDCodecArr[i5];
        }
        if (i5 == 116) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                throw new EOFException("End of buffer read whilst trying to decode codec");
            }
            int i7 = i6 & 1;
            int i8 = (i6 >> 1) & 3;
            int i9 = ((i6 >> 3) & 7) + 1;
            int i10 = inputStream.read();
            if (i10 != -1) {
                return new BHSDCodec(i9, i10 + 1, i8, i7);
            }
            throw new EOFException("End of buffer read whilst trying to decode codec");
        }
        if (i5 >= 117 && i5 <= 140) {
            int i11 = i5 - 117;
            int i12 = i11 & 3;
            boolean z6 = ((i11 >> 2) & 1) == 1;
            boolean z7 = ((i11 >> 3) & 1) == 1;
            boolean z8 = ((i11 >> 4) & 1) == 1;
            if (z7 && z8) {
                throw new Pack200Exception("ADef and BDef should never both be true");
            }
            int iPow = ((z6 ? inputStream.read() : 3) + 1) * ((int) Math.pow(16.0d, i12));
            Codec codec2 = z7 ? codec : getCodec(inputStream.read(), inputStream, codec);
            if (!z8) {
                codec = getCodec(inputStream.read(), inputStream, codec);
            }
            return new RunCodec(iPow, codec2, codec);
        }
        if (i5 < 141 || i5 > 188) {
            throw new Pack200Exception(a.i(i5, "Invalid codec encoding byte (", ") found"));
        }
        int i13 = i5 - 141;
        boolean z9 = (i13 & 1) == 1;
        boolean z10 = ((i13 >> 1) & 1) == 1;
        int i14 = i13 >> 2;
        boolean z11 = i14 != 0;
        int i15 = new int[]{0, 4, 8, 16, 32, 64, 128, 192, 224, 240, 248, 252}[i14];
        if (z11) {
            Codec codec3 = z9 ? codec : getCodec(inputStream.read(), inputStream, codec);
            if (!z10) {
                codec = getCodec(inputStream.read(), inputStream, codec);
            }
            return new PopulationCodec(codec3, i15, codec);
        }
        Codec codec4 = z9 ? codec : getCodec(inputStream.read(), inputStream, codec);
        Codec codec5 = getCodec(inputStream.read(), inputStream, codec);
        if (!z10) {
            codec = getCodec(inputStream.read(), inputStream, codec);
        }
        return new PopulationCodec(codec4, codec5, codec);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0130  */
    public static int[] getSpecifier(Codec codec, Codec codec2) {
        int iBinarySearch;
        int i5;
        int i6;
        int i7 = 0;
        if (canonicalCodecsToSpecifiers == null) {
            HashMap map = new HashMap(canonicalCodec.length);
            int i8 = 0;
            while (true) {
                BHSDCodec[] bHSDCodecArr = canonicalCodec;
                if (i8 >= bHSDCodecArr.length) {
                    break;
                }
                map.put(bHSDCodecArr[i8], Integer.valueOf(i8));
                i8++;
            }
            canonicalCodecsToSpecifiers = map;
        }
        if (canonicalCodecsToSpecifiers.containsKey(codec)) {
            return new int[]{((Integer) canonicalCodecsToSpecifiers.get(codec)).intValue()};
        }
        int i9 = 2;
        if (codec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) codec;
            return new int[]{116, ((bHSDCodec.getB() - 1) * 8) + (bHSDCodec.getS() * 2) + (bHSDCodec.isDelta() ? 1 : 0), bHSDCodec.getH() - 1};
        }
        if (codec instanceof RunCodec) {
            RunCodec runCodec = (RunCodec) codec;
            int k6 = runCodec.getK();
            if (k6 <= 256) {
                i5 = k6 - 1;
                i6 = 0;
            } else if (k6 <= 4096) {
                i5 = (k6 / 16) - 1;
                i6 = 1;
            } else if (k6 <= 65536) {
                i5 = (k6 / 256) - 1;
                i6 = 2;
            } else {
                i5 = (k6 / 4096) - 1;
                i6 = 3;
            }
            Codec aCodec = runCodec.getACodec();
            Codec bCodec = runCodec.getBCodec();
            int i10 = aCodec.equals(codec2) ? 1 : bCodec.equals(codec2) ? 2 : 0;
            int i11 = (i10 * 8) + i6 + 117 + (i5 == 3 ? 0 : 4);
            int[] specifier = i10 == 1 ? new int[0] : getSpecifier(aCodec, codec2);
            int[] specifier2 = i10 == 2 ? new int[0] : getSpecifier(bCodec, codec2);
            int[] iArr = new int[(i5 == 3 ? 0 : 1) + 1 + specifier.length + specifier2.length];
            iArr[0] = i11;
            if (i5 != 3) {
                iArr[1] = i5;
            } else {
                i9 = 1;
            }
            for (int i12 : specifier) {
                iArr[i9] = i12;
                i9++;
            }
            while (i7 < specifier2.length) {
                iArr[i9] = specifier2[i7];
                i9++;
                i7++;
            }
            return iArr;
        }
        if (!(codec instanceof PopulationCodec)) {
            return null;
        }
        PopulationCodec populationCodec = (PopulationCodec) codec;
        Codec tokenCodec = populationCodec.getTokenCodec();
        Codec favouredCodec = populationCodec.getFavouredCodec();
        Codec unfavouredCodec = populationCodec.getUnfavouredCodec();
        boolean zEquals = favouredCodec.equals(codec2);
        boolean zEquals2 = unfavouredCodec.equals(codec2);
        if (populationCodec.getFavoured() == null) {
            iBinarySearch = 0;
        } else if (tokenCodec == Codec.BYTE1) {
            iBinarySearch = 1;
        } else if (tokenCodec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec2 = (BHSDCodec) tokenCodec;
            if (bHSDCodec2.getS() != 0 || (iBinarySearch = Arrays.binarySearch(new int[]{4, 8, 16, 32, 64, 128, 192, 224, 240, 248, 252}, 256 - bHSDCodec2.getH())) == -1) {
                iBinarySearch = 0;
            }
        } else {
            iBinarySearch = 0;
        }
        int i13 = (iBinarySearch * 4) + ((zEquals2 ? 1 : 0) * 2) + (zEquals ? 1 : 0) + 141;
        int[] specifier3 = zEquals ? new int[0] : getSpecifier(favouredCodec, codec2);
        int[] specifier4 = iBinarySearch != 0 ? new int[0] : getSpecifier(tokenCodec, codec2);
        int[] specifier5 = zEquals2 ? new int[0] : getSpecifier(unfavouredCodec, codec2);
        int[] iArr2 = new int[specifier3.length + 1 + specifier5.length + specifier4.length];
        iArr2[0] = i13;
        int i14 = 1;
        for (int i15 : specifier3) {
            iArr2[i14] = i15;
            i14++;
        }
        for (int i16 : specifier4) {
            iArr2[i14] = i16;
            i14++;
        }
        while (i7 < specifier5.length) {
            iArr2[i14] = specifier5[i7];
            i14++;
            i7++;
        }
        return iArr2;
    }

    public static int getSpecifierForDefaultCodec(BHSDCodec bHSDCodec) {
        return getSpecifier(bHSDCodec, null)[0];
    }
}

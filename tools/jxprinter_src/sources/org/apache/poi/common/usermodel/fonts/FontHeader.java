package org.apache.poi.common.usermodel.fonts;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FontHeader implements FontInfo, GenericRecord {
    private static final int[] FLAGS_MASKS = {1, 4, 16, 32, 64, 128, 268435456};
    private static final String[] FLAGS_NAMES = {"SUBSET", "TTCOMPRESSED", "FAILIFVARIATIONSIMULATED", "EMBEDEUDC", "VALIDATIONTESTS", "WEBOBJECT", "XORENCRYPTDATA"};
    private static final int[] FSTYPE_MASKS = {0, 2, 4, 8, 256, 512};
    private static final String[] FSTYPE_NAMES = {"INSTALLABLE_EMBEDDING", "RESTRICTED_LICENSE_EMBEDDING", "PREVIEW_PRINT_EMBEDDING", "EDITABLE_EMBEDDING", "NO_SUBSETTING", "BITMAP_EMBEDDING_ONLY"};
    public static final int REGULAR_WEIGHT = 400;
    private byte charset;
    private int checkSumAdjustment;
    private int codePageRange1;
    private int codePageRange2;
    private int eotSize;
    private String familyName;
    private int flags;
    private int fontDataSize;
    private int fsType;
    private String fullName;
    private byte italic;
    private int magic;
    private final byte[] panose = new byte[10];
    private String styleName;
    private int unicodeRange1;
    private int unicodeRange2;
    private int unicodeRange3;
    private int unicodeRange4;
    private int version;
    private String versionName;
    private int weight;

    /* JADX INFO: renamed from: org.apache.poi.common.usermodel.fonts.FontHeader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif;

        static {
            int[] iArr = new int[PanoseSerif.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif = iArr;
            try {
                iArr[PanoseSerif.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.NORMAL_SANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.OBTUSE_SANS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.PERP_SANS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.FLARED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[PanoseSerif.ROUNDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[PanoseFamily.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily = iArr2;
            try {
                iArr2[PanoseFamily.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.NO_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.TEXT_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.DECORATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.SCRIPT.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[PanoseFamily.PICTORIAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseArmStyle {
        ANY,
        NO_FIT,
        STRAIGHT_ARMS_HORZ,
        STRAIGHT_ARMS_WEDGE,
        STRAIGHT_ARMS_VERT,
        STRAIGHT_ARMS_SINGLE_SERIF,
        STRAIGHT_ARMS_DOUBLE_SERIF,
        BENT_ARMS_HORZ,
        BENT_ARMS_WEDGE,
        BENT_ARMS_VERT,
        BENT_ARMS_SINGLE_SERIF,
        BENT_ARMS_DOUBLE_SERIF
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseContrast {
        ANY,
        NO_FIT,
        NONE,
        VERY_LOW,
        LOW,
        MEDIUM_LOW,
        MEDIUM,
        MEDIUM_HIGH,
        HIGH,
        VERY_HIGH
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseFamily {
        ANY,
        NO_FIT,
        TEXT_DISPLAY,
        SCRIPT,
        DECORATIVE,
        PICTORIAL
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseLetterForm {
        ANY,
        NO_FIT,
        NORMAL_CONTACT,
        NORMAL_WEIGHTED,
        NORMAL_BOXED,
        NORMAL_FLATTENED,
        NORMAL_ROUNDED,
        NORMAL_OFF_CENTER,
        NORMAL_SQUARE,
        OBLIQUE_CONTACT,
        OBLIQUE_WEIGHTED,
        OBLIQUE_BOXED,
        OBLIQUE_FLATTENED,
        OBLIQUE_ROUNDED,
        OBLIQUE_OFF_CENTER,
        OBLIQUE_SQUARE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseMidLine {
        ANY,
        NO_FIT,
        STANDARD_TRIMMED,
        STANDARD_POINTED,
        STANDARD_SERIFED,
        HIGH_TRIMMED,
        HIGH_POINTED,
        HIGH_SERIFED,
        CONSTANT_TRIMMED,
        CONSTANT_POINTED,
        CONSTANT_SERIFED,
        LOW_TRIMMED,
        LOW_POINTED,
        LOW_SERIFED
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseProportion {
        ANY,
        NO_FIT,
        OLD_STYLE,
        MODERN,
        EVEN_WIDTH,
        EXPANDED,
        CONDENSED,
        VERY_EXPANDED,
        VERY_CONDENSED,
        MONOSPACED
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseSerif {
        ANY,
        NO_FIT,
        COVE,
        OBTUSE_COVE,
        SQUARE_COVE,
        OBTUSE_SQUARE_COVE,
        SQUARE,
        THIN,
        BONE,
        EXAGGERATED,
        TRIANGLE,
        NORMAL_SANS,
        OBTUSE_SANS,
        PERP_SANS,
        FLARED,
        ROUNDED
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseStroke {
        ANY,
        NO_FIT,
        GRADUAL_DIAG,
        GRADUAL_TRAN,
        GRADUAL_VERT,
        GRADUAL_HORZ,
        RAPID_VERT,
        RAPID_HORZ,
        INSTANT_VERT
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseWeight {
        ANY,
        NO_FIT,
        VERY_LIGHT,
        LIGHT,
        THIN,
        BOOK,
        MEDIUM,
        DEMI,
        BOLD,
        HEAVY,
        BLACK,
        NORD
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PanoseXHeight {
        ANY,
        NO_FIT,
        CONSTANT_SMALL,
        CONSTANT_STD,
        CONSTANT_LARGE,
        DUCKING_SMALL,
        DUCKING_STD,
        DUCKING_LARGE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.eotSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.fontDataSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$10() {
        return Integer.valueOf(this.checkSumAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this.version);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$3() {
        return Integer.valueOf(this.fsType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return Integer.valueOf(this.unicodeRange1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return Integer.valueOf(this.unicodeRange2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$6() {
        return Integer.valueOf(this.unicodeRange3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$7() {
        return Integer.valueOf(this.unicodeRange4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$8() {
        return Integer.valueOf(this.codePageRange1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$9() {
        return Integer.valueOf(this.codePageRange2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseArmStyle$17() {
        return Byte.valueOf(this.panose[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseContrast$15() {
        return Byte.valueOf(this.panose[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseFamily$11() {
        return Byte.valueOf(this.panose[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseLetterForm$18() {
        return Byte.valueOf(this.panose[7]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseMidLine$19() {
        return Byte.valueOf(this.panose[8]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseProportion$14() {
        return Byte.valueOf(this.panose[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseSerif$12() {
        return Byte.valueOf(this.panose[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseStroke$16() {
        return Byte.valueOf(this.panose[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseWeight$13() {
        return Byte.valueOf(this.panose[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getPanoseXHeight$20() {
        return Byte.valueOf(this.panose[9]);
    }

    private String readName(LittleEndianInput littleEndianInput) {
        littleEndianInput.readShort();
        int uShort = littleEndianInput.readUShort();
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(uShort, 1000);
        littleEndianInput.readFully(bArrSafelyAllocate);
        return new String(bArrSafelyAllocate, 0, uShort, StandardCharsets.UTF_16LE).trim();
    }

    public InputStream bufferInit(InputStream inputStream) {
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(inputStream);
        littleEndianInputStream.mark(1000);
        init(littleEndianInputStream);
        littleEndianInputStream.reset();
        return littleEndianInputStream;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return FontCharset.valueOf(getCharsetByte());
    }

    public byte getCharsetByte() {
        return this.charset;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[getPanoseFamily().ordinal()];
        if (i5 == 1 || i5 == 2) {
            return FontFamily.FF_DONTCARE;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                return i5 != 6 ? FontFamily.FF_DECORATIVE : FontFamily.FF_MODERN;
            }
            return FontFamily.FF_SCRIPT;
        }
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseSerif[getPanoseSerif().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return FontFamily.FF_SWISS;
            default:
                return FontFamily.FF_ROMAN;
        }
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public int getFlags() {
        return this.flags;
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("eotSize", new a(this, 1));
        linkedHashMap.put("fontDataSize", new a(this, 13));
        linkedHashMap.put("version", new a(this, 24));
        linkedHashMap.put("flags", GenericRecordUtil.getBitsAsString(new a(this, 25), FLAGS_MASKS, FLAGS_NAMES));
        linkedHashMap.put("panose.familyType", new a(this, 26));
        linkedHashMap.put("panose.serifType", new a(this, 27));
        linkedHashMap.put("panose.weight", new a(this, 28));
        linkedHashMap.put("panose.proportion", new a(this, 29));
        linkedHashMap.put("panose.contrast", new b(this, 0));
        linkedHashMap.put("panose.stroke", new b(this, 1));
        linkedHashMap.put("panose.armStyle", new a(this, 2));
        linkedHashMap.put("panose.letterForm", new a(this, 3));
        linkedHashMap.put("panose.midLine", new a(this, 4));
        linkedHashMap.put("panose.xHeight", new a(this, 5));
        linkedHashMap.put("charset", new a(this, 6));
        linkedHashMap.put("italic", new a(this, 7));
        linkedHashMap.put("weight", new a(this, 8));
        linkedHashMap.put("fsType", GenericRecordUtil.getBitsAsString(new a(this, 9), FSTYPE_MASKS, FSTYPE_NAMES));
        linkedHashMap.put("unicodeRange1", new a(this, 10));
        linkedHashMap.put("unicodeRange2", new a(this, 12));
        linkedHashMap.put("unicodeRange3", new a(this, 14));
        linkedHashMap.put("unicodeRange4", new a(this, 15));
        linkedHashMap.put("codePageRange1", new a(this, 16));
        linkedHashMap.put("codePageRange2", new a(this, 17));
        linkedHashMap.put("checkSumAdjustment", new a(this, 18));
        linkedHashMap.put("familyName", new a(this, 19));
        linkedHashMap.put("styleName", new a(this, 20));
        linkedHashMap.put("versionName", new a(this, 21));
        linkedHashMap.put("fullName", new a(this, 23));
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public byte[] getPanose() {
        return this.panose;
    }

    public PanoseArmStyle getPanoseArmStyle() {
        return (PanoseArmStyle) GenericRecordUtil.safeEnum(PanoseArmStyle.values(), new b(this, 4)).get();
    }

    public PanoseContrast getPanoseContrast() {
        return (PanoseContrast) GenericRecordUtil.safeEnum(PanoseContrast.values(), new b(this, 2)).get();
    }

    public PanoseFamily getPanoseFamily() {
        return (PanoseFamily) GenericRecordUtil.safeEnum(PanoseFamily.values(), new b(this, 7)).get();
    }

    public PanoseLetterForm getPanoseLetterForm() {
        return (PanoseLetterForm) GenericRecordUtil.safeEnum(PanoseLetterForm.values(), new a(this, 0)).get();
    }

    public PanoseMidLine getPanoseMidLine() {
        return (PanoseMidLine) GenericRecordUtil.safeEnum(PanoseMidLine.values(), new a(this, 22)).get();
    }

    public PanoseProportion getPanoseProportion() {
        return (PanoseProportion) GenericRecordUtil.safeEnum(PanoseProportion.values(), new b(this, 8)).get();
    }

    public PanoseSerif getPanoseSerif() {
        return (PanoseSerif) GenericRecordUtil.safeEnum(PanoseSerif.values(), new b(this, 5)).get();
    }

    public PanoseStroke getPanoseStroke() {
        return (PanoseStroke) GenericRecordUtil.safeEnum(PanoseStroke.values(), new a(this, 11)).get();
    }

    public PanoseWeight getPanoseWeight() {
        return (PanoseWeight) GenericRecordUtil.safeEnum(PanoseWeight.values(), new b(this, 3)).get();
    }

    public PanoseXHeight getPanoseXHeight() {
        return (PanoseXHeight) GenericRecordUtil.safeEnum(PanoseXHeight.values(), new b(this, 6)).get();
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontHeader$PanoseFamily[getPanoseFamily().ordinal()];
        if (i5 == 3 || i5 == 4) {
            return getPanoseProportion() == PanoseProportion.MONOSPACED ? FontPitch.FIXED : FontPitch.VARIABLE;
        }
        if (i5 == 5 || i5 == 6) {
            return getPanoseProportion() == PanoseProportion.MODERN ? FontPitch.FIXED : FontPitch.VARIABLE;
        }
        return FontPitch.VARIABLE;
    }

    public String getStyleName() {
        return this.styleName;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return getFamilyName();
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getWeight() {
        return this.weight;
    }

    public void init(byte[] bArr, int i5, int i6) {
        init(new LittleEndianByteArrayInputStream(bArr, i5, i6));
    }

    public boolean isBold() {
        return getWeight() > 400;
    }

    public boolean isItalic() {
        return this.italic != 0;
    }

    public void init(LittleEndianInput littleEndianInput) {
        this.eotSize = littleEndianInput.readInt();
        this.fontDataSize = littleEndianInput.readInt();
        int i5 = littleEndianInput.readInt();
        this.version = i5;
        if (i5 != 65536 && i5 != 131073 && i5 != 131074) {
            throw new RuntimeException("not a EOT font data stream");
        }
        this.flags = littleEndianInput.readInt();
        littleEndianInput.readFully(this.panose);
        this.charset = littleEndianInput.readByte();
        this.italic = littleEndianInput.readByte();
        this.weight = littleEndianInput.readInt();
        this.fsType = littleEndianInput.readUShort();
        int uShort = littleEndianInput.readUShort();
        this.magic = uShort;
        if (uShort != 20556) {
            throw new RuntimeException("not a EOT font data stream");
        }
        this.unicodeRange1 = littleEndianInput.readInt();
        this.unicodeRange2 = littleEndianInput.readInt();
        this.unicodeRange3 = littleEndianInput.readInt();
        this.unicodeRange4 = littleEndianInput.readInt();
        this.codePageRange1 = littleEndianInput.readInt();
        this.codePageRange2 = littleEndianInput.readInt();
        this.checkSumAdjustment = littleEndianInput.readInt();
        littleEndianInput.readInt();
        littleEndianInput.readInt();
        littleEndianInput.readInt();
        littleEndianInput.readInt();
        this.familyName = readName(littleEndianInput);
        this.styleName = readName(littleEndianInput);
        this.versionName = readName(littleEndianInput);
        this.fullName = readName(littleEndianInput);
    }
}

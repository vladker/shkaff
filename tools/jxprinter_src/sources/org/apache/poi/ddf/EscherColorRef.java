package org.apache.poi.ddf;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherColorRef {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int colorRef;
    private int opid;
    private static final BitField FLAG_SYS_INDEX = new BitField(268435456);
    private static final BitField FLAG_SCHEME_INDEX = new BitField(134217728);
    private static final BitField FLAG_SYSTEM_RGB = new BitField(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    private static final BitField FLAG_PALETTE_RGB = new BitField(33554432);
    private static final BitField FLAG_PALETTE_INDEX = new BitField(16777216);
    private static final BitField FLAG_BLUE = new BitField(16711680);
    private static final BitField FLAG_GREEN = new BitField(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    private static final BitField FLAG_RED = new BitField(255);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum SysIndexProcedure {
        DARKEN_COLOR(1),
        LIGHTEN_COLOR(2),
        ADD_GRAY_LEVEL(3),
        SUB_GRAY_LEVEL(4),
        REVERSE_GRAY_LEVEL(5),
        THRESHOLD(6),
        INVERT_AFTER(32),
        INVERT_HIGHBIT_AFTER(64);

        private BitField mask;

        SysIndexProcedure(int i5) {
            this.mask = new BitField(i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum SysIndexSource {
        FILL_COLOR(240),
        LINE_OR_FILL_COLOR(241),
        LINE_COLOR(242),
        SHADOW_COLOR(243),
        CURRENT_OR_LAST_COLOR(244),
        FILL_BACKGROUND_COLOR(245),
        LINE_BACKGROUND_COLOR(246),
        FILL_OR_LINE_COLOR(247);

        private int value;

        SysIndexSource(int i5) {
            this.value = i5;
        }
    }

    public EscherColorRef(int i5) {
        this.opid = -1;
        this.colorRef = i5;
    }

    private int getIndex() {
        return (FLAG_GREEN.getValue(this.colorRef) << 8) | FLAG_RED.getValue(this.colorRef);
    }

    public int getPaletteIndex() {
        if (hasPaletteIndexFlag()) {
            return getIndex();
        }
        return -1;
    }

    public int[] getRGB() {
        return new int[]{FLAG_RED.getValue(this.colorRef), FLAG_GREEN.getValue(this.colorRef), FLAG_BLUE.getValue(this.colorRef)};
    }

    public int getSchemeIndex() {
        if (hasSchemeIndexFlag()) {
            return FLAG_RED.getValue(this.colorRef);
        }
        return -1;
    }

    public int getSysIndex() {
        if (hasSysIndexFlag()) {
            return getIndex();
        }
        return -1;
    }

    public int getSysIndexInvert() {
        if (!hasSysIndexFlag()) {
            return 0;
        }
        int value = FLAG_GREEN.getValue(this.colorRef);
        if (SysIndexProcedure.INVERT_AFTER.mask.isSet(value)) {
            return 1;
        }
        return SysIndexProcedure.INVERT_HIGHBIT_AFTER.mask.isSet(value) ? 2 : 0;
    }

    public SysIndexProcedure getSysIndexProcedure() {
        if (!hasSysIndexFlag()) {
            return null;
        }
        int value = FLAG_GREEN.getValue(this.colorRef);
        for (SysIndexProcedure sysIndexProcedure : SysIndexProcedure.values()) {
            if (sysIndexProcedure != SysIndexProcedure.INVERT_AFTER && sysIndexProcedure != SysIndexProcedure.INVERT_HIGHBIT_AFTER && sysIndexProcedure.mask.isSet(value)) {
                return sysIndexProcedure;
            }
        }
        return null;
    }

    public SysIndexSource getSysIndexSource() {
        if (!hasSysIndexFlag()) {
            return null;
        }
        int value = FLAG_RED.getValue(this.colorRef);
        for (SysIndexSource sysIndexSource : SysIndexSource.values()) {
            if (sysIndexSource.value == value) {
                return sysIndexSource;
            }
        }
        return null;
    }

    public boolean hasPaletteIndexFlag() {
        return FLAG_PALETTE_INDEX.isSet(this.colorRef);
    }

    public boolean hasPaletteRGBFlag() {
        return FLAG_PALETTE_RGB.isSet(this.colorRef);
    }

    public boolean hasSchemeIndexFlag() {
        return FLAG_SCHEME_INDEX.isSet(this.colorRef);
    }

    public boolean hasSysIndexFlag() {
        return FLAG_SYS_INDEX.isSet(this.colorRef);
    }

    public boolean hasSystemRGBFlag() {
        return FLAG_SYSTEM_RGB.isSet(this.colorRef);
    }

    public void setPaletteIndexFlag(boolean z6) {
        this.colorRef = FLAG_PALETTE_INDEX.setBoolean(this.colorRef, z6);
    }

    public void setPaletteRGBFlag(boolean z6) {
        this.colorRef = FLAG_PALETTE_RGB.setBoolean(this.colorRef, z6);
    }

    public void setSchemeIndexFlag(boolean z6) {
        this.colorRef = FLAG_SCHEME_INDEX.setBoolean(this.colorRef, z6);
    }

    public void setSysIndexFlag(boolean z6) {
        this.colorRef = FLAG_SYS_INDEX.setBoolean(this.colorRef, z6);
    }

    public void setSystemRGBFlag(boolean z6) {
        this.colorRef = FLAG_SYSTEM_RGB.setBoolean(this.colorRef, z6);
    }

    public EscherColorRef(byte[] bArr, int i5, int i6) {
        this.opid = -1;
        if (i6 == 6) {
            this.opid = LittleEndian.getUShort(bArr, i5);
            i5 += 2;
        }
        this.colorRef = LittleEndian.getInt(bArr, i5);
    }
}

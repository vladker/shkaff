package org.apache.poi.ss.util;

import java.util.Objects;
import org.apache.poi.ss.usermodel.PaneType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PaneInformation {
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    private final byte activePane;
    private final boolean frozen;
    private final short leftColumn;
    private final short topRow;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final short f7238x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final short f7239y;

    public PaneInformation(short s6, short s7, short s8, short s9, byte b, boolean z6) {
        this.f7238x = s6;
        this.f7239y = s7;
        this.topRow = s8;
        this.leftColumn = s9;
        this.activePane = b;
        this.frozen = z6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaneInformation)) {
            return false;
        }
        PaneInformation paneInformation = (PaneInformation) obj;
        return this.f7238x == paneInformation.f7238x && this.f7239y == paneInformation.f7239y && this.topRow == paneInformation.topRow && this.leftColumn == paneInformation.leftColumn && this.activePane == paneInformation.activePane && this.frozen == paneInformation.frozen;
    }

    public byte getActivePane() {
        return this.activePane;
    }

    public PaneType getActivePaneType() {
        byte b = this.activePane;
        if (b == 0) {
            return PaneType.LOWER_RIGHT;
        }
        if (b == 1) {
            return PaneType.UPPER_RIGHT;
        }
        if (b == 2) {
            return PaneType.LOWER_LEFT;
        }
        if (b != 3) {
            return null;
        }
        return PaneType.UPPER_LEFT;
    }

    public short getHorizontalSplitPosition() {
        return this.f7239y;
    }

    public short getHorizontalSplitTopRow() {
        return this.topRow;
    }

    public short getVerticalSplitLeftColumn() {
        return this.leftColumn;
    }

    public short getVerticalSplitPosition() {
        return this.f7238x;
    }

    public int hashCode() {
        return Objects.hash(Short.valueOf(this.f7238x), Short.valueOf(this.f7239y), Short.valueOf(this.topRow), Short.valueOf(this.leftColumn), Byte.valueOf(this.activePane), Boolean.valueOf(this.frozen));
    }

    public boolean isFreezePane() {
        return this.frozen;
    }
}

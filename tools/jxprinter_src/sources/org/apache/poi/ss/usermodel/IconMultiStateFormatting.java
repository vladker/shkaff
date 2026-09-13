package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface IconMultiStateFormatting {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum IconSet {
        GYR_3_ARROW(0, 3, "3Arrows"),
        GREY_3_ARROWS(1, 3, "3ArrowsGray"),
        GYR_3_FLAGS(2, 3, "3Flags"),
        GYR_3_TRAFFIC_LIGHTS(3, 3, "3TrafficLights1"),
        GYR_3_TRAFFIC_LIGHTS_BOX(4, 3, "3TrafficLights2"),
        GYR_3_SHAPES(5, 3, "3Signs"),
        GYR_3_SYMBOLS_CIRCLE(6, 3, "3Symbols"),
        GYR_3_SYMBOLS(7, 3, "3Symbols2"),
        GYR_4_ARROWS(8, 4, "4Arrows"),
        GREY_4_ARROWS(9, 4, "4ArrowsGray"),
        RB_4_TRAFFIC_LIGHTS(10, 4, "4RedToBlack"),
        RATINGS_4(11, 4, "4Rating"),
        GYRB_4_TRAFFIC_LIGHTS(12, 4, "4TrafficLights"),
        GYYYR_5_ARROWS(13, 5, "5Arrows"),
        GREY_5_ARROWS(14, 5, "5ArrowsGray"),
        RATINGS_5(15, 5, "5Rating"),
        QUARTERS_5(16, 5, "5Quarters");

        public final int id;
        public final String name;
        public final int num;

        IconSet(int i5, int i6, String str) {
            this.id = i5;
            this.num = i6;
            this.name = str;
        }

        public static IconSet byId(int i5) {
            return values()[i5];
        }

        public static IconSet byName(String str) {
            for (IconSet iconSet : values()) {
                if (iconSet.name.equals(str)) {
                    return iconSet;
                }
            }
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.id + " - " + this.name;
        }
    }

    ConditionalFormattingThreshold createThreshold();

    IconSet getIconSet();

    ConditionalFormattingThreshold[] getThresholds();

    boolean isIconOnly();

    boolean isReversed();

    void setIconOnly(boolean z6);

    void setIconSet(IconSet iconSet);

    void setReversed(boolean z6);

    void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr);
}

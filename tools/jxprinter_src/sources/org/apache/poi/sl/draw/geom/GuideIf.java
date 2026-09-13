package org.apache.poi.sl.draw.geom;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface GuideIf extends Formula {
    public static final Pattern WHITESPACE = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.GuideIf$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op;

        static {
            int[] iArr = new int[Op.values().length];
            $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op = iArr;
            try {
                iArr[Op.abs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.adddiv.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.addsub.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.at2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.cos.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.cat2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.ifelse.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.val.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.max.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.min.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.mod.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.muldiv.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.pin.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.sat2.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.sin.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.sqrt.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[Op.tan.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Op {
        muldiv,
        addsub,
        adddiv,
        ifelse,
        val,
        abs,
        sqrt,
        max,
        min,
        at2,
        sin,
        cos,
        tan,
        cat2,
        sat2,
        pin,
        mod
    }

    @Override // org.apache.poi.sl.draw.geom.Formula
    default double evaluate(Context context) {
        return evaluateGuide(context);
    }

    default double evaluateGuide(Context context) {
        Op opValueOf;
        String[] strArrSplit = WHITESPACE.split(getFmla());
        String str = strArrSplit[0];
        str.getClass();
        switch (str) {
            case "*/":
                opValueOf = Op.muldiv;
                break;
            case "+-":
                opValueOf = Op.addsub;
                break;
            case "+/":
                opValueOf = Op.adddiv;
                break;
            case "?:":
                opValueOf = Op.ifelse;
                break;
            default:
                opValueOf = Op.valueOf(strArrSplit[0]);
                break;
        }
        double value = strArrSplit.length > 1 ? context.getValue(strArrSplit[1]) : 0.0d;
        double value2 = strArrSplit.length > 2 ? context.getValue(strArrSplit[2]) : 0.0d;
        double value3 = strArrSplit.length > 3 ? context.getValue(strArrSplit[3]) : 0.0d;
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$geom$GuideIf$Op[opValueOf.ordinal()]) {
            case 1:
                return Math.abs(value);
            case 2:
                if (value3 == 0.0d) {
                    return 0.0d;
                }
                return (value + value2) / value3;
            case 3:
                return (value + value2) - value3;
            case 4:
                return Math.toDegrees(Math.atan2(value2, value)) * 60000.0d;
            case 5:
                return Math.cos(Math.toRadians(value2 / 60000.0d)) * value;
            case 6:
                return Math.cos(Math.atan2(value3, value2)) * value;
            case 7:
                return value > 0.0d ? value2 : value3;
            case 8:
                return value;
            case 9:
                return Math.max(value, value2);
            case 10:
                return Math.min(value, value2);
            case 11:
                return Math.sqrt((value3 * value3) + (value2 * value2) + (value * value));
            case 12:
                if (value3 == 0.0d) {
                    return 0.0d;
                }
                return (value * value2) / value3;
            case 13:
                return Math.max(value, Math.min(value2, value3));
            case 14:
                return Math.sin(Math.atan2(value3, value2)) * value;
            case 15:
                return Math.sin(Math.toRadians(value2 / 60000.0d)) * value;
            case 16:
                return Math.sqrt(value);
            case 17:
                return Math.tan(Math.toRadians(value2 / 60000.0d)) * value;
            default:
                return 0.0d;
        }
    }

    String getFmla();

    String getName();

    void setFmla(String str);

    void setName(String str);
}

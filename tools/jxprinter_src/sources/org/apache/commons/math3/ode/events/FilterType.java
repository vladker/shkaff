package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.exception.MathInternalError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FilterType {
    TRIGGER_ONLY_DECREASING_EVENTS { // from class: org.apache.commons.math3.ode.events.FilterType.1
        @Override // org.apache.commons.math3.ode.events.FilterType
        public boolean getTriggeredIncreasing() {
            return false;
        }

        @Override // org.apache.commons.math3.ode.events.FilterType
        public Transformer selectTransformer(Transformer transformer, double d, boolean z6) {
            if (z6) {
                int i5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$ode$events$Transformer[transformer.ordinal()];
                if (i5 == 1) {
                    if (d > 0.0d) {
                        return Transformer.MAX;
                    }
                    return d < 0.0d ? Transformer.PLUS : Transformer.UNINITIALIZED;
                }
                if (i5 == 2) {
                    return d >= 0.0d ? Transformer.MIN : transformer;
                }
                if (i5 == 3) {
                    return d >= 0.0d ? Transformer.MAX : transformer;
                }
                if (i5 == 4) {
                    return d <= 0.0d ? Transformer.MINUS : transformer;
                }
                if (i5 == 5) {
                    return d <= 0.0d ? Transformer.PLUS : transformer;
                }
                throw new MathInternalError();
            }
            int i6 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$ode$events$Transformer[transformer.ordinal()];
            if (i6 == 1) {
                if (d > 0.0d) {
                    return Transformer.MINUS;
                }
                return d < 0.0d ? Transformer.MIN : Transformer.UNINITIALIZED;
            }
            if (i6 == 2) {
                return d <= 0.0d ? Transformer.MAX : transformer;
            }
            if (i6 == 3) {
                return d <= 0.0d ? Transformer.MIN : transformer;
            }
            if (i6 == 4) {
                return d >= 0.0d ? Transformer.PLUS : transformer;
            }
            if (i6 == 5) {
                return d >= 0.0d ? Transformer.MINUS : transformer;
            }
            throw new MathInternalError();
        }
    },
    TRIGGER_ONLY_INCREASING_EVENTS { // from class: org.apache.commons.math3.ode.events.FilterType.2
        @Override // org.apache.commons.math3.ode.events.FilterType
        public boolean getTriggeredIncreasing() {
            return true;
        }

        @Override // org.apache.commons.math3.ode.events.FilterType
        public Transformer selectTransformer(Transformer transformer, double d, boolean z6) {
            if (z6) {
                int i5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$ode$events$Transformer[transformer.ordinal()];
                if (i5 == 1) {
                    if (d > 0.0d) {
                        return Transformer.PLUS;
                    }
                    return d < 0.0d ? Transformer.MIN : Transformer.UNINITIALIZED;
                }
                if (i5 == 2) {
                    return d <= 0.0d ? Transformer.MAX : transformer;
                }
                if (i5 == 3) {
                    return d <= 0.0d ? Transformer.MIN : transformer;
                }
                if (i5 == 4) {
                    return d >= 0.0d ? Transformer.PLUS : transformer;
                }
                if (i5 == 5) {
                    return d >= 0.0d ? Transformer.MINUS : transformer;
                }
                throw new MathInternalError();
            }
            int i6 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$ode$events$Transformer[transformer.ordinal()];
            if (i6 == 1) {
                if (d > 0.0d) {
                    return Transformer.MAX;
                }
                return d < 0.0d ? Transformer.MINUS : Transformer.UNINITIALIZED;
            }
            if (i6 == 2) {
                return d >= 0.0d ? Transformer.MIN : transformer;
            }
            if (i6 == 3) {
                return d >= 0.0d ? Transformer.MAX : transformer;
            }
            if (i6 == 4) {
                return d <= 0.0d ? Transformer.MINUS : transformer;
            }
            if (i6 == 5) {
                return d <= 0.0d ? Transformer.PLUS : transformer;
            }
            throw new MathInternalError();
        }
    };

    /* JADX INFO: renamed from: org.apache.commons.math3.ode.events.FilterType$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ode$events$Transformer;

        static {
            int[] iArr = new int[Transformer.values().length];
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer = iArr;
            try {
                iArr[Transformer.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MINUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MAX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public abstract boolean getTriggeredIncreasing();

    public abstract Transformer selectTransformer(Transformer transformer, double d, boolean z6);
}

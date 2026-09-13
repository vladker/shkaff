package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
enum Transformer {
    UNINITIALIZED { // from class: org.apache.commons.math3.ode.events.Transformer.1
        @Override // org.apache.commons.math3.ode.events.Transformer
        public double transformed(double d) {
            return 0.0d;
        }
    },
    PLUS { // from class: org.apache.commons.math3.ode.events.Transformer.2
        @Override // org.apache.commons.math3.ode.events.Transformer
        public double transformed(double d) {
            return d;
        }
    },
    MINUS { // from class: org.apache.commons.math3.ode.events.Transformer.3
        @Override // org.apache.commons.math3.ode.events.Transformer
        public double transformed(double d) {
            return -d;
        }
    },
    MIN { // from class: org.apache.commons.math3.ode.events.Transformer.4
        @Override // org.apache.commons.math3.ode.events.Transformer
        public double transformed(double d) {
            return FastMath.min(-Precision.SAFE_MIN, FastMath.min(-d, d));
        }
    },
    MAX { // from class: org.apache.commons.math3.ode.events.Transformer.5
        @Override // org.apache.commons.math3.ode.events.Transformer
        public double transformed(double d) {
            return FastMath.max(Precision.SAFE_MIN, FastMath.max(-d, d));
        }
    };

    public abstract double transformed(double d);
}

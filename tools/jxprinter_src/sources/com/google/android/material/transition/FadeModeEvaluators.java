package com.google.android.material.transition;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f7, f8, f6));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, f8, f6), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, f8, f6), TransitionUtils.lerp(0, 255, f7, f8, f6));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            float fA = AbstractC0157z.a(f8, f7, f9, f7);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, fA, f6), TransitionUtils.lerp(0, 255, fA, f8, f6));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i5, boolean z6) {
        if (i5 == 0) {
            return z6 ? IN : OUT;
        }
        if (i5 == 1) {
            return z6 ? OUT : IN;
        }
        if (i5 == 2) {
            return CROSS;
        }
        if (i5 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid fade mode: "));
    }
}

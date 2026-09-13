package androidx.activity;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final O3.l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i5, int i6, O3.l lVar, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i5, i6, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6) {
            return auto$default(this, i5, i6, null, 4, null);
        }

        public final SystemBarStyle dark(@ColorInt int i5) {
            return new SystemBarStyle(i5, i5, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        public final SystemBarStyle light(@ColorInt int i5, @ColorInt int i6) {
            return new SystemBarStyle(i5, i6, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6, O3.l detectDarkMode) {
            E.f(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i5, i6, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i5, int i6, int i7, O3.l lVar, AbstractC1107v abstractC1107v) {
        this(i5, i6, i7, lVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6) {
        return Companion.auto(i5, i6);
    }

    public static final SystemBarStyle dark(@ColorInt int i5) {
        return Companion.dark(i5);
    }

    public static final SystemBarStyle light(@ColorInt int i5, @ColorInt int i6) {
        return Companion.light(i5, i6);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final O3.l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z6) {
        return z6 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z6) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z6 ? this.darkScrim : this.lightScrim;
    }

    private SystemBarStyle(int i5, int i6, int i7, O3.l lVar) {
        this.lightScrim = i5;
        this.darkScrim = i6;
        this.nightMode = i7;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i5, @ColorInt int i6, O3.l lVar) {
        return Companion.auto(i5, i6, lVar);
    }
}

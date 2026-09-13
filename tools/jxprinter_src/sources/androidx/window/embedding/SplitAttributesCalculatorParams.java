package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.annotation.RestrictTo;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SplitAttributesCalculatorParams {
    private final boolean areDefaultConstraintsSatisfied;
    private final SplitAttributes defaultSplitAttributes;
    private final Configuration parentConfiguration;
    private final WindowLayoutInfo parentWindowLayoutInfo;
    private final WindowMetrics parentWindowMetrics;
    private final String splitRuleTag;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SplitAttributesCalculatorParams(WindowMetrics parentWindowMetrics, Configuration parentConfiguration, WindowLayoutInfo parentWindowLayoutInfo, SplitAttributes defaultSplitAttributes, boolean z6, String str) {
        E.f(parentWindowMetrics, "parentWindowMetrics");
        E.f(parentConfiguration, "parentConfiguration");
        E.f(parentWindowLayoutInfo, "parentWindowLayoutInfo");
        E.f(defaultSplitAttributes, "defaultSplitAttributes");
        this.parentWindowMetrics = parentWindowMetrics;
        this.parentConfiguration = parentConfiguration;
        this.parentWindowLayoutInfo = parentWindowLayoutInfo;
        this.defaultSplitAttributes = defaultSplitAttributes;
        this.areDefaultConstraintsSatisfied = z6;
        this.splitRuleTag = str;
    }

    public final boolean areDefaultConstraintsSatisfied() {
        return this.areDefaultConstraintsSatisfied;
    }

    public final SplitAttributes getDefaultSplitAttributes() {
        return this.defaultSplitAttributes;
    }

    public final Configuration getParentConfiguration() {
        return this.parentConfiguration;
    }

    public final WindowLayoutInfo getParentWindowLayoutInfo() {
        return this.parentWindowLayoutInfo;
    }

    public final WindowMetrics getParentWindowMetrics() {
        return this.parentWindowMetrics;
    }

    public final String getSplitRuleTag() {
        return this.splitRuleTag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SplitAttributesCalculatorParams:{windowMetrics=");
        sb.append(this.parentWindowMetrics);
        sb.append(", configuration=");
        sb.append(this.parentConfiguration);
        sb.append(", windowLayoutInfo=");
        sb.append(this.parentWindowLayoutInfo);
        sb.append(", defaultSplitAttributes=");
        sb.append(this.defaultSplitAttributes);
        sb.append(", areDefaultConstraintsSatisfied=");
        sb.append(this.areDefaultConstraintsSatisfied);
        sb.append(", tag=");
        return androidx.collection.a.f('}', this.splitRuleTag, sb);
    }
}

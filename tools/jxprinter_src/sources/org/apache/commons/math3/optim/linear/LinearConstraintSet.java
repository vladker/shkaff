package org.apache.commons.math3.optim.linear;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LinearConstraintSet implements OptimizationData {
    private final Set<LinearConstraint> linearConstraints;

    public LinearConstraintSet(LinearConstraint... linearConstraintArr) {
        this.linearConstraints = new LinkedHashSet();
        for (LinearConstraint linearConstraint : linearConstraintArr) {
            this.linearConstraints.add(linearConstraint);
        }
    }

    public Collection<LinearConstraint> getConstraints() {
        return Collections.unmodifiableSet(this.linearConstraints);
    }

    public LinearConstraintSet(Collection<LinearConstraint> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.linearConstraints = linkedHashSet;
        linkedHashSet.addAll(collection);
    }
}

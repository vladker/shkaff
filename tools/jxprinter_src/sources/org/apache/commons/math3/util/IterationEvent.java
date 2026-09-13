package org.apache.commons.math3.util;

import java.util.EventObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IterationEvent extends EventObject {
    private static final long serialVersionUID = 20120128;
    private final int iterations;

    public IterationEvent(Object obj, int i5) {
        super(obj);
        this.iterations = i5;
    }

    public int getIterations() {
        return this.iterations;
    }
}

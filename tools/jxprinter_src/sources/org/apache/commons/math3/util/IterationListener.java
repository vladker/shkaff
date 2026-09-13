package org.apache.commons.math3.util;

import java.util.EventListener;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface IterationListener extends EventListener {
    void initializationPerformed(IterationEvent iterationEvent);

    void iterationPerformed(IterationEvent iterationEvent);

    void iterationStarted(IterationEvent iterationEvent);

    void terminationPerformed(IterationEvent iterationEvent);
}

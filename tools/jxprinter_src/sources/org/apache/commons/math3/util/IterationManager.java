package org.apache.commons.math3.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IterationManager {
    private IntegerSequence.Incrementor iterations;
    private final Collection<IterationListener> listeners;

    public IterationManager(int i5) {
        this.iterations = IntegerSequence.Incrementor.create().withMaximalCount(i5);
        this.listeners = new CopyOnWriteArrayList();
    }

    public void addIterationListener(IterationListener iterationListener) {
        this.listeners.add(iterationListener);
    }

    public void fireInitializationEvent(IterationEvent iterationEvent) {
        Iterator<IterationListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().initializationPerformed(iterationEvent);
        }
    }

    public void fireIterationPerformedEvent(IterationEvent iterationEvent) {
        Iterator<IterationListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().iterationPerformed(iterationEvent);
        }
    }

    public void fireIterationStartedEvent(IterationEvent iterationEvent) {
        Iterator<IterationListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().iterationStarted(iterationEvent);
        }
    }

    public void fireTerminationEvent(IterationEvent iterationEvent) {
        Iterator<IterationListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().terminationPerformed(iterationEvent);
        }
    }

    public int getIterations() {
        return this.iterations.getCount();
    }

    public int getMaxIterations() {
        return this.iterations.getMaximalCount();
    }

    public void incrementIterationCount() {
        this.iterations.increment();
    }

    public void removeIterationListener(IterationListener iterationListener) {
        this.listeners.remove(iterationListener);
    }

    public void resetIterationCount() {
        this.iterations = this.iterations.withStart(0);
    }

    @Deprecated
    public IterationManager(int i5, final Incrementor.MaxCountExceededCallback maxCountExceededCallback) {
        this(i5, new IntegerSequence.Incrementor.MaxCountExceededCallback() { // from class: org.apache.commons.math3.util.IterationManager.1
            @Override // org.apache.commons.math3.util.IntegerSequence.Incrementor.MaxCountExceededCallback
            public void trigger(int i6) {
                maxCountExceededCallback.trigger(i6);
            }
        });
    }

    public IterationManager(int i5, IntegerSequence.Incrementor.MaxCountExceededCallback maxCountExceededCallback) {
        this.iterations = IntegerSequence.Incrementor.create().withMaximalCount(i5).withCallback(maxCountExceededCallback);
        this.listeners = new CopyOnWriteArrayList();
    }
}

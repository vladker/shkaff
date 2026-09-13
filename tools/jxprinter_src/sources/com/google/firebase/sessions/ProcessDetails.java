package com.google.firebase.sessions;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ProcessDetails {
    private final int importance;
    private final boolean isDefaultProcess;
    private final int pid;
    private final String processName;

    public ProcessDetails(String processName, int i5, int i6, boolean z6) {
        E.f(processName, "processName");
        this.processName = processName;
        this.pid = i5;
        this.importance = i6;
        this.isDefaultProcess = z6;
    }

    public static /* synthetic */ ProcessDetails copy$default(ProcessDetails processDetails, String str, int i5, int i6, boolean z6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = processDetails.processName;
        }
        if ((i7 & 2) != 0) {
            i5 = processDetails.pid;
        }
        if ((i7 & 4) != 0) {
            i6 = processDetails.importance;
        }
        if ((i7 & 8) != 0) {
            z6 = processDetails.isDefaultProcess;
        }
        return processDetails.copy(str, i5, i6, z6);
    }

    public final String component1() {
        return this.processName;
    }

    public final int component2() {
        return this.pid;
    }

    public final int component3() {
        return this.importance;
    }

    public final boolean component4() {
        return this.isDefaultProcess;
    }

    public final ProcessDetails copy(String processName, int i5, int i6, boolean z6) {
        E.f(processName, "processName");
        return new ProcessDetails(processName, i5, i6, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return E.a(this.processName, processDetails.processName) && this.pid == processDetails.pid && this.importance == processDetails.importance && this.isDefaultProcess == processDetails.isDefaultProcess;
    }

    public final int getImportance() {
        return this.importance;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDefaultProcess) + ((Integer.hashCode(this.importance) + ((Integer.hashCode(this.pid) + (this.processName.hashCode() * 31)) * 31)) * 31);
    }

    public final boolean isDefaultProcess() {
        return this.isDefaultProcess;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.processName + ", pid=" + this.pid + ", importance=" + this.importance + ", isDefaultProcess=" + this.isDefaultProcess + ')';
    }
}

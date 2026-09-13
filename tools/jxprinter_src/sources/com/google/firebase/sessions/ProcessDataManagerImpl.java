package com.google.firebase.sessions;

import A3.j0;
import A3.k0;
import android.content.Context;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p147z3.A;
import p147z3.AbstractC1935o;
import p147z3.C1938s;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ProcessDataManagerImpl implements ProcessDataManager {
    private final Context appContext;
    private boolean hasGeneratedSession;
    private final int myPid;
    private final InterfaceC1934n myProcessDetails$delegate;
    private final InterfaceC1934n myProcessName$delegate;
    private final InterfaceC1934n myUuid$delegate;

    public ProcessDataManagerImpl(Context appContext, UuidGenerator uuidGenerator) {
        E.f(appContext, "appContext");
        E.f(uuidGenerator, "uuidGenerator");
        this.appContext = appContext;
        final int i5 = 0;
        this.myProcessName$delegate = AbstractC1935o.lazy(new O3.a(this) { // from class: com.google.firebase.sessions.e
            public final /* synthetic */ ProcessDataManagerImpl b;

            {
                this.b = this;
            }

            @Override // O3.a
            public final Object invoke() {
                switch (i5) {
                    case 0:
                        return ProcessDataManagerImpl.myProcessName_delegate$lambda$0(this.b);
                    default:
                        return ProcessDataManagerImpl.myProcessDetails_delegate$lambda$2(this.b);
                }
            }
        });
        this.myPid = Process.myPid();
        this.myUuid$delegate = AbstractC1935o.lazy(new c(uuidGenerator, 2));
        final int i6 = 1;
        this.myProcessDetails$delegate = AbstractC1935o.lazy(new O3.a(this) { // from class: com.google.firebase.sessions.e
            public final /* synthetic */ ProcessDataManagerImpl b;

            {
                this.b = this;
            }

            @Override // O3.a
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        return ProcessDataManagerImpl.myProcessName_delegate$lambda$0(this.b);
                    default:
                        return ProcessDataManagerImpl.myProcessDetails_delegate$lambda$2(this.b);
                }
            }
        });
    }

    private final List<ProcessDetails> getAppProcessDetails() {
        return ProcessDetailsProvider.INSTANCE.getAppProcessDetails(this.appContext);
    }

    private final ProcessDetails getMyProcessDetails() {
        return (ProcessDetails) this.myProcessDetails$delegate.getValue();
    }

    private final boolean isProcessStale(ProcessDetails processDetails, ProcessData processData) {
        if (E.a(getMyProcessName(), processDetails.getProcessName())) {
            return (processDetails.getPid() == processData.getPid() && E.a(getMyUuid(), processData.getUuid())) ? false : true;
        }
        return processDetails.getPid() != processData.getPid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProcessDetails myProcessDetails_delegate$lambda$2(ProcessDataManagerImpl processDataManagerImpl) {
        return ProcessDetailsProvider.INSTANCE.getMyProcessDetails(processDataManagerImpl.appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String myProcessName_delegate$lambda$0(ProcessDataManagerImpl processDataManagerImpl) {
        return processDataManagerImpl.getMyProcessDetails().getProcessName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String myUuid_delegate$lambda$1(UuidGenerator uuidGenerator) {
        String string = uuidGenerator.next().toString();
        E.e(string, "toString(...)");
        return string;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map<String, ProcessData> generateProcessDataMap() {
        return ProcessDataManager.DefaultImpls.generateProcessDataMap(this);
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public int getMyPid() {
        return this.myPid;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public String getMyProcessName() {
        return (String) this.myProcessName$delegate.getValue();
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public String getMyUuid() {
        return (String) this.myUuid$delegate.getValue();
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean isColdStart(Map<String, ProcessData> processDataMap) {
        E.f(processDataMap, "processDataMap");
        if (this.hasGeneratedSession) {
            return false;
        }
        List<ProcessDetails> appProcessDetails = getAppProcessDetails();
        ArrayList arrayList = new ArrayList();
        for (ProcessDetails processDetails : appProcessDetails) {
            ProcessData processData = processDataMap.get(processDetails.getProcessName());
            C1938s c1938s = processData != null ? new C1938s(processDetails, processData) : null;
            if (c1938s != null) {
                arrayList.add(c1938s);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C1938s c1938s2 = (C1938s) obj;
            if (!isProcessStale((ProcessDetails) c1938s2.f9134a, (ProcessData) c1938s2.b)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean isMyProcessStale(Map<String, ProcessData> processDataMap) {
        E.f(processDataMap, "processDataMap");
        ProcessData processData = processDataMap.get(getMyProcessName());
        return (processData != null && processData.getPid() == getMyPid() && E.a(processData.getUuid(), getMyUuid())) ? false : true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public void onSessionGenerated() {
        this.hasGeneratedSession = true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map<String, ProcessData> updateProcessDataMap(Map<String, ProcessData> map) {
        Map mutableMap;
        if (map != null && (mutableMap = k0.toMutableMap(map)) != null) {
            mutableMap.put(getMyProcessName(), new ProcessData(Process.myPid(), getMyUuid()));
            Map<String, ProcessData> map2 = k0.toMap(mutableMap);
            if (map2 != null) {
                return map2;
            }
        }
        return j0.mapOf(A.to(getMyProcessName(), new ProcessData(Process.myPid(), getMyUuid())));
    }
}

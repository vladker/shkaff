package R2;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends Activity {
    private final ArrayList<h> listeners = new ArrayList<>();

    public void addLifeCycleListener(h hVar) {
        if (this.listeners.contains(hVar)) {
            return;
        }
        this.listeners.add(hVar);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ArrayList<h> arrayList = this.listeners;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            h hVar = arrayList.get(i5);
            i5++;
            hVar.getClass();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ArrayList<h> arrayList = this.listeners;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            h hVar = arrayList.get(i5);
            i5++;
            c cVar = (c) hVar;
            H2.c cVar2 = cVar.e;
            cVar2.run();
            cVar.d.removeCallbacks(cVar2);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        ArrayList<h> arrayList = this.listeners;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            h hVar = arrayList.get(i5);
            i5++;
            ((c) hVar).b.show();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ArrayList<h> arrayList = this.listeners;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            h hVar = arrayList.get(i5);
            i5++;
            ((c) hVar).b.hide();
        }
    }

    public void removeLifeCycleListener(h hVar) {
        this.listeners.remove(hVar);
    }
}

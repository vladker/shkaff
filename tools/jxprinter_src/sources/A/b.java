package A;

import android.os.CountDownTimer;
import android.widget.Button;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar) {
        super(60000L, 1000L);
        this.f4a = dVar;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        d dVar = this.f4a;
        Button button = dVar.f6f;
        if (button != null) {
            button.setEnabled(true);
            dVar.f6f.setText(dVar.getString(g.Send_verification_code));
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j6) {
        d dVar = this.f4a;
        Button button = dVar.f6f;
        if (button != null) {
            button.setEnabled(false);
            dVar.f6f.setText(String.format(dVar.getString(g.second_unit), Integer.valueOf(((int) j6) / 1000)));
        }
    }
}

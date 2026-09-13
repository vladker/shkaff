package p102s;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import android.speech.SpeechRecognizer;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import java.util.ArrayList;
import p007a4.M;
import p050j.w;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: s.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1630c extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8170a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1630c(int i5, g gVar, int i6) {
        super(i5, gVar);
        this.f8170a = i6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f8170a) {
            case 0:
                return new C1630c(2, gVar, 0);
            case 1:
                return new C1630c(2, gVar, 1);
            case 2:
                return new C1630c(2, gVar, 2);
            case 3:
                return new C1630c(2, gVar, 3);
            case 4:
                return new C1630c(2, gVar, 4);
            case 5:
                return new C1630c(2, gVar, 5);
            case 6:
                return new C1630c(2, gVar, 6);
            case 7:
                return new C1630c(2, gVar, 7);
            case 8:
                return new C1630c(2, gVar, 8);
            case 9:
                return new C1630c(2, gVar, 9);
            case 10:
                return new C1630c(2, gVar, 10);
            default:
                return new C1630c(2, gVar, 11);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        g gVar = (g) obj2;
        switch (this.f8170a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
        return ((C1630c) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f8170a;
        i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                v.throwOnFailure(obj);
                C1628a c1628a = C1631d.Companion;
                SpeechRecognizer speechRecognizer = c1628a.getSpeechRecognizer();
                if (speechRecognizer != null) {
                    speechRecognizer.stopListening();
                }
                SpeechRecognizer speechRecognizer2 = c1628a.getSpeechRecognizer();
                if (speechRecognizer2 != null) {
                    speechRecognizer2.destroy();
                }
                c1628a.setSpeechRecognizer(null);
                break;
            case 1:
                v.throwOnFailure(obj);
                ArrayList arrayList = r.curTable;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj2 = arrayList.get(i6);
                        i6++;
                        ((PrinterLabelTableView) obj2).addColumnOnSelectedLeft();
                    }
                }
                break;
            case 2:
                v.throwOnFailure(obj);
                ArrayList arrayList2 = r.curTable;
                if (arrayList2 != null) {
                    int size2 = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        Object obj3 = arrayList2.get(i7);
                        i7++;
                        ((PrinterLabelTableView) obj3).addColumnOnSelectedRight();
                    }
                }
                break;
            case 3:
                v.throwOnFailure(obj);
                ArrayList arrayList3 = r.curTable;
                if (arrayList3 != null) {
                    int size3 = arrayList3.size();
                    int i8 = 0;
                    while (i8 < size3) {
                        Object obj4 = arrayList3.get(i8);
                        i8++;
                        ((PrinterLabelTableView) obj4).addRowOnSelectedBottom();
                    }
                }
                break;
            case 4:
                v.throwOnFailure(obj);
                ArrayList arrayList4 = r.curTable;
                if (arrayList4 != null) {
                    int size4 = arrayList4.size();
                    int i9 = 0;
                    while (i9 < size4) {
                        Object obj5 = arrayList4.get(i9);
                        i9++;
                        ((PrinterLabelTableView) obj5).addRowOnSelectedTop();
                    }
                }
                break;
            case 5:
                v.throwOnFailure(obj);
                ArrayList arrayList5 = r.curTable;
                if (arrayList5 != null) {
                    int size5 = arrayList5.size();
                    int i10 = 0;
                    while (i10 < size5) {
                        Object obj6 = arrayList5.get(i10);
                        i10++;
                        ((PrinterLabelTableView) obj6).merge();
                    }
                }
                break;
            case 6:
                v.throwOnFailure(obj);
                ArrayList arrayList6 = r.curTable;
                if (arrayList6 != null) {
                    int size6 = arrayList6.size();
                    int i11 = 0;
                    while (i11 < size6) {
                        Object obj7 = arrayList6.get(i11);
                        i11++;
                        ((PrinterLabelTableView) obj7).removeColumnOnSelectedLeft();
                    }
                }
                break;
            case 7:
                v.throwOnFailure(obj);
                ArrayList arrayList7 = r.curTable;
                if (arrayList7 != null) {
                    int size7 = arrayList7.size();
                    int i12 = 0;
                    while (i12 < size7) {
                        Object obj8 = arrayList7.get(i12);
                        i12++;
                        ((PrinterLabelTableView) obj8).removeColumnOnSelectedRight();
                    }
                }
                break;
            case 8:
                v.throwOnFailure(obj);
                ArrayList arrayList8 = r.curTable;
                if (arrayList8 != null) {
                    int size8 = arrayList8.size();
                    int i13 = 0;
                    while (i13 < size8) {
                        Object obj9 = arrayList8.get(i13);
                        i13++;
                        ((PrinterLabelTableView) obj9).removeRowOnSelectedBottom();
                    }
                }
                break;
            case 9:
                v.throwOnFailure(obj);
                ArrayList arrayList9 = r.curTable;
                if (arrayList9 != null) {
                    int size9 = arrayList9.size();
                    int i14 = 0;
                    while (i14 < size9) {
                        Object obj10 = arrayList9.get(i14);
                        i14++;
                        ((PrinterLabelTableView) obj10).removeRowOnSelectedTop();
                    }
                }
                break;
            case 10:
                v.throwOnFailure(obj);
                ArrayList arrayList10 = r.curTable;
                if (arrayList10 != null) {
                    int size10 = arrayList10.size();
                    int i15 = 0;
                    while (i15 < size10) {
                        Object obj11 = arrayList10.get(i15);
                        i15++;
                        ((PrinterLabelTableView) obj11).split();
                    }
                }
                break;
            default:
                v.throwOnFailure(obj);
                w.c();
                break;
        }
        return Q.INSTANCE;
    }
}

package org.apache.poi.xssf.usermodel;

import A3.G;
import com.bumptech.glide.g;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.apache.poi.xwpf.usermodel.XWPFComments;
import org.apache.poi.xwpf.usermodel.XWPFEndnotes;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFFootnotes;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFSettings;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p102s.C1630c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements POIXMLRelation.PackagePartConstructor, POIXMLRelation.NoArgConstructor, POIXMLRelation.ParentPartConstructor, BasicMessageChannel.MessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7343a;

    public /* synthetic */ b(int i5) {
        this.f7343a = i5;
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.NoArgConstructor
    public POIXMLDocumentPart init() {
        switch (this.f7343a) {
            case 1:
                return new SingleXmlCells();
            case 2:
            case 4:
            case 7:
            case 9:
            case 11:
            case 13:
            case 15:
            case 17:
            case 19:
            default:
                return new XWPFEndnotes();
            case 3:
                return new XSSFTable();
            case 5:
                return new XWPFNumbering();
            case 6:
                return new XWPFPictureData();
            case 8:
                return new XWPFSettings();
            case 10:
                return new XWPFStyles();
            case 12:
                return new XWPFHeader();
            case 14:
                return new XWPFFooter();
            case 16:
                return new XWPFChart();
            case 18:
                return new XWPFComments();
            case 20:
                return new XWPFFootnotes();
        }
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        List listA;
        List listA2;
        List listA3;
        List listA4;
        List listA5;
        switch (this.f7343a) {
            case 25:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 0));
                    listA = G.listOf(null);
                } catch (Throwable th) {
                    listA = g.a(th);
                }
                reply.reply(listA);
                break;
            case 26:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 1));
                    listA2 = G.listOf(null);
                } catch (Throwable th2) {
                    listA2 = g.a(th2);
                }
                reply.reply(listA2);
                break;
            case 27:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 6));
                    listA3 = G.listOf(null);
                } catch (Throwable th3) {
                    listA3 = g.a(th3);
                }
                reply.reply(listA3);
                break;
            case 28:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 2));
                    listA4 = G.listOf(null);
                } catch (Throwable th4) {
                    listA4 = g.a(th4);
                }
                reply.reply(listA4);
                break;
            default:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 7));
                    listA5 = G.listOf(null);
                } catch (Throwable th5) {
                    listA5 = g.a(th5);
                }
                reply.reply(listA5);
                break;
        }
    }

    public /* synthetic */ b(Object obj, int i5) {
        this.f7343a = i5;
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.ParentPartConstructor
    public POIXMLDocumentPart init(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        switch (this.f7343a) {
            case 13:
                return new XWPFHeader(pOIXMLDocumentPart, packagePart);
            case 14:
            default:
                return new XWPFComments(pOIXMLDocumentPart, packagePart);
            case 15:
                return new XWPFFooter(pOIXMLDocumentPart, packagePart);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.PackagePartConstructor
    public POIXMLDocumentPart init(PackagePart packagePart) {
        switch (this.f7343a) {
            case 0:
                return new MapInfo(packagePart);
            case 2:
                return new SingleXmlCells(packagePart);
            case 4:
                return new XSSFTable(packagePart);
            case 7:
                return new XWPFPictureData(packagePart);
            case 9:
                return new XWPFSettings(packagePart);
            case 11:
                return new XWPFStyles(packagePart);
            case 17:
                return new XWPFChart(packagePart);
            case 21:
                return new XWPFFootnotes(packagePart);
            case 23:
                return new XWPFEndnotes(packagePart);
            default:
                return new XWPFNumbering(packagePart);
        }
    }
}

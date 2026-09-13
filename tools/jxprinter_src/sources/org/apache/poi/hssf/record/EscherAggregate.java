package org.apache.poi.hssf.record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSerializationListener;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.ss.util.IEEEDouble;
import org.apache.poi.util.GenericRecordXmlWriter;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherAggregate extends AbstractEscherHolderRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static int MAX_RECORD_LENGTH = 100000000;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTBORDERCALLOUT1 = 50;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTBORDERCALLOUT2 = 51;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTBORDERCALLOUT3 = 52;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTBORDERCALLOUT90 = 181;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTCALLOUT1 = 44;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTCALLOUT2 = 45;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTCALLOUT3 = 46;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACCENTCALLOUT90 = 179;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONBACKPREVIOUS = 194;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONBEGINNING = 196;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONBLANK = 189;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONDOCUMENT = 198;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONEND = 195;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONFORWARDNEXT = 193;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONHELP = 191;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONHOME = 190;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONINFORMATION = 192;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONMOVIE = 200;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONRETURN = 197;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ACTIONBUTTONSOUND = 199;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ARC = 19;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ARROW = 13;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BALLOON = 17;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTARROW = 91;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTCONNECTOR2 = 33;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTCONNECTOR3 = 34;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTCONNECTOR4 = 35;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTCONNECTOR5 = 36;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BENTUPARROW = 90;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BEVEL = 84;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BLOCKARC = 95;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BORDERCALLOUT1 = 47;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BORDERCALLOUT2 = 48;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BORDERCALLOUT3 = 49;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BORDERCALLOUT90 = 180;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BRACEPAIR = 186;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_BRACKETPAIR = 185;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CALLOUT1 = 41;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CALLOUT2 = 42;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CALLOUT3 = 43;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CALLOUT90 = 178;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CAN = 22;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CHEVRON = 55;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CIRCULARARROW = 99;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CLOUDCALLOUT = 106;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CUBE = 16;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDCONNECTOR2 = 37;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDCONNECTOR3 = 38;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDCONNECTOR4 = 39;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDCONNECTOR5 = 40;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDDOWNARROW = 105;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDLEFTARROW = 103;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDRIGHTARROW = 102;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_CURVEDUPARROW = 104;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_DIAMOND = 4;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_DONUT = 23;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_DOUBLEWAVE = 188;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_DOWNARROW = 67;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_DOWNARROWCALLOUT = 80;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ELLIPSE = 3;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ELLIPSERIBBON = 107;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ELLIPSERIBBON2 = 108;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTALTERNATEPROCESS = 176;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTCOLLATE = 125;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTCONNECTOR = 120;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTDECISION = 110;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTDELAY = 135;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTDISPLAY = 134;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTDOCUMENT = 114;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTEXTRACT = 127;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTINPUTOUTPUT = 111;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTINTERNALSTORAGE = 113;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMAGNETICDISK = 132;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMAGNETICDRUM = 133;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMAGNETICTAPE = 131;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMANUALINPUT = 118;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMANUALOPERATION = 119;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMERGE = 128;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTMULTIDOCUMENT = 115;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTOFFLINESTORAGE = 129;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTOFFPAGECONNECTOR = 177;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTONLINESTORAGE = 130;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTOR = 124;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTPREDEFINEDPROCESS = 112;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTPREPARATION = 117;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTPROCESS = 109;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTPUNCHEDCARD = 121;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTPUNCHEDTAPE = 122;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTSORT = 126;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTSUMMINGJUNCTION = 123;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FLOWCHARTTERMINATOR = 116;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_FOLDEDCORNER = 65;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_HEART = 74;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_HEXAGON = 9;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_HOMEPLATE = 15;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_HORIZONTALSCROLL = 98;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_HOSTCONTROL = 201;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_IRREGULARSEAL1 = 71;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_IRREGULARSEAL2 = 72;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ISOCELESTRIANGLE = 5;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTARROW = 66;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTARROWCALLOUT = 77;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTBRACE = 87;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTBRACKET = 85;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTRIGHTARROW = 69;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTRIGHTARROWCALLOUT = 81;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTRIGHTUPARROW = 182;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LEFTUPARROW = 89;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LIGHTNINGBOLT = 73;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_LINE = 20;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_MIN = 0;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_MOON = 184;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_NIL = 4095;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_NOSMOKING = 57;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_NOTCHEDCIRCULARARROW = 100;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_NOTCHEDRIGHTARROW = 94;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_NOT_PRIMATIVE = 0;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_OCTAGON = 10;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_PARALLELOGRAM = 7;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_PENTAGON = 56;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_PICTUREFRAME = 75;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_PLAQUE = 21;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_PLUS = 11;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_QUADARROW = 76;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_QUADARROWCALLOUT = 83;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RECTANGLE = 1;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIBBON = 53;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIBBON2 = 54;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIGHTARROWCALLOUT = 78;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIGHTBRACE = 88;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIGHTBRACKET = 86;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_RIGHTTRIANGLE = 6;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_ROUNDRECTANGLE = 2;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL = 18;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL16 = 59;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL24 = 92;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL32 = 60;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL4 = 187;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SEAL8 = 58;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SMILEYFACE = 96;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_STAR = 12;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_STRAIGHTCONNECTOR1 = 32;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_STRIPEDRIGHTARROW = 93;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_SUN = 183;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTARCHDOWNCURVE = 145;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTARCHDOWNPOUR = 149;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTARCHUPCURVE = 144;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTARCHUPPOUR = 148;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTBOX = 202;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTBUTTONCURVE = 147;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTBUTTONPOUR = 151;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCANDOWN = 175;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCANUP = 174;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCASCADEDOWN = 155;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCASCADEUP = 154;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCHEVRON = 140;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCHEVRONINVERTED = 141;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCIRCLECURVE = 146;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCIRCLEPOUR = 150;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCURVE = 27;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCURVEDOWN = 153;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTCURVEUP = 152;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTDEFLATE = 161;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTDEFLATEBOTTOM = 163;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTDEFLATEINFLATE = 166;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTDEFLATEINFLATEDEFLATE = 167;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTDEFLATETOP = 165;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTFADEDOWN = 171;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTFADELEFT = 169;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTFADERIGHT = 168;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTFADEUP = 170;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTHEXAGON = 26;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTINFLATE = 160;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTINFLATEBOTTOM = 162;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTINFLATETOP = 164;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTOCTAGON = 25;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTONCURVE = 30;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTONRING = 31;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTPLAINTEXT = 136;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTRING = 29;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTRINGINSIDE = 142;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTRINGOUTSIDE = 143;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTSIMPLE = 24;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTSLANTDOWN = 173;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTSLANTUP = 172;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTSTOP = 137;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTTRIANGLE = 138;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTTRIANGLEINVERTED = 139;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTWAVE = 28;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTWAVE1 = 156;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTWAVE2 = 157;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTWAVE3 = 158;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TEXTWAVE4 = 159;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_THICKARROW = 14;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_TRAPEZOID = 8;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_UPARROW = 68;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_UPARROWCALLOUT = 79;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_UPDOWNARROW = 70;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_UPDOWNARROWCALLOUT = 82;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_UTURNARROW = 101;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_VERTICALSCROLL = 97;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_WAVE = 64;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_WEDGEELLIPSECALLOUT = 63;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_WEDGERECTCALLOUT = 61;

    @Removal(version = "5.3")
    @Deprecated
    public static final short ST_WEDGERRECTCALLOUT = 62;
    public static final short sid = 9876;
    private final Map<EscherRecord, Record> shapeToObj;
    private final Map<Integer, NoteRecord> tailRec;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShapeCollector extends DefaultEscherRecordFactory {
        final UnsynchronizedByteArrayOutputStream buffer;
        final List<EscherRecord> objShapes;

        private ShapeCollector() {
            this.objShapes = new ArrayList();
            this.buffer = new UnsynchronizedByteArrayOutputStream();
        }

        public void addBytes(byte[] bArr) {
            try {
                this.buffer.write(bArr);
            } catch (IOException e) {
                throw new RuntimeException("Couldn't get data from drawing/continue records", e);
            }
        }

        @Override // org.apache.poi.ddf.DefaultEscherRecordFactory, org.apache.poi.ddf.EscherRecordFactory
        public EscherRecord createRecord(byte[] bArr, int i5) {
            EscherRecord escherRecordCreateRecord = super.createRecord(bArr, i5);
            short recordId = escherRecordCreateRecord.getRecordId();
            if (recordId != EscherClientDataRecord.RECORD_ID && recordId != EscherTextboxRecord.RECORD_ID) {
                return escherRecordCreateRecord;
            }
            this.objShapes.add(escherRecordCreateRecord);
            return escherRecordCreateRecord;
        }

        public List<EscherRecord> parse(EscherAggregate escherAggregate) {
            byte[] byteArray = this.buffer.toByteArray();
            int iFillFields = 0;
            while (iFillFields < byteArray.length) {
                EscherRecord escherRecordCreateRecord = createRecord(byteArray, iFillFields);
                iFillFields += escherRecordCreateRecord.fillFields(byteArray, iFillFields, this);
                escherAggregate.addEscherRecord(escherRecordCreateRecord);
            }
            return this.objShapes;
        }
    }

    public EscherAggregate(boolean z6) {
        this.shapeToObj = new HashMap();
        this.tailRec = new LinkedHashMap();
        if (z6) {
            buildBaseTree();
        }
    }

    private void buildBaseTree() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord3 = new EscherContainerRecord();
        EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.DG_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        EscherDgRecord escherDgRecord = new EscherDgRecord();
        escherDgRecord.setRecordId(EscherDgRecord.RECORD_ID);
        escherDgRecord.setOptions((short) 16);
        escherDgRecord.setNumShapes(0);
        escherDgRecord.setLastMSOSPID(1024);
        escherContainerRecord2.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord2.setOptions((short) 15);
        escherContainerRecord3.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord3.setOptions((short) 15);
        escherSpgrRecord.setRecordId(EscherSpgrRecord.RECORD_ID);
        escherSpgrRecord.setOptions((short) 1);
        escherSpgrRecord.setRectX1(0);
        escherSpgrRecord.setRectY1(0);
        escherSpgrRecord.setRectX2(IEEEDouble.EXPONENT_BIAS);
        escherSpgrRecord.setRectY2(255);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        escherSpRecord.setVersion((short) 2);
        escherSpRecord.setShapeId(-1);
        escherSpRecord.setFlags(5);
        escherContainerRecord.addChildRecord(escherDgRecord);
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        escherContainerRecord2.addChildRecord(escherContainerRecord3);
        escherContainerRecord3.addChildRecord(escherSpgrRecord);
        escherContainerRecord3.addChildRecord(escherSpRecord);
        addEscherRecord(escherContainerRecord);
    }

    public static EscherAggregate createAggregate(List<RecordBase> list, int i5) {
        EscherAggregate escherAggregate = new EscherAggregate(false);
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList arrayList = new ArrayList();
        int i6 = i5;
        for (RecordBase recordBase : list.subList(i5, list.size())) {
            int i7 = i6 + 1;
            short sSid = sid(recordBase);
            if (sSid == 28) {
                NoteRecord noteRecord = (NoteRecord) recordBase;
                escherAggregate.tailRec.put(Integer.valueOf(noteRecord.getShapeId()), noteRecord);
            } else if (sSid == 60) {
                shapeCollector.addBytes(((ContinueRecord) recordBase).getData());
            } else if (sSid == 93) {
                arrayList.add((Record) recordBase);
            } else if (sSid != 236) {
                if (sSid != 438) {
                    break;
                }
                arrayList.add((Record) recordBase);
            } else {
                shapeCollector.addBytes(((DrawingRecord) recordBase).getRecordData());
            }
            i6 = i7;
        }
        list.set(i5, escherAggregate);
        int i8 = i5 + 1;
        if (i8 <= i6) {
            list.subList(i8, i6).clear();
        }
        arrayList.forEach(new C(escherAggregate, shapeCollector.parse(escherAggregate).iterator(), 0));
        return escherAggregate;
    }

    private int getEscherRecordSize(List<EscherRecord> list) {
        Iterator<EscherRecord> it = list.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAggregate$0(EscherAggregate escherAggregate, Iterator it, Record record) {
        escherAggregate.shapeToObj.put((EscherRecord) it.next(), record);
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    private static short sid(RecordBase recordBase) {
        if (recordBase instanceof Record) {
            return ((Record) recordBase).getSid();
        }
        return (short) -1;
    }

    private int writeDataIntoDrawingRecord(byte[] bArr, int i5, int i6, byte[] bArr2, boolean z6) {
        boolean z7 = z6 || i5 + bArr.length <= 8224;
        int i7 = 0;
        int iSerialize = 0;
        while (i7 < bArr.length) {
            int i8 = i7 + 8224;
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7, Math.min(i8, bArr.length));
            iSerialize += (z7 ? new DrawingRecord(bArrCopyOfRange) : new ContinueRecord(bArrCopyOfRange)).serialize(i6 + iSerialize, bArr2);
            z7 = false;
            i7 = i8;
        }
        return iSerialize;
    }

    public void addTailRecord(NoteRecord noteRecord) {
        this.tailRec.put(Integer.valueOf(noteRecord.getShapeId()), noteRecord);
    }

    public void associateShapeToObjRecord(EscherRecord escherRecord, Record record) {
        this.shapeToObj.put(escherRecord, record);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public NoteRecord getNoteRecordByObj(ObjRecord objRecord) {
        return this.tailRec.get(Integer.valueOf(((CommonObjectDataSubRecord) objRecord.getSubRecords().get(0)).getObjectId()));
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    public String getRecordName() {
        return "ESCHERAGGREGATE";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        List<EscherRecord> escherRecords = getEscherRecords();
        int escherRecordSize = getEscherRecordSize(escherRecords);
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(escherRecordSize, MAX_RECORD_LENGTH);
        final ArrayList arrayList = new ArrayList();
        Iterator<EscherRecord> it = escherRecords.iterator();
        int recordSize = 0;
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArrSafelyAllocate, new EscherSerializationListener() { // from class: org.apache.poi.hssf.record.EscherAggregate.2
                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void afterRecordSerialize(int i5, short s6, int i6, EscherRecord escherRecord) {
                    if (s6 == EscherClientDataRecord.RECORD_ID || s6 == EscherTextboxRecord.RECORD_ID) {
                        arrayList.add(Integer.valueOf(i5));
                    }
                }

                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void beforeRecordSerialize(int i5, short s6, EscherRecord escherRecord) {
                }
            });
        }
        arrayList.add(0, 0);
        int iIntValue = 0;
        for (int i5 = 1; i5 < arrayList.size(); i5++) {
            if (i5 == arrayList.size() - 1 && ((Integer) arrayList.get(i5)).intValue() < iSerialize) {
                iIntValue += 4;
            }
            int i6 = i5 - 1;
            if (((Integer) arrayList.get(i5)).intValue() - ((Integer) arrayList.get(i6)).intValue() > 8224) {
                iIntValue = (((((Integer) arrayList.get(i5)).intValue() - ((Integer) arrayList.get(i6)).intValue()) / 8224) * 4) + iIntValue;
            }
        }
        int size = (this.shapeToObj.size() * 4) + escherRecordSize;
        if (escherRecordSize != 0 && arrayList.size() == 1) {
            iIntValue += 4;
        }
        Iterator<Record> it2 = this.shapeToObj.values().iterator();
        int recordSize2 = 0;
        while (it2.hasNext()) {
            recordSize2 += it2.next().getRecordSize();
        }
        Iterator<NoteRecord> it3 = this.tailRec.values().iterator();
        while (it3.hasNext()) {
            recordSize += it3.next().getRecordSize();
        }
        return size + recordSize2 + recordSize + iIntValue;
    }

    public Map<EscherRecord, Record> getShapeToObjMapping() {
        return Collections.unmodifiableMap(this.shapeToObj);
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public Map<Integer, NoteRecord> getTailRecords() {
        return Collections.unmodifiableMap(this.tailRec);
    }

    public void removeShapeToObjRecord(EscherRecord escherRecord) {
        this.shapeToObj.remove(escherRecord);
    }

    public void removeTailRecord(NoteRecord noteRecord) {
        this.tailRec.remove(Integer.valueOf(noteRecord.getShapeId()));
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int serialize(int i5, byte[] bArr) {
        List<EscherRecord> escherRecords = getEscherRecords();
        int escherRecordSize = getEscherRecordSize(escherRecords);
        byte[] bArr2 = new byte[escherRecordSize];
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<EscherRecord> it = escherRecords.iterator();
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr2, new EscherSerializationListener() { // from class: org.apache.poi.hssf.record.EscherAggregate.1
                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void afterRecordSerialize(int i6, short s6, int i7, EscherRecord escherRecord) {
                    if (s6 == EscherClientDataRecord.RECORD_ID || s6 == EscherTextboxRecord.RECORD_ID) {
                        arrayList.add(Integer.valueOf(i6));
                        arrayList2.add(escherRecord);
                    }
                }

                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void beforeRecordSerialize(int i6, short s6, EscherRecord escherRecord) {
                }
            });
        }
        arrayList2.add(0, null);
        arrayList.add(0, 0);
        int i6 = 1;
        int iSerialize2 = i5;
        boolean z6 = true;
        int i7 = 0;
        int length = 0;
        while (i6 < arrayList2.size()) {
            int iIntValue = ((Integer) arrayList.get(i6)).intValue();
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, i7, iIntValue);
            int iWriteDataIntoDrawingRecord = iSerialize2 + writeDataIntoDrawingRecord(bArrCopyOfRange, length, iSerialize2, bArr, z6);
            length += bArrCopyOfRange.length;
            iSerialize2 = iWriteDataIntoDrawingRecord + this.shapeToObj.get(arrayList2.get(i6)).serialize(iWriteDataIntoDrawingRecord, bArr);
            i6++;
            z6 = false;
            i7 = iIntValue;
        }
        if (i7 < escherRecordSize - 1) {
            iSerialize2 += writeDataIntoDrawingRecord(Arrays.copyOfRange(bArr2, i7, escherRecordSize), length, iSerialize2, bArr, z6);
        }
        Iterator<NoteRecord> it2 = this.tailRec.values().iterator();
        while (it2.hasNext()) {
            iSerialize2 += it2.next().serialize(iSerialize2, bArr);
        }
        int i8 = iSerialize2 - i5;
        if (i8 == getRecordSize()) {
            return i8;
        }
        throw new RecordFormatException(i8 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    public void setDgId(short s6) {
        EscherDgRecord escherDgRecord = (EscherDgRecord) getEscherContainer().getChildById(EscherDgRecord.RECORD_ID);
        if (escherDgRecord != null) {
            escherDgRecord.setOptions((short) (s6 << 4));
        }
    }

    public void setMainSpRecordId(int i5) {
        EscherSpRecord escherSpRecord;
        EscherContainerRecord escherContainerRecord = (EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SPGR_CONTAINER);
        if (escherContainerRecord == null || (escherSpRecord = (EscherSpRecord) ((EscherContainerRecord) escherContainerRecord.getChild(0)).getChildById(EscherSpRecord.RECORD_ID)) == null) {
            return;
        }
        escherSpRecord.setShapeId(i5);
    }

    public String toXml(String str) {
        return GenericRecordXmlWriter.marshal(this);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ESCHER_AGGREGATE;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public EscherAggregate copy() {
        return new EscherAggregate(this);
    }

    public EscherAggregate(EscherAggregate escherAggregate) {
        super(escherAggregate);
        HashMap map = new HashMap();
        this.shapeToObj = map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.tailRec = linkedHashMap;
        map.putAll(escherAggregate.shapeToObj);
        linkedHashMap.putAll(escherAggregate.tailRec);
    }
}

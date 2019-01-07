package com.frightanic.smn;

import com.frightanic.smn.api.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Static map of all SMN stations. Stores meta-data for each station. Source:
 * https://data.geo.admin.ch/ch.meteoschweiz.messwerte-aktuell/info/VQHA80_de.txt contains a list of stations with all their
 * metadata.
 */
public final class StationMap {
  private static final Logger LOGGER = LoggerFactory.getLogger(StationMap.class);
  private static final Map<String, Station> MAP = new HashMap<>();

  private StationMap() {
    // utility class
  }

  static {
    MAP.put("TAE", new Station("TAE", "Aadorf / Tänikon", 710517, 259824, 47.483333, 8.9, 539));
    MAP.put("COM", new Station("COM", "Acquarossa / Comprovasco", 714984, 146451, 46.466667, 8.933333, 575));
    MAP.put("ABO", new Station("ABO", "Adelboden", 609350, 149001, 46.5, 7.566667, 1322));
    MAP.put("AIG", new Station("AIG", "Aigle", 560404, 130713, 46.333333, 6.916667, 381));
    MAP.put("ALT", new Station("ALT", "Altdorf", 690180, 193564, 46.883333, 8.616667, 438));
    MAP.put("ARH", new Station("ARH", "Altenrhein", 760382, 261386, 47.483333, 9.566667, 398));
    MAP.put("AND", new Station("AND", "Andeer", 752691, 164038, 46.616667, 9.433333, 987));
    MAP.put("ANT", new Station("ANT", "Andermatt", 687444, 165044, 46.633333, 8.583333, 1438));
    MAP.put("ARO", new Station("ARO", "Arosa", 771030, 184825, 46.8, 9.683333, 1878));
    MAP.put("RAG", new Station("RAG", "Bad Ragaz", 756910, 209350, 47.016667, 9.5, 496));
    MAP.put("BAN", new Station("BAN", "Bantiger", 606850, 202975, 46.983333, 7.533333, 941));
    MAP.put("BAS", new Station("BAS", "Basel / Binningen", 610908, 265611, 47.533333, 7.583333, 316));
    MAP.put("LAT", new Station("LAT", "Bergün / Latsch", 777273, 166618, 46.633333, 9.75, 1407));
    MAP.put("BER", new Station("BER", "Bern / Zollikofen", 601933, 204409, 46.983333, 7.466667, 552));
    MAP.put("BEZ", new Station("BEZ", "Beznau", 659812, 267696, 47.55, 8.233333, 325));
    MAP.put("BIA", new Station("BIA", "Biasca", 718550, 132800, 46.333333, 8.983333, 278));
    MAP.put("BIN", new Station("BIN", "Binn", 657996, 135422, 46.366667, 8.2, 1479));
    MAP.put("BIZ", new Station("BIZ", "Bischofszell", 735325, 262285, 47.5, 9.233333, 470));
    MAP.put("BIV", new Station("BIV", "Bivio", 771281, 148119, 46.466667, 9.666667, 1856));
    MAP.put("BIE", new Station("BIE", "Bière", 515887, 153210, 46.516667, 6.35, 683));
    MAP.put("BLA", new Station("BLA", "Blatten, Lötschental", 629564, 141084, 46.416667, 7.816667, 1538));
    MAP.put("BOL", new Station("BOL", "Boltigen", 595831, 163587, 46.616667, 7.383333, 820));
    MAP.put("BOU", new Station("BOU", "Bouveret", 555264, 138175, 46.4, 6.85, 374));
    MAP.put("BRZ", new Station("BRZ", "Brienz", 647552, 176803, 46.733333, 8.066667, 567));
    MAP.put("BUS", new Station("BUS", "Buchs / Aarau", 648395, 248369, 47.383333, 8.083333, 386));
    MAP.put("BUF", new Station("BUF", "Buffalora", 816494, 170225, 46.65, 10.266667, 1968));
    MAP.put("FRE", new Station("FRE", "Bullet / La Frétaz", 534225, 188081, 46.833333, 6.583333, 1205));
    MAP.put("CEV", new Station("CEV", "Cevio", 689688, 130565, 46.316667, 8.6, 417));
    MAP.put("CHZ", new Station("CHZ", "Cham", 677758, 226878, 47.183333, 8.466667, 442));
    MAP.put("CHA", new Station("CHA", "Chasseral", 570845, 220157, 47.133333, 7.05, 1599));
    MAP.put("CHM", new Station("CHM", "Chaumont", 565060, 211006, 47.05, 6.983333, 1136));
    MAP.put("CHU", new Station("CHU", "Chur", 759465, 193152, 46.866667, 9.533333, 556));
    MAP.put("CHD", new Station("CHD", "Château-d'Oex", 577040, 147654, 46.483333, 7.133333, 1028));
    MAP.put("CIM", new Station("CIM", "Cimetta", 704433, 117457, 46.2, 8.783333, 1661));
    MAP.put("CDM", new Station("CDM", "Col des Mosses", 573817, 137852, 46.383333, 7.1, 1412));
    MAP.put("GSB", new Station("GSB", "Col du Grand St-Bernard", 579192, 79753, 45.866667, 7.166667, 2472));
    MAP.put("COY", new Station("COY", "Courtelary", 573622, 225597, 47.183333, 7.083333, 695));
    MAP.put("CMA", new Station("CMA", "Crap Masegn", 732820, 189380, 46.85, 9.183333, 2480));
    MAP.put("CRM", new Station("CRM", "Cressier", 571162, 210797, 47.05, 7.066667, 430));
    MAP.put("DAV", new Station("DAV", "Davos", 783518, 187458, 46.816667, 9.85, 1594));
    MAP.put("DEM", new Station("DEM", "Delémont", 593269, 244543, 47.35, 7.35, 439));
    MAP.put("DIS", new Station("DIS", "Disentis", 708190, 173793, 46.7, 8.85, 1197));
    MAP.put("EBK", new Station("EBK", "Ebnat-Kappel", 726347, 237176, 47.266667, 9.116667, 623));
    MAP.put("EGH", new Station("EGH", "Eggishorn", 650279, 141897, 46.433333, 8.1, 2893));
    MAP.put("EGO", new Station("EGO", "Egolzwil", 642912, 225540, 47.183333, 8, 521));
    MAP.put("EIN", new Station("EIN", "Einsiedeln", 699982, 221068, 47.133333, 8.75, 910));
    MAP.put("ELM", new Station("ELM", "Elm", 732265, 198425, 46.916667, 9.183333, 957));
    MAP.put("ENG", new Station("ENG", "Engelberg", 674160, 186069, 46.816667, 8.416667, 1035));
    MAP.put("EVI", new Station("EVI", "Evionnaz", 568197, 114693, 46.183333, 7.033333, 482));
    MAP.put("EVO", new Station("EVO", "Evolène / Villa", 605412, 106748, 46.116667, 7.516667, 1825));
    MAP.put("FAH", new Station("FAH", "Fahy", 562464, 252675, 47.416667, 6.933333, 596));
    MAP.put("FLU", new Station("FLU", "Flühli, LU", 644332, 193311, 46.883333, 8.016667, 939));
    MAP.put("GRA", new Station("GRA", "Fribourg / Posieux", 575183, 180076, 46.766667, 7.116667, 650));
    MAP.put("FRU", new Station("FRU", "Frutigen", 616773, 160884, 46.6, 7.65, 756));
    MAP.put("GVE", new Station("GVE", "Genève / Cointrin", 498904, 122631, 46.25, 6.133333, 410));
    MAP.put("GES", new Station("GES", "Gersau", 682509, 205571, 47, 8.516667, 521));
    MAP.put("GIH", new Station("GIH", "Giswil", 657322, 188976, 46.85, 8.183333, 471));
    MAP.put("GLA", new Station("GLA", "Glarus", 723755, 210567, 47.033333, 9.066667, 516));
    MAP.put("GOR", new Station("GOR", "Gornergrat", 626900, 92512, 45.983333, 7.783333, 3129));
    MAP.put("GRE", new Station("GRE", "Grenchen", 598218, 225349, 47.183333, 7.416667, 427));
    MAP.put("GRH", new Station("GRH", "Grimsel Hospiz", 668583, 158215, 46.566667, 8.333333, 1980));
    MAP.put("GRO", new Station("GRO", "Grono", 733016, 124090, 46.25, 9.166667, 323));
    MAP.put("GRC", new Station("GRC", "Grächen", 630738, 116062, 46.2, 7.833333, 1605));
    MAP.put("GOS", new Station("GOS", "Göschenen", 688477, 171926, 46.7, 8.6, 950));
    MAP.put("GOE", new Station("GOE", "Gösgen", 640421, 245949, 47.366667, 7.966667, 380));
    MAP.put("GUE", new Station("GUE", "Gütsch, Andermatt", 690050, 167475, 46.65, 8.616667, 2283));
    MAP.put("GUT", new Station("GUT", "Güttingen", 738421, 273962, 47.6, 9.283333, 440));
    MAP.put("HLL", new Station("HLL", "Hallau", 677456, 283472, 47.7, 8.466667, 419));
    MAP.put("HOE", new Station("HOE", "Hörnli", 713516, 247756, 47.366667, 8.933333, 1144));
    MAP.put("ILZ", new Station("ILZ", "Ilanz", 735685, 181965, 46.783333, 9.216667, 698));
    MAP.put("INT", new Station("INT", "Interlaken", 633023, 169092, 46.666667, 7.866667, 577));
    MAP.put("JUN", new Station("JUN", "Jungfraujoch", 641930, 155275, 46.55, 7.983333, 3580));
    MAP.put("KOP", new Station("KOP", "Koppigen", 612662, 218664, 47.116667, 7.6, 485));
    MAP.put("BRL", new Station("BRL", "La Brévine", 536981, 203974, 46.983333, 6.616667, 1050));
    MAP.put("CDF", new Station("CDF", "La Chaux-de-Fonds", 550919, 214861, 47.083333, 6.8, 1017));
    MAP.put("DOL", new Station("DOL", "La Dôle", 497060, 142371, 46.416667, 6.1, 1669));
    MAP.put("LAC", new Station("LAC", "Lachen / Galgenen", 707637, 226334, 47.183333, 8.866667, 468));
    MAP.put("LAG", new Station("LAG", "Langnau i.E.",628003, 198793, 46.933333, 7.8, 743));
    MAP.put("MLS", new Station("MLS", "Le Moléson", 567718, 155076, 46.55, 7.016667, 1974));
    MAP.put("LEI", new Station("LEI", "Leibstadt", 656373, 272121, 47.6, 8.183333, 341));
    MAP.put("ATT", new Station("ATT", "Les Attelas", 586854, 105302, 46.1, 7.266667, 2735));
    MAP.put("CHB", new Station("CHB", "Les Charbonnières", 513821, 169387, 46.666667, 6.316667, 1045));
    MAP.put("DIA", new Station("DIA", "Les Diablerets", 581914, 130622, 46.333333, 7.2, 2964));
    MAP.put("MAR", new Station("MAR", "Les Marécottes", 567375, 107577, 46.116667, 7.016667, 990));
    MAP.put("OTL", new Station("OTL", "Locarno / Monti", 704172, 114342, 46.166667, 8.783333, 366));
    MAP.put("LUG", new Station("LUG", "Lugano", 717873, 95884, 46, 8.966667, 273));
    MAP.put("LUZ", new Station("LUZ", "Luzern", 665543, 209849, 47.033333, 8.3, 454));
    MAP.put("LAE", new Station("LAE", "Lägern", 672250, 259460, 47.483333, 8.4, 845));
    MAP.put("MAG", new Station("MAG", "Magadino / Cadenazzo", 715479, 113161, 46.166667, 8.933333, 203));
    MAP.put("MAS", new Station("MAS", "Marsens", 571758, 167316, 46.65, 7.066667, 714));
    MAP.put("MAH", new Station("MAH", "Mathod", 533458, 176567, 46.733333, 6.566667, 437));
    MAP.put("MTR", new Station("MTR", "Matro", 714263, 140943, 46.416667, 8.916667, 2171));
    MAP.put("MER", new Station("MER", "Meiringen", 655844, 175930, 46.733333, 8.166667, 588));
    MAP.put("MOB", new Station("MOB", "Montagnier, Bagnes", 583492, 102189, 46.066667, 7.233333, 839));
    MAP.put("MVE", new Station("MVE", "Montana", 601709, 127488, 46.3, 7.466667, 1427));
    MAP.put("GEN", new Station("GEN", "Monte Generoso", 722503, 87456, 45.933333, 9.016667, 1600));
    MAP.put("MRP", new Station("MRP", "Monte Rosa-Plattje", 629149, 89520, 45.95, 7.816667, 2885));
    MAP.put("MOA", new Station("MOA", "Mosen", 660127, 232851, 47.25, 8.233333, 453));
    MAP.put("MTE", new Station("MTE", "Mottec", 614325, 110730, 46.15, 7.616667, 1580));
    MAP.put("MOE", new Station("MOE", "Möhlin", 633053, 269147, 47.566667, 7.883333, 343));
    MAP.put("MUB", new Station("MUB", "Mühleberg", 587792, 202479, 46.966667, 7.283333, 479));
    MAP.put("MSK", new Station("MSK", "Mühleberg / Stockeren", 588150, 200125, 46.95, 7.283333, 775));
    MAP.put("NAS", new Station("NAS", "Naluns / Schlivera", 815374, 188987, 46.816667, 10.266667, 2380));
    MAP.put("NAP", new Station("NAP", "Napf", 638136, 206078, 47, 7.933333, 1403));
    MAP.put("NEU", new Station("NEU", "Neuchâtel", 563086, 205559, 47, 6.95, 485));
    MAP.put("CGI", new Station("CGI", "Nyon / Changins", 506878, 139572, 46.4, 6.233333, 455));
    MAP.put("OBR", new Station("OBR", "Oberriet / Kriessern", 764170, 249582, 47.383333, 9.616667, 409));
    MAP.put("AEG", new Station("AEG", "Oberägeri", 688728, 220956, 47.133333, 8.6, 724));
    MAP.put("ORO", new Station("ORO", "Oron", 555505, 158052, 46.566667, 6.85, 828));
    MAP.put("BEH", new Station("BEH", "Passo del Bernina", 798422, 143020, 46.416667, 10.016667, 2260));
    MAP.put("PAY", new Station("PAY", "Payerne", 562131, 184611, 46.816667, 6.95, 490));
    MAP.put("PIL", new Station("PIL", "Pilatus", 661904, 203410, 46.983333, 8.25, 2106));
    MAP.put("PIO", new Station("PIO", "Piotta", 695880, 152264, 46.516667, 8.683333, 990));
    MAP.put("COV", new Station("COV", "Piz Corvatsch", 783150, 143521, 46.416667, 9.816667, 3302));
    MAP.put("PMA", new Station("PMA", "Piz Martegnas", 760261, 160570, 46.583333, 9.533333, 2670));
    MAP.put("PLF", new Station("PLF", "Plaffeien", 586828, 177406, 46.75, 7.266667, 1042));
    MAP.put("ROB", new Station("ROB", "Poschiavo / Robbia", 801992, 136248, 46.35, 10.066667, 1078));
    MAP.put("PUY", new Station("PUY", "Pully", 540819, 151510, 46.516667, 6.666667, 455));
    MAP.put("QUI", new Station("QUI", "Quinten", 734848, 221278, 47.133333, 9.216667, 419));
    MAP.put("ROE", new Station("ROE", "Robièi", 682587, 144091, 46.45, 8.516667, 1896));
    MAP.put("RUE", new Station("RUE", "Rünenberg", 633252, 253845, 47.433333, 7.883333, 611));
    MAP.put("SBE", new Station("SBE", "S. Bernardino", 734115, 147294, 46.466667, 9.183333, 1638));
    MAP.put("HAI", new Station("HAI", "Salen-Reutenen", 719099, 279047, 47.65, 9.016667, 718));
    MAP.put("SAM", new Station("SAM", "Samedan", 787249, 155685, 46.533333, 9.883333, 1708));
    MAP.put("SAG", new Station("SAG", "Sattel, SZ", 690999, 215145, 47.083333, 8.633333, 790));
    MAP.put("SHA", new Station("SHA", "Schaffhausen", 688702, 282803, 47.683333, 8.616667, 438));
    MAP.put("SRS", new Station("SRS", "Schiers", 769617, 205125, 46.983333, 9.666667, 626));
    MAP.put("SCM", new Station("SCM", "Schmerikon", 713725, 231533, 47.216667, 8.933333, 408));
    MAP.put("SPF", new Station("SPF", "Schüpfheim", 643683, 199710, 46.95, 8.016667, 744));
    MAP.put("SCU", new Station("SCU", "Scuol", 817137, 186393, 46.8, 10.283333, 1303));
    MAP.put("SIA", new Station("SIA", "Segl-Maria", 778574, 144976, 46.433333, 9.766667, 1804));
    MAP.put("SIM", new Station("SIM", "Simplon-Dorf", 647683, 116340, 46.2, 8.05, 1465));
    MAP.put("SIO", new Station("SIO", "Sion", 591633, 118583, 46.216667, 7.333333, 482));
    MAP.put("PRE", new Station("PRE", "St-Prex", 523549, 148525, 46.483333, 6.45, 425));
    MAP.put("STC", new Station("STC", "St. Chrischona", 618695, 269036, 47.566667, 7.683333, 493));
    MAP.put("STG", new Station("STG", "St. Gallen", 747865, 254588, 47.433333, 9.4, 775));
    MAP.put("SMM", new Station("SMM", "Sta. Maria, Val Müstair", 828861, 165579, 46.6, 10.433333, 1386));
    MAP.put("SBO", new Station("SBO", "Stabio", 716048, 77973, 45.85, 8.933333, 353));
    MAP.put("STK", new Station("STK", "Steckborn", 715870, 280916, 47.666667, 8.983333, 397));
    MAP.put("SAE", new Station("SAE", "Säntis", 744183, 234918, 47.25, 9.35, 2502));
    MAP.put("THU", new Station("THU", "Thun", 611200, 177640, 46.75, 7.583333, 570));
    MAP.put("TIT", new Station("TIT", "Titlis", 675400, 180400, 46.766667, 8.433333, 3040));
    MAP.put("UEB", new Station("UEB", "Uetliberg", 679454, 245034, 47.35, 8.483333, 854));
    MAP.put("ULR", new Station("ULR", "Ulrichen", 666747, 150767, 46.5, 8.3, 1345));
    MAP.put("VAD", new Station("VAD", "Vaduz", 757722, 221699, 47.133333, 9.516667, 457));
    MAP.put("VAB", new Station("VAB", "Valbella", 761634, 180385, 46.75, 9.55, 1568));
    MAP.put("VLS", new Station("VLS", "Vals", 734016, 165551, 46.633333, 9.183333, 1242));
    MAP.put("VEV", new Station("VEV", "Vevey / Corseaux", 552106, 146847, 46.466667, 6.816667, 405));
    MAP.put("VIO", new Station("VIO", "Vicosoprano", 768485, 135866, 46.35, 9.633333, 1089));
    MAP.put("VIT", new Station("VIT", "Villars-Tiercelin", 544198, 163650, 46.616667, 6.716667, 859));
    MAP.put("VIS", new Station("VIS", "Visp", 631150, 128024, 46.3, 7.85, 639));
    MAP.put("WFJ", new Station("WFJ", "Weissfluhjoch", 780614, 189634, 46.833333, 9.8, 2691));
    MAP.put("WYN", new Station("WYN", "Wynau", 626404, 233848, 47.25, 7.783333, 422));
    MAP.put("WAE", new Station("WAE", "Wädenswil", 693847, 230744, 47.216667, 8.683333, 485));
    MAP.put("PSI", new Station("PSI", "Würenlingen / PSI", 659355, 265380, 47.533333, 8.233333, 334));
    MAP.put("ZER", new Station("ZER", "Zermatt", 624298, 97574, 46.033333, 7.75, 1638));
    MAP.put("REH", new Station("REH", "Zürich / Affoltern", 681432, 253548, 47.433333, 8.516667, 443));
    MAP.put("SMA", new Station("SMA", "Zürich / Fluntern", 685116, 248065, 47.383333, 8.566667, 555));
    MAP.put("KLO", new Station("KLO", "Zürich / Kloten", 682710, 259338, 47.483333, 8.533333, 426));
  }

  /**
   * Returns the station for the given code or null.
   *
   * @param code upper-case SMN code such as 'HOE'
   * @return station or null
   */
  public static Station get(String code) {
    Station station = MAP.get(code);
    if (station == null) {
      LOGGER.warn("No station meta-data available for '{}'.", code);
    }
    return station;
  }
}

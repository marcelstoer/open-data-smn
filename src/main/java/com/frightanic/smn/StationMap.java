package com.frightanic.smn;

import com.frightanic.smn.api.Station;

import java.util.HashMap;
import java.util.Map;

/**
 * Static map of all SMN stations. Stores meta-data for each station.
 */
public final class StationMap {
  private static final Map<String, Station> MAP = new HashMap<>();

  private StationMap(){
    // utility class
  }

  static {
    MAP.put("TAE", new Station("TAE", "Aadorf / Tänikon", 710514, 259821, 47.4798656101848, 8.90487073380479));
    MAP.put("COM", new Station("COM", "Acquarossa / Comprovasco", 714998, 146440, 46.459417646146, 8.93565185399796));
    MAP.put("ABO", new Station("ABO", "Adelboden", 609400, 148975, 46.4920219644093, 7.56107046494746));
    MAP.put("AIG", new Station("AIG", "Aigle", 560400, 130713, 46.3266430235642, 6.92442010713835));
    MAP.put("ALT", new Station("ALT", "Altdorf", 690174, 193558, 46.8870196529326, 8.62180380198374));
    MAP.put("AND", new Station("AND", "Andeer", 752687, 164035, 46.6101172538401, 9.43191033832129));
    MAP.put("BAS", new Station("BAS", "Basel / Binningen", 610911, 265600, 47.5410344530504, 7.58355531113649));
    MAP.put("BER", new Station("BER", "Bern / Zollikofen", 601929, 204409, 46.9907380051444, 7.46399539556357));
    MAP.put("BEZ", new Station("BEZ", "Beznau", 659808, 267693, 47.5572264128632, 8.23325335813757));
    MAP.put("BIE", new Station("BIE", "Bière", 515888, 153206, 46.5248640958054, 6.34239552456168));
    MAP.put("BUS", new Station("BUS", "Buchs / Aarau", 648389, 248365, 47.3843365892733, 8.07945080431874));
    MAP.put("FRE", new Station("FRE", "Bullet / La Frétaz", 534221, 188081, 46.8406158817807, 6.57631505871086));
    MAP.put("CHA", new Station("CHA", "Chasseral", 570842, 220154, 47.1317251222829, 7.05432266967391));
    MAP.put("CHU", new Station("CHU", "Chur", 759471, 193157, 46.8704059117362, 9.53057035777944));
    MAP.put("CIM", new Station("CIM", "Cimetta", 704433, 117452, 46.2004218343832, 8.79164245030769));
    MAP.put("GSB", new Station("GSB", "Col du Grand St-Bernard", 579200, 79720, 45.8687853402045, 7.17079950096375));
    MAP.put("DAV", new Station("DAV", "Davos", 783514, 187457, 46.8129562080056, 9.84348961918048));
    MAP.put("DIS", new Station("DIS", "Disentis / Sedrun", 708188, 173789, 46.7065316128356, 8.85344049269398));
    MAP.put("ENG", new Station("ENG", "Engelberg", 674156, 186097, 46.8218898122211, 8.41044407966648));
    MAP.put("EVO", new Station("EVO", "Evolène / Villa", 605415, 106740, 46.1121374956964, 7.50867577695555));
    MAP.put("FAH", new Station("FAH", "Fahy", 562458, 252676, 47.4238169986586, 6.94110403084587));
    MAP.put("GVE", new Station("GVE", "Genève-Cointrin", 498903, 122624, 46.247449465089, 6.12772466049919));
    MAP.put("GLA", new Station("GLA", "Glarus", 723752, 210567, 47.0345849430787, 9.0669015770812));
    MAP.put("GRH", new Station("GRH", "Grimsel Hospiz", 668583, 158215, 46.5716911603333, 8.33325155123996));
    MAP.put("GOE", new Station("GOE", "Gösgen", 640417, 245937, 47.3630361197977, 7.97366228620389));
    MAP.put("GUE", new Station("GUE", "Gütsch ob Andermatt", 690140, 167590, 46.6534573364687, 8.61624444240366));
    MAP.put("GUT", new Station("GUT", "Güttingen", 738419, 273960, 47.6017140906501, 9.27937890904876));
    MAP.put("HOE", new Station("HOE", "Hörnli", 713515, 247755, 47.3708509834111, 8.94161219191723));
    MAP.put("INT", new Station("INT", "Interlaken", 633019, 169093, 46.6722444362808, 7.87014022921899));
    MAP.put("JUN", new Station("JUN", "Jungfraujoch", 641930, 155275, 46.5474466171335, 7.98533074962599));
    MAP.put("CDF", new Station("CDF", "La Chaux-de-Fonds", 550923, 214893, 47.083227527603, 6.79236217734247));
    MAP.put("DOL", new Station("DOL", "La Dôle", 497061, 142362, 46.4246996116535, 6.09947680352535));
    MAP.put("MLS", new Station("MLS", "Le Moléson", 567723, 155072, 46.5461557457332, 7.01781324637386));
    MAP.put("LEI", new Station("LEI", "Leibstadt", 656378, 272111, 47.5972619269058, 8.18824494230146));
    MAP.put("OTL", new Station("OTL", "Locarno / Monti", 704160, 114350, 46.1725640792303, 8.78741560470555));
    MAP.put("LUG", new Station("LUG", "Lugano", 717873, 95884, 46.0042259772403, 8.96030751582468));
    MAP.put("LUZ", new Station("LUZ", "Luzern", 665540, 209848, 47.0364265819145, 8.30096191566564));
    MAP.put("LAE", new Station("LAE", "Lägern", 672250, 259460, 47.4819349333631, 8.39720963761465));
    MAP.put("MAG", new Station("MAG", "Magadino / Cadenazzo", 715475, 113162, 46.1600351411371, 8.93360690453619));
    MAP.put("MVE", new Station("MVE", "Montana", 601706, 127482, 46.2987429348438, 7.4607785993475));
    MAP.put("MRP", new Station("MRP", "Monte Rosa-Plattje", 629149, 89520, 45.9566302439615, 7.81458611643345));
    MAP.put("MOE", new Station("MOE", "Möhlin", 633050, 269142, 47.5721492327181, 7.87786102786742));
    MAP.put("MUB", new Station("MUB", "Mühleberg", 587788, 202478, 46.9732588722611, 7.27815330573383));
    MAP.put("NAP", new Station("NAP", "Napf", 638132, 206078, 47.0046580839788, 7.94004485409616));
    MAP.put("NEU", new Station("NEU", "Neuchâtel", 563150, 205600, 47.0004309289581, 6.95412531516132));
    MAP.put("CGI", new Station("CGI", "Nyon / Changins", 506880, 139573, 46.4010491034945, 6.22775290546194));
    MAP.put("PAY", new Station("PAY", "Payerne", 562127, 184612, 46.8115845232361, 6.94241980764273));
    MAP.put("PIL", new Station("PIL", "Pilatus", 661910, 203410, 46.9788679884085, 8.25232643434535));
    MAP.put("PIO", new Station("PIO", "Piotta", 695888, 152261, 46.5147811270825, 8.68813619838581));
    MAP.put("COV", new Station("COV", "Piz Corvatsch", 783146, 143519, 46.4179950938244, 9.82117965380986));
    MAP.put("PLF", new Station("PLF", "Plaffeien", 586808, 177400, 46.7476559472698, 7.26599961662007));
    MAP.put("ROB", new Station("ROB", "Poschiavo / Robbia", 801850, 136180, 46.3466435649771, 10.0611313011419));
    MAP.put("PUY", new Station("PUY", "Pully", 540811, 151514, 46.5123118387978, 6.66741106502265));
    MAP.put("ROE", new Station("ROE", "Robièi", 682587, 144091, 46.4430666805738, 8.5133789655127));
    MAP.put("RUE", new Station("RUE", "Rünenberg", 633246, 253845, 47.4345618598242, 7.87932494955346));
    MAP.put("SBE", new Station("SBE", "S. Bernardino", 734112, 147296, 46.4635635963581, 9.18464366199888));
    MAP.put("SAM", new Station("SAM", "Samedan", 787210, 155700, 46.5263952324829, 9.87894426591142));
    MAP.put("SHA", new Station("SHA", "Schaffhausen", 688698, 282796, 47.6897747246289, 8.62006156184061));
    MAP.put("SCU", new Station("SCU", "Scuol", 817135, 186393, 46.7932730895871, 10.2832147855995));
    MAP.put("SIO", new Station("SIO", "Sion", 591630, 118575, 46.2185693630369, 7.33016671307668));
    MAP.put("STG", new Station("STG", "St. Gallen", 747861, 254586, 47.4254611175553, 9.39846161236304));
    MAP.put("SBO", new Station("SBO", "Stabio", 716034, 77964, 45.8433785042042, 8.93217221523274));
    MAP.put("SAE", new Station("SAE", "Säntis", 744200, 234920, 47.2494413976821, 9.34362868326132));
    MAP.put("ULR", new Station("ULR", "Ulrichen", 666740, 150760, 46.5048195416325, 8.30813554042627));
    MAP.put("VAD", new Station("VAD", "Vaduz", 757718, 221696, 47.1274464538661, 9.51750545932092));
    MAP.put("VIS", new Station("VIS", "Visp", 631149, 128020, 46.3028630759321, 7.84293785963058));
    MAP.put("WFJ", new Station("WFJ", "Weissfluhjoch", 780615, 189635, 46.8333321796502, 9.80638447408206));
    MAP.put("WYN", new Station("WYN", "Wynau", 626400, 233850, 47.255031533783, 7.78740270818214));
    MAP.put("WAE", new Station("WAE", "Wädenswil", 693849, 230708, 47.2206347285515, 8.67771149999218));
    MAP.put("ZER", new Station("ZER", "Zermatt", 624350, 97566, 46.02919614897, 7.75310743639163));
    MAP.put("REH", new Station("REH", "Zürich / Affoltern", 681428, 253545, 47.4276680064869, 8.51788559876821));
    MAP.put("SMA", new Station("SMA", "Zürich / Fluntern", 685117, 248061, 47.37788228649, 8.56572989044059));
    MAP.put("KLO", new Station("KLO", "Zürich / Kloten", 682706, 259337, 47.4795972529174, 8.53589493902082));
    MAP.put("EBK", new Station("EBK", "Ebnat-Kappel", 726348, 237167, 47.273304109823, 9.10849572491865));
    MAP.put("BIZ", new Station("BIZ", "Bischofszell", 735325, 262285, 47.4973844860844, 9.23469610574162));
    MAP.put("SPF", new Station("SPF", "Schüpfheim", 643677, 199706, 46.9470006485667, 8.01234264167352));
    MAP.put("GIH", new Station("GIH", "Giswil", 657320, 188980, 46.8494845894586, 8.1901872008975));
    MAP.put("EGO", new Station("EGO", "Egolzwil", 642910, 225537, 47.1793945148474, 8.00471536059651));
    MAP.put("BUF", new Station("BUF", "Buffalora", 816494, 170225, 46.6481375438919, 10.267184151095));
    MAP.put("CRM", new Station("CRM", "Cressier", 571160, 210800, 47.0476012189039, 7.05911011263168));
    MAP.put("NAS", new Station("NAS", "Naluns / Schlivera", 815374, 188987, 46.8171641190244, 10.2613879737207));
    MAP.put("HAI", new Station("HAI", "Salen-Reutenen", 719102, 279042, 47.6511999115618, 9.02393114025726));
    MAP.put("GRE", new Station("GRE", "Grenchen", 598216, 225348, 47.1790838897612, 7.41510265303697));
    MAP.put("CMA", new Station("CMA", "Crap Masegn", 732820, 189380, 46.8422958147689, 9.17998933354038));
    MAP.put("ELM", new Station("ELM", "Elm", 732265, 198425, 46.9237490269023, 9.17534023178287));
    MAP.put("GRA", new Station("GRA", "Fribourg / Posieux", 575182, 180076, 46.771396166934, 7.11371186853416));
    MAP.put("LAG", new Station("LAG", "Langnau i.E.", 628005, 198792, 46.939624676323, 7.80643559081051));
    MAP.put("HLL", new Station("HLL", "Hallau", 677456, 283472, 47.6972788468148, 8.47045810518921));
    MAP.put("MER", new Station("MER", "Meiringen", 655843, 175920, 46.7321351879739, 8.16922852769843));
    MAP.put("VAB", new Station("VAB", "Valbella", 761637, 180380, 46.7549906589076, 9.55444949690734));
    MAP.put("SCM", new Station("SCM", "Schmerikon", 713722, 231496, 47.2246005188842, 8.94023396758032));
    MAP.put("QUI", new Station("QUI", "Quinten", 734848, 221278, 47.1287419931682, 9.21604230416234));
    MAP.put("PMA", new Station("PMA", "Piz Martegnas", 760267, 160583, 46.5773005835068, 9.52961722091492));
    MAP.put("SMM", new Station("SMM", "Sta. Maria, Val Müstair", 828858, 165569, 46.6021602831445, 10.4262523158962));
    MAP.put("KOP", new Station("KOP", "Koppigen", 612662, 218664, 47.1188437731359, 7.60548695538811));
    MAP.put("ORO", new Station("ORO", "Oron", 555502, 158048, 46.5722248742171, 6.85819527540231));
    MAP.put("PRE", new Station("PRE", "St-Prex", 523549, 148525, 46.4836778004649, 6.44300489604474));
    MAP.put("RAG", new Station("RAG", "Bad Ragaz", 756907, 209340, 47.0165353440425, 9.50253629846569));
    MAP.put("CHD", new Station("CHD", "Château-d'Oex", 577041, 147644, 46.4797214100593, 7.139667797942));
    MAP.put("STK", new Station("STK", "Steckborn", 715871, 280916, 47.6686292005605, 8.98142593062216));
    MAP.put("EIN", new Station("EIN", "Einsiedeln", 699981, 221058, 47.1329481119422, 8.75651765205525));
    MAP.put("EGH", new Station("EGH", "Eggishorn", 650279, 141897, 46.4265323138949, 8.09272861659522));
    MAP.put("BOU", new Station("BOU", "Bouveret", 555264, 138175, 46.3934441640058, 6.85701200475683));
    MAP.put("BRZ", new Station("BRZ", "Brienz", 647546, 176806, 46.7407480523312, 8.06077610588396));
    MAP.put("DEM", new Station("DEM", "Delémont", 593269, 244543, 47.3517025817606, 7.34955441506763));
    MAP.put("MOA", new Station("MOA", "Mosen", 660124, 232846, 47.2437927613342, 8.23276877144593));
    MAP.put("ATT", new Station("ATT", "Les Attelas", 586862, 105305, 46.0991228053999, 7.26874843020939));
    MAP.put("GEN", new Station("GEN", "Monte Generoso", 722503, 87456, 45.9276055169427, 9.01787277740671));
    MAP.put("GOR", new Station("GOR", "Gornergrat", 626900, 92512, 45.9836372007407, 7.7857506622667));
    MAP.put("GRO", new Station("GRO", "Grono", 733014, 124080, 46.254991245749, 9.16370831011765));
    MAP.put("BOL", new Station("BOL", "Boltigen", 595828, 163588, 46.6235274330422, 7.38416556356202));
    MAP.put("TIT", new Station("TIT", "Titlis", 675400, 180400, 46.7705073073692, 8.4258056927188));
    MAP.put("THU", new Station("THU", "Thun", 611202, 177630, 46.7497613024516, 7.58523830610707));
  }

  /**
   * Returns the station for the given code or null.
   *
   * @param code upper-case SMN code such as 'HOE'
   * @return station or null
   */
  public static Station get(String code) {
    return MAP.get(code);
  }
}

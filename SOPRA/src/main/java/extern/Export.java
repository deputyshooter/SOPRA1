package extern;

import projektelemente.Projekt;

/**
 * Bietet die Möglichkeit des PDF-Exports von Projekten.
 * 
 * @author Manuel Weber
 * 
 */
public class Export {

	/**
	 * Erzeugt eine PDF-Datei für ein übergebenes Projekt und gibt einen Link
	 * zum Speicherort zurück.
	 * 
	 * @param projekt
	 * @return Link zum Speicherort
	 */
	public static String pdfKomplett(Projekt projekt) {
		return "";
	}

	/**
	 * Erzeugt eine PDF-Datei für ein übergebenes Projekt und gibt einen Link
	 * zum Speicherort zurück. Im Gegensatz zu pdfKomplett() werden hier beim
	 * Export nur abgenommene Anforderungen berücksichtigt.
	 * 
	 * @param projekt
	 * @return 
	 * @return Link zum Speicherort
	 */
	public static String pdfAbgenommeAnforderungen(Projekt projekt) {
		return "";
	}
}

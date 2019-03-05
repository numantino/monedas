package es.raul.monedas.constantes;

/**
 * @author raul.gonzalez
 * 
 * Constantes comunes y path de los diferentes directorios que se usan
 * 
 */
public  interface constantesMonedas {
	/**
	 * Constantes comunes
	 */
	public final static int MAX_CONTINENTE = 6;
	/**
	 * Path
	 */
	public final static String PATH_MONEDAS = "MonedasdelMundo";
	public final static String PATH_EURO = "OtrasColecciones\\Euro";
	public final static String PATH_EURO_CON = "OtrasColecciones\\Euro\\conmemorativas";
	public final static String PATH_BILLETES = "OtrasColecciones\\Billetes";
	public final static String PATH_PESETAS = "OtrasColecciones\\Pesetas";
	public final static String PATH_SEPARADOR = "/";
	public final static String IMAGEN_PATH_PNG = ".png";
	public final static String IMAGEN_PATH_JPG = ".jpg";
	public final static String IMAGEN_PATH_GIF = ".gif";
	public final static String IMAGEN_PATH_PDF = ".pdf";
	public final static String IMAGEN_BASE = "Base";
	public final static String IMAGEN_ICONO_PDF = "pdf";
	public final static String IMAGEN_ICONO_MAS = "mas";
	/**
	 * 
	 */	
	public static enum CONTINENTES{
		EUROPA("Europa","Europa",3),
		AFRICA("Africa","Africa",1),
		ASIA("Asia","Asia",5),
		AMERICA_SUR("AmericaDelSur","America del Sur",2),
		AMERICA_NORTE("AmericaDelNorte","America del Norte",4),
		AMERICA_CENTRAL("AmericaCentral","America Central",6),
		OCEANIA("Oceania","Oceania",7);
		
		private final String nombre;
		private final String nombreCompleto;
		private final int numero;
		
		private CONTINENTES(String value,String value2, int num){
			this.nombre = value;
			this.nombreCompleto = value2;
			this.numero = num;
		}
		
		public String getNombre(){
			return nombre;
		}
		public String getNombreCompleto(){
			return nombreCompleto;
		}
		public int getNumero(){
			return numero;
		}
		public String getNumeroString(){
			return String.valueOf(numero);
		}
	}
	/**
	 * Valores que identifican los diferentes activity
	 */
	public final static int ACTIVITY_MONEDAS = 1; 
	public final static int ACTIVITY_MONEDAS_INFO = 4; 
	public final static int ACTIVITY_CONTINENTE = 2; 
	public final static int ACTIVITY_MAIN = 3; 
	
	/**
	 * Indica el tipo de mondeda del que se trata
	 * */
	public final static int TIPO_EURO=1;
	public final static int TIPO_EURO_CON=2;
	public final static int TIPO_MUNDO=3;
	public final static int TIPO_PESETA=4;
	public final static int TIPO_BILLETE=5;
	/**
	 * Valores que nos va ha dar la diferente informacion de la moneda
	 */
	public final static String INFORMACION_ACTUALIZACION = "ACTUALIZACION_DB";
	public final static String INFORMACION_ACTUALIZACION_DATOS = "ACTUALIZACION_DATOS";
	public final static String INFORMACION_ULTIMO_NUMERO_AFRICA = "NUMERO_AFRICA";
	public final static String INFORMACION_ULTIMO_NUMERO_EUROPA = "NUMERO_EUROPA";
	public final static String INFORMACION_ULTIMO_NUMERO_ASIA = "NUMERO_ASIA";
	public final static String INFORMACION_ULTIMO_NUMERO_AMERICA_NORTE = "NUMERO_AMERICA_NORTE";
	public final static String INFORMACION_ULTIMO_NUMERO_AMERICA_SUR = "NUMERO_AMERICA_SUR";
	public final static String INFORMACION_ULTIMO_NUMERO_AMERICA_CENTRAL = "NUMERO_AMERICA_CENTRAL";
	public final static String INFORMACION_ULTIMO_NUMERO_OCEANIA = "NUMERO_OCEANIA";
	public final static String INFORMACION_TOTAL_MONEDAS_MUNDO = "TOTAL_MONEDAS_MUNDO";
	public final static String INFORMACION_TOTAL_MONEDAS_EURO = "TOTAL_MONEDAS_EURO";
	public final static String INFORMACION_TOTAL_MONEDAS_PESETAS= "TOTAL_MONEDAS_PESETAS";
	/**
	 * Separadores
	 */
	public final static String SEPARADOR_E = "E";
	public final static String SEPARADOR_1 = "#";
	public final static String SEPARADOR_2 = "@";
	public final static String SEPARADOR_3 = "&";
	public final static String SEPARADOR_RASO = "_";
}

package es.raul.monedas.constantes;


/**
 * @author raul.gonzalez
 * 
 * Constantes relacionadas con la DB
 *
 */
public class constantesDatabase {
	/**
	 * Nombre del fichero donde se almacena la DB
	 */
	public static final String DB_NOMBRE = "coleccionMonedas.sqlite";
	/**
	 * Tabla en DB de MONEDAS 
	 */
	public static final String MONEDAS_NAME = "MONEDAS";
	public static final String MONEDAS_IDMONEDA = "IDMONEDA";
	public static final String MONEDAS_KMMONEDA = "KMMONEDA";
	public static final String MONEDAS_VALOR = "VALOR";
	public static final String MONEDAS_PAIS = "PAIS";
	public static final String MONEDAS_GRUPO = "GRUPO";
	public static final String MONEDAS_DATE = "DATE";
	public static final String MONEDAS_COMPOSICION = "COMPOSICION";
	public static final String MONEDAS_ANVERSO = "ANVERSO";
	public static final String MONEDAS_ANVERSOLEYENDA = "ANVERSOLEYENDA";
	public static final String MONEDAS_REVERSO = "REVERSO";
	public static final String MONEDAS_REVERSOEYENDA = "REVERSOEYENDA";
	public static final String MONEDAS_FORMA = "FORMA";
	public static final String MONEDAS_CANTO = "CANTO";
	public static final String MONEDAS_CANTOLEYENDA = "CANTOLEYENDA";
	public static final String MONEDAS_NOTA = "NOTA";
	public static final String MONEDAS_ESTADO = "ESTADO";	
	public static final String sqlCrearMonedas = "CREATE TABLE " + MONEDAS_NAME +
			"(" + MONEDAS_IDMONEDA + " INT PRIMARY KEY     NOT NULL, " +
			MONEDAS_KMMONEDA + " TEXT NOT NULL, " +
			MONEDAS_VALOR + " TEXT    NOT NULL, " + 
			MONEDAS_PAIS + " TEXT    NOT NULL, " + 
			MONEDAS_GRUPO + " TEXT, " + 
			MONEDAS_DATE + " TEXT, " + 
			MONEDAS_COMPOSICION + " TEXT, " + 
			MONEDAS_ANVERSO + " TEXT, " + 
			MONEDAS_ANVERSOLEYENDA + " TEXT, " +
			MONEDAS_REVERSO + " TEXT, " +
			MONEDAS_REVERSOEYENDA + " TEXT, " + 
			MONEDAS_FORMA + " TEXT, " +
			MONEDAS_CANTO + " TEXT, " +
			MONEDAS_CANTOLEYENDA + " TEXT, " +
			MONEDAS_NOTA + " TEXT, " + 
			MONEDAS_ESTADO + " TEXT)";			
	
	//Seleccion / sentencias SQL 
	public static final String[] MONEDA_COLUM ={MONEDAS_IDMONEDA,MONEDAS_KMMONEDA,MONEDAS_VALOR,MONEDAS_DATE};	
	public static final String MONEDA_SQL ="(" + MONEDAS_IDMONEDA + "," +MONEDAS_KMMONEDA + "," +MONEDAS_VALOR + "," +MONEDAS_PAIS + "," + "," +MONEDAS_GRUPO + "," +MONEDAS_DATE + "," +MONEDAS_COMPOSICION + "," +MONEDAS_ANVERSO + "," +MONEDAS_ANVERSOLEYENDA + "," +MONEDAS_REVERSO + "," +MONEDAS_REVERSOEYENDA + "," +MONEDAS_FORMA + "," +MONEDAS_CANTO + "," +MONEDAS_CANTOLEYENDA + "," +MONEDAS_NOTA + "," + MONEDAS_ESTADO + ")";
	/**
	 * Tabla en DB de MONEDAS AUXILIARES
	 */
	public static final String MONEDAS_AUX_NAME = "MONEDAS_AUX";
	public static final String MONEDAS_AUX_PAIS = "PAIS";
	public static final String MONEDAS_AUX_VALOR = "VALOR";
	public static final String MONEDAS_AUX_KM = "KM";
	public static final String sqlCrearMonedasAux = "CREATE TABLE " + MONEDAS_AUX_NAME +
			"(" + MONEDAS_AUX_PAIS + " TEXT PRIMARY KEY     NOT NULL, " +
			MONEDAS_AUX_KM + "INT" + 
			MONEDAS_AUX_VALOR + " TEXT NOT NULL)";	
	//Seleccion / sentencias SQL 
	public static final String[] MONEDA_AUX_COLUM ={MONEDAS_AUX_PAIS,MONEDAS_AUX_VALOR,MONEDAS_AUX_KM};	
	/**
	 * Tabla en DB de EUROS 
	 */
	public static final String EURO_NAME = "EUROS";
	public static final String EURO_PAIS = "PAIS";
	public static final String EURO_PERIODO = "PERIODO";
	public static final String EURO_1C = "unCent";
	public static final String EURO_2C = "dosCent";
	public static final String EURO_5C = "cincoCent";
	public static final String EURO_10C = "diezCent";
	public static final String EURO_20C = "veinteCent";
	public static final String EURO_50C = "cincuentaCent";
	public static final String EURO_1E = "unEur";
	public static final String EURO_2E = "dosEur";
	public static final String EURO_CONME = "conme";
	public static final String sqlCrearEuros = "CREATE TABLE " + EURO_NAME +
			"(" + EURO_PAIS + " TEXT NOT NULL, " +
			EURO_PERIODO  + " TEXT, " +
			EURO_1C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_2C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_5C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_10C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_20C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_50C + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_1E + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_2E + "INTEGER NOT NULL  DEFAULT 0," +
			EURO_CONME + "INTEGER NOT NULL  DEFAULT 0)";
	
	//Seleccion / sentencias SQL 
	public static final String[] EURO_COLUM ={EURO_PAIS,EURO_PERIODO,EURO_1C,EURO_2C,EURO_5C,EURO_10C,EURO_20C,EURO_50C,EURO_1E,EURO_2E,EURO_CONME};
	public static final String EURO_SQL ="(" + EURO_PAIS + "," + EURO_PERIODO + "," +  EURO_1C + "," + EURO_2C + "," + EURO_5C + "," + EURO_10C + "," + EURO_20C + "," + EURO_50C + "," + EURO_1E + "," + EURO_2E + "," + EURO_CONME + ")";
	/**
	 * Tabla en DB de EUROS CONMEMORATIVOS 
	 */
	public static final String EURO_C_NAME = "EUROS2CON";
	public static final String EURO_C_PAIS = "PAIS";
	public static final String EURO_C_FECHA = "FECHA";
	public static final String EURO_C_DESCRIPCION = "DESCRIPCION";
	public static final String sqlCrearEurosConme = "CREATE TABLE " + EURO_C_NAME +
			"(" + EURO_C_PAIS + " TEXT NOT NULL, " +
			EURO_C_FECHA + "TEXT, " +
			EURO_C_DESCRIPCION + "TEXT)";
	
	//Seleccion / sentencias SQL 
	public static final String[] EURO_C_COLUM = {EURO_C_PAIS,EURO_C_FECHA,EURO_C_DESCRIPCION};
	public static final String EURO_C_SQL = "(" + EURO_C_PAIS + "," + EURO_C_FECHA + "," + EURO_C_DESCRIPCION + ")";
	/**
	 * Tabla en DB de PESETAS 
	 */
	public static final String PESETA_NAME = "PESETA";
	public static final String PESETA_ID = "ID";
	public static final String PESETA_KM = "KM";
	public static final String PESETA_PERIODO = "PERIODO";
	public static final String PESETA_VALOR = "VALOR";
	public static final String PESETA_ESTRELLAS = "ESTRELLAS";
	public static final String PESETA_COMPOSICION = "COMPOSICION";
	public static final String PESETA_ANVERSO = "ANVERSO";
	public static final String PESETA_REVERSO = "REVERSO";
	public static final String PESETA_ESTA = "Esta";
	public static final String PESETA_NOTAS = "NOTAS";
	public static final String sqlCrearPeseta = "CREATE TABLE " + PESETA_NAME +
			"(" + PESETA_ID + " INTEGER NOT NULL UNIQUE," +
			PESETA_KM + " TEXT NOT NULL, " +
			PESETA_PERIODO + "TEXT," +
			PESETA_VALOR + "TEXT," +
			PESETA_ESTRELLAS + "INTEGER DEFAULT 0," +
			PESETA_COMPOSICION + "TEXT," +
			PESETA_ANVERSO + "TEXT," +
			PESETA_REVERSO + "TEXT," +
			PESETA_ESTA + "INTEGER," +
			PESETA_NOTAS + "TEXT)";
	
	//Seleccion / sentencias SQL 
	public static final String[] PESETA_COLUM ={PESETA_ID,PESETA_KM,PESETA_PERIODO,PESETA_VALOR,PESETA_ESTRELLAS,PESETA_COMPOSICION,PESETA_ANVERSO,PESETA_REVERSO,PESETA_ESTA,PESETA_NOTAS};
	
	/**
	 * Tabla en DB de PESETAS INFORMACION
	 */
	public static final String PESETA_A_NAME = "PESETAaux";
	public static final String PESETA_A_ID = "ID";
	public static final String PESETA_A_ANO = "DATE";
	public static final String PESETA_A_ESTRELLA = "ESTRELLA";
	public static final String PESETA_A_CECA = "CECA";
	public static final String PESETA_A_TIRADA = "TIRADA";
	public static final String PESETA_A_ESTA = "ESTA";
	public static final String PESETA_A_ESTADO = "ESTADO";
	public static final String sqlCrearPesetaAux = "CREATE TABLE " + PESETA_A_NAME +
			"(" + PESETA_A_ID + " INTEGER NOT NULL UNIQUE," +
			PESETA_A_ANO + "INTEGER," +
			PESETA_A_ESTRELLA + "TEXT," +
			PESETA_A_CECA + "TEXT," +
			PESETA_A_TIRADA + "TEXT," +
			PESETA_A_ESTA + "BOOL NOT NULL DEFAULT false," +
			PESETA_A_ESTADO + "TEXT)";
	
	//Seleccion / sentencias SQL
	public static final String[] PESETA_A_COLUM ={PESETA_A_ID,PESETA_A_ANO,PESETA_A_ESTRELLA,PESETA_A_ESTADO};
	public static final String[] PESETA_A_TODO ={PESETA_A_ID,PESETA_A_ANO,PESETA_A_ESTRELLA,PESETA_A_CECA,PESETA_A_TIRADA,PESETA_A_ESTA,PESETA_A_ESTADO};

	/**
	 * Tabla en DB de INFORMACION 
	 */
	public static final String INFORMACION_NAME = "INFORMACION";
	public static final String INFORMACION_TAG = "TAG";
	public static final String INFORMACION_DESCRIPCION = "DESCRIPCION";
	public static final String INFORMACION_ULTIMA_MODIFICACION = "ULTIMA_MODIFICACION";
	public static final String sqlCrearInformacion = "CREATE TABLE " + INFORMACION_NAME +
			"(" + INFORMACION_TAG + " TEXT NOT NULL UNIQUE, " +
			INFORMACION_DESCRIPCION + "TEXT NOT NULL)";
	
	//Seleccion / sentencias SQL
	public static final String[] INFORMACION_COLUM = {INFORMACION_TAG,INFORMACION_DESCRIPCION};
	//Algunos campos
	public static final String INFORMACION_TAG_ULTIMA_MODIFICACION = "ULTIMA_MODIFICACION";
}

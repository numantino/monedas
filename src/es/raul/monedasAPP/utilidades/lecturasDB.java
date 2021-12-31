package es.raul.monedasAPP.utilidades;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.constantes.constantesDatabase;
import es.raul.monedas.constantes.constantesMonedas.CONTINENTES;
import es.raul.monedas.objetos.billete.billete;
import es.raul.monedas.objetos.euros.listaMonedaEuro;
import es.raul.monedas.objetos.euros.monedaEuro;
import es.raul.monedas.objetos.euros.monedaEuroCon;
import es.raul.monedas.objetos.mundo.denominacion;
import es.raul.monedas.objetos.mundo.informacionMoneda;
import es.raul.monedas.objetos.mundo.localizacion;
import es.raul.monedas.objetos.mundo.moneda;
import es.raul.monedas.objetos.mundo.monedaExt;
import es.raul.monedas.objetos.peseta.estrellasPesetas;
import es.raul.monedas.objetos.peseta.monedaPeseta;
import es.raul.monedas.objetos.peseta.monedaPesetaAux;

/**
 *  Clase encargada de realizar las lecturas de la DB
 *
 */
public class lecturasDB {

	private final static String NOMBRE_CLASS="lecturasDB   ";
	//Ruta de la DB
	private String PATH_DB; //		//Ruta de la base de datos
	//PATH_DB= PATH_PC + File.separator + constantesDatabase.DB_NOMBRE;
	//Una isntancia del objeto de utilidades
	private utilLog uLog = utilLog.getInstance();
	//SQL comunes
	private final static String sqlFinMasComa = "';";
	private final static String sqlFin = ";";
	private final static String sqlCount = 	"SELECT COUNT(";

	//DB
	private Connection c = null;
	private Statement stmt = null;

	/**
	 * Constructor del la conexion DB
	 */
	public lecturasDB(){
		//
		PATH_DB =  utils.getInstance().getPath() + "db" + File.separator + constantesDatabase.DB_NOMBRE;
		//Inicialilzamos la DB
		openDB();
	}

	/*********************************************** DB ************************************************************/
	/**
	 * Esta funcion es para el envio de sentencias SELECT de sql
	 *
	 */
	private ResultSet DBExecuteQuery(String sql){
		ResultSet rs = null;
		try {			
			rs = stmt.executeQuery(sql);	
		}catch (SQLException s){
			//Este error es porque la Tabla ya existe
			uLog.escribirExcepcion(NOMBRE_CLASS,"DBExecuteQuery", s);
			if (s.getErrorCode() == 0) {
				uLog.escribirError(NOMBRE_CLASS,"DBExecuteQuery--> SQL ERROR: Dato [" + sql + "] por [" + s.getMessage() + "]");
				return null;
			}
			else{
				uLog.escribirError(NOMBRE_CLASS,"DBExecuteQuery--> SQL ERROR al insertar [" + sql + "] por [" + s.getMessage() + "]");
				return null;		
			}		
		}catch ( Exception e) {
			uLog.escribirError(NOMBRE_CLASS,"DBExecuteQuery--> SQL ERROR al insertar [" + sql + "]");
			return null;
		}
		return rs;
	}
	/**
	 * Esta funcion es para abrir la DB al inicio de la aplicacion
	 *
	 */
	public void openDB(){
		//Inicialilzamos la DB
		try {
			uLog.escribirTrazas(NOMBRE_CLASS,"PATH DB: [" + PATH_DB +"]");
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + PATH_DB);
			stmt = c.createStatement();
		}catch (SQLException s){
			//Este error es porque la Tabla ya existe
			uLog.escribirExcepcion(NOMBRE_CLASS,"openDB", s);	
		}catch ( Exception e) {
			uLog.escribirExcepcion(NOMBRE_CLASS,"openDB", e);
		}
	}
	/**
	 * Esta funcion es para cerrar la DB al final de la aplicacion
	 *
	 */
	public void closeDB(){
		if (stmt != null) { 
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"closeDB", e);
			} 
		}
	}

	/************************************* MONEDA MUNDO ***********************************************************************************/
	//example: SELECT DISTINCT PAIS FROM MOnEDAS where IDMONEDA like '1%';
	private final static String sqlLeerPais =	"SELECT DISTINCT " + 
			constantesDatabase.MONEDAS_PAIS + " FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_IDMONEDA + " like '";
	//example: SELECT IDMONEDA,KMMONEDA,VALOR,DATE FROM MONEDAS WHERE PAIS='Tunez';
	private final static String sqlLeerMoneda1 = 	"SELECT " + 
			constantesDatabase.MONEDAS_IDMONEDA + "," + 
			constantesDatabase.MONEDAS_KMMONEDA + "," + 
			constantesDatabase.MONEDAS_VALOR + "," + 
			constantesDatabase.MONEDAS_DATE + " FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_PAIS + "='";
	private final static String sqlLeerMonedaPais = 	"SELECT " +  
			constantesDatabase.MONEDAS_PAIS + " FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_IDMONEDA + "=";
	//
	private final static String sqlLeerCurrency = 	"SELECT " + 
			constantesDatabase.MONEDAS_AUX_VALOR + " FROM " +
			constantesDatabase.MONEDAS_AUX_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_AUX_PAIS + "='";
	private final static String sqlLeerKM = 	"SELECT " + 
			constantesDatabase.MONEDAS_AUX_KM + " FROM " +
			constantesDatabase.MONEDAS_AUX_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_AUX_PAIS + "='";
	//"ISNUMERIC(" + constantesDatabase.MONEDAS_KMMONEDA + "), " + constantesDatabase.MONEDAS_KMMONEDA + ";";
	//example: SELECT * FROM MONEDAS WHERE IDMONEDA='1002000';
	private final static String sqlLeerMoneda3 = 	"SELECT * FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_IDMONEDA + "=";
	//example: SELECT COUNT(*) FROM MOnEDAS where pais='Marruecos';
	private final static String sqlContar5 = 	"SELECT COUNT(*) FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_PAIS + " = '";
	//example: INSERT INTO PAISES () VALUES ();
	private final static String sqlInsertMoneda = 	"INSERT INTO " + 
			constantesDatabase.MONEDAS_NAME + " VALUES ('";
	//SELECT (IDMONEDA) FROM MoNEDAS WHERE PAIS='Marruecos' ORDER BY IDMONEDA DESC;
	private final static String sqlNewID1 = "SELECT " + constantesDatabase.MONEDAS_IDMONEDA + " FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_PAIS + "='";
	private final static String sqlNewID2 = "' ORDER BY " + constantesDatabase.MONEDAS_IDMONEDA +" DESC;";
	//SELECT (IDMONEDA) FROM MoNEDAS WHERE IDMONEDA LIKE '1%' ORDER BY IDMONEDA DESC;
	private final static String sqlNewID3 = "SELECT " + constantesDatabase.MONEDAS_IDMONEDA + " FROM " +
			constantesDatabase.MONEDAS_NAME + " WHERE " + 
			constantesDatabase.MONEDAS_IDMONEDA + " LIKE '";
	private final static String sqlNewID4 = "%' ORDER BY " + constantesDatabase.MONEDAS_IDMONEDA +" DESC;";

	/**
	 * 
	 * SELECT --> Obtenemos los nombres de los diferentes paises
	 *
	 */
	public List<String> DBLeerPaisNombres(String continente){
		List<String> nombrePaises = new ArrayList<String>();

		//leemos datos de la DB
		String sql = sqlLeerPais + continente + "%';";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPaisNombres--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) { 
					nombrePaises.add(valores.getString(constantesDatabase.MONEDAS_PAIS));
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerPaisNombres", e);
			}
		}

		return nombrePaises;
	}
	/**
	 */
	public int DBContarNumeroPaises(CONTINENTES nombre) {

		List<String> nombrePaises = DBLeerPaisNombres(nombre.getNumeroString());
		if (nombrePaises==null) return 0;
		else return nombrePaises.size();
	}
	/**
	 * 
	 * SELECT -->  Obtenemos los datos de TODAS las monedas de un determinado pais
	 *
	 */
	public List<moneda> DBLeerMoneda(String pais){
		List<moneda> nombreMoneda = new ArrayList<moneda>();

		//Primero leemos la lista de monedas
		String sql = sqlLeerCurrency + pais + "';";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMoneda--> SQL 1: [" + sql + "]");
		String[] listCurrency = null;
		ResultSet valores=DBExecuteQuery(sql);
		if (valores!=null){
			try {
				listCurrency = valores.getString(1).split(";");
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMoneda 1", e);
			}
		}
		
		//Obtenemos la informacion de si es KM
		sql = sqlLeerKM + pais + "';";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMoneda--> SQL 2: [" + sql + "]");
		boolean esMonedaKM=true;
		valores=DBExecuteQuery(sql);
		if (valores!=null){
			try {
				
				if (valores.getInt(1)==1) esMonedaKM=false;
				else esMonedaKM=true;
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMoneda 2", e);
			}
		}

		//leemos datos de la DB
		sql = sqlLeerMoneda1 + pais + "' ORDER BY IDMONEDA;";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMoneda--> SQL 3: [" + sql + "]");

		valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					denominacion de = new denominacion(valores.getString(constantesDatabase.MONEDAS_VALOR),valores.getString(constantesDatabase.MONEDAS_DATE));
					de.setListCurrency(listCurrency);
					moneda l = new moneda(valores.getInt(constantesDatabase.MONEDAS_IDMONEDA), valores.getString(constantesDatabase.MONEDAS_KMMONEDA),de,pais,esMonedaKM); 
					nombreMoneda.add(l);
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMoneda 3", e);
			}
		}

		return nombreMoneda;
	}
	/**
	 *
	 *  SELECT -->  Obtenemos los datos (informacion extendida) de una moneda determinada
	 *
	 * Se tiene que pasar el continente porque esa informacion no esta disponible en la informacion de la moneda
	 */
	public monedaExt DBLeerMonedaExtendida(int idMoneda, String continente){
		monedaExt nombreMoneda = null;

		//Obtenemos la informacion de si es KM
		String sql = sqlLeerMonedaPais + idMoneda + ";";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMoneda--> SQL 2: [" + sql + "]");
		String pais="";
		ResultSet valores=DBExecuteQuery(sql);
		if (valores!=null){
			try {
				pais = valores.getString(1);
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMoneda 2", e);
			}
		}
		
		//Obtenemos la informacion de si es KM
		sql = sqlLeerKM + pais + "';";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMoneda--> SQL 2: [" + sql + "]");
		boolean esMonedaKM=true;
		valores=DBExecuteQuery(sql);
		if (valores!=null){
			try {
				
				if (valores.getInt(1)==1) esMonedaKM=false;
				else esMonedaKM=true;
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMoneda 2", e);
			}
		}
		
		//leemos datos de la DB
		sql = sqlLeerMoneda3 + idMoneda + ";";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMonedaExtendida--> SQL: [" + sql + "]");
		
		valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					denominacion d = new denominacion(valores.getString(constantesDatabase.MONEDAS_VALOR),valores.getString(constantesDatabase.MONEDAS_DATE));
					localizacion l = new localizacion(valores.getString(constantesDatabase.MONEDAS_PAIS), continente, valores.getString(constantesDatabase.MONEDAS_GRUPO));
					moneda	m = new moneda(valores.getInt(constantesDatabase.MONEDAS_IDMONEDA),valores.getString(constantesDatabase.MONEDAS_KMMONEDA),d,l,esMonedaKM);	
					informacionMoneda info = new informacionMoneda(
							valores.getString(constantesDatabase.MONEDAS_ANVERSO),valores.getString(constantesDatabase.MONEDAS_ANVERSOLEYENDA),
							valores.getString(constantesDatabase.MONEDAS_REVERSO),valores.getString(constantesDatabase.MONEDAS_REVERSOEYENDA),
							valores.getString(constantesDatabase.MONEDAS_CANTO),valores.getString(constantesDatabase.MONEDAS_CANTOLEYENDA));

					nombreMoneda = new monedaExt(m,valores.getString(constantesDatabase.MONEDAS_COMPOSICION),info,valores.getString(constantesDatabase.MONEDAS_FORMA),valores.getString(constantesDatabase.MONEDAS_NOTA),valores.getString(constantesDatabase.MONEDAS_ESTADO));
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMonedaExtendida", e);
			}
		}

		return nombreMoneda;
	}
	/**
	 *
	 * COUNT --> Obtenemos el numero de Monedas de un determinado pais
	 */
	public int DBContarNumeroMonedas(CONTINENTES coontinente){
		//Primero obtenemos los paises
		List<String> nombrePaises = DBLeerPaisNombres(coontinente.getNumeroString());

		if (nombrePaises==null) return 0;
		else{		

			int value=0;
			String sql = "";
			for (int i=0;i<nombrePaises.size();i++){

				sql = sqlContar5 + nombrePaises.get(i) + sqlFinMasComa;
				uLog.escribirTrazas(NOMBRE_CLASS,"DBContarNumeroMonedas--> SQL: [" + sql + "]");
				ResultSet valores=DBExecuteQuery(sql);
				if (valores!=null){
					try {
						value = value + valores.getInt(1);
					} catch (Exception e) {
						uLog.escribirExcepcion(NOMBRE_CLASS,"DBContarNumeroPaises", e);
					}
				}
			}
			return value;
		}
	}
	/**
	 * INSERT --> Insertamos la informacion de una nueva moneda
	 */
	public void DBInsertarMoneda(monedaExt moneda){
		String sql = sqlInsertMoneda + 
				moneda.getIdMoneda() + "','" + 
				moneda.getKmMoneda() + "','" + 
				moneda.getDenominacionMoneda().getValor() + "','" + 
				moneda.getLocalizacionMoneda().getPais() + "','" + 
				moneda.getLocalizacionMoneda().getPeriodoMoneda() + "','" +
				moneda.getDenominacionMoneda().getAño() + "','" + 
				moneda.getComposicionMoneda() + "','" + 
				moneda.getInformacionMoneda().getAnverso() + "','" + 
				moneda.getInformacionMoneda().getAnversoLeyenda() + "','" + 
				moneda.getInformacionMoneda().getReverso() + "','" + 
				moneda.getInformacionMoneda().getReversoLeyenda() + "','" + 
				moneda.getFormaMoneda() + "','" + 
				moneda.getInformacionMoneda().getCanto() + "','" + 
				moneda.getInformacionMoneda().getCantoLeyenda() + "','" +
				moneda.getNotaMoneda() + "','" +
				moneda.getEstadoMoneda() + "');";

		uLog.escribirTrazas(NOMBRE_CLASS,"DBInsertarPais--> SQL: [" + sql + "]");
		ResultSet valores=DBExecuteQuery(sql);
	}
	/**
	 * 
	 * SELECT --> Obtenemos el ultimo ID de la moneda de un pais
	 *
	 */
	public int DBgetIDMoneda(String pais){
		int value=0;
		String sql = sqlNewID1 + pais + sqlNewID2;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBgetIDMoneda--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				value = valores.getInt(constantesDatabase.MONEDAS_IDMONEDA) + 1;
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBgetIDMoneda", e);
			}
		}
		return value;
	}

	/**
	 * 
	 * SELECT --> Obtenemos el ultimo ID de la moneda de un continente
	 *
	 */
	public String DBgetUltimoIDMoneda(String continente){
		String value = "";

		String sql = sqlNewID3 + continente + sqlNewID4;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBgetUltimoIDMoneda--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				value = Integer.toString(valores.getInt(constantesDatabase.MONEDAS_IDMONEDA)).substring(0,4);
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBgetUltimoIDMoneda", e);
				value="";
			}
		}
		return value;
	}
	/************************************* EUROS ***********************************************************************************/
	//example: SELECT DISTINCT PAIS FROM  EUROS  ORDER BY  PAIS ASC;
	//Eliminamos los nombres de los paises que esten repetidos
	private final static String sqlLeerPaisesEuro = "SELECT DISTINCT " + 
			constantesDatabase.EURO_PAIS + " FROM " +
			constantesDatabase.EURO_NAME + 
			" ORDER BY " + constantesDatabase.EURO_PAIS + " ASC;";
	//example: SELECT * FROM  EUROS  WHERE PAIS;
	private final static String sqlLeerMonedaEuro = "SELECT * FROM " + 
			constantesDatabase.EURO_NAME + " WHERE " + 
			constantesDatabase.EURO_PAIS + "='";
	//example: SELECT * FROM  EUROS2CON  WHERE PAIS;
	private final static String sqlLeerMonedaEuroCon = "SELECT * FROM " + 
			constantesDatabase.EURO_C_NAME + " WHERE " + 
			constantesDatabase.EURO_C_PAIS + "='";
	//example: SELECT * FROM  EUROS2CON  WHERE PAIS;
	private final static String sqlContar2 = 	") FROM " + 
			constantesDatabase.EURO_NAME +
			" WHERE ";
	//example: SELECT COUNT(*) FROM EUROS2CON;
	private final static String sqlContar3 = 	"SELECT COUNT(*) FROM " + 
			constantesDatabase.EURO_C_NAME + ";";
	/**
	 * 
	 *   SELECT -->  Obtenemos la lista de los paises de EURO
	 *
	 */
	public List<String> DBLeerPaisEuro(){
		List<String> nombrePaises = new ArrayList<String>();

		//leemos datos de la DB
		String sql = sqlLeerPaisesEuro;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPaisEuro--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					nombrePaises.add(valores.getString(constantesDatabase.EURO_PAIS));
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerPaisEuro", e);
			}
		}

		return nombrePaises;
	}

	/**
	 * 
	 *  SELECT -->  Obtenemos la lista de los euros de un determinado pais (indicandonos en esta lista los euros que estan y los que no estan)
	 *
	 */
	public List<listaMonedaEuro> DBLeerMonedaEuro(String pais){
		List<listaMonedaEuro> todasMonedas = new ArrayList<listaMonedaEuro>();

		String sql = sqlLeerMonedaEuro + pais + sqlFinMasComa;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMonedaEuro--> SQL: [" + sql + "]");
		//leemos datos de la DB
		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					monedaEuro moneda = new monedaEuro(valores.getString(constantesDatabase.EURO_PERIODO),
							valores.getInt(constantesDatabase.EURO_1C),
							valores.getInt(constantesDatabase.EURO_2C),
							valores.getInt(constantesDatabase.EURO_5C),
							valores.getInt(constantesDatabase.EURO_10C),
							valores.getInt(constantesDatabase.EURO_20C),
							valores.getInt(constantesDatabase.EURO_50C),
							valores.getInt(constantesDatabase.EURO_1E),
							valores.getInt(constantesDatabase.EURO_2E));

					todasMonedas.add(new listaMonedaEuro(pais, moneda, valores.getInt(constantesDatabase.EURO_CONME)));
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMonedaEuro", e);
			}
		}

		return todasMonedas;
	}
	/**
	 * 
	 *  SELECT -->  Obtenemos la lista de los euros conmemorativos de un determinado pais
	 *
	 */
	public List<monedaEuroCon> DBLeerMonedaEuroCon(String pais){
		List<monedaEuroCon> listaMoneda = new ArrayList<monedaEuroCon>();

		//leemos datos de la DB
		String sql = sqlLeerMonedaEuroCon + pais + 	"' ORDER BY " + constantesDatabase.EURO_C_FECHA + " ASC;";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerMonedaEuroCon--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					monedaEuroCon moneda = new monedaEuroCon(valores.getString(constantesDatabase.EURO_C_PAIS),
							valores.getString(constantesDatabase.EURO_C_FECHA),
							valores.getString(constantesDatabase.EURO_C_DESCRIPCION));
					listaMoneda.add(moneda);
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerMonedaEuroCon", e);
			}
		}

		return listaMoneda;
	}
	/**
	 * 
	 *  COUNT --> Obtenemos el numero de euros (0=no estan; 1=estan)
	 *  
	 */
	public int DBContarNumeroEuros(int val){
		int value=0;
		String sql = "";

		for(int i=0; i<monedaEuro.MAX_MONEDAS_ERUROS;i++){
			sql = sqlCount + constantesDatabase.EURO_COLUM[i+2] + sqlContar2 + constantesDatabase.EURO_COLUM[i+2] + "=" + val + sqlFin;
			uLog.escribirTrazas(NOMBRE_CLASS,"DBContarNumeroEuros--> SQL: [" + sql + "]");

			ResultSet valores=DBExecuteQuery(sql);
			if (valores!=null){
				try {
					value = value + valores.getInt(1);
				} catch (Exception e) {
					uLog.escribirExcepcion(NOMBRE_CLASS,"DBContarNumeroEuros", e);
				}
			}
		}

		return value;
	}
	/**
	 * 
	 *  COUNT --> Obtenemos el numero de Euros conmemorativos
	 *  
	 */
	public int DBContarNumeroEurosConmemorativos(){
		int value=0;
		String sql = "";

		sql = sqlContar3;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBContarNumeroEurosConmemorativos--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				value = value + valores.getInt(1);
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBContarNumeroPaises", e);
			}
		}

		return value;
	}
	/**
	 *
	 * INSERT --> Incluimos en la DB una moneda de euro
	 */
	public void DBIncluirMonedaEuro(String pais, String posicion){
		String sql = "UPDATE " + constantesDatabase.EURO_NAME + " SET " +
				posicion + "='1' WHERE " +
				constantesDatabase.EURO_PAIS + "='" + pais + "';";
		uLog.escribirTrazas(NOMBRE_CLASS,"SQL update euro [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);		
	}

	/************************************* PESETA ***********************************************************************************/
	//example: SELECT DISTINCT PERIODO FROM  PESETA;
	private final static String sqlLeerPeseta1 = "SELECT DISTINCT " + 
			constantesDatabase.PESETA_PERIODO + " FROM " +
			constantesDatabase.PESETA_NAME + ";";
	//example: SELECT ID, KM, PERIODO, VALOR FROM  PESETA  WHERE PERIODO='Estado Español';
	private final static String sqlLeerPeseta2 = 	"SELECT " +
			constantesDatabase.PESETA_ID + "," +
			constantesDatabase.PESETA_KM + "," +
			constantesDatabase.PESETA_PERIODO + "," +
			constantesDatabase.PESETA_VALOR + " FROM " +
			constantesDatabase.PESETA_NAME + " WHERE " + 
			constantesDatabase.PESETA_PERIODO + "='";
	private final static String sqlPesetaOrdenadoKM = "' ORDER BY " + constantesDatabase.PESETA_KM + ";";
	//private final static String sqlPesetaOrdenadoKM = "' ORDER BY " + constantesDatabase.PESETA_VALOR + ";";
	//example: SELECT * FROM  PESETA WHERE ID='1001';
	private final static String sqlLeerPeseta3 = 	"SELECT * FROM " +
			constantesDatabase.PESETA_NAME + " WHERE " + 
			constantesDatabase.PESETA_ID + "=";
	//example: SELECT * FROM  PESETAaux WHERE ID='1001';
	private final static String sqlLeerPeseta4 = 	"SELECT * FROM " +
			constantesDatabase.PESETA_A_NAME + " WHERE " + 
			constantesDatabase.PESETA_A_ID + "=";
	//example: SELECT ID,ESTA FROM PESETAaux where ESTA=1
	private final static String sqlContarPesetas = 	"SELECT " + 
			constantesDatabase.PESETA_A_ID + "," +
			constantesDatabase.PESETA_A_ESTA + " FROM " +
			constantesDatabase.PESETA_A_NAME + " WHERE " +
			constantesDatabase.PESETA_A_ESTA + "=1;";
	//example: SELECT DISTINCT ID FROM PeseTAaux
	private final static String sqlContarPesetasTotales = 	"SELECT DISTINCT " + 
			constantesDatabase.PESETA_A_ID + " FROM "+
			constantesDatabase.PESETA_A_NAME;
	//example: SELECT COUNT(*) FROM PeseTAaux WHERE ID='1001' AND ESTA=1;
	private final static String sqlTengoPeseta1 = 	"SELECT COUNT(*) FROM " + 
			constantesDatabase.PESETA_A_NAME + " WHERE ID=";
	private final static String sqlTengoPeseta2 = 	" AND ESTA=1;";
	/**
	 * 
	 *  SELECT -->  Obtenemos la lista de los periodos de las PESETAS
	 *
	 */
	public List<String> DBLeerPeriodosPeseta(){
		List<String> nombrePeriodos = new ArrayList<String>();

		//leemos datos de la DB
		String sql = sqlLeerPeseta1;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPeriodosPeseta--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					nombrePeriodos.add(valores.getString(constantesDatabase.PESETA_PERIODO));
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerPeriodosPeseta", e);
			}
		}

		return nombrePeriodos;

	}
	/**
	 * 
	 *  SELECT -->  Obtenemos una lista de las pesetas de un determiando periodo
	 *
	 */
	public List<monedaPeseta> DBLeerPeseta(String periodo){
		List<monedaPeseta> nombreMoneda = new ArrayList<monedaPeseta>();

		//leemos datos de la DB
		String sql = sqlLeerPeseta2 + periodo + sqlPesetaOrdenadoKM;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPeseta--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					int idMoneda = valores.getInt(constantesDatabase.PESETA_ID);
					monedaPeseta l = new monedaPeseta(idMoneda, valores.getString(constantesDatabase.PESETA_KM),periodo,valores.getString(constantesDatabase.PESETA_VALOR));
					nombreMoneda.add(l);
				}
				//Ponemos si la tenemos
				for (int i=0;i<nombreMoneda.size();i++){
					int idMoneda = nombreMoneda.get(i).getIdMoneda();
					nombreMoneda.get(i).setTengoMoneda(tengoPeseta(idMoneda));
				}				
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerPeseta", e);
			}
		}

		return nombreMoneda;
	}
	/**
	 * 
	 * @param idPeseta
	 * @return
	 */
	public boolean tengoPeseta(int idPeseta){
		boolean value=false;
		String sql = sqlTengoPeseta1 + idPeseta + sqlTengoPeseta2;
		uLog.escribirTrazas(NOMBRE_CLASS,"tengoPeseta--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				if (valores.getInt(1) != 0) value=true;
			} catch (SQLException e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"tengoPeseta", e);
			}
		}

		return value;
	}
	/**
	 * 
	 *  SELECT -->  Obtenemos la informacion completa de una determinada peseta
	 *
	 */
	public monedaPesetaAux  DBLeerPesetaExtendida(int id){
		monedaPesetaAux mo = null;

		//leemos datos de la DB
		String sql = sqlLeerPeseta3 + id + ";";
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPesetaExtendida--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				monedaPeseta m = new monedaPeseta(valores.getInt(constantesDatabase.PESETA_ID), valores.getString(constantesDatabase.PESETA_KM),valores.getString(constantesDatabase.PESETA_PERIODO),valores.getString(constantesDatabase.PESETA_VALOR));
				informacionMoneda info = new informacionMoneda();
				info.setAnverso(valores.getString(constantesDatabase.PESETA_ANVERSO));
				info.setReverso(valores.getString(constantesDatabase.PESETA_REVERSO));
				mo  = new monedaPesetaAux(m,valores.getString(constantesDatabase.PESETA_COMPOSICION),info);
				//Incluimos informacion de notas
				if (valores.getString(constantesDatabase.PESETA_NOTAS)!=null) mo.setNotaMoneda(valores.getString(constantesDatabase.PESETA_NOTAS));

				if(valores.getInt(constantesDatabase.PESETA_ESTRELLAS)>0){					
					sql = sqlLeerPeseta4 + id  + ";";
					uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerPesetaExtendida--> segunda consulta SQL: [" + sql + "]");

					valores=DBExecuteQuery(sql);

					List<estrellasPesetas> lista = new ArrayList<estrellasPesetas>();

					//Obtener informacion de las estrellas
					while (valores.next()) {
						estrellasPesetas estrella = new estrellasPesetas(valores.getString(constantesDatabase.PESETA_A_ANO),
								valores.getString(constantesDatabase.PESETA_A_ESTRELLA),
								valores.getInt(constantesDatabase.PESETA_A_TIRADA),
								valores.getString(constantesDatabase.PESETA_A_CECA),
								valores.getString(constantesDatabase.PESETA_A_ESTADO),
								valores.getInt(constantesDatabase.PESETA_A_ESTA));
						lista.add(estrella);
					}

					mo.setEstrellas(lista);
				} 
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerPesetaExtendida", e);
			}
		}

		return mo;
	}

	/**
	 *
	 * INSERT --> Incluimos en la DB la peseta
	 */
	public void DBIncluirPeseta(int id, String fecha, String estrella, String estado){

		//TODO no esta almacenando la informacion correctamente

		String sql = "UPDATE " + constantesDatabase.PESETA_A_NAME + " SET " +
				constantesDatabase.PESETA_A_ESTA + "='1' WHERE " +
				constantesDatabase.PESETA_A_ID + "=" + id + " AND " +
				constantesDatabase.PESETA_A_ANO + "='" + fecha + "' AND " +
				constantesDatabase.PESETA_A_ESTRELLA + "='" + estrella + "';";
		uLog.escribirTrazas(NOMBRE_CLASS,"SQL update peseta [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);		
	}
	/**
	 * 
	 *  COUNT --> Obtenemos el numero de Billetes
	 *  
	 */
	public int[] DBContarNumeroPesetas(){
		int [] value= new int[2];

		String sql = sqlContarPesetas;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBContarNumeroPesetas--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				int auxValor1;
				int auxValor2=0;
				while (valores.next()) {
					auxValor1=valores.getInt(constantesDatabase.PESETA_A_ID);
					if (auxValor1!=auxValor2){
						value[0]++;
						auxValor2=auxValor1;	
					}
					value[1]++;
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBContarNumeroPesetas", e);
			}
		}

		return value;
	}

	/**
	 * 
	 *  COUNT --> Obtenemos el numero total de pesetas
	 *  
	 */
	public int DBContarNumeroPesetasTotales(){
		int value=0;

		String sql = sqlContarPesetasTotales;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBContarNumeroPesetasTotales--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					value++;
				}
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBContarNumeroPesetasTotales", e);
			}
		}

		return value;
	}
	/************************************* BILLETES ***********************************************************************************/
	private final static String sqlLeerListaBilletes = "SELECT * FROM " + constantesDatabase.BILLETE_NAME + ";";
	public List<billete> DBLeerBilletes(){
		List<billete> listaBilletes = new ArrayList<billete>();

		//leemos datos de la DB
		String sql = sqlLeerListaBilletes;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerBilletes--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				while (valores.next()) {
					billete b = new billete(
							valores.getInt(constantesDatabase.BILLETE_ID),
							valores.getString(constantesDatabase.BILLETE_PAIS),
							valores.getString(constantesDatabase.BILLETE_DENOMINACION),
							valores.getInt(constantesDatabase.BILLETE_FECHA),
							valores.getString(constantesDatabase.BILLETE_NOTAS));

					listaBilletes.add(b);
				}				
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerBilletes", e);
			}
		}

		return listaBilletes;
	}
	/************************************* INFORMACION ***********************************************************************************/
	//example: SELECT * FROM  INFORMACION WHERE TAG='';
	private final static String sqlLeerFechaActualizacion = "SELECT * FROM " + 
			constantesDatabase.INFORMACION_NAME + " WHERE " + 
			constantesDatabase.INFORMACION_TAG + "='";
	/**
	 * SELECT --> Obtenemos los datos de informacion relativos a la clave que mandamos
	 */
	public String DBLeerDatosInformacion(String key){
		String dato="";

		//leemos datos de la DB
		String sql = sqlLeerFechaActualizacion + key + sqlFinMasComa;
		uLog.escribirTrazas(NOMBRE_CLASS,"DBLeerFechaActualilzacion--> SQL: [" + sql + "]");

		ResultSet valores=DBExecuteQuery(sql);

		if (valores!=null){
			try {
				dato = valores.getString(constantesDatabase.INFORMACION_DESCRIPCION);
			} catch (Exception e) {
				uLog.escribirExcepcion(NOMBRE_CLASS,"DBLeerFechaActualilzacion", e);
				dato="";
			}
		}

		return dato;
	}

	/**
	 * UPDATE --> Modificamos los campos
	 */
	public void DBModificarDatosInformacion(String key, String dato){
		String sql = "UPDATE " + constantesDatabase.INFORMACION_NAME + " SET " +
				constantesDatabase.INFORMACION_DESCRIPCION + "='" + dato + "' WHERE " +
				constantesDatabase.INFORMACION_TAG + "='" + key + "';";

		uLog.escribirTrazas(NOMBRE_CLASS,"DBModificarDatosInformacion--> SQL: [" + sql + "]");
		ResultSet valores = DBExecuteQuery(sql);
	}
	/**
	 * 
	 */
	public void modificarFechaUltimoCambio(){
//		uLog.escribirTrazas(NOMBRE_CLASS,"modificarFechaUltimoCambio--> Modificamos la ultima fecha en la que se han modificado los datos");
//		//Obtener la fecha del sistema
//		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		//Modificarla
//		DBModificarDatosInformacion(constantesDatabase.INFORMACION_TAG_ULTIMA_MODIFICACION,sdf.format(new Date()));
	}
}

// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Big Data
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package sales_data_analysis.etl_papier_et_besoins_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: ETL_papier_et_besoins Purpose: <br>
 * Description: ETL principal qui execute les sous job <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class ETL_papier_et_besoins implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ETL_papier_et_besoins";
	private final String projectName = "SALES_DATA_ANALYSIS";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					ETL_papier_et_besoins.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ETL_papier_et_besoins.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tRunJob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tRunJob_1 begin ] start
				 */

				ok_Hash.put("tRunJob_1", false);
				start_Hash.put("tRunJob_1", System.currentTimeMillis());

				currentComponent = "tRunJob_1";

				int tos_count_tRunJob_1 = 0;

				/**
				 * [tRunJob_1 begin ] stop
				 */

				/**
				 * [tRunJob_1 main ] start
				 */

				currentComponent = "tRunJob_1";

				java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();

				paraList_tRunJob_1.add("--father_pid=" + pid);

				paraList_tRunJob_1.add("--root_pid=" + rootPid);

				paraList_tRunJob_1.add("--father_node=tRunJob_1");

				paraList_tRunJob_1.add("--context=Default");

				if (enableLogStash) {
					paraList_tRunJob_1.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_1.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null) {
					paraList_tRunJob_1.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");

				java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_1 = null;

				sales_data_analysis.connexiondb_et_creation_des_tables_0_1.ConnexionDB_et_creation_des_tables childJob_tRunJob_1 = new sales_data_analysis.connexiondb_et_creation_des_tables_0_1.ConnexionDB_et_creation_des_tables();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_1) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
							.entrySet()) {
						dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
								talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
					}
					childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
				}

				childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;

				String[][] childReturn_tRunJob_1 = childJob_tRunJob_1
						.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

				if (childJob_tRunJob_1.getErrorCode() == null) {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE",
							childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
				}
				if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_1.getErrorCode();
				if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
					java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1 != null)
							? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage())
							: ""));
				}

				tos_count_tRunJob_1++;

				/**
				 * [tRunJob_1 main ] stop
				 */

				/**
				 * [tRunJob_1 process_data_begin ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_1 process_data_end ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_end ] stop
				 */

				/**
				 * [tRunJob_1 end ] start
				 */

				currentComponent = "tRunJob_1";

				ok_Hash.put("tRunJob_1", true);
				end_Hash.put("tRunJob_1", System.currentTimeMillis());

				/**
				 * [tRunJob_1 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_1:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tRunJob_2Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRunJob_1 finally ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}

	public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
		final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		static byte[] commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String id_vente;

		public String getId_vente() {
			return this.id_vente;
		}

		public Integer id_agence;

		public Integer getId_agence() {
			return this.id_agence;
		}

		public Integer id_vendeur;

		public Integer getId_vendeur() {
			return this.id_vendeur;
		}

		public Integer id_client;

		public Integer getId_client() {
			return this.id_client;
		}

		public Integer id_produit;

		public Integer getId_produit() {
			return this.id_produit;
		}

		public Integer quantite;

		public Integer getQuantite() {
			return this.quantite;
		}

		public Integer somme;

		public Integer getSomme() {
			return this.somme;
		}

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.id_vente == null) ? 0 : this.id_vente.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out2Struct other = (out2Struct) obj;

			if (this.id_vente == null) {
				if (other.id_vente != null)
					return false;

			} else if (!this.id_vente.equals(other.id_vente))

				return false;

			return true;
		}

		public void copyDataTo(out2Struct other) {

			other.id_vente = this.id_vente;
			other.id_agence = this.id_agence;
			other.id_vendeur = this.id_vendeur;
			other.id_client = this.id_client;
			other.id_produit = this.id_produit;
			other.quantite = this.quantite;
			other.somme = this.somme;
			other.date = this.date;

		}

		public void copyKeysDataTo(out2Struct other) {

			other.id_vente = this.id_vente;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_agence = readInteger(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.somme = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_agence = readInteger(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.somme = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_agence, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// Integer

				writeInteger(this.somme, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_agence, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// Integer

				writeInteger(this.somme, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_vente=" + id_vente);
			sb.append(",id_agence=" + String.valueOf(id_agence));
			sb.append(",id_vendeur=" + String.valueOf(id_vendeur));
			sb.append(",id_client=" + String.valueOf(id_client));
			sb.append(",id_produit=" + String.valueOf(id_produit));
			sb.append(",quantite=" + String.valueOf(quantite));
			sb.append(",somme=" + String.valueOf(somme));
			sb.append(",date=" + String.valueOf(date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		static byte[] commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];

		public String id_vente;

		public String getId_vente() {
			return this.id_vente;
		}

		public Integer id_vendeur;

		public Integer getId_vendeur() {
			return this.id_vendeur;
		}

		public Integer id_client;

		public Integer getId_client() {
			return this.id_client;
		}

		public Integer id_produit;

		public Integer getId_produit() {
			return this.id_produit;
		}

		public Integer quantite;

		public Integer getQuantite() {
			return this.quantite;
		}

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_vente=" + id_vente);
			sb.append(",id_vendeur=" + String.valueOf(id_vendeur));
			sb.append(",id_client=" + String.valueOf(id_client));
			sb.append(",id_produit=" + String.valueOf(id_produit));
			sb.append(",quantite=" + String.valueOf(quantite));
			sb.append(",date=" + String.valueOf(date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tRunJob_2Struct implements routines.system.IPersistableRow<after_tRunJob_2Struct> {
		final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		static byte[] commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String id_vente;

		public String getId_vente() {
			return this.id_vente;
		}

		public Integer id_vendeur;

		public Integer getId_vendeur() {
			return this.id_vendeur;
		}

		public Integer id_client;

		public Integer getId_client() {
			return this.id_client;
		}

		public Integer id_produit;

		public Integer getId_produit() {
			return this.id_produit;
		}

		public Integer quantite;

		public Integer getQuantite() {
			return this.quantite;
		}

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.id_vente == null) ? 0 : this.id_vente.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tRunJob_2Struct other = (after_tRunJob_2Struct) obj;

			if (this.id_vente == null) {
				if (other.id_vente != null)
					return false;

			} else if (!this.id_vente.equals(other.id_vente))

				return false;

			return true;
		}

		public void copyDataTo(after_tRunJob_2Struct other) {

			other.id_vente = this.id_vente;
			other.id_vendeur = this.id_vendeur;
			other.id_client = this.id_client;
			other.id_produit = this.id_produit;
			other.quantite = this.quantite;
			other.date = this.date;

		}

		public void copyKeysDataTo(after_tRunJob_2Struct other) {

			other.id_vente = this.id_vente;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length) {
					if (length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins.length == 0) {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[1024];
					} else {
						commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length);
				strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_vente = readString(dis);

					this.id_vendeur = readInteger(dis);

					this.id_client = readInteger(dis);

					this.id_produit = readInteger(dis);

					this.quantite = readInteger(dis);

					this.date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.id_vente, dos);

				// Integer

				writeInteger(this.id_vendeur, dos);

				// Integer

				writeInteger(this.id_client, dos);

				// Integer

				writeInteger(this.id_produit, dos);

				// Integer

				writeInteger(this.quantite, dos);

				// java.util.Date

				writeDate(this.date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_vente=" + id_vente);
			sb.append(",id_vendeur=" + String.valueOf(id_vendeur));
			sb.append(",id_client=" + String.valueOf(id_client));
			sb.append(",id_produit=" + String.valueOf(id_produit));
			sb.append(",quantite=" + String.valueOf(quantite));
			sb.append(",date=" + String.valueOf(date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tRunJob_2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_1Process(globalMap);
				tDBInput_2Process(globalMap);

				row5Struct row5 = new row5Struct();
				out2Struct out2 = new out2Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out2");
				}

				int tos_count_tDBOutput_1 = 0;

				int updateKeyCount_tDBOutput_1 = 1;
				if (updateKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_1 == 8 && true) {
					System.err.println("For update, every Schema column can not be a key");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "ventes";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db"
						+ "?" + properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				String dbUser_tDBOutput_1 = "root";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:JELDp5yIDKy2GwiWBgsIRN32MbGIPC6HRRY+uM70fLKn9LJx1BU=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement("SELECT COUNT(1) FROM `" + "ventes" + "` WHERE `id_vente` = ?");
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				String insert_tDBOutput_1 = "INSERT INTO `" + "ventes"
						+ "` (`id_vente`,`id_agence`,`id_vendeur`,`id_client`,`id_produit`,`quantite`,`somme`,`date`) VALUES (?,?,?,?,?,?,?,?)";

				java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
				String update_tDBOutput_1 = "UPDATE `" + "ventes"
						+ "` SET `id_agence` = ?,`id_vendeur` = ?,`id_client` = ?,`id_produit` = ?,`quantite` = ?,`somme` = ?,`date` = ? WHERE `id_vente` = ?";

				java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(update_tDBOutput_1);
				resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) globalMap
						.get("tHash_Lookup_row6"));

				row6Struct row6HashKey = new row6Struct();
				row6Struct row6Default = new row6Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row1Struct> tHash_Lookup_row1 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row1Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row1Struct>) globalMap
						.get("tHash_Lookup_row1"));

				row1Struct row1HashKey = new row1Struct();
				row1Struct row1Default = new row1Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tRunJob_2 begin ] start
				 */

				ok_Hash.put("tRunJob_2", false);
				start_Hash.put("tRunJob_2", System.currentTimeMillis());

				currentComponent = "tRunJob_2";

				int tos_count_tRunJob_2 = 0;

				/**
				 * [tRunJob_2 begin ] stop
				 */

				/**
				 * [tRunJob_2 main ] start
				 */

				currentComponent = "tRunJob_2";

				java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();

				paraList_tRunJob_2.add("--father_pid=" + pid);

				paraList_tRunJob_2.add("--root_pid=" + rootPid);

				paraList_tRunJob_2.add("--father_node=tRunJob_2");

				paraList_tRunJob_2.add("--context=Default");

				if (enableLogStash) {
					paraList_tRunJob_2.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_2.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null) {
					paraList_tRunJob_2.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");

				java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

				context.synchronizeContext();
				java.util.Enumeration<?> propertyNames_tRunJob_2 = context.propertyNames();
				while (propertyNames_tRunJob_2.hasMoreElements()) {
					String key_tRunJob_2 = (String) propertyNames_tRunJob_2.nextElement();
					Object value_tRunJob_2 = (Object) context.get(key_tRunJob_2);
					if (value_tRunJob_2 != null) {
						paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + value_tRunJob_2);
					} else {
						paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "="
								+ NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
					}

				}

				Object obj_tRunJob_2 = null;

				sales_data_analysis.input_sales_0_1.input_sales childJob_tRunJob_2 = new sales_data_analysis.input_sales_0_1.input_sales();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_2) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
							.entrySet()) {
						dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
								talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
					}
					childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
				}

				childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;

				String[][] childReturn_tRunJob_2 = childJob_tRunJob_2
						.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));

				if (childJob_tRunJob_2.getErrorCode() == null) {
					globalMap.put("tRunJob_2_CHILD_RETURN_CODE",
							childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
				}
				if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
				}
				errorCode = childJob_tRunJob_2.getErrorCode();
				if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
					java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
					throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2 != null)
							? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage())
							: ""));
				}
				for (String[] item_tRunJob_2 : childReturn_tRunJob_2) {
					if (childJob_tRunJob_2.hastBufferOutputComponent() || true) {

						if (0 < item_tRunJob_2.length) {

							row5.id_vente = item_tRunJob_2[0];

						} else {
							row5.id_vente = null;
						}

						if (1 < item_tRunJob_2.length) {

							row5.id_vendeur = ParserUtils.parseTo_Integer(item_tRunJob_2[1]);

						} else {
							row5.id_vendeur = null;
						}

						if (2 < item_tRunJob_2.length) {

							row5.id_client = ParserUtils.parseTo_Integer(item_tRunJob_2[2]);

						} else {
							row5.id_client = null;
						}

						if (3 < item_tRunJob_2.length) {

							row5.id_produit = ParserUtils.parseTo_Integer(item_tRunJob_2[3]);

						} else {
							row5.id_produit = null;
						}

						if (4 < item_tRunJob_2.length) {

							row5.quantite = ParserUtils.parseTo_Integer(item_tRunJob_2[4]);

						} else {
							row5.quantite = null;
						}

						if (5 < item_tRunJob_2.length) {

							row5.date = ParserUtils.parseTo_Date(item_tRunJob_2[5], "dd/MM/yyyy");

						} else {
							row5.date = null;
						}

					}

					tos_count_tRunJob_2++;

					/**
					 * [tRunJob_2 main ] stop
					 */

					/**
					 * [tRunJob_2 process_data_begin ] start
					 */

					currentComponent = "tRunJob_2";

					/**
					 * [tRunJob_2 process_data_begin ] stop
					 */

					/**
					 * [tMap_1 main ] start
					 */

					currentComponent = "tMap_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row5"

						);
					}

					boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

					// ###############################
					// # Input tables (lookups)
					boolean rejectedInnerJoin_tMap_1 = false;
					boolean mainRowRejected_tMap_1 = false;

					///////////////////////////////////////////////
					// Starting Lookup Table "row6"
					///////////////////////////////////////////////

					boolean forceLooprow6 = false;

					row6Struct row6ObjectFromLookup = null;

					if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

						hasCasePrimitiveKeyWithNull_tMap_1 = false;

						Object exprKeyValue_row6__id_employe = row5.id_vendeur;
						if (exprKeyValue_row6__id_employe == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row6HashKey.id_employe = (int) (Integer) exprKeyValue_row6__id_employe;
						}

						row6HashKey.hashCodeDirty = true;

						if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

							tHash_Lookup_row6.lookup(row6HashKey);

						} // G_TM_M_091

					} // G_TM_M_020

					if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
						// and it contains more one result from keys : row6.id_employe = '" +
						// row6HashKey.id_employe + "'");
					} // G 071

					row6Struct row6 = null;

					row6Struct fromLookup_row6 = null;
					row6 = row6Default;

					if (tHash_Lookup_row6 != null && tHash_Lookup_row6.hasNext()) { // G 099

						fromLookup_row6 = tHash_Lookup_row6.next();

					} // G 099

					if (fromLookup_row6 != null) {
						row6 = fromLookup_row6;
					}

					///////////////////////////////////////////////
					// Starting Lookup Table "row1"
					///////////////////////////////////////////////

					boolean forceLooprow1 = false;

					row1Struct row1ObjectFromLookup = null;

					if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

						hasCasePrimitiveKeyWithNull_tMap_1 = false;

						Object exprKeyValue_row1__id_produit = row5.id_produit;
						if (exprKeyValue_row1__id_produit == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row1HashKey.id_produit = (int) (Integer) exprKeyValue_row1__id_produit;
						}

						row1HashKey.hashCodeDirty = true;

						if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

							tHash_Lookup_row1.lookup(row1HashKey);

						} // G_TM_M_091

					} // G_TM_M_020

					if (tHash_Lookup_row1 != null && tHash_Lookup_row1.getCount(row1HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row1'
						// and it contains more one result from keys : row1.id_produit = '" +
						// row1HashKey.id_produit + "'");
					} // G 071

					row1Struct row1 = null;

					row1Struct fromLookup_row1 = null;
					row1 = row1Default;

					if (tHash_Lookup_row1 != null && tHash_Lookup_row1.hasNext()) { // G 099

						fromLookup_row1 = tHash_Lookup_row1.next();

					} // G 099

					if (fromLookup_row1 != null) {
						row1 = fromLookup_row1;
					}

					// ###############################
					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
						// ###############################
						// # Output tables

						out2 = null;

// # Output table : 'out2'
						out2_tmp.id_vente = row5.id_vente;
						out2_tmp.id_agence = row6.agence;
						out2_tmp.id_vendeur = row5.id_vendeur;
						out2_tmp.id_client = row5.id_client;
						out2_tmp.id_produit = row5.id_produit;
						out2_tmp.quantite = row5.quantite;
						out2_tmp.somme = row1.prix * row5.quantite;
						out2_tmp.date = row5.date;
						out2 = out2_tmp;
// ###############################

					} // end of Var scope

					rejectedInnerJoin_tMap_1 = false;

					tos_count_tMap_1++;

					/**
					 * [tMap_1 main ] stop
					 */

					/**
					 * [tMap_1 process_data_begin ] start
					 */

					currentComponent = "tMap_1";

					/**
					 * [tMap_1 process_data_begin ] stop
					 */
// Start of branch "out2"
					if (out2 != null) {

						/**
						 * [tDBOutput_1 main ] start
						 */

						currentComponent = "tDBOutput_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "out2"

							);
						}

						whetherReject_tDBOutput_1 = false;
						if (out2.id_vente == null) {
							pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
						} else {
							pstmt_tDBOutput_1.setString(1, out2.id_vente);
						}

						int checkCount_tDBOutput_1 = -1;
						try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
							while (rs_tDBOutput_1.next()) {
								checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
							}
						}
						if (checkCount_tDBOutput_1 > 0) {
							if (out2.id_agence == null) {
								pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(1, out2.id_agence);
							}

							if (out2.id_vendeur == null) {
								pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(2, out2.id_vendeur);
							}

							if (out2.id_client == null) {
								pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(3, out2.id_client);
							}

							if (out2.id_produit == null) {
								pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(4, out2.id_produit);
							}

							if (out2.quantite == null) {
								pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(5, out2.quantite);
							}

							if (out2.somme == null) {
								pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
							} else {
								pstmtUpdate_tDBOutput_1.setInt(6, out2.somme);
							}

							if (out2.date != null) {
								date_tDBOutput_1 = out2.date.getTime();
								if (date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
									pstmtUpdate_tDBOutput_1.setString(7, "0000-00-00 00:00:00");
								} else {
									pstmtUpdate_tDBOutput_1.setTimestamp(7, new java.sql.Timestamp(date_tDBOutput_1));
								}
							} else {
								pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.DATE);
							}

							if (out2.id_vente == null) {
								pstmtUpdate_tDBOutput_1.setNull(8 + count_tDBOutput_1, java.sql.Types.VARCHAR);
							} else {
								pstmtUpdate_tDBOutput_1.setString(8 + count_tDBOutput_1, out2.id_vente);
							}

							try {
								int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
								updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
								rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
								nb_line_tDBOutput_1++;
							} catch (java.lang.Exception e) {
								globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
								whetherReject_tDBOutput_1 = true;
								nb_line_tDBOutput_1++;
								System.err.print(e.getMessage());
							}
						} else {
							if (out2.id_vente == null) {
								pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmtInsert_tDBOutput_1.setString(1, out2.id_vente);
							}

							if (out2.id_agence == null) {
								pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(2, out2.id_agence);
							}

							if (out2.id_vendeur == null) {
								pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(3, out2.id_vendeur);
							}

							if (out2.id_client == null) {
								pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(4, out2.id_client);
							}

							if (out2.id_produit == null) {
								pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(5, out2.id_produit);
							}

							if (out2.quantite == null) {
								pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(6, out2.quantite);
							}

							if (out2.somme == null) {
								pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
							} else {
								pstmtInsert_tDBOutput_1.setInt(7, out2.somme);
							}

							if (out2.date != null) {
								date_tDBOutput_1 = out2.date.getTime();
								if (date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
									pstmtInsert_tDBOutput_1.setString(8, "0000-00-00 00:00:00");
								} else {
									pstmtInsert_tDBOutput_1.setTimestamp(8, new java.sql.Timestamp(date_tDBOutput_1));
								}
							} else {
								pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.DATE);
							}

							try {
								int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
								insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
								rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
								nb_line_tDBOutput_1++;
							} catch (java.lang.Exception e) {
								globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
								whetherReject_tDBOutput_1 = true;
								nb_line_tDBOutput_1++;
								System.err.print(e.getMessage());
							}
						}
						commitCounter_tDBOutput_1++;

						if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

							if (rowsToCommitCount_tDBOutput_1 != 0) {
							}
							conn_tDBOutput_1.commit();
							if (rowsToCommitCount_tDBOutput_1 != 0) {
								rowsToCommitCount_tDBOutput_1 = 0;
							}
							commitCounter_tDBOutput_1 = 0;

						}

						tos_count_tDBOutput_1++;

						/**
						 * [tDBOutput_1 main ] stop
						 */

						/**
						 * [tDBOutput_1 process_data_begin ] start
						 */

						currentComponent = "tDBOutput_1";

						/**
						 * [tDBOutput_1 process_data_begin ] stop
						 */

						/**
						 * [tDBOutput_1 process_data_end ] start
						 */

						currentComponent = "tDBOutput_1";

						/**
						 * [tDBOutput_1 process_data_end ] stop
						 */

					} // End of branch "out2"

					/**
					 * [tMap_1 process_data_end ] start
					 */

					currentComponent = "tMap_1";

					/**
					 * [tMap_1 process_data_end ] stop
					 */

				} // C_01

				/**
				 * [tRunJob_2 process_data_end ] start
				 */

				currentComponent = "tRunJob_2";

				/**
				 * [tRunJob_2 process_data_end ] stop
				 */

				/**
				 * [tRunJob_2 end ] start
				 */

				currentComponent = "tRunJob_2";

				ok_Hash.put("tRunJob_2", true);
				end_Hash.put("tRunJob_2", System.currentTimeMillis());

				/**
				 * [tRunJob_2 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row6 != null) {
					tHash_Lookup_row6.endGet();
				}
				globalMap.remove("tHash_Lookup_row6");

				if (tHash_Lookup_row1 != null) {
					tHash_Lookup_row1.endGet();
				}
				globalMap.remove("tHash_Lookup_row1");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				if (pstmtUpdate_tDBOutput_1 != null) {
					pstmtUpdate_tDBOutput_1.close();
					resourceMap.remove("pstmtUpdate_tDBOutput_1");
				}
				if (pstmtInsert_tDBOutput_1 != null) {
					pstmtInsert_tDBOutput_1.close();
					resourceMap.remove("pstmtInsert_tDBOutput_1");
				}
				if (pstmt_tDBOutput_1 != null) {
					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				conn_tDBOutput_1.close();

				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out2");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row6");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row1");

			try {

				/**
				 * [tRunJob_2 finally ] start
				 */

				currentComponent = "tRunJob_2";

				/**
				 * [tRunJob_2 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
						if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtUpdate_tDBOutput_1")) != null) {
							pstmtUpdateToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
						if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtInsert_tDBOutput_1")) != null) {
							pstmtInsertToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
		final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		static byte[] commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id_employe;

		public int getId_employe() {
			return this.id_employe;
		}

		public String nom;

		public String getNom() {
			return this.nom;
		}

		public String poste;

		public String getPoste() {
			return this.poste;
		}

		public String sexe;

		public String getSexe() {
			return this.sexe;
		}

		public String age;

		public String getAge() {
			return this.age;
		}

		public String nationalite;

		public String getNationalite() {
			return this.nationalite;
		}

		public Integer salaire;

		public Integer getSalaire() {
			return this.salaire;
		}

		public Integer agence;

		public Integer getAgence() {
			return this.agence;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id_employe;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row6Struct other = (row6Struct) obj;

			if (this.id_employe != other.id_employe)
				return false;

			return true;
		}

		public void copyDataTo(row6Struct other) {

			other.id_employe = this.id_employe;
			other.nom = this.nom;
			other.poste = this.poste;
			other.sexe = this.sexe;
			other.age = this.age;
			other.nationalite = this.nationalite;
			other.salaire = this.salaire;
			other.agence = this.agence;

		}

		public void copyKeysDataTo(row6Struct other) {

			other.id_employe = this.id_employe;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_employe = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_employe = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id_employe);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id_employe);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.nom = readString(dis, ois);

				this.poste = readString(dis, ois);

				this.sexe = readString(dis, ois);

				this.age = readString(dis, ois);

				this.nationalite = readString(dis, ois);

				this.salaire = readInteger(dis, ois);

				this.agence = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.nom = readString(dis, objectIn);

				this.poste = readString(dis, objectIn);

				this.sexe = readString(dis, objectIn);

				this.age = readString(dis, objectIn);

				this.nationalite = readString(dis, objectIn);

				this.salaire = readInteger(dis, objectIn);

				this.agence = readInteger(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.nom, dos, oos);

				writeString(this.poste, dos, oos);

				writeString(this.sexe, dos, oos);

				writeString(this.age, dos, oos);

				writeString(this.nationalite, dos, oos);

				writeInteger(this.salaire, dos, oos);

				writeInteger(this.agence, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.nom, dos, objectOut);

				writeString(this.poste, dos, objectOut);

				writeString(this.sexe, dos, objectOut);

				writeString(this.age, dos, objectOut);

				writeString(this.nationalite, dos, objectOut);

				writeInteger(this.salaire, dos, objectOut);

				writeInteger(this.agence, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_employe=" + String.valueOf(id_employe));
			sb.append(",nom=" + nom);
			sb.append(",poste=" + poste);
			sb.append(",sexe=" + sexe);
			sb.append(",age=" + age);
			sb.append(",nationalite=" + nationalite);
			sb.append(",salaire=" + String.valueOf(salaire));
			sb.append(",agence=" + String.valueOf(agence));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id_employe, other.id_employe);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row6Struct row6 = new row6Struct();

				/**
				 * [tAdvancedHash_row6 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row6", false);
				start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tAdvancedHash_row6 = 0;

				// connection name:row6
				// source node:tDBInput_1 - inputs:(after_tRunJob_2) outputs:(row6,row6) |
				// target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row5,row6,row1) outputs:(out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row6Struct>getLookup(matchingModeEnum_row6);

				globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);

				/**
				 * [tAdvancedHash_row6 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:fFJb+J8tyEsa45Y+cLHbfxXZ7Wcru3ElHoozNOMP+g4Uoiwetwk=");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db"
						+ "?" + properties_tDBInput_1;

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `employes`.`id_employe`, \n  `employes`.`nom`, \n  `employes`.`poste`, \n  `employes`.`sexe`, \n  `employes`.`age"
						+ "`, \n  `employes`.`nationalite`, \n  `employes`.`salaire`, \n  `employes`.`agence`\nFROM `employes`";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row6.id_employe = 0;
						} else {

							row6.id_employe = rs_tDBInput_1.getInt(1);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row6.nom = null;
						} else {

							row6.nom = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row6.poste = null;
						} else {

							row6.poste = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row6.sexe = null;
						} else {

							row6.sexe = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row6.age = null;
						} else {

							row6.age = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row6.nationalite = null;
						} else {

							row6.nationalite = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row6.salaire = null;
						} else {

							row6.salaire = rs_tDBInput_1.getInt(7);
							if (rs_tDBInput_1.wasNull()) {
								row6.salaire = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row6.agence = null;
						} else {

							row6.agence = rs_tDBInput_1.getInt(8);
							if (rs_tDBInput_1.wasNull()) {
								row6.agence = null;
							}
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 main ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row6"

							);
						}

						row6Struct row6_HashRow = new row6Struct();

						row6_HashRow.id_employe = row6.id_employe;

						row6_HashRow.nom = row6.nom;

						row6_HashRow.poste = row6.poste;

						row6_HashRow.sexe = row6.sexe;

						row6_HashRow.age = row6.age;

						row6_HashRow.nationalite = row6.nationalite;

						row6_HashRow.salaire = row6.salaire;

						row6_HashRow.agence = row6.agence;

						tHash_Lookup_row6.put(row6_HashRow);

						tos_count_tAdvancedHash_row6++;

						/**
						 * [tAdvancedHash_row6 main ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row6 end ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				tHash_Lookup_row6.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tAdvancedHash_row6", true);
				end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row6 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row6 finally ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				/**
				 * [tAdvancedHash_row6 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row1Struct implements routines.system.IPersistableComparableLookupRow<row1Struct> {
		final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		static byte[] commonByteArray_SALES_DATA_ANALYSIS_ETL_papier_et_besoins = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id_produit;

		public int getId_produit() {
			return this.id_produit;
		}

		public String nom;

		public String getNom() {
			return this.nom;
		}

		public Integer prix;

		public Integer getPrix() {
			return this.prix;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id_produit;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row1Struct other = (row1Struct) obj;

			if (this.id_produit != other.id_produit)
				return false;

			return true;
		}

		public void copyDataTo(row1Struct other) {

			other.id_produit = this.id_produit;
			other.nom = this.nom;
			other.prix = this.prix;

		}

		public void copyKeysDataTo(row1Struct other) {

			other.id_produit = this.id_produit;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_produit = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALES_DATA_ANALYSIS_ETL_papier_et_besoins) {

				try {

					int length = 0;

					this.id_produit = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id_produit);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id_produit);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.nom = readString(dis, ois);

				this.prix = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.nom = readString(dis, objectIn);

				this.prix = readInteger(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.nom, dos, oos);

				writeInteger(this.prix, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.nom, dos, objectOut);

				writeInteger(this.prix, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_produit=" + String.valueOf(id_produit));
			sb.append(",nom=" + nom);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id_produit, other.id_produit);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();

				/**
				 * [tAdvancedHash_row1 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row1", false);
				start_Hash.put("tAdvancedHash_row1", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tAdvancedHash_row1 = 0;

				// connection name:row1
				// source node:tDBInput_2 - inputs:(after_tRunJob_2) outputs:(row1,row1) |
				// target node:tAdvancedHash_row1 - inputs:(row1) outputs:()
				// linked node: tMap_1 - inputs:(row5,row6,row1) outputs:(out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row1 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row1Struct> tHash_Lookup_row1 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row1Struct>getLookup(matchingModeEnum_row1);

				globalMap.put("tHash_Lookup_row1", tHash_Lookup_row1);

				/**
				 * [tAdvancedHash_row1 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "root";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:jixtu2J0dpJQsfDzR8Btu4iWJfxEy3apylExpMiazu0LgG3CsiQ=");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db"
						+ "?" + properties_tDBInput_2;

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  `produits`.`id_produit`, \n  `produits`.`nom`, \n  `produits`.`prix`\nFROM `produits`";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row1.id_produit = 0;
						} else {

							row1.id_produit = rs_tDBInput_2.getInt(1);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row1.nom = null;
						} else {

							row1.nom = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row1.prix = null;
						} else {

							row1.prix = rs_tDBInput_2.getInt(3);
							if (rs_tDBInput_2.wasNull()) {
								row1.prix = null;
							}
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row1 main ] start
						 */

						currentComponent = "tAdvancedHash_row1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						row1Struct row1_HashRow = new row1Struct();

						row1_HashRow.id_produit = row1.id_produit;

						row1_HashRow.nom = row1.nom;

						row1_HashRow.prix = row1.prix;

						tHash_Lookup_row1.put(row1_HashRow);

						tos_count_tAdvancedHash_row1++;

						/**
						 * [tAdvancedHash_row1 main ] stop
						 */

						/**
						 * [tAdvancedHash_row1 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row1";

						/**
						 * [tAdvancedHash_row1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row1 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row1";

						/**
						 * [tAdvancedHash_row1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row1 end ] start
				 */

				currentComponent = "tAdvancedHash_row1";

				tHash_Lookup_row1.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tAdvancedHash_row1", true);
				end_Hash.put("tAdvancedHash_row1", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row1 finally ] start
				 */

				currentComponent = "tAdvancedHash_row1";

				/**
				 * [tAdvancedHash_row1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final ETL_papier_et_besoins ETL_papier_et_besoinsClass = new ETL_papier_et_besoins();

		int exitCode = ETL_papier_et_besoinsClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = ETL_papier_et_besoins.class.getClassLoader().getResourceAsStream(
					"sales_data_analysis/etl_papier_et_besoins_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = ETL_papier_et_besoins.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRunJob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRunJob_1) {
			globalMap.put("tRunJob_1_SUBPROCESS_STATE", -1);

			e_tRunJob_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : ETL_papier_et_besoins");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 136989 characters generated by Talend Open Studio for Big Data on the 28
 * janvier 2025, 11:09:04 CET
 ************************************************************************************************/
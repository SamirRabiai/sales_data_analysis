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


package sales_data_analysis.connexiondb_et_creation_des_tables_0_1;

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
 * Job: ConnexionDB_et_creation_des_tables Purpose: .<br>
 * Description: Ce sous job se connecte à la DB de l'entreprise. Il crée ensuite les tables nécesaires si elles n'existent pas.
Il rempli par la suite ces tables des données nécessaires <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class ConnexionDB_et_creation_des_tables implements TalendJob {

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
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
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

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
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
	private final String jobName = "ConnexionDB_et_creation_des_tables";
	private final String projectName = "SALES_DATA_ANALYSIS";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
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
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
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
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				ConnexionDB_et_creation_des_tables.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(ConnexionDB_et_creation_des_tables.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		
	

	
        String properties_tDBConnection_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBConnection_1 == null || properties_tDBConnection_1.trim().length() == 0) {
            properties_tDBConnection_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBConnection_1.contains("rewriteBatchedStatements=")) {
                properties_tDBConnection_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBConnection_1.contains("allowLoadLocalInfile=")) {
                properties_tDBConnection_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBConnection_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBConnection_1;
	String dbUser_tDBConnection_1 = "root";
	
	
		 
	final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:C54P1gDmoJrdE/jaxuIGZAtrepMAvoULVcgrsq6VNQi7s6jItr8=");
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
		
			String driverClass_tDBConnection_1 = "com.mysql.cj.jdbc.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("db_tDBConnection_1","papier_et_besoins_db");
 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());




/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_1:OnSubjobOk1", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tDBRow_2Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_1:OnSubjobOk2", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tDBRow_1Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_1:OnSubjobOk3", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tDBRow_3Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_1:OnSubjobOk4", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
								} 
							
							tDBRow_4Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_1:OnSubjobOk5", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk5", 0, "ok");
								} 
							
							tDBRow_5Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_2_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_2", false);
		start_Hash.put("tDBRow_2", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_2";

	
		int tos_count_tDBRow_2 = 0;
		

	java.sql.Connection conn_tDBRow_2 = null;
	String query_tDBRow_2 = "";
	boolean whetherReject_tDBRow_2 = false;
			String driverClass_tDBRow_2 = "com.mysql.cj.jdbc.Driver";
		    java.lang.Class jdbcclazz_tDBRow_2 = java.lang.Class.forName(driverClass_tDBRow_2);
		
        String properties_tDBRow_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBRow_2 == null || properties_tDBRow_2.trim().length() == 0) {
            properties_tDBRow_2 = "allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBRow_2.contains("allowLoadLocalInfile=")) {
                properties_tDBRow_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBRow_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBRow_2;
					String dbUser_tDBRow_2 = "root";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:kqCPqbL3W6WOb1SQ049sp/y13q9eu+rRWQt0NAq5iahjPh3lA1w=");
        		   	
        	        String dbPwd_tDBRow_2 = decryptedPassword_tDBRow_2;
	        
					
			conn_tDBRow_2 = java.sql.DriverManager.getConnection(url_tDBRow_2,dbUser_tDBRow_2,dbPwd_tDBRow_2);
		
        resourceMap.put("conn_tDBRow_2", conn_tDBRow_2);
					if(conn_tDBRow_2.getAutoCommit()) {
						
				conn_tDBRow_2.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_2 = 10000;
					int commitCounter_tDBRow_2 = 0;
				
        java.sql.Statement stmt_tDBRow_2 = conn_tDBRow_2.createStatement();
        resourceMap.put("stmt_tDBRow_2", stmt_tDBRow_2);

 



/**
 * [tDBRow_2 begin ] stop
 */
	
	/**
	 * [tDBRow_2 main ] start
	 */

	

	
	
	currentComponent="tDBRow_2";

	

query_tDBRow_2 = "CREATE TABLE IF NOT EXISTS agences (\n	id_agence INT primary key,\n	nom VARCHAR(255),\n	ville VARCHAR(255),\n	adresse V"
+"ARCHAR(255)\n	);";
whetherReject_tDBRow_2 = false;
globalMap.put("tDBRow_2_QUERY",query_tDBRow_2);
try {
		stmt_tDBRow_2.execute(query_tDBRow_2);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_2 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_2_ERROR_MESSAGE", e.getMessage());
				
	}
	
	if(!whetherReject_tDBRow_2) {
		
	}
	
		commitCounter_tDBRow_2++;
		if(commitEvery_tDBRow_2 <= commitCounter_tDBRow_2) {
			
			conn_tDBRow_2.commit();
			
			commitCounter_tDBRow_2=0;
		}
		

 


	tos_count_tDBRow_2++;

/**
 * [tDBRow_2 main ] stop
 */
	
	/**
	 * [tDBRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_2";

	

 



/**
 * [tDBRow_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_2";

	

 



/**
 * [tDBRow_2 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_2 end ] start
	 */

	

	
	
	currentComponent="tDBRow_2";

	

	
        stmt_tDBRow_2.close();
        resourceMap.remove("stmt_tDBRow_2");
    resourceMap.put("statementClosed_tDBRow_2", true);
		if(commitEvery_tDBRow_2>commitCounter_tDBRow_2){

			
			conn_tDBRow_2.commit();
			
	
			commitCounter_tDBRow_2=0;
	
		}
			conn_tDBRow_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_2", true);
 

ok_Hash.put("tDBRow_2", true);
end_Hash.put("tDBRow_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tFileInputDelimited_2Process(globalMap);



/**
 * [tDBRow_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_2 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_2";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_2") == null) {
            java.sql.Statement stmtToClose_tDBRow_2 = null;
            if ((stmtToClose_tDBRow_2 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_2")) != null) {
                stmtToClose_tDBRow_2.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_2") == null){
            java.sql.Connection ctn_tDBRow_2 = null;
            if((ctn_tDBRow_2 = (java.sql.Connection)resourceMap.get("conn_tDBRow_2")) != null){
                try {
                    ctn_tDBRow_2.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_2) {
                    String errorMessage_tDBRow_2 = "failed to close the connection in tDBRow_2 :" + sqlEx_tDBRow_2.getMessage();
                    System.err.println(errorMessage_tDBRow_2);
                }
            }
        }
    }
 



/**
 * [tDBRow_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_agence;

				public int getId_agence () {
					return this.id_agence;
				}
				
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String ville;

				public String getVille () {
					return this.ville;
				}
				
			    public String adresse;

				public String getAdresse () {
					return this.adresse;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.id_agence;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row4Struct other = (row4Struct) obj;
		
						if (this.id_agence != other.id_agence)
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.id_agence = this.id_agence;
	            other.nom = this.nom;
	            other.ville = this.ville;
	            other.adresse = this.adresse;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.id_agence = this.id_agence;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_agence = dis.readInt();
					
					this.nom = readString(dis);
					
					this.ville = readString(dis);
					
					this.adresse = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_agence = dis.readInt();
					
					this.nom = readString(dis);
					
					this.ville = readString(dis);
					
					this.adresse = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_agence);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.ville,dos);
					
					// String
				
						writeString(this.adresse,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_agence);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.ville,dos);
					
					// String
				
						writeString(this.adresse,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_agence="+String.valueOf(id_agence));
		sb.append(",nom="+nom);
		sb.append(",ville="+ville);
		sb.append(",adresse="+adresse);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_agence, other.id_agence);
						if(returnValue != 0) {
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
public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_4", false);
		start_Hash.put("tDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tDBOutput_4 = 0;
		





        int updateKeyCount_tDBOutput_4 = 1;
        if(updateKeyCount_tDBOutput_4 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_4 == 4 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_4 = 0;
int nb_line_update_tDBOutput_4 = 0;
int nb_line_inserted_tDBOutput_4 = 0;
int nb_line_deleted_tDBOutput_4 = 0;
int nb_line_rejected_tDBOutput_4 = 0;

int deletedCount_tDBOutput_4=0;
int updatedCount_tDBOutput_4=0;
int insertedCount_tDBOutput_4=0;
int rowsToCommitCount_tDBOutput_4=0;
int rejectedCount_tDBOutput_4=0;

String tableName_tDBOutput_4 = "agences";
boolean whetherReject_tDBOutput_4 = false;

java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
calendar_tDBOutput_4.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
calendar_tDBOutput_4.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
long date_tDBOutput_4;

java.sql.Connection conn_tDBOutput_4 = null;
		
        String properties_tDBOutput_4 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBOutput_4 == null || properties_tDBOutput_4.trim().length() == 0) {
            properties_tDBOutput_4 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_4.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_4 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_4.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_4 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_4 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBOutput_4;
		
		String driverClass_tDBOutput_4 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_4 = "root";
		

		 
	final String decryptedPassword_tDBOutput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:gd67Ki+B123IfJFCvxOvUI/jZygzWTMBQUNoJgCN4Z1TrTzFHeE=");

		String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
		java.lang.Class.forName(driverClass_tDBOutput_4);
		
		conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4, dbPwd_tDBOutput_4);
		
	
	resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);
        conn_tDBOutput_4.setAutoCommit(false);
        int commitEvery_tDBOutput_4 = 10000;
        int commitCounter_tDBOutput_4 = 0;

int count_tDBOutput_4=0;
    	
	    java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement("SELECT COUNT(1) FROM `" + "agences" + "` WHERE `id_agence` = ?");
	    resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);
	    String insert_tDBOutput_4 = "INSERT INTO `" + "agences" + "` (`id_agence`,`nom`,`ville`,`adresse`) VALUES (?,?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
	    resourceMap.put("pstmtInsert_tDBOutput_4", pstmtInsert_tDBOutput_4);
	    String update_tDBOutput_4 = "UPDATE `" + "agences" + "` SET `nom` = ?,`ville` = ?,`adresse` = ? WHERE `id_agence` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(update_tDBOutput_4);
	    resourceMap.put("pstmtUpdate_tDBOutput_4", pstmtUpdate_tDBOutput_4);
	    

 



/**
 * [tDBOutput_4 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_2", false);
		start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_2";

	
		int tos_count_tFileInputDelimited_2 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = -1;
				try{
					
						Object filename_tFileInputDelimited_2 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/agences.csv";
						if(filename_tFileInputDelimited_2 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
			if(footer_value_tFileInputDelimited_2 >0 || random_value_tFileInputDelimited_2 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/agences.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_2
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_2!=null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();
						
			    						row4 = null;			
												
									boolean whetherReject_tFileInputDelimited_2 = false;
									row4 = new row4Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_2 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_2 = 0;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row4.id_agence = ParserUtils.parseTo_int(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_agence", "row4", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								rowstate_tFileInputDelimited_2.setException(new RuntimeException("Value is empty for column : 'id_agence' in 'row4' connection, value is invalid or this column should be nullable or have a default value."));
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 1;
					
							row4.nom = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 2;
					
							row4.ville = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 3;
					
							row4.adresse = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
				
										
										if(rowstate_tFileInputDelimited_2.getException()!=null) {
											throw rowstate_tFileInputDelimited_2.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_2 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row4 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_2 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 


	tos_count_tFileInputDelimited_2++;

/**
 * [tFileInputDelimited_2 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_begin ] stop
 */
// Start of branch "row4"
if(row4 != null) { 



	
	/**
	 * [tDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					



        whetherReject_tDBOutput_4 = false;
                    pstmt_tDBOutput_4.setInt(1, row4.id_agence);

            int checkCount_tDBOutput_4 = -1;
            try (java.sql.ResultSet rs_tDBOutput_4 = pstmt_tDBOutput_4.executeQuery()) {
                while(rs_tDBOutput_4.next()) {
                    checkCount_tDBOutput_4 = rs_tDBOutput_4.getInt(1);
                }
            }
            if(checkCount_tDBOutput_4 > 0) {
                        if(row4.nom == null) {
pstmtUpdate_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(1, row4.nom);
}

                        if(row4.ville == null) {
pstmtUpdate_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(2, row4.ville);
}

                        if(row4.adresse == null) {
pstmtUpdate_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(3, row4.adresse);
}

                        pstmtUpdate_tDBOutput_4.setInt(4 + count_tDBOutput_4, row4.id_agence);

                try {
                    int processedCount_tDBOutput_4 = pstmtUpdate_tDBOutput_4.executeUpdate();
                    updatedCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    rowsToCommitCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    nb_line_tDBOutput_4++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_4 = true;
                        nb_line_tDBOutput_4++;
                            System.err.print(e.getMessage());
                }
            } else {
                        pstmtInsert_tDBOutput_4.setInt(1, row4.id_agence);

                        if(row4.nom == null) {
pstmtInsert_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(2, row4.nom);
}

                        if(row4.ville == null) {
pstmtInsert_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(3, row4.ville);
}

                        if(row4.adresse == null) {
pstmtInsert_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(4, row4.adresse);
}

                try {
                    int processedCount_tDBOutput_4 = pstmtInsert_tDBOutput_4.executeUpdate();
                    insertedCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    rowsToCommitCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    nb_line_tDBOutput_4++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_4 = true;
                        nb_line_tDBOutput_4++;
                            System.err.print(e.getMessage());
                }
            }
                commitCounter_tDBOutput_4++;

                if(commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {

                    if(rowsToCommitCount_tDBOutput_4 != 0){
                    }
                    conn_tDBOutput_4.commit();
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                        rowsToCommitCount_tDBOutput_4 = 0;
                    }
                    commitCounter_tDBOutput_4=0;

                }


 


	tos_count_tDBOutput_4++;

/**
 * [tDBOutput_4 main ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_end ] stop
 */

} // End of branch "row4"




	
	/**
	 * [tFileInputDelimited_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/agences.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_2!=null){
                		fid_tFileInputDelimited_2.close();
                	}
                }
                if(fid_tFileInputDelimited_2!=null){
                	globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_2", true);
end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());




/**
 * [tFileInputDelimited_2 end ] stop
 */

	
	/**
	 * [tDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



        if(pstmtUpdate_tDBOutput_4 != null){
            pstmtUpdate_tDBOutput_4.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_4");
        }
        if(pstmtInsert_tDBOutput_4 != null){
            pstmtInsert_tDBOutput_4.close();
            resourceMap.remove("pstmtInsert_tDBOutput_4");
        }
        if(pstmt_tDBOutput_4 != null) {
            pstmt_tDBOutput_4.close();
            resourceMap.remove("pstmt_tDBOutput_4");
        }
    resourceMap.put("statementClosed_tDBOutput_4", true);
    	if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {
    		
    	}
    	conn_tDBOutput_4.commit();
    	if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {
    		
			rowsToCommitCount_tDBOutput_4 = 0;
    	}
		commitCounter_tDBOutput_4 = 0;
    	
		
    	conn_tDBOutput_4 .close();
    	
    	resourceMap.put("finish_tDBOutput_4", true);
    	

	nb_line_deleted_tDBOutput_4=nb_line_deleted_tDBOutput_4+ deletedCount_tDBOutput_4;
	nb_line_update_tDBOutput_4=nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
	nb_line_inserted_tDBOutput_4=nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
	nb_line_rejected_tDBOutput_4=nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;
	
        globalMap.put("tDBOutput_4_NB_LINE",nb_line_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_UPDATED",nb_line_update_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_DELETED",nb_line_deleted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tDBOutput_4", true);
end_Hash.put("tDBOutput_4", System.currentTimeMillis());




/**
 * [tDBOutput_4 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_4 = null;
                if ((pstmtUpdateToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_4")) != null) {
                    pstmtUpdateToClose_tDBOutput_4.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_4 = null;
                if ((pstmtInsertToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_4")) != null) {
                    pstmtInsertToClose_tDBOutput_4.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
                if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_4")) != null) {
                    pstmtToClose_tDBOutput_4.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_4") == null){
            java.sql.Connection ctn_tDBOutput_4 = null;
            if((ctn_tDBOutput_4 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_4")) != null){
                try {
                    ctn_tDBOutput_4.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_4) {
                    String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :" + sqlEx_tDBOutput_4.getMessage();
                    System.err.println(errorMessage_tDBOutput_4);
                }
            }
        }
    }
 



/**
 * [tDBOutput_4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_1", false);
		start_Hash.put("tDBRow_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_1";

	
		int tos_count_tDBRow_1 = 0;
		

	java.sql.Connection conn_tDBRow_1 = null;
	String query_tDBRow_1 = "";
	boolean whetherReject_tDBRow_1 = false;
			String driverClass_tDBRow_1 = "com.mysql.cj.jdbc.Driver";
		    java.lang.Class jdbcclazz_tDBRow_1 = java.lang.Class.forName(driverClass_tDBRow_1);
		
        String properties_tDBRow_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBRow_1 == null || properties_tDBRow_1.trim().length() == 0) {
            properties_tDBRow_1 = "allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBRow_1.contains("allowLoadLocalInfile=")) {
                properties_tDBRow_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBRow_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBRow_1;
					String dbUser_tDBRow_1 = "root";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:IMxzgZCjoh3VXAsGNP821YRKRQ0V++2d9KMXju/mMEP86sb3PWQ=");
        		   	
        	        String dbPwd_tDBRow_1 = decryptedPassword_tDBRow_1;
	        
					
			conn_tDBRow_1 = java.sql.DriverManager.getConnection(url_tDBRow_1,dbUser_tDBRow_1,dbPwd_tDBRow_1);
		
        resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
					if(conn_tDBRow_1.getAutoCommit()) {
						
				conn_tDBRow_1.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_1 = 10000;
					int commitCounter_tDBRow_1 = 0;
				
        java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
        resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

 



/**
 * [tDBRow_1 begin ] stop
 */
	
	/**
	 * [tDBRow_1 main ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

query_tDBRow_1 = "CREATE TABLE IF NOT EXISTS employes (\n	id_employe INT primary key,\n	nom VARCHAR(255),\n	poste VARCHAR(255),\n	sexe VA"
+"RCHAR(255),\n	age INT,\n	nationalite VARCHAR(20),\n	salaire INT,\n	agence INT NOT NULL,\n	FOREIGN KEY(agence) REFERENCES"
+" agences(id_agence)\n	ON DELETE CASCADE\n	ON UPDATE CASCADE\n);";
whetherReject_tDBRow_1 = false;
globalMap.put("tDBRow_1_QUERY",query_tDBRow_1);
try {
		stmt_tDBRow_1.execute(query_tDBRow_1);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_1 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());
				
	}
	
	if(!whetherReject_tDBRow_1) {
		
	}
	
		commitCounter_tDBRow_1++;
		if(commitEvery_tDBRow_1 <= commitCounter_tDBRow_1) {
			
			conn_tDBRow_1.commit();
			
			commitCounter_tDBRow_1=0;
		}
		

 


	tos_count_tDBRow_1++;

/**
 * [tDBRow_1 main ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_1 end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

	
        stmt_tDBRow_1.close();
        resourceMap.remove("stmt_tDBRow_1");
    resourceMap.put("statementClosed_tDBRow_1", true);
		if(commitEvery_tDBRow_1>commitCounter_tDBRow_1){

			
			conn_tDBRow_1.commit();
			
	
			commitCounter_tDBRow_1=0;
	
		}
			conn_tDBRow_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_1", true);
 

ok_Hash.put("tDBRow_1", true);
end_Hash.put("tDBRow_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tFileInputDelimited_1Process(globalMap);



/**
 * [tDBRow_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_1") == null) {
            java.sql.Statement stmtToClose_tDBRow_1 = null;
            if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
                stmtToClose_tDBRow_1.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_1") == null){
            java.sql.Connection ctn_tDBRow_1 = null;
            if((ctn_tDBRow_1 = (java.sql.Connection)resourceMap.get("conn_tDBRow_1")) != null){
                try {
                    ctn_tDBRow_1.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_1) {
                    String errorMessage_tDBRow_1 = "failed to close the connection in tDBRow_1 :" + sqlEx_tDBRow_1.getMessage();
                    System.err.println(errorMessage_tDBRow_1);
                }
            }
        }
    }
 



/**
 * [tDBRow_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}
	


public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_employe;

				public int getId_employe () {
					return this.id_employe;
				}
				
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String poste;

				public String getPoste () {
					return this.poste;
				}
				
			    public String sexe;

				public String getSexe () {
					return this.sexe;
				}
				
			    public Integer age;

				public Integer getAge () {
					return this.age;
				}
				
			    public String nationalite;

				public String getNationalite () {
					return this.nationalite;
				}
				
			    public Integer salaire;

				public Integer getSalaire () {
					return this.salaire;
				}
				
			    public int agence;

				public int getAgence () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final out1Struct other = (out1Struct) obj;
		
						if (this.id_employe != other.id_employe)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.id_employe = this.id_employe;
	            other.nom = this.nom;
	            other.poste = this.poste;
	            other.sexe = this.sexe;
	            other.age = this.age;
	            other.nationalite = this.nationalite;
	            other.salaire = this.salaire;
	            other.agence = this.agence;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.id_employe = this.id_employe;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_employe = dis.readInt();
					
					this.nom = readString(dis);
					
					this.poste = readString(dis);
					
					this.sexe = readString(dis);
					
						this.age = readInteger(dis);
					
					this.nationalite = readString(dis);
					
						this.salaire = readInteger(dis);
					
			        this.agence = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_employe = dis.readInt();
					
					this.nom = readString(dis);
					
					this.poste = readString(dis);
					
					this.sexe = readString(dis);
					
						this.age = readInteger(dis);
					
					this.nationalite = readString(dis);
					
						this.salaire = readInteger(dis);
					
			        this.agence = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_employe);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.poste,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
					// String
				
						writeString(this.nationalite,dos);
					
					// Integer
				
						writeInteger(this.salaire,dos);
					
					// int
				
		            	dos.writeInt(this.agence);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_employe);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.poste,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
					// String
				
						writeString(this.nationalite,dos);
					
					// Integer
				
						writeInteger(this.salaire,dos);
					
					// int
				
		            	dos.writeInt(this.agence);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_employe="+String.valueOf(id_employe));
		sb.append(",nom="+nom);
		sb.append(",poste="+poste);
		sb.append(",sexe="+sexe);
		sb.append(",age="+String.valueOf(age));
		sb.append(",nationalite="+nationalite);
		sb.append(",salaire="+String.valueOf(salaire));
		sb.append(",agence="+String.valueOf(agence));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_employe, other.id_employe);
						if(returnValue != 0) {
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

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];

	
			    public int id_employe;

				public int getId_employe () {
					return this.id_employe;
				}
				
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String prenom;

				public String getPrenom () {
					return this.prenom;
				}
				
			    public String poste;

				public String getPoste () {
					return this.poste;
				}
				
			    public String sexe;

				public String getSexe () {
					return this.sexe;
				}
				
			    public Integer age;

				public Integer getAge () {
					return this.age;
				}
				
			    public String nationalite;

				public String getNationalite () {
					return this.nationalite;
				}
				
			    public Integer salaire;

				public Integer getSalaire () {
					return this.salaire;
				}
				
			    public Integer contact;

				public Integer getContact () {
					return this.contact;
				}
				
			    public int id_agence;

				public int getId_agence () {
					return this.id_agence;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_employe = dis.readInt();
					
					this.nom = readString(dis);
					
					this.prenom = readString(dis);
					
					this.poste = readString(dis);
					
					this.sexe = readString(dis);
					
						this.age = readInteger(dis);
					
					this.nationalite = readString(dis);
					
						this.salaire = readInteger(dis);
					
						this.contact = readInteger(dis);
					
			        this.id_agence = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_employe = dis.readInt();
					
					this.nom = readString(dis);
					
					this.prenom = readString(dis);
					
					this.poste = readString(dis);
					
					this.sexe = readString(dis);
					
						this.age = readInteger(dis);
					
					this.nationalite = readString(dis);
					
						this.salaire = readInteger(dis);
					
						this.contact = readInteger(dis);
					
			        this.id_agence = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_employe);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.prenom,dos);
					
					// String
				
						writeString(this.poste,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
					// String
				
						writeString(this.nationalite,dos);
					
					// Integer
				
						writeInteger(this.salaire,dos);
					
					// Integer
				
						writeInteger(this.contact,dos);
					
					// int
				
		            	dos.writeInt(this.id_agence);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_employe);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.prenom,dos);
					
					// String
				
						writeString(this.poste,dos);
					
					// String
				
						writeString(this.sexe,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
					// String
				
						writeString(this.nationalite,dos);
					
					// Integer
				
						writeInteger(this.salaire,dos);
					
					// Integer
				
						writeInteger(this.contact,dos);
					
					// int
				
		            	dos.writeInt(this.id_agence);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_employe="+String.valueOf(id_employe));
		sb.append(",nom="+nom);
		sb.append(",prenom="+prenom);
		sb.append(",poste="+poste);
		sb.append(",sexe="+sexe);
		sb.append(",age="+String.valueOf(age));
		sb.append(",nationalite="+nationalite);
		sb.append(",salaire="+String.valueOf(salaire));
		sb.append(",contact="+String.valueOf(contact));
		sb.append(",id_agence="+String.valueOf(id_agence));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

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
public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();
out1Struct out1 = new out1Struct();





	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tDBOutput_3 = 0;
		





        int updateKeyCount_tDBOutput_3 = 1;
        if(updateKeyCount_tDBOutput_3 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_3 == 8 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

String tableName_tDBOutput_3 = "employes";
boolean whetherReject_tDBOutput_3 = false;

java.util.Calendar calendar_tDBOutput_3 = java.util.Calendar.getInstance();
calendar_tDBOutput_3.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
calendar_tDBOutput_3.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
long date_tDBOutput_3;

java.sql.Connection conn_tDBOutput_3 = null;
		
        String properties_tDBOutput_3 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBOutput_3 == null || properties_tDBOutput_3.trim().length() == 0) {
            properties_tDBOutput_3 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_3.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_3 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_3.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_3 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_3 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBOutput_3;
		
		String driverClass_tDBOutput_3 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_3 = "root";
		

		 
	final String decryptedPassword_tDBOutput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:ZT+UMchJXBb/HHjMspqEG8jYpZ8FuQxFXQI+h8nqpBs+GFg1b3U=");

		String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;
		java.lang.Class.forName(driverClass_tDBOutput_3);
		
		conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3, dbUser_tDBOutput_3, dbPwd_tDBOutput_3);
		
	
	resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);
        conn_tDBOutput_3.setAutoCommit(false);
        int commitEvery_tDBOutput_3 = 10000;
        int commitCounter_tDBOutput_3 = 0;

int count_tDBOutput_3=0;
    	
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_3 = conn_tDBOutput_3.getMetaData();
                                    java.sql.ResultSet rsTable_tDBOutput_3 = dbMetaData_tDBOutput_3.getTables("papier_et_besoins_db", null, null, new String[]{"TABLE"});
                                boolean whetherExist_tDBOutput_3 = false;
                                while(rsTable_tDBOutput_3.next()) {
                                    String table_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_NAME");
                                    if(table_tDBOutput_3.equalsIgnoreCase("employes")) {
                                        whetherExist_tDBOutput_3 = true;
                                        break;
                                    }
                                }
                                if(!whetherExist_tDBOutput_3) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                                        stmtCreate_tDBOutput_3.execute("CREATE TABLE `" + tableName_tDBOutput_3 + "`(`id_employe` INT(0)   not null ,`nom` VARCHAR(0)  ,`poste` VARCHAR(0)  ,`sexe` VARCHAR(0)  ,`age` INT(0)  ,`nationalite` VARCHAR(0)  ,`salaire` INT(0)  ,`agence` INT(0)   not null ,primary key(`id_employe`))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement("SELECT COUNT(1) FROM `" + "employes" + "` WHERE `id_employe` = ?");
	    resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);
	    String insert_tDBOutput_3 = "INSERT INTO `" + "employes" + "` (`id_employe`,`nom`,`poste`,`sexe`,`age`,`nationalite`,`salaire`,`agence`) VALUES (?,?,?,?,?,?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
	    resourceMap.put("pstmtInsert_tDBOutput_3", pstmtInsert_tDBOutput_3);
	    String update_tDBOutput_3 = "UPDATE `" + "employes" + "` SET `nom` = ?,`poste` = ?,`sexe` = ?,`age` = ?,`nationalite` = ?,`salaire` = ?,`agence` = ? WHERE `id_employe` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(update_tDBOutput_3);
	    resourceMap.put("pstmtUpdate_tDBOutput_3", pstmtUpdate_tDBOutput_3);
	    

 



/**
 * [tDBOutput_3 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_1", false);
		start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_1";

	
		int tos_count_tFileInputDelimited_1 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try{
					
						Object filename_tFileInputDelimited_1 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/employes.csv";
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/employes.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_1
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_1!=null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();
						
			    						row3 = null;			
												
									boolean whetherReject_tFileInputDelimited_1 = false;
									row3 = new row3Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_1 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_1 = 0;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row3.id_employe = ParserUtils.parseTo_int(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_employe", "row3", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								rowstate_tFileInputDelimited_1.setException(new RuntimeException("Value is empty for column : 'id_employe' in 'row3' connection, value is invalid or this column should be nullable or have a default value."));
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
							row3.nom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
							row3.prenom = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 3;
					
							row3.poste = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 4;
					
							row3.sexe = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 5;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row3.age = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"age", "row3", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row3.age = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 6;
					
							row3.nationalite = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 7;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row3.salaire = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"salaire", "row3", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row3.salaire = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 8;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row3.contact = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"contact", "row3", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row3.contact = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 9;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row3.id_agence = ParserUtils.parseTo_int(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_agence", "row3", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								rowstate_tFileInputDelimited_1.setException(new RuntimeException("Value is empty for column : 'id_agence' in 'row3' connection, value is invalid or this column should be nullable or have a default value."));
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_1.getException()!=null) {
											throw rowstate_tFileInputDelimited_1.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_1 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row3 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_1 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 


	tos_count_tFileInputDelimited_1++;

/**
 * [tFileInputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.id_employe = row3.id_employe ;
out1_tmp.nom = row3.nom + " " +  row3.prenom ;
out1_tmp.poste = row3.poste ;
out1_tmp.sexe = row3.sexe ;
out1_tmp.age = row3.age ;
out1_tmp.nationalite = row3.nationalite ;
out1_tmp.salaire = row3.salaire ;
out1_tmp.agence = row3.id_agence ;
out1 = out1_tmp;
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

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					



        whetherReject_tDBOutput_3 = false;
                    pstmt_tDBOutput_3.setInt(1, out1.id_employe);

            int checkCount_tDBOutput_3 = -1;
            try (java.sql.ResultSet rs_tDBOutput_3 = pstmt_tDBOutput_3.executeQuery()) {
                while(rs_tDBOutput_3.next()) {
                    checkCount_tDBOutput_3 = rs_tDBOutput_3.getInt(1);
                }
            }
            if(checkCount_tDBOutput_3 > 0) {
                        if(out1.nom == null) {
pstmtUpdate_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(1, out1.nom);
}

                        if(out1.poste == null) {
pstmtUpdate_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(2, out1.poste);
}

                        if(out1.sexe == null) {
pstmtUpdate_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(3, out1.sexe);
}

                        if(out1.age == null) {
pstmtUpdate_tDBOutput_3.setNull(4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(4, out1.age);
}

                        if(out1.nationalite == null) {
pstmtUpdate_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(5, out1.nationalite);
}

                        if(out1.salaire == null) {
pstmtUpdate_tDBOutput_3.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(6, out1.salaire);
}

                        pstmtUpdate_tDBOutput_3.setInt(7, out1.agence);

                        pstmtUpdate_tDBOutput_3.setInt(8 + count_tDBOutput_3, out1.id_employe);

                try {
                    int processedCount_tDBOutput_3 = pstmtUpdate_tDBOutput_3.executeUpdate();
                    updatedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_3 = true;
                        nb_line_tDBOutput_3++;
                            System.err.print(e.getMessage());
                }
            } else {
                        pstmtInsert_tDBOutput_3.setInt(1, out1.id_employe);

                        if(out1.nom == null) {
pstmtInsert_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(2, out1.nom);
}

                        if(out1.poste == null) {
pstmtInsert_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(3, out1.poste);
}

                        if(out1.sexe == null) {
pstmtInsert_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(4, out1.sexe);
}

                        if(out1.age == null) {
pstmtInsert_tDBOutput_3.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(5, out1.age);
}

                        if(out1.nationalite == null) {
pstmtInsert_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(6, out1.nationalite);
}

                        if(out1.salaire == null) {
pstmtInsert_tDBOutput_3.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(7, out1.salaire);
}

                        pstmtInsert_tDBOutput_3.setInt(8, out1.agence);

                try {
                    int processedCount_tDBOutput_3 = pstmtInsert_tDBOutput_3.executeUpdate();
                    insertedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_3 = true;
                        nb_line_tDBOutput_3++;
                            System.err.print(e.getMessage());
                }
            }
                commitCounter_tDBOutput_3++;

                if(commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {

                    if(rowsToCommitCount_tDBOutput_3 != 0){
                    }
                    conn_tDBOutput_3.commit();
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                        rowsToCommitCount_tDBOutput_3 = 0;
                    }
                    commitCounter_tDBOutput_3=0;

                }


 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row3"




	
	/**
	 * [tFileInputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/employes.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_1!=null){
                		fid_tFileInputDelimited_1.close();
                	}
                }
                if(fid_tFileInputDelimited_1!=null){
                	globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



        if(pstmtUpdate_tDBOutput_3 != null){
            pstmtUpdate_tDBOutput_3.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_3");
        }
        if(pstmtInsert_tDBOutput_3 != null){
            pstmtInsert_tDBOutput_3.close();
            resourceMap.remove("pstmtInsert_tDBOutput_3");
        }
        if(pstmt_tDBOutput_3 != null) {
            pstmt_tDBOutput_3.close();
            resourceMap.remove("pstmt_tDBOutput_3");
        }
    resourceMap.put("statementClosed_tDBOutput_3", true);
    	if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {
    		
    	}
    	conn_tDBOutput_3.commit();
    	if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {
    		
			rowsToCommitCount_tDBOutput_3 = 0;
    	}
		commitCounter_tDBOutput_3 = 0;
    	
		
    	conn_tDBOutput_3 .close();
    	
    	resourceMap.put("finish_tDBOutput_3", true);
    	

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());




/**
 * [tDBOutput_3 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_3 = null;
                if ((pstmtUpdateToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_3")) != null) {
                    pstmtUpdateToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_3 = null;
                if ((pstmtInsertToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_3")) != null) {
                    pstmtInsertToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_3") == null){
            java.sql.Connection ctn_tDBOutput_3 = null;
            if((ctn_tDBOutput_3 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_3")) != null){
                try {
                    ctn_tDBOutput_3.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_3) {
                    String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :" + sqlEx_tDBOutput_3.getMessage();
                    System.err.println(errorMessage_tDBOutput_3);
                }
            }
        }
    }
 



/**
 * [tDBOutput_3 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_3_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBRow_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_3", false);
		start_Hash.put("tDBRow_3", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_3";

	
		int tos_count_tDBRow_3 = 0;
		

	java.sql.Connection conn_tDBRow_3 = null;
	String query_tDBRow_3 = "";
	boolean whetherReject_tDBRow_3 = false;
			String driverClass_tDBRow_3 = "com.mysql.cj.jdbc.Driver";
		    java.lang.Class jdbcclazz_tDBRow_3 = java.lang.Class.forName(driverClass_tDBRow_3);
		
        String properties_tDBRow_3 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBRow_3 == null || properties_tDBRow_3.trim().length() == 0) {
            properties_tDBRow_3 = "allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBRow_3.contains("allowLoadLocalInfile=")) {
                properties_tDBRow_3 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBRow_3 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBRow_3;
					String dbUser_tDBRow_3 = "root";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:yKoS4r90OQWa0WjVKSPZJn3UiyDUbLK4HPRFWYJW2s3LqJRqmGA=");
        		   	
        	        String dbPwd_tDBRow_3 = decryptedPassword_tDBRow_3;
	        
					
			conn_tDBRow_3 = java.sql.DriverManager.getConnection(url_tDBRow_3,dbUser_tDBRow_3,dbPwd_tDBRow_3);
		
        resourceMap.put("conn_tDBRow_3", conn_tDBRow_3);
					if(conn_tDBRow_3.getAutoCommit()) {
						
				conn_tDBRow_3.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_3 = 10000;
					int commitCounter_tDBRow_3 = 0;
				
        java.sql.Statement stmt_tDBRow_3 = conn_tDBRow_3.createStatement();
        resourceMap.put("stmt_tDBRow_3", stmt_tDBRow_3);

 



/**
 * [tDBRow_3 begin ] stop
 */
	
	/**
	 * [tDBRow_3 main ] start
	 */

	

	
	
	currentComponent="tDBRow_3";

	

query_tDBRow_3 = "CREATE TABLE IF NOT EXISTS produits (\n	id_produit INT primary key,\n	nom VARCHAR(255),\n	prix INT\n);";
whetherReject_tDBRow_3 = false;
globalMap.put("tDBRow_3_QUERY",query_tDBRow_3);
try {
		stmt_tDBRow_3.execute(query_tDBRow_3);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_3 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_3_ERROR_MESSAGE", e.getMessage());
				
	}
	
	if(!whetherReject_tDBRow_3) {
		
	}
	
		commitCounter_tDBRow_3++;
		if(commitEvery_tDBRow_3 <= commitCounter_tDBRow_3) {
			
			conn_tDBRow_3.commit();
			
			commitCounter_tDBRow_3=0;
		}
		

 


	tos_count_tDBRow_3++;

/**
 * [tDBRow_3 main ] stop
 */
	
	/**
	 * [tDBRow_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_3";

	

 



/**
 * [tDBRow_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_3";

	

 



/**
 * [tDBRow_3 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_3 end ] start
	 */

	

	
	
	currentComponent="tDBRow_3";

	

	
        stmt_tDBRow_3.close();
        resourceMap.remove("stmt_tDBRow_3");
    resourceMap.put("statementClosed_tDBRow_3", true);
		if(commitEvery_tDBRow_3>commitCounter_tDBRow_3){

			
			conn_tDBRow_3.commit();
			
	
			commitCounter_tDBRow_3=0;
	
		}
			conn_tDBRow_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_3", true);
 

ok_Hash.put("tDBRow_3", true);
end_Hash.put("tDBRow_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tFileInputDelimited_4Process(globalMap);



/**
 * [tDBRow_3 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_3 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_3";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_3") == null) {
            java.sql.Statement stmtToClose_tDBRow_3 = null;
            if ((stmtToClose_tDBRow_3 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_3")) != null) {
                stmtToClose_tDBRow_3.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_3") == null){
            java.sql.Connection ctn_tDBRow_3 = null;
            if((ctn_tDBRow_3 = (java.sql.Connection)resourceMap.get("conn_tDBRow_3")) != null){
                try {
                    ctn_tDBRow_3.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_3) {
                    String errorMessage_tDBRow_3 = "failed to close the connection in tDBRow_3 :" + sqlEx_tDBRow_3.getMessage();
                    System.err.println(errorMessage_tDBRow_3);
                }
            }
        }
    }
 



/**
 * [tDBRow_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_3_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_produit;

				public int getId_produit () {
					return this.id_produit;
				}
				
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public Integer prix;

				public Integer getPrix () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.id_produit != other.id_produit)
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.id_produit = this.id_produit;
	            other.nom = this.nom;
	            other.prix = this.prix;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.id_produit = this.id_produit;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_produit = dis.readInt();
					
					this.nom = readString(dis);
					
						this.prix = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_produit = dis.readInt();
					
					this.nom = readString(dis);
					
						this.prix = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_produit);
					
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.prix,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_produit);
					
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.prix,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_produit="+String.valueOf(id_produit));
		sb.append(",nom="+nom);
		sb.append(",prix="+String.valueOf(prix));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_produit, other.id_produit);
						if(returnValue != 0) {
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
public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





        int updateKeyCount_tDBOutput_2 = 1;
        if(updateKeyCount_tDBOutput_2 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_2 == 3 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

String tableName_tDBOutput_2 = "produits";
boolean whetherReject_tDBOutput_2 = false;

java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
long date_tDBOutput_2;

java.sql.Connection conn_tDBOutput_2 = null;
		
        String properties_tDBOutput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
            properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBOutput_2;
		
		String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_2 = "root";
		

		 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:6Lr9/LtpaRpQlsIgz7kGKh6hJg2Di0w62ZTUE4Va2rlwCbiCwbk=");

		String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
		java.lang.Class.forName(driverClass_tDBOutput_2);
		
		conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2, dbPwd_tDBOutput_2);
		
	
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;

int count_tDBOutput_2=0;
    	
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement("SELECT COUNT(1) FROM `" + "produits" + "` WHERE `id_produit` = ?");
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    String insert_tDBOutput_2 = "INSERT INTO `" + "produits" + "` (`id_produit`,`nom`,`prix`) VALUES (?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmtInsert_tDBOutput_2", pstmtInsert_tDBOutput_2);
	    String update_tDBOutput_2 = "UPDATE `" + "produits" + "` SET `nom` = ?,`prix` = ? WHERE `id_produit` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
	    resourceMap.put("pstmtUpdate_tDBOutput_2", pstmtUpdate_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_4", false);
		start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_4";

	
		int tos_count_tFileInputDelimited_4 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_4 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_4 = null;
				int limit_tFileInputDelimited_4 = -1;
				try{
					
						Object filename_tFileInputDelimited_4 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/produits.csv";
						if(filename_tFileInputDelimited_4 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_4 = 0, random_value_tFileInputDelimited_4 = -1;
			if(footer_value_tFileInputDelimited_4 >0 || random_value_tFileInputDelimited_4 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_4 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/produits.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_4
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_4!=null && fid_tFileInputDelimited_4.nextRecord()) {
						rowstate_tFileInputDelimited_4.reset();
						
			    						row2 = null;			
												
									boolean whetherReject_tFileInputDelimited_4 = false;
									row2 = new row2Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_4 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_4 = 0;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row2.id_produit = ParserUtils.parseTo_int(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row2", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								rowstate_tFileInputDelimited_4.setException(new RuntimeException("Value is empty for column : 'id_produit' in 'row2' connection, value is invalid or this column should be nullable or have a default value."));
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 1;
					
							row2.nom = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 2;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row2.prix = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"prix", "row2", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row2.prix = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_4.getException()!=null) {
											throw rowstate_tFileInputDelimited_4.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_4 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row2 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_4 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 


	tos_count_tFileInputDelimited_4++;

/**
 * [tFileInputDelimited_4 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    pstmt_tDBOutput_2.setInt(1, row2.id_produit);

            int checkCount_tDBOutput_2 = -1;
            try (java.sql.ResultSet rs_tDBOutput_2 = pstmt_tDBOutput_2.executeQuery()) {
                while(rs_tDBOutput_2.next()) {
                    checkCount_tDBOutput_2 = rs_tDBOutput_2.getInt(1);
                }
            }
            if(checkCount_tDBOutput_2 > 0) {
                        if(row2.nom == null) {
pstmtUpdate_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(1, row2.nom);
}

                        if(row2.prix == null) {
pstmtUpdate_tDBOutput_2.setNull(2, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_2.setInt(2, row2.prix);
}

                        pstmtUpdate_tDBOutput_2.setInt(3 + count_tDBOutput_2, row2.id_produit);

                try {
                    int processedCount_tDBOutput_2 = pstmtUpdate_tDBOutput_2.executeUpdate();
                    updatedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_2 = true;
                        nb_line_tDBOutput_2++;
                            System.err.print(e.getMessage());
                }
            } else {
                        pstmtInsert_tDBOutput_2.setInt(1, row2.id_produit);

                        if(row2.nom == null) {
pstmtInsert_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(2, row2.nom);
}

                        if(row2.prix == null) {
pstmtInsert_tDBOutput_2.setNull(3, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_2.setInt(3, row2.prix);
}

                try {
                    int processedCount_tDBOutput_2 = pstmtInsert_tDBOutput_2.executeUpdate();
                    insertedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_2 = true;
                        nb_line_tDBOutput_2++;
                            System.err.print(e.getMessage());
                }
            }
                commitCounter_tDBOutput_2++;

                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                        rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;

                }


 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tFileInputDelimited_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/produits.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_4!=null){
                		fid_tFileInputDelimited_4.close();
                	}
                }
                if(fid_tFileInputDelimited_4!=null){
                	globalMap.put("tFileInputDelimited_4_NB_LINE", fid_tFileInputDelimited_4.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_4", true);
end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());




/**
 * [tFileInputDelimited_4 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



        if(pstmtUpdate_tDBOutput_2 != null){
            pstmtUpdate_tDBOutput_2.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_2");
        }
        if(pstmtInsert_tDBOutput_2 != null){
            pstmtInsert_tDBOutput_2.close();
            resourceMap.remove("pstmtInsert_tDBOutput_2");
        }
        if(pstmt_tDBOutput_2 != null) {
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);
    	if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
    		
    	}
    	conn_tDBOutput_2.commit();
    	if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
    		
			rowsToCommitCount_tDBOutput_2 = 0;
    	}
		commitCounter_tDBOutput_2 = 0;
    	
		
    	conn_tDBOutput_2 .close();
    	
    	resourceMap.put("finish_tDBOutput_2", true);
    	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_4 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_2 = null;
                if ((pstmtUpdateToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_2")) != null) {
                    pstmtUpdateToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_2 = null;
                if ((pstmtInsertToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_2")) != null) {
                    pstmtInsertToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                    ctn_tDBOutput_2.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_4_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBRow_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_4", false);
		start_Hash.put("tDBRow_4", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_4";

	
		int tos_count_tDBRow_4 = 0;
		

	java.sql.Connection conn_tDBRow_4 = null;
	String query_tDBRow_4 = "";
	boolean whetherReject_tDBRow_4 = false;
			String driverClass_tDBRow_4 = "com.mysql.cj.jdbc.Driver";
		    java.lang.Class jdbcclazz_tDBRow_4 = java.lang.Class.forName(driverClass_tDBRow_4);
		
        String properties_tDBRow_4 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBRow_4 == null || properties_tDBRow_4.trim().length() == 0) {
            properties_tDBRow_4 = "allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBRow_4.contains("allowLoadLocalInfile=")) {
                properties_tDBRow_4 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBRow_4 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBRow_4;
					String dbUser_tDBRow_4 = "root";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:6RN+dhQi3yDeARux7MIHkS9YZK4aoDO9pDGHQiz7iTj4z6RMs0I=");
        		   	
        	        String dbPwd_tDBRow_4 = decryptedPassword_tDBRow_4;
	        
					
			conn_tDBRow_4 = java.sql.DriverManager.getConnection(url_tDBRow_4,dbUser_tDBRow_4,dbPwd_tDBRow_4);
		
        resourceMap.put("conn_tDBRow_4", conn_tDBRow_4);
					if(conn_tDBRow_4.getAutoCommit()) {
						
				conn_tDBRow_4.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_4 = 10000;
					int commitCounter_tDBRow_4 = 0;
				
        java.sql.Statement stmt_tDBRow_4 = conn_tDBRow_4.createStatement();
        resourceMap.put("stmt_tDBRow_4", stmt_tDBRow_4);

 



/**
 * [tDBRow_4 begin ] stop
 */
	
	/**
	 * [tDBRow_4 main ] start
	 */

	

	
	
	currentComponent="tDBRow_4";

	

query_tDBRow_4 = "CREATE TABLE IF NOT EXISTS clients (\n	id_client INT primary key,\n	nom VARCHAR(255),\n	ville VARCHAR(255),\n	secteur V"
+"ARCHAR(255)\n);";
whetherReject_tDBRow_4 = false;
globalMap.put("tDBRow_4_QUERY",query_tDBRow_4);
try {
		stmt_tDBRow_4.execute(query_tDBRow_4);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_4 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_4_ERROR_MESSAGE", e.getMessage());
				
	}
	
	if(!whetherReject_tDBRow_4) {
		
	}
	
		commitCounter_tDBRow_4++;
		if(commitEvery_tDBRow_4 <= commitCounter_tDBRow_4) {
			
			conn_tDBRow_4.commit();
			
			commitCounter_tDBRow_4=0;
		}
		

 


	tos_count_tDBRow_4++;

/**
 * [tDBRow_4 main ] stop
 */
	
	/**
	 * [tDBRow_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_4";

	

 



/**
 * [tDBRow_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_4";

	

 



/**
 * [tDBRow_4 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_4 end ] start
	 */

	

	
	
	currentComponent="tDBRow_4";

	

	
        stmt_tDBRow_4.close();
        resourceMap.remove("stmt_tDBRow_4");
    resourceMap.put("statementClosed_tDBRow_4", true);
		if(commitEvery_tDBRow_4>commitCounter_tDBRow_4){

			
			conn_tDBRow_4.commit();
			
	
			commitCounter_tDBRow_4=0;
	
		}
			conn_tDBRow_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_4", true);
 

ok_Hash.put("tDBRow_4", true);
end_Hash.put("tDBRow_4", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tFileInputDelimited_3Process(globalMap);



/**
 * [tDBRow_4 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_4 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_4";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_4") == null) {
            java.sql.Statement stmtToClose_tDBRow_4 = null;
            if ((stmtToClose_tDBRow_4 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_4")) != null) {
                stmtToClose_tDBRow_4.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_4") == null){
            java.sql.Connection ctn_tDBRow_4 = null;
            if((ctn_tDBRow_4 = (java.sql.Connection)resourceMap.get("conn_tDBRow_4")) != null){
                try {
                    ctn_tDBRow_4.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_4) {
                    String errorMessage_tDBRow_4 = "failed to close the connection in tDBRow_4 :" + sqlEx_tDBRow_4.getMessage();
                    System.err.println(errorMessage_tDBRow_4);
                }
            }
        }
    }
 



/**
 * [tDBRow_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_4_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_client;

				public int getId_client () {
					return this.id_client;
				}
				
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String ville;

				public String getVille () {
					return this.ville;
				}
				
			    public String secteur;

				public String getSecteur () {
					return this.secteur;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.id_client;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row1Struct other = (row1Struct) obj;
		
						if (this.id_client != other.id_client)
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.id_client = this.id_client;
	            other.nom = this.nom;
	            other.ville = this.ville;
	            other.secteur = this.secteur;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.id_client = this.id_client;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_client = dis.readInt();
					
					this.nom = readString(dis);
					
					this.ville = readString(dis);
					
					this.secteur = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_ConnexionDB_et_creation_des_tables) {

        	try {

        		int length = 0;
		
			        this.id_client = dis.readInt();
					
					this.nom = readString(dis);
					
					this.ville = readString(dis);
					
					this.secteur = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_client);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.ville,dos);
					
					// String
				
						writeString(this.secteur,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id_client);
					
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.ville,dos);
					
					// String
				
						writeString(this.secteur,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_client="+String.valueOf(id_client));
		sb.append(",nom="+nom);
		sb.append(",ville="+ville);
		sb.append(",secteur="+secteur);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
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
public void tFileInputDelimited_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 4 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "clients";
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
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBOutput_1;
		
		String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_1 = "root";
		

		 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lJRYykT6nmx9DdhjZcdpCmM2Ue+oX18YpBHudT/IP7yyaPyLyT8=");

		String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
		java.lang.Class.forName(driverClass_tDBOutput_1);
		
		conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
		
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

int count_tDBOutput_1=0;
    	
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM `" + "clients" + "` WHERE `id_client` = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO `" + "clients" + "` (`id_client`,`nom`,`ville`,`secteur`) VALUES (?,?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE `" + "clients" + "` SET `nom` = ?,`ville` = ?,`secteur` = ? WHERE `id_client` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_3", false);
		start_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_3";

	
		int tos_count_tFileInputDelimited_3 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_3 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_3 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_3 = null;
				int limit_tFileInputDelimited_3 = -1;
				try{
					
						Object filename_tFileInputDelimited_3 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/clients.csv";
						if(filename_tFileInputDelimited_3 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
			if(footer_value_tFileInputDelimited_3 >0 || random_value_tFileInputDelimited_3 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/clients.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_3
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_3!=null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();
						
			    						row1 = null;			
												
									boolean whetherReject_tFileInputDelimited_3 = false;
									row1 = new row1Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_3 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_3 = 0;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row1.id_client = ParserUtils.parseTo_int(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row1", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								rowstate_tFileInputDelimited_3.setException(new RuntimeException("Value is empty for column : 'id_client' in 'row1' connection, value is invalid or this column should be nullable or have a default value."));
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 1;
					
							row1.nom = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 2;
					
							row1.ville = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 3;
					
							row1.secteur = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
				
										
										if(rowstate_tFileInputDelimited_3.getException()!=null) {
											throw rowstate_tFileInputDelimited_3.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_3 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row1 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_3 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 


	tos_count_tFileInputDelimited_3++;

/**
 * [tFileInputDelimited_3 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    pstmt_tDBOutput_1.setInt(1, row1.id_client);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(row1.nom == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, row1.nom);
}

                        if(row1.ville == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, row1.ville);
}

                        if(row1.secteur == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, row1.secteur);
}

                        pstmtUpdate_tDBOutput_1.setInt(4 + count_tDBOutput_1, row1.id_client);

                try {
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            } else {
                        pstmtInsert_tDBOutput_1.setInt(1, row1.id_client);

                        if(row1.nom == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, row1.nom);
}

                        if(row1.ville == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, row1.ville);
}

                        if(row1.secteur == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, row1.secteur);
}

                try {
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            }
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;

                }


 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputDelimited_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/clients.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_3!=null){
                		fid_tFileInputDelimited_3.close();
                	}
                }
                if(fid_tFileInputDelimited_3!=null){
                	globalMap.put("tFileInputDelimited_3_NB_LINE", fid_tFileInputDelimited_3.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_3", true);
end_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());




/**
 * [tFileInputDelimited_3 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
        if(pstmt_tDBOutput_1 != null) {
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
    	
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_3 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_5_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBRow_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_5", false);
		start_Hash.put("tDBRow_5", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_5";

	
		int tos_count_tDBRow_5 = 0;
		

	java.sql.Connection conn_tDBRow_5 = null;
	String query_tDBRow_5 = "";
	boolean whetherReject_tDBRow_5 = false;
			String driverClass_tDBRow_5 = "com.mysql.cj.jdbc.Driver";
		    java.lang.Class jdbcclazz_tDBRow_5 = java.lang.Class.forName(driverClass_tDBRow_5);
		
        String properties_tDBRow_5 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1&noDatetimeStringSync=true&serverTimezone=Europe/Paris";
        if (properties_tDBRow_5 == null || properties_tDBRow_5.trim().length() == 0) {
            properties_tDBRow_5 = "allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBRow_5.contains("allowLoadLocalInfile=")) {
                properties_tDBRow_5 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBRow_5 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "papier_et_besoins_db" + "?" + properties_tDBRow_5;
					String dbUser_tDBRow_5 = "root";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:ipHFG81oE2kNfBUQtOOAv4fRulDdsKQ/wSXe4V+SwGeS2lF/Eg4=");
        		   	
        	        String dbPwd_tDBRow_5 = decryptedPassword_tDBRow_5;
	        
					
			conn_tDBRow_5 = java.sql.DriverManager.getConnection(url_tDBRow_5,dbUser_tDBRow_5,dbPwd_tDBRow_5);
		
        resourceMap.put("conn_tDBRow_5", conn_tDBRow_5);
					if(conn_tDBRow_5.getAutoCommit()) {
						
				conn_tDBRow_5.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_5 = 10000;
					int commitCounter_tDBRow_5 = 0;
				
        java.sql.Statement stmt_tDBRow_5 = conn_tDBRow_5.createStatement();
        resourceMap.put("stmt_tDBRow_5", stmt_tDBRow_5);

 



/**
 * [tDBRow_5 begin ] stop
 */
	
	/**
	 * [tDBRow_5 main ] start
	 */

	

	
	
	currentComponent="tDBRow_5";

	

query_tDBRow_5 = "CREATE TABLE IF NOT EXISTS ventes (\n	id_vente VARCHAR(12) primary key,\n	id_agence INT,\n	id_vendeur INT,\n	id_client "
+"INT,\n	id_produit INT,\n	quantite INT,\n	somme INT,\n	date DATETIME,\n	FOREIGN KEY(id_agence) REFERENCES agences(id_agen"
+"ce)\n	ON DELETE CASCADE,\n	FOREIGN KEY(id_vendeur) REFERENCES employes(id_employe)\n	ON DELETE CASCADE,\n	FOREIGN KEY(id"
+"_client) REFERENCES clients(id_client)\n	ON DELETE CASCADE,\n	FOREIGN KEY(id_produit) REFERENCES produits(id_produit)\n	"
+"ON DELETE CASCADE\n);";
whetherReject_tDBRow_5 = false;
globalMap.put("tDBRow_5_QUERY",query_tDBRow_5);
try {
		stmt_tDBRow_5.execute(query_tDBRow_5);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_5 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_5_ERROR_MESSAGE", e.getMessage());
				
	}
	
		commitCounter_tDBRow_5++;
		if(commitEvery_tDBRow_5 <= commitCounter_tDBRow_5) {
			
			conn_tDBRow_5.commit();
			
			commitCounter_tDBRow_5=0;
		}
		

 


	tos_count_tDBRow_5++;

/**
 * [tDBRow_5 main ] stop
 */
	
	/**
	 * [tDBRow_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_5";

	

 



/**
 * [tDBRow_5 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_5";

	

 



/**
 * [tDBRow_5 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_5 end ] start
	 */

	

	
	
	currentComponent="tDBRow_5";

	

	
        stmt_tDBRow_5.close();
        resourceMap.remove("stmt_tDBRow_5");
    resourceMap.put("statementClosed_tDBRow_5", true);
		if(commitEvery_tDBRow_5>commitCounter_tDBRow_5){

			
			conn_tDBRow_5.commit();
			
	
			commitCounter_tDBRow_5=0;
	
		}
			conn_tDBRow_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_5", true);
 

ok_Hash.put("tDBRow_5", true);
end_Hash.put("tDBRow_5", System.currentTimeMillis());




/**
 * [tDBRow_5 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_5 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_5";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_5") == null) {
            java.sql.Statement stmtToClose_tDBRow_5 = null;
            if ((stmtToClose_tDBRow_5 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_5")) != null) {
                stmtToClose_tDBRow_5.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_5") == null){
            java.sql.Connection ctn_tDBRow_5 = null;
            if((ctn_tDBRow_5 = (java.sql.Connection)resourceMap.get("conn_tDBRow_5")) != null){
                try {
                    ctn_tDBRow_5.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_5) {
                    String errorMessage_tDBRow_5 = "failed to close the connection in tDBRow_5 :" + sqlEx_tDBRow_5.getMessage();
                    System.err.println(errorMessage_tDBRow_5);
                }
            }
        }
    }
 



/**
 * [tDBRow_5 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_5_SUBPROCESS_STATE", 1);
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
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final ConnexionDB_et_creation_des_tables ConnexionDB_et_creation_des_tablesClass = new ConnexionDB_et_creation_des_tables();

        int exitCode = ConnexionDB_et_creation_des_tablesClass.runJobInTOS(args);

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

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
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
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = ConnexionDB_et_creation_des_tables.class.getClassLoader().getResourceAsStream("sales_data_analysis/connexiondb_et_creation_des_tables_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = ConnexionDB_et_creation_des_tables.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
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
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
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


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBConnection_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBConnection_1) {
globalMap.put("tDBConnection_1_SUBPROCESS_STATE", -1);

e_tDBConnection_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : ConnexionDB_et_creation_des_tables");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






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
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
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
 *     204942 characters generated by Talend Open Studio for Big Data 
 *     on the 28 janvier 2025, 11:09:02 CET
 ************************************************************************************************/
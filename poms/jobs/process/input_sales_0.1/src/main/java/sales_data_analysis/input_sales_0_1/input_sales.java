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


package sales_data_analysis.input_sales_0_1;

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
 * Job: input_sales Purpose: <br>
 * Description: récupere et fait l'union des ventes de toutes les agences <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class input_sales implements TalendJob {

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
	private final String jobName = "input_sales";
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
				input_sales.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(input_sales.this, new Object[] { e , currentComponent, globalMap});
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

			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUnite_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tBufferOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row1Struct other = (row1Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row7Struct other = (row7Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row6Struct other = (row6Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row8Struct other = (row8Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row8Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row8Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row9Struct implements routines.system.IPersistableRow<row9Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row9Struct other = (row9Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row9Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row9Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row11Struct implements routines.system.IPersistableRow<row11Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row11Struct other = (row11Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row11Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row11Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row11Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row10Struct other = (row10Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row10Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row10Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row10Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row13Struct implements routines.system.IPersistableRow<row13Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row13Struct other = (row13Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row13Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row13Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row13Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row12Struct implements routines.system.IPersistableRow<row12Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row12Struct other = (row12Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row12Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row12Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row12Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row15Struct implements routines.system.IPersistableRow<row15Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row15Struct other = (row15Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row15Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row15Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row15Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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

public static class row14Struct implements routines.system.IPersistableRow<row14Struct> {
    final static byte[] commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales = new byte[0];
    static byte[] commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_vente;

				public String getId_vente () {
					return this.id_vente;
				}
				
			    public Integer id_vendeur;

				public Integer getId_vendeur () {
					return this.id_vendeur;
				}
				
			    public Integer id_client;

				public Integer getId_client () {
					return this.id_client;
				}
				
			    public Integer id_produit;

				public Integer getId_produit () {
					return this.id_produit;
				}
				
			    public Integer quantite;

				public Integer getQuantite () {
					return this.quantite;
				}
				
			    public java.util.Date date;

				public java.util.Date getDate () {
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
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row14Struct other = (row14Struct) obj;
		
						if (this.id_vente == null) {
							if (other.id_vente != null)
								return false;
						
						} else if (!this.id_vente.equals(other.id_vente))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row14Struct other) {

		other.id_vente = this.id_vente;
	            other.id_vendeur = this.id_vendeur;
	            other.id_client = this.id_client;
	            other.id_produit = this.id_produit;
	            other.quantite = this.quantite;
	            other.date = this.date;
	            
	}

	public void copyKeysDataTo(row14Struct other) {

		other.id_vente = this.id_vente;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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
			if(length > commonByteArray_SALES_DATA_ANALYSIS_input_sales.length) {
				if(length < 1024 && commonByteArray_SALES_DATA_ANALYSIS_input_sales.length == 0) {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[1024];
				} else {
   					commonByteArray_SALES_DATA_ANALYSIS_input_sales = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length);
			strReturn = new String(commonByteArray_SALES_DATA_ANALYSIS_input_sales, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
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
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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

		synchronized(commonByteArrayLock_SALES_DATA_ANALYSIS_input_sales) {

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
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_vente,dos);
					
					// Integer
				
						writeInteger(this.id_vendeur,dos);
					
					// Integer
				
						writeInteger(this.id_client,dos);
					
					// Integer
				
						writeInteger(this.id_produit,dos);
					
					// Integer
				
						writeInteger(this.quantite,dos);
					
					// java.util.Date
				
						writeDate(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_vente="+id_vente);
		sb.append(",id_vendeur="+String.valueOf(id_vendeur));
		sb.append(",id_client="+String.valueOf(id_client));
		sb.append(",id_produit="+String.valueOf(id_produit));
		sb.append(",quantite="+String.valueOf(quantite));
		sb.append(",date="+String.valueOf(date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row14Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_vente, other.id_vente);
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



		row7Struct row7 = new row7Struct();

		row6Struct row6 = new row6Struct();

		row8Struct row8 = new row8Struct();

		row9Struct row9 = new row9Struct();

		row11Struct row11 = new row11Struct();

		row10Struct row10 = new row10Struct();

		row13Struct row13 = new row13Struct();

		row12Struct row12 = new row12Struct();

		row15Struct row15 = new row15Struct();

		row14Struct row14 = new row14Struct();

			row1Struct row1 = new row1Struct();




	
	/**
	 * [tBufferOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tBufferOutput_1", false);
		start_Hash.put("tBufferOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tBufferOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tBufferOutput_1 = 0;
		

 



/**
 * [tBufferOutput_1 begin ] stop
 */



	
	/**
	 * [tUnite_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUnite_1", false);
		start_Hash.put("tUnite_1", System.currentTimeMillis());
		
	
	currentComponent="tUnite_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11","row10","row14","row7","row9","row6","row12","row13","row15","row8");
					}
				
		int tos_count_tUnite_1 = 0;
		

int nb_line_tUnite_1 = 0;

 



/**
 * [tUnite_1 begin ] stop
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
					
						Object filename_tFileInputDelimited_1 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Robin_sales.csv";
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Robin_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_1
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_1!=null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();
						
			    						row7 = null;			
												
									boolean whetherReject_tFileInputDelimited_1 = false;
									row7 = new row7Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_1 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_1 = 0;
					
							row7.id_vente = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row7.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row7", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row7.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row7.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row7", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row7.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 3;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row7.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row7", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row7.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 4;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row7.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row7", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row7.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_1 = 5;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    									row7.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row7", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row7.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_1.getException()!=null) {
											throw rowstate_tFileInputDelimited_1.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_1 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row7 = null;
			                				
										
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
// Start of branch "row7"
if(row7 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row7"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row7.id_vente;								
			row1.id_vendeur = row7.id_vendeur;								
			row1.id_client = row7.id_client;								
			row1.id_produit = row7.id_produit;								
			row1.quantite = row7.quantite;								
			row1.date = row7.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row7"




	
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
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Robin_sales.csv") instanceof java.io.InputStream)){
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
					
						Object filename_tFileInputDelimited_2 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Leleunec_sales.csv";
						if(filename_tFileInputDelimited_2 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
			if(footer_value_tFileInputDelimited_2 >0 || random_value_tFileInputDelimited_2 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Leleunec_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_2
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_2!=null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();
						
			    						row6 = null;			
												
									boolean whetherReject_tFileInputDelimited_2 = false;
									row6 = new row6Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_2 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_2 = 0;
					
							row6.id_vente = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 1;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row6.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row6", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row6.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 2;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row6.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row6", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row6.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 3;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row6.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row6", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row6.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 4;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    								row6.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row6", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row6.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_2 = 5;
					
						temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						if(temp.length() > 0) {
							
								try {
								
    									row6.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_2) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row6", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}
    							
						} else {						
							
								
									row6.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_2.getException()!=null) {
											throw rowstate_tFileInputDelimited_2.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_2 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row6 = null;
			                				
										
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
// Start of branch "row6"
if(row6 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row6"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row6.id_vente;								
			row1.id_vendeur = row6.id_vendeur;								
			row1.id_client = row6.id_client;								
			row1.id_produit = row6.id_produit;								
			row1.quantite = row6.quantite;								
			row1.date = row6.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row6"




	
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
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Leleunec_sales.csv") instanceof java.io.InputStream)){
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
					
						Object filename_tFileInputDelimited_3 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Marques-les-Bains_sales.csv";
						if(filename_tFileInputDelimited_3 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
			if(footer_value_tFileInputDelimited_3 >0 || random_value_tFileInputDelimited_3 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Marques-les-Bains_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_3
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_3!=null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();
						
			    						row8 = null;			
												
									boolean whetherReject_tFileInputDelimited_3 = false;
									row8 = new row8Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_3 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_3 = 0;
					
							row8.id_vente = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 1;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row8.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row8", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row8.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 2;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row8.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row8", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row8.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 3;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row8.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row8", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row8.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 4;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    								row8.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row8", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row8.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_3 = 5;
					
						temp = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						if(temp.length() > 0) {
							
								try {
								
    									row8.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_3) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",ex_tFileInputDelimited_3.getMessage());
									rowstate_tFileInputDelimited_3.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row8", temp, ex_tFileInputDelimited_3), ex_tFileInputDelimited_3));
								}
    							
						} else {						
							
								
									row8.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_3.getException()!=null) {
											throw rowstate_tFileInputDelimited_3.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_3 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row8 = null;
			                				
										
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
// Start of branch "row8"
if(row8 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row8"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row8.id_vente;								
			row1.id_vendeur = row8.id_vendeur;								
			row1.id_client = row8.id_client;								
			row1.id_produit = row8.id_produit;								
			row1.quantite = row8.quantite;								
			row1.date = row8.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row8"




	
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
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Marques-les-Bains_sales.csv") instanceof java.io.InputStream)){
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
					
						Object filename_tFileInputDelimited_4 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Grenier_sales.csv";
						if(filename_tFileInputDelimited_4 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_4 = 0, random_value_tFileInputDelimited_4 = -1;
			if(footer_value_tFileInputDelimited_4 >0 || random_value_tFileInputDelimited_4 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_4 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Grenier_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_4
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_4!=null && fid_tFileInputDelimited_4.nextRecord()) {
						rowstate_tFileInputDelimited_4.reset();
						
			    						row9 = null;			
												
									boolean whetherReject_tFileInputDelimited_4 = false;
									row9 = new row9Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_4 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_4 = 0;
					
							row9.id_vente = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 1;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row9.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row9", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row9.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 2;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row9.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row9", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row9.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 3;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row9.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row9", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row9.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 4;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    								row9.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row9", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row9.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_4 = 5;
					
						temp = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						if(temp.length() > 0) {
							
								try {
								
    									row9.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_4) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",ex_tFileInputDelimited_4.getMessage());
									rowstate_tFileInputDelimited_4.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row9", temp, ex_tFileInputDelimited_4), ex_tFileInputDelimited_4));
								}
    							
						} else {						
							
								
									row9.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_4.getException()!=null) {
											throw rowstate_tFileInputDelimited_4.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_4 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row9 = null;
			                				
										
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
// Start of branch "row9"
if(row9 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row9"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row9.id_vente;								
			row1.id_vendeur = row9.id_vendeur;								
			row1.id_client = row9.id_client;								
			row1.id_produit = row9.id_produit;								
			row1.quantite = row9.quantite;								
			row1.date = row9.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row9"




	
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
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Grenier_sales.csv") instanceof java.io.InputStream)){
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
	 * [tFileInputDelimited_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_5", false);
		start_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_5";

	
		int tos_count_tFileInputDelimited_5 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_5 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_5 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_5 = null;
				int limit_tFileInputDelimited_5 = -1;
				try{
					
						Object filename_tFileInputDelimited_5 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Delorme_sales.csv";
						if(filename_tFileInputDelimited_5 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_5 = 0, random_value_tFileInputDelimited_5 = -1;
			if(footer_value_tFileInputDelimited_5 >0 || random_value_tFileInputDelimited_5 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_5 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Delorme_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_5
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_5!=null && fid_tFileInputDelimited_5.nextRecord()) {
						rowstate_tFileInputDelimited_5.reset();
						
			    						row11 = null;			
												
									boolean whetherReject_tFileInputDelimited_5 = false;
									row11 = new row11Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_5 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_5 = 0;
					
							row11.id_vente = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 1;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row11.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row11", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row11.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 2;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row11.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row11", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row11.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 3;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row11.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row11", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row11.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 4;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    								row11.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row11", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row11.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_5 = 5;
					
						temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						if(temp.length() > 0) {
							
								try {
								
    									row11.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_5) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row11", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}
    							
						} else {						
							
								
									row11.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_5.getException()!=null) {
											throw rowstate_tFileInputDelimited_5.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_5 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row11 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_5 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 


	tos_count_tFileInputDelimited_5++;

/**
 * [tFileInputDelimited_5 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_begin ] stop
 */
// Start of branch "row11"
if(row11 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row11"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row11.id_vente;								
			row1.id_vendeur = row11.id_vendeur;								
			row1.id_client = row11.id_client;								
			row1.id_produit = row11.id_produit;								
			row1.quantite = row11.quantite;								
			row1.date = row11.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row11"




	
	/**
	 * [tFileInputDelimited_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Delorme_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_5!=null){
                		fid_tFileInputDelimited_5.close();
                	}
                }
                if(fid_tFileInputDelimited_5!=null){
                	globalMap.put("tFileInputDelimited_5_NB_LINE", fid_tFileInputDelimited_5.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_5", true);
end_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());




/**
 * [tFileInputDelimited_5 end ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_6", false);
		start_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_6";

	
		int tos_count_tFileInputDelimited_6 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_6 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_6 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_6 = null;
				int limit_tFileInputDelimited_6 = -1;
				try{
					
						Object filename_tFileInputDelimited_6 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Guichard_sales.csv";
						if(filename_tFileInputDelimited_6 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_6 = 0, random_value_tFileInputDelimited_6 = -1;
			if(footer_value_tFileInputDelimited_6 >0 || random_value_tFileInputDelimited_6 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_6 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Guichard_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_6
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_6!=null && fid_tFileInputDelimited_6.nextRecord()) {
						rowstate_tFileInputDelimited_6.reset();
						
			    						row10 = null;			
												
									boolean whetherReject_tFileInputDelimited_6 = false;
									row10 = new row10Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_6 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_6 = 0;
					
							row10.id_vente = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 1;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row10.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row10", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row10.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 2;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row10.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row10", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row10.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 3;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row10.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row10", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row10.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 4;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    								row10.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row10", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row10.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_6 = 5;
					
						temp = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						if(temp.length() > 0) {
							
								try {
								
    									row10.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_6) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",ex_tFileInputDelimited_6.getMessage());
									rowstate_tFileInputDelimited_6.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row10", temp, ex_tFileInputDelimited_6), ex_tFileInputDelimited_6));
								}
    							
						} else {						
							
								
									row10.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_6.getException()!=null) {
											throw rowstate_tFileInputDelimited_6.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_6 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row10 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_6 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 


	tos_count_tFileInputDelimited_6++;

/**
 * [tFileInputDelimited_6 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_begin ] stop
 */
// Start of branch "row10"
if(row10 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row10"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row10.id_vente;								
			row1.id_vendeur = row10.id_vendeur;								
			row1.id_client = row10.id_client;								
			row1.id_produit = row10.id_produit;								
			row1.quantite = row10.quantite;								
			row1.date = row10.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row10"




	
	/**
	 * [tFileInputDelimited_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Guichard_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_6!=null){
                		fid_tFileInputDelimited_6.close();
                	}
                }
                if(fid_tFileInputDelimited_6!=null){
                	globalMap.put("tFileInputDelimited_6_NB_LINE", fid_tFileInputDelimited_6.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_6", true);
end_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());




/**
 * [tFileInputDelimited_6 end ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_7", false);
		start_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_7";

	
		int tos_count_tFileInputDelimited_7 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_7 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_7 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_7 = null;
				int limit_tFileInputDelimited_7 = -1;
				try{
					
						Object filename_tFileInputDelimited_7 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Jacquet-les-Bains_sales.csv";
						if(filename_tFileInputDelimited_7 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_7 = 0, random_value_tFileInputDelimited_7 = -1;
			if(footer_value_tFileInputDelimited_7 >0 || random_value_tFileInputDelimited_7 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_7 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Jacquet-les-Bains_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_7
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_7!=null && fid_tFileInputDelimited_7.nextRecord()) {
						rowstate_tFileInputDelimited_7.reset();
						
			    						row13 = null;			
												
									boolean whetherReject_tFileInputDelimited_7 = false;
									row13 = new row13Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_7 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_7 = 0;
					
							row13.id_vente = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						
				
					columnIndexWithD_tFileInputDelimited_7 = 1;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 2;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 3;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 4;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    								row13.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_7 = 5;
					
						temp = fid_tFileInputDelimited_7.get(columnIndexWithD_tFileInputDelimited_7);
						if(temp.length() > 0) {
							
								try {
								
    									row13.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_7) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",ex_tFileInputDelimited_7.getMessage());
									rowstate_tFileInputDelimited_7.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row13", temp, ex_tFileInputDelimited_7), ex_tFileInputDelimited_7));
								}
    							
						} else {						
							
								
									row13.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_7.getException()!=null) {
											throw rowstate_tFileInputDelimited_7.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_7 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row13 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_7 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 


	tos_count_tFileInputDelimited_7++;

/**
 * [tFileInputDelimited_7 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 process_data_begin ] stop
 */
// Start of branch "row13"
if(row13 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row13"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row13.id_vente;								
			row1.id_vendeur = row13.id_vendeur;								
			row1.id_client = row13.id_client;								
			row1.id_produit = row13.id_produit;								
			row1.quantite = row13.quantite;								
			row1.date = row13.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row13"




	
	/**
	 * [tFileInputDelimited_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Jacquet-les-Bains_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_7!=null){
                		fid_tFileInputDelimited_7.close();
                	}
                }
                if(fid_tFileInputDelimited_7!=null){
                	globalMap.put("tFileInputDelimited_7_NB_LINE", fid_tFileInputDelimited_7.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_7", true);
end_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());




/**
 * [tFileInputDelimited_7 end ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_8", false);
		start_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_8";

	
		int tos_count_tFileInputDelimited_8 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_8 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_8 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_8 = null;
				int limit_tFileInputDelimited_8 = -1;
				try{
					
						Object filename_tFileInputDelimited_8 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Diallonec_sales.csv";
						if(filename_tFileInputDelimited_8 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_8 = 0, random_value_tFileInputDelimited_8 = -1;
			if(footer_value_tFileInputDelimited_8 >0 || random_value_tFileInputDelimited_8 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_8 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Diallonec_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_8
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_8!=null && fid_tFileInputDelimited_8.nextRecord()) {
						rowstate_tFileInputDelimited_8.reset();
						
			    						row12 = null;			
												
									boolean whetherReject_tFileInputDelimited_8 = false;
									row12 = new row12Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_8 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_8 = 0;
					
							row12.id_vente = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						
				
					columnIndexWithD_tFileInputDelimited_8 = 1;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row12.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row12", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row12.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 2;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row12.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row12", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row12.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 3;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row12.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row12", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row12.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 4;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    								row12.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row12", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row12.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_8 = 5;
					
						temp = fid_tFileInputDelimited_8.get(columnIndexWithD_tFileInputDelimited_8);
						if(temp.length() > 0) {
							
								try {
								
    									row12.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_8) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",ex_tFileInputDelimited_8.getMessage());
									rowstate_tFileInputDelimited_8.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row12", temp, ex_tFileInputDelimited_8), ex_tFileInputDelimited_8));
								}
    							
						} else {						
							
								
									row12.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_8.getException()!=null) {
											throw rowstate_tFileInputDelimited_8.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_8 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row12 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_8 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 


	tos_count_tFileInputDelimited_8++;

/**
 * [tFileInputDelimited_8 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 process_data_begin ] stop
 */
// Start of branch "row12"
if(row12 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row12"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row12.id_vente;								
			row1.id_vendeur = row12.id_vendeur;								
			row1.id_client = row12.id_client;								
			row1.id_produit = row12.id_produit;								
			row1.quantite = row12.quantite;								
			row1.date = row12.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row12"




	
	/**
	 * [tFileInputDelimited_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Diallonec_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_8!=null){
                		fid_tFileInputDelimited_8.close();
                	}
                }
                if(fid_tFileInputDelimited_8!=null){
                	globalMap.put("tFileInputDelimited_8_NB_LINE", fid_tFileInputDelimited_8.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_8", true);
end_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());




/**
 * [tFileInputDelimited_8 end ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_9", false);
		start_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_9";

	
		int tos_count_tFileInputDelimited_9 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_9 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_9 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_9 = null;
				int limit_tFileInputDelimited_9 = -1;
				try{
					
						Object filename_tFileInputDelimited_9 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Gosselin_sales.csv";
						if(filename_tFileInputDelimited_9 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_9 = 0, random_value_tFileInputDelimited_9 = -1;
			if(footer_value_tFileInputDelimited_9 >0 || random_value_tFileInputDelimited_9 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_9 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Gosselin_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_9
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_9!=null && fid_tFileInputDelimited_9.nextRecord()) {
						rowstate_tFileInputDelimited_9.reset();
						
			    						row15 = null;			
												
									boolean whetherReject_tFileInputDelimited_9 = false;
									row15 = new row15Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_9 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_9 = 0;
					
							row15.id_vente = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						
				
					columnIndexWithD_tFileInputDelimited_9 = 1;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row15.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row15", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row15.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 2;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row15.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row15", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row15.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 3;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row15.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row15", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row15.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 4;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    								row15.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row15", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row15.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_9 = 5;
					
						temp = fid_tFileInputDelimited_9.get(columnIndexWithD_tFileInputDelimited_9);
						if(temp.length() > 0) {
							
								try {
								
    									row15.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_9) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",ex_tFileInputDelimited_9.getMessage());
									rowstate_tFileInputDelimited_9.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row15", temp, ex_tFileInputDelimited_9), ex_tFileInputDelimited_9));
								}
    							
						} else {						
							
								
									row15.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_9.getException()!=null) {
											throw rowstate_tFileInputDelimited_9.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_9 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row15 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_9 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 


	tos_count_tFileInputDelimited_9++;

/**
 * [tFileInputDelimited_9 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 process_data_begin ] stop
 */
// Start of branch "row15"
if(row15 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row15"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row15.id_vente;								
			row1.id_vendeur = row15.id_vendeur;								
			row1.id_client = row15.id_client;								
			row1.id_produit = row15.id_produit;								
			row1.quantite = row15.quantite;								
			row1.date = row15.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row15"




	
	/**
	 * [tFileInputDelimited_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Gosselin_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_9!=null){
                		fid_tFileInputDelimited_9.close();
                	}
                }
                if(fid_tFileInputDelimited_9!=null){
                	globalMap.put("tFileInputDelimited_9_NB_LINE", fid_tFileInputDelimited_9.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_9", true);
end_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());




/**
 * [tFileInputDelimited_9 end ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_10", false);
		start_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_10";

	
		int tos_count_tFileInputDelimited_10 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_10 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_10 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_10 = null;
				int limit_tFileInputDelimited_10 = -1;
				try{
					
						Object filename_tFileInputDelimited_10 = "C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Toussaint-sur-Texier_sales.csv";
						if(filename_tFileInputDelimited_10 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_10 = 0, random_value_tFileInputDelimited_10 = -1;
			if(footer_value_tFileInputDelimited_10 >0 || random_value_tFileInputDelimited_10 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_10 = new org.talend.fileprocess.FileInputDelimited("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Toussaint-sur-Texier_sales.csv", "ISO-8859-15",";","\n",true,1,0,
									limit_tFileInputDelimited_10
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_10!=null && fid_tFileInputDelimited_10.nextRecord()) {
						rowstate_tFileInputDelimited_10.reset();
						
			    						row14 = null;			
												
									boolean whetherReject_tFileInputDelimited_10 = false;
									row14 = new row14Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_10 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_10 = 0;
					
							row14.id_vente = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						
				
					columnIndexWithD_tFileInputDelimited_10 = 1;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row14.id_vendeur = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_vendeur", "row14", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row14.id_vendeur = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 2;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row14.id_client = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_client", "row14", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row14.id_client = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 3;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row14.id_produit = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"id_produit", "row14", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row14.id_produit = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 4;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    								row14.quantite = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"quantite", "row14", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row14.quantite = null;
								
							
						}
					
				
					columnIndexWithD_tFileInputDelimited_10 = 5;
					
						temp = fid_tFileInputDelimited_10.get(columnIndexWithD_tFileInputDelimited_10);
						if(temp.length() > 0) {
							
								try {
								
    									row14.date = ParserUtils.parseTo_Date(temp, "dd/MM/yyyy");
    								
    							} catch(java.lang.Exception ex_tFileInputDelimited_10) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",ex_tFileInputDelimited_10.getMessage());
									rowstate_tFileInputDelimited_10.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"date", "row14", temp, ex_tFileInputDelimited_10), ex_tFileInputDelimited_10));
								}
    							
						} else {						
							
								
									row14.date = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_10.getException()!=null) {
											throw rowstate_tFileInputDelimited_10.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_10 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row14 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_10 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 


	tos_count_tFileInputDelimited_10++;

/**
 * [tFileInputDelimited_10 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 process_data_begin ] stop
 */
// Start of branch "row14"
if(row14 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"row14"
									
							);
						}
						
//////////
 

// for output
			row1 = new row1Struct();
								
			row1.id_vente = row14.id_vente;								
			row1.id_vendeur = row14.id_vendeur;								
			row1.id_client = row14.id_client;								
			row1.id_produit = row14.id_produit;								
			row1.quantite = row14.quantite;								
			row1.date = row14.date;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","","","","","",};		
	    if(row1.id_vente != null){
	        
	            row_tBufferOutput_1[0] = row1.id_vente;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row1.id_vendeur != null){
	        
	            row_tBufferOutput_1[1] = String.valueOf(row1.id_vendeur);
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	    if(row1.id_client != null){
	        
	            row_tBufferOutput_1[2] = String.valueOf(row1.id_client);
	                        			    
	    }else{
	    	row_tBufferOutput_1[2] = null;
	    }
	    if(row1.id_produit != null){
	        
	            row_tBufferOutput_1[3] = String.valueOf(row1.id_produit);
	                        			    
	    }else{
	    	row_tBufferOutput_1[3] = null;
	    }
	    if(row1.quantite != null){
	        
	            row_tBufferOutput_1[4] = String.valueOf(row1.quantite);
	                        			    
	    }else{
	    	row_tBufferOutput_1[4] = null;
	    }
	    if(row1.date != null){
	        
	            row_tBufferOutput_1[5] = FormatterUtils.format_Date(row1.date, "dd/MM/yyyy");
	                        			    
	    }else{
	    	row_tBufferOutput_1[5] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "row14"




	
	/**
	 * [tFileInputDelimited_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	



            }
            }finally{
                if(!((Object)("C:/Users/samra/Downloads/TOS_BD-20211109_1610-V8.0.1/TOS_BD-20211109_1610-V8.0.1/workspace/SALES_DATA_ANALYSIS/Source/Toussaint-sur-Texier_sales.csv") instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_10!=null){
                		fid_tFileInputDelimited_10.close();
                	}
                }
                if(fid_tFileInputDelimited_10!=null){
                	globalMap.put("tFileInputDelimited_10_NB_LINE", fid_tFileInputDelimited_10.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_10", true);
end_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());




/**
 * [tFileInputDelimited_10 end ] stop
 */
	
	/**
	 * [tUnite_1 end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11","row10","row14","row7","row9","row6","row12","row13","row15","row8");
			  	}
			  	
 

ok_Hash.put("tUnite_1", true);
end_Hash.put("tUnite_1", System.currentTimeMillis());




/**
 * [tUnite_1 end ] stop
 */

	
	/**
	 * [tBufferOutput_1 end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tBufferOutput_1", true);
end_Hash.put("tBufferOutput_1", System.currentTimeMillis());




/**
 * [tBufferOutput_1 end ] stop
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
	 * [tFileInputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_7 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_7";

	

 



/**
 * [tFileInputDelimited_7 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_8 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_8";

	

 



/**
 * [tFileInputDelimited_8 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_9 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_9";

	

 



/**
 * [tFileInputDelimited_9 finally ] stop
 */
	
	/**
	 * [tFileInputDelimited_10 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_10";

	

 



/**
 * [tFileInputDelimited_10 finally ] stop
 */
	
	/**
	 * [tUnite_1 finally ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 finally ] stop
 */

	
	/**
	 * [tBufferOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 finally ] stop
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
        final input_sales input_salesClass = new input_sales();

        int exitCode = input_salesClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = (String[][])globalBuffer.toArray(new String[globalBuffer.size()][]);

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        		hastBufferOutput = true;
    	
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
            java.io.InputStream inContext = input_sales.class.getClassLoader().getResourceAsStream("sales_data_analysis/input_sales_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = input_sales.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
errorCode = null;tFileInputDelimited_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : input_sales");
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
 *     271365 characters generated by Talend Open Studio for Big Data 
 *     on the 28 janvier 2025, 11:09:03 CET
 ************************************************************************************************/
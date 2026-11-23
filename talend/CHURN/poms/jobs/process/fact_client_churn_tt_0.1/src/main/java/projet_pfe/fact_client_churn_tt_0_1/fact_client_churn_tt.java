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


package projet_pfe.fact_client_churn_tt_0_1;

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
 * Job: fact_client_churn_tt Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class fact_client_churn_tt implements TalendJob {

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
	private final String jobName = "fact_client_churn_tt";
	private final String projectName = "PROJET_PFE";
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
				fact_client_churn_tt.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(fact_client_churn_tt.this, new Object[] { e , currentComponent, globalMap});
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

			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class factStruct implements routines.system.IPersistableRow<factStruct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_fact_churn;

				public String getId_fact_churn () {
					return this.id_fact_churn;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public int id_ville;

				public int getId_ville () {
					return this.id_ville;
				}
				
			    public int id_date;

				public int getId_date () {
					return this.id_date;
				}
				
			    public Integer nb_jours_abonne;

				public Integer getNb_jours_abonne () {
					return this.nb_jours_abonne;
				}
				
			    public Float duree_appel_jour_minutes;

				public Float getDuree_appel_jour_minutes () {
					return this.duree_appel_jour_minutes;
				}
				
			    public Integer nb_appel_jour;

				public Integer getNb_appel_jour () {
					return this.nb_appel_jour;
				}
				
			    public Float cout_appel_jour;

				public Float getCout_appel_jour () {
					return this.cout_appel_jour;
				}
				
			    public Float duree_appel_soiree_minutes;

				public Float getDuree_appel_soiree_minutes () {
					return this.duree_appel_soiree_minutes;
				}
				
			    public Integer nb_appel_soiree;

				public Integer getNb_appel_soiree () {
					return this.nb_appel_soiree;
				}
				
			    public Float cout_appel_soiree;

				public Float getCout_appel_soiree () {
					return this.cout_appel_soiree;
				}
				
			    public Float duree_appel_nuit_minutes;

				public Float getDuree_appel_nuit_minutes () {
					return this.duree_appel_nuit_minutes;
				}
				
			    public Integer nb_appel_nuit;

				public Integer getNb_appel_nuit () {
					return this.nb_appel_nuit;
				}
				
			    public Float cout_appel_nuit;

				public Float getCout_appel_nuit () {
					return this.cout_appel_nuit;
				}
				
			    public Float duree_appel_inter_minutes;

				public Float getDuree_appel_inter_minutes () {
					return this.duree_appel_inter_minutes;
				}
				
			    public Integer nb_appel_inter;

				public Integer getNb_appel_inter () {
					return this.nb_appel_inter;
				}
				
			    public Float cout_appel_inter;

				public Float getCout_appel_inter () {
					return this.cout_appel_inter;
				}
				
			    public Integer nb_msg_vocaux;

				public Integer getNb_msg_vocaux () {
					return this.nb_msg_vocaux;
				}
				
			    public Integer nb_reclamation;

				public Integer getNb_reclamation () {
					return this.nb_reclamation;
				}
				
			    public Integer Score_Satisfaction;

				public Integer getScore_Satisfaction () {
					return this.Score_Satisfaction;
				}
				
			    public int churn;

				public int getChurn () {
					return this.churn;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_fact_churn == null) ? 0 : this.id_fact_churn.hashCode());
					
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
		final factStruct other = (factStruct) obj;
		
						if (this.id_fact_churn == null) {
							if (other.id_fact_churn != null)
								return false;
						
						} else if (!this.id_fact_churn.equals(other.id_fact_churn))
						
							return false;
					

		return true;
    }

	public void copyDataTo(factStruct other) {

		other.id_fact_churn = this.id_fact_churn;
	            other.id_client = this.id_client;
	            other.id_ville = this.id_ville;
	            other.id_date = this.id_date;
	            other.nb_jours_abonne = this.nb_jours_abonne;
	            other.duree_appel_jour_minutes = this.duree_appel_jour_minutes;
	            other.nb_appel_jour = this.nb_appel_jour;
	            other.cout_appel_jour = this.cout_appel_jour;
	            other.duree_appel_soiree_minutes = this.duree_appel_soiree_minutes;
	            other.nb_appel_soiree = this.nb_appel_soiree;
	            other.cout_appel_soiree = this.cout_appel_soiree;
	            other.duree_appel_nuit_minutes = this.duree_appel_nuit_minutes;
	            other.nb_appel_nuit = this.nb_appel_nuit;
	            other.cout_appel_nuit = this.cout_appel_nuit;
	            other.duree_appel_inter_minutes = this.duree_appel_inter_minutes;
	            other.nb_appel_inter = this.nb_appel_inter;
	            other.cout_appel_inter = this.cout_appel_inter;
	            other.nb_msg_vocaux = this.nb_msg_vocaux;
	            other.nb_reclamation = this.nb_reclamation;
	            other.Score_Satisfaction = this.Score_Satisfaction;
	            other.churn = this.churn;
	            
	}

	public void copyKeysDataTo(factStruct other) {

		other.id_fact_churn = this.id_fact_churn;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.id_fact_churn = readString(dis);
					
					this.id_client = readString(dis);
					
			        this.id_ville = dis.readInt();
					
			        this.id_date = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
			        this.churn = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.id_fact_churn = readString(dis);
					
					this.id_client = readString(dis);
					
			        this.id_ville = dis.readInt();
					
			        this.id_date = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
			        this.churn = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_fact_churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// int
				
		            	dos.writeInt(this.id_ville);
					
					// int
				
		            	dos.writeInt(this.id_date);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// int
				
		            	dos.writeInt(this.churn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_fact_churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
					// int
				
		            	dos.writeInt(this.id_ville);
					
					// int
				
		            	dos.writeInt(this.id_date);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// int
				
		            	dos.writeInt(this.churn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_fact_churn="+id_fact_churn);
		sb.append(",id_client="+id_client);
		sb.append(",id_ville="+String.valueOf(id_ville));
		sb.append(",id_date="+String.valueOf(id_date));
		sb.append(",nb_jours_abonne="+String.valueOf(nb_jours_abonne));
		sb.append(",duree_appel_jour_minutes="+String.valueOf(duree_appel_jour_minutes));
		sb.append(",nb_appel_jour="+String.valueOf(nb_appel_jour));
		sb.append(",cout_appel_jour="+String.valueOf(cout_appel_jour));
		sb.append(",duree_appel_soiree_minutes="+String.valueOf(duree_appel_soiree_minutes));
		sb.append(",nb_appel_soiree="+String.valueOf(nb_appel_soiree));
		sb.append(",cout_appel_soiree="+String.valueOf(cout_appel_soiree));
		sb.append(",duree_appel_nuit_minutes="+String.valueOf(duree_appel_nuit_minutes));
		sb.append(",nb_appel_nuit="+String.valueOf(nb_appel_nuit));
		sb.append(",cout_appel_nuit="+String.valueOf(cout_appel_nuit));
		sb.append(",duree_appel_inter_minutes="+String.valueOf(duree_appel_inter_minutes));
		sb.append(",nb_appel_inter="+String.valueOf(nb_appel_inter));
		sb.append(",cout_appel_inter="+String.valueOf(cout_appel_inter));
		sb.append(",nb_msg_vocaux="+String.valueOf(nb_msg_vocaux));
		sb.append(",nb_reclamation="+String.valueOf(nb_reclamation));
		sb.append(",Score_Satisfaction="+String.valueOf(Score_Satisfaction));
		sb.append(",churn="+String.valueOf(churn));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(factStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_fact_churn, other.id_fact_churn);
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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];

	
			    public int id;

				public int getId () {
					return this.id;
				}
				
			    public Integer nb_jours_abonne;

				public Integer getNb_jours_abonne () {
					return this.nb_jours_abonne;
				}
				
			    public Float duree_appel_jour_minutes;

				public Float getDuree_appel_jour_minutes () {
					return this.duree_appel_jour_minutes;
				}
				
			    public Integer nb_appel_jour;

				public Integer getNb_appel_jour () {
					return this.nb_appel_jour;
				}
				
			    public Float cout_appel_jour;

				public Float getCout_appel_jour () {
					return this.cout_appel_jour;
				}
				
			    public Float duree_appel_soiree_minutes;

				public Float getDuree_appel_soiree_minutes () {
					return this.duree_appel_soiree_minutes;
				}
				
			    public Integer nb_appel_soiree;

				public Integer getNb_appel_soiree () {
					return this.nb_appel_soiree;
				}
				
			    public Float cout_appel_soiree;

				public Float getCout_appel_soiree () {
					return this.cout_appel_soiree;
				}
				
			    public Float duree_appel_nuit_minutes;

				public Float getDuree_appel_nuit_minutes () {
					return this.duree_appel_nuit_minutes;
				}
				
			    public Integer nb_appel_nuit;

				public Integer getNb_appel_nuit () {
					return this.nb_appel_nuit;
				}
				
			    public Float cout_appel_nuit;

				public Float getCout_appel_nuit () {
					return this.cout_appel_nuit;
				}
				
			    public Float duree_appel_inter_minutes;

				public Float getDuree_appel_inter_minutes () {
					return this.duree_appel_inter_minutes;
				}
				
			    public Integer nb_appel_inter;

				public Integer getNb_appel_inter () {
					return this.nb_appel_inter;
				}
				
			    public Float cout_appel_inter;

				public Float getCout_appel_inter () {
					return this.cout_appel_inter;
				}
				
			    public Integer nb_msg_vocaux;

				public Integer getNb_msg_vocaux () {
					return this.nb_msg_vocaux;
				}
				
			    public Integer nb_reclamation;

				public Integer getNb_reclamation () {
					return this.nb_reclamation;
				}
				
			    public Integer Score_Satisfaction;

				public Integer getScore_Satisfaction () {
					return this.Score_Satisfaction;
				}
				
			    public java.util.Date date_activation;

				public java.util.Date getDate_activation () {
					return this.date_activation;
				}
				
			    public String Ville;

				public String getVille () {
					return this.Ville;
				}
				
			    public String Etat_civil;

				public String getEtat_civil () {
					return this.Etat_civil;
				}
				
			    public String active_msg_vocaux;

				public String getActive_msg_vocaux () {
					return this.active_msg_vocaux;
				}
				
			    public String Tranche_d_age;

				public String getTranche_d_age () {
					return this.Tranche_d_age;
				}
				
			    public Integer churn;

				public Integer getChurn () {
					return this.churn;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
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

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
					this.date_activation = readDate(dis);
					
					this.Ville = readString(dis);
					
					this.Etat_civil = readString(dis);
					
					this.active_msg_vocaux = readString(dis);
					
					this.Tranche_d_age = readString(dis);
					
						this.churn = readInteger(dis);
					
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
					this.date_activation = readDate(dis);
					
					this.Ville = readString(dis);
					
					this.Etat_civil = readString(dis);
					
					this.active_msg_vocaux = readString(dis);
					
					this.Tranche_d_age = readString(dis);
					
						this.churn = readInteger(dis);
					
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// java.util.Date
				
						writeDate(this.date_activation,dos);
					
					// String
				
						writeString(this.Ville,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
					// String
				
						writeString(this.active_msg_vocaux,dos);
					
					// String
				
						writeString(this.Tranche_d_age,dos);
					
					// Integer
				
						writeInteger(this.churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// java.util.Date
				
						writeDate(this.date_activation,dos);
					
					// String
				
						writeString(this.Ville,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
					// String
				
						writeString(this.active_msg_vocaux,dos);
					
					// String
				
						writeString(this.Tranche_d_age,dos);
					
					// Integer
				
						writeInteger(this.churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",nb_jours_abonne="+String.valueOf(nb_jours_abonne));
		sb.append(",duree_appel_jour_minutes="+String.valueOf(duree_appel_jour_minutes));
		sb.append(",nb_appel_jour="+String.valueOf(nb_appel_jour));
		sb.append(",cout_appel_jour="+String.valueOf(cout_appel_jour));
		sb.append(",duree_appel_soiree_minutes="+String.valueOf(duree_appel_soiree_minutes));
		sb.append(",nb_appel_soiree="+String.valueOf(nb_appel_soiree));
		sb.append(",cout_appel_soiree="+String.valueOf(cout_appel_soiree));
		sb.append(",duree_appel_nuit_minutes="+String.valueOf(duree_appel_nuit_minutes));
		sb.append(",nb_appel_nuit="+String.valueOf(nb_appel_nuit));
		sb.append(",cout_appel_nuit="+String.valueOf(cout_appel_nuit));
		sb.append(",duree_appel_inter_minutes="+String.valueOf(duree_appel_inter_minutes));
		sb.append(",nb_appel_inter="+String.valueOf(nb_appel_inter));
		sb.append(",cout_appel_inter="+String.valueOf(cout_appel_inter));
		sb.append(",nb_msg_vocaux="+String.valueOf(nb_msg_vocaux));
		sb.append(",nb_reclamation="+String.valueOf(nb_reclamation));
		sb.append(",Score_Satisfaction="+String.valueOf(Score_Satisfaction));
		sb.append(",date_activation="+String.valueOf(date_activation));
		sb.append(",Ville="+Ville);
		sb.append(",Etat_civil="+Etat_civil);
		sb.append(",active_msg_vocaux="+active_msg_vocaux);
		sb.append(",Tranche_d_age="+Tranche_d_age);
		sb.append(",churn="+String.valueOf(churn));
		sb.append(",id_client="+id_client);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

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

public static class after_tDBInput_4Struct implements routines.system.IPersistableRow<after_tDBInput_4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id;

				public int getId () {
					return this.id;
				}
				
			    public Integer nb_jours_abonne;

				public Integer getNb_jours_abonne () {
					return this.nb_jours_abonne;
				}
				
			    public Float duree_appel_jour_minutes;

				public Float getDuree_appel_jour_minutes () {
					return this.duree_appel_jour_minutes;
				}
				
			    public Integer nb_appel_jour;

				public Integer getNb_appel_jour () {
					return this.nb_appel_jour;
				}
				
			    public Float cout_appel_jour;

				public Float getCout_appel_jour () {
					return this.cout_appel_jour;
				}
				
			    public Float duree_appel_soiree_minutes;

				public Float getDuree_appel_soiree_minutes () {
					return this.duree_appel_soiree_minutes;
				}
				
			    public Integer nb_appel_soiree;

				public Integer getNb_appel_soiree () {
					return this.nb_appel_soiree;
				}
				
			    public Float cout_appel_soiree;

				public Float getCout_appel_soiree () {
					return this.cout_appel_soiree;
				}
				
			    public Float duree_appel_nuit_minutes;

				public Float getDuree_appel_nuit_minutes () {
					return this.duree_appel_nuit_minutes;
				}
				
			    public Integer nb_appel_nuit;

				public Integer getNb_appel_nuit () {
					return this.nb_appel_nuit;
				}
				
			    public Float cout_appel_nuit;

				public Float getCout_appel_nuit () {
					return this.cout_appel_nuit;
				}
				
			    public Float duree_appel_inter_minutes;

				public Float getDuree_appel_inter_minutes () {
					return this.duree_appel_inter_minutes;
				}
				
			    public Integer nb_appel_inter;

				public Integer getNb_appel_inter () {
					return this.nb_appel_inter;
				}
				
			    public Float cout_appel_inter;

				public Float getCout_appel_inter () {
					return this.cout_appel_inter;
				}
				
			    public Integer nb_msg_vocaux;

				public Integer getNb_msg_vocaux () {
					return this.nb_msg_vocaux;
				}
				
			    public Integer nb_reclamation;

				public Integer getNb_reclamation () {
					return this.nb_reclamation;
				}
				
			    public Integer Score_Satisfaction;

				public Integer getScore_Satisfaction () {
					return this.Score_Satisfaction;
				}
				
			    public java.util.Date date_activation;

				public java.util.Date getDate_activation () {
					return this.date_activation;
				}
				
			    public String Ville;

				public String getVille () {
					return this.Ville;
				}
				
			    public String Etat_civil;

				public String getEtat_civil () {
					return this.Etat_civil;
				}
				
			    public String active_msg_vocaux;

				public String getActive_msg_vocaux () {
					return this.active_msg_vocaux;
				}
				
			    public String Tranche_d_age;

				public String getTranche_d_age () {
					return this.Tranche_d_age;
				}
				
			    public Integer churn;

				public Integer getChurn () {
					return this.churn;
				}
				
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.id;
						
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
		final after_tDBInput_4Struct other = (after_tDBInput_4Struct) obj;
		
						if (this.id != other.id)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_4Struct other) {

		other.id = this.id;
	            other.nb_jours_abonne = this.nb_jours_abonne;
	            other.duree_appel_jour_minutes = this.duree_appel_jour_minutes;
	            other.nb_appel_jour = this.nb_appel_jour;
	            other.cout_appel_jour = this.cout_appel_jour;
	            other.duree_appel_soiree_minutes = this.duree_appel_soiree_minutes;
	            other.nb_appel_soiree = this.nb_appel_soiree;
	            other.cout_appel_soiree = this.cout_appel_soiree;
	            other.duree_appel_nuit_minutes = this.duree_appel_nuit_minutes;
	            other.nb_appel_nuit = this.nb_appel_nuit;
	            other.cout_appel_nuit = this.cout_appel_nuit;
	            other.duree_appel_inter_minutes = this.duree_appel_inter_minutes;
	            other.nb_appel_inter = this.nb_appel_inter;
	            other.cout_appel_inter = this.cout_appel_inter;
	            other.nb_msg_vocaux = this.nb_msg_vocaux;
	            other.nb_reclamation = this.nb_reclamation;
	            other.Score_Satisfaction = this.Score_Satisfaction;
	            other.date_activation = this.date_activation;
	            other.Ville = this.Ville;
	            other.Etat_civil = this.Etat_civil;
	            other.active_msg_vocaux = this.active_msg_vocaux;
	            other.Tranche_d_age = this.Tranche_d_age;
	            other.churn = this.churn;
	            other.id_client = this.id_client;
	            
	}

	public void copyKeysDataTo(after_tDBInput_4Struct other) {

		other.id = this.id;
	            	
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

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
					this.date_activation = readDate(dis);
					
					this.Ville = readString(dis);
					
					this.Etat_civil = readString(dis);
					
					this.active_msg_vocaux = readString(dis);
					
					this.Tranche_d_age = readString(dis);
					
						this.churn = readInteger(dis);
					
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
						this.nb_jours_abonne = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_jour_minutes = null;
           				} else {
           			    	this.duree_appel_jour_minutes = dis.readFloat();
           				}
					
						this.nb_appel_jour = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_jour = null;
           				} else {
           			    	this.cout_appel_jour = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_soiree_minutes = null;
           				} else {
           			    	this.duree_appel_soiree_minutes = dis.readFloat();
           				}
					
						this.nb_appel_soiree = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_soiree = null;
           				} else {
           			    	this.cout_appel_soiree = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_nuit_minutes = null;
           				} else {
           			    	this.duree_appel_nuit_minutes = dis.readFloat();
           				}
					
						this.nb_appel_nuit = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_nuit = null;
           				} else {
           			    	this.cout_appel_nuit = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.duree_appel_inter_minutes = null;
           				} else {
           			    	this.duree_appel_inter_minutes = dis.readFloat();
           				}
					
						this.nb_appel_inter = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.cout_appel_inter = null;
           				} else {
           			    	this.cout_appel_inter = dis.readFloat();
           				}
					
						this.nb_msg_vocaux = readInteger(dis);
					
						this.nb_reclamation = readInteger(dis);
					
						this.Score_Satisfaction = readInteger(dis);
					
					this.date_activation = readDate(dis);
					
					this.Ville = readString(dis);
					
					this.Etat_civil = readString(dis);
					
					this.active_msg_vocaux = readString(dis);
					
					this.Tranche_d_age = readString(dis);
					
						this.churn = readInteger(dis);
					
					this.id_client = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// java.util.Date
				
						writeDate(this.date_activation,dos);
					
					// String
				
						writeString(this.Ville,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
					// String
				
						writeString(this.active_msg_vocaux,dos);
					
					// String
				
						writeString(this.Tranche_d_age,dos);
					
					// Integer
				
						writeInteger(this.churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
					// Integer
				
						writeInteger(this.nb_jours_abonne,dos);
					
					// Float
				
						if(this.duree_appel_jour_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_jour_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_jour,dos);
					
					// Float
				
						if(this.cout_appel_jour == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_jour);
		            	}
					
					// Float
				
						if(this.duree_appel_soiree_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_soiree_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_soiree,dos);
					
					// Float
				
						if(this.cout_appel_soiree == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_soiree);
		            	}
					
					// Float
				
						if(this.duree_appel_nuit_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_nuit_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_nuit,dos);
					
					// Float
				
						if(this.cout_appel_nuit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_nuit);
		            	}
					
					// Float
				
						if(this.duree_appel_inter_minutes == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.duree_appel_inter_minutes);
		            	}
					
					// Integer
				
						writeInteger(this.nb_appel_inter,dos);
					
					// Float
				
						if(this.cout_appel_inter == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.cout_appel_inter);
		            	}
					
					// Integer
				
						writeInteger(this.nb_msg_vocaux,dos);
					
					// Integer
				
						writeInteger(this.nb_reclamation,dos);
					
					// Integer
				
						writeInteger(this.Score_Satisfaction,dos);
					
					// java.util.Date
				
						writeDate(this.date_activation,dos);
					
					// String
				
						writeString(this.Ville,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
					// String
				
						writeString(this.active_msg_vocaux,dos);
					
					// String
				
						writeString(this.Tranche_d_age,dos);
					
					// Integer
				
						writeInteger(this.churn,dos);
					
					// String
				
						writeString(this.id_client,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",nb_jours_abonne="+String.valueOf(nb_jours_abonne));
		sb.append(",duree_appel_jour_minutes="+String.valueOf(duree_appel_jour_minutes));
		sb.append(",nb_appel_jour="+String.valueOf(nb_appel_jour));
		sb.append(",cout_appel_jour="+String.valueOf(cout_appel_jour));
		sb.append(",duree_appel_soiree_minutes="+String.valueOf(duree_appel_soiree_minutes));
		sb.append(",nb_appel_soiree="+String.valueOf(nb_appel_soiree));
		sb.append(",cout_appel_soiree="+String.valueOf(cout_appel_soiree));
		sb.append(",duree_appel_nuit_minutes="+String.valueOf(duree_appel_nuit_minutes));
		sb.append(",nb_appel_nuit="+String.valueOf(nb_appel_nuit));
		sb.append(",cout_appel_nuit="+String.valueOf(cout_appel_nuit));
		sb.append(",duree_appel_inter_minutes="+String.valueOf(duree_appel_inter_minutes));
		sb.append(",nb_appel_inter="+String.valueOf(nb_appel_inter));
		sb.append(",cout_appel_inter="+String.valueOf(cout_appel_inter));
		sb.append(",nb_msg_vocaux="+String.valueOf(nb_msg_vocaux));
		sb.append(",nb_reclamation="+String.valueOf(nb_reclamation));
		sb.append(",Score_Satisfaction="+String.valueOf(Score_Satisfaction));
		sb.append(",date_activation="+String.valueOf(date_activation));
		sb.append(",Ville="+Ville);
		sb.append(",Etat_civil="+Etat_civil);
		sb.append(",active_msg_vocaux="+active_msg_vocaux);
		sb.append(",Tranche_d_age="+Tranche_d_age);
		sb.append(",churn="+String.valueOf(churn));
		sb.append(",id_client="+id_client);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id, other.id);
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
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);
		tDBInput_1Process(globalMap);

		row1Struct row1 = new row1Struct();
factStruct fact = new factStruct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"fact");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 21 && true) {
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

String tableName_tDBOutput_1 = "fact_churn_tt";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
        String properties_tDBOutput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
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

        String url_tDBOutput_1 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "bd_pfe" + "?" + properties_tDBOutput_1;
		
		String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_1 = "root";
		

		 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:dQstUzTBZLoRsTbMGDSfkzeSz2L4GlNeIyx/ox2jeCaA");

		String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
		java.lang.Class.forName(driverClass_tDBOutput_1);
		
		conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
		
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

int count_tDBOutput_1=0;
    	
            int rsTruncCountNumber_tDBOutput_1 = 0;
            try(java.sql.Statement stmtTruncCount_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                try (java.sql.ResultSet rsTruncCount_tDBOutput_1 = stmtTruncCount_tDBOutput_1.executeQuery("SELECT COUNT(1) FROM `" + tableName_tDBOutput_1 + "`")) {
                    if(rsTruncCount_tDBOutput_1.next()) {
                        rsTruncCountNumber_tDBOutput_1 = rsTruncCount_tDBOutput_1.getInt(1);
                    }
                }
            }
            try (java.sql.Statement stmtTrunc_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                stmtTrunc_tDBOutput_1.executeUpdate("TRUNCATE TABLE `" + tableName_tDBOutput_1 + "`");
                deletedCount_tDBOutput_1 += rsTruncCountNumber_tDBOutput_1;
            }
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM `" + "fact_churn_tt" + "` WHERE `id_fact_churn` = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO `" + "fact_churn_tt" + "` (`id_fact_churn`,`id_client`,`id_ville`,`id_date`,`nb_jours_abonne`,`duree_appel_jour_minutes`,`nb_appel_jour`,`cout_appel_jour`,`duree_appel_soiree_minutes`,`nb_appel_soiree`,`cout_appel_soiree`,`duree_appel_nuit_minutes`,`nb_appel_nuit`,`cout_appel_nuit`,`duree_appel_inter_minutes`,`nb_appel_inter`,`cout_appel_inter`,`nb_msg_vocaux`,`nb_reclamation`,`Score_Satisfaction`,`churn`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE `" + "fact_churn_tt" + "` SET `id_client` = ?,`id_ville` = ?,`id_date` = ?,`nb_jours_abonne` = ?,`duree_appel_jour_minutes` = ?,`nb_appel_jour` = ?,`cout_appel_jour` = ?,`duree_appel_soiree_minutes` = ?,`nb_appel_soiree` = ?,`cout_appel_soiree` = ?,`duree_appel_nuit_minutes` = ?,`nb_appel_nuit` = ?,`cout_appel_nuit` = ?,`duree_appel_inter_minutes` = ?,`nb_appel_inter` = ?,`cout_appel_inter` = ?,`nb_msg_vocaux` = ?,`nb_reclamation` = ?,`Score_Satisfaction` = ?,`churn` = ? WHERE `id_fact_churn` = ?";
	    
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
factStruct fact_tmp = new factStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
	
		    java.util.Calendar calendar_tDBInput_4 = java.util.Calendar.getInstance();
		    calendar_tDBInput_4.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_4 = calendar_tDBInput_4.getTime();
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "root";
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:W4+FrYKrjIDh6mYtqPaYyvfCptX4o9X/99gWkNstbGBA");
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
        String properties_tDBInput_4 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_4 == null || properties_tDBInput_4.trim().length() == 0) {
            properties_tDBInput_4 = "";
        }
        String url_tDBInput_4 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "bd_pfe1" + "?" + properties_tDBInput_4;
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT \n  `table_source`.`id`, \n  `table_source`.`nb_jours_abonne`, \n  `table_source`.`duree_appel_jour_minutes`, \n  `t"
+"able_source`.`nb_appel_jour`, \n  `table_source`.`cout_appel_jour`, \n  `table_source`.`duree_appel_soiree_minutes`, \n  `t"
+"able_source`.`nb_appel_soiree`, \n  `table_source`.`cout_appel_soiree`, \n  `table_source`.`duree_appel_nuit_minutes`, \n  "
+"`table_source`.`nb_appel_nuit`, \n  `table_source`.`cout_appel_nuit`, \n  `table_source`.`duree_appel_inter_minutes`, \n  `"
+"table_source`.`nb_appel_inter`, \n  `table_source`.`cout_appel_inter`, \n  `table_source`.`nb_msg_vocaux`, \n  `table_sourc"
+"e`.`nb_reclamation`, \n  `table_source`.`Score_Satisfaction`, \n  `table_source`.`date_activation`, \n  `table_source`.`Vil"
+"le`, \n  `table_source`.`Etat_civil`, \n  `table_source`.`active_msg_vocaux`, \n  `table_source`.`Tranche_d_age`, \n  `table"
+"_source`.`churn`, \n  `table_source`.`id_client`\nFROM `table_source`";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row1.id = 0;
							} else {
		                          
            row1.id = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row1.nb_jours_abonne = null;
							} else {
		                          
            row1.nb_jours_abonne = rs_tDBInput_4.getInt(2);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_jours_abonne = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row1.duree_appel_jour_minutes = null;
							} else {
		                          
            row1.duree_appel_jour_minutes = rs_tDBInput_4.getFloat(3);
            if(rs_tDBInput_4.wasNull()){
                    row1.duree_appel_jour_minutes = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row1.nb_appel_jour = null;
							} else {
		                          
            row1.nb_appel_jour = rs_tDBInput_4.getInt(4);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_appel_jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row1.cout_appel_jour = null;
							} else {
		                          
            row1.cout_appel_jour = rs_tDBInput_4.getFloat(5);
            if(rs_tDBInput_4.wasNull()){
                    row1.cout_appel_jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row1.duree_appel_soiree_minutes = null;
							} else {
		                          
            row1.duree_appel_soiree_minutes = rs_tDBInput_4.getFloat(6);
            if(rs_tDBInput_4.wasNull()){
                    row1.duree_appel_soiree_minutes = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row1.nb_appel_soiree = null;
							} else {
		                          
            row1.nb_appel_soiree = rs_tDBInput_4.getInt(7);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_appel_soiree = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 8) {
								row1.cout_appel_soiree = null;
							} else {
		                          
            row1.cout_appel_soiree = rs_tDBInput_4.getFloat(8);
            if(rs_tDBInput_4.wasNull()){
                    row1.cout_appel_soiree = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 9) {
								row1.duree_appel_nuit_minutes = null;
							} else {
		                          
            row1.duree_appel_nuit_minutes = rs_tDBInput_4.getFloat(9);
            if(rs_tDBInput_4.wasNull()){
                    row1.duree_appel_nuit_minutes = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 10) {
								row1.nb_appel_nuit = null;
							} else {
		                          
            row1.nb_appel_nuit = rs_tDBInput_4.getInt(10);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_appel_nuit = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 11) {
								row1.cout_appel_nuit = null;
							} else {
		                          
            row1.cout_appel_nuit = rs_tDBInput_4.getFloat(11);
            if(rs_tDBInput_4.wasNull()){
                    row1.cout_appel_nuit = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 12) {
								row1.duree_appel_inter_minutes = null;
							} else {
		                          
            row1.duree_appel_inter_minutes = rs_tDBInput_4.getFloat(12);
            if(rs_tDBInput_4.wasNull()){
                    row1.duree_appel_inter_minutes = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 13) {
								row1.nb_appel_inter = null;
							} else {
		                          
            row1.nb_appel_inter = rs_tDBInput_4.getInt(13);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_appel_inter = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 14) {
								row1.cout_appel_inter = null;
							} else {
		                          
            row1.cout_appel_inter = rs_tDBInput_4.getFloat(14);
            if(rs_tDBInput_4.wasNull()){
                    row1.cout_appel_inter = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 15) {
								row1.nb_msg_vocaux = null;
							} else {
		                          
            row1.nb_msg_vocaux = rs_tDBInput_4.getInt(15);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_msg_vocaux = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 16) {
								row1.nb_reclamation = null;
							} else {
		                          
            row1.nb_reclamation = rs_tDBInput_4.getInt(16);
            if(rs_tDBInput_4.wasNull()){
                    row1.nb_reclamation = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 17) {
								row1.Score_Satisfaction = null;
							} else {
		                          
            row1.Score_Satisfaction = rs_tDBInput_4.getInt(17);
            if(rs_tDBInput_4.wasNull()){
                    row1.Score_Satisfaction = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 18) {
								row1.date_activation = null;
							} else {
										
				if(rs_tDBInput_4.getString(18) != null) {
					String dateString_tDBInput_4 = rs_tDBInput_4.getString(18);
					if (!("0000-00-00").equals(dateString_tDBInput_4) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_4)) {
						row1.date_activation = rs_tDBInput_4.getTimestamp(18);
					} else {
						row1.date_activation = (java.util.Date) year0_tDBInput_4.clone();
					}
				} else {
					row1.date_activation =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_4 < 19) {
								row1.Ville = null;
							} else {
	                         		
        	row1.Ville = routines.system.JDBCUtil.getString(rs_tDBInput_4, 19, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 20) {
								row1.Etat_civil = null;
							} else {
	                         		
        	row1.Etat_civil = routines.system.JDBCUtil.getString(rs_tDBInput_4, 20, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 21) {
								row1.active_msg_vocaux = null;
							} else {
	                         		
        	row1.active_msg_vocaux = routines.system.JDBCUtil.getString(rs_tDBInput_4, 21, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 22) {
								row1.Tranche_d_age = null;
							} else {
	                         		
        	row1.Tranche_d_age = routines.system.JDBCUtil.getString(rs_tDBInput_4, 22, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 23) {
								row1.churn = null;
							} else {
		                          
            row1.churn = rs_tDBInput_4.getInt(23);
            if(rs_tDBInput_4.wasNull()){
                    row1.churn = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 24) {
								row1.id_client = null;
							} else {
	                         		
        	row1.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_4, 24, false);
		                    }
					

 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row3HashKey.Ville = row1.Ville ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.Ville = '" + row3HashKey.Ville + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row4HashKey.jour = TalendDate.getPartOfDate("DAY_OF_MONTH", row1.date_activation)  ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.jour = '" + row4HashKey.jour + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.id_client = row1.id_client;
                        		    		
                        		    		    row2HashKey.Etat_civil = row1.Etat_civil ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.id_client = '" + row2HashKey.id_client + "', row2.Etat_civil = '" + row2HashKey.Etat_civil + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

fact = null;


// # Output table : 'fact'
fact_tmp.id_fact_churn = (row2.id_client.length() > 4 ? row2.id_client.substring(4) : "") + "-" + 
String.valueOf(row3.id_ville) + "-" + 
String.valueOf(row4.id_date) ;
fact_tmp.id_client = row2.id_client ;
fact_tmp.id_ville = row3.id_ville ;
fact_tmp.id_date = row4.id_date ;
fact_tmp.nb_jours_abonne = row1.nb_jours_abonne ;
fact_tmp.duree_appel_jour_minutes = row1.duree_appel_jour_minutes ;
fact_tmp.nb_appel_jour = row1.nb_appel_jour ;
fact_tmp.cout_appel_jour = row1.cout_appel_jour ;
fact_tmp.duree_appel_soiree_minutes = row1.duree_appel_soiree_minutes ;
fact_tmp.nb_appel_soiree = row1.nb_appel_soiree ;
fact_tmp.cout_appel_soiree = row1.cout_appel_soiree ;
fact_tmp.duree_appel_nuit_minutes = row1.duree_appel_nuit_minutes ;
fact_tmp.nb_appel_nuit = row1.nb_appel_nuit ;
fact_tmp.cout_appel_nuit = row1.cout_appel_nuit ;
fact_tmp.duree_appel_inter_minutes = row1.duree_appel_inter_minutes ;
fact_tmp.nb_appel_inter = row1.nb_appel_inter ;
fact_tmp.cout_appel_inter = row1.cout_appel_inter ;
fact_tmp.nb_msg_vocaux = row1.nb_msg_vocaux ;
fact_tmp.nb_reclamation = row1.nb_reclamation ;
fact_tmp.Score_Satisfaction = row1.Score_Satisfaction   ;
fact_tmp.churn = row1.churn ;
fact = fact_tmp;
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
// Start of branch "fact"
if(fact != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"fact"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(fact.id_fact_churn == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, fact.id_fact_churn);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(fact.id_client == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, fact.id_client);
}

                        pstmtUpdate_tDBOutput_1.setInt(2, fact.id_ville);

                        pstmtUpdate_tDBOutput_1.setInt(3, fact.id_date);

                        if(fact.nb_jours_abonne == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(4, fact.nb_jours_abonne);
}

                        if(fact.duree_appel_jour_minutes == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(5, fact.duree_appel_jour_minutes);
}

                        if(fact.nb_appel_jour == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(6, fact.nb_appel_jour);
}

                        if(fact.cout_appel_jour == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(7, fact.cout_appel_jour);
}

                        if(fact.duree_appel_soiree_minutes == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(8, fact.duree_appel_soiree_minutes);
}

                        if(fact.nb_appel_soiree == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(9, fact.nb_appel_soiree);
}

                        if(fact.cout_appel_soiree == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(10, fact.cout_appel_soiree);
}

                        if(fact.duree_appel_nuit_minutes == null) {
pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(11, fact.duree_appel_nuit_minutes);
}

                        if(fact.nb_appel_nuit == null) {
pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(12, fact.nb_appel_nuit);
}

                        if(fact.cout_appel_nuit == null) {
pstmtUpdate_tDBOutput_1.setNull(13, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(13, fact.cout_appel_nuit);
}

                        if(fact.duree_appel_inter_minutes == null) {
pstmtUpdate_tDBOutput_1.setNull(14, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(14, fact.duree_appel_inter_minutes);
}

                        if(fact.nb_appel_inter == null) {
pstmtUpdate_tDBOutput_1.setNull(15, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(15, fact.nb_appel_inter);
}

                        if(fact.cout_appel_inter == null) {
pstmtUpdate_tDBOutput_1.setNull(16, java.sql.Types.FLOAT);
} else {pstmtUpdate_tDBOutput_1.setFloat(16, fact.cout_appel_inter);
}

                        if(fact.nb_msg_vocaux == null) {
pstmtUpdate_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(17, fact.nb_msg_vocaux);
}

                        if(fact.nb_reclamation == null) {
pstmtUpdate_tDBOutput_1.setNull(18, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(18, fact.nb_reclamation);
}

                        if(fact.Score_Satisfaction == null) {
pstmtUpdate_tDBOutput_1.setNull(19, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(19, fact.Score_Satisfaction);
}

                        pstmtUpdate_tDBOutput_1.setInt(20, fact.churn);

                        if(fact.id_fact_churn == null) {
pstmtUpdate_tDBOutput_1.setNull(21 + count_tDBOutput_1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(21 + count_tDBOutput_1, fact.id_fact_churn);
}

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
                        if(fact.id_fact_churn == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(1, fact.id_fact_churn);
}

                        if(fact.id_client == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, fact.id_client);
}

                        pstmtInsert_tDBOutput_1.setInt(3, fact.id_ville);

                        pstmtInsert_tDBOutput_1.setInt(4, fact.id_date);

                        if(fact.nb_jours_abonne == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(5, fact.nb_jours_abonne);
}

                        if(fact.duree_appel_jour_minutes == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(6, fact.duree_appel_jour_minutes);
}

                        if(fact.nb_appel_jour == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(7, fact.nb_appel_jour);
}

                        if(fact.cout_appel_jour == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(8, fact.cout_appel_jour);
}

                        if(fact.duree_appel_soiree_minutes == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(9, fact.duree_appel_soiree_minutes);
}

                        if(fact.nb_appel_soiree == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(10, fact.nb_appel_soiree);
}

                        if(fact.cout_appel_soiree == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(11, fact.cout_appel_soiree);
}

                        if(fact.duree_appel_nuit_minutes == null) {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(12, fact.duree_appel_nuit_minutes);
}

                        if(fact.nb_appel_nuit == null) {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(13, fact.nb_appel_nuit);
}

                        if(fact.cout_appel_nuit == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(14, fact.cout_appel_nuit);
}

                        if(fact.duree_appel_inter_minutes == null) {
pstmtInsert_tDBOutput_1.setNull(15, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(15, fact.duree_appel_inter_minutes);
}

                        if(fact.nb_appel_inter == null) {
pstmtInsert_tDBOutput_1.setNull(16, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(16, fact.nb_appel_inter);
}

                        if(fact.cout_appel_inter == null) {
pstmtInsert_tDBOutput_1.setNull(17, java.sql.Types.FLOAT);
} else {pstmtInsert_tDBOutput_1.setFloat(17, fact.cout_appel_inter);
}

                        if(fact.nb_msg_vocaux == null) {
pstmtInsert_tDBOutput_1.setNull(18, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(18, fact.nb_msg_vocaux);
}

                        if(fact.nb_reclamation == null) {
pstmtInsert_tDBOutput_1.setNull(19, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(19, fact.nb_reclamation);
}

                        if(fact.Score_Satisfaction == null) {
pstmtInsert_tDBOutput_1.setNull(20, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(20, fact.Score_Satisfaction);
}

                        pstmtInsert_tDBOutput_1.setInt(21, fact.churn);

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

} // End of branch "fact"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
		
}

		   globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
		


 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"fact");
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
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
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
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_ville;

				public int getId_ville () {
					return this.id_ville;
				}
				
			    public String Ville;

				public String getVille () {
					return this.Ville;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Ville == null) ? 0 : this.Ville.hashCode());
					
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
		final row3Struct other = (row3Struct) obj;
		
						if (this.Ville == null) {
							if (other.Ville != null)
								return false;
						
						} else if (!this.Ville.equals(other.Ville))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.id_ville = this.id_ville;
	            other.Ville = this.Ville;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.Ville = this.Ville;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.Ville = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.Ville = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Ville,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Ville,dos);
					
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
		
			            this.id_ville = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_ville = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_ville);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_ville);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_ville="+String.valueOf(id_ville));
		sb.append(",Ville="+Ville);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Ville, other.Ville);
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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_4) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row3,row4,row2) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
	
		    java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
		    calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "root";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:HYpEoz/TIGV0OsIMsCOOVR/2q5/aNd9bB+NUOiLk0TAw");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
        String properties_tDBInput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
            properties_tDBInput_2 = "";
        }
        String url_tDBInput_2 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "bd_pfe" + "?" + properties_tDBInput_2;
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  `dim_localisation`.`id_ville`, \n  `dim_localisation`.`Ville`\nFROM `dim_localisation`";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row3.id_ville = 0;
							} else {
		                          
            row3.id_ville = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.Ville = null;
							} else {
	                         		
        	row3.Ville = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
					

 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.id_ville = row3.id_ville;
				
				row3_HashRow.Ville = row3.Ville;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
		
}

		   globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
		


 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int id_date;

				public int getId_date () {
					return this.id_date;
				}
				
			    public Integer jour;

				public Integer getJour () {
					return this.jour;
				}
				
			    public Integer mois;

				public Integer getMois () {
					return this.mois;
				}
				
			    public Integer annee;

				public Integer getAnnee () {
					return this.annee;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.jour == null) ? 0 : this.jour.hashCode());
					
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
		
						if (this.jour == null) {
							if (other.jour != null)
								return false;
						
						} else if (!this.jour.equals(other.jour))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.id_date = this.id_date;
	            other.jour = this.jour;
	            other.mois = this.mois;
	            other.annee = this.annee;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.jour = this.jour;
	            	
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
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
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
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
						this.jour = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
						this.jour = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.jour,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.jour,dos);
					
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
		
			            this.id_date = dis.readInt();
					
						this.mois = readInteger(dis,ois);
					
						this.annee = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.id_date = objectIn.readInt();
					
						this.mois = readInteger(dis,objectIn);
					
						this.annee = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.id_date);
					
					writeInteger(this.mois, dos, oos);
					
					writeInteger(this.annee, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.id_date);
					
					writeInteger(this.mois, dos, objectOut);
					
					writeInteger(this.annee, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_date="+String.valueOf(id_date));
		sb.append(",jour="+String.valueOf(jour));
		sb.append(",mois="+String.valueOf(mois));
		sb.append(",annee="+String.valueOf(annee));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.jour, other.jour);
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
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

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
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_4) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row3,row4,row2) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
	
		    java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
		    calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "root";
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:bitY/bZjHLPnLZlAP+9Ag9Z8bBqWvESAEDTBxRiX2SMy");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
        String properties_tDBInput_3 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
            properties_tDBInput_3 = "";
        }
        String url_tDBInput_3 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "bd_pfe" + "?" + properties_tDBInput_3;
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT \n  `dim_temps_tt`.`id_date`, \n  `dim_temps_tt`.`jour`, \n  `dim_temps_tt`.`mois`, \n  `dim_temps_tt`.`annee`\nFROM "
+"`dim_temps_tt`";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row4.id_date = 0;
							} else {
		                          
            row4.id_date = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row4.jour = null;
							} else {
		                          
            row4.jour = rs_tDBInput_3.getInt(2);
            if(rs_tDBInput_3.wasNull()){
                    row4.jour = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row4.mois = null;
							} else {
		                          
            row4.mois = rs_tDBInput_3.getInt(3);
            if(rs_tDBInput_3.wasNull()){
                    row4.mois = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row4.annee = null;
							} else {
		                          
            row4.annee = rs_tDBInput_3.getInt(4);
            if(rs_tDBInput_3.wasNull()){
                    row4.annee = null;
            }
		                    }
					

 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.id_date = row4.id_date;
				
				row4_HashRow.jour = row4.jour;
				
				row4_HashRow.mois = row4.mois;
				
				row4_HashRow.annee = row4.annee;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
		
}

		   globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);
		


 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJET_PFE_fact_client_churn_tt = new byte[0];
    static byte[] commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String id_client;

				public String getId_client () {
					return this.id_client;
				}
				
			    public String Categorie_d_age;

				public String getCategorie_d_age () {
					return this.Categorie_d_age;
				}
				
			    public String Etat_civil;

				public String getEtat_civil () {
					return this.Etat_civil;
				}
				
			    public String active_msg_vocaux;

				public String getActive_msg_vocaux () {
					return this.active_msg_vocaux;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id_client == null) ? 0 : this.id_client.hashCode());
					
						result = prime * result + ((this.Etat_civil == null) ? 0 : this.Etat_civil.hashCode());
					
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
		
						if (this.id_client == null) {
							if (other.id_client != null)
								return false;
						
						} else if (!this.id_client.equals(other.id_client))
						
							return false;
					
						if (this.Etat_civil == null) {
							if (other.Etat_civil != null)
								return false;
						
						} else if (!this.Etat_civil.equals(other.Etat_civil))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.id_client = this.id_client;
	            other.Categorie_d_age = this.Categorie_d_age;
	            other.Etat_civil = this.Etat_civil;
	            other.active_msg_vocaux = this.active_msg_vocaux;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.id_client = this.id_client;
	            	other.Etat_civil = this.Etat_civil;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PFE_fact_client_churn_tt.length) {
				if(length < 1024 && commonByteArray_PROJET_PFE_fact_client_churn_tt.length == 0) {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[1024];
				} else {
   					commonByteArray_PROJET_PFE_fact_client_churn_tt = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length);
			strReturn = new String(commonByteArray_PROJET_PFE_fact_client_churn_tt, 0, length, utf8Charset);
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
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
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
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
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
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.Etat_civil = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PFE_fact_client_churn_tt) {

        	try {

        		int length = 0;
		
					this.id_client = readString(dis);
					
					this.Etat_civil = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.id_client,dos);
					
					// String
				
						writeString(this.Etat_civil,dos);
					
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
		
						this.Categorie_d_age = readString(dis,ois);
					
						this.active_msg_vocaux = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Categorie_d_age = readString(dis,objectIn);
					
						this.active_msg_vocaux = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.Categorie_d_age, dos, oos);
					
						writeString(this.active_msg_vocaux, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.Categorie_d_age, dos, objectOut);
					
						writeString(this.active_msg_vocaux, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id_client="+id_client);
		sb.append(",Categorie_d_age="+Categorie_d_age);
		sb.append(",Etat_civil="+Etat_civil);
		sb.append(",active_msg_vocaux="+active_msg_vocaux);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id_client, other.id_client);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Etat_civil, other.Etat_civil);
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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_1 - inputs:(after_tDBInput_4) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row3,row4,row2) outputs:(fact)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:s+/iP9B++HYkURg+5nzG1gIkIUbVCBsLqa3OL/sj5cPq");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + "127.0.0.1" + ":" + "3306" + "/" + "bd_pfe" + "?" + properties_tDBInput_1;
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  `dim_client_tt`.`id_client`, \n  `dim_client_tt`.`Catégorie_d'âge`, \n  `dim_client_tt`.`Etat_civil`, \n  `dim_c"
+"lient_tt`.`active_msg_vocaux`\nFROM `dim_client_tt`";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row2.id_client = null;
							} else {
	                         		
        	row2.id_client = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row2.Categorie_d_age = null;
							} else {
	                         		
        	row2.Categorie_d_age = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row2.Etat_civil = null;
							} else {
	                         		
        	row2.Etat_civil = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row2.active_msg_vocaux = null;
							} else {
	                         		
        	row2.active_msg_vocaux = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.id_client = row2.id_client;
				
				row2_HashRow.Categorie_d_age = row2.Categorie_d_age;
				
				row2_HashRow.Etat_civil = row2.Etat_civil;
				
				row2_HashRow.active_msg_vocaux = row2.active_msg_vocaux;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
		
}

		   globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
		


 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
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
        final fact_client_churn_tt fact_client_churn_ttClass = new fact_client_churn_tt();

        int exitCode = fact_client_churn_ttClass.runJobInTOS(args);

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
            java.io.InputStream inContext = fact_client_churn_tt.class.getClassLoader().getResourceAsStream("projet_pfe/fact_client_churn_tt_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = fact_client_churn_tt.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
errorCode = null;tDBInput_4Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_4) {
globalMap.put("tDBInput_4_SUBPROCESS_STATE", -1);

e_tDBInput_4.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : fact_client_churn_tt");
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
 *     201006 characters generated by Talend Open Studio for Big Data 
 *     on the 2 juin 2025, 17:00:41 GMT+01:00
 ************************************************************************************************/
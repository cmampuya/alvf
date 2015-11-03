/**
 * 
 */
package fr.lavoie.france.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.lavoie.france.constants.TableAndColumnConstant;

/**
 * @author chrmampu
 *
 */
public class InitialisationApp {

	private static Properties configProp = new Properties();
	public static DBConfiguration dbConfiguration = null;
	
	public InitialisationApp(){
		//Private constructor to restrict new instances
	      InputStream in = this.getClass().getClassLoader().getResourceAsStream("db_config.properties");
	      System.out.println("Read all properties from file");
	      try {
	          configProp.load(in);
	          
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	

	public static DBConfiguration loadParams() {
		
		dbConfiguration = new DBConfiguration();
		
		dbConfiguration.setDbName(configProp.getProperty(TableAndColumnConstant.DBNAME).trim());
		dbConfiguration.setServer(configProp.getProperty(TableAndColumnConstant.SERVER).trim());
		dbConfiguration.setDriver(configProp.getProperty(TableAndColumnConstant.DRIVER).trim());
		dbConfiguration.setUrl(configProp.getProperty(TableAndColumnConstant.URL).trim());
		dbConfiguration.setPort(Integer.parseInt(configProp.getProperty(TableAndColumnConstant.PORT)));
		dbConfiguration.setUser(configProp.getProperty(TableAndColumnConstant.USER).trim());
		//dbConfiguration.setPassword(configProp.getProperty(TableAndColumnConstant.PASSWORD).trim());
		
		return dbConfiguration;
	}
}

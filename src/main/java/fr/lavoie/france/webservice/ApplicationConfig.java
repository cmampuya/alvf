package fr.lavoie.france.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.lavoie.france.utils.InitialisationApp;

@ApplicationPath("lavoie")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<Class<?>>();
		addRestResourceClasses(resources);
		
		return resources;
	}
	
	private void addRestResourceClasses(Set<Class<?>> resources){
		resources.add(fr.lavoie.france.service.DiscipleServiceImpl.class);
	}
}

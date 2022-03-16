package com.mtit.osgi.itemserviceprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext Context) throws Exception {
		
		System.out.println("Publisher Starter");
		BookItemService publishBookService = new BookItemServiceImpl();
		publishServiceRegistration = Context.registerService(BookItemService.class.getName(),publishBookService , null);
		
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Publisher stop.");
		publishServiceRegistration.unregister();
	}

}
package com.mtit.osgi.merchantserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.itemserviceprovider.BookItemService;

public class Activator implements BundleActivator {

	ServiceReference serviceReferenceItem;
	
	
	public void start(BundleContext Context) throws Exception {
		System.out.println("Start Consumer Service");
		serviceReferenceItem = Context.getServiceReference(BookItemService.class.getName());
		BookItemService bookItemService = (BookItemService)Context.getService(serviceReferenceItem);
		System.out.println(bookItemService.publishBooks());
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Good Bye");
	    Context.ungetService(serviceReferenceItem);
	}

}

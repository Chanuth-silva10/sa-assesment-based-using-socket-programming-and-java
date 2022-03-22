package com.mtit.osgi.orderservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration CusOrderServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Order Service Starts");
		CusOrderService orderService = new CusOrderServiceImpl();
		CusOrderServiceRegistration = context.registerService(CusOrderService.class.getName(), orderService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Thank You! for using Order Service");
		CusOrderServiceRegistration.unregister();
	}

}

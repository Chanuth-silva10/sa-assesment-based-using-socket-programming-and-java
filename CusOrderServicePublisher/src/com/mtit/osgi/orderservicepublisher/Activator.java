package com.mtit.osgi.orderservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration orderServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Order Service Starts");
		OrderService orderService = new OrderServiceImpl();
		orderServiceRegistration = context.registerService(OrderService.class.getName(), orderService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Thank You! for using Order Service");
		orderServiceRegistration.unregister();
	}

}

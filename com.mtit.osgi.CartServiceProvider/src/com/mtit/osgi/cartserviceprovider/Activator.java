package com.mtit.osgi.cartserviceprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration cartServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Cart Service Starts");
		CartService cartService = new CartServiceImpl();
		cartServiceRegistration = context.registerService(CartService.class.getName(), cartService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Thank You! for using Cart Service");
		cartServiceRegistration.unregister();
	}

}


public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}


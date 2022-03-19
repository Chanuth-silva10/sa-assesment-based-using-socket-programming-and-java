package com.mtit.osgi.employeeserviceprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext Context) throws Exception {
		
		System.out.println("Publisher Employee Management Starter");
		EmployeeService publishEmployeeService = new EmployeeServiceImpl();
		publishServiceRegistration = Context.registerService(EmployeeService.class.getName(),publishEmployeeService , null);
		
	}
	public void stop(BundleContext Context) throws Exception {
		System.out.println("Publisher Employee Management stop.");
		publishServiceRegistration.unregister();
	}

}

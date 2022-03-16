package addtocartserviceprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration cartServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Add to Cart Service Starts. Lets go to your Services and started.");
		AddToCartService cartService = new AddToCartServiceImpl();
		cartServiceRegistration = context.registerService(AddToCartService.class.getName(), cartService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Thank You! for using Addto Cart Service. ");
		cartServiceRegistration.unregister();
	}

}

package com.scb.rdm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAspectSupport {

	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		System.out.println("Configuring the TransactionManager as "
				+ transactionManager.getClass().getCanonicalName());
		this.transactionManager = transactionManager;
	}

	public PlatformTransactionManager getTransactionManager() {
		if (transactionManager == null) {
			System.out.println("Platform Transaction Manager is Null");
			BundleContext bundleContext = FrameworkUtil.getBundle(
					PlatformTransactionManager.class).getBundleContext();
			ServiceReference<PlatformTransactionManager> reference = bundleContext
					.getServiceReference(PlatformTransactionManager.class);
			if (reference != null) {
				this.transactionManager = bundleContext.getService(reference);
			}
		}
		return this.transactionManager;
	}

	@Around("execution(@Transactional  * *.*(..))")
	public Object execute(ProceedingJoinPoint pjp) {
		PlatformTransactionManager platformTransactionManager = getTransactionManager();
		System.out.println("Executing the Method "
				+ pjp.getSignature().getName());
		Object result = null;
		DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		paramTransactionDefinition
				.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
		System.out.println("Transaction Manager " + platformTransactionManager);
		System.out.println("Param Transaction Definition "
				+ paramTransactionDefinition);
		TransactionStatus status = platformTransactionManager
				.getTransaction(paramTransactionDefinition);
		System.out.println("The Transaction Status retrieved is " + status);
		try {
			result = pjp.proceed();
			platformTransactionManager.commit(status);
		} catch (Throwable e) {
			platformTransactionManager.rollback(status);
			return result;
		}
		return result;
	}
}

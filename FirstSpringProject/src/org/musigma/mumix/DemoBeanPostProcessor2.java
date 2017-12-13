package org.musigma.mumix;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor2 implements BeanPostProcessor, Ordered{

	//arg0 is the bean instance
		//arg1 is bean instance
		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName)
				throws BeansException {
			// TODO Auto-generated method stub
			System.out.println("DemoBeanPostProcessor2 --Processing bean instance AFTER the initialization (i.e just after the init life cycle event) of :"+beanName);
			System.out.println(bean.hashCode());
			return bean;
		}

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName)
				throws BeansException {
			// TODO Auto-generated method stub
			System.out.println(" DemoBeanPostProcessor2 --Processing bean instance BEFORE the initialization (i.e just after sprint initializes beans and before the init life cycle event) of :"+beanName);
			System.out.println(bean);
			return bean;
		}

		@Override
		public int getOrder() {
			// TODO Auto-generated method stub
			return 0;
		}
}

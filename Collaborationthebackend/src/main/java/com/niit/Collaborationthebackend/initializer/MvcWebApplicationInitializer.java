package com.niit.Collaborationthebackend.initializer;



import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.Collaborationthebackend.config.CORSFilter;
import com.niit.Collaborationthebackend.config.EmailConfig;
import com.niit.Collaborationthebackend.config.HibernateConfig;
import com.niit.Collaborationthebackend.config.MvcConfig;
import com.niit.Collaborationthebackend.config.RootConfig;


public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {HibernateConfig.class, RootConfig.class, EmailConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
    protected Filter[] getServletFilters() {
   	 Filter [] singleton = { new CORSFilter() };
   	 return singleton;
    }
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		 // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
				
		registration.setMultipartConfig(multipartConfigElement);
		super.customizeRegistration(registration);
	}
	
}
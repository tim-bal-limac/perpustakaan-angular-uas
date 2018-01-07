/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballimactim.perpustakaanangularuas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author AguzR
 */
@Configuration
public class WebConfig
		extends WebMvcConfigurerAdapter{

			@Override
			public void addViewControllers(
				ViewControllerRegistry reg){
			reg.addViewController("/")
                                .setViewName("daftar-buku");
            reg.addViewController("/keluarin-donk")
                                .setViewName("coba");
            reg.addViewController("/list")
                                .setViewName("daftar-buku"); 
			reg.addViewController("/tambah")
                                .setViewName("form");   
            reg.addViewController("/form-edit")
                                .setViewName("edit");                    

		}

}
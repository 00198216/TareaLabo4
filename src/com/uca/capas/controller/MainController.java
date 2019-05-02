package com.uca.capas.controller;



//import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Date;


import javax.validation.Valid;

import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.uca.domain.Product;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Product product= new Product();
		mav.addObject("message", "Bienvenidos a MVC");
		mav.addObject("product",product);
		mav.setViewName("main");
		return mav;
	}
	

	@InitBinder     
	public void dataBinding(WebDataBinder binder){
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 dateFormat.setLenient(false);
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(dateFormat,true));   
	     
	     binder.setBindingErrorProcessor(new DefaultBindingErrorProcessor() {
	         @Override
	         public void processPropertyAccessException(PropertyAccessException ex, BindingResult bindingResult) {
	             String propertyName = ex.getPropertyName();
	             Object value = ex.getValue();
	             bindingResult.addError(new FieldError(bindingResult.getObjectName(), propertyName, value, true,
	             new String[] { "moderation.field.error" }, new Object[] { propertyName, value },
	             "Formato no valido de " + propertyName + " para el valor (" + value + ")! Ingrese una fecha valida."));
	         }
	     });
	}
	
	@RequestMapping("/formData")
	public ModelAndView form(@Valid @ModelAttribute Product product,BindingResult result) {
		ModelAndView mav= new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("main");
		}
		else {
			mav.addObject("message","Producto agregada con exito!");
			mav.setViewName("form");
		}
		return mav;
    }
	
	
	
		
	}
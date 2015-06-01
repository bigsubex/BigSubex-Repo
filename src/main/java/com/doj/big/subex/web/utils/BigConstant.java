package com.doj.big.subex.web.utils;

/**
 * @author Dinesh.Rajput
 *
 */
public interface BigConstant {
	
	String HOME = "home";
	String INDEX = "index";
	String USERLOGIN = "userlogin";
	String GUESTLOGIN = "guestlogin";
	String USERSIGNIN = "user.register";
	String USERCOMPANY = "user.register.company";
	String EMPLOYEESEDIT = "employees.edit";
	String EMPLOYEES = "list.employees";
	String PRODUCT_SEARCH = "products.old";
	String PRODUCT_DETAIL = "products.new";
	String SUPPLIERSHOW = "supplier.show";
	String FORGOT_PASSWORD = "user.lostpassword";
	String CHANGE_PASSWORD = "user.changepassword";
	
	String ERROR404 = "404";
	String ERRORPAGE = "/*";
	
	String ROOTPAGE = "/";
	String INDEXPAGE = "/indexc";
	String USER = "/user";
	String LOGIN_PAGE = "/login";
	String USER_LOGIN_PAGE = "/login/user";
	String GUEST = "/guest";
	String GUEST_LOGIN_PAGE = "/login/guest";
	String USER_SIGNIN_PAGE = "/user/register";
	String USER_COMPANY_PAGE = "/company/register";
	String EMPLOYEE_REGISTRATION_PAGE = "/employee/register";
	String EMPLOYEES_PAGE = "/employees";
	String PRODUCT_SEARCH_PAGE = "/products/search";
	String PRODUCT_DETAIL_PAGE = "/products";
	String SUPPLIER_SHOW_PAGE = "/supplier/show";
	String FORGOT_PASSWORD_PAGE = "/user/lostpassword";
	String CHANGE_PASSWORD_PAGE = "/change-password";
	
	String IMAGEROOTURL = "images/";
	String JSROOTURL = "js/";
	String CSSROOTURL = "css/";
	
	//Local development
	String CONTEXTROOT = "/BigSubex";
	//For Production
	//String CONTEXTROOT = "/BigSubex";
	
	String TILES = "classpath:tiles-defs.xml";
}

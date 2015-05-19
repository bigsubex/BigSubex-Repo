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
	String PRODUCT_PAGE = "products.new";
	String SUPPLIERSHOW = "supplier.show";
	String FORGOTPASSWORD = "user.lostpassword";
	
	String ERROR404 = "404";
	String ERRORPAGE = "/*";
	
	String ROOTPAGE = "/";
	String INDEXPAGE = "/indexc";
	String USER = "/user";
	String LOGINPAGE = "/login";
	String USERLOGINPAGE = "/login/user";
	String GUEST = "/guest";
	String GUESTLOGINPAGE = "/login/guest";
	String USERSIGNINPAGE = "/user/register";
	String USERCOMPANYPAGE = "/company/register";
	String EMPLOYEEREGISTRATIONPAGE = "/employee/register";
	String EMPLOYEESPAGE = "/employees";
	String PRODUCT_SEARCH_PAGE = "/products/search";
	String PRODUCT_PROTOKOL_PAGE = "/products";
	String SUPPLIERSHOWPAGE = "/supplier/show";
	String FORGOTPASSWORDPAGE = "/user/lostpassword";
	
	String IMAGEROOTURL = "images/";
	String JSROOTURL = "js/";
	String CSSROOTURL = "css/";
	
	//Local development
	String CONTEXTROOT = "/BigSubex";
	//For Production
	//String CONTEXTROOT = "/BigSubex";
	
	String TILES = "classpath:tiles-defs.xml";
}

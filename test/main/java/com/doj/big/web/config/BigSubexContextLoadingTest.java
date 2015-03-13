package com.doj.big.web.config;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.doj.big.subex.web.config.BigSubexWebMvcContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BigSubexWebMvcContextConfig.class })
@WebAppConfiguration
public class BigSubexContextLoadingTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
    private WebApplicationContext context;
	
    @Test
    public void testLoading() {
        Assert.assertNotNull(this.context);
    }
    
}

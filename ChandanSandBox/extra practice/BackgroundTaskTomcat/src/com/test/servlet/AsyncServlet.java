package com.test.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.AsyncRequestProcessor;
import com.test.listener.MyAsyncListener;
	 
	
	@SuppressWarnings("serial")
	@WebServlet(urlPatterns = "/AsyncServlet", asyncSupported=true)
	public class AsyncServlet extends HttpServlet {
	    private static final Logger logger = Logger.getLogger("com.test");
	 
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response)
	        throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response)
	        throws ServletException, IOException {
	        logger.info("AsyncServlet: Processing request: " +
	                    request.getParameter("id") + ". on thread: " +
	                    Thread.currentThread().getId() + ":" +
	                    Thread.currentThread().getName() + "[" +
	                    new Date() + "]");
	 
	                request.setAttribute("receivedAt", new Date());
	 
	        boolean dispatch = false;
	        String dispatchParam = request.getParameter("dispatch");
	        if ("true".equalsIgnoreCase(dispatchParam)) dispatch = true;
	 
	        boolean timeout = false;
	        String timeoutParam = request.getParameter("timeout");
	        if ("true".equalsIgnoreCase(timeoutParam)) timeout = true;
	 
	        AsyncContext asyncCtx = request.startAsync();
	        asyncCtx.addListener(new MyAsyncListener());
	        if (timeout) {
	            asyncCtx.setTimeout(1000);
	        }
	 
	        Executor executor =
	            (Executor)request.getServletContext().getAttribute("executor");
	        //delegate long running process to an "async" thread
	        executor.execute(new AsyncRequestProcessor(asyncCtx, dispatch));
	 
	        logger.info("AsyncServlet: Returning after request: " +
	                    request.getParameter("id") + ". on thread: " +
	                    Thread.currentThread().getId() + ":" +
	                    Thread.currentThread().getName()+ "[" +
	                    new Date() + "]");
	 
	                //Watch out for concurrency issues at this point
	                // between the "main" thread and the "async" thread
	                // main thread returns now -
	                // - returning from service() does not commit the response
	                // - so client still waits patiently
	    }
	}
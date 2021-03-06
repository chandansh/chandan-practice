package com.edujini.ws.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/hws")
public class HelloWorldService {

	public HelloWorldService() {
		System.out.println(getClass().getName() + ":: instantiated...");
	}

	@GET
	@Path("/hw")
	@Produces("text/plain")
	public String sayHelloWorld() {
		return "Hello, World!";
	}

	@GET
	@Path("/hwn/{username}")
	@Produces("text/plain")
	public String sayHelloWorld(@PathParam("username") String name) {
		return "Hello, " + name + "!";
	}

	StatusInfoBean statusInfoBean = new StatusInfoBean();

	{
		statusInfoBean.jobs
				.add(new JobInfoBean("sample.doc", "printing...", 13));
		statusInfoBean.jobs.add(new JobInfoBean("sample1.doc", "printing...",
				12));
		statusInfoBean.jobs.add(new JobInfoBean("sample2.doc", "printing...",
				14));
	}

	@POST
	@Path("/sjson")
	@Produces("application/json")
	public StatusInfoBean getStatus() {
		return statusInfoBean;
	}

	@PUT
	@Consumes("application/json")
	public synchronized void setStatus(StatusInfoBean status) {
		this.statusInfoBean = status;
	}

	@POST
	@Path("/cities")
	@Produces("application/json")
	public SvcResponse getCities() {
		List<City> cities = new ArrayList<City>();
		for (int i = 0; i < 5; i++) {
			cities.add(new City("delhi", 1000));
		}
		SvcResponse resp = new SvcResponse(200, "this is result", cities);
		return resp;
	}

	@POST
	@Path("/ss")
	// @Consumes({"application/json"})
	@Produces("text/plain")
	public String setStatus(@FormParam("status") String r,
			@FormParam("tonerRemaining") int tr) {
		System.out.println("Status: " + r + ", tr: " + tr);
		// this.statusInfoBean = status;
		return "Hello: " + r + "\nTr: " + tr;
	}

	@POST
	@Path("/re")
	@Produces("text/plain")
	public String hello(@Context HttpServletRequest req,
			@FormParam("status") String r) {

		HttpSession session = req.getSession(true);
		Object foo = session.getAttribute("foo");
		if (foo != null) {
			System.out.println(foo.toString());
		} else {
			foo = "bar";
			session.setAttribute("foo", "bar");
		}
		return foo.toString() + "\n status : " + r;

	}
}

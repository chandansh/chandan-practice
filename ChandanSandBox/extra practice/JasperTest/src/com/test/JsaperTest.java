package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JsaperTest {

	public static void main(String[] args) {

		Cart cart = new Cart();
		cart.setOrderId(123455);
		cart.setCartTotal(34.78);
		
		List<CartItemDetail> details = new ArrayList<CartItemDetail>();
		
		details.add(new CartItemDetail("mysku1", "my name1", 12, 25.0, 400, ""));
		details.add(new CartItemDetail("mysku1", "my name1", 12, 25.0, 400, ""));
		details.add(new CartItemDetail("mysku1", "my name1", 12, 25.0, 400, ""));
		
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(new CartItem(12, "my Recipe", "Delhi", 23.78, "", details));
		
		cart.setCartItems(items);
		
		try {
			generateReport("myReport.pdf", cart);
		} catch (JRException e) {
			e.printStackTrace();
		}
		System.out.println("done ");
	}

	private static JasperReport generateReport(String docFile, Cart cart)
			throws JRException {
		JasperReport jasperReport = JasperCompileManager
				.compileReport("helloworld.jrxml");
		List<CartItemDetail> details = new ArrayList<CartItemDetail>();
		for(CartItem item: cart.getCartItems()){
			details.addAll(item.getCartItemDetails());
		}
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("name", "Hello Chandan");
		parameter.put("orderId",cart.getOrderId());
		parameter.put("logo", "http://th1197.photobucket.com/albums/aa437/donmacphee88/th_facebook-logo-resized-image-100x100.png");
		

		try {
			 JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(details);
//			JasperPrint jasperPrint = JasperFillManager.fillReport(
//					jasperReport, parameter, new JREmptyDataSource());
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameter, ds);
			JasperExportManager.exportReportToPdfFile(jasperPrint, docFile);

		} catch (JRException jre) {
			System.out.println("Exception in PDF Creation:" + jre);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return jasperReport;
	}

}

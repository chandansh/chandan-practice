package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileCopier {

	public static void main(String args[]) throws Exception {

		File inboxDir = new File("Inbox");
		File outboxDir = new File("Outbox");

		outboxDir.mkdir();
		File[] files = inboxDir.listFiles();
		for (File source : files)
			if (source.isFile()) {
				File dest = new File(outboxDir.getPath() + File.separator
						+ source.getName());
				copyFile(source, dest);
			}
		
		System.out.println("file copied...");
	}

	public static void copyFile(File source, File dest) throws IOException {

		OutputStream out = new FileOutputStream(dest);
		byte[] buffer = new byte[(int) source.length()];
		FileInputStream in = new FileInputStream(source);
		in.read(buffer);
		try {
			out.write(buffer);
		} finally {
			out.close();
			in.close();
		}
	}
}
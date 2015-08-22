package com.wxisme.idb1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ��ȡ�û����룬���û�����
 * @author wxisme
 *
 */

public class GetInput {
	
	public static String getInput() {
		Scanner scan = new Scanner(System.in);
		StringBuilder SQLstr = new StringBuilder();
		SQLstr.append(scan.next());   //��һ���ַ���
		if(SQLstr.toString().equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		if(SQLstr.toString().equalsIgnoreCase("change")) {
			String s = scan.next();
			if(s.equalsIgnoreCase("user")) {
				return "change user";
			}
			else {
				PrintInfo.printSyntaxError();
				return "err";
			}
		}
		if(SQLstr.toString().equalsIgnoreCase("help")) {
			String str = scan.next();
			if(str.equalsIgnoreCase("user")) {
				return "help user";
			}
			else if(str.equalsIgnoreCase("table")) {
				return "help table " + scan.next();
			}
			else if(str.equalsIgnoreCase("database")) {
				return "help database " + scan.next();
			}
			else {
				//PrintInfo.printSyntaxError();
				return "err;";
			}
		}
		if(SQLstr.toString().equalsIgnoreCase("show")) {
			if(scan.next().equalsIgnoreCase("cmd")) {
				return "show cmd";
			}
			else {
				//PrintInfo.printSyntaxError();
				return "err;";
			}
		}
		
		while(true) {
			SQLstr.append(" " + scan.next());
			if(SQLstr.charAt(SQLstr.length()-1) == ';')
				break;
		}
		return SQLstr.toString();
	}
	
	public static UserInfo getUser() {
		Scanner scan = new Scanner(System.in);
		
		String user = scan.next();
		if(user.equalsIgnoreCase("new")) {
			String user2 = scan.next();
			String pswd2 = scan.next();
			File file = new File("src" + File.separator + "userfile" + File.separator
					+ user2 + pswd2);
			file.mkdir();
			
			//�趨�洢�û���Ϣ����Ȩ�޵����ݽṹ
			File uFile = new File("src" + File.separator + "userfile" + File.separator
					+ "userInfo.txt");
			
			PrintWriter pw = null;
			
			try {
				pw = new PrintWriter(new FileWriter(uFile, true));
				//��ʽ���û���Ϣ
				StringBuilder uinfo = new StringBuilder();
				pw.println("username: " + user2 + "\n");
				pw.println("password: " + pswd2 + "\n");
				pw.println("ps: DBA\n");
				//uinfo.append("username: " + user2 + "\n");
				//uinfo.append("password: " + pswd2 + "\n");
				//uinfo.append("ps: DBA\n");
				//pw.print(uinfo);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				pw.close();
			}
			
			
			
			return new UserInfo(user2, pswd2);
		}
		else {
			String pswd = scan.next();
			return new UserInfo(user, pswd);
		}
	}

}

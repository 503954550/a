package com.test.run;

import java.lang.reflect.*;

public class TestReflect {
	private String name;
	private String age;

	public TestReflect(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		try {
			Class<?> strClass = Class.forName("com.test.run.Test");
			Method m[] = strClass.getDeclaredMethods();
			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
		} catch (Throwable e) {
			System.err.println(e);
		}

	}

	public static void fun(Object obj) throws Exception {
		Field[] fields = obj.getClass().getDeclaredFields();
		System.out.println("�滻֮ǰ��:");
		for (Field field : fields) {
			System.out.println(field.getName() + "=" + field.get(obj));
			if (field.getType().equals(java.lang.String.class)) {
				field.setAccessible(true);
				// ��������Ϊtrue�ſ����޸ĳ�Ա����
				String org = (String) field.get(obj);
				field.set(obj, org.replaceAll("a", "b"));
			}
		}
		System.out.println("�滻֮��ģ� ");
		for (Field field : fields) {
			System.out.println(field.getName() + "=" + field.get(obj));
		}
	}
}

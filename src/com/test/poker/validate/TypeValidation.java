package com.test.poker.validate;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.type.Type;

public class TypeValidation {
	private static List<Class<Type>> typeList = null;
	static{
		try {
			typeList = getAllAssignedClass(Type.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Type validate(List<Poker> list) {
		try {
			for(Class<Type> c : typeList){
				if(c.newInstance().validate(list)){
					Type type = c.newInstance();
					type.cloneList(list);
					return type;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 *  获取同一路径下所有子类或接口实现类 
	 * @param cls
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<Class<T>> getAllAssignedClass(Class<T> cls) throws IOException, ClassNotFoundException {
		List<Class<T>> classes = new ArrayList<Class<T>>();
		for (Class<T> c : getClasses(cls)) {
			if (cls.isAssignableFrom(c) && !cls.equals(c)) {
				classes.add(c);
			}
		}
		return classes;
	}
	
	/**
	 * 取得当前类路径下的所有类 
	 * @param cls
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<Class<T>> getClasses(Class<T> cls) throws IOException,
			ClassNotFoundException {
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		return getClasses(new File(url.getFile()), pk);
	}
	
	/**
	 * 迭代查找类 
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private static <T> List<Class<T>> getClasses(File dir, String pk) throws ClassNotFoundException {  
        List<Class<T>> classes = new ArrayList<Class<T>>();  
        if (!dir.exists()) {  
            return classes;  
        }  
        for (File f : dir.listFiles()) {  
            if (f.isDirectory()) {  
                classes.addAll((Collection<? extends Class<T>>) getClasses(f, pk + "." + f.getName()));  
            }  
            String name = f.getName();  
            if (name.endsWith(".class")) {  
                classes.add((Class<T>) Class.forName(pk + "." + name.substring(0, name.length() - 6)));  
            }  
        }  
        return classes;
    }  
}

package com.superm.easy.cloud.commons.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {

	public static Object getProperty(Object o, String fieldName) {
		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		String getMethodName = "get" + firstLetter + fieldName.substring(1);
		Method getMethod;
		try {
			getMethod = o.getClass().getMethod(getMethodName, new Class[] {});
			Object value = getMethod.invoke(o, new Object[] {});
			return value;
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 拷贝
	 * 
	 * @param source
	 * @param target
	 * @isCover 是否覆盖。true：source完全copy覆盖target；false：source中的非空属性copy到target，
	 *          不影响target的其他属性
	 */
	public static void copyProperties(Object source, Object target, boolean isCover) {
		if (isCover) {
			org.springframework.beans.BeanUtils.copyProperties(source, target);
		}
		else {
			Class clazz = source.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				// System.out.println("----    " + f.getName());
				String fieldName = f.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Method getMethod;
				try {
					getMethod = clazz.getMethod(getMethodName, new Class[] {});
					Object value;
					value = getMethod.invoke(source, new Object[] {});

					if (value == null) {
						continue;
					}
					Method setMethod = clazz.getMethod(setMethodName, f.getType());
					setMethod.invoke(target, value);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	public static void main (String[] args){
//		ChargeAmountByParkinglot chargeAmountByParkinglot = new ChargeAmountByParkinglot(1, 1, 1, "2", "33", 22, "2012");
//		ChargeAmountInfoByParkinglotVo chargeAmountInfoByParkinglotVo = new ChargeAmountInfoByParkinglotVo();
//		copyProperties(chargeAmountByParkinglot, chargeAmountInfoByParkinglotVo, true);
//		chargeAmountInfoByParkinglotVo.setLotId(chargeAmountByParkinglot.getParkinglot().getId());
//		chargeAmountInfoByParkinglotVo.setLotName(chargeAmountByParkinglot.getParkinglot().getName());
//		System.out.println(chargeAmountInfoByParkinglotVo.getNomalCharge()+"," + chargeAmountInfoByParkinglotVo.getEscapeCharge()+ "," +chargeAmountInfoByParkinglotVo.getRecoveredCharge()+ "," + chargeAmountInfoByParkinglotVo.getLotId() +","+ chargeAmountInfoByParkinglotVo.getLotName());
	}

	// public static PropertyDescriptor[] getPropertyDescriptors(Class clazz)
	// throws BeansException
	// {
	// CachedIntrospectionResults cr =
	// CachedIntrospectionResults.forClass(clazz);
	// return cr.getBeanInfo().getPropertyDescriptors();
	// }
}

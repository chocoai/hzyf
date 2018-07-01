package com.cd.zjyf.utils;

import com.alibaba.fastjson.JSON;

import com.cd.zjyf.annotation.Invalid;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExcelUtils {
	
	private static Logger log = LoggerFactory.getLogger(ExcelUtils.class);

	
	/**
	 * 用于报表单页导出
	 * 
	 * @param templatesPath
	 *            模板在项目中的路径
	 * @param dataset 按实体类的字段顺序导出（实体类的字段顺序一定要对！）
	 * @param out 输出流
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static <T> void exportExcel(String templatesPath, String sheetName, Collection<T> dataset, OutputStream out)
			throws FileNotFoundException, IOException {
		String pattern = "yyyy-MM-dd HH:mm:ss";// 暂时时间格式写死
		// URL resource =
		// ExcelUtils.class.getClassLoader().getResource("report/templates/aa.xls");
		InputStream inputStream=ExcelUtils.class.getResourceAsStream(templatesPath);

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);// 得到这个excel表格对象


		// workbook.removeSheetAt(workbook.getSheetIndex(""));这个用于删除其它所有的sheet
		Iterator<Sheet> sheets = workbook.sheetIterator();
		ArrayList<String> removeSheetNames = new ArrayList<>();
		while (sheets.hasNext()) {
			Sheet s = sheets.next();
			if (!s.getSheetName().equals(sheetName)) {
				removeSheetNames.add(s.getSheetName());
			}
		}
		for (String removeSheetName : removeSheetNames) {
			workbook.removeSheetAt(workbook.getSheetIndex(removeSheetName));
		}

		// 获取目标sheet
		HSSFSheet sheet = workbook.getSheet(sheetName);
		//重置sheet1的名称
		workbook.setSheetName(0, "Sheet1");

		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 产生表格标题行
		HSSFRow row = null;
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();

		// index=excel模板读出的行数
		int rows = sheet.getPhysicalNumberOfRows();

		// System.out.println("行数："+rows);

		int index = rows;
		while (it.hasNext()) {
			row = (HSSFRow) sheet.createRow(index++);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0,j=0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                //注解过滤这里
                Invalid invalid = field.getAnnotation(Invalid.class);
                if(invalid != null) {
                   continue;
                }

                HSSFCell cell = (HSSFCell) row.createCell(j++);
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					Class<? extends Object> tclass = t.getClass();
					Method getMethod = tclass.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					String textValue = null;
					if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
						row.setHeightInPoints(20);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value != null ? value.toString() : "";
						row.setHeightInPoints(20);
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != "") {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							cell.setCellValue(textValue);
						}
					}
				} catch (Exception e) {
					log.error("excel导出错误",e);
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	


		

}





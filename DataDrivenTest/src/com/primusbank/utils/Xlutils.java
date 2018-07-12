package com.primusbank.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Xlutils 
{
	public static Workbook wb;
	public static FileInputStream fi;
	public	static FileOutputStream fo;
	 static Sheet ws;
	 static Row r;
	 static CellStyle style;
	 static Cell c;	
public static int getRowcount(String Xlfile,String Xlsheet) throws IOException
{	
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	int rowcount=ws.getLastRowNum();
	return rowcount;
}
public static int getCellcount(String Xlfile,String Xlsheet,int rownum) throws IOException
{	
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	r=ws.getRow(rownum);
	 int cellcount=r.getLastCellNum();
	 return cellcount;
}
public static String getCelldata(String Xlfile,String Xlsheet,int rownum,int colnum) throws IOException
{	
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	r=ws.getRow(rownum);
	c=r.getCell(colnum);
	String data;
	try 
	{
	data=c.getStringCellValue();	
	} 
	catch (Exception e) 
	{
		data=" ";
	}
	fi.close();
	wb.close();
	return data;
}
public static void setCelldata(String Xlfile,String Xlsheet,int rownum,int colnum,String data) throws IOException
{	
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	r=ws.getRow(rownum);
	c=r.getCell(colnum);
	c.setCellValue(data);
	fo=new FileOutputStream(Xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
public static void fillGreencolour(String Xlfile,String Xlsheet,int rownum,int colnum) throws IOException
{	
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	r=ws.getRow(rownum);
	c=r.getCell(colnum);
	style=wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	c.setCellStyle(style);
	fo=new FileOutputStream(Xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
public static void fillRedcolour(String Xlfile,String Xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(Xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(Xlsheet);
	r=ws.getRow(rownum);
	c=r.getCell(colnum);	
	style=wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	c.setCellStyle(style);
	fo=new FileOutputStream(Xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
}
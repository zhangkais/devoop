package OperationExcel.Creat;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * HSSF － 提供读写Microsoft Excel XLS格式档案的功能。
  XSSF － 提供读写Microsoft Excel OOXML XLSX格式档案的功能。
  HWPF － 提供读写Microsoft Word DOC97格式档案的功能。
  XWPF － 提供读写Microsoft Word DOC2003格式档案的功能。
  HSLF － 提供读写Microsoft PowerPoint格式档案的功能。
  HDGF － 提供读Microsoft Visio格式档案的功能。
  HPBF － 提供读Microsoft Publisher格式档案的功能。
  HSMF － 提供读Microsoft Outlook格式档案的功能。
 */

public class CreatFile {
    /**
     * 1、	生成两个Excel文档，一个为xls格式，另一个为xlsx格式，
     *    在这两个Excel文件中分别添加一个名为”Demo”的Sheet
     * ，在此Sheet中填写一个4列4行的表格数据，内容随意，但必须包含数字列、字符列、日期列。
     */
    @Test
    public  void creatWorkbook_xls()
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();

        FileOutputStream fileOut = null;
        try {
            String[] title={"序号","姓名","生日","入团时间"};                                 //给出列名
            fileOut = new FileOutputStream("D:/test.xls");
                                                     //创建文件xls
            Sheet rs = workbook.createSheet("Demo");               //创建一个子表
            HSSFRow a= (HSSFRow) rs.createRow(0);                        //在子表中创建以上数据
            HSSFCell c=null;                                                      //声明一个单元格
             for(int i=0;i<title.length;i++)
             {
                 c=a.createCell(i);
                 c.setCellValue(title[i]);
             }

             String[] data={"1","张三","1990-1-12","2010-10-20"};
            HSSFRow b= (HSSFRow) rs.createRow(1);                    //在子表中创建以上数据
            SimpleDateFormat as=new SimpleDateFormat("yyyy-MM-dd");
            for(int i=0;i<data.length;i++)
            {
                HSSFCell d=b.createCell(i);                                    //声明一个单元格
                if(data[i].contains("-")||data[i].contains("/"))
                {
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
                    cellStyle.setFillBackgroundColor(HSSFColor.AQUA.index);   //设置背景颜色
                    cellStyle.setFillPattern((short)1);
                    Date  date=as.parse(data[i]);
                    d.setCellValue(date);
                    d.setCellStyle(cellStyle);
                }else {

                    d = b.createCell(i);
                    d.setCellValue(data[i]);

                }
            }
            workbook.write(fileOut);
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void creatWorkbook_xlsx()
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        FileOutputStream fileOut = null;
        try {
            String[] title={"序号","姓名","金币","入团时间"};                                 //给出列名
            fileOut = new FileOutputStream("D:/test.xlsx");
            //创建文件xls
            Sheet rs = workbook.createSheet("Demo");//创建一个子表

            XSSFRow sss= (XSSFRow) rs.createRow(0);
            XSSFCell sc=null;//声明一个单元格



            //第5题  	为4行4列的表格设置一个标题，合并同行的4列单元格。
                sc=sss.createCell(0);
                sc.setCellValue("账号基本信息");                             //创建一个合并单元格
                rs.addMergedRegion(new CellRangeAddress(0,0,0,3));

            XSSFRow a= (XSSFRow) rs.createRow(1);                        //在子表中创建以上数据
            XSSFCell c=null;                                                      //声明一个单元格
            for(int i=0;i<title.length;i++)
            {
                c=a.createCell(i);
                c.setCellValue(title[i]);
            }
            String[] data={"1","李四","1001.5","2010-10-20"};
            XSSFRow b= (XSSFRow) rs.createRow(2);                        //在子表中创建以上数据
            SimpleDateFormat as=new SimpleDateFormat("yyyy-MM-dd");
            for(int i=0;i<data.length;i++)
            {
                XSSFCell d = b.createCell(i);                     //声明一个单元格
                if(i>2)
                {



                    //第7题	设置日期列单元格格式：yyyy/mm/dd
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/mm/dd"));
                    cellStyle.setAlignment(CellStyle.ALIGN_CENTER);                //水平居中
                    cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);    //垂直居中
                    Date  date=as.parse(data[i]);
                    d.setCellValue(date);
                    d.setCellStyle(cellStyle);
                }
                else if (i==2){
                    System.out.println(data[i]);
                    d.setCellValue(data[i]);


                  //  6、	设置数字列单元格格式为带有千分号格式，两位小数：#,##0.00
                    XSSFCellStyle ce = workbook.createCellStyle();
                    XSSFDataFormat format = workbook.createDataFormat();
                    ce.setDataFormat(format.getFormat("$#,##0.00"));
                    d.setCellStyle(ce);
                }
                else if (i==0){
                    XSSFCellStyle cellStyles = workbook.createCellStyle();
                    cellStyles.setAlignment(CellStyle.ALIGN_LEFT);                //水平左居中
                    cellStyles.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

                    d.setCellValue(data[i]);

                    //4、	设置Excel文件单元格格式：黑色实线边框，黄色背景色、蓝色前景色，16号字，隶书，数字列粗斜体字。
                    cellStyles.setFillForegroundColor(IndexedColors.BLUE.getIndex());//设置前景色
                    cellStyles.setFillPattern(CellStyle.SOLID_FOREGROUND);
                    cellStyles.setFillBackgroundColor(IndexedColors.YELLOW.index);//设置背景颜色
                      cellStyles.setFillPattern((short) 2);
//                    cellStyle.setFillForegroundColor(HSSFColor);
                      XSSFFont font = workbook.createFont();
                    font.setFontName("隶书");              //字体样式
                    font.setFontHeightInPoints((short)16);//字体大小
                    font.setItalic(true);                 //是否斜体加粗
                    cellStyles.setFont(font);
                     d.setCellStyle(cellStyles);
                }
                else {

                    CellStyle cellStyless = workbook.createCellStyle();
                    d.setCellValue(data[i]);

                    // 3、	设置Excel文件单元格样式，字符列水平居左、数字列水平居右，日期列水平居中。
                    cellStyless.setAlignment(CellStyle.ALIGN_RIGHT);                //水平左右中
                    cellStyless.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    cellStyle.setBorderBottom(CellStyle.BORDER_THIN); // 底部边框
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 底部边框颜色
                    cellStyle.setBorderLeft(CellStyle.BORDER_THIN);  // 左边边框
                    cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边边框颜色
                    cellStyle.setBorderRight(CellStyle.BORDER_THIN); // 右边边框
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());  // 右边边框颜色
                    cellStyle.setBorderTop(CellStyle.BORDER_THIN); // 上边边框
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());  // 上边边框颜色
                    d.setCellStyle(cellStyless);
                }
            }
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



}

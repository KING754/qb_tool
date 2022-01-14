package com.wejias.qb_tool.helper;

import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.converters.booleanconverter.BooleanStringConverter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class CustomBooleanConverter extends BooleanStringConverter{

    

    @Override
    public Boolean convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) {
        return cellData.getStringValue().equals("T") ? true : false;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Boolean> context) throws Exception {
//        return Converter.super.convertToExcelData(context);
        return context.getValue() ? new WriteCellData<>("T"):new WriteCellData<>("F");
    }
   
}

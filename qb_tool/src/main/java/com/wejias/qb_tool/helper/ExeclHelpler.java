package com.wejias.qb_tool.helper;

import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.wejias.qb_tool.vo.TorrentVO;

public class ExeclHelpler {
    public static void writeExcel(String path, List<TorrentVO> list) {
        EasyExcel.write(path, TorrentVO.class).sheet("qb").doWrite(list);
    }
}

package com.pms.dbview.controller;

import com.ectrip.controller.base.BaseController;
import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import com.pms.dbview.model.compare.CompareTable;
import com.pms.dbview.model.compare.Infornation;
import com.pms.dbview.model.compare.MyComparator;
import com.pms.dbview.service.DBViewService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sunshine on 16/7/21.
 */
@Controller
@RequestMapping("/pms")
public class DbViewController extends BaseController {
    @Resource
    DBViewService dbViewService;

    /**
     * 列表
     *
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(Page page, String tableName) throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        List<PageData> varList = null;
        if (StringUtils.isEmpty(tableName)) {
            pd.put("keywords", null);
            page.setPd(pd);
            varList = dbViewService.listPage(page);
        } else {
            pd.put("keywords", tableName.toUpperCase());
            page.setPd(pd);
            varList = dbViewService.listPage(page);
        }
        mv.setViewName("pms/table_list");
        mv.addObject("varList", varList);
        mv.addObject("pd", pd);
        return mv;
    }

    @RequestMapping(value = "/columns")
    public ModelAndView columnPage(Page page, String tableName) {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        List<PageData> varList = null;
        page.setPd(pd);
        if (StringUtils.isEmpty(tableName)) {
            pd.put("keywords", null);
            page.setPd(pd);
            varList = dbViewService.columnslistPage(page);    //列出Pictures列表
        } else {
            pd.put("keywords", tableName.toUpperCase());
            page.setPd(pd);
            varList = dbViewService.columnslistPage(page);    //列出Pictures列
        }
        mv.setViewName("pms/column_list");
        mv.addObject("varList", varList);
        mv.addObject("pd", pd);
        return mv;
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage(Page page, String tableName) throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        List<PageData> varList = null;
        if (StringUtils.isEmpty(tableName)) {
            pd.put("keywords", null);
            page.setPd(pd);
            varList = dbViewService.indexlistPage(page);    //列出Pictures列表
        } else {
            pd.put("keywords", tableName.toUpperCase());
            page.setPd(pd);
            varList = dbViewService.indexlistPage(page);    //列出Pictures列表
        }
        mv.setViewName("pms/index_list");
        mv.addObject("varList", varList);
        mv.addObject("pd", pd);
        return mv;
    }

    @RequestMapping(value = "/trigger")
    public ModelAndView triggerPage(Page page, String tableName) throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        List<PageData> varList = null;
        if (StringUtils.isEmpty(tableName)) {
            pd.put("keywords", "");
            page.setPd(pd);
            varList = dbViewService.triggerlistPage(page);
        } else {
            pd.put("keywords", tableName.toUpperCase());
            page.setPd(pd);
            varList = dbViewService.triggerlistPage(page);
        }
        mv.setViewName("pms/trigger_list");
        mv.addObject("varList", varList);
        mv.addObject("pd", pd);
        return mv;
    }

    @RequestMapping(value = "/compareTable")
    public ModelAndView compareTable(Integer type) {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        List<Infornation> varList = null;
        List<Infornation> p46List = new ArrayList<Infornation>();
        List<Infornation> p461List = new ArrayList<Infornation>();

        try {
            varList = CompareTable.compareTables();
            Collections.sort(varList, new MyComparator());
            pd.put("keywords", type);
            if (varList != null && varList.size() > 0) {
                if (type == 1) {//表结构差异
                    for (Iterator<Infornation> iter_table = varList.iterator(); iter_table.hasNext(); ) {
                        Infornation info = iter_table.next();
                        if (info.getNum() == 1) p46List.add(info);
                        if (info.getNum() == 2) p461List.add(info);
                    }
                } else if (type == 2) {
                    for (Iterator<Infornation> iter = varList.iterator(); iter.hasNext(); ) {
                        Infornation info = iter.next();
                        if (info.getNum() == 3) p46List.add(info);
                        if (info.getNum() == 4) p461List.add(info);
                    }
                } else if (type == 3) {
                    for (Iterator<Infornation> iter = varList.iterator(); iter.hasNext(); ) {
                        Infornation info = iter.next();
                        if (info.getNum() == 5 || info.getNum() == 6)
                            p46List.add(info);
//                        if (info.getNum() == 6) p461List.add(info);
                    }
                }
            }

//            if (!StringUtils.isEmpty(type)) {
//                Iterator<Infornation> it = varList.iterator();
//                while (it.hasNext()) {
//                    if (it.next().getNum() != Integer.valueOf(type)) {
//                        it.remove();
//                    }
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("pms/comptable_list");
        mv.addObject("p46List", p46List);
        mv.addObject("p461List", p461List);
        mv.addObject("pd", pd);
        return mv;
    }
}

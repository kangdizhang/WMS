package com.pms.dbview.service.impl;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import com.pms.dbview.dao.DatatableDao;
import com.pms.dbview.service.DBViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunshine on 16/7/21.
 */
@Service
public class DBViewServiceImpl implements DBViewService {
    @Resource
    DatatableDao datatableDao;

    public List<PageData> listPage(Page page) {
        return datatableDao.listPage(page);
    }

    public List<PageData> columnslistPage(Page page) {
        return datatableDao.columnslistPage(page);
    }

    public List<PageData> indexlistPage(Page page) {
        return datatableDao.indexlistPage(page);
    }

    public List<PageData> triggerlistPage(Page page) {
        return datatableDao.triggerlistPage(page);
    }
}

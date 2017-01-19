package com.pms.dbview.service;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;

import java.util.List;

/**
 * Created by sunshine on 16/7/21.
 */
public interface DBViewService {

    public List<PageData> listPage(Page page);

    public List<PageData> columnslistPage(Page page);

    public List<PageData> indexlistPage(Page page);

    public List<PageData> triggerlistPage(Page page);
}

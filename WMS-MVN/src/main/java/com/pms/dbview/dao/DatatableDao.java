package com.pms.dbview.dao;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunshine on 16/7/21.
 */
@Repository
public interface DatatableDao {

    public List<PageData> listPage(Page page);

    public List<PageData> columnslistPage(Page page);

    public List<PageData> indexlistPage(Page page);

    public List<PageData> triggerlistPage(Page page);
}

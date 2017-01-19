package com.ectrip.service.information.pictures.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.information.pictures.PicturesDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.Page;
import com.ectrip.service.information.pictures.PicturesManager;
import com.ectrip.util.PageData;
import org.springframework.transaction.annotation.Transactional;


/**
 * 图片管理
 *
 * @author fh313596790qq(青苔)
 *         修改时间：2015.11.2
 */
@Service("picturesService")
@Transactional
public class PicturesService implements PicturesManager {

    @Resource
    private PicturesDao dao;

    /**
     * 列表
     *
     * @param page
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> list(Page page) throws Exception {
        return dao.datalistPage(page);
    }

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception {
        dao.save(pd);
    }

    /**
     * 删除
     *
     * @param pd
     * @throws Exception
     */
    public void delete(PageData pd) throws Exception {
        dao.delete(pd);
    }

    /**
     * 修改
     *
     * @param pd
     * @throws Exception
     */
    public void edit(PageData pd) throws Exception {
        dao.edit(pd);
    }

    /**
     * 通过id获取数据
     *
     * @param pd
     * @return
     * @throws Exception
     */
    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findById(pd);
    }

    /**
     * 批量删除
     *
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    public void deleteAll(String[] ArrayDATA_IDS) throws Exception {
        dao.deleteAll(ArrayDATA_IDS);
    }

    /**
     * 批量获取
     *
     * @param ArrayDATA_IDS
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<PageData> getAllById(String[] ArrayDATA_IDS) throws Exception {
        return dao.getAllById(ArrayDATA_IDS);
    }

    /**
     * 删除图片
     *
     * @param pd
     * @throws Exception
     */
    public void delTp(PageData pd) throws Exception {
        dao.delTp(pd);
    }

}


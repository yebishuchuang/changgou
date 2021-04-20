package com.fh.changgou.service;

import com.fh.changgou.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author fh
 * @create 2021-04-20 下午10:18
 */
public interface BrandService {

    public List<Brand> findAll();

    public Brand findById(Integer id);

    /**
     * 新增品牌信息
     * @param brand 需要新增的品牌信息
     */
    public void addBrand(Brand brand);

    /**
     * 修改品牌信息
     * @param brand 需要修改的品牌信息
     */
    public void updateBrand(Brand brand);

    /**
     * 根据品牌id删除品牌信息
     * @param id 品牌id
     */
    public void deleteById(Integer id);

    /**
     * 分页查询品牌信息
     * @param pageNum 当前页数
     * @param pageSize 每页显示条数
     * @return
     */
    public PageInfo<Brand> findByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询品牌信息
     * @param brand 查询信息
     * @return
     */
    public List<Brand> findList(Brand brand);

    /**
     * 分页查询根据条件查询品牌信息
     * @param brand 查询的品牌信息
     * @param pageNum 当前页数
     * @param pageSize 每页显示条数
     * @return
     */
    public PageInfo<Brand> findListByPage(Brand brand,Integer pageNum,Integer pageSize);
}

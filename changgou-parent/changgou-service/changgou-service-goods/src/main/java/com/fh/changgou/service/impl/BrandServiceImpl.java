package com.fh.changgou.service.impl;

import com.fh.changgou.dao.BrandMapper;
import com.fh.changgou.pojo.Brand;
import com.fh.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * 品牌brand service层接口的实现类
 * @author fh
 * @create 2021-04-20 下午10:19
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有品牌信息
     * @return 返回查询到的品牌信息集合
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据品牌id查询品牌信息
     * @param id 品牌id
     * @return 品牌信息
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addBrand(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Brand> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> brandList = brandMapper.selectAll();
        return new PageInfo<>(brandList);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = getExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * 获取brand的分页查询条件
     * @param brand
     * @return
     */
    private Example getExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria brandCriteria = example.createCriteria();
        //根据brand中的内容拼接sql语句
        if (brand != null) {
            if (!StringUtil.isEmpty(brand.getName())){
                //第一个参数：需要拼接的sql语句中的表中的字段名
                //第二个参数：sql语句中like后面拼接的内容
                brandCriteria.andLike("name", "%"+brand.getName()+"%");
            }
            if(!StringUtil.isEmpty(brand.getLetter())){
                //第一个参数：需要拼接的sql语句中的表中的字段名
                brandCriteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public PageInfo<Brand> findListByPage(Brand brand,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> brandList = brandMapper.selectByExample(getExample(brand));
        return new PageInfo<>(brandList);
    }
}

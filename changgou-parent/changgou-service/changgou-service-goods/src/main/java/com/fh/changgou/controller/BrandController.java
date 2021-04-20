package com.fh.changgou.controller;

import com.fh.changgou.entity.Page;
import com.fh.changgou.entity.Result;
import com.fh.changgou.entity.StatusCode;
import com.fh.changgou.pojo.Brand;
import com.fh.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fh
 * @create 2021-04-20 下午10:21
 */
@RestController
@RequestMapping("/brand")
@CrossOrigin //允许跨域访问
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询全部品牌信息
     * @return
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询品牌信息成功！", brandList);
    }

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(name = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据id查询品牌信息成功！", brand);
    }

    @PostMapping
    public Result addBrand(@RequestBody Brand brand){
        brandService.addBrand(brand);
        return new Result(true, StatusCode.OK, "新增品牌信息成功!");
    }

    /**
     * 根据id修改品牌信息
     * @param brand 需要修改的品牌信息内容
     * @param id 需要修改的品牌的id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result updateBrand(@RequestBody Brand brand,@PathVariable(name = "id") Integer id){
        brand.setId(id);
        brandService.updateBrand(brand);
        return new Result(true, StatusCode.OK, "根据id修改品牌信息成功！");
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable(name = "id") Integer id){
        brandService.deleteById(id);
        return new Result(true, StatusCode.OK, "根据id删除品牌信息成功！");
    }
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable(name = "page") Integer pageNum,@PathVariable(name = "size") Integer pageSize){
        PageInfo<Brand> brandPageInfo = brandService.findByPage(pageNum, pageSize);
        return new Result<>(true, StatusCode.OK, "分页查询品牌信息成功！", brandPageInfo);
    }

    /**
     * 根据条件查询品牌信息
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brandList = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "根据条件查询品牌信息成功！", brandList);
    }

    @PostMapping(value = "/search/{page}/{size}")
    public  Result<PageInfo<Brand>> findListByPage(@RequestBody Brand brand,@PathVariable(name = "page") Integer pageNum,@PathVariable(name = "size") Integer pageSize){
        PageInfo<Brand> brandPageInfo = brandService.findListByPage(brand, pageNum, pageSize);
        return new Result<>(true, StatusCode.OK, "根据条件分页查询品牌信息成功!", brandPageInfo);
    }
}

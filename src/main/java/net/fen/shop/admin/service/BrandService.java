package net.fen.shop.admin.service;

import net.fen.shop.admin.entity.Brand;
import net.fen.shop.admin.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Transactional
    public int add_brand(Brand brand) {
        return brandMapper.add_brand(brand);
    }

    public List<Brand> selectall_brand() {
        return brandMapper.selectall();
    }

    @Transactional
    public int del(int id) {
        return brandMapper.del(id);
    }

}

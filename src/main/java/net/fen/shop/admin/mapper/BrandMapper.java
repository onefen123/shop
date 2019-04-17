package net.fen.shop.admin.mapper;

import net.fen.shop.admin.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {
    @Insert("insert into brand(name,url,logo,description) values(#{name},#{url},#{logo},#{description})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    public int add_brand(Brand brand);

    @Select("select * from brand where 1")
    public List<Brand> selectall();

    @Delete("delete from brand where id=#{id}")
    public int del(int id);

    @Select("select * from brand where id=#{id}")
    public Brand selectById(int id);

    @Update("update brand set name=#{name},logo=#{logo},url=#{url},description=#{description},status=#{status} where id=#{id}")
    public int edit(Brand brand);

}

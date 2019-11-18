package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {

    public SysUser selectById(Long id);

    public List<SysUser> selectAll();
}

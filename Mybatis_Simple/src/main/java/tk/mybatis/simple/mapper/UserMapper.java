package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {

    public SysUser selectById(Long id);

    public List<SysUser> selectAll();

    public List<SysRole> selectRolesByUserId(Long userId);


    /**
     *
     * @param user
     * @return
     */
    public int insert(SysUser user);



    public int insert2(SysUser user);
}

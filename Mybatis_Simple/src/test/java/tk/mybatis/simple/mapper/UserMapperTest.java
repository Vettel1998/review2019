package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){

        SqlSession session = getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
//        List<SysUser> sysUsers = mapper.selectAll();
//        sysUsers.forEach(System.out::println);
            SysUser sysUser = mapper.selectById(1L);
            assertNotNull(sysUser);
            assertEquals("admin",sysUser.getUserName());
        } finally {
            session.close();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<SysUser> sysUsers = mapper.selectAll();
        assertNotNull(sysUsers);
        assertTrue(sysUsers.size()>0);
    }

    @Test
    public void testSelectRolesByUserId(){
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<SysRole> sysRoles = mapper.selectRolesByUserId(1L);
        assertNotNull(sysRoles);
        assertTrue(sysRoles.size()>0);

    }
}

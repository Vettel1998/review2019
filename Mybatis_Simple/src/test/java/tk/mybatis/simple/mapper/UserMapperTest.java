package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;
import tk.mybatis.simple.util.ImageUtil;

import javax.annotation.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
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

    @Test
    public void testInsert(){
        SqlSession session = getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("vettel");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setCreateTime(new Date());
//            user.setHeadImg(new byte[]{1,2,3});
            user.setHeadImg(ImageUtil.image2byte(ImageUtil.class.getResource("/th.jpg").getPath()));
            int result = mapper.insert(user);
            assertEquals(1,result);
            assertNull(user.getId());
        } finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void testInsert2(){
        SqlSession session = getSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("NewBoy");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setCreateTime(new Date());
//            user.setHeadImg(new byte[]{1,2,3});
            user.setHeadImg(ImageUtil.image2byte(ImageUtil.class.getResource("/th.jpg").getPath()));
            int result = mapper.insert2(user);
            assertEquals(1,result);
            assertNotNull(user.getId());
            System.out.println(user.getId());
        } finally {
            session.commit();
            session.close();
        }
    }


    /*@Test
    public void testStream() throws IOException, URISyntaxException {
        // 获取URL
        URL url = ImageUtil.class.getResource("/th.jpg");
        // 通过url获取File的绝对路径
        File f = new File(url.getFile());
        System.out.println("文件的名子是:" + f.getName());
        System.out.println("文件的大小是:" + f.length());
    }*/
}

package com.itdoater.access.dataaccess;

import com.itdoater.access.mapper._UserMapper;
import com.itdoater.access.pojo.Article;
import com.itdoater.access.pojo._User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jt_hu on 2016/12/30.
 */
public class _UserAccess implements _UserMapper {
    private SqlSession session;
    private _UserMapper mapper;

    public _UserAccess(){
        session = AccessFactory.getItdotaerSession();
        try {
            mapper =  session.getMapper(_UserMapper.class);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据id获取User
     *
     * @param id
     * @return
     */
    @Override
    public _User getUserById(int id) {
        return mapper.getUserById(id);
    }

    /**
     * 获取Users like userName
     *
     * @param userName
     * @return
     */
    @Override
    public List<_User> getUsers(String userName) {
        return mapper.getUsers(userName);
    }

    /**
     * 新增User
     *
     * @param user
     */
    @Override
    public int addUser(_User user) {
        return mapper.addUser(user);
    }

    /**
     * 修改User
     *
     * @param user
     */
    @Override
    public int updateUser(_User user) {
        return mapper.updateUser(user);
    }

    /**
     * 删除User
     *
     * @param id
     */
    @Override
    public int deleteUserById(int id) {
        return mapper.deleteUserById(id);
    }

    /**
     * 根据UserName删掉符合条件的Users
     *
     * @param userName
     */
    @Override
    public int deleteUserByUserName(String userName) {
        return mapper.deleteUserByUserName(userName);
    }

    /**
     * 关联查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Article> getUserArtices(int id) {
        return mapper.getUserArtices(id);
    }

    /**
     * 关闭
     */
    public void close(){
        session.close();
    }
}
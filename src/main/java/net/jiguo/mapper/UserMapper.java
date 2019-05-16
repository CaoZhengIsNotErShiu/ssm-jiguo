package net.jiguo.mapper;

import net.jiguo.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午5:30
 * @Version 1.0
 */

public interface UserMapper {
    User checkLogin(@Param("name") String name,@Param("password") String password);
}

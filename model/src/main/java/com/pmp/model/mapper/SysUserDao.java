package com.pmp.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pmp.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @Author gali
 * @Description //系统用户表mapper类
 * @Date 19:26 2021/1/16
 * @Param
 * @return
 **/
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * @Author gali
	 * @Description //查询用户的所有权限
	 * @Date 19:27 2021/1/16
	 * @Param userId 用户id
	 * @return java.util.List<java.lang.String>
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * @Author gali
	 * @Description //查询用户的所有权限
	 * @Date 19:27 2021/1/16
	 * @Param [userId] 用户id
	 * @return java.util.List<java.lang.Long>
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * @Author gali
	 * @Description // 根据用户id获取部门数据Id列表 ~ 数据权限
	 * @Date 19:28 2021/1/16
	 * @Param [userId] 用户id
	 * @return java.util.Set<java.lang.Long>
	 **/
	Set<Long> queryDeptIdsByUserId(Long userId);
	/**
	 * @Author gali
	 * @Description //根据用户名称查询用户信息
	 * @Date 19:28 2021/1/16
	 * @Param [userName] 用户名称
	 * @return com.pmp.model.entity.SysUserEntity
	 **/
	SysUserEntity selectByUserName(@Param("userName") String userName);
}

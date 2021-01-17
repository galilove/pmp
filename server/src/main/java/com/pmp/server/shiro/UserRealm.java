package com.pmp.server.shiro;

import com.pmp.model.entity.SysUserEntity;
import com.pmp.model.mapper.SysUserDao;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.krb5.Realm;

import javax.annotation.Resource;

/**
 * @author gali
 * shiro用于认证用户~授权
 * @date 2021/01/16 18:53
 **/
@Component
public class UserRealm extends AuthorizingRealm {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /**
     * @Author gali
     * @Description //用户认证 ~ 登录认证
     * @Date 18:58 2021/1/16
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户信息
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        final String username = userToken.getUsername();
        final String password = String.valueOf(userToken.getPassword());

        //2.获取数据库用户信息
        SysUserEntity userEntity = sysUserDao.selectByUserName(username);
        //账户不存在
        if (userEntity==null){
            throw new UnknownAccountException("账户不存在!");
        }
        //账户被禁用
        if (0 == userEntity.getStatus()){
            throw new DisabledAccountException("账户已被禁用,请联系管理员!");
        }

        //3.将输入的密码进行加盐操作
        String realPassword = ShiroUtil.sha256(password, userEntity.getSalt());
        //4.进行密码匹配
        if (StringUtils.isBlank(realPassword) || !realPassword.equals(userEntity.getPassword())){
            throw new IncorrectCredentialsException("账户密码不匹配!");
        }

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userEntity,password,getName());
        return info;
    }
}

package com.bx.springvue.Mapper;

import com.bx.springvue.Entity.UserEntity;
import com.gitee.fastmybatis.core.query.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface fastMapper {
    /**
     * 根据主键查询
     *
     * @param id
     * @return 返回实体对象，没有返回null
     */
//    UserEntity getById(ID id);

    /**
     * 根据条件查找单条记录
     * @param query 查询条件
     * @return 返回实体对象，没有返回null
     */
    UserEntity getByQuery(@Param("query") Query query);

    /**
     * 根据字段查询一条记录
     * @param column 数据库字段名
     * @param value 字段值
     * @return 返回实体对象，没有返回null
     */
    UserEntity getByColumn(@Param("column")String column,@Param("value")Object value);

    /**
     * 查询总记录数
     *
     * @param query 查询条件
     * @return 返回总记录数
     */
    long getCount(@Param("query")Query query);

    /**
     * 根据字段查询集合
     * @param column 数据库字段名
     * @param value 字段值
     * @return 返回实体对象集合，没有返回空集合
     */
    List<UserEntity> listByColumn(@Param("column")String column, @Param("value")Object value);

    /**
     * 条件查询
     *
     * @param query 查询条件
     * @return 返回实体对象集合，没有返回空集合
     */
    List<UserEntity> list(@Param("query")Query query);

    /**
     * 查询指定字段结果
     * @param columns 返回的字段
     * @param query 查询条件
     * @return 返回结果集
     */
    List<Map<String, Object>> listMap(@Param("columns")List<String> columns, @Param("query")Query query);

    /**
     * 新增,新增所有字段
     *
     * @param entity
     * @return 受到影响的行数
     */
    int save(UserEntity entity);

    /**
     * 新增（忽略null数据）
     * @param entity
     * @return 受到影响的行数
     */
    int saveIgnoreNull(UserEntity entity);

    /**
     * 批量添加,只支持mysql,sqlserver2008及以上数据库.<br>
     * <strong>若要兼容其它版本数据库,请使用saveMulti()方法</strong>
     * @param entitys
     * @return
     */
    int saveBatch(@Param("entitys")List<UserEntity> entitys);

    /**
     * 批量添加,兼容更多的数据库版本.<br>
     * 此方式采用union all的方式批量insert,如果是mysql或sqlserver2008及以上推荐saveBatch()方法.
     * @param entitys
     * @return
     */
    int saveMulti(@Param("entitys")List<UserEntity> entitys);

    /**
     * 修改,修改所有字段
     *
     * @param entity
     * @return 受到影响的行数
     */
    int update(UserEntity entity);

    /**
     * 根据主键更新不为null的字段
     *
     * @param entity
     * @return 受到影响的行数
     */
    int updateIgnoreNull(UserEntity entity);

    /**
     * 根据条件批量更新
     *
     * @param entity 待更新的数据，可以是实体类，也可以是Map{@literal<String,Object>}
     * @param query 更新条件
     * @return 受到影响的行数
     */
    int updateByQuery(@Param("entity") Object entity, @Param("query") Query query);

    /**
     * 删除
     *
     * @param entity
     * @return 受到影响的行数
     */
    int delete(UserEntity entity);

    /**
     * 根据id删除
     *
     * @param id 主键id
     * @return 受到影响的行数
     */
//    int deleteById(ID id);

    /**
     * 根据条件删除
     *
     * @param query
     * @return 受到影响的行数
     */
    int deleteByQuery(@Param("query")Query query);
}

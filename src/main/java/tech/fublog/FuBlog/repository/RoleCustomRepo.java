package tech.fublog.FuBlog.repository;

import tech.fublog.FuBlog.entity.RoleEntity;
import tech.fublog.FuBlog.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class RoleCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<RoleEntity> getRole(UserEntity user){
        StringBuilder sql = new StringBuilder().append("SELECT db.roles.name as name FROM db.users join db.user_role on db.users.id=db.user_role.users_id join db.roles on db.roles.id = db.user_role.roles_id");
        sql.append(" Where 1=1");
        if(user.getUsername() != null){
            sql.append(" and username = :username");
        }
        NativeQuery<RoleEntity> query = ((Session) entityManager.getDelegate()) .createNativeQuery(sql.toString());

        if(user.getUsername() != null){
            query.setParameter("username", user.getUsername());
        }
        query.addScalar("name", StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(RoleEntity.class));
        return query.list();
    }
}

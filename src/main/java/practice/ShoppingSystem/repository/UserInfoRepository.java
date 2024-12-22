package practice.ShoppingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.ShoppingSystem.entity.UserInfo;

/**
 * ユーザー情報テーブルDAO
 * @author shoujiyuuki
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> { //対象テーブルのEntityクラスの情報を渡す

}

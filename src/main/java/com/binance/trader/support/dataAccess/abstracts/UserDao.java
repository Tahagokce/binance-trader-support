package com.binance.trader.support.dataAccess.abstracts;
import com.binance.trader.support.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}

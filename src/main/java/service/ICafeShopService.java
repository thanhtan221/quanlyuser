package service;

import model.CafeShop;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface ICafeShopService {
    public void insertcafeshop(CafeShop cafeShop) throws SQLException;

    public CafeShop selectcafeshop(int id);

    public List<CafeShop> selectAllcafeshop();

    public boolean updatecafeshop(CafeShop cafeShop) throws SQLException;
}

package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.beans.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jtemp;

	@Override
	public boolean saveProduct(Product p) {
		int n = jtemp.update("insert into product123 values(?, ?, ?, ?, ?, ?)", new Object[] {
				p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getExpdate(), p.getCid()
		});
		if(n>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int pid) {
		int n = jtemp.update("delete from product123 where pid=?", new Object[] {pid});
		return n>0;
	}

	@Override
	public List<Product> FindAll() {
		List<Product> plist = jtemp.query("select * from product123", (rs, numofrows)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setExpdate(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}

	@Override
	public boolean modifyProduct(int pid, int qty, double price) {
		int n = jtemp.update("update product123 set qty=?, price=? where pid=?", new Object[] {qty, price, pid});
		return n>0;
	}

	@Override
	public List<Product> getByPrice() {
		return jtemp.query("SELECT * FROM product123 ORDER BY price", (rs, numofrows)->{
			return new Product(rs.getInt("pid"), rs.getString("pname"), rs.getInt("qty"), rs.getDouble("price"), rs.getDate("expdate").toLocalDate(), rs.getInt("cid"));
		});
	}

}

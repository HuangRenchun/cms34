package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Category;
import com.briup.cms.common.ConnectionFactory;
/**
 * 栏目管理的数据库操作类
 * */
public class CategoryDao {
	/**
	 * 删除
	 * */
	public void deleteById(long id){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "delete from t_category where id = ?";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 保存
	 * @param  栏目
	 * */
	public void save(Category category){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_category(name,code) values(?,?)";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2, category.getCode());
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改
	 * @param  栏目
	 * 
	 * 学生信息管理系统  GUI
	 * */
	public void update(Category category){
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "update t_category set name=?,code=? where id=?";
				//2.预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2, category.getCode());
				pstmt.setLong(3, category.getId());
				//3.执行sql
				pstmt.executeUpdate();
			}finally{
				//4.释放资源
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id查询
	 * */
	public Category findById(long id){
		Category category = null;
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_category where id=?";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					String name = rs.getString("name");
					int code = rs.getInt("code");
					category = new Category(name, code);
					category.setId(id);
				}
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return category;
	}
	
	public List<Category> findAll(){
		List<Category> list = new ArrayList<Category>();
		try{
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//1.注册驱动，获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_category";
				//2. 预处理
				pstmt = conn.prepareStatement(sql);
				//3.执行
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String name = rs.getString("name");
					int code = rs.getInt("code");
					Category c = new Category(name, code);
					c.setId(id);
					list.add(c);
				}
				
			}finally{
				//4.释放资源
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					pstmt.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}

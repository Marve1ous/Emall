package com.emall.spring;

import com.emall.spring.dao.*;
import com.emall.spring.entity.Admin;
import com.emall.spring.entity.Distribute;
import com.emall.spring.services.BannerService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private DistributeMapper distributeMapper;

	@Autowired
    private AdminMapper adminMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private ProductclassMapper productclassMapper;

	@Autowired
	private BannerService bannerService;

	@Test
	public void selectByTelPasswordTest() {
		Distribute distribute = new Distribute();
		distribute.setDistributetel("123");
		distribute.setDistributepassword("123");
		Distribute distribute1 = distributeMapper.selectByTelPassword(distribute);
		if (distribute1 != null) {
			System.out.println(distribute1.getRegisttime());
		} else {
			System.out.println("用户名或者密码错误！");
		}
	}

	@Test
    public void selectByTel() {
	    String admintel = "123";
        Admin admin = adminMapper.selectByTel(admintel);
        System.out.println(admin);
    }

    @Test
	public void selectAllTest() {
		JSONObject jsonObject = new JSONObject();
		ArrayList list = productMapper.selectAll();
		jsonObject.put("product", list);
		System.out.println(jsonObject);
	}


	@Test
	public void selectByname() {
		JSONObject jsonObject = new JSONObject();
		ArrayList list = productMapper.selectByNameLike("电脑");
		jsonObject.put("product", list);
		System.out.println(jsonObject);
	}

	@Test
	public void selectAllTestOrder() {
		System.out.println(orderMapper.selectAll());
	}

	@Test
	public void selectAllTestProductclass() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("productclass", productclassMapper.selectAll());
		System.out.println(jsonObject);
	}

	@Test
	public void selectByProductclassTest() {
		System.out.println(productMapper.selectByProductclass("休闲零食"));
	}

	@Test
	public void selectAllBanner() {
		System.out.println(bannerService.selectAll());
	}
}

package com.billboard.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.billboard.model.BillboardService;
import com.billboard.model.BillboardVO;

@Controller
@RequestMapping("/billboard")
public class BillboardController {
	
	//首頁新增公佈欄資訊用
	@RequestMapping(method = RequestMethod.GET, value = "addBillboard")
	public String addEmp(ModelMap model) {
		BillboardVO billboardVO = new BillboardVO();
		model.addAttribute("billboardVO", billboardVO);
		return "billboard/addBillboard";
	}
	
	//新增公佈欄資訊用
	@RequestMapping(method = RequestMethod.POST, value = "insert")
	public String insert(@Valid BillboardVO billboardVO, BindingResult result, ModelMap model) {

		/***************************1.接收請求參數 - 輸入格式的錯誤處理******************/
		if (result.hasErrors()) {
			return "billboard/addBillboard";
		}
		/***************************2.開始新增資料***************************************/
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.addBillboard(billboardVO);

		/***************************3.新增完成,準備轉交(Send the Success view)***********/
		model.addAttribute("success", "- (新增成功)");
		return "billboard/listAllBillboard"; 
	}
	
	//取得修改資料
	@RequestMapping(method = RequestMethod.POST, value = "getOne_For_Update")
	public String getOne_For_Update(@RequestParam("bill_id") Integer bill_id, ModelMap model) {
		/***************************1.接收請求參數 - 輸入格式的錯誤處理******************/
		/***************************2.開始查詢資料***************************************/
		BillboardService billboardSvc = new BillboardService();
		BillboardVO billboardVO = billboardSvc.getOneBillboard(bill_id);
		
		/***************************3.查詢完成,準備轉交(Send the Success view)***********/
		model.addAttribute("billboardVO", billboardVO);
		return "billboard/updateBillboard"; 
	}
	
	//修改資料
	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String update(@Valid BillboardVO billboardVO, BindingResult result, ModelMap model) {

		/***************************1.接收請求參數 - 輸入格式的錯誤處理******************/
		if (result.hasErrors()) {
			return "billboard/updateBillboard";
		}
		/***************************2.開始修改資料***************************************/
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.updateBillboard(billboardVO);
		System.out.println("資料庫 update 成功");

		/***************************3.修改完成,準備轉交(Send the Success view)***********/
		model.addAttribute("billboardVO", billboardVO);
		return "billboard/listOneBillboard"; 
	}
	
	//刪除公佈欄
	@RequestMapping(method = RequestMethod.POST, value = "delete")
	public String delete(@RequestParam("bill_id") Integer bill_id, ModelMap model) {
		/***************************1.接收請求參數 - 輸入格式的錯誤處理*******************/
		/***************************2.開始刪除資料***************************************/
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.deleteBillboard(bill_id);
		System.out.println("資料庫 delete 成功");
		
		/***************************3.刪除完成,準備轉交(Send the Success view)***********/
		return "billboard/listAllBillboard"; 
	}

}

package com.billboard.controller;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.billboard.model.BillboardService;
import com.billboard.model.BillboardVO;

@Controller
@Validated
@RequestMapping("/billboard")
public class BillnoController {

	//取得要顯示的資料
	@RequestMapping(method = RequestMethod.GET, value ="getOne_For_Display")
	public String getOne_For_Display(
		/***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
		@RequestParam("bill_id") String bill_id,
		ModelMap model) {
		
		/***************************2.開始查詢資料*********************************************/
		BillboardService billboardSvc = new BillboardService();
		BillboardVO billboardVO = billboardSvc.getOneBillboard(new Integer(bill_id));
		if (billboardVO == null) {
			model.addAttribute("message", "查無資料");
			return "select_page";
		}
		
		/***************************3.查詢完成,準備轉交(Send the Success view)*****************/
		model.addAttribute("billboardVO", billboardVO);
		return "billboard/listOneBillboard"; // 查詢完成後轉交listOneEmp.jsp
	}
}

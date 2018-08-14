package com.giveu.controller;

import com.giveu.common.Msg;
import com.giveu.common.validate.AnnotationDealUtil;
import com.giveu.entity.Person;
import com.giveu.responEntity.ResponPerson;
import com.giveu.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by fox on 2018/7/27.
 */
@RestController
@RequestMapping(value = "person")
@CrossOrigin
public class PersonController {

	@Autowired
	PersonService personServiceImpl;

	@RequestMapping(value = "/list")
	List<ResponPerson> list() {
		return personServiceImpl.list();
	}

	@RequestMapping(value = "/add")
	Msg add(Person person) {
		Msg msg=new Msg();
		String errorMsg="";
		Map<String, Object> map= AnnotationDealUtil.validate(person);
//		map.forEach((key,value)->{
//         if(value!=null)
//		 {
//			 Map<String, Object> item=(Map<String, Object>)value;
//			 errorMsg=item.get("message").toString();
//		 }
//		});
		if(map!=null && map.size()>0)
		{
			for (Object value : map.values()) {
				errorMsg=errorMsg+"、"+ value.toString();
			}
			if (errorMsg.startsWith("、")) {
				errorMsg = errorMsg.substring(1);
			}
			msg.Message=errorMsg;
			msg.Result="0";
			return msg;
		}
		else
		{
			Integer in= personServiceImpl.add(person);
			msg.Message="";
			msg.Result="1";
			return msg;
		}
	}

	@RequestMapping(value = "/del")
	Integer del(Integer id) {
		return personServiceImpl.del(id);
	}
	@RequestMapping(value = "/update")
	Msg update(Person person) {
		Msg msg=new Msg();
		 String errorMsg="";
		Map<String, Object> map= AnnotationDealUtil.validate(person);
//		map.forEach((key,value)->{
//         if(value!=null)
//		 {
//			 Map<String, Object> item=(Map<String, Object>)value;
//			 errorMsg=item.get("message").toString();
//		 }
//		});
		if(map!=null && map.size()>0)
		{
			for (Object value : map.values()) {
				errorMsg=errorMsg+"、"+ value.toString();
			}
			if (errorMsg.startsWith("、")) {
				errorMsg = errorMsg.substring(1);
			}
			msg.Message=errorMsg;
			msg.Result="0";
			return msg;
		}
		else
		{
			Integer in= personServiceImpl.update(person);
			msg.Message="";
			msg.Result="1";
			return msg;
		}
	}

	@RequestMapping(value = "/getOne")
	ResponPerson getPerson(Integer id) {
		return personServiceImpl.getPerson(id);
	}
}

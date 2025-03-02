package com.hibernate.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ManagerController
{
	@Autowired
	private ManagerService mnse;
	
	@PostMapping("/save")
	public Manager save(@RequestBody Manager mn)
	{
		return mnse.save(mn);
	}
	@GetMapping("/getall")
	public List<Manager> get(Model model)
	{
		List<Manager> l2 = mnse.getalls();
		return l2;
	}
	
	@Scheduled(fixedRate = 10000) // 1000 = 1sec
	public List<Manager> gets()
	{
		List<Manager> l2 = mnse.getalls();
		System.out.println(l2);
		return l2;
	}
	
	@GetMapping("/get/{id}")
	public Optional<Manager> getbyid(@PathVariable("id") Integer id) {
		return mnse.getbyid(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer mnid)
	{
		mnse.DeleteManager(mnid);
	}
	@PutMapping("/update")
	public void updates(@RequestBody Manager m)
	{
		mnse.save(m);
	}
	@PatchMapping("/update/{id}")
	public Manager updatedatabyid(@PathVariable("id") Integer id , @RequestBody String name) throws Exception
	{
		return mnse.updatebyid(id, name);
	}
	
	

}

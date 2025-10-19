package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.model.OrderMethod;
import in.nareshit.raghu.repo.OrderMethodRepository;
import in.nareshit.raghu.service.IOrderMethodService;
import in.nareshit.raghu.util.AppUtil;

@Service
public class OrderMethodServiceImpl 
	implements IOrderMethodService
{

	@Autowired
	private OrderMethodRepository repo; //HAS-A
	
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		om = repo.save(om);
		Integer id = om.getId();
		return id;
	}
	
	@Override
	public List<OrderMethod> getAllOrderMethods() {
		List<OrderMethod> list = repo.findAll();
		return list;
	}
	
	@Override
	public void deleteOrderMethod(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public boolean isOrderMethodExist(Integer id) {
		return repo.existsById(id);
	}
	
	@Override
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
		Optional<OrderMethod> opt = repo.findById(id);
		return opt;
	}
	
	@Override
	public void updateOrderMethod(OrderMethod om) {
		repo.save(om); //UPDATE SQL..
	}
	
	@Override
	public boolean isOrderMethodExistByCode(String orderCode) {
		/*Integer count = repo.getOrderMethodCountByCode(orderCode);
		boolean exist = count>0? true:false;
		return exist;*/
		return  repo.getOrderMethodCountByCode(orderCode) > 0;
		
	}
	
	@Override
	public Map<Integer, String> getOrderMethodIdAndCode(String mode) {
		List<Object[]> list = repo.getOrderMethodIdAndCode(mode);
		Map<Integer, String> map = AppUtil.convertToMap(list);
		return map;
	}
}

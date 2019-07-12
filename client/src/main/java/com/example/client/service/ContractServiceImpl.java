package com.example.client.service;

import com.example.client.entity.Customer;
import com.example.client.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	DiscoveryClient discoveryClient;

	@Override
	public List<Contract> findAll() {

		List<ServiceInstance> list = discoveryClient.getInstances("customer");

		URI uri = list.get(0).getUri();
		ResponseEntity<List<Contract>> responseEntity = new RestTemplate()
				.exchange(
						uri + "/customers",
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<Contract>>() {
						});

		return responseEntity.getBody();
	}

	@Override
	public Contract findById(int theId) {

		List<ServiceInstance> list = discoveryClient.getInstances("customer");

		URI uri = list.get(0).getUri();
		ResponseEntity<Contract> responseEntity = new RestTemplate()
				.exchange(
						uri + "/customers/" + theId,
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<Contract>() {
						});

		return responseEntity.getBody();
	}

	@Override
	public void save(Contract contract) {

		List<ServiceInstance> list = discoveryClient.getInstances("customer");
		URI uri = list.get(0).getUri();

		HttpEntity<Customer> request = new HttpEntity<>(contract.getCustomer());

		if (contract.getCustomer().getCustomerId() > 0){
			new RestTemplate().exchange(uri + "/customers", HttpMethod.PUT, request, Customer.class);
		}else{
			new RestTemplate().postForObject(uri + "/customers", request, Customer.class);

		}
	}

	@Override
	public void deleteById(int id) {

		List<ServiceInstance> list = discoveryClient.getInstances("customer");
		URI uri = list.get(0).getUri();

		new RestTemplate().delete(uri + "/customers/" + id);
	}
}







package com.example.customer.service;

import com.example.customer.model.Contract;
import com.example.customer.model.Credit;
import com.example.customer.model.Customer;
import com.example.customer.model.Product;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    DiscoveryClient discoveryClient;

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Contract findById(int id) {

        Optional<Customer> customer = customerRepository.findById(id);

        Customer theCustomer = null;

        if (customer.isPresent()){
            theCustomer = customer.get();
        }
        else {
            throw new RuntimeException("Did not find customer id - " + id);
        }

        Contract contract = new Contract();
        contract.setCustomer(theCustomer);

        return contract;
    }

    @Override
    public List<Contract> findAll() {

        List<Contract> dataList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        List<Product> products = new ArrayList<>();
        List<Credit> credits = new ArrayList<>();

        List<ServiceInstance> list = discoveryClient.getInstances("product");

        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();

            ResponseEntity<List<Product>> responseEntity = new RestTemplate()
                    .exchange(
                            uri + "/products",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Product>>() {
                            });

            assert responseEntity.getBody() != null;
            products = responseEntity.getBody();
        }

        list = discoveryClient.getInstances("credit");

        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();

            ResponseEntity<List<Credit>> responseEntity = new RestTemplate()
                    .exchange(
                            uri + "/credits",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Credit>>() {
                            });

            assert responseEntity.getBody() != null;
            credits = responseEntity.getBody();
        }

        for (Customer customer : customers) {

            Contract contract = new Contract();

            contract.setCustomer(customer);
            for (Product product : products) {
                if (product.getProductId() == customer.getProductId()) {
                    contract.setProduct(product);
                    for (Credit credit : credits) {
                        if (product.getCredit_id() == credit.getCreditId()) {
                            contract.setCredit(credit);
                        }
                    }
                }
            }
            dataList.add(contract);
        }
        return dataList;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer theCustomer) {
        Customer customer = customerRepository.getOne(theCustomer.getCustomerId());

        customer.setFirstName(theCustomer.getFirstName());
        customer.setSurname(theCustomer.getSurname());
        customer.setPESEL(theCustomer.getPESEL());
        customer.setProductId(theCustomer.getProductId());

        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

}

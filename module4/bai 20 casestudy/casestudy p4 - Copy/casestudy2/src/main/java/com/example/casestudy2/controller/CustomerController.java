package com.example.casestudy2.controller;

import com.example.casestudy2.model.customer.Customer;
import com.example.casestudy2.model.customer.CustomerType;
import com.example.casestudy2.service.customer.CustomerService;
import com.example.casestudy2.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable
            , Optional<String> searchCustomerByName) {
//        List<Customer>customers= customerService.findAll();
//        Iterable<CustomerType> customerTypes=customerTypeService.findAll();
//        if (searchCustomerByName.isPresent()){
//            model.addAttribute("customers",customerService.searchCustomerByName(searchCustomerByName.get(),pageable));
//            model.addAttribute("customerNameSearch",searchCustomerByName);
//
//        }else {
        model.addAttribute("customers", customerService.findAll(pageable));
//            model.addAttribute("customerNameSearch",searchCustomerByName);

//        }
//        model.addAttribute("customerTypes",customerTypes);
        return "customer/listPageable";
    }

    @GetMapping("/create-customer")
    public String showFormCreate(Model model) {
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute(name = "customer") Customer customer, RedirectAttributes redirectAttributes) {

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New product created successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/view/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerForm(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/delete";
    }

    @PostMapping("/actionDelete/{id}")
    public String deleteCustomer(Model model, @PathVariable int id) {
        System.out.println(id);
        customerService.deleteById(id);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "customer/searchTable";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable int id, Model model) {
        System.out.println("id:" + id);
        Customer customer = customerService.findById(id);
        Iterable<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", customer);

        return "customer/edit";
    }

    @PostMapping("/actionEdit")
    public String editCustomer(@ModelAttribute(name = "customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/searchTablePageable")
    public String returnSearchTable(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "customer/searchTablePageable";
    }

    @GetMapping("/searchCustomerByName")
    public String searchCustomer(@RequestParam("searchCustomerByName") String searchCustomerByName,
                                 Model model,@PageableDefault(size = 2) Pageable pageable) {
        List<Customer> customerList = customerService.searchCustomerByName(searchCustomerByName);
        model.addAttribute("customers", customerService.searchCustomerByName(searchCustomerByName, pageable));
        model.addAttribute("customerNameSearch222", searchCustomerByName);
        return "customer/searchTablePageable2";

    }
//
//    @GetMapping("/searchTablePageable2")
//    public String returnSearchTable2(@RequestParam("searchCustomerByName") String searchCustomerByName,
//                                     Model model, @PageableDefault(size = 2) Pageable pageable) {
//        model.addAttribute("customers", customerService.findAll(pageable));
//        model.addAttribute("customerNameSearch", searchCustomerByName);
//        return "customer/searchTablePageable2";
//    }
}

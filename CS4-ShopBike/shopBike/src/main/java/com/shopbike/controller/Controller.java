package com.shopbike.controller;

import com.shopbike.service.cart.ICartService;
import com.shopbike.service.product.IProductService;
import com.shopbike.service.size.ISizeService;
import com.shopbike.service.type.ITypeService;
import com.shopbike.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ISizeService sizeService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICartService cartService;

    @GetMapping("/product")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/product/index");
        return modelAndView;
    }

    //Product Manager
    @GetMapping("/")
    public ModelAndView showProducts() {
        ModelAndView modelAndView = new ModelAndView("/product/manager");
        return modelAndView;
    }

    @GetMapping("/product-detail")
    public ModelAndView showDetail() {
        ModelAndView modelAndView = new ModelAndView("/product/product-detail");
        return modelAndView;
    }

    @GetMapping("/info-product")
    public ModelAndView showInfo() {
        ModelAndView modelAndView = new ModelAndView("/product/info-product");
        return modelAndView;
    }

    //Type Manager
    @GetMapping("/type")
    public ModelAndView showTypes() {
        ModelAndView modelAndView = new ModelAndView("/type/manager");
        modelAndView.addObject("types", typeService.findAll());
        return modelAndView;
    }

    //Size Manager
    @GetMapping("/size")
    public ModelAndView showSizes() {
        ModelAndView modelAndView = new ModelAndView("/size/manager");
        modelAndView.addObject("sizes", sizeService.findAll());
        return modelAndView;
    }

    //User Manager
    @GetMapping("/user")
    public ModelAndView showUsers() {
        ModelAndView modelAndView = new ModelAndView("/user/manager");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    //Product Manager
    @GetMapping("/cart")
    public ModelAndView showCarts() {
        ModelAndView modelAndView = new ModelAndView("/cart/manager");
        modelAndView.addObject("carts", cartService.findAll());
        return modelAndView;
    }

    //Admin Manager
    @GetMapping("/admin")
    public ModelAndView showAdmin() {
        ModelAndView modelAndView = new ModelAndView("/admin/set");
        modelAndView.addObject("admin", userService.findById(1L));
        return modelAndView;
    }
}

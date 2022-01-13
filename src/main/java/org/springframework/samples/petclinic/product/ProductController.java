package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService ps;

    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM="products/createOrUpdateProductForm";

    @GetMapping(path="/create")
    public String initCreationForm(ModelMap modelmap){
        String view=VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        modelmap.addAttribute("product",new Product());
        modelmap.addAttribute("productType",ps.findAllProductTypes());
        return view;
    }

    @PostMapping(path="/create")
    public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model){
        String view="welcome";
        if (result.hasErrors()){
            model.addAttribute("product",product);
            model.addAttribute("productType",ps.findAllProductTypes());
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        }else{
            ps.save(product);
            model.addAttribute("message","Product saved");
        }
        return view;
    }
}

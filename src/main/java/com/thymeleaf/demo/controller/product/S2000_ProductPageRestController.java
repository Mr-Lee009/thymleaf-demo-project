package com.thymeleaf.demo.controller.product;

import com.thymeleaf.demo.dto.common.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/product")
public class S2000_ProductPageRestController {

    @Autowired
    S2000_ProductHelper helper;

    /**
     * delete product by id
     *
     * @param productIds
     * @return
     */
    @PostMapping("/delete-all")
    public ResponseData<String> deleteProduct(@RequestBody S2000_RequestDelete request) {
        try{
            if(request.getIds() == null || request.getIds().isEmpty()){
                return ResponseData.error(HttpStatus.BAD_REQUEST.value(),"Error when delete product: List of id is empty");
            }
            helper.deleteInListId(request.getIds());
            return ResponseData.success(HttpStatus.OK.value(), "Delete product success!", null);
        } catch (Exception e) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
    }
}

package com.riftshop.riftshop.controllers;

import com.riftshop.riftshop.models.Product;
import com.riftshop.riftshop.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/RecoveryImage", produces = MediaType.IMAGE_JPEG_VALUE)

    public @ResponseBody
    byte[] showImage(
            @RequestParam(value = "id_product") int id_product,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");

        byte[] buffer = new byte[2048];
        int bytesread = 0;

        ServletOutputStream out = response.getOutputStream();
        InputStream is;
        Product product = productRepository.findById(id_product).orElseThrow(Exception::new);

        if (product.getImage() == null) {
            is = request.getSession().getServletContext().getResourceAsStream("DefaultImage.png");
            while ((bytesread = is.read(buffer)) != -1)
                out.write(buffer, 0, bytesread);
        } else {
            is = new ByteArrayInputStream(product.getImage());
            while ((bytesread = is.read(buffer)) != -1)
                out.write(buffer, 0, bytesread);
            out.flush();
            ;
        }
        out.close();
        is.close();

        return buffer;


    }

}

package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Garry's Guitars");
        o.setName("Strings");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        o.setMinInv(2);
        o.setMaxInv(20);

        OutsourcedPart o2= new OutsourcedPart();
        o2.setCompanyName("Garry's Guitars");
        o2.setName("Body");
        o2.setInv(3);
        o2.setPrice(100.0);
        o2.setId(101L);
        o2.setMinInv(2);
        o2.setMaxInv(20);

        OutsourcedPart o3= new OutsourcedPart();
        o3.setCompanyName("Garry's Guitars");
        o3.setName("Neck");
        o3.setInv(10);
        o3.setPrice(50.0);
        o3.setId(102L);
        o3.setMinInv(2);
        o3.setMaxInv(20);

        OutsourcedPart o4 = new OutsourcedPart();
        o4.setCompanyName("Garry's Guitars");
        o4.setName("Head");
        o4.setInv(7);
        o4.setPrice(9.0);
        o4.setId(103L);
        o4.setMinInv(2);
        o4.setMaxInv(20);

        OutsourcedPart o5= new OutsourcedPart();
        o5.setCompanyName("Garry's Guitars");
        o5.setName("Fret Wire");
        o5.setInv(100);
        o5.setPrice(2.0);
        o5.setId(104L);
        o5.setMinInv(2);
        o5.setMaxInv(120);

        Product acoustic= new Product("Acoustic Guitar",120.0,10);
        Product electric= new Product("Electric Guitar",110.0,15);
        Product banjo= new Product("Banjo",75.0,8);
        Product ukulele= new Product("Ukulele",50.0,12);
        Product bass= new Product("Bass Guitar",115.0,17);

        if (productRepository.count() == 0 && outsourcedPartRepository.count() == 0) {
            outsourcedPartRepository.save(o);
            outsourcedPartRepository.save(o2);
            outsourcedPartRepository.save(o3);
            outsourcedPartRepository.save(o4);
            outsourcedPartRepository.save(o5);

            productRepository.save(acoustic);
            productRepository.save(electric);
            productRepository.save(banjo);
            productRepository.save(ukulele);
            productRepository.save(bass);
        } else {
            System.out.println("There are already parts and products in the tables.");
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

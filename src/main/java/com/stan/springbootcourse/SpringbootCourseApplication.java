package com.stan.springbootcourse;

import com.stan.springbootcourse.dto.request.AddressDto;
import com.stan.springbootcourse.dto.request.CreateAddressRequest;
import com.stan.springbootcourse.dto.request.CreateUserRequest;
import com.stan.springbootcourse.dto.response.UserResponse;
import com.stan.springbootcourse.entity.*;
import com.stan.springbootcourse.repository.*;
import com.stan.springbootcourse.service.AddressService;
import com.stan.springbootcourse.service.UsersService;
import com.stan.springbootcourse.service.impl.UserServiceImpl;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootCourseApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringbootCourseApplication.class, args);

   /*     Users user = Users.builder()
            .email("omeje@gmail.com")
            .name("Chidozie")
            .password("123456")
            .build();

        Users users2 = new Users();
        users2.setEmail("chidozie@gmail.com");
        users2.setName("Chidozie");
        users2.setPassword("123456");


        Address address = Address.builder()
            .city("Egbeda")
            .street("Olaleka")
            .zip("123")
            .build();

        Address address1 = new Address();
        address1.setCity("Egbeda");
        address1.setStreet("Olaleka");
        address1.setZip("123");

        Profile profile = Profile.builder()
            .bio("eye")
            .build();

        Profile profile1 = new Profile();
        profile1.setBio("Finger");


        user.addAddress(address);
//        user.setProfile(profile);
//        profile.setUser(user);

        System.out.println(user);
        System.out.println(address);
        System.out.println(profile);

        UsersRepository repository = context.getBean(UsersRepository.class);
        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        ProfileRepository profileRepository = context.getBean(ProfileRepository.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
       // UsersService usersService = (UsersService) context.getBean("usersService");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        //user2, address1, profile1


          System.out.println("------------------");
        Users user1 = repository.save(user);
        System.out.println("Saved user1... "+user1);
        System.out.println("####################");

       /* System.out.println("------------------");
        Users user1 = repository.save(users2);
        System.out.println("Saved user1... "+user1);
        System.out.println("####################");

        address1.setUsers(user1);
        profile1.setUser(user1);
        Address savedAddress = addressRepository.save(address1);
        System.out.println("savedAddress... "+savedAddress);

        Profile savedProfile = profileRepository.save(profile1);
        System.out.println("savedProfile... "+savedProfile);*/

    /*    UserResponse userResponse = new UserResponse();
//        userResponse.setStatus("00");
//        userResponse.setMessage("Success");
////        userResponse.setUser(user1);
//        userResponse.setAddress(savedAddress);
//        userResponse.setProfile(savedProfile);

        System.out.println(userResponse);

        //List<Users> usersList = repository.findAll();
        //System.out.println("usersList "+ usersList.get(0).getEmail());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Category category = new Category();
        category.setName("Jingle");
        Category savedCategory = categoryRepository.save(category);
        System.out.println("savedCategory"+savedCategory);

        Products products = new Products();
        products.setCategory(category);
        products.setName("30s premium");
        products.setDescription("Premium");
        products.setPrice(BigDecimal.valueOf(3000));
        Products savedProducts = productRepository.save(products);
        System.out.println("savedProduct "+savedProducts);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Category newCategory = categoryRepository.findById(1l).get();
        Products products2 = new Products();
        products2.setCategory(newCategory);
        products2.setName("60s premium");
        products2.setDescription("Premium plus");
        products2.setPrice(BigDecimal.valueOf(6000));
        Products savedProducts2 = productRepository.save(products2);
        System.out.println("New savedProduct "+savedProducts2);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        //Users newUser = repository.findById(1l).get();
       /* Users newUser = new Users();
        List<Products> productsList = productRepository.findAll();
//        newUser.getProducts().addAll(productsList);
       // productsList.forEach(newUser::addProducts);
        productsList.forEach(newUser::addProducts);
         Users anotherUser = repository.save(newUser);
        System.out.println("New User "+anotherUser);*/


       /* UsersService usersService = context.getBean(UsersService.class);
        AddressService addressService = context.getBean(AddressService.class);

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Chidozie");
        createUserRequest.setEmail("chidozie1@gmail.com");
        createUserRequest.setPassword("123456");
        createUserRequest.setStreet("Olaleka");
        createUserRequest.setCity("Egbeda");
        createUserRequest.setZip("123");
        createUserRequest.setBio("Finger");
        createUserRequest.setPhoneNumber("08066635427");
        createUserRequest.setDateOfBirth(LocalDate.now());
        createUserRequest.setLocaltyPoints(2);
        createUserRequest.setProductName("jingle");
        createUserRequest.setProductDescription("Premium");
        createUserRequest.setPrice(BigDecimal.valueOf(3000));

        usersService.createUser(createUserRequest);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        CreateAddressRequest createAddressRequest = new CreateAddressRequest();
        List<AddressDto> addresses = new ArrayList<>();

        AddressDto addressDto = new AddressDto();
        addressDto.setCity("Chidozie");
        addressDto.setStreet("Olaleka");
        addressDto.setZip("123");

        AddressDto addressDto1 = new AddressDto();
        addressDto1.setCity("Chidozie");
        addressDto1.setStreet("Olaleka");
        addressDto1.setZip("123");

        AddressDto addressDto2 = new AddressDto();
        addressDto2.setCity("Chidozie");
        addressDto2.setStreet("Olaleka");
        addressDto2.setZip("123");

        addresses.add(addressDto);
        addresses.add(addressDto1);
        addresses.add(addressDto2);

        createAddressRequest.setUserId(11L);
        createAddressRequest.setAddresses(addresses);
        addressService.createAddress(createAddressRequest);


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Pageable pageable = PageRequest.of(0, 10);
        usersService.getAllUserUser(pageable);*/




    }

}

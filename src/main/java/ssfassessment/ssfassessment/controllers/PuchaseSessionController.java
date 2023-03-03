// package ssfassessment.ssfassessment.controllers;

// import org.springframework.http.MediaType;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// import jakarta.servlet.http.HttpSession;

// @Controller
// @RequestMapping(path="/cart")
// public class PuchaseSessionController {


//     @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//     public String postMapping(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {

        
//         System.out.println("Hello2");

//         String item = form.getFirst("item");
// 		String quantity = form.getFirst("quantity");


//         return "view1";
//     }
    
// }

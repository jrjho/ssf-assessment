package ssfassessment.ssfassessment.controllers;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.http.HttpSession;
import ssfassessment.ssfassessment.models.PurchaseOrder;
import ssfassessment.ssfassessment.services.PurchaseOrderService;

@Controller
// @RequestMapping(path = "")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService pOrderSvc;

    private Logger logger = Logger.getLogger(PurchaseOrderController.class.getName());

    @GetMapping(path = { "/", "/view1.html" })
    public String getIndex(Model model, HttpSession sess) {


        model.addAttribute("purchaseorder", new PurchaseOrder());
        PurchaseOrder po = new PurchaseOrder();
        // System.out.println(po.toString());
        System.out.println("Hello1");

        sess.setAttribute("purchaseorder", po);
        model.addAttribute("purchaseorder", po);

        return "view1";
    }

    @GetMapping(path = "/cart/shippingaddress")
    public String getShippingAddress(Model model, HttpSession sess){
        System.out.println("Hello4");
        PurchaseOrder purchaseOrder = (PurchaseOrder) sess.getAttribute("purchaseorder");

        sess.setAttribute("purchaseorder", purchaseOrder);
        model.addAttribute("purchaseorder", purchaseOrder);        
        return "view2";
    }

    @PostMapping(path = "/cart/shippingaddress/quotation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    public ResponseEntity<String>getQuotation(@RequestBody String payload){

        Reader reader = new StringReader(payload);
        JsonReader jsonReader = Json.createReader(reader);
		JsonObject json = jsonReader.readObject();

        // Quotation quotation = Quotation.getQuotation()


        return ResponseEntity.status(201).body(json.toString());

    }

    // public String postQuotation(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess) {

    //             return "hello";
    //         }

    @PostMapping(path = "/cart", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postMapping(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess
            ) {

        PurchaseOrder purchaseOrder = (PurchaseOrder) sess.getAttribute("purchaseorder");

        String name = form.getFirst("item");
        String quantity = form.getFirst("quantity");
        
        System.out.printf("Item is: %s\n", name);
        System.out.printf("Quantity is: %s\n", quantity);
        System.out.printf("PO is: %s\n", purchaseOrder.toString());

        pOrderSvc.updateCart(name, quantity, purchaseOrder);


        // purchaseOrder.setCart(name, Integer.parseInt(quantity));
        System.out.printf("Updated PO is: %s\n", purchaseOrder.toString());
        sess.setAttribute("purchaseorder", purchaseOrder);
        model.addAttribute("purchaseorder", purchaseOrder);

    
        //to display
        //----------------------------------------------------------------------
        List<String> itemQty = (List<String>)sess.getAttribute("itemQty");


        if (null == itemQty) {
			// If cart is null, then new session
            System.out.println("Hello3");

			itemQty = new LinkedList<>();
			sess.setAttribute("itemQty", itemQty);
			sess.setAttribute("name", name);


		}
        itemQty.add(quantity);

		model.addAttribute("itemQty", itemQty);
		model.addAttribute("name", name);
        //----------------------------------------------------------------------


        return "view1";
    }

}

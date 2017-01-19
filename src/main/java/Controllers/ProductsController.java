package Controllers;

import Tables.AllShopItems;
import Mapper.ProductMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody ProductMapper request) {
        try {
            AllShopItems allShopItems = new AllShopItems();
            allShopItems.addToTable();
            System.out.println("Success");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

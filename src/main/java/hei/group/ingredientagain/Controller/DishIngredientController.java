package hei.group.ingredientagain.Controller;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/ingredient")
public class ProductController {
    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;

    public ProductController(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @getMapping("/")
    public ResponseEntity<?> getAllIngredientEntity(){
        try{
            return ResponseEntity.ok(ingredientRepository.getListIngredient());
        } catch (java.lang.Exception e) {
          return ResponseEntity.Bad_Request("bad request");
        }
    }

    @getMapping("/{id}")
    public ResponseEntity<?> getIngredientById(@RequestParam int id){
        try{
            return ResponseEntity.ok(ingredientRepository.getListIngredient(id));
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }

        @RestController
        @RequestMapping("/ingredients")
        public class IngredientController {

            @GetMapping("/{id}/stock")
            public ResponseEntity<StockResponse> getStock(
                    @PathVariable int id,
                    @RequestParam(name = "at", required = true) String at,
                    @RequestParam(name = "unit", required = true) String unit
            ) {


                double stockValue = 10.5;

                StockResponse response = new StockResponse(unit, stockValue);

                return ResponseEntity.ok(response);
            }
        }
    }
}

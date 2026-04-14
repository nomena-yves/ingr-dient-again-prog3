package hei.group.ingredientagain.Controller;

import hei.group.ingredientagain.Repository.DishRepository;
import hei.group.ingredientagain.Repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class IngredientController {
    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;

    public ProductController(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredient")
    public ResponseEntity<?> getAllIngredientEntity(){
        try{
            return ResponseEntity.ok(ingredientRepository.getListIngredient());
        } catch (java.lang.Exception e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
        }
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<?> getIngredientById(@RequestParam int id){
        try{
            return ResponseEntity.ok(ingredientRepository.getListIngredient(id));
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/ingredient/{id}/stock")
    public ResponseEntity<?> getStock(
            @PathVariable int id,
            @RequestParam(name = "at", required = true) String at,
            @RequestParam(name = "unit", required = true) String unit
    ) {
        try{
            return ResponseEntity.status(HttpStatus.OK);
        } catch (java.lang.Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingredient.id={id) is not found");
        }
    }
}



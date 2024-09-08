package peaksoft.pestaran_task.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.menultem.*;
import peaksoft.pestaran_task.repository.MenultemRepository;
import peaksoft.pestaran_task.service.MenultemService;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenultemApi {
    private final MenultemService mService;
    private final MenultemRepository menultemRepository;

    @PostMapping({"{id}"})
    SimpleResponse saveRestaurant ( @PathVariable Long id, @RequestBody MenultemRequest menultemRequest) {
        return mService.saveRestaurant(id, menultemRequest);
    }
    @GetMapping("/price")
    public List<MeniltemRespomsePrice> getAllPrices(@RequestParam(value = "sort", defaultValue = "asc") String sortOrder) {
        return mService.getAllPrices(sortOrder);
    }
    @GetMapping("/search")
    public List<MenultemResponse> name(@RequestParam String word) {
        return mService.findMenultemByNameOrCategoryOrSubcategory(word);
    }
   @PostMapping()
   SimpleResponse price(@RequestBody MenultemRequest menultemRequest ){
        return mService.priceMenu(menultemRequest);
    }
    @GetMapping
    public List<MeniltemResponseGetAll> getAll(){
        return  mService.getAllMenultem();
    }
    @PostMapping("{id}update")
    public SimpleResponse update( @PathVariable Long id,@RequestBody MenultemRequestGetAll menultemRequest) {
        return mService.updateMenultem(id,menultemRequest);
    }
    @GetMapping("{id}")
    public MeniltemResponseGetAll getBYid(@PathVariable Long id){
        return mService.getMenultemById(id);
    }
    @DeleteMapping("{id}delete")
    public SimpleResponse delete(@PathVariable Long id){
        return mService.deleteMenultem(id);
    }
    @PostMapping("save")
    public SimpleResponse save(@RequestBody MenultemRequest menultemRequest) {
        return mService.saveMenultem(menultemRequest);
    }
}

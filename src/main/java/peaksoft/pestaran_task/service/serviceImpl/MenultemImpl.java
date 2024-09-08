package peaksoft.pestaran_task.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.menultem.*;
import peaksoft.pestaran_task.emum.Role;
import peaksoft.pestaran_task.entiti.Menultem;
import peaksoft.pestaran_task.entiti.Restaurant;
import peaksoft.pestaran_task.repository.MenultemRepository;
import peaksoft.pestaran_task.repository.RestaurantRepository;
import peaksoft.pestaran_task.service.MenultemService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MenultemImpl implements MenultemService {
    private final MenultemRepository menultemRepository;
    private final RestaurantRepository restaurantRepository;
    private static final boolean SORT_DESC = true;

    @Override
    public SimpleResponse waiterChatGet(Role role, MenultemRequest menultemRequest) {

        return null;
    }

    @Override
    public SimpleResponse saveRestaurant(Long id, MenultemRequest menultemRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Ресторан табылган жок, ID: " + id));
        Menultem menultem = new Menultem();
        menultem.setName(menultemRequest.getName());
        menultem.setImage(menultemRequest.getImage());
        menultem.setDescription(menultemRequest.getDescription());
        menultem.setPrice(menultemRequest.getPrice());
        menultem.setIsVegetarian(menultemRequest.getIsVegetarian());
        restaurant.getMenuItems().add(menultem);
        menultem.setRestaurant(restaurant);
        menultemRepository.save(menultem);
        return new SimpleResponse(
                HttpStatus.OK,
                "сакталды"
        );
    }

    @Override
    public SimpleResponse priceMenu(MenultemRequest menultemRequest) {
        Menultem menultem = new Menultem();
        menultem.setName(menultemRequest.getName());
        menultem.setImage(menultemRequest.getImage());
        menultem.setDescription(menultemRequest.getDescription());
        if (menultemRequest.getPrice() >= 0) {
            menultem.setPrice(menultemRequest.getPrice());
        } else {
            return new SimpleResponse(
                    HttpStatus.BAD_REQUEST,
                    "сиз терс сан берип атасыз"
            );
        }
        menultem.setIsVegetarian(menultemRequest.getIsVegetarian());
        menultemRepository.save(menultem);
        return new SimpleResponse(HttpStatus.OK, "сакталды");
    }



        @Override
    public List<MenultemResponse> findMenultemByNameOrCategoryOrSubcategory(String word) {
        String word1 = "someName";
        List<MenultemResponse> results = menultemRepository.findMenultemByNameOrCategoryOrSubcategory(word);
        results.forEach(System.out::println);
        return results;
    }

    @Override
    public SimpleResponse deleteMenultem(Long id) {
        Menultem menultem = menultemRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("menultem табылган жок, ID: " + id));
        menultemRepository.delete(menultem);
        return new SimpleResponse(
                HttpStatus.OK,
                "очту"
        );
    }

    @Override
    public SimpleResponse updateMenultem(Long id, MenultemRequestGetAll menultemRequest) {
        Menultem menultem =   menultemRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("menultem табылган жок, ID: " + id));
        menultem.setName(menultemRequest.getName());
        menultem.setImage(menultemRequest.getImage());
        menultem.setDescription(menultemRequest.getDescription());
        menultem.setPrice(menultemRequest.getPrice());
        menultemRepository.save(menultem);
        return new SimpleResponse(
                HttpStatus.OK,
                "озгорду"
        );
    }

    @Override
    public MeniltemResponseGetAll getMenultemById(Long id) {
        Menultem menultem =   menultemRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("menultem табылган жок, ID: " + id));
        MeniltemResponseGetAll menultemResponse =  new MeniltemResponseGetAll();
        menultemResponse.setName(menultem.getName());
        menultemResponse.setImage(menultem.getImage());
        menultemResponse.setDescription(menultem.getDescription());
        menultemResponse.setPrice(menultem.getPrice());
        return menultemResponse;
    }

    @Override
    public SimpleResponse saveMenultem(MenultemRequest menultemRequest) {
        Menultem menultem = new Menultem();
        menultem.setName(menultemRequest.getName());
        menultem.setImage(menultemRequest.getImage());
        menultem.setDescription(menultemRequest.getDescription());
        menultem.setPrice(menultemRequest.getPrice());
        menultemRepository.save(menultem);
        return new  SimpleResponse(
                HttpStatus.OK,
                "сакталды"
        );
    }

    @Override
    public List<MeniltemResponseGetAll> getAllMenultem() {
        List<Menultem> menultems =  menultemRepository.findAll();
        List<MeniltemResponseGetAll> meniltemResponseGetAlls = new ArrayList<>();
        for (Menultem menultem : menultems) {
            meniltemResponseGetAlls.add(MeniltemResponseGetAll.builder()
                            .name(menultem.getName())
                            .image(menultem.getImage())
                            .description(menultem.getDescription())
                            .isVegetarian(menultem.getIsVegetarian())
                    .build());
        }
        return meniltemResponseGetAlls;
    }


    public List<MeniltemRespomsePrice> getAllPrices(String sortOrder) {
        List<Menultem> menultems = menultemRepository.findAll();
        if ("desc".equalsIgnoreCase(sortOrder)) {
            menultems.sort((a, b) -> Integer.compare(b.getPrice(), a.getPrice()));
        } else {
            menultems.sort((a, b) -> Integer.compare(a.getPrice(), b.getPrice()));
        }
        List<MeniltemRespomsePrice> responsePrices = new ArrayList<>();
        for (Menultem menultem : menultems) {
            responsePrices.add(MeniltemRespomsePrice.builder()
                    .price(menultem.getPrice())
                    .build());
        }

        return responsePrices;
    }
}

















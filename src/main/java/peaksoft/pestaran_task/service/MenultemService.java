package peaksoft.pestaran_task.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import peaksoft.pestaran_task.dto.SimpleResponse;
import peaksoft.pestaran_task.dto.menultem.*;
import peaksoft.pestaran_task.emum.Role;
import peaksoft.pestaran_task.entiti.Restaurant;

import java.util.List;

public interface MenultemService {
    SimpleResponse waiterChatGet(Role role, MenultemRequest menultemRequest);
    SimpleResponse saveRestaurant(Long id ,MenultemRequest menultemRequest);
    SimpleResponse priceMenu(MenultemRequest menultemRequest);
    List<MeniltemRespomsePrice>getAllPrices(String sortOrder);
    List<MenultemResponse> findMenultemByNameOrCategoryOrSubcategory(String menultemName);
    SimpleResponse deleteMenultem(Long id );
    SimpleResponse updateMenultem(Long id, MenultemRequestGetAll menultemRequest);
    MeniltemResponseGetAll getMenultemById(Long id);
    SimpleResponse saveMenultem( MenultemRequest menultemRequest);
    List<MeniltemResponseGetAll> getAllMenultem();

    }


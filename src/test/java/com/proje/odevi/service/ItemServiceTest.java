package com.proje.odevi.service;


import com.proje.odevi.model.entity.Item;
import com.proje.odevi.model.entity.Orders;
import com.proje.odevi.repository.ItemRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {


    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;


    @Test
    void getAllItem() {
        // init
        List<Item> expItemList = new ArrayList<>();
        Item item1 = new Item(1L, "Car1", 1000.00, null);
        Item item2 = new Item(2L, "Car2", 1000.00, null);
        Item item3 = new Item(3L, "Car3", 1000.00, null);
        expItemList.add(item2);
        expItemList.add(item1);
        expItemList.add(item3);

        //when
        Mockito.when(itemRepository.findAll()).thenReturn(expItemList);

        //then
        List<Item> actualItemList = itemService.getAllItems();

        Assert.assertEquals(expItemList.size(), actualItemList.size());

        System.out.println("First: " + expItemList);
        expItemList = expItemList.stream().sorted(getItemComparator()).collect(Collectors.toList());
        actualItemList = actualItemList.stream().sorted(getItemComparator()).collect(Collectors.toList());
        for (int i = 0; i < expItemList.size(); i++) {
            Item currExpItem = expItemList.get(i);
            Item currActualItem = actualItemList.get(i);
            Assert.assertEquals(currExpItem.getItemId(), currActualItem.getItemId());
            Assert.assertEquals(currExpItem.getName(), currActualItem.getName());
        }

        System.out.println("Second: " + expItemList);

    }

    private Comparator<Item> getItemComparator() {
        return (o1, o2) -> {
            if (o1.getItemId() - o2.getItemId() < 0)
                return -1;
            if (o1.getItemId() - o2.getItemId() == 0)
                return 0;
            return 1;
        };
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}
}

package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    private Item getItemById(int id) {
        for (Item i : items) {
            if (i.getProductOption().getProductOptionID() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t) {
        if (getItemById(t.getProductOption().getProductOptionID()) != null) {
            Item m = getItemById(t.getProductOption().getProductOptionID());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public int getTotalMoney() {
        int t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    private ProductOptions getProductOptionsById(int id, List<ProductOptions> list) {
        for (ProductOptions po : list) {
            if (po.getProductOptionID() == id) {
                return po;
            }
        }
        return null;
    }

    public Cart(String txt, List<ProductOptions> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("-");
                for (String c : s) {
                    String[] n = c.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    ProductOptions p = getProductOptionsById(id, list);
                    Item t = new Item(p, quantity, (int) (p.getPrice()));
                    addItem(t);
                }
            }
        } catch (Exception e) {
        }
    }
}

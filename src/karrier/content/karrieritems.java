package karrier.content;

import arc.Events;
import arc.graphics.Color;
import arc.util.Log;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.type.Item;

public class karrieritems {
    public static Item diamond,tin,aluminum,lithium,coveredlithium,manganese,graphene;
    public static void load(){
        lithium = new Item("lithium", Color.valueOf("CC007A")){{
            hardness = 1;
            cost = 1.1f;
            flammability=100;
            explosiveness=100;
        }};
        diamond = new Item("diamond", Color.valueOf("7EE0F9")){{
            hardness = 10;
            cost = 0.1f;
        }};
        tin = new Item("tin", Color.valueOf("FFFFFF")){{
            hardness = 1;
            cost = 1;
        }};
        aluminum = new Item("aluminum", Color.valueOf("B8B8B8")){{
            hardness = 1;
            cost = 0.9f;
        }};
        coveredlithium = new Item("covered-lithium", Color.valueOf("CC007A")){{
            cost = 1f;
        }};
        manganese = new Item("manganese", Color.valueOf("FF00FF")){{
            cost = 0.8f;
            hardness = 2;
        }};
        graphene = new Item("graphene", Color.valueOf("111111")){{
            cost = 1f;
        }};
        Events.on(ClientLoadEvent.class, e -> {
            Log.info("Items loaded.");
        });
    }
}

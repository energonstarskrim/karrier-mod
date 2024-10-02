package karrier;

import arc.util.Log;
import karrier.content.karrierblocks;
import karrier.content.karrieritems;
import mindustry.mod.Mod;

public class karriermod extends Mod{
    @Override
    public void loadContent(){
        karrieritems.load();
        Log.info("Items loaded.");
        karrierblocks.load();
        Log.info("Blocks loaded.");
        Log.info("Mod loaded.");
    }
}

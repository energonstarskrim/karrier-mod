package karrier.content;
import static mindustry.type.ItemStack.*;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.Junction;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
public class karrierblocks {
    public static Block oreTin,autoDrill,oreAluminum,oreLithium,physycalPump,chemicalGenerator,easyWall,largeeasyWall,tinRouter,tinSorter,tinConveyor,
    tinliquidRouter,tinconduit,tinliquidJunction,tinjunction,coverer,beamwire,ignitor,motorDrill,delaminator,manganeseWall,largemanganeseWall,geothermalGenerator,easyArtilery;

    public static void load(){
        oreLithium = new OreBlock("ore-lithium", karrieritems.lithium){{
            oreDefault = true;
            oreThreshold = 0.878f;
            oreScale = 19.7239f;
            variants = 1;
        }};
        oreTin = new OreBlock("ore-tin", karrieritems.tin){{
            oreDefault = true;
            oreThreshold = 0.778f;
            oreScale = 20.7239f;
            variants = 2;
        }};
        oreAluminum = new OreBlock("ore-aluminum", karrieritems.aluminum){{
            oreDefault = true;
            oreThreshold = 0.797f;
            oreScale = 18.7239f;
            variants = 2;
        }};
        autoDrill = new Drill("automatic-drill"){{
                requirements(Category.production, with(karrieritems.tin, 20));
                tier = 1;
                drillTime = 700;
                size = 2;
        }};
        physycalPump = new Pump("physical-pump"){{
            requirements(Category.liquid, with(karrieritems.aluminum, 20, karrieritems.lithium, 5));
            pumpAmount = 1f / 6f;
            size = 1;
        }};
        chemicalGenerator = new ConsumeGenerator("chemical-generator"){{
            requirements(Category.power, with(karrieritems.aluminum, 45, karrieritems.tin, 20));
            powerProduction = 2f;
            itemDuration = 90f;
            
            consumeLiquid(Liquids.water, 0.3f);
            consumeItem(karrieritems.lithium);
            hasLiquids = true;
            size = 1;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
        }};
        easyWall=new Wall("easy-wall"){{
            requirements(Category.defense, with(karrieritems.aluminum, 4, karrieritems.tin, 2));
            health=200;
        }};
        largeeasyWall=new Wall("large-easy-wall"){{
            requirements(Category.defense, with(karrieritems.aluminum, 16, karrieritems.tin, 8));
            health=200*4;
            size=2;
        }};
        manganeseWall = new Wall("manganese-wall"){{
            requirements(Category.defense, with(karrieritems.manganese, 8, karrieritems.lithium, 2));
            health=520;
        }};
        largemanganeseWall = new Wall("large-manganese-wall"){{
            requirements(Category.defense, with(karrieritems.manganese, 32, karrieritems.lithium, 8));
            health=520*4;
            size=2;
        }};
        tinRouter = new Router("tin-router"){{
            requirements(Category.distribution, with(karrieritems.tin, 3));
            health=10;
            buildCostMultiplier = 4f;
        }};
        tinSorter = new Sorter("tin-sorter"){{
            requirements(Category.distribution, with(karrieritems.tin ,5));
            health=10;
            buildCostMultiplier = 3f;
            invert = true;
        }};
        tinConveyor = new Conveyor("tin-conveyor"){{
            requirements(Category.distribution, with(karrieritems.tin, 1));
            health=10;
            buildCostMultiplier = 2f;
            speed = 0.03f;
            displayedSpeed = 4.2f;
        }};
        tinliquidRouter = new LiquidRouter("tin-liquid-router"){{
            requirements(Category.liquid, with(karrieritems.tin, 20));
            health=10;
            liquidCapacity = 10f;
            underBullets = true;
            solid = false;
        }};
        tinconduit = new Conduit("tin-pipe"){{
            requirements(Category.liquid, with(karrieritems.tin, 5));
            health = 10;
        }};
        tinliquidJunction = new LiquidJunction("tin-liquid-junction"){{
            requirements(Category.liquid, with(karrieritems.tin, 3));
            solid = false;
        }};
        tinjunction = new Junction("tin-junction"){{
            requirements(Category.distribution, with(karrieritems.tin, 2));
            speed = 20;
            capacity = 6;
            health = 10;
            buildCostMultiplier = 6f;
        }};
        coverer = new GenericCrafter("chemical-isolator"){{
            requirements(Category.crafting, with(karrieritems.tin, 10, karrieritems.aluminum, 50));
            outputItem = new ItemStack(karrieritems.coveredlithium, 2);
            craftEffect = Fx.smoke;
            craftTime = 60f;
            size = 2;
            hasPower = true;
            health=100;
            consumeItems(with(karrieritems.lithium, 2, karrieritems.tin, 1));
            consumePower(1f);
        }};
        beamwire = new PowerNode("beam-wire"){{
            requirements(Category.power, with(karrieritems.coveredlithium, 5, karrieritems.aluminum, 2));
            maxNodes = 15;
            laserRange = 8;
        }};
        ignitor = new ItemTurret("ignitor"){{
            requirements(Category.turret, with(karrieritems.aluminum, 50, karrieritems.tin, 20));
            ammo(
                karrieritems.lithium, new BasicBulletType(3f, 16){{
                    width = 5f;
                    height = 10f;
                    lifetime = 70f;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("CC007A");
                    status = StatusEffects.burning;
                    makeFire = true;
                    range = 200f;
                }});
            reload=10f;
            range=200f;
            health=200;
        }};
        motorDrill = new Drill("motor-drill"){{
            requirements(Category.production, with(karrieritems.aluminum, 20, karrieritems.coveredlithium, 10));
            tier = 2;
            drillTime = 500;
            size = 2;
        }};
        delaminator = new GenericCrafter("delaminator"){{
            requirements(Category.crafting, with(karrieritems.manganese, 10, karrieritems.aluminum, 60, karrieritems.coveredlithium, 15));
            outputItem = new ItemStack(karrieritems.graphene, 1);
            craftTime = 80f;
            size = 3;
            hasPower = true;
            health=280;
            consumeItems(with(Items.coal, 2));
            consumePower(3.5f);
        }};
        geothermalGenerator = new ThermalGenerator("geothermal-Generator"){{
            requirements(Category.power, with(karrieritems.aluminum, 20, karrieritems.manganese, 65, karrieritems.graphene, 25));
            powerProduction = 3.5f;
            generateEffect = Fx.generatespark;
            effectChance = 0.001f;
            size = 2;
            floating = true;
        }};
        easyArtilery = new ItemTurret("easy-artilery"){{
            requirements(Category.turret, with(karrieritems.aluminum, 100, karrieritems.graphene, 20, karrieritems.coveredlithium, 10, karrieritems.manganese, 40));
            ammo(
                karrieritems.lithium, new BasicBulletType(1f, 72){{
                    width = 10f;
                    height = 20f;
                    lifetime = 70f;
                    ammoMultiplier = 1;
                    frontColor = Color.valueOf("FFFFFF");
                    makeFire = false;
                    range = 200f;
                    
                }},
                karrieritems.lithium, new BasicBulletType(0.7f, 144){{
                    width = 5f;
                    height = 10f;
                    lifetime = 70f;
                    ammoMultiplier = 1;
                    frontColor = Color.valueOf("FF00FF");
                    status = StatusEffects.slow;
                    makeFire = false;
                    range = 150f;}});
            reload=200f;
            range=500f;
            health=350;
            maxAmmo=1;
            size = 2;
        }};
    }
}

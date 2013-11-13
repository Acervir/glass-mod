package acervir.glass.entities;

import net.minecraft.entity.Entity;

public class Entities
{
    public static Entity entity;
    
    public static void init() {
        entity = new LightningStrikeEvent(null, 0, 0, 0);
    }

}

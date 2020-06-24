package com.meeku.blockdeleter;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Deleter implements Runnable {
    private Block block;

    public Deleter(Block b) {
        block = b;
    }

    @Override
    public void run() {
        block.setType(Material.AIR);
    }
}

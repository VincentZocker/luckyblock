package mod.lucky.resources;

import mod.lucky.drop.DropContainer;
import mod.lucky.resources.loader.BaseLoader;
import mod.lucky.util.LuckyReader;

public class ResourceNaturalGen extends BaseResource {
  @Override
  public void process(LuckyReader reader, BaseLoader loader) {
    try {
      String section = "";
      String curLine;
      while ((curLine = reader.readLine()) != null) {
        if (curLine.startsWith(">")) {
          section = curLine;
          continue;
        }

        DropContainer drop = new DropContainer();
        drop.readFromString(curLine);
        if (section.equals(">surface")) loader.getBlock().getWorldGenerator().addSurfacedDrop(drop);
        if (section.equals(">nether")) loader.getBlock().getWorldGenerator().addNetherDrop(drop);
        if (section.equals(">end")) loader.getBlock().getWorldGenerator().addEndDrop(drop);
      }
    } catch (Exception e) {
      System.err.println("Lucky Block: Error reading 'drops.txt'");
      e.printStackTrace();
    }
  }

  @Override
  public String getDirectory() {
    return "natural_gen.txt";
  }
}
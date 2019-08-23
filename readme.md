
## Engineer's Decor

A [Minecraft](https://minecraft.net) (Java Edition) mod based on
[`Forge`](http://www.minecraftforge.net/), adding cosmetic blocks
for the Engineer's factory, workshop, and home.

![](documentation/engineers-decor-v103-summary.png)

### Distribution file download

Main distribution channel for this mod is CurseForge:

  - Release/beta versions: https://www.curseforge.com/minecraft/mc-mods/engineers-decor/files
  - All versions: https://minecraft.curseforge.com/projects/engineers-decor/files

----
### Details

The mod has its focus decorative blocks and devices helping you to build nice
looking manufacturing contraptions. Current feature set:

- *Treated wood crafting table*: 3x3 crafting table with IE style GUI and a model
  fitting better in the engineer's workshop. Keeps its inventory, has eight additional
  storage slots on the left side of the crafting grid. Crafted 2x2 with three
  treated wood planks and one vanilla crafting table.

- *Small laboratory furnace*: Solid fuel consuming, updraught. Slightly hotter and
  better isolated than a cobblestone furnace, therefore more efficient. Has internal
  hopper FiFos for input, output, and fuel (two stacks each). Two auxilliary slots
  (storage tray). Keeps inventory when relocated. Crafted with one cobblestone
  furnace, one hopper, and seven metal plates.

- *Small electrical furnace*: Pass-through electrical furnace. Can pull items out
  input side inventories, inserts items into inventories at the output side. Internal
  fifo slots. Automatically bypasses items that cannot be cooked or smelted. Electrical
  RF/FE power can be applied on all sides. Items can be inserted or drawn from all
  sides (e.g. with filtered hopper or whatever). Fits ideally into a conveyor belt
  line/lane. Consumption and efficiency tunable via config.

- *Factory dropper*: Dropper with GUI configurable drop force, direction, stack size,
  trigger cool-down delay, and trigger logic. Three trigger slots ("filter slots") can
  be used as internal trigger. They emit an internal signal if their item is found in
  in the dropper inventory (also at least the stack size of a trigger slot). Internal
  triggers can be easily combined with the external redstone signal trigger using
  logical *AND* or *OR* gates. If internal triggers match, the dropper will spit out
  exactly the stacks in these slots. That allows to drop e.g. always nine lapis,
  redstone, nuggets, etc on a conveyor to feed a compression metal press - instantly
  and automatically after nine of these items have been inserted into the dropper.

- *Small waste incinerator*: Buffered and delayed item disposal device. 16 fifo
  slots are filled when new items are pushed in from any side. A GUI allows to
  take out accidentally trashed items or put in items to get rid of. When the fifo
  is full, the oldest stack will be disposed. The processing speed can be increased
  by connecting electrical RF/FE power.

- *Clinker bricks*: Slightly darker and more colorful version of the vanilla brick
  block. Eight position dependent texture variations are implemented to make the
  wall look more "alive". Crafted 3x3 with a brick block in the centre and any
  combination of bricks and nether bricks around (actually, anything where the
  ore dictionary says it's a "brick ingot"). Higher explosion resistance than the
  vanilla bricks. Also available as stairs and wall, crafted as usual. There
  is a reverse recipe to get three clinker brick blocks back from stairs or walls.

- *Slag bricks*: Gray-brownish brick, also eight texture variations. Crafted 3x3
  from slag in the centre and any kind of bricks ("brick ingot") around. Has a higher
  explosion resistance than bricks. Also available as stairs and wall, also with
  reverse recipes.

- Rebar (steel) reinforced concrete: Expensive but creeper-proof. Crafted 3x3 from
  four concrete blocks and five steel rods. Texture design oriented at the IE concrete,
  slightly darker, eight (position dependent) random texture variations with rust
  traces. Also creaftable in form of *stairs* and *walls*. Like the IE contrete *tiles*,
  you can craft rebar concrete tiles with corresponding stairs. Reverse recipes
  available for all blocks crafted from rebar concrete.

- Concrete wall: Solid concrete wall (not the vanilla wall design), crafted 3x3
  from six IE concrete blocks (normal wall recipe).

- *Treated wood ladder*: Crafted 3x3 with the known ladder pattern, items are
  treated wood sticks. Climbing is faster if looking up/down and not sneaking.

- *Metal rung ladder*: Industrial wall-fixed ladder with horizontal bent rods.
  Crafted 3x3 with five iron or steel rods in a "U" pattern. Climbing is faster
  if looking up/down and not sneaking.

- *Staggered metal steps*: Industrial wall-fixed sparse ladder with steps in a
  zip pattern. Crafted 3x3 with six iron or steel rods in a zip pattern. Climbing
  is faster when looking up/down and not sneaking.

- *Panzer glass*: Reinforced, dark gray tinted glass block. Explosion-proof.
  Faint structural lines are visible, multiple texture variations for seemless
  look. Crafted 3x3 with four metal rods, four glass blocks, and one diamond.

- *Treated wood table*: Four leg table made out of treated wood. Crafted 3x3
  with three treated wood slabs and four treated wood poles. Guess the pattern.

- *Treated wood stool*: Simple small stool fitting to the table. Crafted 3x3
  with three treated wood slabs and one treated wood pole.

- *Treated wood pole*: Pole fragment that can be placed in all directions. It
  does intentionally not connect to posts, fences, etc - just a straigt pole.
  Can be used e.g. for structural support or wire relay post, where the height
  of the IE wire posts does not match.

- *Thin and thick steel support poles*: Hollow steel pole fragments, can be
  placed in all directions. Also with head/food end components. Thin poles crafted
  3x3 from three steel ingots (output 12), thick poles crafted 3x3 from six thin
  steel poles.

- *Double-T steel support*: Horizontal top-aligned support beam, placed in the
  direction you look. Auto connects to adjacent beams if facing towards them. Auto
  connects to steel poles underneath. Crafted 3x3 from thin steel poles in a T-shape
  (output: 6 beams).

- *Inset spot light*: Small metal framed glowstone based light source for ceiling,
  wall, or floor. Light level like a torch. Thin, hence not blocking the way.
  Allows illuminating places where electrical light installations are problematic.

- *Fluid pipe check valve*: Check valve: IE fluid pipe styled straight valve that
  conducts fluids only in one direction. Crafted from 3x3 from three fluid pipes.
  Supports IE pressurized fluid transfer.

- *Redstone controlled valves*: Conduct only in one direction, on-off
  variant (open on redstone power) and analog variant (closed at power 0, linear
  flow slope, fully open at power 15). Support IE pressurized fluid transfer.

- *Passive fluid accumulator*: Block with one output and five input sides, that
  draws fluids out of adjacent tanks when a pump drains fluid from the output port.
  Implicit round-robin balanced drain from adjacent blocks. Random initial fluid
  drip-in to allow pumps to detect that fluids can be drained. The accumulator
  has a vacuum suction delay.

- *Industrial signs*: "Danger", "electrical hazard", etc.

- *Slab slices*: Decorative stackable thin slabs made of of IE metal sheets,
  concretes, treated wood. Useful e.g. for roofs or ramps. Left-clicking with
  the same slab type in your hand while looking up/down removes slices again.
  Crafted 3x3 from four slabs.

More to come slowly but steadily.

----
### Mod pack integration, forking, back ports, bug reports, testing

  - Packs: If your mod pack ***is open source as well and has no installer***,
    you don't need to ask and simply integrate this mod. The mod has an extensive
    configuration allowing you to choose exactly which features you want, and
    additional tweaks like furni power consumption, smelting speed etc, allow
    to adapt the mod to the context it is used in.

  - Bug reports: Yes, please let me know. Drop a mail or better open an issue
    for the repository.

  - Translations: Please translate the 1.12 lang files if possible (because the
    1.13+ JSON language files are automatically generated from these `.lang`
    files - saves me a bit of work).

  - Pull requests: Happily accepted. Please make sure that use the ***develop
    branch*** for pull requests. The master branch is for release versions only.
    I might merge the pull request locally if I'm ahead of the github repository,
    we will communicate this in the pull request thread then.

  - The mod config has an "include testing features" option. Enabling this causes
    blocks under development to be registered as well.

----
## Version history

Mod versions are tracked in the readme files for individual Minecraft versions, and
of course in the commits of this repository. Beta and release versions that are
distributed as compiled `jar`s are tagged accordingly. Release versions are merged
into the `master` branch, while beta/alpha version tags link to `develop` branch
commits.

  - [1.12](1.12/readme.md)

  - [1.14](1.14/readme.md)

### Community references

Mods covering similar features, or may fit well together with IE and the decorations of this mod:

- [Immersive Engineering](https://github.com/BluSunrize/ImmersiveEngineering/): Without IE, my
  little mod here does not make much sense ;). It works without IE, but quite a few blocks are
  not craftable.

- [Engineer's doors](https://www.curseforge.com/minecraft/mc-mods/engineers-doors) has brilliant
  doors, trapdoors, and fence doors, all made of the IE materials.

- [Dirty Bricks](https://www.curseforge.com/minecraft/texture-packs/dirty-bricks-vanilla-add-on) applies
  position dependent variations to the vanilla bricks, similar to the clinkers and slag bricks in this
  mod.

- [Chisel](https://www.curseforge.com/minecraft/mc-mods/chisel) needless to say, Chisel has a variety
  of factory blocks.

### Screenshots

![Concrete](documentation/engineers-decor-v100a-concrete-stuff.png)

![v1.0.1 summary](documentation/engineers-decor-v101a-summary.png)

![Crafting table GUI](documentation/engineers-decor-v104a-craftinggui.png)

![Lab furnace GUI](documentation/engineers-decor-v103-labfurnacegui.png)

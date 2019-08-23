
## Engineer's Decor (MC1.12.2)

Mod sources for Minecraft version 1.12.2.

- Description, credits, and features: Please see the readme in the repository root.

- Compiled mod distribution channel is curseforge: https://www.curseforge.com/minecraft/mc-mods/engineers-decor/files.

----
## Version history

    ~ v1.0.11-b2 [A]

    - v1.0.11-b1 [M] Lang update ru-ru (Shellyoung, PR #45).
                 [F] Fixed bounding box of the Steel Table.
                 [M] Steel Floor Frating: Items fall through.

                 -------------------------------------------------------------------
    - v1.0.10    [R] Release based on v1.0.10-b2. Release-to-release changes:
                     * Steel table added.
                     * Steel floor grating added.
                     * Treated wood side table added.
                     * Exit Sign added.
                     * Recipe fixes.
                 -------------------------------------------------------------------

    - v1.0.10-b2 [A] Steel table added.
                 [A] Steel floor grating added.

    - v1.0.10-b1 [A] Treated wood side table added.
                 [F] Fixed recipe collision of Metal Rung Ladder (issue #37,
                     thx ProsperCraft for reporting).
                 [A] Added Exit Sign (texture design by J. Carver).

                 -------------------------------------------------------------------
    - v1.0.9     [R] Release based on v1.0.9-b3. Release-to-release changes:
                     * Slabs for clinker, concrete, slag bricks.
                     * Slab slices for sheet metals, treated wood, and concretes.
                     * Language updates.
                     * Block hardness adaptions.
                     * 1st/3rd person item model fixes.
                     * Furnace initialisation issue fixed.
                 -------------------------------------------------------------------

    - v1.0.9-b3  [A] Added missing recipes for slabs.
                 [A] Added slab slices for IE sheet metals, treated wood,
                     and concretes (stackable "quater-slabs").
                 [M] Updated 1st/3rd person item model rotations/translations.
                 [M] Hardness of valves and furni slightly increased.

    - v1.0.9-b2  [A] Added slabs for Clinker Brick, Slag Brick, Rebar Concrete,
                     and Stained Clinker. Texture variations like the base blocks.
                     Allow fast pick-up (see tooltip help or config).
                 [F] Fixed lab/electrical furnace initialisation issue (first item
                     inserted was smelted directly).

    - v1.0.9-b1  [U] Lang file ru_ru updated (PR#31, yaroslav4167).
                 [M] Block hardness adaptions (issue #32).

                 -------------------------------------------------------------------
    - v1.0.8     [R] Release based on v1.0.8-b2. Release-to-release changes:
                     * Added factory area sign.
                     * Added stained clinker.
                     * Config opt-out fixes, detailed feature selection possible now.
                     * Recipe adaptions and fixes.
                     * Lang files updated.
                 -------------------------------------------------------------------
                 [A] Added stained clinker brick block/stairs. Can be mixed with
                     "normal" clinkers.
                 [A] Added opt-out option for CTRL-SHIFT tooltips.
                 [M] Recipe condition requirements updated, recipes categorized.

    - v1.0.8-b2  [F] Config opt-out fixed (thx IronPiston for the report #30).
                 [A] Added opt-out config for detailed including/excluding
                     of features (using registry name wildcard matching).

    - v1.0.8-b1  [A] Added "Factory area" sign.
                 [M] Electrical furnace recipe changed (hoppers to conveyors).
                 [A] Opt-out config options added.
                 [F] Lang file fixes for en_us (Angela, PR#29).

                 -------------------------------------------------------------------
    - v1.0.7     [R] Release based on v1.0.7-b2. Release-to-release changes:
                     * Factory dropper added.
                     * Defense system warning sign added.
                     * Warning sign backgrounds adapted.
                     * Standalone recipes added.
                     * Lang files updated.
                 -------------------------------------------------------------------
                 [A] Added standalone recipes for signs, factory dropper, and
                     electrical furnace.
                 [M] Adapted "Caution" sign backgrounds to the yellow defense
                     system warning background.

    - v1.0.7-b2  [A] Added Defense System Warning sign (design by J. Carver).
                 [M] Factory dropper non-experimental now. GUI click area tuning.
                     "Fast drop" symbol replaced from arrow to dog icon (thx
                     overchoice for that icon).
                 [M] Lang files updated.

    - v1.0.7-b1  [M] Factory dropper (config:experimental) button placement fixed,
                     GUI vs external view x/y markers added, internal trigger logic
                     simplified. Thx @overchoice for beta testing!

                 -------------------------------------------------------------------
    - v1.0.6     [R] Release based on v1.0.6-b1. Release-to-release changes:
                     * Fixed FML remapping issue (COULD CAUSE CRASHES).
                     * Small waste incinerator added.
                     * Lang files updated/corrections.
                     * Metal ladder easier to break.
                 -------------------------------------------------------------------
                 [A] Added factory dropper (config:experimental).
                 [C] Thx to abdurraslan for the detailed issue #25.

    - v1.0.6-b1  [A] Added small waste incinerator (delayed fifo-buffered item disposal).
                 [M] Fixed item/block name capitalization (by Voxelo).
                 [M] Metal ladders are easier to break/harvest.
                 [F] Fixed FML remapping issue by using dedicated IItemHandler instances.

                 -------------------------------------------------------------------
    - v1.0.5     [R] Release based on v1.0.5-b1. Release-to-release changes:
                     * Small electrical passthrough-furnace added.
                     * Passive fluid accumulator added.
                     * Config options added.
                     * Sign plates added.
                     * Minor bug fixes.
                 -------------------------------------------------------------------
                 [A] Added sign "Electrical hazard"/"Caution hot wire".
                 [A] Added sign "Caution dangerous there" (skull/bones).

    - v1.0.5-b1  [A] Added passive fluid accumulator.
                 [A] Added small electrical passthrough-furnace.
                 [F] Fixed version check URL.
                 [M] Opt-out config options for valves, passive fluid accumulator,
                     and furni.

                 -------------------------------------------------------------------
    - v1.0.4     [R] Release based on v1.0.4-b9. Release-to-release changes:
                     * Crafting table: Quick crafting history re-fab, JEI integration.
                     * Rendering improvements and issue fixes (stairs, ambient occlusion,
                       optifine, etc).
                     * Walls with texture variations.
                     * Thin/thick steel poles with support feet/heads.
                     * Horizontal steel double-T support beams added.
                     * Fluid pipe valves added: Check valve, redstone controlled valve,
                       analog redstone controlled valve. Support pressurized transfer.
                     * Tool tip documentation (CTRL-SHIFT) for stairs added.
                     * Internal code cleanups.
                     * Recipes tuned.
                 -------------------------------------------------------------------
                 [E] Added pass-through electrical furnace (experimental, see config).

    - v1.0.4-b9  [F] Inserting fluids with pressurized tag only into IE piping.
                 [F] Valve redstone connector rendering does not check for
                     "can connect redstone" but only for "can provide power".
                 [M] Valves are adapted to be detected as pipe by IE.

    - v1.0.4-b8  [F] Fixed stairs rendering without smooth light (thanks rastot9).
                 [E] Added passive fluid accumulator (experimental feature, see config).

    - v1.0.4-b7  [F] Fixed recipe loading issue if IE is not installed.
                 [M] Valves support IE pressurized fluid transfer.

    - v1.0.4-b6  [A] Added redstone controlled fluid valve.
                 [A] Added redstone controlled analog fluid valve.
                 [M] Check valve recipe adapted (thanks majijn).

    - v1.0.4-b5  [A] Horizontal steel double-T support beam with pole connections.
                 [A] Added fluid pipe check valve (straight, conducts only one way).
                 [M] Internal registration block/te handling changed.

    - v1.0.4-b4  [F] Clinker/slag brick wall side cullfacing disabled to prevent
                     texture leaks when connecting to concrete walls.
                 [F] Unused treated wood pole texture regions filled (optifine).
                 [F] Using mipped cutout format for window multi-layer model
                     (issue #19, thanks rixmswey for reporting and details).
                 [M] Recipe tuning, added standalone recipe for all mod blocks.
                 [M] In-game CTRL-SHIFT tooltip documentation updated.
                 [M] Panzer glass block: Ambient occlusion and light opacity tuned.
                 [M] Stairs: Light opacity tuned.
                 [A] Tooltip documentation added for mod stairs.
                 [E] Horizontal steel double-T support beam (config:experimental).

    - v1.0.4-b3  [A] Added thin (4x4x16) and thick (6x6x16) steel hollow poles.
                 [A] Added support head/foot components for thin and thick steel poles.

    - v1.0.4-b2  [A] Added position dependent texture variation to clinker wall,
                     slag brick wall and rebar concrete wall.

    - v1.0.4-b1  [A] Crafting table: JEI integration for recipe placement added.
                 [A] Crafting table: History re-fab added, allowing to quickly select
                     and re-craft recent recipes. Selection with arrow buttons,
                     ingredient placement by clicking the result slot. Automatic
                     item distribution on shift-click. Quick-move buttons.
                 [F] Crafting table textures modified to prevent optifine glitches
                     on the edges of the legs.

                 -------------------------------------------------------------------
    - v1.0.3     [R] Release based on v1.0.3-b5. Release-to-release changes:
                     * Small laboratory furnace added.
                     * Extensive config options for mod packing and tuning added.
                     * Rendering issues fixes (window bleeding, optifine).
                     * Steel framed window added.
                     * Treated wood pole "end pieces" added (two support variants).
                     * Sitting on treated wood stool added including mobs (but not
                       villagers, as these are obviously very upright people).
                     * Lang ru_ru added (github contribution from Yaroslavik).
                     * Creative tab logo changed to mod logo.
                     * Table/crafting table bounding boxes refined.
                     * Standalone "escape" recipes added if IE is not installed.
                 -------------------------------------------------------------------

    - v1.0.3-b5  [F] Fixed typo in en-en lang file.
                 [F] Fixed IE concrete texture missing bailout in log if IE is not installed.
                 [F] Using forge multi-layer models for windows to circumvent glitches.
                 [M] Changed creative tab logo to the mod logo.
                 [A] Added alternative recipes for crafting table and furnace if main
                     IE ingredients are missing (for "stand-alone" mod usage).

    - v1.0.3-b4  [A] Lab furnace supports electrical speedup when a IE external
                     is placed in one of the two auxiliary slots.
                 [F] Fixed window rendering issue (issue #15, thanks to ILLOMIURGE).
                 [M] Updated ru_ru lang file (Yaroslavik).

    - v1.0.3-b3  [A] Added sitting on treated wood stool, Zombies included.
                 [A] Added steel framed window.
                 [A] Added treated wood pole support head/foot and heavy duty support.
                 [A] Added language Russian language support, thanks to yaroslav4167.
                 [A] Added config for furnace smelting speed (percent of vanilla furnace).
                 [A] Added config for furnace fuel efficiency (in percent, ref is vanilla).
                 [F] Treated pole model changed to circumvent potential texture bleeding.
                 [M] Treated wood table bounding box aligned with the legs.
                 [M] Treated wood crafting table bounding box aligned with the legs.
                 [M] Treated wood window can be vertically placed for rooflights.

    - v1.0.3-b2  [A] Added config options for selective feature opt-outs (soft opt-out).
                 [A] Added config skip registration of opt-out features (hard opt-out).
                 [A] Added config to disable all internal recipes (for packs).
                 [A] Added JEI API adapter for soft opt-outs.
                 [A] Added lab furnace recipe override config to smelt ores to nuggets
                    that would normally be smelted into ingots. Can be changed on-the-fly.

    - v1.0.3-b1  [A] Added small laboratory furnace.
                 [M] Panzer glass opacity/light level set explicitly 0.

                 -------------------------------------------------------------------
    - v1.0.2     [R] Release based on v1.0.2-b3
                     * Fixes: Spawning.
                     * Crafting table: Shift-click.
                     * Ladders: Faster climbing/descending.
                     * Concrete: Rebar tiles, tile stairs.
                     * Treated wood: window, windowsill.
                     * Slag brick: wall.
                     * Panzer glass: added.
                     * Recipes: Adaptions, added decompositions.
                 -------------------------------------------------------------------

    - v1.0.2-b3  [A] Added slag brick wall.
                 [A] Added wall decomposition recipes.
                 [A] Added treated wood window.
                 [M] Climbing/descending mod ladders is faster when
                     looking up or down and not sneaking.
                 [M] Panzer glass material definition changed.
                 [M] Explicitly preventing spawning in and on "non-full"
                     blocks of the mod.

    - v1.0.2-b2  [A] Added rebar concrete tile stairs.
                 [A] Added treated wood window sill.
                 [A] Added decomposition recipes for stairs and tiles.
                 [M] Changed stair recipe yield quantity from 9 to 6.

    - v1.0.2-b1  [A] Added rebar concrete tile.
                 [A] Added panzer glass (explosion-resistant reinforced glass).
                 [M] Treated wood crafting table supports shift-click to transfer
                     stacks between player inventory and crafting table storage
                     (thanks majijn for the hint).

                 -------------------------------------------------------------------
    - v1.0.1     [R] Release based on v1.0.1-b4
                     * Treated wood crafting table
                     * Clinker brick wall
                     * Treated wood stool
                     * Inset spot light
                     * Recipe fixes
                     * Logo updated
                 -------------------------------------------------------------------

    - v1.0.1-b4  [M] Crafting table keeps inventory and has eight storage slots.
                 [M] Adapted inset light strength and harvest tool.
                 [M] Crafting table recipe adapted.

    - v1.0.1-b3  [A] Added inset light (glowstone-metal, light level like torch,
                     can be used as floor/ceiling/wall light).
                 [M] Crafting table model updated (issue #7, thanks majijn).
                 [M] Logo image updated.

    - v1.0.1-b2  [A] Added treated wood crafting table.
                 [A] Added treated wood stool.
                 [F] Fixed ladder bounding boxes to allow climbing connected trap doors
                     (issue #6, thanks to Forgilageord).
                 [M] Improved wall-block connections (wall elements only connect to other
                     walls or gates, as well as to solid blocks if these blocks are in
                     a straight line with at least two wall elements).
                 [M] Decor walls are defined "solid" on top, so that e.g. torches and
                     redstone tracks can be placed on them.

    - v1.0.1-b1  [F] Fixed missing condition for ie:stone_deco in recipe constants.
                 [A] Added clinker brick wall.

                 -------------------------------------------------------------------
    - v1.0.0     [R] Release based on v1.0.0-b4
                 -------------------------------------------------------------------

    - v1.0.0-b4  [F] Fixed vanished recipe for the rebar concrete wall.
                 [A] Concrete wall, material: IE concrete.

    - v1.0.0-b3  [A] Textures of rebar concrete and treated wood table improved.
                 [A] Added rebar concrete wall.

    - v1.0.0-b2  [A] Added rebar concrete (steel reinforced, expensive, creeper-proof).

    - v1.0.0-b1  [A] Initial structure.
                 [A] Added clinker bricks and clinker brick stairs.
                 [A] Added slag bricks and slag brick stairs.
                 [A] Added metal rung ladder.
                 [A] Added staggered metal steps ladder.
                 [A] Added treated wood ladder.
                 [A] Added treated wood pole.
                 [A] Added treated wood table.

----

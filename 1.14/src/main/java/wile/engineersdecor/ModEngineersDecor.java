package wile.engineersdecor;

import wile.engineersdecor.detail.ModConfig;
import wile.engineersdecor.detail.RecipeCondModSpecific;
import wile.engineersdecor.detail.Networking;
import wile.engineersdecor.blocks.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;


@Mod("engineersdecor")
public class ModEngineersDecor
{
  public static final String MODID = "engineersdecor";
  public static final int VERSION_DATAFIXER = 0;
  private static final Logger LOGGER = LogManager.getLogger();

  public ModEngineersDecor()
  {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSendImc);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRecvImc);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_CONFIG_SPEC);
    ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, ModConfig.CLIENT_CONFIG_SPEC);
    MinecraftForge.EVENT_BUS.register(this);
  }

  public static final Logger logger() { return LOGGER; }

  //
  // Events
  //

  private void onSetup(final FMLCommonSetupEvent event)
  {
    LOGGER.info("Registering recipe condition processor ...");
    CraftingHelper.register(new ResourceLocation(MODID, "grc"), new RecipeCondModSpecific());
    Networking.init();
  }

  private void onClientSetup(final FMLClientSetupEvent event)
  { ModContent.registerContainerGuis(event); }

  private void onSendImc(final InterModEnqueueEvent event)
  {}

  private void onRecvImc(final InterModProcessEvent event)
  {}

  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event)
  {}

  @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents
  {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event)
    { ModContent.registerBlocks(event); }

    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event)
    { ModContent.registerItemBlocks(event); }

    @SubscribeEvent
    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event)
    { ModContent.registerTileEntities(event); }

    @SubscribeEvent
    public static void onRegisterEntityTypes(final RegistryEvent.Register<EntityType<?>> event)
    { ModContent.registerEntities(event); }

    @SubscribeEvent
    public static void onRegisterContainerTypes(final RegistryEvent.Register<ContainerType<?>> event)
    { ModContent.registerContainers(event); }
  }

  //
  // Sided proxy functionality (skel)
  //
  public static ISidedProxy proxy = DistExecutor.runForDist(()->ClientProxy::new, ()->ServerProxy::new);
  public interface ISidedProxy
  {
    default @Nullable PlayerEntity getPlayerClientSide() { return null; }
    default @Nullable World getWorldClientSide() { return null; }
    default @Nullable Minecraft mc() { return null; }
  }
  public static final class ClientProxy implements ISidedProxy
  {
    public @Nullable PlayerEntity getPlayerClientSide() { return Minecraft.getInstance().player; }
    public @Nullable World getWorldClientSide() { return Minecraft.getInstance().world; }
    public @Nullable Minecraft mc() { return Minecraft.getInstance(); }
  }
  public static final class ServerProxy implements ISidedProxy
  {
    public @Nullable PlayerEntity getPlayerClientSide() { return null; }
    public @Nullable World getWorldClientSide() { return null; }
    public @Nullable Minecraft mc() { return null; }
  }

  //
  // Item group / creative tab
  //
  public static final ItemGroup ITEMGROUP = (new ItemGroup("tab" + MODID) {
    @OnlyIn(Dist.CLIENT)
    public ItemStack createIcon()
    { return new ItemStack(ModContent.SIGN_MODLOGO); }
  });

  //
  // Player update event
  //
  @SubscribeEvent
  public void onPlayerEvent(final LivingEvent.LivingUpdateEvent event)
  {
    if(!(event.getEntity() instanceof PlayerEntity)) return;
    final PlayerEntity player = (PlayerEntity)event.getEntity();
    if(player.world == null) return;
    if(player.isOnLadder()) BlockDecorLadder.onPlayerUpdateEvent(player);
  }

}
